package iih.ci.ord.s.bp.cfg.rulecfg.rule.lis;

import iih.ci.ord.orsms.d.CiLisOrInfo4Sms;
import iih.ci.ord.orsms.d.CiLisOrSmsIoDTO;

/**
 * 按医嘱进行检验分单
 * 
 * @author HUMS
 *
 */
public class SplitByIdOr extends AbstractLisSplitRuleExecutor {

	@Override
	protected String getIdentification(CiLisOrInfo4Sms ciLisOrInfo4Sms) {

		return ciLisOrInfo4Sms.getOrdo().getId_or();
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

	@Override
	protected void setRuleVal(CiLisOrSmsIoDTO ciLisOrSmsIo, CiLisOrInfo4Sms ciLisOrInfo4Sms) {

		ciLisOrSmsIo.setId_or(ciLisOrInfo4Sms.getOrdo().getId_or());
	}

}
