package com.sudao.cloud.component.user.manager.platform.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.*;
import java.net.URLEncoder;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/9.
 * httpClient
 */
public class HttpClientUtil {

    private static int socketTimeout = 60000;
    private static int connectTimeout = 60000;

    private static final String APPLICATION_JSON = "application/json";
    private static final String CONTENT_TYPE_TEXT_JSON = "text/json";

    private static HttpClientBuilder buildHttpClient(String url) throws Exception {
        HttpClientBuilder httpBuilder =  null;
        if (StringUtils.startsWith(url, "https")) {
            SSLContext sslcontext = SSLContext.getInstance("TLSv1.2");
            sslcontext.init(null, new TrustManager[] { new X509TrustManager() {
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[] {};
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

                }

                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

                }
            } }, new java.security.SecureRandom());
            SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslcontext,
                    new String[] { "TLSv1", "SSLv3" }, null, new HostnameVerifier() {
                @Override
                public boolean verify(String urlHostName, SSLSession session) {
                    return true;
                }
            });
            Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.getSocketFactory())
                    .register("https", sslConnectionSocketFactory).build();
            PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(registry);
            httpBuilder = HttpClientBuilder.create().setConnectionManager(cm);
        } else {
            httpBuilder = HttpClientBuilder.create();
        }
        return httpBuilder;
    }

    /***
     * post 请求
     * @param url
     * @param reqMap
     * @return
     */
    public static String post(String url, Map<String,String> reqMap, Map<String,String> headerMap, String body)  {
        String result = "";
        HttpPost httpPost = new HttpPost(url);
        RequestConfig config = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();
        httpPost.setConfig(config);
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        try {
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            if (headerMap != null) { //请求头
                for (Map.Entry<String, String> param : headerMap.entrySet()) {
                    httpPost.addHeader(param.getKey(), param.getValue());
                }
            }
            if (reqMap != null) {
                for (Map.Entry<String, String> param : reqMap.entrySet()) {//请求参数
                    String key = param.getKey();
                    String value = param.getValue();
                    BasicNameValuePair basicPair = new BasicNameValuePair(key, null != value?value : "");
                    list.add(basicPair);
                }
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "UTF-8");
                httpPost.setEntity(entity);
            }
            if (body != null) {
                httpPost.setEntity(new StringEntity(body, "UTF-8"));
            }
            httpClient = buildHttpClient(url).build();
            httpResponse = httpClient.execute(httpPost);
            if(null != httpResponse) {
                HttpEntity resEntity = httpResponse.getEntity();
                if(null != resEntity){
                    result = EntityUtils.toString(resEntity,"UTF-8");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != httpResponse) {
                try {
                    httpResponse.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (null != httpPost) {
                try {
                    httpPost.releaseConnection();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (null != httpClient) {
                try {
                    httpClient.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public static String postWithJSON(String url, String json) {

        String result = "";
        HttpPost httpPost = null;
        RequestConfig config = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();
        DefaultHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;

        // 将JSON进行UTF-8编码,以便传输中文
        String encoderJson = null;
        try {
             encoderJson = URLEncoder.encode(json, HTTP.UTF_8);

             httpClient = new DefaultHttpClient();
             httpPost = new HttpPost(url);
             httpPost.setConfig(config);
             httpPost.addHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON);

             StringEntity se = new StringEntity(encoderJson);
             se.setContentType(CONTENT_TYPE_TEXT_JSON);
             se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON));
             httpPost.setEntity(se);
             httpResponse =  httpClient.execute(httpPost);
            if (null != httpResponse) {
                HttpEntity resEntity = httpResponse.getEntity();
                if (null != resEntity) {
                    result = EntityUtils.toString(resEntity, "UTF-8");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  result;
    }

    /**
     * get 请求
     * @param url
     * @param reqMap
     * @param headerMap
     * @return
     */
    public static String get(String url, Map<String,String> reqMap, Map<String,String> headerMap) {
        String result = "";
        HttpGet httpGet = new HttpGet(getUrl(url, reqMap));
        RequestConfig config = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();
        httpGet.setConfig(config);
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        try {
            if (headerMap != null) { //请求头
                for (Map.Entry<String, String> param : headerMap.entrySet()) {
                    httpGet.addHeader(param.getKey(), param.getValue());
                }
            }
            httpClient = buildHttpClient(url).build();
            httpResponse = httpClient.execute(httpGet);
            if(null != httpResponse) {
                HttpEntity resEntity = httpResponse.getEntity();
                if(null != resEntity){
                    result = EntityUtils.toString(resEntity,"UTF-8");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != httpResponse) {
                try {
                    httpResponse.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (null != httpGet) {
                try {
                    httpGet.releaseConnection();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (null != httpClient) {
                try {
                    httpClient.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    private static String getUrl(String url, Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(url);
        if (map != null && map.size() > 0) {
            stringBuilder.append("?");
            int i = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (i == 0) {
                    stringBuilder.append(entry.getKey()).append("=").append(entry.getValue());
                } else {
                    stringBuilder.append("&").append(entry.getKey()).append("=").append(entry.getValue());
                }
                i++;
            }
        }
        return stringBuilder.toString();
    }

}
