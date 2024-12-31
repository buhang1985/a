package iih.ci.ord.s.bp.cfg.rulecfg.rule.lis;

import iih.ci.ord.orsms.d.CiLisOrInfo4Sms;
import iih.ci.ord.orsms.d.CiLisOrSmsIoDTO;
import xap.mw.coreitf.d.FBoolean;

/**
 * 按照科研项目ID进行检验分单，相同科研项目id合并到一个检验打印单
 * @author HUMS
 *
 */
public class SplitLisByResearchProject extends AbstractLisSplitRuleExecutor{

	@Override
	protected String getIdentification(CiLisOrInfo4Sms ciLisOrInfo4Sms) {
		
		return ciLisOrInfo4Sms.getId_researchproject();
	}

	/**
	 * 是否符合规则
	 */
	@Override
	protected boolean isConformToTheRules(CiLisOrInfo4Sms ciLisOrInfo4Sms) {
		
		return FBoolean.TRUE.equals(ciLisOrInfo4Sms.getFg_research());
	}

	@Override
	protected void setRuleVal(CiLisOrSmsIoDTO ciLisOrSmsIo, CiLisOrInfo4Sms ciLisOrInfo4Sms) {
		
		ciLisOrSmsIo.setFg_research(ciLisOrInfo4Sms.getFg_research());
		ciLisOrSmsIo.setId_researchproject(ciLisOrInfo4Sms.getId_researchproject());		
		ciLisOrSmsIo.setName_researchproject(ciLisOrInfo4Sms.getName_researchproject());
	}

}
