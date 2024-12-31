package iih.en.que.enqueue.s;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.enqueue.d.desc.EnQueueDODesc;
import iih.en.que.enqueue.i.IEnqueueCudService;
import iih.en.que.enqueue.i.IEnqueueRService;
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
 * 患者就诊_队列AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnqueueCudService.class,IEnqueueRService.class}, binding=Binding.JSONRPC)
public class EnqueueCrudServiceImpl extends BaseDOService<EnQueueDO> implements IEnqueueCudService,IEnqueueRService {

    public EnqueueCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnQueueDODesc.class),IAppFwTempTbl.tmp_iaw_17.name()); 
    }
    
    @Override
    protected void addInsertAfterRule(AroundProcesser<EnQueueDO> processor) {
    	super.addInsertAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<EnQueueDO>(EuOperTp.INSERT));
    }
    
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<EnQueueDO> processor, EnQueueDO[] originvos) {
    	super.addUpdateAfterRule(processor, originvos);
    	processor.addAfterRule(new ScLogRule<EnQueueDO>(EuOperTp.UPDATE, originvos));
    }
    
    @Override
    protected void addRealDeleteAfterRule(AroundProcesser<EnQueueDO> processor) {
    	super.addRealDeleteAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<EnQueueDO>(EuOperTp.DELETE));
    }
}

