package iih.bd.res.bizgrp.s;

import iih.bd.res.bizgrp.d.BizGroupDO;
import iih.bd.res.bizgrp.d.desc.BizGroupDODesc;
import iih.bd.res.bizgrp.i.IBizgrpMDOCudService;
import iih.bd.res.bizgrp.i.IBizgrpMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 业务组主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IBizgrpMDOCudService.class, IBizgrpMDORService.class }, binding = Binding.JSONRPC)
public class BizgrpMDOCrudServiceImpl extends BaseDOService<BizGroupDO>
		implements IBizgrpMDOCudService, IBizgrpMDORService {

	public BizgrpMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(BizGroupDODesc.class), IAppFwTempTbl.tmp_iaw_06.name());
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(BizGroupDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
