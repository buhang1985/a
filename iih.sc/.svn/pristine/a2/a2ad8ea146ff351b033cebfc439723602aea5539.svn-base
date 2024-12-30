package iih.sc.apt.scapt.s;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.d.ScaptAggDO;
import iih.sc.apt.scapt.d.desc.ScAptDODesc;
import iih.sc.apt.scapt.i.IScaptCudService;
import iih.sc.apt.scapt.i.IScaptRService;
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
 * 计划排班_预约AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IScaptCudService.class,IScaptRService.class}, binding=Binding.JSONRPC)
public class ScaptCrudServiceImpl extends BaseAggService<ScaptAggDO,ScAptDO> implements IScaptCudService,IScaptRService {
    public ScaptCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScAptDODesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
    }
    
    @Override
    protected void addInsertAfterRule(AroundProcesser<ScaptAggDO> processor) {
    	super.addInsertAfterRule(processor);
    	processor.addAfterRule(new ScAggLogRule<ScaptAggDO>(EuOperTp.INSERT));
    }
    
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<ScaptAggDO> processor, ScaptAggDO[] originvos) {
    	super.addUpdateAfterRule(processor, originvos);
    	processor.addAfterRule(new ScAggLogRule<ScaptAggDO>(EuOperTp.UPDATE, originvos));
    }
    
    @Override
    protected void addRealDeleteAfterRule(AroundProcesser<ScaptAggDO> processor) {
    	super.addRealDeleteAfterRule(processor);
    	processor.addAfterRule(new ScAggLogRule<ScaptAggDO>(EuOperTp.DELETE));
    }
}
