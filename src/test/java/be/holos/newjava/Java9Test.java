package be.holos.newjava;

import org.junit.Test;

/**
 * @author Dieter D'haeyere on 23/06/2019.
 */
public class Java9Test {

    @Test
    public void testNewHttpClient() {

        final HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/get"))
                .GET()
                .build();

        final HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandler.asString());
    }

    @Test
    public void testVar() {
        final var test = "abc";
    }
}
