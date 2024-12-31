package iih.bd.srv.pub;

import iih.bd.srv.ems.i.IEmsRelSrvDORService;
import iih.bd.srv.oth.i.ISrvwordfreqstatisticCudService;
import iih.bd.srv.oth.i.ISrvwordfreqstatisticRService;
import iih.bd.srv.srvrtempref.i.ISrvrtemprefRService;
import xap.mw.core.data.Context;
import xap.mw.core.service.time.TimeService;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.custcfg.billcode.i.IBillcodeManage;



public class BdSrvAppUtils {
	
	/**
	 * 获得系统环境变量
	 * MM
	 * @return
	 */
	public static Context getEnvContext(){
		return Context.get();
	}
	
	/***
	 * 获得服务器日期时间
	 * @return
	 */
	public static FDateTime getServerDateTime(){
		TimeService ts=(TimeService)ServiceFinder.find(TimeService.class.getName());
		return  ts.getUFDateTime();
	}
	/**
	 * 获得医生服务开立权限查询服务
	 * @return
	 */
	public static ISrvrtemprefRService getSrvrtemprefQryService(){
		return (ISrvrtemprefRService)ServiceFinder.find(ISrvrtemprefRService.class);
	}
	/**
	 * 获得服务词频统计信息查询服务
	 * @return
	 */
	public static ISrvwordfreqstatisticRService getSrvwordfreqQryService(){
		return (ISrvwordfreqstatisticRService)ServiceFinder.find(ISrvwordfreqstatisticRService.class);
	}
	/**
	 * 获得服务词频统计信息维护服务
	 */
	public static ISrvwordfreqstatisticCudService getSrvwordfreqService(){
		return (ISrvwordfreqstatisticCudService)ServiceFinder.find(ISrvwordfreqstatisticCudService.class);
	}
	/**
	 * 获得医疗单关联服务数据信息查询服务
	 * @return
	 */
	public static IEmsRelSrvDORService getEmsRelSrvQryService(){
		return (IEmsRelSrvDORService)ServiceFinder.find(IEmsRelSrvDORService.class);
	}
	
	/**
	 * 获得编码字段生成管理器
	 * @return
	 */
	public static IBillcodeManage getIBillcodeManager(){
		return (IBillcodeManage)ServiceFinder.find(IBillcodeManage.class);
	}
}
