package iih.mi.mc.s;

import iih.mi.mc.dto.mimcdidependrule.d.MiMcDiDependInParamDTO;
import iih.mi.mc.dto.mimcdidependrule.d.MiMcDiDependOutParamDTO;
import iih.mi.mc.dto.mimcindicationrule.d.MiMcIndicationInParamDTO;
import iih.mi.mc.dto.mimcindicationrule.d.MiMcIndicationOutParamDTO;
import iih.mi.mc.dto.mimcspecdrug.d.MiMcSpecDrugInDTO;
import iih.mi.mc.dto.mimcspecdrug.d.MiMcSpecDrugOutDTO;
import iih.mi.mc.dto.mimcwholerule.d.MiMcWholeRuleInParamDTO;
import iih.mi.mc.dto.mimcwholerule.d.MiMcWholeRuleOutParamDTO;
import iih.mi.mc.i.IMiMcRuleService;
import iih.mi.mc.s.bp.CheckIsPatDiBP;
import iih.mi.mc.s.bp.GetMiMcSpecInfoBP;
import iih.mi.mc.s.bp.MiIsSpecDrugBP;
import iih.mi.mc.s.bp.MiIsSpecPatBP;
import iih.mi.mc.s.ctrlcore.mimcdidependcheck.rule.MiDiDependCheckRule;
import iih.mi.mc.s.ctrlcore.mimcdiscopecheck.rule.MiMcDiScopeCheckRule;
import iih.mi.mc.s.ctrlcore.mimcindicationcheck.rule.MiIndicationCheckRule;
import iih.mi.mc.s.ctrlcore.mimcwholecheck.rule.MiWholeCheckRule;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
/**
 * 医保校验接口服务
 * @author LIM
 * @since 2019-10-11
 */
@Service(serviceInterfaces = { IMiMcRuleService.class }, binding = Binding.JSONRPC)
public class IMiMcRuleServiceImpl  implements IMiMcRuleService{

	/**
	 * 医保整体开单校验
	 * @param inParamDto
	 * @return
	 * @throws BizException
	 */
	@Override
	public MiMcWholeRuleOutParamDTO checkWholeRule(MiMcWholeRuleInParamDTO inParamDto) throws BizException {
		MiWholeCheckRule bp= new MiWholeCheckRule();
		return bp.exec(inParamDto);
	}

	/**
	 * 医保适应症校验
	 * @param inparam
	 * @return
	 * @throws BizException
	 */
	@Override
	public MiMcIndicationOutParamDTO[] checkIndicationRule(MiMcIndicationInParamDTO[] inparam) throws BizException {
		MiIndicationCheckRule bp = new MiIndicationCheckRule();
		return bp.exec(inparam);
	}

	/**
	 * 诊断依赖校验
	 * @param inParamDTO
	 * @return
	 * @throws BizException
	 */
	@Override
	public MiMcDiDependOutParamDTO[] checkDiDependRule(MiMcDiDependInParamDTO inParamDTO) throws BizException {
		MiDiDependCheckRule bp = new MiDiDependCheckRule();
		return bp.exec(inParamDTO);
	}

	/**
	 * 诊断范围判断
	 * @param hpId 医保id
	 * @param entpCode 就诊code
	 * @param diIds 诊断id集合
	 * @return
	 * @throws BizException
	 */
	@Override
	public FMap checkDiScopeRule(String hpId, String entpCode, String[] diIds) throws BizException {
		MiMcDiScopeCheckRule bp= new MiMcDiScopeCheckRule();
		return bp.exec(hpId, entpCode, diIds);
	}

	/**
	 * 判定是否医保特殊病	 
	 * @param hpId 医保计划ID
	 * @param patId 患者ID
	 * @param diDefIds 诊断ID集合
	 * @return fmap,[key:诊断ID,value:FBoolean]
	 * @throws BizException
	 */
	@Override
	public FMap isPatSpecDi(String hpId,String patId,String[] diDefIds) throws BizException{
		CheckIsPatDiBP checkBP = new CheckIsPatDiBP();
		return checkBP.exec(hpId, patId, diDefIds);
	}

	/**
	 * 判断是否特殊病患者
	 * @param hpId 医保计划id
	 * @param hpNo 医保号
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean isSpecDiPat(String hpId, String hpNo) throws BizException {
		MiIsSpecPatBP bp = new MiIsSpecPatBP();
		return bp.exec(hpId, hpNo);
	}
	
	/**
	 * 判断是否为医保特殊病药品 
	 * @param miMcSpecDrugInDTO 入参
	 * @return MiMcSpecDrugOutDTO
	 * @throws BizException
	 */
	@Override
	public MiMcSpecDrugOutDTO[] isPatSpecDrug(MiMcSpecDrugInDTO miMcSpecDrugInDTO) throws BizException{
		MiIsSpecDrugBP bp = new MiIsSpecDrugBP();
		return bp.exec(miMcSpecDrugInDTO);
	}
	/**
	 * 获取特殊病患者的病种信息
	 * @param hpId 医保计划id
	 * @param hpNo 医保号
	 * @param patId 患者id
	 * @return
	 * @throws BizException
	 */
	@Override
	public String getSpecInfoPat(String hpId,String hpNo,String patId) throws BizException{
		GetMiMcSpecInfoBP bp = new GetMiMcSpecInfoBP();
		return bp.exec(hpId,hpNo,patId);
	}
}
