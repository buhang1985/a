package iih.bd.srv.diagdef.s;

import iih.bd.srv.diagdef.d.DiagAliasDO;
import iih.bd.srv.diagdef.d.desc.DiagAliasDODesc;
import iih.bd.srv.diagdef.i.IDiagAliasDOCudService;
import iih.bd.srv.diagdef.i.IDiagAliasDORService;
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
@Service(serviceInterfaces = { IDiagAliasDOCudService.class, IDiagAliasDORService.class }, binding = Binding.JSONRPC)
public class DiagAliasDOCrudServiceImpl extends BaseDOService<DiagAliasDO>
		implements IDiagAliasDOCudService, IDiagAliasDORService {

	public DiagAliasDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(DiagAliasDODesc.class), IAppFwTempTbl.tmp_iaw_17.name());
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
	protected Validator[] getUpdateValidator(DiagAliasDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
