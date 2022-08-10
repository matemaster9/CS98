package cs.matemaster.web.common.webcore.httpclient;

/**
 * @author MateMaster
 * @since 2022/7/9
 */
public interface HttpClientConfig {
    String CONTENT_TYPE_URL_ENCODED = "application/x-www-form-urlencoded; charset=UTF-8";
    String CONTENT_TYPE_APPLICATION_JSON = "application/json; charset=UTF-8";
    String CONTENT_TYPE_TEXT_PLAIN = "text/plain; charset=UTF-8";
    int RETRY_EXECUTION_COUNT = 0;
    int CONNECTION_REQUEST_TIMEOUT = 1_000;
    int CONNECTION_TIMEOUT = 3_000;
    int SOCKET_TIMEOUT = 10_000;
}
