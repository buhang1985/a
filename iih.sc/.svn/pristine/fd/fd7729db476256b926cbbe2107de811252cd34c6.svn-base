package iih.sc.scbd.schedulechl.s;

import iih.sc.scbd.schedulechl.d.ScChlPeriodDO;
import iih.sc.scbd.schedulechl.d.SchedulechlAggDO;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scbd.schedulechl.d.desc.ScChlPeriodDODesc;
import iih.sc.scbd.schedulechl.d.desc.SchedulechlDODesc;
import iih.sc.scbd.schedulechl.i.ISchedulechlCudService;
import iih.sc.scbd.schedulechl.i.ISchedulechlRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 排班预约渠道AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { ISchedulechlCudService.class, ISchedulechlRService.class }, binding = Binding.JSONRPC)
public class SchedulechlCrudServiceImpl extends BaseAggService<SchedulechlAggDO, SchedulechlDO>
		implements ISchedulechlCudService, ISchedulechlRService {

	public SchedulechlCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(SchedulechlDODesc.class),
				IAppFwTempTbl.tmp_iaw_24.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };

	}

	@Override
	protected Validator[] getUpdateValidator(SchedulechlAggDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };

	}
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
			AggBDReferenceChecker.getInstance(new String[]{ScChlPeriodDODesc.TABLE_NAME},true,false)
		};
	}
}
