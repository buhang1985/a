package iih.pi.reg.s.bp;

import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.s.PatiMDOCrudServiceImpl;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;

/**
 * 写入病案编码逻辑类
 * @author ly
 *
 */
public class PiPatInsertAmrCodeBP {

	/**
	 * 写入病案编码
	 * @param patId 患者id
	 * @param amrCode 门诊病案编号
	 * @param ifOp 是否门诊
	 * @return true:成功 false:失败
	 * @throws BizException
	 */
	public FBoolean exec(String patId,String amrCode,boolean ifOp) throws BizException{
	
		if(StringUtil.isEmpty(patId) || StringUtil.isEmpty(amrCode))
			return FBoolean.FALSE;
		
		PatiMDOCrudServiceImpl patiService = new PatiMDOCrudServiceImpl();
		PatDO pat = patiService.findById(patId);
		
		if(pat == null){
			throw new BizException("该患者不存在 患者id:" + patId);
		}
		
		if(ifOp){
			if(!StringUtil.isEmpty(pat.getCode_amr_oep())){
				throw new BizException("该患者的门诊病案编码已经存在");
			}
			pat.setCode_amr_oep(amrCode);
			
		}else{
			if(!StringUtil.isEmpty(pat.getCode_amr_ip())){
				throw new BizException("该患者的住院病案编码已经存在");
			}
			pat.setCode_amr_ip(amrCode);
		}
		
		pat.setStatus(DOStatus.UPDATED);
		
		patiService.update(pat);
		return FBoolean.TRUE;
	}
}
