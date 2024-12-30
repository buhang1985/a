package iih.sc.scp.scpltick.s;

import iih.sc.scbd.log.d.EuOperTp;
import iih.sc.scbd.log.rule.ScLogRule;
import iih.sc.scp.scpltick.d.ScPlanWeekTickDO;
import iih.sc.scp.scpltick.d.desc.ScPlanWeekTickDODesc;
import iih.sc.scp.scpltick.i.IScpltickCudService;
import iih.sc.scp.scpltick.i.IScpltickRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;

/**
 * 排班计划号位AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IScpltickCudService.class, IScpltickRService.class }, binding = Binding.JSONRPC)
public class ScpltickCrudServiceImpl extends BaseDOService<ScPlanWeekTickDO>
		implements IScpltickCudService, IScpltickRService {

	public ScpltickCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(ScPlanWeekTickDODesc.class), IAppFwTempTbl.tmp_iaw_05.name());
	}

	/**
	 * 新增后规则
	 */
	@Override
	protected void addInsertAfterRule(AroundProcesser<ScPlanWeekTickDO> processer) {
		super.addInsertAfterRule(processer);
		// 记录业务日志
		processer.addAfterRule(new ScLogRule<ScPlanWeekTickDO>(EuOperTp.INSERT));
	}

	/**
	 * 更新后规则
	 */
	@Override
	protected void addUpdateAfterRule(CompareAroundProcesser<ScPlanWeekTickDO> processer,
			ScPlanWeekTickDO[] originvos) {
		super.addUpdateAfterRule(processer, originvos);

		// 记录业务日志
		processer.addAfterRule(new ScLogRule<ScPlanWeekTickDO>(EuOperTp.UPDATE, originvos));
	}
	/**
	 * 删除后规则
	 * @param processer
	 */
	@Override
	protected void addRealDeleteAfterRule(AroundProcesser<ScPlanWeekTickDO> processer) {
		super.addRealDeleteAfterRule(processer);
		processer.addAfterRule(new ScLogRule<ScPlanWeekTickDO>(EuOperTp.DELETE));
	}
}
