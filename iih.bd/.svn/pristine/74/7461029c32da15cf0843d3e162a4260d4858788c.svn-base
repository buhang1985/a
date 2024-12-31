package iih.bd.res.bizgrp.s;

import iih.bd.res.bizgrp.d.BizGrpEmpsDO;
import iih.bd.res.bizgrp.d.desc.BizGrpEmpsDODesc;
import iih.bd.res.bizgrp.i.IBizGrpEmpsDOCudService;
import iih.bd.res.bizgrp.i.IBizGrpEmpsDORService;
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
@Service(serviceInterfaces = { IBizGrpEmpsDOCudService.class, IBizGrpEmpsDORService.class }, binding = Binding.JSONRPC)
public class BizGrpEmpsDOCrudServiceImpl extends BaseDOService<BizGrpEmpsDO>
		implements IBizGrpEmpsDOCudService, IBizGrpEmpsDORService {

	public BizGrpEmpsDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(BizGrpEmpsDODesc.class), IAppFwTempTbl.tmp_iaw_07.name());
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
	protected Validator[] getUpdateValidator(BizGrpEmpsDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
