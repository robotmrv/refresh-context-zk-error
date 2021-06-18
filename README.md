0. start zookeeper (you can use `docker-compose up`)  
1. Start application  
Result - application fails to start  
```
18:31:33.001 [main] DEBUG org.springframework.boot.diagnostics.LoggingFailureAnalysisReporter - Application failed to start due to an exception
org.springframework.boot.context.config.ConfigDataResourceNotFoundException: Config data resource '[ZookeeperConfigDataResource@59494225 context = 'config/application,default', optional = false, profile = 'default']' via location 'zookeeper:localhost:2181' cannot be found
	at org.springframework.boot.context.config.ConfigDataResourceNotFoundException.withLocation(ConfigDataResourceNotFoundException.java:97)
	at org.springframework.boot.context.config.ConfigDataImporter.handle(ConfigDataImporter.java:147)
	at org.springframework.boot.context.config.ConfigDataImporter.load(ConfigDataImporter.java:138)
	at org.springframework.boot.context.config.ConfigDataImporter.resolveAndLoad(ConfigDataImporter.java:88)
	at org.springframework.boot.context.config.ConfigDataEnvironmentContributors.withProcessedImports(ConfigDataEnvironmentContributors.java:122)
	at org.springframework.boot.context.config.ConfigDataEnvironment.processWithProfiles(ConfigDataEnvironment.java:311)
	at org.springframework.boot.context.config.ConfigDataEnvironment.processAndApply(ConfigDataEnvironment.java:232)
	at org.springframework.boot.context.config.ConfigDataEnvironmentPostProcessor.postProcessEnvironment(ConfigDataEnvironmentPostProcessor.java:102)
	at org.springframework.boot.context.config.ConfigDataEnvironmentPostProcessor.postProcessEnvironment(ConfigDataEnvironmentPostProcessor.java:94)
	at org.springframework.boot.env.EnvironmentPostProcessorApplicationListener.onApplicationEnvironmentPreparedEvent(EnvironmentPostProcessorApplicationListener.java:100)
	at org.springframework.boot.env.EnvironmentPostProcessorApplicationListener.onApplicationEvent(EnvironmentPostProcessorApplicationListener.java:86)
	at org.springframework.context.event.SimpleApplicationEventMulticaster.doInvokeListener(SimpleApplicationEventMulticaster.java:176)
	at org.springframework.context.event.SimpleApplicationEventMulticaster.invokeListener(SimpleApplicationEventMulticaster.java:169)
	at org.springframework.context.event.SimpleApplicationEventMulticaster.multicastEvent(SimpleApplicationEventMulticaster.java:143)
	at org.springframework.context.event.SimpleApplicationEventMulticaster.multicastEvent(SimpleApplicationEventMulticaster.java:131)
	at org.springframework.boot.context.event.EventPublishingRunListener.environmentPrepared(EventPublishingRunListener.java:82)
	at org.springframework.boot.SpringApplicationRunListeners.lambda$environmentPrepared$2(SpringApplicationRunListeners.java:63)
	at java.util.ArrayList.forEach(ArrayList.java:1259)
	at org.springframework.boot.SpringApplicationRunListeners.doWithListeners(SpringApplicationRunListeners.java:117)
	at org.springframework.boot.SpringApplicationRunListeners.doWithListeners(SpringApplicationRunListeners.java:111)
	at org.springframework.boot.SpringApplicationRunListeners.environmentPrepared(SpringApplicationRunListeners.java:62)
	at org.springframework.boot.SpringApplication.prepareEnvironment(SpringApplication.java:375)
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:333)
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1329)
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1318)
	at com.example.zkerror.ZkErrorApplication.main(ZkErrorApplication.java:18)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.springframework.boot.loader.MainMethodRunner.run(MainMethodRunner.java:49)
	at org.springframework.boot.loader.Launcher.launch(Launcher.java:108)
	at org.springframework.boot.loader.Launcher.launch(Launcher.java:58)
	at org.springframework.boot.loader.JarLauncher.main(JarLauncher.java:88)
Caused by: java.lang.IllegalArgumentException: Property source must not be null
	at org.springframework.util.Assert.notNull(Assert.java:201)
	at org.springframework.core.env.PropertySource.<init>(PropertySource.java:76)
	at org.springframework.core.env.EnumerablePropertySource.<init>(EnumerablePropertySource.java:53)
	at org.springframework.cloud.zookeeper.config.AbstractZookeeperPropertySource.<init>(AbstractZookeeperPropertySource.java:36)
	at org.springframework.cloud.zookeeper.config.ZookeeperPropertySource.<init>(ZookeeperPropertySource.java:46)
	at org.springframework.cloud.zookeeper.config.ZookeeperConfigDataLoader.load(ZookeeperConfigDataLoader.java:46)
	at org.springframework.cloud.zookeeper.config.ZookeeperConfigDataLoader.load(ZookeeperConfigDataLoader.java:33)
	at org.springframework.boot.context.config.ConfigDataLoaders.load(ConfigDataLoaders.java:103)
	at org.springframework.boot.context.config.ConfigDataImporter.load(ConfigDataImporter.java:130)
	... 31 common frames omitted
18:31:33.006 [main] ERROR org.springframework.boot.diagnostics.LoggingFailureAnalysisReporter - 

***************************
APPLICATION FAILED TO START
***************************

Description:

Config data resource '[ZookeeperConfigDataResource@59494225 context = 'config/application,default', optional = false, profile = 'default']' via location 'zookeeper:localhost:2181' does not exist

Action:

Check that the value 'zookeeper:localhost:2181' at class path resource [application.yml] from zk-error-0.0.1-SNAPSHOT.jar - 4:13 is correct, or prefix it with 'optional:'

Disconnected from the target VM, address: '127.0.0.1:58391', transport: 'socket'

Process finished with exit code 1
```

