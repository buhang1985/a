package iih.en.pv.opreg.s;
import iih.en.pv.opreg.d.EnOpRegDO;
import iih.en.pv.opreg.d.desc.EnOpRegDODesc;
import iih.en.pv.opreg.i.IOpregCudService;
import iih.en.pv.opreg.i.IOpregRService;
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
 * 就诊登记记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IOpregCudService.class,IOpregRService.class}, binding=Binding.JSONRPC)
public class OpregCrudServiceImpl extends BaseDOService<EnOpRegDO> implements IOpregCudService,IOpregRService {
    public OpregCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnOpRegDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }
    
    @Override
    protected void addInsertAfterRule(AroundProcesser<EnOpRegDO> processor) {
    	super.addInsertAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<EnOpRegDO>(EuOperTp.INSERT));
    }
    
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<EnOpRegDO> processor, EnOpRegDO[] originvos) {
    	super.addUpdateAfterRule(processor, originvos);
    	processor.addAfterRule(new ScLogRule<EnOpRegDO>(EuOperTp.UPDATE, originvos));
    }
    
    @Override
    protected void addRealDeleteAfterRule(AroundProcesser<EnOpRegDO> processor) {
    	super.addRealDeleteAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<EnOpRegDO>(EuOperTp.DELETE));
    }
}
