package com.kevin.mellow.http;

import android.view.View;

import com.kevin.mellow.R;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/1/5.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class HttpStatusCode {

    private static final int UNAUTHORIZED = 401;
    private static final int FORBIDDEN = 403;
    private static final int NOT_FOUND = 404;
    private static final int REQUEST_TIMEOUT = 408;
    private static final int INTERNAL_SERVER_ERROR = 500;
    private static final int BAD_GATEWAY = 502;
    private static final int SERVICE_UNAVAILABLE = 503;
    private static final int GATEWAY_TIMEOUT = 504;
    /***自定义编码****/
    private static final int CONNECT_EXCEPTION = 1001;
    private static final int INTERRUPTED_IO_EXCEPTION = 1002;
    private static final int PARSE_CEPTION = 1003;
    private static final int UNKNOW_ERROR = 1004;

    public static int getErrorDesResId(int statusCode) {
        int resId = View.NO_ID;
        switch (statusCode) {
            case UNAUTHORIZED:
                resId = R.string.http_error_unauthorized;
                break;
            case FORBIDDEN:
                resId = R.string.http_error_forbidden;
                break;
            case NOT_FOUND:
                resId = R.string.http_error_not_found;
                break;
            case REQUEST_TIMEOUT:
                resId = R.string.http_error_request_timeout;
                break;
            case INTERNAL_SERVER_ERROR:
                resId = R.string.http_error_internal_server_error;
                break;
            case BAD_GATEWAY:
                resId = R.string.http_error_bad_gateway;
                break;
            case SERVICE_UNAVAILABLE:
                resId = R.string.http_error_service_unavailable;
                break;
            case GATEWAY_TIMEOUT:
                resId = R.string.http_error_gateway_timeout;
                break;
            case CONNECT_EXCEPTION:
                resId = R.string.exception_connect;
                break;
            case INTERRUPTED_IO_EXCEPTION:
                resId = R.string.exception_interrupted_io;
                break;
            case PARSE_CEPTION:
                resId = R.string.exception_parse;
                break;
            case UNKNOW_ERROR:
                resId = R.string.http_error_unknown;
                break;
            default:
                resId = R.string.http_error_unknown;
                break;
        }
        return resId;
    }
}
