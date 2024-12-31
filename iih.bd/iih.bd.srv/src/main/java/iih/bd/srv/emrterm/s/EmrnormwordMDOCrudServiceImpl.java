package iih.bd.srv.emrterm.s;

import iih.bd.srv.emrterm.d.EmrNormWordCaDO;
import iih.bd.srv.emrterm.d.desc.EmrNormWordCaDODesc;
import iih.bd.srv.emrterm.i.IEmrnormwordMDOCudService;
import iih.bd.srv.emrterm.i.IEmrnormwordMDORService;
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
@Service(serviceInterfaces = { IEmrnormwordMDOCudService.class,
		IEmrnormwordMDORService.class }, binding = Binding.JSONRPC)
public class EmrnormwordMDOCrudServiceImpl extends BaseDOService<EmrNormWordCaDO>
		implements IEmrnormwordMDOCudService, IEmrnormwordMDORService {

	public EmrnormwordMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(EmrNormWordCaDODesc.class), IAppFwTempTbl.tmp_iaw_24.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(EmrNormWordCaDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
