package iih.ci.ord.s.bp.cfg.rulecfg.rule.lis;

import iih.ci.ord.orsms.d.CiLisOrInfo4Sms;
import iih.ci.ord.orsms.d.CiLisOrSmsIoDTO;

/**
 * 按照标本类型进行检验分单
 * @author HUMS
 *
 */
public class SplitBySample extends AbstractLisSplitRuleExecutor{

	/**
	 * 返回标本类型id
	 */
	@Override
	protected String getIdentification(CiLisOrInfo4Sms ciLisOrInfo4Sms) {
		
		return ciLisOrInfo4Sms.getOrlisapdo().getId_samptp();
	}

	/**
	 * 判断是否符合规则
	 */
	@Override
	protected boolean isConformToTheRules(CiLisOrInfo4Sms ciLisOrInfo4Sms) {
		
		return true;
	}

	/**
	 * 设置标本类型id ，编码
	 */
	@Override
	protected void setRuleVal(CiLisOrSmsIoDTO ciLisOrSmsIo, CiLisOrInfo4Sms ciLisOrInfo4Sms) {

		ciLisOrSmsIo.setId_samptp(ciLisOrInfo4Sms.getOrlisapdo().getId_samptp());
		ciLisOrSmsIo.setSd_samptp(ciLisOrInfo4Sms.getOrlisapdo().getSd_samptp());
	}

}
