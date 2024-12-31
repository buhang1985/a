package iih.en.pv.outpatient.s;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.outpatient.d.desc.OutpatientDODesc;
import iih.en.pv.outpatient.i.IOutpatientCudService;
import iih.en.pv.outpatient.i.IOutpatientRService;
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
@Service(serviceInterfaces={IOutpatientCudService.class,IOutpatientRService.class}, binding=Binding.JSONRPC)
public class OutpatientCrudServiceImpl extends BaseDOService<OutpatientDO> implements IOutpatientCudService,IOutpatientRService {
    public OutpatientCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OutpatientDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }

    @Override
    protected void addInsertAfterRule(AroundProcesser<OutpatientDO> processor) {
    	super.addInsertAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<OutpatientDO>(EuOperTp.INSERT));
    }
    
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<OutpatientDO> processor, OutpatientDO[] originvos) {
    	super.addUpdateAfterRule(processor, originvos);
    	processor.addAfterRule(new ScLogRule<OutpatientDO>(EuOperTp.UPDATE, originvos));
    }
    
    @Override
    protected void addRealDeleteAfterRule(AroundProcesser<OutpatientDO> processor) {
    	super.addRealDeleteAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<OutpatientDO>(EuOperTp.DELETE));
    }
}
