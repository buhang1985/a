package iih.sc.sch.sctick.s;
import iih.sc.scbd.log.d.EuOperTp;
import iih.sc.scbd.log.rule.ScLogRule;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.sctick.d.desc.ScSchTickDODesc;
import iih.sc.sch.sctick.i.ISctickCudService;
import iih.sc.sch.sctick.i.ISctickRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISctickCudService.class,ISctickRService.class}, binding=Binding.JSONRPC)
public class SctickCrudServiceImpl extends BaseDOService<ScSchTickDO> implements ISctickCudService,ISctickRService {
    public SctickCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScSchTickDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
    }
    /**
	 * 新增后规则
	 */
	@Override
	protected void addInsertAfterRule(AroundProcesser<ScSchTickDO> processer) {
		super.addInsertAfterRule(processer);
		// 记录业务日志
		processer.addAfterRule(new ScLogRule<ScSchTickDO>(EuOperTp.INSERT));
	}

	/**
	 * 更新后规则
	 */
	@Override
	protected void addUpdateAfterRule(CompareAroundProcesser<ScSchTickDO> processer,
			ScSchTickDO[] originvos) {
		super.addUpdateAfterRule(processer, originvos);

		// 记录业务日志
		processer.addAfterRule(new ScLogRule<ScSchTickDO>(EuOperTp.UPDATE, originvos));
	}
	/**
	 * 删除后规则
	 * @param processer
	 */
	@Override
	protected void addRealDeleteAfterRule(AroundProcesser<ScSchTickDO> processer) {
		super.addRealDeleteAfterRule(processer);
		processer.addAfterRule(new ScLogRule<ScSchTickDO>(EuOperTp.DELETE));
	}
}
