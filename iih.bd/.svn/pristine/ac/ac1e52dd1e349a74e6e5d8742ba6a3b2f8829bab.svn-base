package iih.bd.res.empdep.s;

import iih.bd.res.empdep.d.EmpDepDO;
import iih.bd.res.empdep.d.desc.EmpDepDODesc;
import iih.bd.res.empdep.i.IEmpdepCudService;
import iih.bd.res.empdep.i.IEmpdepRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 科室员工关系维护AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IEmpdepCudService.class, IEmpdepRService.class }, binding = Binding.JSONRPC)
public class EmpdepCrudServiceImpl extends BaseDOService<EmpDepDO> implements IEmpdepCudService, IEmpdepRService {

	public EmpdepCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(EmpDepDODesc.class), IAppFwTempTbl.tmp_iaw_06.name());
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
	protected Validator[] getUpdateValidator(EmpDepDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
