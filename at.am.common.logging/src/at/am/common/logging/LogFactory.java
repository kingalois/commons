package at.am.common.logging;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class LogFactory {

	static {
		Logger log = Logger.getLogger(LoggingContants.ROOT_LOGGER_PREFIX);
		for (Handler h : log.getHandlers()) {
			log.removeHandler(h);
		}
		Handler consoleHandler = new ConsoleHandler();
		consoleHandler.setFormatter(new DefaultFormatter());

		try {
			FileHandler fileHandler = new FileHandler(LoggingContants.FILENAME_PATTERN, LoggingContants.FILESIZE_10MB, LoggingContants.NR_OF_FILES, true);
			fileHandler.setFormatter(new DefaultFormatter());
			log.addHandler(fileHandler);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.addHandler(consoleHandler);
	}

	public static Logger makeLogger() {
		Throwable th = new Throwable();
		Logger logger = Logger.getLogger(th.getStackTrace()[1].getClassName());
		logger.setUseParentHandlers(true);
		return logger;
	}

	public static Logger makeLogger(String name) {
		Logger logger = Logger.getLogger(name);
		logger.setUseParentHandlers(true);
		return logger;
	}
}
