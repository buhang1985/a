package iih.bd.res.dayslot.s;

import iih.bd.res.dayslot.d.DaysLotDO;
import iih.bd.res.dayslot.d.desc.DaysLotDODesc;
import iih.bd.res.dayslot.i.IDayslotMDOCudService;
import iih.bd.res.dayslot.i.IDayslotMDORService;
import iih.bd.res.dayslot.s.validate.TimeCrossValidate;
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
@Service(serviceInterfaces = { IDayslotMDOCudService.class, IDayslotMDORService.class }, binding = Binding.JSONRPC)
public class DayslotMDOCrudServiceImpl extends BaseDOService<DaysLotDO>
		implements IDayslotMDOCudService, IDayslotMDORService {

	public DayslotMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(DaysLotDODesc.class), IAppFwTempTbl.tmp_iaw_10.name());
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), new TimeCrossValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(DaysLotDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate(), new TimeCrossValidate() };
	}
}
