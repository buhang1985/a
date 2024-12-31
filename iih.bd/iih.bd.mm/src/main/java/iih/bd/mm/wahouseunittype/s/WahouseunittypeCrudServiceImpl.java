package iih.bd.mm.wahouseunittype.s;

import iih.bd.mm.wahouseunittype.d.WahouseUnitTypeDO;
import iih.bd.mm.wahouseunittype.d.desc.WahouseUnitTypeDODesc;
import iih.bd.mm.wahouseunittype.i.IWahouseunittypeCudService;
import iih.bd.mm.wahouseunittype.i.IWahouseunittypeRService;
import iih.bd.mm.wahouseunittype.s.rule.WahouseUnitTypeBeforeUpdateRule;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 组件AggDO数据CRUD服务实现
 */
public class WahouseunittypeCrudServiceImpl extends BaseDOService<WahouseUnitTypeDO>
		implements IWahouseunittypeCudService, IWahouseunittypeRService {

	public WahouseunittypeCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(WahouseUnitTypeDODesc.class), IAppFwTempTbl.tmp_iaw_07.name());
	}

	@Override
	protected void addUpdateBeforeRule(CompareAroundProcesser<WahouseUnitTypeDO> processer,
			WahouseUnitTypeDO[] originvos) {
		super.addUpdateBeforeRule(processer, originvos);
		processer.addBeforeRule(new WahouseUnitTypeBeforeUpdateRule());
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
	protected Validator[] getUpdateValidator(WahouseUnitTypeDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
