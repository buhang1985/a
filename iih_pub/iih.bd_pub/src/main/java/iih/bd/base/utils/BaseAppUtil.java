package iih.bd.base.utils;

import xap.mw.core.service.time.TimeService;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

public class BaseAppUtil {
	/***
	 * 获得服务器日期时间
	 * @return
	 */
	public static FDateTime getServerDateTime(){
		TimeService ts=(TimeService)ServiceFinder.find(TimeService.class.getName());
		return  ts.getUFDateTime();
	}
}
