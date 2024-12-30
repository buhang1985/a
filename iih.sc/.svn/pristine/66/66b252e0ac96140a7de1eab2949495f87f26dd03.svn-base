package iih.sc.apt.scapt.s;
import iih.sc.apt.scapt.d.AptExChlDO;
import iih.sc.apt.scapt.d.desc.AptExChlDODesc;
import iih.sc.apt.scapt.i.IAptexchlCudService;
import iih.sc.apt.scapt.i.IAptexchlRService;
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
 * 预约外部渠道AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IAptexchlCudService.class,IAptexchlRService.class}, binding=Binding.JSONRPC)
public class AptexchlCrudServiceImpl extends BaseDOService<AptExChlDO> implements IAptexchlCudService,IAptexchlRService {
    public AptexchlCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(AptExChlDODesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
    }
    
    @Override
    protected void addInsertAfterRule(AroundProcesser<AptExChlDO> processor) {
    	super.addInsertAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<AptExChlDO>(EuOperTp.INSERT));
    }
    
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<AptExChlDO> processor, AptExChlDO[] originvos) {
    	super.addUpdateAfterRule(processor, originvos);
    	processor.addAfterRule(new ScLogRule<AptExChlDO>(EuOperTp.UPDATE, originvos));
    }
    
    @Override
    protected void addRealDeleteAfterRule(AroundProcesser<AptExChlDO> processor) {
    	super.addRealDeleteAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<AptExChlDO>(EuOperTp.DELETE));
    }
}
