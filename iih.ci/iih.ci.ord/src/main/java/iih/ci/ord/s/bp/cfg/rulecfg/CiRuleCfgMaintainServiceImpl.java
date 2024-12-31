package iih.ci.ord.s.bp.cfg.rulecfg;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.ci.ord.cfg.cirulecfg.d.CiRuleCfg;
import iih.ci.ord.cfg.cirulecfg.d.RuleCheckPoint;
import iih.ci.ord.cfg.cirulecfg.d.RuleType;
import iih.ci.ord.cfg.cirulecfg.i.ICirulecfgMDORService;
import iih.ci.ord.i.cfg.rulecfg.ICiRuleCfgMaintainService;
import iih.ci.ord.i.cfg.rulecfg.meta.RuleCfgParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 规则校验维护实现类
 * 
 * @author HUMS
 *
 */
public class CiRuleCfgMaintainServiceImpl implements ICiRuleCfgMaintainService {

	
	@Override
	public List<CiRuleCfg> getRuleCfgs(RuleCfgParamDTO ruleCfgParam) throws BizException {

		String id_org = Context.get().getOrgId();
		String id_grp = Context.get().getGroupId();

		if(StringUtils.isEmpty(ruleCfgParam.getId_org())){
			ruleCfgParam.setId_org(id_org);
			ruleCfgParam.setId_grp(id_grp);
		}
		
		StringBuffer whereBuffer = new StringBuffer();

		ICirulecfgMDORService ciRuleCfgRService = (ICirulecfgMDORService) ServiceFinder.find(ICirulecfgMDORService.class);

		whereBuffer.append(" id_org = '" + ruleCfgParam.getId_org() + "'");
		whereBuffer.append(" and id_grp = '" + ruleCfgParam.getId_grp() + "'");		

		if (StringUtils.isNotEmpty(ruleCfgParam.getCode_entp())) {
			whereBuffer.append(" and code_entp = '" + ruleCfgParam.getCode_entp() + "'");
		}
		if (StringUtils.isNotEmpty(ruleCfgParam.getCheck_point())) {
			whereBuffer.append(" and check_point = '" + ruleCfgParam.getCheck_point() + "'");
		}
		whereBuffer.append(" and rule_type = '" + ruleCfgParam.getRule_type() + "'");
		if (StringUtils.isNotEmpty(ruleCfgParam.getUse_scope())) {
			whereBuffer.append(" and use_scope = '" + ruleCfgParam.getUse_scope() + "'");
		}

		whereBuffer.append(" and fg_active = '" + FBoolean.TRUE + "'");

		CiRuleCfg[] ciRuleCfg = ciRuleCfgRService.find(whereBuffer.toString(), "sortno", FBoolean.FALSE);

		return Arrays.asList(ciRuleCfg);
	}

	/**
	 * 获取合单规则
	 */
	@Override
	public CiRuleCfg getMergeRuleCfg() throws BizException {

		return new CiRuleCfg();
	}

	/**
	 * 获取分方规则
	 */
	@Override
	public List<CiRuleCfg> getSplitPresRuleCfgs(String code_entp) throws BizException {

		RuleCfgParamDTO ruleCfgParam = new RuleCfgParamDTO();
		ruleCfgParam.setCheck_point(RuleType.MERGE_PRES);
		ruleCfgParam.setCode_entp(code_entp);

		return this.getRuleCfgs(ruleCfgParam);
	}

	@Override
	public List<CiRuleCfg> getExcessiveReasonCfgs(String code_entp) throws BizException {

		RuleCfgParamDTO ruleCfgParam = new RuleCfgParamDTO();
		ruleCfgParam.setCheck_point(RuleCheckPoint.EXCESSIVE);
		ruleCfgParam.setCode_entp(code_entp);
		return this.getRuleCfgs(ruleCfgParam);
	}

}
