###To run the sample http2:

```
wget http://repo.maven.apache.org/maven2/org/mortbay/jetty/alpn/jetty-alpn-agent/2.0.6/jetty-alpn-agent-2.0.6.jar

 mvn clean install -DskipTests && java -javaagent:jetty-alpn-agent-2.0.6.jar -jar target/jetty-http2-springboot-0.0.1-SNAPSHOT.jar
```

The go to https://localhost:8443 (note it's a self certificate so accept that :-) )