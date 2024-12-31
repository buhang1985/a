package iih.bl.comm.util;

import iih.bl.cg.blcgoep.i.IBlcgoepCudService;
import iih.bl.cg.blcgoep.i.IBlcgoepRService;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 费用域服务仓库
 * @author yankan
 * @since 2017-06-27
 *
 */
public class BlServiceRepository {
	/**
	 * 获取门诊记账查询服务
	 * @return
	 */
	public static IBlcgoepRService getOpCgRService(){
		IBlcgoepRService service = ServiceFinder.find(IBlcgoepRService.class);
		return service;
	}
	/**
	 * 获取门诊记账查询服务
	 * @return
	 */
	public static IBlcgoepCudService getOpCgCudService(){
		IBlcgoepCudService service = ServiceFinder.find(IBlcgoepCudService.class);
		return service;
	}
}
