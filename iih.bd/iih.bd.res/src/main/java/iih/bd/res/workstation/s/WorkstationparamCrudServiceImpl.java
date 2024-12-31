package iih.bd.res.workstation.s;

import iih.bd.res.workstation.d.WorkStationParamDO;
import iih.bd.res.workstation.d.desc.WorkStationParamDODesc;
import iih.bd.res.workstation.i.IWorkstationparamCudService;
import iih.bd.res.workstation.i.IWorkstationparamRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 计算机工作站参数AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IWorkstationparamCudService.class,
		IWorkstationparamRService.class }, binding = Binding.JSONRPC)
public class WorkstationparamCrudServiceImpl extends BaseDOService<WorkStationParamDO>
		implements IWorkstationparamCudService, IWorkstationparamRService {

	public WorkstationparamCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(WorkStationParamDODesc.class), IAppFwTempTbl.tmp_iaw_11.name());
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
	protected Validator[] getUpdateValidator(WorkStationParamDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
