package iih.bd.srv.mrbasetpl.s;

import iih.bd.srv.mrbasetpl.d.EmrBaseTplDO;
import iih.bd.srv.mrbasetpl.d.desc.EmrBaseTplDODesc;
import iih.bd.srv.mrbasetpl.i.IMrbasetplCudService;
import iih.bd.srv.mrbasetpl.i.IMrbasetplRService;
import iih.bd.srv.mrbasetpl.rule.AfterInsertEmrBaseTplRule;
import iih.bd.srv.mrbasetpl.rule.AfterUpdateEmrBaseTplRule;
import iih.bd.srv.mrbasetpl.rule.BeforeLogicDeleteEmrBaseTplRule;
import iih.bd.srv.mrbasetpl.rule.BeforeRealDeleteEmrBaseTplRule;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.custcfg.billcode.pub.BillCodeGenerateRule;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医疗记录基础模板AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IMrbasetplCudService.class, IMrbasetplRService.class }, binding = Binding.JSONRPC)
public class MrbasetplCrudServiceImpl extends BaseDOService<EmrBaseTplDO>
		implements IMrbasetplCudService, IMrbasetplRService {

	public MrbasetplCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(EmrBaseTplDODesc.class), IAppFwTempTbl.tmp_iaw_12.name());
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance(new String[] { "bd_base_mrtpl_fs" }) };
	}
	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(EmrBaseTplDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void addRealDeleteBeforeRule(AroundProcesser<EmrBaseTplDO> processer, int versionValidateType) {
		super.addRealDeleteBeforeRule(processer, versionValidateType);
		processer.addBeforeRule(new BeforeRealDeleteEmrBaseTplRule());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void addLogicDeleteBeforeRule(AroundProcesser<EmrBaseTplDO> processer, int versionValidateType) {
		super.addLogicDeleteBeforeRule(processer, versionValidateType);
		processer.addBeforeRule(new BeforeLogicDeleteEmrBaseTplRule());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertAfterRule(AroundProcesser<EmrBaseTplDO> processor) {
		super.addInsertAfterRule(processor);
		processor.addAfterRule(new AfterInsertEmrBaseTplRule());
	}
	
	@Override
	protected void addUpdateAfterRule(CompareAroundProcesser<EmrBaseTplDO> processor, EmrBaseTplDO[] originvos) {
		super.addUpdateAfterRule(processor, originvos);
		processor.addAfterRule(new AfterUpdateEmrBaseTplRule());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertBeforeRule(AroundProcesser<EmrBaseTplDO> processer) {
		super.addInsertBeforeRule(processer);
		processer.addBeforeRule(new BillCodeGenerateRule<EmrBaseTplDO>());
	}
}
