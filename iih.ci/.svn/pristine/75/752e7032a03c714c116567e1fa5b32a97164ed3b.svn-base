package iih.ci.ord.s.bp.cfg.rulecfg.rule.lis;

import iih.ci.ord.orsms.d.CiLisOrInfo4Sms;
import iih.ci.ord.orsms.d.CiLisOrSmsIoDTO;

/**
 * 设置检验申请信息不允许在拆分
 * 
 * @author HUMS
 *
 */
public class RefusedLisSplit extends AbstractLisSplitRuleExecutor {

	@Override
	protected String getIdentification(CiLisOrInfo4Sms ciLisOrInfo4Sms) {
		return null;
	}

	@Override
	protected boolean isConformToTheRules(CiLisOrInfo4Sms ciLisOrInfo4Sms) {

		if (!super.isMatchedCfgSdSamptp(this.cfgJsonResult, ciLisOrInfo4Sms.getOrlisapdo().getSd_samptp())) {
			return false;
		}

		if (!super.isMatchedCfgSrvca(this.cfgJsonResult, ciLisOrInfo4Sms.getOrlisapdo().getCode_srvca())) {
			return false;
		}

		return true;
	}

	/**
	 * 当服务配置条件时，检验申请信息不可在拆分
	 */
	@Override
	protected void setRuleVal(CiLisOrSmsIoDTO ciLisOrSmsIo, CiLisOrInfo4Sms ciLisOrInfo4Sms) {
		ciLisOrSmsIo.setFg_apprule("N");
	}

}
