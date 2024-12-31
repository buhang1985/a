package iih.bd.srv.deptstd2diag.s;

import iih.bd.srv.deptstd2diag.d.DeptDiagCaDO;
import iih.bd.srv.deptstd2diag.d.desc.DeptDiagCaDODesc;
import iih.bd.srv.deptstd2diag.i.IDepdiagcaCudService;
import iih.bd.srv.deptstd2diag.i.IDepdiagcaRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IDepdiagcaCudService.class, IDepdiagcaRService.class }, binding = Binding.JSONRPC)
public class DepdiagcaCrudServiceImpl extends BaseDOService<DeptDiagCaDO>
		implements IDepdiagcaCudService, IDepdiagcaRService {

	public DepdiagcaCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(DeptDiagCaDODesc.class), IAppFwTempTbl.tmp_iaw_05.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(DeptDiagCaDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
