package iih.bd.pp.pripat.s.rule;

import iih.bd.pp.pripat.d.PriPatSrvOrCaDO;
import iih.bd.pp.pripat.s.rule.bp.PriPatSrvOrCaDOInsertBeforeRuleBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 患者价格分类服务插入前规则
 * @author guoyang
 *
 */
public class PriPatSrvOrCaDOInsertBeforeRule implements IRule<PriPatSrvOrCaDO> {

	@Override
	public void process(PriPatSrvOrCaDO... arg0) throws BizException {
		
		PriPatSrvOrCaDOInsertBeforeRuleBp bp = new PriPatSrvOrCaDOInsertBeforeRuleBp();
		bp.exec(arg0);
	}
}
