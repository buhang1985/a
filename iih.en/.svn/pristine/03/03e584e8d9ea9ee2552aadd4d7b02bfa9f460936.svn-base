package iih.en.pv.s.bp.ip;

import iih.en.pv.dto.d.LvHosAppDTO;
import iih.en.pv.s.bp.ip.qry.GetLvHosDTOArrayBP;
import xap.mw.core.data.BizException;

/**
 * 出院检查BP
 * 
 * @author jizb
 *
 */
public class CheckAppBp {

	/**
	 * 出院检查
	 * 
	 * @param idEnts 就诊ID
	 * @return
	 * @throws BizException 
	 */

	public LvHosAppDTO[] exec(String[] idEnts) throws BizException {
		if (null == idEnts || idEnts.length == 0) {
			return null;
		}
		GetLvHosDTOArrayBP bp = new GetLvHosDTOArrayBP();
		LvHosAppDTO[] appDTOs = bp.exec(idEnts); //0133979 lilei 
		//检查
		LvHosCheckBP checkBP = new LvHosCheckBP();		
		checkBP.exec(appDTOs);
		return appDTOs;
	}
}
