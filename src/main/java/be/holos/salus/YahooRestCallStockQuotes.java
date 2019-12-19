package be.holos.salus;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Dieter D'haeyere on 06/02/17.
 */
public class YahooRestCallStockQuotes {

    public static void main(final String[] args) {
        try {

            final DefaultHttpClient httpClient = new DefaultHttpClient();
            final HttpGet getRequest = new HttpGet(
                    "http://finance.yahoo.com/d/quotes.csv?s=AAPL+GOOG+ORC&f=snpdr1re");
            getRequest.addHeader("accept", "application/csv");

            final HttpResponse response = httpClient.execute(getRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }

            final BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            httpClient.getConnectionManager().shutdown();
        } catch (final ClientProtocolException e) {

            e.printStackTrace();
        } catch (final IOException e) {

            e.printStackTrace();
        }
    }
}
