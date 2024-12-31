package iih.bd.srv.diagdef.s;

import iih.bd.srv.diagdef.d.DiagCompDO;
import iih.bd.srv.diagdef.d.desc.DiagCompDODesc;
import iih.bd.srv.diagdef.i.IDiagCompDOCudService;
import iih.bd.srv.diagdef.i.IDiagCompDORService;
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
@Service(serviceInterfaces = { IDiagCompDOCudService.class, IDiagCompDORService.class }, binding = Binding.JSONRPC)
public class DiagCompDOCrudServiceImpl extends BaseDOService<DiagCompDO>
		implements IDiagCompDOCudService, IDiagCompDORService {

	public DiagCompDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(DiagCompDODesc.class), IAppFwTempTbl.tmp_iaw_08.name());
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
	protected Validator[] getUpdateValidator(DiagCompDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
