package iih.sc.sch.scticks.s;
import iih.sc.scbd.log.d.EuOperTp;
import iih.sc.scbd.log.rule.ScLogRule;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import iih.sc.sch.scticks.d.desc.ScSchTicksDODesc;
import iih.sc.sch.scticks.i.IScticksCudService;
import iih.sc.sch.scticks.i.IScticksRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 计划排班_号段AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IScticksCudService.class,IScticksRService.class}, binding=Binding.JSONRPC)
public class ScticksCrudServiceImpl extends BaseDOService<ScSchTicksDO> implements IScticksCudService,IScticksRService {
    public ScticksCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScSchTicksDODesc.class),IAppFwTempTbl.tmp_iaw_08.name()); 
    }
    /**
	 * 新增后规则
	 */
	@Override
	protected void addInsertAfterRule(AroundProcesser<ScSchTicksDO> processer) {
		super.addInsertAfterRule(processer);
		// 记录业务日志
		processer.addAfterRule(new ScLogRule<ScSchTicksDO>(EuOperTp.INSERT));
	}

	/**
	 * 更新后规则
	 */
	@Override
	protected void addUpdateAfterRule(CompareAroundProcesser<ScSchTicksDO> processer,
			ScSchTicksDO[] originvos) {
		super.addUpdateAfterRule(processer, originvos);

		// 记录业务日志
		processer.addAfterRule(new ScLogRule<ScSchTicksDO>(EuOperTp.UPDATE, originvos));
	}
	/**
	 * 删除后规则
	 * @param processer
	 */
	@Override
	protected void addRealDeleteAfterRule(AroundProcesser<ScSchTicksDO> processer) {
		super.addRealDeleteAfterRule(processer);
		processer.addAfterRule(new ScLogRule<ScSchTicksDO>(EuOperTp.DELETE));
	}
}
