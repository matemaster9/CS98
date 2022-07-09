package cs.matemaster.common.webcore.httpclient;

import cs.matemaster.common.vo.HttpResponseWrapperVO;
import cs.matemaster.common.webcore.BizUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

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
        CloseableHttpClient httpClient = HttpClientFactory.getHttpClient(connectionRequestTimeout, connectionTimeout, socketTimeout);
        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            long end = System.currentTimeMillis();
            // 执行get请求耗时
            httpResponseWrapper.setTimeConsuming(end - start);

            int httpStatus = response.getStatusLine().getStatusCode();

            // http响应成功
            if (httpStatus == HttpStatus.SC_OK
                    || httpStatus == HttpStatus.SC_CREATED
                    || httpStatus == HttpStatus.SC_NO_CONTENT) {
                String result = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                httpResponseWrapper.setData(result);
            } else {

            }
        } catch (IOException e) {
            httpGet.abort();
        }

        return httpResponseWrapper;
    }

}
