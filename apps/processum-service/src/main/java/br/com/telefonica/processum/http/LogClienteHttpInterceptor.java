package br.com.telefonica.processum.http;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Ivan Queiroz <ivanqueiroz@gmail.com>
 */
public class LogClienteHttpInterceptor implements Interceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteHttp.class);

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        long t1 = System.nanoTime();
        LOGGER.info(String.format("Enviando request %s em %s%n%s", request.url(), chain.connection(), request.headers()));
        Response response = chain.proceed(request);

        long t2 = System.nanoTime();
        LOGGER.info(String.format("Recebendo response de %s em %.1fms%n%s",
                response.request().url(), (t2 - t1) / 1e6d, response.headers()));
        return response;
    }
}