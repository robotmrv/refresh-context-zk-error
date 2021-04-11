0. start zookeeper (you can use `docker-compose up`)
1. Start application 
2. refresh context via `curl http://localhost:8080/actuator/refresh -i -X POST`
Expected Result:  
   context refreshes without errors  
Actual result:
   error response with logs
```
2021-04-11 09:50:34.298 ERROR 37112 --- [nio-8080-exec-2] o.s.boot.SpringApplication               : Application run failed

java.lang.IllegalStateException: org.springframework.boot.context.properties.bind.Binder has not been registered
	at org.springframework.boot.DefaultBootstrapContext.lambda$get$1(DefaultBootstrapContext.java:88) ~[spring-boot-2.4.4.jar:2.4.4]
	at org.springframework.boot.DefaultBootstrapContext.getOrElseThrow(DefaultBootstrapContext.java:109) ~[spring-boot-2.4.4.jar:2.4.4]
	at org.springframework.boot.DefaultBootstrapContext.get(DefaultBootstrapContext.java:88) ~[spring-boot-2.4.4.jar:2.4.4]
	at org.springframework.cloud.zookeeper.CuratorFactory.lambda$registerCurator$1(CuratorFactory.java:89) ~[spring-cloud-zookeeper-core-3.0.2.jar:3.0.2]
	at org.springframework.boot.DefaultBootstrapContext.getInstance(DefaultBootstrapContext.java:119) ~[spring-boot-2.4.4.jar:2.4.4]
	at org.springframework.boot.DefaultBootstrapContext.getOrElseThrow(DefaultBootstrapContext.java:111) ~[spring-boot-2.4.4.jar:2.4.4]
	at org.springframework.boot.DefaultBootstrapContext.get(DefaultBootstrapContext.java:88) ~[spring-boot-2.4.4.jar:2.4.4]
	at org.springframework.cloud.zookeeper.CuratorFactory.lambda$registerCurator$3(CuratorFactory.java:94) ~[spring-cloud-zookeeper-core-3.0.2.jar:3.0.2]
	at org.springframework.boot.DefaultBootstrapContext.getInstance(DefaultBootstrapContext.java:119) ~[spring-boot-2.4.4.jar:2.4.4]
	at org.springframework.boot.DefaultBootstrapContext.getOrElseThrow(DefaultBootstrapContext.java:111) ~[spring-boot-2.4.4.jar:2.4.4]
	at org.springframework.boot.DefaultBootstrapContext.get(DefaultBootstrapContext.java:88) ~[spring-boot-2.4.4.jar:2.4.4]
	at org.springframework.cloud.zookeeper.CuratorFactory.lambda$registerCurator$4(CuratorFactory.java:98) ~[spring-cloud-zookeeper-core-3.0.2.jar:3.0.2]
	at org.springframework.context.event.SimpleApplicationEventMulticaster.doInvokeListener(SimpleApplicationEventMulticaster.java:176) ~[spring-context-5.3.5.jar:5.3.5]
	at org.springframework.context.event.SimpleApplicationEventMulticaster.invokeListener(SimpleApplicationEventMulticaster.java:169) ~[spring-context-5.3.5.jar:5.3.5]
	at org.springframework.context.event.SimpleApplicationEventMulticaster.multicastEvent(SimpleApplicationEventMulticaster.java:143) ~[spring-context-5.3.5.jar:5.3.5]
	at org.springframework.context.event.SimpleApplicationEventMulticaster.multicastEvent(SimpleApplicationEventMulticaster.java:131) ~[spring-context-5.3.5.jar:5.3.5]
	at org.springframework.boot.DefaultBootstrapContext.close(DefaultBootstrapContext.java:133) ~[spring-boot-2.4.4.jar:2.4.4]
	at org.springframework.boot.SpringApplication.prepareContext(SpringApplication.java:392) ~[spring-boot-2.4.4.jar:2.4.4]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:325) ~[spring-boot-2.4.4.jar:2.4.4]
	at org.springframework.boot.builder.SpringApplicationBuilder.run(SpringApplicationBuilder.java:144) [spring-boot-2.4.4.jar:2.4.4]
	at org.springframework.cloud.context.refresh.LegacyContextRefresher.addConfigFilesToEnvironment(LegacyContextRefresher.java:78) [spring-cloud-context-3.0.2.jar:3.0.2]
	at org.springframework.cloud.context.refresh.LegacyContextRefresher.updateEnvironment(LegacyContextRefresher.java:56) [spring-cloud-context-3.0.2.jar:3.0.2]
	at org.springframework.cloud.context.refresh.ContextRefresher.refreshEnvironment(ContextRefresher.java:101) [spring-cloud-context-3.0.2.jar:3.0.2]
	at org.springframework.cloud.context.refresh.ContextRefresher.refresh(ContextRefresher.java:94) [spring-cloud-context-3.0.2.jar:3.0.2]
	at org.springframework.cloud.endpoint.RefreshEndpoint.refresh(RefreshEndpoint.java:41) [spring-cloud-context-3.0.2.jar:3.0.2]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_265]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:1.8.0_265]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:1.8.0_265]
	at java.lang.reflect.Method.invoke(Method.java:498) ~[na:1.8.0_265]
	at org.springframework.util.ReflectionUtils.invokeMethod(ReflectionUtils.java:282) [spring-core-5.3.5.jar:5.3.5]
	at org.springframework.boot.actuate.endpoint.invoke.reflect.ReflectiveOperationInvoker.invoke(ReflectiveOperationInvoker.java:77) [spring-boot-actuator-2.4.4.jar:2.4.4]
	at org.springframework.boot.actuate.endpoint.annotation.AbstractDiscoveredOperation.invoke(AbstractDiscoveredOperation.java:60) [spring-boot-actuator-2.4.4.jar:2.4.4]
	at org.springframework.boot.actuate.endpoint.web.servlet.AbstractWebMvcEndpointHandlerMapping$ServletWebOperationAdapter.handle(AbstractWebMvcEndpointHandlerMapping.java:290) [spring-boot-actuator-2.4.4.jar:2.4.4]
	at org.springframework.boot.actuate.endpoint.web.servlet.AbstractWebMvcEndpointHandlerMapping$OperationHandler.handle(AbstractWebMvcEndpointHandlerMapping.java:373) [spring-boot-actuator-2.4.4.jar:2.4.4]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_265]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:1.8.0_265]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:1.8.0_265]
	at java.lang.reflect.Method.invoke(Method.java:498) ~[na:1.8.0_265]
	at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:197) [spring-web-5.3.5.jar:5.3.5]
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:141) [spring-web-5.3.5.jar:5.3.5]
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106) [spring-webmvc-5.3.5.jar:5.3.5]
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:894) [spring-webmvc-5.3.5.jar:5.3.5]
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:808) [spring-webmvc-5.3.5.jar:5.3.5]
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87) [spring-webmvc-5.3.5.jar:5.3.5]
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1060) [spring-webmvc-5.3.5.jar:5.3.5]
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:962) [spring-webmvc-5.3.5.jar:5.3.5]
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006) [spring-webmvc-5.3.5.jar:5.3.5]
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:909) [spring-webmvc-5.3.5.jar:5.3.5]
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:652) [tomcat-embed-core-9.0.44.jar:4.0.FR]
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883) [spring-webmvc-5.3.5.jar:5.3.5]
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:733) [tomcat-embed-core-9.0.44.jar:4.0.FR]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:227) [tomcat-embed-core-9.0.44.jar:9.0.44]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) [tomcat-embed-core-9.0.44.jar:9.0.44]
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53) [tomcat-embed-websocket-9.0.44.jar:9.0.44]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) [tomcat-embed-core-9.0.44.jar:9.0.44]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) [tomcat-embed-core-9.0.44.jar:9.0.44]
	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100) [spring-web-5.3.5.jar:5.3.5]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119) [spring-web-5.3.5.jar:5.3.5]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) [tomcat-embed-core-9.0.44.jar:9.0.44]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) [tomcat-embed-core-9.0.44.jar:9.0.44]
	at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93) [spring-web-5.3.5.jar:5.3.5]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119) [spring-web-5.3.5.jar:5.3.5]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) [tomcat-embed-core-9.0.44.jar:9.0.44]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) [tomcat-embed-core-9.0.44.jar:9.0.44]
	at org.springframework.boot.actuate.metrics.web.servlet.WebMvcMetricsFilter.doFilterInternal(WebMvcMetricsFilter.java:93) [spring-boot-actuator-2.4.4.jar:2.4.4]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119) [spring-web-5.3.5.jar:5.3.5]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) [tomcat-embed-core-9.0.44.jar:9.0.44]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) [tomcat-embed-core-9.0.44.jar:9.0.44]
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201) [spring-web-5.3.5.jar:5.3.5]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119) [spring-web-5.3.5.jar:5.3.5]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) [tomcat-embed-core-9.0.44.jar:9.0.44]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) [tomcat-embed-core-9.0.44.jar:9.0.44]
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:202) [tomcat-embed-core-9.0.44.jar:9.0.44]
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:97) [tomcat-embed-core-9.0.44.jar:9.0.44]
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:542) [tomcat-embed-core-9.0.44.jar:9.0.44]
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:143) [tomcat-embed-core-9.0.44.jar:9.0.44]
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92) [tomcat-embed-core-9.0.44.jar:9.0.44]
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:78) [tomcat-embed-core-9.0.44.jar:9.0.44]
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:357) [tomcat-embed-core-9.0.44.jar:9.0.44]
	at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:374) [tomcat-embed-core-9.0.44.jar:9.0.44]
	at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65) [tomcat-embed-core-9.0.44.jar:9.0.44]
	at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:893) [tomcat-embed-core-9.0.44.jar:9.0.44]
	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1707) [tomcat-embed-core-9.0.44.jar:9.0.44]
	at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49) [tomcat-embed-core-9.0.44.jar:9.0.44]
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149) [na:1.8.0_265]
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624) [na:1.8.0_265]
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61) [tomcat-embed-core-9.0.44.jar:9.0.44]
	at java.lang.Thread.run(Thread.java:748) [na:1.8.0_265]
```
