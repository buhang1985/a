package iih.bd.mm.mmcategory.s;

import iih.bd.mm.mmcategory.d.MMCategoryDO;
import iih.bd.mm.mmcategory.d.desc.MMCategoryDODesc;
import iih.bd.mm.mmcategory.i.IMmcategoryCudService;
import iih.bd.mm.mmcategory.i.IMmcategoryRService;
import iih.bd.mm.mmcategory.s.rule.MMCategoryAfterUpdateRule;
import iih.bd.mm.mmcategory.s.rule.MMCategoryBeforeDeleteRule;
import iih.bd.mm.mmcategory.s.rule.MMCategoryBeforeUpdateRule;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.TreeBaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医疗物品基本分类AggDO数据CRUD服务实现
 */
public class MmcategoryCrudServiceImpl extends TreeBaseDOService<MMCategoryDO>
		implements IMmcategoryCudService, IMmcategoryRService {

	public MmcategoryCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MMCategoryDODesc.class), IAppFwTempTbl.tmp_iaw_15.name());
	}

	@Override
	protected void addUpdateBeforeRule(CompareAroundProcesser<MMCategoryDO> processer, MMCategoryDO[] originvos) {
		super.addUpdateBeforeRule(processer, originvos);
		processer.addBeforeRule(new MMCategoryBeforeUpdateRule());
	}

	@Override
	protected void addUpdateAfterRule(CompareAroundProcesser<MMCategoryDO> processor, MMCategoryDO[] originvos) {
		super.addUpdateAfterRule(processor, originvos);
		processor.addAfterRule(new MMCategoryAfterUpdateRule());
	};

	@SuppressWarnings("unchecked")
	@Override
	protected void addLogicDeleteBeforeRule(AroundProcesser<MMCategoryDO> processer, int versionValidateType) {
		super.addLogicDeleteBeforeRule(processer, versionValidateType);
		processer.addBeforeRule(new MMCategoryBeforeDeleteRule());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addRealDeleteBeforeRule(AroundProcesser<MMCategoryDO> processer, int versionValidateType) {
		super.addRealDeleteBeforeRule(processer, versionValidateType);
		processer.addBeforeRule(new MMCategoryBeforeDeleteRule());
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
	protected Validator[] getUpdateValidator(MMCategoryDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
