package service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import entity.Param;
import entity.User;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import ui.MainPanel;
import java.io.IOException;

public class ConnectNetwork {
    public static boolean loginStatus = false;

    public static String getLoginPath() throws IOException {
        String href = null;

        try {
            Document document = Jsoup.connect("http://192.168.2.135").get();
            if (document.title().equals("登录成功")) {
                return "logged in";
            } else {
                href = document.head().data();
                href = href.split("\\?")[1];
                href = href.split("'")[0];
                return href;
            }
        } catch (IOException var2) {
            throw var2;
        }
    }

    public static void login() throws IOException {
        String url = "http://192.168.2.135/eportal/InterFace.do?method=login";
        String href = "";

        try {
            href = getLoginPath();
        } catch (IOException var14) {
            throw var14;
        }

        if (href.equals("logged in")) {
            loginStatus = true;
        } else {
            Param param = new Param(User.number, User.password, href);

            try {
                URIBuilder builder = new URIBuilder(url);
                builder.addParameter("method", "login");
                builder.addParameter("userId", param.getUserId());
                builder.addParameter("password", param.getPassword());
                builder.addParameter("service", param.getService());
                builder.addParameter("queryString", param.getQueryString());
                builder.addParameter("operatorPwd", param.getOperatorPwd());
                builder.addParameter("operatorUserId", param.getOperatorUserId());
                builder.addParameter("validcode", param.getValidcode());
                builder.addParameter("passwordEncrypt", param.getPasswordEncrypt());
                HttpPost httpPost = new HttpPost(builder.build());
                CloseableHttpClient httpClient = HttpClientBuilder.create().build();
                CloseableHttpResponse response = null;

                try {
                    response = httpClient.execute(httpPost);
                    HttpEntity responseEntity = response.getEntity();
                    if (responseEntity != null) {
                        JSONObject jsonObject = JSON.parseObject(EntityUtils.toString(responseEntity, "UTF-8"));
                        String connectloginStatus = (String)jsonObject.get("result");
                        if (connectloginStatus.equals("success")) {
                            loginStatus = true;
                        } else {
                            if (!jsonObject.get("message").equals("")) {
                                MainPanel.text.append(jsonObject.get("message").toString());
                                return;
                            }
                        }
                    }
                } catch (Exception var12) {
                    var12.printStackTrace();
                }
            } catch (Exception var13) {
                var13.printStackTrace();
            }

        }
    }
}
