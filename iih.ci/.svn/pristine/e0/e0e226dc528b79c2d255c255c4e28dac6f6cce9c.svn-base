package iih.ci.sdk.log;

import com.founder.xap.runtime.msys.Module;
import com.founder.xap.runtime.msys.ModuleSystem;
import com.founder.xap.runtime.msys.impl.ModuleSystemImpl;

import iih.ci.log.d.LogLevel;
import iih.ci.log.i.ICiBizLogService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.sdk.utils.CiBizUtils;
import iih.ci.sdk.utils.CiEnContextUtil;
import iih.ci.sdk.utils.CiOrdAppUtils;
import iih.ci.sdk.utils.ObjectUtils;
import xap.mw.core.data.BizException;
import xap.mw.log.logging.Level;
import xap.mw.log.logging.internal.Logger;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 临床业务类操作日志输出
 * @author wangqingzhu
 *
 */
public class OrdBizLogger {
	
	private static Module module= null;
	private static ICiBizLogService logService;
	static {
		logService = ServiceFinder.find(ICiBizLogService.class);
		module= ModuleSystemImpl.getExtensionPoints().getExtensionPoint(ModuleSystem.class).getModule("iih.ci");
	}
	
	private OrdBizLogger(){}
	
	/**
	 * 信息输出到日志
	 * @param ctx
	 * @param msg
	 * @throws BizException 
	 */
	public static void info(CiEnContextDTO ctx,String msg){
//		try {
//			logService.SaveLoglevel(LogLevel.INFO, ctx, msg);
//		} catch (BizException e) {
//			e.printStackTrace();
//		}
		GetLogger(ctx,null).info(msg);
	}
	
	/**
	 * 记录服务器日志文件
	 * @param filename
	 * @param msg
	 */
	public static void finfo(String filename,String msg){
		
		GetLogger(filename,null).info(msg);
	}
	
	public static void info(String msg,String code_or,String id_emp){
		if(!ObjectUtils.isEmpty(code_or)){
			CiEnContextDTO ctx = CiEnContextUtil.GetEnContext4Logger(code_or,id_emp);
//			try {
//				logService.SaveLoglevel(LogLevel.INFO, ctx, msg);
//			} catch (BizException e) {
//				e.printStackTrace();
//			}
			GetLogger(ctx,null).info(msg);
		}
	}
	/**
	 * 调试信息输入到日志
	 * @param ctx
	 * @param msg
	 * @throws BizException 
	 */
	public static void debug(CiEnContextDTO ctx,String msg) {
//		try {
//			logService.SaveLoglevel(LogLevel.DEBUG, ctx, msg);
//		} catch (BizException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		GetLogger(ctx,null).debug(msg);
	}
	
	public static void fdebug(String filename, String msg) {
		
		GetLogger(filename,null).debug(msg);
	}
	
	
	public static void debug(String msg,String code_or,String id_emp){
		if(!ObjectUtils.isEmpty(code_or)){
			CiEnContextDTO ctx = CiEnContextUtil.GetEnContext4Logger(code_or,id_emp);
//			try {
//				logService.SaveLoglevel(LogLevel.DEBUG, ctx, msg);
//			} catch (BizException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			GetLogger(ctx,null).debug(msg);
		}
	}
	/**
	 * 错误信息输出到日志
	 * @param ctx
	 * @param msg
	 * @param t
	 * @throws BizException 
	 */
	public static void error(CiEnContextDTO ctx,String msg, Throwable t) {
//		try {
//			logService.SaveLoglevel2(LogLevel.ERROR, ctx, msg, t);
//		} catch (BizException e) {
//			e.printStackTrace();
//		}
		GetLogger(ctx,null).error(msg,t);
	}
	
	/**
	 * 输出本地日志文件
	 * @param filename
	 * @param msg
	 * @param t
	 */
	public static void ferror(String filename, String msg, Throwable t) {
		
		GetLogger(filename,null).error(msg + t.getMessage());
	}
	
	public static void error(String code_or,String id_emp,String msg,Throwable t){
		if(!ObjectUtils.isEmpty(code_or)){
			CiEnContextDTO ctx = CiEnContextUtil.GetEnContext4Logger(code_or,id_emp);
//			try {
//				logService.SaveLoglevel2(LogLevel.ERROR, ctx, msg, t);
//			} catch (BizException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			GetLogger(ctx,null).error(msg);
		}
	}
	/**
	 * 错误信息输出到日志
	 * @param ctx
	 * @param msg
	 * @throws BizException 
	 */
	public static void error(CiEnContextDTO ctx,String msg){
	
//		try {
//			logService.SaveLoglevel(LogLevel.ERROR, ctx, msg);
//		} catch (BizException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		GetLogger(ctx,null).error(msg);
	}
	
	/**
	 * 输出本地错误日志文件
	 * @param filename
	 * @param msg
	 */
	public static void ferror(String filename, String msg){
		
		GetLogger(filename,null).error(msg);
	}
	
	/**
	 * 错误日志输出
	 * @param msg
	 * @param code_or
	 * @param id_emp
	 */
	public static void error(String msg,String code_or,String id_emp){
		if(!ObjectUtils.isEmpty(code_or)){
			CiEnContextDTO ctx = CiEnContextUtil.GetEnContext4Logger(code_or,id_emp);
//			try {
//				logService.SaveLoglevel(LogLevel.ERROR, ctx, msg);
//			} catch (BizException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			GetLogger(ctx,null).error(msg);
		}
	
	}
	/**
	 * 获取日志文件流
	 * @param ctx
	 * @return
	 */
	public static Logger  GetLogger(CiEnContextDTO ctx, Level lv){
		String logfile = ObjectUtils.isEmpty(ctx) ? "default"
				: String.format("%s.%s.%s.%s.%s.%s",
						CiOrdAppUtils.getServerDateTime().getDate().toString(),
						ObjectUtils.isEmpty(ctx.getName_org())  ? "未知组织" : ctx.getName_org(),
						CiBizUtils.isIpWf(ctx.getCode_entp()) ? "住院" : "门急诊",
						ObjectUtils.isEmpty(ctx.getName_dep_or()) ? "未知科室" : ctx.getName_dep_or(),
						ObjectUtils.isEmpty(ctx.getName_psndoc()) ? "未知医生" : ctx.getName_psndoc(),
						ObjectUtils.isEmpty(ctx.getName_pat()) ? "未知患者" : ctx.getName_pat());
						
		Logger logger = module.getContext().getLogger(logfile);
		module.getContext().setLogLevel(logfile, null == lv?Level.INFO:lv);
		return logger;
	}
	
	/**
	 * 获取给定文件名称的日志记录器对象
	 * @param filename
	 * @return
	 */
	public static Logger  GetLogger(String filename, Level lv){
		String logfile = ObjectUtils.isEmpty(filename) ? "default":filename;
				
		Logger logger = module.getContext().getLogger(logfile);
		module.getContext().setLogLevel(logfile,  null == lv?Level.INFO:lv);
		return logger;
	}
	
	/**
	 * 获取当前服务器时间
	 * @return
	 */
	public static long GetLocalTime() {
		return System.currentTimeMillis();
	}
	
	/**
	 * 控制台输出耗时统计
	 * @param desc
	 * @param lBeginTime
	 */
	public static void OutputCostTime(String desc, long lBeginTime) {
		System.out.println(String.format("## %s %s", desc, System.currentTimeMillis() - lBeginTime));
	}
	
	
}
