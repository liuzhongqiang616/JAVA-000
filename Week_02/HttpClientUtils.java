import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientUtils {

    public static String HttpGet(String url) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet("http://localhost:8801");

            CloseableHttpResponse response = httpclient.execute(httpGet);

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String data = EntityUtils.toString(entity);
                return data;
            }
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
