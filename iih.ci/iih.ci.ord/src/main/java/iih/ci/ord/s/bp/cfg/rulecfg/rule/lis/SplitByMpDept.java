package iih.ci.ord.s.bp.cfg.rulecfg.rule.lis;

import iih.ci.ord.orsms.d.CiLisOrInfo4Sms;
import iih.ci.ord.orsms.d.CiLisOrSmsIoDTO;

/**
 * 按照执行科室进行检验分单
 * @author HUMS
 *
 */
public class SplitByMpDept extends AbstractLisSplitRuleExecutor{

	@Override
	protected String getIdentification(CiLisOrInfo4Sms ciLisOrInfo4Sms) {
		// TODO Auto-generated method stub
		return ciLisOrInfo4Sms.getOrdo().getId_dep_mp();
	}

	@Override
	protected boolean isConformToTheRules(CiLisOrInfo4Sms ciLisOrInfo4Sms) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected void setRuleVal(CiLisOrSmsIoDTO ciLisOrSmsIo, CiLisOrInfo4Sms ciLisOrInfo4Sms) {
		ciLisOrSmsIo.setId_dep_mp(ciLisOrInfo4Sms.getOrdo().getId_dep_mp());
	}
}
