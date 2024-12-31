package iih.bd.bs.ctmitf.s;

import iih.bd.bs.ctmitf.d.CtmItfDO;
import iih.bd.bs.ctmitf.d.desc.CtmItfDODesc;
import iih.bd.bs.ctmitf.i.ICtmitfCudService;
import iih.bd.bs.ctmitf.i.ICtmitfRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 客开接口AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { ICtmitfCudService.class, ICtmitfRService.class }, binding = Binding.JSONRPC)
public class CtmitfCrudServiceImpl extends BaseDOService<CtmItfDO> implements ICtmitfCudService, ICtmitfRService {
	public CtmitfCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(CtmItfDODesc.class), IAppFwTempTbl.tmp_iaw_29.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(CtmItfDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
