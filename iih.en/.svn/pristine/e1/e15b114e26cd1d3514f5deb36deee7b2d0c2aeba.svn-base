package iih.en.pv.enclin.s;
import iih.en.pv.enclin.d.EntStateDO;
import iih.en.pv.enclin.d.desc.EntStateDODesc;
import iih.en.pv.enclin.i.IEntstateCudService;
import iih.en.pv.enclin.i.IEntstateRService;
import iih.sc.scbd.log.d.EuOperTp;
import iih.sc.scbd.log.rule.ScLogRule;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 就诊状况AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEntstateCudService.class,IEntstateRService.class}, binding=Binding.JSONRPC)
public class EntstateCrudServiceImpl extends BaseDOService<EntStateDO> implements IEntstateCudService,IEntstateRService {

    public EntstateCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EntStateDODesc.class),IAppFwTempTbl.tmp_iaw_03.name()); 
    }
    
    @Override
    protected void addInsertAfterRule(AroundProcesser<EntStateDO> processor) {
    	super.addInsertAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<EntStateDO>(EuOperTp.INSERT));
    }
    
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<EntStateDO> processor, EntStateDO[] originvos) {
    	super.addUpdateAfterRule(processor, originvos);
    	processor.addAfterRule(new ScLogRule<EntStateDO>(EuOperTp.UPDATE, originvos));
    }
    
    @Override
    protected void addRealDeleteAfterRule(AroundProcesser<EntStateDO> processor) {
    	super.addRealDeleteAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<EntStateDO>(EuOperTp.DELETE));
    }
}

