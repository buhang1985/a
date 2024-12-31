package iih.bd.srv.diagdef.s;

import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.diagdef.d.desc.DiagDefDODesc;
import iih.bd.srv.diagdef.i.IDiagdefMDOCudService;
import iih.bd.srv.diagdef.i.IDiagdefMDORService;
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
@Service(serviceInterfaces = { IDiagdefMDOCudService.class, IDiagdefMDORService.class }, binding = Binding.JSONRPC)
public class DiagdefMDOCrudServiceImpl extends BaseDOService<DiagDefDO>
		implements IDiagdefMDOCudService, IDiagdefMDORService {

	public DiagdefMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(DiagDefDODesc.class), IAppFwTempTbl.tmp_iaw_05.name());
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
	protected Validator[] getUpdateValidator(DiagDefDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
