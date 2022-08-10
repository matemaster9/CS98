package cs.matemaster.web.common.webcore.httpclient;

import cs.matemaster.web.common.vo.HttpResponseWrapperVO;
import cs.matemaster.web.common.webcore.BizUtil;
import cs.matemaster.web.common.webcore.JsonUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.web.util.UriUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author MateMaster
 * @since 2022/7/9
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HttpClientUtil {

    public static HttpResponseWrapperVO doGet(String url) {
        return doSendGet(url, null,
                HttpClientConfig.CONNECTION_REQUEST_TIMEOUT,
                HttpClientConfig.CONNECTION_TIMEOUT,
                HttpClientConfig.SOCKET_TIMEOUT);
    }

    public static HttpResponseWrapperVO doGet(String url,
                                              Map<String, String> headerParams) {
        return doSendGet(url, headerParams,
                HttpClientConfig.CONNECTION_REQUEST_TIMEOUT,
                HttpClientConfig.CONNECTION_TIMEOUT,
                HttpClientConfig.SOCKET_TIMEOUT);
    }

    public static HttpResponseWrapperVO doGet(String url,
                                              Map<String, String> headerParams,
                                              int connectionRequestTimeout,
                                              int connectionTimeout,
                                              int socketTimeout) {
        return doSendGet(url, headerParams, connectionRequestTimeout, connectionTimeout, socketTimeout);
    }

    public static HttpResponseWrapperVO doPost(String url,
                                               Object parameter) {
        return doPost(url, parameter, HttpClientConfig.CONTENT_TYPE_APPLICATION_JSON);
    }

    public static HttpResponseWrapperVO doPost(String url,
                                               Object parameter,
                                               String contentType) {
        return doPost(url, parameter, HttpClientConfig.CONNECTION_REQUEST_TIMEOUT, HttpClientConfig.CONNECTION_TIMEOUT, HttpClientConfig.SOCKET_TIMEOUT, contentType);
    }

    public static HttpResponseWrapperVO doPost(String url,
                                               Object parameter,
                                               int connectionRequestTimeout,
                                               int connectionTimeout,
                                               int socketTimeout,
                                               String contentType) {
        String parameters = JsonUtil.serialize(parameter);
        return doPost(url, parameters, connectionRequestTimeout, connectionTimeout, socketTimeout, contentType);
    }

    public static HttpResponseWrapperVO doPost(String url,
                                               Object parameter,
                                               Map<String, String> headerParams) {
        return doPost(url, parameter, HttpClientConfig.CONTENT_TYPE_APPLICATION_JSON, headerParams);
    }

    public static HttpResponseWrapperVO doPost(String url,
                                               Object parameter,
                                               String contentType,
                                               Map<String, String> headerParams) {
        return doPost(url, parameter, HttpClientConfig.CONNECTION_REQUEST_TIMEOUT, HttpClientConfig.CONNECTION_TIMEOUT, HttpClientConfig.SOCKET_TIMEOUT, contentType, headerParams);
    }

    public static HttpResponseWrapperVO doPost(String url,
                                               Object parameter,
                                               int connectionRequestTimeout,
                                               int connectionTimeout,
                                               int socketTimeout,
                                               String contentType,
                                               Map<String, String> headerParams) {
        String parameters = JsonUtil.serialize(parameter);
        return doPost(url, parameters, connectionRequestTimeout, connectionTimeout, socketTimeout, contentType, headerParams);
    }

    public static HttpResponseWrapperVO doPost(String url,
                                               String parameter,
                                               int connectionRequestTimeout,
                                               int connectionTimeout,
                                               int socketTimeout,
                                               String contentType) {
        return doSendPost(url, parameter, connectionRequestTimeout, connectionTimeout, socketTimeout, contentType, null);
    }

    public static HttpResponseWrapperVO doPost(String url,
                                               String parameter,
                                               int connectionRequestTimeout,
                                               int connectionTimeout,
                                               int socketTimeout,
                                               String contentType,
                                               Map<String, String> headerParams) {
        return doSendPost(url, parameter, connectionRequestTimeout, connectionTimeout, socketTimeout, contentType, headerParams);
    }

    /**
     * Get请求
     *
     * @param url                      请求地址url
     * @param headerParams             请求头参数
     * @param connectionRequestTimeout 获取连接耗时
     * @param connectionTimeout        请求连接耗时
     * @param socketTimeout            获取响应数据耗时
     * @return
     */
    private static HttpResponseWrapperVO doSendGet(String url,
                                                   Map<String, String> headerParams,
                                                   int connectionRequestTimeout,
                                                   int connectionTimeout,
                                                   int socketTimeout) {
        HttpResponseWrapperVO httpResponseWrapper = new HttpResponseWrapperVO();

        URL requestUrl;
        try {
            requestUrl = new URL(url);
        } catch (MalformedURLException e) {
            return httpResponseWrapper;
        }

        HttpGet httpGet = new HttpGet(requestUrl.toString());

        // 设置请求参数
        if (BizUtil.isNotEmptyMap(headerParams)) {
            headerParams.forEach(httpGet::setHeader);
        }

        long start = System.currentTimeMillis();
        try {
            CloseableHttpClient httpClient = HttpClientFactory.getHttpClient(connectionRequestTimeout, connectionTimeout, socketTimeout);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            long end = System.currentTimeMillis();
            // 执行get请求耗时
            httpResponseWrapper.setTimeConsuming(end - start);

            int httpStatus = response.getStatusLine().getStatusCode();
            httpResponseWrapper.setHttpStatus(httpStatus);
            // http响应成功
            if (BizUtil.isTrue(checkHttpRequestSuccess(httpStatus))) {
                String result = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                httpResponseWrapper.setData(result);
            } else {
                httpResponseWrapper.setData(null);
            }
        } catch (IOException e) {
            httpGet.abort();
        } catch (Exception e) {
            httpGet.abort();
        }

        return httpResponseWrapper;
    }

    /**
     * Post请求
     *
     * @param url                      请求地址url
     * @param parameter                请求参数
     * @param connectionRequestTimeout 获取连接耗时
     * @param connectionTimeout        请求连接耗时
     * @param socketTimeout            获取响应数据耗时
     * @param contentType              内容类型
     * @param headerParams             请求头参数
     * @return
     */
    private static HttpResponseWrapperVO doSendPost(String url,
                                                    String parameter,
                                                    int connectionRequestTimeout,
                                                    int connectionTimeout,
                                                    int socketTimeout,
                                                    String contentType,
                                                    Map<String, String> headerParams) {

        HttpResponseWrapperVO httpResponseWrapper = new HttpResponseWrapperVO();

        URL requestUrl;
        try {
            requestUrl = new URL(url);
        } catch (MalformedURLException e) {
            return httpResponseWrapper;
        }

        HttpPost httpPost = new HttpPost(requestUrl.toString());

        httpPost.setHeader(HTTP.CONTENT_TYPE, contentType);

        if (BizUtil.isNotEmptyMap(headerParams)) {
            headerParams.forEach(httpPost::setHeader);
        }

        String parameters = null;
        if (BizUtil.isTrue(needUrlEncode(contentType))) {
            parameters = UriUtils.encode(contentType, StandardCharsets.UTF_8);
        } else if (StringUtils.equals(HttpClientConfig.CONTENT_TYPE_APPLICATION_JSON, contentType)) {
            parameters = parameter;
        }
        if (StringUtils.isNotBlank(parameters)) {
            httpPost.setEntity(new StringEntity(parameter, StandardCharsets.UTF_8));
        }

        long start = System.currentTimeMillis();
        try {
            CloseableHttpClient httpClient = HttpClientFactory.getHttpClient(connectionRequestTimeout, connectionTimeout, socketTimeout);
            CloseableHttpResponse response = httpClient.execute(httpPost);
            long end = System.currentTimeMillis();

            httpResponseWrapper.setTimeConsuming(end - start);
            int httpStatus = response.getStatusLine().getStatusCode();
            httpResponseWrapper.setHttpStatus(httpStatus);
            if (BizUtil.isTrue(checkHttpRequestSuccess(httpStatus))) {
                String result = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                httpResponseWrapper.setData(result);
            } else {
                httpResponseWrapper.setData(null);
            }
        } catch (IOException e) {
            httpPost.abort();
        } catch (Exception e) {
            httpPost.abort();
        }

        return httpResponseWrapper;
    }

    private static boolean checkHttpRequestSuccess(int httpStatus) {
        return httpStatus == HttpStatus.SC_OK || httpStatus == HttpStatus.SC_CREATED || httpStatus == HttpStatus.SC_NO_CONTENT;
    }

    private static boolean needUrlEncode(String contentType) {
        return HttpClientConfig.CONTENT_TYPE_URL_ENCODED.equals(contentType) || HttpClientConfig.CONTENT_TYPE_TEXT_PLAIN.equals(contentType);
    }

}
