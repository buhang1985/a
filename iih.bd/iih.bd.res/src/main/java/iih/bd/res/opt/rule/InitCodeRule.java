package iih.bd.res.opt.rule;

import iih.bd.res.opt.d.OptAggDO;
import xap.lui.tools.pinyin.CnToPy;
import xap.lui.tools.pinyin.CnToWB;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.bizrule.IRule;

/**
 * 拼音、五笔、助记码处理规则
 * 
 * @author zhengcm
 * @date 2016-07-22 11:16:56
 *
 */
public class InitCodeRule implements IRule<OptAggDO> {

	@Override
	public void process(OptAggDO... vos) throws BizException {
		if (ArrayUtil.isEmpty(vos)) {
			return;
		}
		if (vos instanceof OptAggDO[]) {
			for (OptAggDO aggDO : vos) {
				// 拼音
				if (StringUtil.isEmptyWithTrim(aggDO.getParentDO().getPycode())) {
					aggDO.getParentDO().setPycode(
							CnToPy.getPyFirstCode(aggDO.getParentDO().getName()));
				}
				// 五笔
				if (StringUtil.isEmptyWithTrim(aggDO.getParentDO().getWbcode())) {
					aggDO.getParentDO().setWbcode(CnToWB.getWBCode(aggDO.getParentDO().getName()));
				}
				// 助记码
				if (StringUtil.isEmptyWithTrim(aggDO.getParentDO().getMnecode())) {
					aggDO.getParentDO().setMnecode(aggDO.getParentDO().getCode());
				}
			}
		}
	}
}
