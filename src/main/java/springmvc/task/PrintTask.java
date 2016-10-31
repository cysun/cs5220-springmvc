package springmvc.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PrintTask {

    private static final Logger logger = LoggerFactory
        .getLogger( PrintTask.class );

    // Print out "something something" every 5 hours
    @Scheduled(cron = "0 0 */5 * * *")
    public void print()
    {
        logger.info( "something something" );
    }

}
