package iih.ci.ord.s.bp.cfg.rulecfg.rule.lis;

import iih.ci.ord.orsms.d.CiLisOrInfo4Sms;
import iih.ci.ord.orsms.d.CiLisOrSmsIoDTO;


/**
 * 按照医嘱id进行检验分单<br>
 * 一条检验医嘱一个申请单
 * 
 * @author HUMS
 *
 */
public class SplitLisByIdOr extends AbstractLisSplitRuleExecutor {

	@Override
	protected String getIdentification(CiLisOrInfo4Sms ciLisOrInfo4Sms) {

		return ciLisOrInfo4Sms.getOrdo().getId_or();
	}

	@Override
	protected boolean isConformToTheRules(CiLisOrInfo4Sms ciLisOrInfo4Sms) {
		return true;
	}

	@Override
	protected void setRuleVal(CiLisOrSmsIoDTO ciLisOrSmsIo, CiLisOrInfo4Sms ciLisOrInfo4Sms) {

	}

}
