package iih.en.pv.s.bp.ip.qry;

import iih.en.comm.ep.EntBedEP;
import iih.en.pv.enres.d.EnBedDO;
import xap.mw.core.data.BizException;

/**
 * 获床位使用列表
 * @author renying
 *
 */
public class GetRentedBedBP {
	/**
	 * 获取床位使用列表
	 * @param entId 患者id
	 * @return
	 * @throws BizException
	 */
	public EnBedDO[] getRentedBedList(String entId) throws BizException{
		EntBedEP entBedEP = new EntBedEP();
		EnBedDO[] enBedDOArray = entBedEP.getUsingBedList(entId) ;		
		return enBedDOArray;
	}
}
