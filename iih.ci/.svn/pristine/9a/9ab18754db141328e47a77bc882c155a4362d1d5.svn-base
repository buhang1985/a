package iih.ci.ord.s.bp.cfg.rulecfg.rule.lis;

import org.apache.commons.lang3.StringUtils;

import iih.ci.ord.orsms.d.CiLisOrInfo4Sms;
import iih.ci.ord.orsms.d.CiLisOrSmsIoDTO;

/**
 * 按照检验属性中分组标识是否相同进行检查分组
 * @author zhangwq
 *
 */
public class SplitLisByLabgroup extends AbstractLisSplitRuleExecutor {

	@Override
	protected String getIdentification(CiLisOrInfo4Sms ciLisOrInfo4Sms) {
		if(ciLisOrInfo4Sms.getOrlisapdo()==null || StringUtils.isEmpty(ciLisOrInfo4Sms.getOrlisapdo().getId_labgroup())){
			return ciLisOrInfo4Sms.getOrdo().getId_or();
		}
		return ciLisOrInfo4Sms.getOrlisapdo().getId_labgroup();
	}

	@Override
	protected boolean isConformToTheRules(CiLisOrInfo4Sms ciLisOrInfo4Sms) {
		return true;
	}

	@Override
	protected void setRuleVal(CiLisOrSmsIoDTO ciLisOrSmsIo, CiLisOrInfo4Sms ciLisOrInfo4Sms) {
		// TODO Auto-generated method stub
		
	}
}
