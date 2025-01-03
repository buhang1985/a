package iih.mi.mc.i;

import iih.mi.mc.dto.mimcdidependrule.d.MiMcDiDependInParamDTO;
import iih.mi.mc.dto.mimcdidependrule.d.MiMcDiDependOutParamDTO;
import iih.mi.mc.dto.mimcindicationrule.d.MiMcIndicationInParamDTO;
import iih.mi.mc.dto.mimcindicationrule.d.MiMcIndicationOutParamDTO;
import iih.mi.mc.dto.mimcspecdrug.d.MiMcSpecDrugInDTO;
import iih.mi.mc.dto.mimcspecdrug.d.MiMcSpecDrugOutDTO;
import iih.mi.mc.dto.mimcwholerule.d.MiMcWholeRuleInParamDTO;
import iih.mi.mc.dto.mimcwholerule.d.MiMcWholeRuleOutParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;

/**
 * 医保校验接口服务
 * @author LIM
 * @since 2019-10-11
 */
public interface IMiMcRuleService {
	
	/**
	 * 医保整体开单校验
	 * @param inParamDto
	 * @return
	 * @throws BizException
	 */
	public abstract MiMcWholeRuleOutParamDTO checkWholeRule(MiMcWholeRuleInParamDTO inParamDto) throws BizException;
	
	/**
	 * 医保适应症校验
	 * @param inparam
	 * @return
	 * @throws BizException
	 */
	public abstract MiMcIndicationOutParamDTO[] checkIndicationRule(MiMcIndicationInParamDTO[] inparam) throws BizException;
	
	/**
	 * 诊断依赖校验
	 * @param inParamDTO
	 * @return
	 * @throws BizException
	 */
	public abstract MiMcDiDependOutParamDTO[] checkDiDependRule(MiMcDiDependInParamDTO inParamDTO) throws BizException;
	
	/**
	 * 诊断范围判断
	 * @param hpId 医保id
	 * @param entpCode 就诊code
	 * @param diIds 诊断id集合
	 * @return
	 * @throws BizException
	 */
	public abstract FMap checkDiScopeRule(String hpId, String entpCode, String[] diIds) throws BizException;
	
	/**
	 * 判定是否医保特殊病	 
	 * @param hpId 医保计划ID
	 * @param patId 患者ID
	 * @param diDefIds 诊断ID集合
	 * @return fmap,[key:诊断ID,value:FBoolean]
	 * @throws BizException
	 */
	public abstract FMap isPatSpecDi(String hpId,String patId,String[] diDefIds) throws BizException;
	
	/**
	 * 是否特殊病患者
	 * @param hpId 医保计划id
	 * @param hpNo 医保号
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean isSpecDiPat(String hpId,String hpNo) throws BizException;
	
	/**
	 * 判断是否为医保特殊病药品 
	 * @param miMcSpecDrugInDTO 入参
	 * @return MiMcSpecDrugOutDTO
	 * @throws BizException
	 */
	public abstract MiMcSpecDrugOutDTO[] isPatSpecDrug(MiMcSpecDrugInDTO miMcSpecDrugInDTO) throws BizException;
	
	/**
	 * 获取特殊病患者的病种信息
	 * @param hpId 医保计划id
	 * @param hpNo 医保号
	 * @param patId 患者id
	 * @return
	 * @throws BizException
	 */
	public abstract String getSpecInfoPat(String hpId,String hpNo,String patId) throws BizException;
	
}
