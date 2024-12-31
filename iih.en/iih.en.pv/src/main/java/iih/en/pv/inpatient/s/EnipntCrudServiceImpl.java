package iih.en.pv.inpatient.s;
import iih.en.pv.inpatient.d.EnipntAggDO;
import iih.en.pv.inpatient.d.EntIpntDO;
import iih.en.pv.inpatient.d.desc.EntIpntDODesc;
import iih.en.pv.inpatient.i.IEnipntCudService;
import iih.en.pv.inpatient.i.IEnipntRService;
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
 * 入院通知单AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnipntCudService.class,IEnipntRService.class}, binding=Binding.JSONRPC)
public class EnipntCrudServiceImpl extends BaseAggService<EnipntAggDO,EntIpntDO> implements IEnipntCudService,IEnipntRService {

    public EnipntCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EntIpntDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
    }
    
    @Override
    protected void addInsertAfterRule(AroundProcesser<EnipntAggDO> processor) {
    	super.addInsertAfterRule(processor);
    	processor.addAfterRule(new ScAggLogRule<EnipntAggDO>(EuOperTp.INSERT));
    }
    
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<EnipntAggDO> processor, EnipntAggDO[] originvos) {
    	super.addUpdateAfterRule(processor, originvos);
    	processor.addAfterRule(new ScAggLogRule<EnipntAggDO>(EuOperTp.UPDATE, originvos));
    }
    
    @Override
    protected void addRealDeleteAfterRule(AroundProcesser<EnipntAggDO> processor) {
    	super.addRealDeleteAfterRule(processor);
    	processor.addAfterRule(new ScAggLogRule<EnipntAggDO>(EuOperTp.DELETE));
    }
}

