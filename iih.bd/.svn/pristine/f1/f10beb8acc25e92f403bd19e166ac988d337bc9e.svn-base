package iih.bd.mm.drugcombctl.s;

import iih.bd.mm.drugcombctl.d.DrugCombCtlDO;
import iih.bd.mm.drugcombctl.d.desc.DrugCombCtlDODesc;
import iih.bd.mm.drugcombctl.i.IDrugcombctlCudService;
import iih.bd.mm.drugcombctl.i.IDrugcombctlRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 联合用药限制AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IDrugcombctlCudService.class, IDrugcombctlRService.class }, binding = Binding.JSONRPC)
public class DrugcombctlCrudServiceImpl extends BaseDOService<DrugCombCtlDO>
		implements IDrugcombctlCudService, IDrugcombctlRService {
	public DrugcombctlCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(DrugCombCtlDODesc.class), IAppFwTempTbl.tmp_iaw_15.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(DrugCombCtlDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
