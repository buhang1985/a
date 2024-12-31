package iih.bd.bs.ctmitf.s;

import iih.bd.bs.ctmitf.d.CtmImplDO;
import iih.bd.bs.ctmitf.d.desc.CtmImplDODesc;
import iih.bd.bs.ctmitf.i.ICtmimplCudService;
import iih.bd.bs.ctmitf.i.ICtmimplRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 客开接口实现类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { ICtmimplCudService.class, ICtmimplRService.class }, binding = Binding.JSONRPC)
public class CtmimplCrudServiceImpl extends BaseDOService<CtmImplDO> implements ICtmimplCudService, ICtmimplRService {
	public CtmimplCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(CtmImplDODesc.class), IAppFwTempTbl.tmp_iaw_21.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(CtmImplDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
