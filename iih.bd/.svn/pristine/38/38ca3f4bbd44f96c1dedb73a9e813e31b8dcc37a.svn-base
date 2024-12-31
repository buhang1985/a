package iih.bd.res.dayslot.s;

import iih.bd.res.dayslot.d.DaysLotDO;
import iih.bd.res.dayslot.d.DayslotAggDO;
import iih.bd.res.dayslot.d.desc.DaysLotDODesc;
import iih.bd.res.dayslot.i.IDayslotCudService;
import iih.bd.res.dayslot.i.IDayslotRService;
import iih.bd.res.dayslot.s.validate.DayslotAggTimeCrossValidate;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 日期分组AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IDayslotCudService.class, IDayslotRService.class }, binding = Binding.JSONRPC)
public class DayslotCrudServiceImpl extends BaseAggService<DayslotAggDO, DaysLotDO>
		implements IDayslotCudService, IDayslotRService {

	public DayslotCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(DaysLotDODesc.class), IAppFwTempTbl.tmp_iaw_17.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), new DayslotAggTimeCrossValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(DayslotAggDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate(), new DayslotAggTimeCrossValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { AggBDReferenceChecker.getInstance() };
	}
}
