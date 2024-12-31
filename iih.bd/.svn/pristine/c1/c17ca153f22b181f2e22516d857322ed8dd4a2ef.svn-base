package iih.bd.res.bed.rule;

import iih.bd.res.bed.d.BedAggDO;
import xap.lui.tools.pinyin.CnToPy;
import xap.lui.tools.pinyin.CnToWB;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.bizrule.IRule;

/**
 * 床位新增时初始化拼音
 * 
 * @author zhengcm
 * @date 2016-06-14 19:28:28
 *
 */

public class BedInitCodeRule implements IRule<BedAggDO> {

	@Override
	public void process(BedAggDO... vos) throws BizException {
		if (ArrayUtil.isEmpty(vos)) {
			return;
		}
		if (vos instanceof BedAggDO[]) {
			for (BedAggDO aggDO : vos) {
				// 拼音
				if (StringUtil.isEmptyWithTrim(aggDO.getParentDO().getPycode())) {
					aggDO.getParentDO()
							.setPycode(
									CnToPy.getPyFirstCode(aggDO.getParentDO()
											.getName()));
				}
				// 五笔
				if (StringUtil.isEmptyWithTrim(aggDO.getParentDO().getWbcode())) {
					aggDO.getParentDO().setWbcode(
							CnToWB.getWBCode(aggDO.getParentDO().getName()));
				}
				// 助记码
				if (StringUtil
						.isEmptyWithTrim(aggDO.getParentDO().getMnecode())) {
					aggDO.getParentDO().setMnecode(
							aggDO.getParentDO().getCode());
				}
			}
		}
	}
}
