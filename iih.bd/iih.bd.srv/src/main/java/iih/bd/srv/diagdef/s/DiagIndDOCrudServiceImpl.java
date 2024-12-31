package iih.bd.srv.diagdef.s;

import iih.bd.srv.diagdef.d.DiagIndDO;
import iih.bd.srv.diagdef.d.desc.DiagIndDODesc;
import iih.bd.srv.diagdef.i.IDiagIndDOCudService;
import iih.bd.srv.diagdef.i.IDiagIndDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医疗服务_疾病诊断定义主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IDiagIndDOCudService.class, IDiagIndDORService.class }, binding = Binding.JSONRPC)
public class DiagIndDOCrudServiceImpl extends BaseDOService<DiagIndDO>
		implements IDiagIndDOCudService, IDiagIndDORService {

	public DiagIndDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(DiagIndDODesc.class), IAppFwTempTbl.tmp_iaw_25.name());
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
	protected Validator[] getUpdateValidator(DiagIndDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
