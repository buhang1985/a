package iih.ci.diag.log;


import iih.ci.diag.s.CiDiUtils;
import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.log.logging.internal.Logger;
import com.founder.xap.runtime.msys.Module;
import com.founder.xap.runtime.msys.ModuleSystem;
import com.founder.xap.runtime.msys.impl.ModuleSystemImpl;

public class Diaglogger {
private static Module module= null;
	
	static {
		module= ModuleSystemImpl.getExtensionPoints().getExtensionPoint(ModuleSystem.class).getModule("iih.ci");
	}
	
	private Diaglogger(){}
	
	/**
	 * 信息输出到日志
	 * @param ctx
	 * @param msg
	 */
	public static void info(CiEnContextDTO ctx,String msg) {
		
		GetLogger(ctx).error(msg);
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
		String logfile = CiDiUtils.isEmpty(ctx) ? "iih.ci.diag"
				: String.format("%s_%s",
						CiDiUtils.isEmpty(ctx.getName_org()) 
						? "未知组织" : ctx.getName_org(),
						CiDiUtils.isEmpty(ctx.getName_dep_en()) 
						? "未知科室" : ctx.getName_dep_en()
						//: String.format("%s_%s_%s_%s_%s",
						//CiDiUtils.getSystemDateTime()
						 
						/*CiDiUtils.isEmpty(ctx.getOrg()) || CiDiUtils.isEmpty(ctx.getOrg().getName()) 
						? "未知组织" : ctx.getOrg().getName(),
						CiDiUtils.isEmpty(ctx.getDept()) || CiDiUtils.isEmpty(ctx.getDept().getName()) 
						? "未知科室" : ctx.getDept().getName(),
						CiDiUtils.isEmpty(ctx.getPsnInfo()) || CiDiUtils.isEmpty(ctx.getPsnInfo().getName()) 
						? "未知医生" : ctx.getPsnInfo().getName(),
						CiDiUtils.isEmpty(ctx.getEnt4BannerDTO()) || CiDiUtils.isEmpty(ctx.getEnt4BannerDTO().getName_pat()) 
						? "未知患者" : ctx.getEnt4BannerDTO().getName_pat()*/);
		return module.getContext().getLogger(logfile);
	}
}

