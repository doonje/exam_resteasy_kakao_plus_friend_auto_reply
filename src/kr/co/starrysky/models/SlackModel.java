package kr.co.starrysky.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

public final class SlackModel {
    private static final Logger log = Logger.getLogger(SlackModel.class.getName());

    // 슬랙 웹훅 URL 입력.
    public final String URL_SLACK_WEB_HOOK = "";

    public void sendNotification(String text) {
        if(URL_SLACK_WEB_HOOK.isEmpty()){
            return ;
        }

        try {
            StringBuilder textObj = new StringBuilder();
            textObj.append("payload=");
            textObj.append("{");
            textObj.append("\"text\":");
            textObj.append("\"" + text + "\"");
            textObj.append("}");


            URL url = new URL(URL_SLACK_WEB_HOOK);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.getOutputStream().write(textObj.toString().getBytes("UTF-8"));
            connection.connect();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

        } catch (MalformedURLException e) {
            log.warning("sendNotification MalformedURLException - " + e.getLocalizedMessage());
        } catch (IOException e) {
            log.warning("sendNotification IOException - " + e.getLocalizedMessage());
        }
    }
}
