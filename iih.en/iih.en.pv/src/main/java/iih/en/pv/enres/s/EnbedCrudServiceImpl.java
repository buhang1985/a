package iih.en.pv.enres.s;
import iih.en.pv.enres.d.EnBedDO;
import iih.en.pv.enres.d.desc.EnBedDODesc;
import iih.en.pv.enres.i.IEnbedCudService;
import iih.en.pv.enres.i.IEnbedRService;
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
 * 患者就诊_床位AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnbedCudService.class,IEnbedRService.class}, binding=Binding.JSONRPC)
public class EnbedCrudServiceImpl extends BaseDOService<EnBedDO> implements IEnbedCudService,IEnbedRService {

    public EnbedCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnBedDODesc.class),IAppFwTempTbl.tmp_iaw_19.name()); 
    }
    
    @Override
    protected void addInsertAfterRule(AroundProcesser<EnBedDO> processor) {
    	super.addInsertAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<EnBedDO>(EuOperTp.INSERT));
    }
    
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<EnBedDO> processor, EnBedDO[] originvos) {
    	super.addUpdateAfterRule(processor, originvos);
    	processor.addAfterRule(new ScLogRule<EnBedDO>(EuOperTp.UPDATE, originvos));
    }
    
    @Override
    protected void addRealDeleteAfterRule(AroundProcesser<EnBedDO> processor) {
    	super.addRealDeleteAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<EnBedDO>(EuOperTp.DELETE));
    }
}

