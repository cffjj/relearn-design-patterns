package cn.caifujin.demo.design;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpClient {

    public static String doGet(String httpUrl){
        HttpURLConnection connection = null;
        InputStream is = null;
        BufferedReader br = null;
        String result = null;
        try {
            //创建远程url连接对象
            URL url = new URL(httpUrl);
            //通过远程url连接对象打开一个连接，强转成httpURLConnection类
            connection = (HttpURLConnection) url.openConnection();
            //设置连接方式：get
            connection.setRequestMethod("get");
            //设置连接主机服务器的超时时间：15000毫秒
            connection.setConnectTimeout(15000);
            //设置读取远程返回的数据时间：60000毫秒
            connection.setReadTimeout(60000);
            //发送请求
            connection.connect();
            //通过connection连接，获取输入流
            if (connection.getResponseCode() == 200){
                is = connection.getInputStream();
                //封装输入流is，并指定字符集
                br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
                StringBuilder sb = new StringBuilder();
                String temp = null;
                while ((temp = br.readLine()) != null){
                    sb.append(temp);
                    sb.append("\n");
                }
                result = sb.toString();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (null != br){
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (null != is){
                try {
                    is.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            assert connection != null;
            connection.disconnect();
        }
        return result;
    }
}
