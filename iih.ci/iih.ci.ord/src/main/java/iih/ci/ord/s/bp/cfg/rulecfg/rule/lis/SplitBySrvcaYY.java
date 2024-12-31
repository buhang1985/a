package iih.ci.ord.s.bp.cfg.rulecfg.rule.lis;

import iih.ci.ord.orsms.d.CiLisOrInfo4Sms;
import iih.ci.ord.orsms.d.CiLisOrSmsIoDTO;

/**
 * 玉溪按照服务类型进行检验分单
 * @author zhangwq
 *
 */
public class SplitBySrvcaYY extends AbstractLisSplitRuleExecutor{

	/**
	 * 返回服务类型
	 */
	@Override
	protected String getIdentification(CiLisOrInfo4Sms ciLisOrInfo4Sms) {
		
		return ciLisOrInfo4Sms.getOrdo().getId_srvca();
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
	}

}
