package iih.ci.ord.s.bp.cfg.rulecfg.rule.lis;

import iih.ci.ord.orsms.d.CiLisOrInfo4Sms;
import iih.ci.ord.orsms.d.CiLisOrSmsIoDTO;

/**
 * 生成检验分单中注意事项
 * @author HUMS
 *
 */
public class SplitLisNotices extends AbstractLisSplitRuleExecutor{

	@Override
	protected String getIdentification(CiLisOrInfo4Sms ciLisOrInfo4Sms) {

		return null;
	}

	@Override
	protected boolean isConformToTheRules(CiLisOrInfo4Sms ciLisOrInfo4Sms) {
		
		
		if(!super.isMatchedCfgSdSamptp(this.cfgJsonResult, ciLisOrInfo4Sms.getOrlisapdo().getSd_samptp())){
			return false;
		}
		
		if(!super.isMatchedCfgSrvca(this.cfgJsonResult, ciLisOrInfo4Sms.getOrlisapdo().getCode_srvca())){
			return false;
		}
		
		return true;
	}

	@Override
	protected void setRuleVal(CiLisOrSmsIoDTO ciLisOrSmsIo, CiLisOrInfo4Sms ciLisOrInfo4Sms) {
		
		ciLisOrSmsIo.setAnnouncements(this.cfgJsonResult.getString("notice"));
	}

}
