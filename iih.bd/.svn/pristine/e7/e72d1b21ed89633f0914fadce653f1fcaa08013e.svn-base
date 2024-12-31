package iih.bd.mhi.hpreferraltp.s;

import iih.bd.mhi.hpreferraltp.d.HpReferralTpDO;
import iih.bd.mhi.hpreferraltp.d.desc.HpReferralTpDODesc;
import iih.bd.mhi.hpreferraltp.i.IHpreferraltpCudService;
import iih.bd.mhi.hpreferraltp.i.IHpreferraltpRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医保产品_转诊类型AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IHpreferraltpCudService.class, IHpreferraltpRService.class }, binding = Binding.JSONRPC)
public class HpreferraltpCrudServiceImpl extends BaseDOService<HpReferralTpDO>
		implements IHpreferraltpCudService, IHpreferraltpRService {
	public HpreferraltpCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(HpReferralTpDODesc.class), IAppFwTempTbl.tmp_iaw_20.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(HpReferralTpDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
