package iih.bd.srv.diagcate.s;

import iih.bd.srv.diagcate.d.DiagCateDO;
import iih.bd.srv.diagcate.d.desc.DiagCateDODesc;
import iih.bd.srv.diagcate.i.IDiagcateMDOCudService;
import iih.bd.srv.diagcate.i.IDiagcateMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 疾病诊断分类主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IDiagcateMDOCudService.class, IDiagcateMDORService.class }, binding = Binding.JSONRPC)
public class DiagcateMDOCrudServiceImpl extends BaseDOService<DiagCateDO>
		implements IDiagcateMDOCudService, IDiagcateMDORService {

	public DiagcateMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(DiagCateDODesc.class), IAppFwTempTbl.tmp_iaw_14.name());
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
	protected Validator[] getUpdateValidator(DiagCateDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
