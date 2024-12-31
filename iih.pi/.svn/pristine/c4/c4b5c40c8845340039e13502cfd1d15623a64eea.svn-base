package iih.pi.reg.s.customer.guoji.util;

import iih.pi.reg.i.IPiPatLogService;

import java.sql.CallableStatement;
import java.sql.SQLException;

import xap.mw.log.logging.Level;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.log.Log;

/**
 * 国际调用相关日志工具类
 * @author ly 2017/12/26
 *
 */
public class PiGjLogUtil {

	/**
	 * chis医保建档日志
	 * @param ps
	 * @throws SQLException 
	 */
	public static void logChisCreateIns(String... args){
		try {
			String log = "执行CHIS医保患者建档存储过程 SP_SST_MZ_DAXXDJ 入参: ";
			String format = "'%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s',%s,'%s','%s','%s','%s','%s'";
			log += String.format(format, args[0], args[1], args[2], args[3],
					args[4], args[5], args[6], args[7], args[8], args[9], args[10],
					args[11], args[12], args[13], args[14], args[15], args[16],
					args[17]);
			
			logInfo(log);
		} catch (Exception e) {
			e.printStackTrace();
			Log.error(e);
		}
	}
	
	/**
	 * chis医保建档返回值日志
	 * @param ps
	 * @throws SQLException 
	 */
	public static void logChisCreateInsRlt(CallableStatement ps){
		try {
			String log = "执行CHIS医保患者建档存储过程 SP_SST_MZ_DAXXDJ 返回值: ";
			String format = "'%s','%s','%s','%s'";
			log += String.format(format, ps.getString(19), ps.getString(20),
					ps.getString(21), ps.getString(22));
			
			logInfo(log);
		} catch (Exception e) {
			e.printStackTrace();
			Log.error(e);
		}
	}
	
	/**
	 * chis自费建档日志
	 * @param ps
	 * @throws SQLException
	 */
	public static void logChisCreateSelf(String... args){
		try {
			String log = "执行CHIS自费患者建档存储过程  proc_phone_createPerson 入参: ";
			String format = "'%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s',%s,'%s','%s','%s','%s'";
			log += String.format(format, args[0], args[1], args[2], args[3],
					args[4], args[5], args[6], args[7], args[8], args[9], args[10],
					args[11], args[12], args[13], args[14], args[15], args[16],
					args[17]);
			
			logInfo(log);
		} catch (Exception e) {
			e.printStackTrace();
			Log.error(e);
		}
	}
	
	/**
	 * chis自费建档返回值日志
	 * @param ps
	 * @throws SQLException
	 */
	public static void logChisCreateSelfRlt(CallableStatement ps){
		try {
			String log = "执行CHIS自费患者建档存储过程  proc_phone_createPerson 返回值: ";
			String format = "'%s','%s','%s','%s'";
			log += String.format(format, ps.getString(19), ps.getString(20),
					ps.getString(21), ps.getString(22));
			
			logInfo(log);
		} catch (Exception e) {
			e.printStackTrace();
			Log.error(e);
		}
		
	}

	/**
	 * chis更新患者日志
	 * @param args
	 * @throws SQLException
	 */
	public static void logChisUpdate(String... args){
		try {
			String log = "执行CHIS更新患者存储过程  IIH_MZ_PatientInfo_update 入参: ";
			String format = "'%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s'";
			
			log += String.format(format, args[0], args[1], args[2], args[3],
					args[4], args[5], args[6], args[7], args[8], args[9],
					args[10], args[11], args[12], args[13], args[14], args[15],
					args[16]);
			
			logInfo(log);
		} catch (Exception e) {
			e.printStackTrace();
			Log.error(e);
		}
		
	}
	
	/**
	 * chis更新患者返回值日志
	 * @param rs
	 * @throws SQLException
	 */
	public static void logChisUpdateRlt(String... args){
		try {
			String log = "执行CHIS更新患者存储过程  IIH_MZ_PatientInfo_update 返回值: ";
			String format = "'%s','%s'";
			format = String.format(format, args[0], args[1]);
			log += format;
			logInfo(log);
		} catch (Exception e) {
			e.printStackTrace();
			Log.error(e);
		}
	}
	
	/**
	 * 输出info级别日志
	 * @param log
	 */
	private static void logInfo(String log){
		IPiPatLogService logService = ServiceFinder.find(IPiPatLogService.class);
		logService.log(log, Level.INFO);
	}
}
