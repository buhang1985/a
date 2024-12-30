package iih.sc.apt.scapt.s;
import iih.sc.apt.scapt.d.AptOpOralDO;
import iih.sc.apt.scapt.d.desc.AptOpOralDODesc;
import iih.sc.apt.scapt.i.IAptoporalCudService;
import iih.sc.apt.scapt.i.IAptoporalRService;
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
 * 口腔门诊预约AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IAptoporalCudService.class,IAptoporalRService.class}, binding=Binding.JSONRPC)
public class AptoporalCrudServiceImpl extends BaseDOService<AptOpOralDO> implements IAptoporalCudService,IAptoporalRService {
    public AptoporalCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(AptOpOralDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }

    @Override
    protected void addInsertAfterRule(AroundProcesser<AptOpOralDO> processor) {
    	super.addInsertAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<AptOpOralDO>(EuOperTp.INSERT));
    }
    
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<AptOpOralDO> processor, AptOpOralDO[] originvos) {
    	super.addUpdateAfterRule(processor, originvos);
    	processor.addAfterRule(new ScLogRule<AptOpOralDO>(EuOperTp.UPDATE, originvos));
    }
    
    @Override
    protected void addRealDeleteAfterRule(AroundProcesser<AptOpOralDO> processor) {
    	super.addRealDeleteAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<AptOpOralDO>(EuOperTp.DELETE));
    }
}
