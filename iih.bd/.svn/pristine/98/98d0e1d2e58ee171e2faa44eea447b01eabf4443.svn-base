package iih.bd.fc.wf.s;

import iih.bd.fc.wf.d.WfAggDO;
import iih.bd.fc.wf.d.WfDO;
import iih.bd.fc.wf.d.desc.WfDODesc;
import iih.bd.fc.wf.i.IWfCudService;
import iih.bd.fc.wf.i.IWfRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 流程配置_医嘱流向AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IWfCudService.class, IWfRService.class }, binding = Binding.JSONRPC)
public class WfCrudServiceImpl extends BaseAggService<WfAggDO, WfDO> implements
		IWfCudService, IWfRService {

	public WfCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(WfDODesc.class),
				IAppFwTempTbl.tmp_iaw_12.name());
	}
	
	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[]{new BDUniqueRuleValidate()};
	}
	
	@Override
	protected Validator[] getUpdateValidator(WfAggDO[] oldDOs) {
		return new Validator[]{new BDUniqueRuleValidate()};
	}
}
