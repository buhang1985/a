package iih.bd.mm.mmcategory.s.rule;

import iih.bd.mm.mmcategory.bp.MmcaDeBeforeBp;
import iih.bd.mm.mmcategory.d.MMCategoryDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 物品基本分类删除前规则
 * 
 * @author hao_wu
 *
 */
public class MMCategoryBeforeDeleteRule implements IRule<MMCategoryDO> {

	@Override
	public void process(MMCategoryDO... mmcaDOS) throws BizException {
		MmcaDeBeforeBp bp = new MmcaDeBeforeBp();

		bp.exec(mmcaDOS);
	}

}
