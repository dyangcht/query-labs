package org.acme.people.health;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Readiness;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.enterprise.context.ApplicationScoped;
import org.jboss.logging.Logger;

@ApplicationScoped
@Readiness
public class DatabaseConnectionHealthCheck implements HealthCheck {

    @ConfigProperty(name = "database.up", defaultValue = "false")
    public boolean databaseUp;
    @ConfigProperty(name = "database.username", defaultValue = "false")
    public String userName;
    @ConfigProperty(name = "database.password", defaultValue = "false")
    public String userPWD;

    @ConfigProperty(name = "database.servername", defaultValue = "server")
    public String serverName;
    @ConfigProperty(name = "database.serverport", defaultValue = "5432")
    public String portNumber;
    @ConfigProperty(name = "database.dbname", defaultValue = "people")
    public String dbName;
    private static final Logger LOG = Logger.getLogger(DatabaseConnectionHealthCheck.class);

    @Override
    public HealthCheckResponse call() {

        HealthCheckResponseBuilder responseBuilder = HealthCheckResponse.named("Database connection health check");
        LOG.info("This is the HealthCheckResponse.");
        try {
            simulateDatabaseConnectionVerification();
            responseBuilder.up();
        } catch (IllegalStateException e) {
            // cannot access the database
            responseBuilder.down().withData("error", e.getMessage());
        }

        return responseBuilder.build();
    }

    private void simulateDatabaseConnectionVerification() {
        databaseUp = getConnection();
        if (!databaseUp) {
            throw new IllegalStateException("Cannot contact database");
        }
    }

    public boolean getConnection() {

        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", this.userName);
        connectionProps.put("password", this.userPWD);

        try {
            conn = DriverManager.getConnection(
                    "jdbc:postgresql://" + this.serverName + ":" + this.portNumber + "/" + this.dbName,
                    connectionProps);
            LOG.info("This is the db connection.");
            conn.close();
        } catch (SQLException e) {
            // throw new IllegalStateException("Cannot contact database");
            return false;
        }
        System.out.println("Connected to database");
        return true;
    }
}