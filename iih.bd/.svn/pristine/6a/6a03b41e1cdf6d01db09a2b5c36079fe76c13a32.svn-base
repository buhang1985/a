package iih.bd.srv.mrfpbltype.s.rule;

import iih.bd.srv.mrfpbltype.d.MrfpbltypeAggDO;
import iih.bd.srv.mrfpbltype.s.bp.MrfpbltypeAggBeforeInsertOrUpdateRuleBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 病案首页费用分类插入或更新前规则
 * 
 * @author hao_wu
 *
 */
public class MrfpbltypeAggBeforeInsertOrUpdateRule implements IRule<MrfpbltypeAggDO> {

	@Override
	public void process(MrfpbltypeAggDO... arg0) throws BizException {
		MrfpbltypeAggBeforeInsertOrUpdateRuleBp bp = new MrfpbltypeAggBeforeInsertOrUpdateRuleBp();
		bp.exec(arg0);
	}
}
