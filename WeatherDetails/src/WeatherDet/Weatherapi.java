package WeatherDet;


import org.json.JSONObject;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Weatherapi
{
    public static void main(final String[] args) {
        try {
            final String url = "http://api.openweathermap.org/data/2.5/weather?q=Chennai&appid=8fb6f04a5563d2b2c1e8bd656370f934";
            final URL obj = new URL(url);
            final HttpURLConnection con = (HttpURLConnection)obj.openConnection();
            final int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL :" + url);
            System.out.println("ResponseCode:" + responseCode);
            final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            final StringBuffer response = new StringBuffer();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            final JSONObject myresponse = new JSONObject(response.toString());
            final JSONObject b = new JSONObject(myresponse.getJSONObject("sys").toString());
            System.out.println("Country" + b.getString("country"));
            System.out.println("Sunrise- " + b.getInt("sunrise"));
            System.out.println("Sunset- " + b.getInt("sunset"));
            final JSONObject a = new JSONObject(myresponse.getJSONObject("coord").toString());
            System.out.println("coord- " + a);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}

