package iih.bd.srv.ems.s;

import iih.bd.srv.ems.d.EmsPrnTmplDO;
import iih.bd.srv.ems.d.desc.EmsPrnTmplDODesc;
import iih.bd.srv.ems.i.IEmsprntmplMDOCudService;
import iih.bd.srv.ems.i.IEmsprntmplMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医疗单打印模板管理主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IEmsprntmplMDOCudService.class,
		IEmsprntmplMDORService.class }, binding = Binding.JSONRPC)
public class EmsprntmplMDOCrudServiceImpl extends BaseDOService<EmsPrnTmplDO>
		implements IEmsprntmplMDOCudService, IEmsprntmplMDORService {

	public EmsprntmplMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(EmsPrnTmplDODesc.class), IAppFwTempTbl.tmp_iaw_16.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(EmsPrnTmplDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
