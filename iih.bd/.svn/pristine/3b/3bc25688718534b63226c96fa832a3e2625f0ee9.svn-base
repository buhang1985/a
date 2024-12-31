package iih.bd.res.opt.rule;

import iih.bd.res.opt.d.OptAggDO;
import iih.bd.res.opt.d.OptDO;
import iih.bd.res.opt.d.OptDepDO;
import iih.bd.res.opt.d.OptFaDO;
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
public class GrpInitRule implements IRule<OptAggDO> {

	/*
	 * override
	 */
	@Override
	public void process(OptAggDO... vos) throws BizException {
		if (ArrayUtil.isEmpty(vos)) {
			return;
		}
		if (vos instanceof OptAggDO[]) {
			for (OptAggDO aggDO : vos) {
				String groupId = Context.get().getGroupId();
				String orgId = Context.get().getOrgId();
				OptDO optDO = aggDO.getParentDO();
				OptFaDO[] ofDOs = aggDO.getOptFaDO();
				OptDepDO[] odDOs = aggDO.getOptDepDO();
				if (StringUtil.isEmptyWithTrim(optDO.getId_grp())) {
					optDO.setId_grp(groupId);
				}
				if (StringUtil.isEmptyWithTrim(optDO.getId_org())) {
					optDO.setId_org(orgId);
				}
				if (!ArrayUtil.isEmpty(ofDOs)) {
					for (OptFaDO ofDO : ofDOs) {
						if (StringUtil.isEmptyWithTrim(ofDO.getId_grp())) {
							ofDO.setId_grp(groupId);
						}
						if (StringUtil.isEmptyWithTrim(ofDO.getId_org())) {
							ofDO.setId_org(orgId);
						}
					}
				}
				if (!ArrayUtil.isEmpty(odDOs)) {
					for (OptDepDO odDO : odDOs) {
						if (StringUtil.isEmptyWithTrim(odDO.getId_grp())) {
							odDO.setId_grp(groupId);
						}
						if (StringUtil.isEmptyWithTrim(odDO.getId_org())) {
							odDO.setId_org(orgId);
						}
					}
				}
			}
		}
	}

}
