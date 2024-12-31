package iih.ci.ord.s.bp.cfg.rulecfg.rule.lis;

import iih.ci.ord.orsms.d.CiLisOrInfo4Sms;
import iih.ci.ord.orsms.d.CiLisOrSmsIoDTO;
import iih.ci.ord.s.bp.cfg.RuleCfgConstant;

/**
 * 按照服务分类进行检验分单
 * @author HUMS
 *
 */
public class SplitBySrvca extends AbstractLisSplitRuleExecutor{

	@Override
	protected String getIdentification(CiLisOrInfo4Sms ciLisOrInfo4Sms) {
		
		return this.cfgJsonResult.getString(RuleCfgConstant.CODE_SRVCA);
	}

	@Override
	protected boolean isConformToTheRules(CiLisOrInfo4Sms ciLisOrInfo4Sms) {
		
		String code_srvca = ciLisOrInfo4Sms.getOrlisapdo().getCode_srvca();
		
		if(super.isMatchedCfgSrvca(this.cfgJsonResult, code_srvca)){
			return true;
		}
		return false;
	}

	@Override
	protected void setRuleVal(CiLisOrSmsIoDTO ciLisOrSmsIo, CiLisOrInfo4Sms ciLisOrInfo4Sms) {
		
		Object codeSrvcaObj = this.cfgJsonResult.get(RuleCfgConstant.CODE_SRVCA);
		ciLisOrSmsIo.setId_srvca(codeSrvcaObj.toString());
	}
	
}
