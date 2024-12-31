package iih.bd.srv.mrelement.s;

import iih.bd.srv.mrelement.d.MrElementDO;
import iih.bd.srv.mrelement.d.desc.MrElementDODesc;
import iih.bd.srv.mrelement.i.IBdmrdeMDOCudService;
import iih.bd.srv.mrelement.i.IBdmrdeMDORService;
import iih.bd.srv.mrelement.s.validator.BdmrdeMDOCValidator;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 组件主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IBdmrdeMDOCudService.class, IBdmrdeMDORService.class }, binding = Binding.JSONRPC)
public class BdmrdeMDOCrudServiceImpl extends BaseDOService<MrElementDO>
		implements IBdmrdeMDOCudService, IBdmrdeMDORService {

	public BdmrdeMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MrElementDODesc.class), IAppFwTempTbl.tmp_iaw_25.name());
	}
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), new BdmrdeMDOCValidator()};
	}

	@Override
	protected Validator[] getUpdateValidator(MrElementDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate(), new BdmrdeMDOCValidator()};
	}
}
