package iih.bd.srv.emrterm.s;

import iih.bd.srv.emrterm.d.EmrNormWordDO;
import iih.bd.srv.emrterm.d.desc.EmrNormWordDODesc;
import iih.bd.srv.emrterm.i.IEmrNormWordDOCudService;
import iih.bd.srv.emrterm.i.IEmrNormWordDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 病历常用词分类主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IEmrNormWordDOCudService.class,
		IEmrNormWordDORService.class }, binding = Binding.JSONRPC)
public class EmrNormWordDOCrudServiceImpl extends BaseDOService<EmrNormWordDO>
		implements IEmrNormWordDOCudService, IEmrNormWordDORService {

	public EmrNormWordDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(EmrNormWordDODesc.class), IAppFwTempTbl.tmp_iaw_26.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(EmrNormWordDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
