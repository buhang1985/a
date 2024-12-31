package iih.bd.mm.mmcategory.s.rule;

import iih.bd.mm.mmcategory.bp.MmcaCuAfterBp;
import iih.bd.mm.mmcategory.d.MMCategoryDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.ICompareRule;

/**
 * 物品基本分类更新后规则
 * 
 * @author hao_wu
 *
 */
public class MMCategoryAfterUpdateRule implements ICompareRule<MMCategoryDO> {

	@Override
	public void process(MMCategoryDO[] vos, MMCategoryDO[] originVOs) throws BizException {
		MmcaCuAfterBp bp = new MmcaCuAfterBp();

		bp.exec(vos, originVOs);
	}
}
