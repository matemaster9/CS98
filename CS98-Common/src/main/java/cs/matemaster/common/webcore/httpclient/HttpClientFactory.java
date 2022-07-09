package cs.matemaster.common.webcore.httpclient;

import cs.matemaster.common.webcore.BizUtil;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

/**
 * @author MateMaster
 * @since 2022/7/9
 */
public class HttpClientFactory {

    private HttpClientFactory() {
    }

    public static CloseableHttpClient getHttpClient(int connectionRequestTimeout,
                                                    int connectionTimeout,
                                                    int socketTimeout) {

        return HttpClients.custom()
                .setDefaultRequestConfig(getRequestConfig(connectionRequestTimeout, connectionTimeout, socketTimeout))
                .setRetryHandler(getRetryHandler())
                .setConnectionManager(getConnectionManager())
                .build();

    }

    private static RequestConfig getRequestConfig(int connectionRequestTimeout,
                                                  int connectionTimeout,
                                                  int socketTimeout) {
        return RequestConfig.custom()
                .setConnectionRequestTimeout(connectionRequestTimeout)
                .setConnectTimeout(connectionTimeout)
                .setSocketTimeout(socketTimeout)
                .build();
    }

    private static HttpRequestRetryHandler getRetryHandler() {
        return (exception, executionCount, context) -> {

            // 超过重试次数、放弃
            if (executionCount >= HttpClientConfig.RETRY_EXECUTION_COUNT) {
                return false;
            }
            // 服务器丢失连接、重试
            if (exception instanceof NoHttpResponseException) {
                return true;
            }
            // SSL握手异常、放弃
            if (exception instanceof SSLHandshakeException) {
                return false;
            }
            // 连接超时被拒、放弃
            if (exception instanceof ConnectTimeoutException) {
                return false;
            }
            // 超时、重试
            if (exception instanceof InterruptedIOException) {
                return true;
            }
            // 目标服务器不可达、放弃
            if (exception instanceof UnknownHostException) {
                return false;
            }
            // SSL异常、放弃
            if (exception instanceof SSLException) {
                return false;
            }
            HttpClientContext httpClientContext = HttpClientContext.adapt(context);
            HttpRequest request = httpClientContext.getRequest();

            // 请求幂等，继续重试
            return BizUtil.isFalse(request instanceof HttpEntityEnclosingRequest);
        };
    }

    private static PoolingHttpClientConnectionManager getConnectionManager() {

        PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager(3, TimeUnit.MINUTES);

        // 最大连接数、单个连接路由数量、关闭空闲连接时间
        manager.setMaxTotal(200);
        manager.setDefaultMaxPerRoute(50);
        manager.closeIdleConnections(30, TimeUnit.MINUTES);
        manager.closeExpiredConnections();

        return manager;
    }

}
