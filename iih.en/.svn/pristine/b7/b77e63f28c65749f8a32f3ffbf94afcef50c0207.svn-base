package iih.en.ip.s.bp.qry;

import iih.en.pv.enres.d.EnBedDO;
import iih.en.pv.enres.i.IEnbedRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 床位
 * @author zhangpp
 *
 */
public class EntBedEP {
	
	/**
	 * 获取床位使用记录
	 * @param entId 患者id
	 * @return
	 * @throws BizException
	 */
	public EnBedDO[] getRentBedList(String entId) throws BizException{
		IEnbedRService enBedRService = ServiceFinder.find(IEnbedRService.class);
		String whereStr = String.format("ID_ENT='%s'",entId);
		String orderStr = "DT_E DESC"; //按使用开始时间倒序排列
		return enBedRService.find(whereStr, orderStr, FBoolean.FALSE);
	}

}
