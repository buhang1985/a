package iih.ci.mi.log;

import com.founder.xap.runtime.msys.Module;
import com.founder.xap.runtime.msys.ModuleSystem;
import com.founder.xap.runtime.msys.impl.ModuleSystemImpl;

import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.log.logging.Level;
import xap.mw.log.logging.internal.Logger;

public class CiMiLogManager {
	
	private static Module module= null;
	
	static {
		module= ModuleSystemImpl.getExtensionPoints().getExtensionPoint(ModuleSystem.class).getModule("iih.ci");
	}
	
	private CiMiLogManager(){}
	
	/**
	 * 信息输出到日志
	 * @param ctx
	 * @param msg
	 */
	public static void info(CiEnContextDTO ctx,String msg) {
		
		GetLogger(ctx).info(msg);
	}
	
	/**
	 * 调试信息输入到日志
	 * @param ctx
	 * @param msg
	 */
	public static void debug(CiEnContextDTO ctx,String msg) {
		
		GetLogger(ctx).debug(msg);
	}
	
	/**
	 * 错误信息输出到日志
	 * @param ctx
	 * @param msg
	 * @param t
	 */
	public static void error(CiEnContextDTO ctx,String msg, Throwable t) {
		
		GetLogger(ctx).error(msg);
	}
	
	/**
	 * 错误信息输出到日志
	 * @param ctx
	 * @param msg
	 */
	public static void error(CiEnContextDTO ctx,String msg) {
		GetLogger(ctx).error(msg);
		
	}
	/**
	 * 获取日志文件流
	 * @param ctx
	 * @return
	 */
	public static Logger  GetLogger(CiEnContextDTO ctx){
//		String logfile = CiOrdUtils.isEmpty(ctx) ? "iih.ci.ord"
//				: String.format("%s_%s_%s_%s_%s_%s",
//						CiOrdAppUtils.getServerDateTime().getDate().toString(),
//						CiOrdUtils.isIpWf(ctx.getCode_entp()) ? "住院" : "门急诊",
//						CiOrdUtils.isEmpty(ctx.getName_org()) 
//						? "未知组织" : ctx.getName_org(),
//						 CiOrdUtils.isEmpty(ctx.getName_dep_or()) 
//						? "未知科室" : ctx.getName_dep_or(),
//						CiOrdUtils.isEmpty(ctx.getName_emp_or()) 
//						? "未知医生" : ctx.getName_emp_or(),
//						 CiOrdUtils.isEmpty(ctx.getName_pat()) 
//						? "未知患者" : ctx.getName_pat());
		String logfile = ctx==null ? "iih.ci.mi"
				: String.format("%s_%s",ctx.getCode_entp(), ctx.getName_dep_or());
		Logger logger = module.getContext().getLogger(logfile);
		module.getContext().setLogLevel(logfile, Level.INFO);
		return logger;
	}
}
