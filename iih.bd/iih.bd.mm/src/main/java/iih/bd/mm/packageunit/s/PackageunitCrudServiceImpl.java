package iih.bd.mm.packageunit.s;

import iih.bd.mm.packageunit.d.PackageUnitDO;
import iih.bd.mm.packageunit.d.desc.PackageUnitDODesc;
import iih.bd.mm.packageunit.i.IPackageunitCudService;
import iih.bd.mm.packageunit.i.IPackageunitRService;
import iih.bd.mm.packageunit.s.rule.PackageUnitBeforeDeleteRule;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 组件AggDO数据CRUD服务实现
 */
public class PackageunitCrudServiceImpl extends BaseDOService<PackageUnitDO>
		implements IPackageunitCudService, IPackageunitRService {

	public PackageunitCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(PackageUnitDODesc.class), IAppFwTempTbl.tmp_iaw_27.name());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addLogicDeleteBeforeRule(AroundProcesser<PackageUnitDO> processor, int versionValidateType) {
		super.addLogicDeleteBeforeRule(processor, versionValidateType);
		processor.addAfterRule(new PackageUnitBeforeDeleteRule());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addRealDeleteBeforeRule(AroundProcesser<PackageUnitDO> processor, int versionValidateType) {
		super.addRealDeleteBeforeRule(processor, versionValidateType);
		processor.addAfterRule(new PackageUnitBeforeDeleteRule());
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
	protected Validator[] getUpdateValidator(PackageUnitDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
