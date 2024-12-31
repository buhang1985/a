package iih.bd.res.goodslocation.s.rule;

import iih.bd.res.goodslocation.d.GoodslocationDO;
import iih.bd.res.goodslocation.s.bp.SetGoodslocationDOGrpOrgBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 插入或更新规则
 * 
 * @author hao_wu
 *
 */
public class InsertOrUpdateRule implements IRule<GoodslocationDO> {

	@Override
	public void process(GoodslocationDO... dos) throws BizException {
		SetGoodslocationDOGrpOrgBp bp = new SetGoodslocationDOGrpOrgBp();
		for (GoodslocationDO goodslocationDO : dos) {
			bp.Exec(goodslocationDO);
		}
	}
}
