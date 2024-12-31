package iih.bd.mm.certi.s;

import iih.bd.mm.certi.d.CertificationDO;
import iih.bd.mm.certi.d.desc.CertificationDODesc;
import iih.bd.mm.certi.i.ICertiCudService;
import iih.bd.mm.certi.i.ICertiRService;
import iih.bd.mm.certi.s.rule.CertificationAfterInsertOrUpdateRule;
import iih.bd.mm.certi.s.rule.CertificationBeforeDeleteRule;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医疗物品_资质证书字典AggDO数据CRUD服务实现
 */
public class CertiCrudServiceImpl extends BaseDOService<CertificationDO> implements ICertiCudService, ICertiRService {

	public CertiCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(CertificationDODesc.class), IAppFwTempTbl.tmp_iaw_14.name());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertAfterRule(AroundProcesser<CertificationDO> processer) {
		super.addInsertAfterRule(processer);
		processer.addAfterRule(new CertificationAfterInsertOrUpdateRule());
	}

	@Override
	protected void addUpdateAfterRule(CompareAroundProcesser<CertificationDO> processer, CertificationDO[] originvos) {
		super.addUpdateAfterRule(processer, originvos);
		processer.addAfterRule(new CertificationAfterInsertOrUpdateRule());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addLogicDeleteBeforeRule(AroundProcesser<CertificationDO> processer, int versionValidateType) {
		super.addLogicDeleteBeforeRule(processer, versionValidateType);
		processer.addBeforeRule(new CertificationBeforeDeleteRule());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addRealDeleteBeforeRule(AroundProcesser<CertificationDO> processer, int versionValidateType) {
		super.addRealDeleteBeforeRule(processer, versionValidateType);
		processer.addBeforeRule(new CertificationBeforeDeleteRule());
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
	protected Validator[] getUpdateValidator(CertificationDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
