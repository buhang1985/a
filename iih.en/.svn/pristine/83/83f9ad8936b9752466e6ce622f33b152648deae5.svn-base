package iih.en.pv.s.bp.op;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;

public class GetRegListByEntBP {

	/**
	 * 检索患者挂号信息
	 * @param patId 患者id
	 * @param withPri　包含价格信息
	 * @return
	 * @throws BizException
	 */
	public RegInfoDTO[] exec(String[] entIds, FBoolean withPri, FDate bDate, FDate eDate) throws BizException{
		//1、查询挂号信息
		GetRegInfoListBP getBP =new GetRegInfoListBP();
		RegInfoDTO[] regInfos = getBP.exec(entIds);
		if(EnValidator.isEmpty(regInfos)){
			return null;
		}
		return new GetPatsRegListBP().decorateRegInfo4CancReg(regInfos[0].getId_pat(),regInfos, withPri);
	}
}
