package iih.bl.cg.s.cglogic.validator;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bl.cg.dto.cglogic.d.BlCgOpAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.OepCgModeEnum;
import iih.bl.st.blauditip.d.BlAuditIp;
import iih.en.pv.enfee.d.EnAccountDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.acc.account.d.PiPatAccDO;
import iih.pi.reg.pat.d.PatDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 可记账校验器
 * @author ly 2018/06/26
 *
 */
public class BlCgAccAbleValidator {

	/**
	 * 可记账校验
	 * @param enDO 就诊数据
	 * @param enAccDO 就诊账户数据
	 * @param auditDO 住院审核数据
	 * @param canAccWhenAudit 住院审核期间，是否允许修改费用明细
	 * @throws BizException
	 */
	public void validate(PatiVisitDO enDO,EnAccountDO enAccDO,BlAuditIp auditDO,FBoolean canAccWhenAudit) throws BizException{
		
		if(FBoolean.TRUE.equals(enDO.getFg_st())){
			throw new BizException(enDO.getName_pat()+":患者已经出院结算，禁止执行与费用有关的操作！");
		}
		
		if(FBoolean.TRUE.equals(enAccDO.getFg_freeze())){
			throw new BizException(enDO.getName_pat()+":患者的费用已经封账，禁止执行与费用有关的操作！");
		}
		
		if(FBoolean.FALSE.equals(canAccWhenAudit)){
			if (auditDO != null && (FBoolean.TRUE.equals(auditDO.getFg_pass_clinic()) 
							|| FBoolean.TRUE.equals(auditDO.getFg_pass_hp()))) {
				throw new BizException(enDO.getName_pat()+":患者的费用正在审核结算流程中，禁止执行与费用有关的操作！");
			}
		}
	}
	
	/**
	 * 可记账校验(患者账户)
	 * @param patAccDO 患者账户数据
	 * @param accSetDto 记账配置
	 * @throws BizException
	 */
	public void validate(PatDO patDO, PiPatAccDO patAccDO, BlCgOpAccountSetDTO accSetDto) throws BizException{
		
		if(!OepCgModeEnum.PREPAY_CG.equals(accSetDto.getEu_oepcgmode()))
			return;
		
		if(IPiDictCodeConst.SD_ACCSTA_FREEZE.equals(patAccDO.getSd_accsta())){
			throw new BizException(patDO.getName() + ":患者账户被冻结，无法进行预交金记账操作！");
		}	
	}
	
	/**
	 * 可记账校验(患者账户急诊)
	 * @param patAccDO 患者账户数据
	 * @param accSetDto 记账配置
	 * @throws BizException
	 */
	public void validateEt(PatDO patDO, PiPatAccDO patAccDO) throws BizException{
		
		if(IPiDictCodeConst.SD_ACCSTA_FREEZE.equals(patAccDO.getSd_accsta())){
			throw new BizException(patDO.getName() + ":患者账户被冻结，无法进行预交金记账操作！");
		}	
	}
}
