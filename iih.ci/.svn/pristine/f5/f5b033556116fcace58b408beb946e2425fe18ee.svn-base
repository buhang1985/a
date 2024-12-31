package iih.ci.ord.s.external.blood.ruimei.s.bp;

import iih.ci.ord.s.external.thirdws.utils.LogUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.time.TimeService;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class BloodManageUtils {
	
	/***
	 * 获得服务器日期时间
	 * 
	 * @return
	 */
	public static FDateTime getServerDateTime() {
		TimeService ts = (TimeService) ServiceFinder.find(TimeService.class.getName());
		return ts.getUFDateTime();
	}
	
	/**
	 * 瑞美血库对接接口备血申请服务编码
	 * @return
	 * @throws BizException
	 */
	public static String LL_CIOR0424() throws BizException
	{
		return ParamsetQryUtil.getParaString(Context.get().getOrgId(), "LL_CIOR0424");
	}
	/**
	 * 瑞美血库对接接口用血申请服务编码
	 * @return
	 * @throws BizException
	 */
	public static String LL_CIOR0425() throws BizException
	{
		return ParamsetQryUtil.getParaString(Context.get().getOrgId(), "LL_CIOR0425");
	}
	
	public static void LogInfo(Exception ex) {
		LogUtils.Logger(ex.getMessage());
		StackTraceElement[] stacks=ex.getStackTrace();
		for (StackTraceElement o : stacks) {
			LogUtils.Logger(o.getClassName()+"."+o.getMethodName()+" "+o.getLineNumber());
		}
	}

}
