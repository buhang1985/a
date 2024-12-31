package iih.bd.mm.supplier.s;

import iih.bd.mm.supplier.d.SupplierDO;
import iih.bd.mm.supplier.d.desc.SupplierDODesc;
import iih.bd.mm.supplier.i.ISupplierCudService;
import iih.bd.mm.supplier.i.ISupplierRService;
import iih.bd.mm.supplier.s.rule.SupplierAfterInsertOrUpdateRule;
import iih.bd.mm.supplier.s.rule.SupplierBeforeDeleteRule;
import iih.bd.mm.supplier.s.rule.SupplierBeforeInsertOrUpdateRule;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 供应商与厂商AggDO数据CRUD服务实现
 */
public class SupplierCrudServiceImpl extends BaseDOService<SupplierDO>
		implements ISupplierCudService, ISupplierRService {

	public SupplierCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(SupplierDODesc.class), IAppFwTempTbl.tmp_iaw_08.name());
	}

	@Override
	protected void addUpdateBeforeRule(CompareAroundProcesser<SupplierDO> processer, SupplierDO[] originvos) {
		super.addUpdateBeforeRule(processer, originvos);
		processer.addBeforeRule(new SupplierBeforeInsertOrUpdateRule());
	}
	
	@Override
	protected void addUpdateAfterRule(CompareAroundProcesser<SupplierDO> processer, SupplierDO[] originvos) {
		super.addUpdateBeforeRule(processer, originvos);
		processer.addBeforeRule(new SupplierAfterInsertOrUpdateRule());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addLogicDeleteBeforeRule(AroundProcesser<SupplierDO> processer, int versionValidateType) {
		super.addLogicDeleteBeforeRule(processer, versionValidateType);

		processer.addBeforeRule(new SupplierBeforeDeleteRule());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addRealDeleteBeforeRule(AroundProcesser<SupplierDO> processer, int versionValidateType) {
		super.addRealDeleteBeforeRule(processer, versionValidateType);

		processer.addBeforeRule(new SupplierBeforeDeleteRule());
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
	protected Validator[] getUpdateValidator(SupplierDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
