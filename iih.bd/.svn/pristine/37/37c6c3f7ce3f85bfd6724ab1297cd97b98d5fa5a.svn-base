package iih.bd.srv.emrterm.s;

import iih.bd.srv.emrterm.d.EmrTermGrpDO;
import iih.bd.srv.emrterm.d.desc.EmrTermGrpDODesc;
import iih.bd.srv.emrterm.i.IEmrTermGrpDOCudService;
import iih.bd.srv.emrterm.i.IEmrTermGrpDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 病历术语分类主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IEmrTermGrpDOCudService.class, IEmrTermGrpDORService.class }, binding = Binding.JSONRPC)
public class EmrTermGrpDOCrudServiceImpl extends BaseDOService<EmrTermGrpDO>
		implements IEmrTermGrpDOCudService, IEmrTermGrpDORService {

	public EmrTermGrpDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(EmrTermGrpDODesc.class), IAppFwTempTbl.tmp_iaw_14.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(EmrTermGrpDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
