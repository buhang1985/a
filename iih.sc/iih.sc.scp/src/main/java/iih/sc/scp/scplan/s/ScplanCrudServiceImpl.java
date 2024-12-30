package iih.sc.scp.scplan.s;

import iih.sc.scbd.log.d.EuOperTp;
import iih.sc.scbd.log.rule.ScLogRule;
import iih.sc.scp.s.rule.CreateQueRule;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scplan.d.desc.ScPlanDODesc;
import iih.sc.scp.scplan.i.IScplanCudService;
import iih.sc.scp.scplan.i.IScplanRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 排班计划AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IScplanCudService.class, IScplanRService.class }, binding = Binding.JSONRPC)
public class ScplanCrudServiceImpl extends BaseDOService<ScPlanDO> implements IScplanCudService, IScplanRService {

	public ScplanCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(ScPlanDODesc.class), IAppFwTempTbl.tmp_iaw_29.name());
	}
	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
	/**
	 * 新增后规则
	 */
	@Override
	protected void addInsertAfterRule(AroundProcesser<ScPlanDO> processer) {
		super.addInsertAfterRule(processer);
		// 记录业务日志
		processer.addAfterRule(new ScLogRule<ScPlanDO>(EuOperTp.INSERT), new CreateQueRule<ScPlanDO>());
	}
	// 更新后规则
	@Override
	protected void addUpdateAfterRule(CompareAroundProcesser<ScPlanDO> processor, ScPlanDO[] originvos) {
		super.addUpdateAfterRule(processor, originvos);
		processor.addAfterRule(new CreateQueRule<ScPlanDO>(originvos));
		// 记录业务日志
		processor.addAfterRule(new ScLogRule<ScPlanDO>(EuOperTp.UPDATE, originvos));
	}
	// 删除后规则
	@Override
	protected void addRealDeleteAfterRule(AroundProcesser<ScPlanDO> processer) {
		super.addRealDeleteAfterRule(processer);
		processer.addAfterRule(new ScLogRule<ScPlanDO>(EuOperTp.DELETE), new CreateQueRule<ScPlanDO>());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(ScPlanDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
