package iih.en.pv.s.bp.ip.qry;

import iih.en.comm.util.EnAgeCalcUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.LvHosAppDTO;
import iih.en.pv.s.bp.ip.LvHosCheckBP;
import xap.mw.core.data.BizException;
/**
 *  获取出院申请列表
 * @author renying
 *
 */
public class GetLvHosListBP {
	
	/**
	 * 获取出院申请列表
	 * @param nurId 病区列表
	 * @return
	 * @throws BizException 
	 */
	public LvHosAppDTO[] exec(String nurId) throws BizException {
		return exec(null, nurId);
	}
	/**
	 * 获取出院申请列表
	 * @param nurId 病区列表
	 * @return
	 * @throws BizException 
	 */
	public LvHosAppDTO[] exec(String depId, String nurId) throws BizException {
		//获取出院申请列表
		GetLvHosDTOArrayBP lvHosBP = new GetLvHosDTOArrayBP();		
		LvHosAppDTO[] appDTOArray = lvHosBP.exec(depId, nurId);
		if(EnValidator.isEmpty(appDTOArray))
			return null;
		//设置年龄,从前天移到后台 - zhangpp 2019.05.17
		EnAgeCalcUtil.setDoAges(appDTOArray, "Id_ent", "Age");
		//检查
		LvHosCheckBP checkBP = new LvHosCheckBP();		
		checkBP.exec(appDTOArray);
	
		return appDTOArray;
	}
	
}
