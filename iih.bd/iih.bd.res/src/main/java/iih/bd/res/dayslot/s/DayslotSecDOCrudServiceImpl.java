package iih.bd.res.dayslot.s;

import iih.bd.res.dayslot.d.DayslotSecDO;
import iih.bd.res.dayslot.d.desc.DayslotSecDODesc;
import iih.bd.res.dayslot.i.IDayslotSecDOCudService;
import iih.bd.res.dayslot.i.IDayslotSecDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 日期分组主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IDayslotSecDOCudService.class, IDayslotSecDORService.class }, binding = Binding.JSONRPC)
public class DayslotSecDOCrudServiceImpl extends BaseDOService<DayslotSecDO>
		implements IDayslotSecDOCudService, IDayslotSecDORService {

	public DayslotSecDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(DayslotSecDODesc.class), IAppFwTempTbl.tmp_iaw_18.name());
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
	protected Validator[] getUpdateValidator(DayslotSecDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
