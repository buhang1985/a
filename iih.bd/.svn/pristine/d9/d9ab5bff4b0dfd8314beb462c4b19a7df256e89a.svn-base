package iih.bd.srv.mrfpbltype.s.rule;

import iih.bd.srv.mrfpbltype.d.MrFpBlTypeProDO;
import iih.bd.srv.mrfpbltype.s.bp.MrFpBlTypeProBeforeInsertOrUpdateRuleBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 病案首页分类项目插入或更新前规则
 * 
 * @author hao_wu
 *
 */
public class MrFpBlTypeProBeforeInsertOrUpdateRule implements IRule<MrFpBlTypeProDO> {

	@Override
	public void process(MrFpBlTypeProDO... arg0) throws BizException {
		MrFpBlTypeProBeforeInsertOrUpdateRuleBp bp = new MrFpBlTypeProBeforeInsertOrUpdateRuleBp();
		bp.exec(arg0);
	}
}
