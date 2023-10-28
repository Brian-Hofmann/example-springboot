package org.example.sboot.config;

import io.ebean.Database;
import io.ebean.DatabaseFactory;
import io.ebean.config.DatabaseConfig;
import io.ebean.config.TenantMode;
import io.ebean.datasource.DataSourceConfig;
import org.example.sboot.service.CurrentUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EbeanConfiguration {

    @Value("${db-url}")
    private String dbUrl;

    @Value("${db-username}")
    private String dbUsername;

    @Value("${db-password}")
    private String dbPassword;

    @Value("${db-driver}")
    private String dbDriver;

    @Value("${ebean.migration.run}")
    private boolean autoRunMigration;

    @Value("${testing}")
    private boolean testing;

    @Bean
    public Database database() {
        // When placing a breakpoint here, you can see the wrong property file values loaded in the @Value variables
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setUsername(dbUsername);
        dsConfig.setPassword(dbPassword);
        dsConfig.setUrl(dbUrl);
        dsConfig.setDriver(dbDriver);

        DatabaseConfig dbConfig = new DatabaseConfig();
        dbConfig.setDataSourceConfig(dsConfig);
        dbConfig.loadFromProperties();
        dbConfig.setRunMigration(autoRunMigration);
        if (!testing) {
            dbConfig.setCurrentUserProvider(new CurrentUser());
        }
        return DatabaseFactory.create(dbConfig);
    }
}
