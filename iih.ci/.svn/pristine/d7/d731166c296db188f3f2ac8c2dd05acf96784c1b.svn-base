package iih.ci.ord.s.bp.cfg.rulecfg.rule.lis;

import iih.ci.ord.orsms.d.CiLisOrInfo4Sms;
import iih.ci.ord.orsms.d.CiLisOrSmsIoDTO;
import xap.mw.coreitf.d.FBoolean;

/**
 * 按医保进行检验分单
 * @author HUMS
 *
 */
public class SplitByFgOrHp extends AbstractLisSplitRuleExecutor{

	@Override
	protected String getIdentification(CiLisOrInfo4Sms ciLisOrInfo4Sms) {
		
		return FBoolean.TRUE.equals(ciLisOrInfo4Sms.getOrdo().getFg_orhp()) ? "Y" : "N";
	}

	@Override
	protected boolean isConformToTheRules(CiLisOrInfo4Sms ciLisOrInfo4Sms) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected void setRuleVal(CiLisOrSmsIoDTO ciLisOrSmsIo, CiLisOrInfo4Sms ciLisOrInfo4Sms) {
		
		ciLisOrSmsIo.setFg_orhp(ciLisOrInfo4Sms.getOrdo().getFg_orhp());	
	}

}
