package iih.en.pv.inpatient.s;
import iih.en.pv.inpatient.d.EnPeCmpyDO;
import iih.en.pv.inpatient.d.EnpecmpyAggDO;
import iih.en.pv.inpatient.d.desc.EnPeCmpyDODesc;
import iih.en.pv.inpatient.i.IEnpecmpyCudService;
import iih.en.pv.inpatient.i.IEnpecmpyRService;
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
 * 团检记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnpecmpyCudService.class,IEnpecmpyRService.class}, binding=Binding.JSONRPC)
public class EnpecmpyCrudServiceImpl extends BaseAggService<EnpecmpyAggDO,EnPeCmpyDO> implements IEnpecmpyCudService,IEnpecmpyRService {
    public EnpecmpyCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnPeCmpyDODesc.class),IAppFwTempTbl.tmp_iaw_02.name()); 
    }
    
    @Override
    protected void addInsertAfterRule(AroundProcesser<EnpecmpyAggDO> processor) {
    	super.addInsertAfterRule(processor);
    	processor.addAfterRule(new ScAggLogRule<EnpecmpyAggDO>(EuOperTp.INSERT));
    }
    
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<EnpecmpyAggDO> processor, EnpecmpyAggDO[] originvos) {
    	super.addUpdateAfterRule(processor, originvos);
    	processor.addAfterRule(new ScAggLogRule<EnpecmpyAggDO>(EuOperTp.UPDATE, originvos));
    }
    
    @Override
    protected void addRealDeleteAfterRule(AroundProcesser<EnpecmpyAggDO> processor) {
    	super.addRealDeleteAfterRule(processor);
    	processor.addAfterRule(new ScAggLogRule<EnpecmpyAggDO>(EuOperTp.DELETE));
    }
}
