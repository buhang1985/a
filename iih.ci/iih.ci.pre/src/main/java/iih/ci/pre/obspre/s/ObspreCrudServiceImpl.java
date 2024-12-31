package iih.ci.pre.obspre.s;
import iih.ci.pre.obspre.d.ObsPreDO;
import iih.ci.pre.obspre.d.ObspreAggDO;
import iih.ci.pre.obspre.d.desc.ObsPreDODesc;
import iih.ci.pre.obspre.i.IObspreCudService;
import iih.ci.pre.obspre.i.IObspreRService;
import iih.ci.pre.obspre.s.rule.UpdateExtForInsertOrUpdateObsPreAfterRule;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 预检AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IObspreCudService.class,IObspreRService.class}, binding=Binding.JSONRPC)
public class ObspreCrudServiceImpl extends BaseAggService<ObspreAggDO,ObsPreDO> implements IObspreCudService,IObspreRService {

    public ObspreCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ObsPreDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }
    
    @Override
    protected void addInsertAfterRule(AroundProcesser<ObspreAggDO> processor) {
    	super.addInsertAfterRule(processor);
    	processor.addAfterRule(new UpdateExtForInsertOrUpdateObsPreAfterRule());
    }
    
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<ObspreAggDO> processor, ObspreAggDO[] originvos) {
    	super.addUpdateAfterRule(processor, originvos);
    	processor.addAfterRule(new UpdateExtForInsertOrUpdateObsPreAfterRule());
    }
}

