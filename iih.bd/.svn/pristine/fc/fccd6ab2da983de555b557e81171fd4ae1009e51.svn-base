package iih.bd.srv.srvrtctl.s;

import iih.bd.srv.srvrtctl.d.SrvRtCtlDO;
import iih.bd.srv.srvrtctl.d.SrvrtctlAggDO;
import iih.bd.srv.srvrtctl.d.desc.SrvRtCtlDODesc;
import iih.bd.srv.srvrtctl.i.ISrvrtctlCudService;
import iih.bd.srv.srvrtctl.i.ISrvrtctlRService;
import iih.bd.srv.srvrtctl.validate.AggSrvRtCtlValidator;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 服务开立权限AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { ISrvrtctlCudService.class, ISrvrtctlRService.class }, binding = Binding.JSONRPC)
public class SrvrtctlCrudServiceImpl extends BaseAggService<SrvrtctlAggDO, SrvRtCtlDO>
		implements ISrvrtctlCudService, ISrvrtctlRService {

	public SrvrtctlCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(SrvRtCtlDODesc.class), IAppFwTempTbl.tmp_iaw_23.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), new AggSrvRtCtlValidator() };
	}

	@Override
	protected Validator[] getUpdateValidator(SrvrtctlAggDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate(), new AggSrvRtCtlValidator() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { AggBDReferenceChecker.getInstance() };
	}
}
