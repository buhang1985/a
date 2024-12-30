package iih.sc.apt.custom;

import iih.sc.apt.custom.i.IScAptCustomService;
import iih.sc.apt.custom.s.ScAptCustomBaseService;
import iih.sc.apt.scapt.d.ScAptDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
/***
 * 预约客开帮助类
 * @author fanlq
 * @date: 2020年2月14日 下午1:26:34
 */
public class ScAptCustomServiceUtils {
	/***
	 * @Description:取号前客开处理
	 * @return
	 * @throws BizException
	 */
	public static boolean handle4TakeApptNoBefor(ScAptDO aptDO,String id_ent) throws BizException {
		return getServices().handle4TakeApptNoBefor(aptDO, id_ent);
	}
	
	/**
	 * BS003消息客开处理
	 * @param obj
	 * @return
	 * @throws BizException
	 */
	public static boolean handleWrapScApt4IeObj(Object obj) throws BizException{
		return getServices().handleWrapScApt4IeObj(obj);
	}
	/**
	 * 获取所有服务实现
	 * 
	 * @return
	 */
	private static IScAptCustomService getServices(){
		IScAptCustomService serv = ServiceFinder.find(IScAptCustomService.class);
		return serv != null ? serv : new ScAptCustomBaseService();
	}
}
