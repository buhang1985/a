package iih.sc.scbd.s.bp;

import iih.sc.scbd.scapptrule.d.ScapptruleDO;
import iih.sc.scbd.scapptrule.i.IScapptruleRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取预约规则类型code
 * @author zhouliming
 */
public class GetScRuleTpBp {
	
	/**
	 * 获取预约规则类型code
	 * @param id_scrule
	 * @return
	 * @throws BizException 
	 */
	public String exec(String id_scrule) throws BizException{
		IScapptruleRService service = ServiceFinder.find(IScapptruleRService.class);
		ScapptruleDO scapptruleDO = service.findById(id_scrule);
		if(scapptruleDO == null) return null;
		return scapptruleDO.getSd_schrule();
	}
}
