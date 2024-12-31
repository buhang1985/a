package iih.en.pv.s.bp.op.st;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 批量加载挂号结算信息
 * @author yank
 *
 */
public class BatchLoadCgInfoBP {
	/**
	 * 加载结算信息
	 * 1、加载价格信息
	 * 2、加载发票信息
	 * 3、加载医保流水号
	 *  
	 * @param regInfo
	 */
	public RegInfoDTO[] exec(RegInfoDTO[] regInfos) throws BizException {
		EnValidator.validateParam("挂号信息", regInfos);
		LoadCgInfoBP loadCgBP = new LoadCgInfoBP();
		for(RegInfoDTO regInfo : regInfos){
			if(FBoolean.TRUE.equals(regInfo.getFg_cg())){
				loadCgBP.exec(regInfo);
			}
		}
		return regInfos;
	}
}
