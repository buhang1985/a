package iih.bd.srv.diagcatectm.s;

import iih.bd.srv.diagcatectm.d.DiCaCtmDO;
import iih.bd.srv.diagcatectm.d.desc.DiCaCtmDODesc;
import iih.bd.srv.diagcatectm.i.IDiagcatectmCudService;
import iih.bd.srv.diagcatectm.i.IDiagcatectmRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 疾病诊断自定义分类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IDiagcatectmCudService.class, IDiagcatectmRService.class }, binding = Binding.JSONRPC)
public class DiagcatectmCrudServiceImpl extends BaseDOService<DiCaCtmDO>
		implements IDiagcatectmCudService, IDiagcatectmRService {
	public DiagcatectmCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(DiCaCtmDODesc.class), IAppFwTempTbl.tmp_iaw_12.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(DiCaCtmDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
