package iih.bd.res.mtassist.rule;

import iih.bd.res.mtassist.d.MtAssistDO;
import iih.bd.res.mtassist.d.MtassistAggDO;
import iih.bd.res.mtassist.d.MtassistFundDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.bizrule.IRule;

/**
 * 集团组织字段初始化规则：默认从上下文中获取
 * 
 * @author zhengcm
 * @date 2016-07-22 11:07:56
 *
 */
public class GrpInitRule implements IRule<MtassistAggDO> {

	/*
	 * override
	 */
	@Override
	public void process(MtassistAggDO... vos) throws BizException {
		if (ArrayUtil.isEmpty(vos)) {
			return;
		}
		if (vos instanceof MtassistAggDO[]) {
			for (MtassistAggDO aggDO : vos) {
				String groupId = Context.get().getGroupId();
				String orgId = Context.get().getOrgId();
				MtAssistDO maDO = aggDO.getParentDO();
				MtassistFundDO[] mfDOs = (MtassistFundDO[]) aggDO.getChildren(MtassistFundDO.class);
				if (StringUtil.isEmptyWithTrim(maDO.getId_grp())) {
					maDO.setId_grp(groupId);
				}
				if (StringUtil.isEmptyWithTrim(maDO.getId_org())) {
					maDO.setId_org(orgId);
				}
				if (ArrayUtil.isEmpty(mfDOs)) {
					continue;
				}
				for (MtassistFundDO mfDO : mfDOs) {
					if (StringUtil.isEmptyWithTrim(mfDO.getId_grp())) {
						mfDO.setId_grp(groupId);
					}
					if (StringUtil.isEmptyWithTrim(mfDO.getId_org())) {
						mfDO.setId_org(orgId);
					}
				}
			}
		}
	}

}
