package iih.en.pv.enhpreferral.s;
import iih.en.pv.enhpreferral.d.EnHpReferralDO;
import iih.en.pv.enhpreferral.d.desc.EnHpReferralDODesc;
import iih.en.pv.enhpreferral.i.IEnhpreferralCudService;
import iih.en.pv.enhpreferral.i.IEnhpreferralRService;
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
 * 医保转诊单AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnhpreferralCudService.class,IEnhpreferralRService.class}, binding=Binding.JSONRPC)
public class EnhpreferralCrudServiceImpl extends BaseDOService<EnHpReferralDO> implements IEnhpreferralCudService,IEnhpreferralRService {
    public EnhpreferralCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnHpReferralDODesc.class),IAppFwTempTbl.tmp_iaw_01.name()); 
    }

    @Override
    protected void addInsertAfterRule(AroundProcesser<EnHpReferralDO> processor) {
    	super.addInsertAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<EnHpReferralDO>(EuOperTp.INSERT));
    }
    
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<EnHpReferralDO> processor, EnHpReferralDO[] originvos) {
    	super.addUpdateAfterRule(processor, originvos);
    	processor.addAfterRule(new ScLogRule<EnHpReferralDO>(EuOperTp.UPDATE, originvos));
    }
    
    @Override
    protected void addRealDeleteAfterRule(AroundProcesser<EnHpReferralDO> processor) {
    	super.addRealDeleteAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<EnHpReferralDO>(EuOperTp.DELETE));
    }
}
