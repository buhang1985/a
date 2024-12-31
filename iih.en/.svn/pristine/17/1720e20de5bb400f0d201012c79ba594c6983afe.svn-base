package iih.en.pv.enfee.s;
import iih.en.pv.enfee.d.EnAccountDO;
import iih.en.pv.enfee.d.EnaccountAggDO;
import iih.en.pv.enfee.d.desc.EnAccountDODesc;
import iih.en.pv.enfee.i.IEnaccountCudService;
import iih.en.pv.enfee.i.IEnaccountRService;
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
 * 患者就诊_就诊账户AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnaccountCudService.class,IEnaccountRService.class}, binding=Binding.JSONRPC)
public class EnaccountCrudServiceImpl extends BaseAggService<EnaccountAggDO,EnAccountDO> implements IEnaccountCudService,IEnaccountRService {

    public EnaccountCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnAccountDODesc.class),IAppFwTempTbl.tmp_iaw_05.name()); 
    }
    
    @Override
    protected void addInsertAfterRule(AroundProcesser<EnaccountAggDO> processor) {
    	super.addInsertAfterRule(processor);
    	processor.addAfterRule(new ScAggLogRule<EnaccountAggDO>(EuOperTp.INSERT));
    }
    
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<EnaccountAggDO> processor, EnaccountAggDO[] originvos) {
    	super.addUpdateAfterRule(processor, originvos);
    	processor.addAfterRule(new ScAggLogRule<EnaccountAggDO>(EuOperTp.UPDATE, originvos));
    }
    
    @Override
    protected void addRealDeleteAfterRule(AroundProcesser<EnaccountAggDO> processor) {
    	super.addRealDeleteAfterRule(processor);
    	processor.addAfterRule(new ScAggLogRule<EnaccountAggDO>(EuOperTp.DELETE));
    }
}

