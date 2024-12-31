package iih.ci.ord.s.bp.cfg.rulecfg.rule.lis;

import iih.ci.ord.orsms.d.CiLisOrInfo4Sms;
import iih.ci.ord.orsms.d.CiLisOrSmsIoDTO;

/**
 * 按照是否为特殊病检验进行检验分单
 * @author HUMS
 *
 */
public class SplitLisByFgSpecill extends AbstractLisSplitRuleExecutor{

	@Override
	protected String getIdentification(CiLisOrInfo4Sms ciLisOrInfo4Sms) {
		// TODO Auto-generated method stub
		return ciLisOrInfo4Sms.getFg_specill().toString();
	}

	@Override
	protected boolean isConformToTheRules(CiLisOrInfo4Sms ciLisOrInfo4Sms) {
		return true;
	}

	@Override
	protected void setRuleVal(CiLisOrSmsIoDTO ciLisOrSmsIo, CiLisOrInfo4Sms ciLisOrInfo4Sms) {
		ciLisOrSmsIo.setFg_specill(ciLisOrInfo4Sms.getFg_specill());
	}

}