3. add WA - uncomment `spring.factories` content and start application  
Result - application starts

4. set application property `spring.cloud.config.discovery.enabled` to true and start application  
Result - application failed to start
```
2021-06-18 18:37:28.298 ERROR 28016 --- [           main] o.s.boot.SpringApplication               : Application run failed

java.lang.IllegalStateException: Could not register object [org.apache.curator.framework.imps.CuratorFrameworkImpl@7cbd213e] under bean name 'configDataCuratorFramework': there is already object [org.apache.curator.framework.imps.CuratorFrameworkImpl@7cbd213e] bound
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.registerSingleton(DefaultSingletonBeanRegistry.java:124) ~[spring-beans-5.3.8.jar!/:5.3.8]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.registerSingleton(DefaultListableBeanFactory.java:1138) ~[spring-beans-5.3.8.jar!/:5.3.8]
	at org.springframework.cloud.zookeeper.CuratorFactory.lambda$registerCurator$5(CuratorFactory.java:120) ~[spring-cloud-zookeeper-core-3.0.3.jar!/:3.0.3]
	at org.springframework.context.event.SimpleApplicationEventMulticaster.doInvokeListener(SimpleApplicationEventMulticaster.java:176) ~[spring-context-5.3.8.jar!/:5.3.8]
	at org.springframework.context.event.SimpleApplicationEventMulticaster.invokeListener(SimpleApplicationEventMulticaster.java:169) ~[spring-context-5.3.8.jar!/:5.3.8]
	at org.springframework.context.event.SimpleApplicationEventMulticaster.multicastEvent(SimpleApplicationEventMulticaster.java:143) ~[spring-context-5.3.8.jar!/:5.3.8]
	at org.springframework.context.event.SimpleApplicationEventMulticaster.multicastEvent(SimpleApplicationEventMulticaster.java:131) ~[spring-context-5.3.8.jar!/:5.3.8]
	at org.springframework.boot.DefaultBootstrapContext.close(DefaultBootstrapContext.java:133) ~[spring-boot-2.4.7.jar!/:2.4.7]
	at org.springframework.boot.SpringApplication.prepareContext(SpringApplication.java:404) [spring-boot-2.4.7.jar!/:2.4.7]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:338) [spring-boot-2.4.7.jar!/:2.4.7]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1329) [spring-boot-2.4.7.jar!/:2.4.7]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1318) [spring-boot-2.4.7.jar!/:2.4.7]
	at com.example.zkerror.ZkErrorApplication.main(ZkErrorApplication.java:18) [classes!/:0.0.1-SNAPSHOT]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_265]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:1.8.0_265]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:1.8.0_265]
	at java.lang.reflect.Method.invoke(Method.java:498) ~[na:1.8.0_265]
	at org.springframework.boot.loader.MainMethodRunner.run(MainMethodRunner.java:49) [zk-error-0.0.1-SNAPSHOT.jar:0.0.1-SNAPSHOT]
	at org.springframework.boot.loader.Launcher.launch(Launcher.java:108) [zk-error-0.0.1-SNAPSHOT.jar:0.0.1-SNAPSHOT]
	at org.springframework.boot.loader.Launcher.launch(Launcher.java:58) [zk-error-0.0.1-SNAPSHOT.jar:0.0.1-SNAPSHOT]
	at org.springframework.boot.loader.JarLauncher.main(JarLauncher.java:88) [zk-error-0.0.1-SNAPSHOT.jar:0.0.1-SNAPSHOT]
```
