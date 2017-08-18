package org.mortbay.jetty.http2.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.http2.client.HTTP2Client;
import org.eclipse.jetty.http2.client.http.HttpClientTransportOverHTTP2;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith( SpringRunner.class )
@SpringBootTest( webEnvironment = RANDOM_PORT )
@TestPropertySource( locations = "classpath:test-application.properties" )
public class SimpleApplicationTests
{
    @Value( "${local.server.port}" )
    protected int port;

    @Test
    public void simple_get()
        throws Exception
    {
        HttpClient httpClient = new HttpClient( new HttpClientTransportOverHTTP2( new HTTP2Client() ), //
                                                new SslContextFactory( true ) );
        httpClient.start();

        String json = httpClient.newRequest( "https://localhost:" + port + "/beer?name=foo" ) //
            .send() //
            .getContentAsString();

        System.out.println( "json:" + json );

        Beer beer = new ObjectMapper().readValue( json, Beer.class );
        Assert.assertEquals( "foo", beer.getName() );

        httpClient.stop();
    }

}

