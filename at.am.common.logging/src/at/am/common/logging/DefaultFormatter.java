package at.am.common.logging;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class DefaultFormatter extends Formatter {

	@Override
	public String format ( LogRecord record ) {

		return new Date(record.getMillis()).toString() + " " + record.getLevel().getName() + " : ["
				+ record.getSourceClassName() + "] " + record.getMessage() + System.lineSeparator();
	}
}
