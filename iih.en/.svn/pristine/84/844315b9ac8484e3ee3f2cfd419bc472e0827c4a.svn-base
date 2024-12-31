package iih.en.pv.inpatient.s;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.d.desc.InpatientDODesc;
import iih.en.pv.inpatient.i.IInpatientCudService;
import iih.en.pv.inpatient.i.IInpatientRService;
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
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IInpatientCudService.class,IInpatientRService.class}, binding=Binding.JSONRPC)
public class InpatientCrudServiceImpl extends BaseDOService<InpatientDO> implements IInpatientCudService,IInpatientRService {

    public InpatientCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(InpatientDODesc.class),IAppFwTempTbl.tmp_iaw_02.name()); 
    }
    
    @Override
    protected void addInsertAfterRule(AroundProcesser<InpatientDO> processor) {
    	super.addInsertAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<InpatientDO>(EuOperTp.INSERT));
    }
    
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<InpatientDO> processor, InpatientDO[] originvos) {
    	super.addUpdateAfterRule(processor, originvos);
    	processor.addAfterRule(new ScLogRule<InpatientDO>(EuOperTp.UPDATE, originvos));
    }
    
    @Override
    protected void addRealDeleteAfterRule(AroundProcesser<InpatientDO> processor) {
    	super.addRealDeleteAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<InpatientDO>(EuOperTp.DELETE));
    }
}

