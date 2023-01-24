package pk;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.internal.LogManagerStatus;

public class Tracer {
    public static void useTracer(boolean tracer){
        Logger log = LogManager.getRootLogger();
        if (tracer == true){
            Configurator.setRootLevel(Level.TRACE);
            log.trace("Tracing will now be on");
        }else{
            Configurator.setRootLevel(Level.DEBUG);
            log.info("Tracing is off");
        }
    }
}
