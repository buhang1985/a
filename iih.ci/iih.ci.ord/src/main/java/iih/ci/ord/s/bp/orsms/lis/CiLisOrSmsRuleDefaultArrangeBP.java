package iih.ci.ord.s.bp.orsms.lis;

import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ci.ord.cfg.cirulecfg.d.RuleCheckPoint;
import iih.ci.ord.cfg.cirulecfg.d.RuleType;
import iih.ci.ord.cfg.cirulecfg.d.RuleUseScope;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.cfg.rulecfg.meta.RuleCfgParamDTO;
import iih.ci.ord.i.orsms.ICiLisOrSmsRule;
import iih.ci.ord.i.orsms.ICiLisOrSmsRuleArrange;
import iih.ci.ord.orsms.d.CiLisOrSmsIoDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.cfg.rulecfg.AbstractRuleExecutor;
import iih.ci.ord.s.bp.cfg.rulecfg.RuleCfgChainFacory;
import iih.ci.ord.s.bp.orsms.lis.rule.CiLisOrSmsMpDeptRule;
import iih.ci.ord.s.bp.orsms.lis.rule.CiLisOrSmsSampColTimeRule;
import iih.ci.ord.s.bp.orsms.lis.rule.CiLisOrSmsSamptpAndSrvCaRule;
import xap.mw.core.data.BizException;

/**
 * 临床检验医嘱分合单规则编排操作BP 产品公司默认的
 */
public class CiLisOrSmsRuleDefaultArrangeBP implements ICiLisOrSmsRuleArrange {

	@Override
	public List<CiLisOrSmsIoDTO> exec(CiEnContextDTO ctx, List<CiLisOrSmsIoDTO> lisorlist) throws BizException {

		// 空判断
		if (CiOrdUtils.isEmpty(lisorlist))
			return null;
		

		RuleCfgParamDTO ruleCfgParam = new RuleCfgParamDTO();
		
		ruleCfgParam.setCode_entp(ctx.getCode_entp());
		ruleCfgParam.setRule_type(RuleType.MERGE_LIS);
		ruleCfgParam.setCheck_point(RuleCheckPoint.SIGN);
		if(IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(ctx.getCode_entp())
				||IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(ctx.getCode_entp())
				||IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(ctx.getCode_entp())){
			ruleCfgParam.setUse_scope(RuleUseScope.RULE_USE_OP);
		}else if(IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(ctx.getCode_entp())
				||IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(ctx.getCode_entp())){
			ruleCfgParam.setUse_scope(RuleUseScope.RULE_USE_IP);
		}
		
		RuleCfgChainFacory<List<CiLisOrSmsIoDTO>> ruleCfgChainFacory = new RuleCfgChainFacory<List<CiLisOrSmsIoDTO>>();
		AbstractRuleExecutor<List<CiLisOrSmsIoDTO>> ruleExecutor = ruleCfgChainFacory.getRuleChain(ruleCfgParam);
		List<CiLisOrSmsIoDTO> list2 = ruleExecutor.startExecuteRule(lisorlist);
		return list2;

		// 标本类型与检验分类复合合单规则
		/*lisorlist = SamptpAndSrvcaSmsIoRule(lisorlist);
		
		lisorlist = SmsSampColTimeRule(lisorlist);
		
		lisorlist = SmsMpDeptRule(lisorlist);
  
		return lisorlist;*/

	}

	/**
	 * 临床医嘱合单规则：标本类型检验分类合单规则合单
	 * 
	 * @param orsmsiolist
	 * @return
	 * @throws BizException
	 */
	private List<CiLisOrSmsIoDTO> SamptpAndSrvcaSmsIoRule(List<CiLisOrSmsIoDTO> orsmsiolist) throws BizException {
		ICiLisOrSmsRule rule = new CiLisOrSmsSamptpAndSrvCaRule();
		return rule.exec(orsmsiolist);
	}
	
	/**
	 * 临床医嘱合单规则：标本类型检验分类合单规则合单
	 * 
	 * @param orsmsiolist
	 * @return
	 * @throws BizException
	 */
	private List<CiLisOrSmsIoDTO> SmsSampColTimeRule(List<CiLisOrSmsIoDTO> orsmsiolist) throws BizException {
		ICiLisOrSmsRule rule = new CiLisOrSmsSampColTimeRule();
		return rule.exec(orsmsiolist);
	}
	
	/**
	 * 临床医嘱合单规则：标本类型检验分类合单规则合单
	 * 
	 * @param orsmsiolist
	 * @return
	 * @throws BizException
	 */
	private List<CiLisOrSmsIoDTO> SmsMpDeptRule(List<CiLisOrSmsIoDTO> orsmsiolist) throws BizException {
		ICiLisOrSmsRule rule = new CiLisOrSmsMpDeptRule();
		return rule.exec(orsmsiolist);
	}

}
