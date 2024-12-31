package iih.bd.srv.srvreact.s;

import iih.bd.srv.srvreact.d.SrvReactItemDO;
import iih.bd.srv.srvreact.d.desc.SrvReactItemDODesc;
import iih.bd.srv.srvreact.i.ISrvReactItemDOCudService;
import iih.bd.srv.srvreact.i.ISrvReactItemDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 服务互斥主实体CRUD服务实现
 */
@Service(serviceInterfaces = { ISrvReactItemDOCudService.class,
		ISrvReactItemDORService.class }, binding = Binding.JSONRPC)
public class SrvReactItemDOCrudServiceImpl extends BaseDOService<SrvReactItemDO>
		implements ISrvReactItemDOCudService, ISrvReactItemDORService {

	public SrvReactItemDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(SrvReactItemDODesc.class), IAppFwTempTbl.tmp_iaw_01.name());
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
	protected Validator[] getUpdateValidator(SrvReactItemDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
