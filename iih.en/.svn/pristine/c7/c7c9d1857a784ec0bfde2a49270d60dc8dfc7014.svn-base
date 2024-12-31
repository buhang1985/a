package iih.en.pv.s.bp.ip;

import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取入院时间
 * @author Sarah
 *
 */
@Deprecated
public class GetEnHosTimeBP {
	/**
	 * 获取入院时间
	 * @param entId 就诊id
	 * @return 入院时间
	 * @throws BizException
	 */
	public FDateTime exec(String entId) throws BizException{
		IPativisitRService service = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO pvDO = service.findById(entId);
		if(pvDO!=null){
			return pvDO.getDt_entry();
		}
		
		return null;
	}
}
