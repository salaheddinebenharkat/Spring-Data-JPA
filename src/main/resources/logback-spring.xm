<!-- logback-spring.xml -->
<configuration>

    <!-- Appender to write logs to a file in a specific directory -->
    <appender name="fileAppender" class="ch.qos.logback.core.FileAppender">
        <file>C:\Users\Salaheddine\Desktop\logs/application.log</file>
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>

    <!-- Root logger level and appender reference -->
    <root level="info">
        <appender-ref ref="fileAppender"/>
    </root>

</configuration>