package iih.bd.srv.deptstd2diag.s;

import iih.bd.srv.deptstd2diag.d.DeptStdDiagDO;
import iih.bd.srv.deptstd2diag.d.desc.DeptStdDiagDODesc;
import iih.bd.srv.deptstd2diag.i.IDeptstddiagCudService;
import iih.bd.srv.deptstd2diag.i.IDeptstddiagRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 科室常用诊断AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IDeptstddiagCudService.class, IDeptstddiagRService.class }, binding = Binding.JSONRPC)
public class DeptstddiagCrudServiceImpl extends BaseDOService<DeptStdDiagDO>
		implements IDeptstddiagCudService, IDeptstddiagRService {

	public DeptstddiagCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(DeptStdDiagDODesc.class), IAppFwTempTbl.tmp_iaw_25.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(DeptStdDiagDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
