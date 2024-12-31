package iih.bd.mm.ctr.s;

import iih.bd.mm.ctr.d.MmUseStrategyDO;
import iih.bd.mm.ctr.d.desc.MmUseStrategyDODesc;
import iih.bd.mm.ctr.i.IMmusestrategyCudService;
import iih.bd.mm.ctr.i.IMmusestrategyRService;
import iih.bd.mm.ctr.s.rule.MmUseStrategyAfterInsertOrUpdateRule;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 物品使用策略AggDO数据CRUD服务实现
 */
public class MmusestrategyCrudServiceImpl extends BaseDOService<MmUseStrategyDO>
		implements IMmusestrategyCudService, IMmusestrategyRService {

	public MmusestrategyCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MmUseStrategyDODesc.class), IAppFwTempTbl.tmp_iaw_18.name());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertAfterRule(AroundProcesser<MmUseStrategyDO> processer) {
		super.addInsertAfterRule(processer);
		processer.addAfterRule(new MmUseStrategyAfterInsertOrUpdateRule());
	}

	@Override
	protected void addUpdateAfterRule(CompareAroundProcesser<MmUseStrategyDO> processer, MmUseStrategyDO[] originvos) {
		super.addUpdateAfterRule(processer, originvos);
		processer.addAfterRule(new MmUseStrategyAfterInsertOrUpdateRule());
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
	protected Validator[] getUpdateValidator(MmUseStrategyDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
