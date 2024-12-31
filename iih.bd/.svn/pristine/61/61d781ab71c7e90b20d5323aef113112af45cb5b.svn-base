package iih.bd.bc.condition.s;

import iih.bd.bc.condition.d.ConditionCateDO;
import iih.bd.bc.condition.d.ConditionDO;
import iih.bd.bc.condition.d.desc.ConditionCateDODesc;
import iih.bd.bc.condition.i.IConditionRService;
import iih.bd.bc.condition.i.IConditioncateCudService;
import iih.bd.bc.condition.i.IConditioncateRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.TreeBaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;

/**
 * 条件指标分类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IConditioncateCudService.class,
		IConditioncateRService.class }, binding = Binding.JSONRPC)
public class ConditioncateCrudServiceImpl extends
		TreeBaseDOService<ConditionCateDO> implements IConditioncateCudService,
		IConditioncateRService {

	public ConditioncateCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(ConditionCateDODesc.class),
				IAppFwTempTbl.tmp_iaw_17.name());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addRealDeleteBeforeRule(
			AroundProcesser<ConditionCateDO> processer, int versionValidateType) {
		super.addRealDeleteBeforeRule(processer, versionValidateType);
		// 检查是否允许删除
		processer.addBeforeRule(new IRule<ConditionCateDO>() {
			@Override
			public void process(ConditionCateDO... dos) throws BizException {
				for (ConditionCateDO conditionCateDO : dos) {
					processBeforeDelete(conditionCateDO);
				}
			}

		});
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addLogicDeleteBeforeRule(
			AroundProcesser<ConditionCateDO> processer, int versionValidateType) {
		super.addLogicDeleteBeforeRule(processer, versionValidateType);
		// 检查是否允许删除
		processer.addBeforeRule(new IRule<ConditionCateDO>() {
			@Override
			public void process(ConditionCateDO... dos) throws BizException {
				for (ConditionCateDO conditionCateDO : dos) {
					processBeforeDelete(conditionCateDO);
				}
			}

		});
	}

	protected void processBeforeDelete(ConditionCateDO conditionCateDO)
			throws BizException {
		// 检查条件指标体系是否使用此分类
		IConditionRService conditionRService = ServiceFinder
				.find(IConditionRService.class);
		String whereStr = String
				.format("a0.id_grp = '%s' and a0.id_org = '%s' and a0.id_contica = '%s' and a0.ds = 0",
						Context.get().getGroupId(), Context.get().getOrgId(),
						conditionCateDO.getId_contica());
		ConditionDO[] result = conditionRService.find(whereStr, "",
				FBoolean.FALSE);
		if (result.length > 0)
			throw new BizException(String.format(
					"该条件指标体系分类下存在条件指标体系数据,无法删除.\n分类名称:%s",
					conditionCateDO.getName()));

	}
}
