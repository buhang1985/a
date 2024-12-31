package iih.en.pv.s.bp.op;

import iih.en.comm.IEnRuleConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.ResultDTO;
import iih.en.pv.outpatient.dto.d.RegRuleDTO;
import iih.en.pv.s.rule.CheckMvelRuleResultPro;
import iih.pi.reg.pat.d.PatDO;

import java.util.HashMap;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 调用挂号规则引擎（医保患者挂号规则+门诊挂号规则）
 * 
 * @author fanlq
 *
 */
public class CheckRegMvelBP {
	
	/**
	 * 门诊挂号规则引擎调用
	 * 
	 * @author liubin
	 * 
	 * @param regRuleDto
	 * @return
	 * @throws BizException
	 */
	public ResultDTO exec(RegRuleDTO regRule) throws BizException {
		//1.查找患者
		PatDO patDo =null;
		if(!EnValidator.isEmpty(regRule.getId_pat())){
			patDo = (PatDO) new DAFacade().findByPK(PatDO.class, regRule.getId_pat());
		}
		//2.验证队列
		ResultDTO res = new IsMatchRuleBP().exec(patDo,regRule.getId_sch(),regRule.getId_patca(),regRule.getDt_birth(),regRule.getId_sex(),regRule.getId_que());	
		if(FBoolean.FALSE.equals(res.getFlag())){
			return res;
		}
		if(EnValidator.isEmpty(regRule.getId_pat())){
			return res;
		}
		if(patDo == null)
			throw new BizException("规则引擎：患者信息不能为空！");
		if (!EnValidator.isEmpty(regRule.getRegdate())) {
			FDateTime dateTime = EnAppUtils.getFDateTime(new FDate(regRule.getRegdate()).asBegin(), new FTime("00:00:00"));
			regRule.setRegdate(dateTime.toStdString());
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(PatDO.class.getSimpleName(), patDo);
		map.put(RegRuleDTO.class.getSimpleName(), regRule);
		if(!EnValidator.isEmpty(regRule.getId_hp())){
			ResultDTO result = CheckMvelRuleResultPro.check(IEnRuleConst.EN_HP_REG_RULEPK_CONST, map);
			if(result != null && FBoolean.FALSE.equals(result.getFlag())){
		    	return result;
		    }
		}
		return CheckMvelRuleResultPro.check(IEnRuleConst.EN_REG_REGRULEPKG_CONST, map);
	}
	/**
	 * 只走医保校验规则
	 * 
	 * @author liubin
	 * 
	 * @param regRuleDto
	 * @return
	 * @throws BizException
	 */
	public ResultDTO execHp(RegRuleDTO regRule) throws BizException{
		PatDO patDo = (PatDO) new DAFacade().findByPK(PatDO.class, regRule.getId_pat()); 
		if(patDo == null)
			throw new BizException("规则引擎：患者信息不能为空！");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(PatDO.class.getSimpleName(), patDo);
		map.put(RegRuleDTO.class.getSimpleName(), regRule);
		return CheckMvelRuleResultPro.check(IEnRuleConst.EN_HP_REG_RULEPK_CONST, map);
	}
}
