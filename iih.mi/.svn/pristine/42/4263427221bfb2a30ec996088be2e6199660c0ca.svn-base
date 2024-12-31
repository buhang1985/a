package iih.mi.mibd.insurkind.s;

import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.mibd.insurkind.d.desc.InsurkindDODesc;
import iih.mi.mibd.insurkind.d.InsurkindDO;
import iih.mi.mibd.insurkind.i.IInsurkindCudService;
import iih.mi.mibd.insurkind.i.IInsurkindRService;

/**
 * 医保平台_险种AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IInsurkindCudService.class, IInsurkindRService.class }, binding = Binding.JSONRPC)
public class InsurkindCrudServiceImpl extends BaseDOService<InsurkindDO>
		implements IInsurkindCudService, IInsurkindRService {
	public InsurkindCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(InsurkindDODesc.class), IAppFwTempTbl.tmp_iaw_12.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(InsurkindDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
