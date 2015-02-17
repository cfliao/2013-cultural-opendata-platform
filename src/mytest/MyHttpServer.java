package mytest;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class MyHttpServer
{

    public static void main(String[] args) throws IOException
    {
        InetSocketAddress addr = new InetSocketAddress(8080);
        HttpServer server = HttpServer.create(addr, 0);
        server.createContext("/main", new HttpHandler() {

            @Override
            public void handle(HttpExchange e) throws IOException
            {
                e.sendResponseHeaders(200, 0);
                OutputStream body = e.getResponseBody();
                body.write("Hello, World!".getBytes());
                body.close();
            }

        });
        server.start();

    }
}
