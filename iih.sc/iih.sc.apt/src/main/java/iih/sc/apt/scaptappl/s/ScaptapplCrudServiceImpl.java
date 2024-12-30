package iih.sc.apt.scaptappl.s;
import iih.sc.apt.scaptappl.d.ScAptApplDO;
import iih.sc.apt.scaptappl.d.ScaptapplAggDO;
import iih.sc.apt.scaptappl.d.desc.ScAptApplDODesc;
import iih.sc.apt.scaptappl.i.IScaptapplCudService;
import iih.sc.apt.scaptappl.i.IScaptapplRService;
import iih.sc.scbd.log.d.EuOperTp;
import iih.sc.scbd.log.rule.ScAggLogRule;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 计划排班_预约_申请AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IScaptapplCudService.class,IScaptapplRService.class}, binding=Binding.JSONRPC)
public class ScaptapplCrudServiceImpl extends BaseAggService<ScaptapplAggDO,ScAptApplDO> implements IScaptapplCudService,IScaptapplRService {
    public ScaptapplCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScAptApplDODesc.class),IAppFwTempTbl.tmp_iaw_04.name()); 
    }
    
    @Override
    protected void addInsertAfterRule(AroundProcesser<ScaptapplAggDO> processor) {
    	super.addInsertAfterRule(processor);
    	processor.addAfterRule(new ScAggLogRule<ScaptapplAggDO>(EuOperTp.INSERT));
    }
    
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<ScaptapplAggDO> processor, ScaptapplAggDO[] originvos) {
    	super.addUpdateAfterRule(processor, originvos);
    	processor.addAfterRule(new ScAggLogRule<ScaptapplAggDO>(EuOperTp.UPDATE, originvos));
    }
    
    @Override
    protected void addRealDeleteAfterRule(AroundProcesser<ScaptapplAggDO> processor) {
    	super.addRealDeleteAfterRule(processor);
    	processor.addAfterRule(new ScAggLogRule<ScaptapplAggDO>(EuOperTp.DELETE));
    }
}
