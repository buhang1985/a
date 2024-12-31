package iih.en.pv.s.bp.ip.qry;

import iih.en.comm.ep.EntBedEP;
import iih.en.pv.enres.d.EnBedDO;
import xap.mw.core.data.BizException;

/**
 * 获取床位使用记录
 * @author renying
 *
 */
public class GetUsedBedListBP {

	/**
	 * 获取床位使用记录
	 * @param entId 患者id
	 * @return
	 * @throws BizException
	 */
	public EnBedDO[] getUsedBedList(String entId) throws BizException{
//		IEnbedRService enBedRService = ServiceFinder.find(IEnbedRService.class);
//		String whereStr = String.format("ID_ENT='%s'",entId);
//		String orderStr = "DT_B DESC"; //按使用开始时间倒序排列
		EntBedEP entBedEP = new EntBedEP();
		EnBedDO[] enBedDOArray = entBedEP.getUsedBedList(entId); //= enBedRService.find(whereStr, orderStr, FBoolean.FALSE);		
		return enBedDOArray;
	}

}
