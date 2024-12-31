package iih.bd.mm.intelcabinet.s;

import iih.bd.mm.intelcabinet.d.IntelCabinetDO;
import iih.bd.mm.intelcabinet.d.desc.IntelCabinetDODesc;
import iih.bd.mm.intelcabinet.i.IIntelcabinetCudService;
import iih.bd.mm.intelcabinet.i.IIntelcabinetRService;
import iih.bd.mm.intelcabinet.s.rule.IntelCabinetAfterInsertOrUpdateRule;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 智能柜AggDO数据CRUD服务实现
 */
public class IntelcabinetCrudServiceImpl extends BaseDOService<IntelCabinetDO>
		implements IIntelcabinetCudService, IIntelcabinetRService {

	public IntelcabinetCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(IntelCabinetDODesc.class), IAppFwTempTbl.tmp_iaw_20.name());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertAfterRule(AroundProcesser<IntelCabinetDO> processer) {
		super.addInsertAfterRule(processer);
		processer.addAfterRule(new IntelCabinetAfterInsertOrUpdateRule());
	}

	@Override
	protected void addUpdateAfterRule(CompareAroundProcesser<IntelCabinetDO> processer, IntelCabinetDO[] originvos) {
		super.addUpdateAfterRule(processer, originvos);
		processer.addAfterRule(new IntelCabinetAfterInsertOrUpdateRule());
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
	protected Validator[] getUpdateValidator(IntelCabinetDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
