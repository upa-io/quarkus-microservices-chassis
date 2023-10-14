package com.upaio;

import jakarta.ws.rs.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/logging")
public class LoggingResource {

    private static Level getLogLevel(Logger logger) {
        for (Logger current = logger; current != null;) {
            Level level = current.getLevel();
            if (level != null)
                return level;
            current = current.getParent();
        }
        return Level.INFO;
    }

    @POST
    @Path("/{logger}")
    @Produces("text/plain")
    public Level logger(@PathParam("logger") String loggerName, @QueryParam("level") String level) {
        // Get the logger instance
        Logger logger = Logger.getLogger(loggerName);

        // Change the log-level if requested
        if (level != null && level.length() > 0)
            logger.setLevel(Level.parse(level));

        // Return the current log-level
        return getLogLevel(logger);
    }
}
