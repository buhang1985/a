package iih.bd.srv.srvrtempref.s;

import iih.bd.srv.srvrtempref.d.SrvRtEmpRefDO;
import iih.bd.srv.srvrtempref.d.desc.SrvRtEmpRefDODesc;
import iih.bd.srv.srvrtempref.i.ISrvrtemprefCudService;
import iih.bd.srv.srvrtempref.i.ISrvrtemprefRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 服务开立权限与医生关系AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { ISrvrtemprefCudService.class, ISrvrtemprefRService.class }, binding = Binding.JSONRPC)
public class SrvrtemprefCrudServiceImpl extends BaseDOService<SrvRtEmpRefDO>
		implements ISrvrtemprefCudService, ISrvrtemprefRService {
	public SrvrtemprefCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(SrvRtEmpRefDODesc.class), IAppFwTempTbl.tmp_iaw_05.name());
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
	protected Validator[] getUpdateValidator(SrvRtEmpRefDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
