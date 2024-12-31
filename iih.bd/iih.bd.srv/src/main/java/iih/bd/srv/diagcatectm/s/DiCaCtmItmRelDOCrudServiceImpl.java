package iih.bd.srv.diagcatectm.s;

import iih.bd.srv.diagcatectm.d.DiCaCtmItmRelDO;
import iih.bd.srv.diagcatectm.d.desc.DiCaCtmItmRelDODesc;
import iih.bd.srv.diagcatectm.i.IDiCaCtmItmRelDOCudService;
import iih.bd.srv.diagcatectm.i.IDiCaCtmItmRelDORService;
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
@Service(serviceInterfaces = { IDiCaCtmItmRelDOCudService.class,
		IDiCaCtmItmRelDORService.class }, binding = Binding.JSONRPC)
public class DiCaCtmItmRelDOCrudServiceImpl extends BaseDOService<DiCaCtmItmRelDO>
		implements IDiCaCtmItmRelDOCudService, IDiCaCtmItmRelDORService {

	public DiCaCtmItmRelDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(DiCaCtmItmRelDODesc.class), IAppFwTempTbl.tmp_iaw_16.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(DiCaCtmItmRelDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
