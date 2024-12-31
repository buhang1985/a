package iih.bd.srv.srvrtctl.s;

import iih.bd.srv.srvrtctl.d.SrvRtCtlDO;
import iih.bd.srv.srvrtctl.d.desc.SrvRtCtlDODesc;
import iih.bd.srv.srvrtctl.i.ISrvrtctlMDOCudService;
import iih.bd.srv.srvrtctl.i.ISrvrtctlMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 服务开立权限主实体CRUD服务实现
 */
@Service(serviceInterfaces = { ISrvrtctlMDOCudService.class, ISrvrtctlMDORService.class }, binding = Binding.JSONRPC)
public class SrvrtctlMDOCrudServiceImpl extends BaseDOService<SrvRtCtlDO>
		implements ISrvrtctlMDOCudService, ISrvrtctlMDORService {

	public SrvrtctlMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(SrvRtCtlDODesc.class), IAppFwTempTbl.tmp_iaw_11.name());
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
	protected Validator[] getUpdateValidator(SrvRtCtlDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
