package iih.bd.mm.mmcategory.s.rule;

import iih.bd.mm.mmcategory.bp.MmcaCuBeforeBp;
import iih.bd.mm.mmcategory.d.MMCategoryDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 物品基本分类更新前规则
 * 
 * @author hao_wu
 *
 */
public class MMCategoryBeforeUpdateRule implements IRule<MMCategoryDO> {

	@Override
	public void process(MMCategoryDO... mmcaDOS) throws BizException {
		MmcaCuBeforeBp bp = new MmcaCuBeforeBp();

		bp.exec(mmcaDOS);
	}

}
