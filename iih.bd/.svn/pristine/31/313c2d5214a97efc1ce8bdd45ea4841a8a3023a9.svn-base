package iih.bd.srv.diagcatectm.s;

import iih.bd.srv.diagcatectm.d.DiCaCtmItmDO;
import iih.bd.srv.diagcatectm.d.desc.DiCaCtmItmDODesc;
import iih.bd.srv.diagcatectm.i.IDiagcatectmitmMDOCudService;
import iih.bd.srv.diagcatectm.i.IDiagcatectmitmMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 疾病诊断自定义分类项目主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IDiagcatectmitmMDOCudService.class,
		IDiagcatectmitmMDORService.class }, binding = Binding.JSONRPC)
public class DiagcatectmitmMDOCrudServiceImpl extends BaseDOService<DiCaCtmItmDO>
		implements IDiagcatectmitmMDOCudService, IDiagcatectmitmMDORService {

	public DiagcatectmitmMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(DiCaCtmItmDODesc.class), IAppFwTempTbl.tmp_iaw_19.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(DiCaCtmItmDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
