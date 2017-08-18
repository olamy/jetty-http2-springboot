### To run the sample http2:

You need to build the branch called feature/jetty_http2 from this repository https://github.com/olamy/spring-boot

```
wget http://repo.maven.apache.org/maven2/org/mortbay/jetty/alpn/jetty-alpn-agent/2.0.6/jetty-alpn-agent-2.0.6.jar

 mvn clean install -DskipTests && java -javaagent:jetty-alpn-agent-2.0.6.jar -jar target/jetty-http2-springboot-0.0.1-SNAPSHOT.jar
```

The go to https://localhost:8443 (note it's a self certificate so accept that :-) )

Or curl (with http2 available)

```
curl --http2 -k  https://localhost:8443/beer
```

Or you can have a look at the unit test.