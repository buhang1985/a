package iih.bd.res.bed.rule;

import iih.bd.res.bed.d.Bdbed;
import iih.bd.res.bed.d.Bdbedfa;
import iih.bd.res.bed.d.BedAggDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.sys.appfw.bizrule.IRule;

/**
 * 集团组织字段初始化规则：默认从上下文中获取
 * 
 * @author zhengcm
 * @date 2016-06-14 19:28:28
 *
 */

public class GrpOrgInitRule implements IRule<BedAggDO> {

	/*
	 * override
	 */
	@Override
	public void process(BedAggDO... vos) throws BizException {
		if (ArrayUtil.isEmpty(vos)) {
			return;
		}
		if (vos instanceof BedAggDO[]) {
			for (BedAggDO aggDO : vos) {
				String groupId = Context.get().getGroupId();
				String orgId = Context.get().getOrgId();
				Bdbed bedDO = aggDO.getParentDO();
				Bdbedfa[] faDOs = (Bdbedfa[]) aggDO.getChildren(Bdbedfa.class);
				bedDO.setId_grp(groupId);
				bedDO.setId_org(orgId);
				if (!ArrayUtil.isEmpty(faDOs)) {
					for (Bdbedfa faDO : faDOs) {
						faDO.setId_grp(groupId);
						faDO.setId_org(orgId);
					}
				}
			}
		}
	}

}
