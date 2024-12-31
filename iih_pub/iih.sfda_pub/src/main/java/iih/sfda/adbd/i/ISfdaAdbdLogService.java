package iih.sfda.adbd.i;

import xap.mw.log.logging.Level;

public interface ISfdaAdbdLogService {
	
	void log(String arg0, Level arg1);

	void apilog(String arg0, Level arg1);

	void apilogStack(String arg0, Level arg1);

	void debug(String arg0, Class<?> arg1, String arg2);
}
