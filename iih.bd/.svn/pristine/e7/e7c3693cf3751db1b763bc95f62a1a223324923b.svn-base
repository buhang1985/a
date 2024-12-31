package iih.bd.srv.ems.s;

import iih.bd.srv.ems.d.EmsDO;
import iih.bd.srv.ems.d.desc.EmsDODesc;
import iih.bd.srv.ems.i.IEmsregistryMDOCudService;
import iih.bd.srv.ems.i.IEmsregistryMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医疗单注册主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IEmsregistryMDOCudService.class,
		IEmsregistryMDORService.class }, binding = Binding.JSONRPC)
public class EmsregistryMDOCrudServiceImpl extends BaseDOService<EmsDO>
		implements IEmsregistryMDOCudService, IEmsregistryMDORService {

	public EmsregistryMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(EmsDODesc.class), IAppFwTempTbl.tmp_iaw_26.name());
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
	protected Validator[] getUpdateValidator(EmsDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
