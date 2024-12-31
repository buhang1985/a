package iih.ci.ord.s.bp.cfg.rulecfg.rule.lis;

import iih.ci.ord.orsms.d.CiLisOrInfo4Sms;
import iih.ci.ord.orsms.d.CiLisOrSmsIoDTO;

/**
 * 按照标本采集时间进行检验分单
 * @author HUMS
 *
 */
public class SplitBySampColTime extends AbstractLisSplitRuleExecutor{

	@Override
	protected String getIdentification(CiLisOrInfo4Sms ciLisOrInfo4Sms) {
		// TODO Auto-generated method stub
		return ciLisOrInfo4Sms.getOrlisapdo().getId_sampcoltime();
	}

	@Override
	protected boolean isConformToTheRules(CiLisOrInfo4Sms ciLisOrInfo4Sms) {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * 设置标本采集时长
	 */
	@Override
	protected void setRuleVal(CiLisOrSmsIoDTO ciLisOrSmsIo, CiLisOrInfo4Sms ciLisOrInfo4Sms) {

		ciLisOrSmsIo.setId_sampcoltime(ciLisOrInfo4Sms.getOrlisapdo().getId_sampcoltime());
	}

}
