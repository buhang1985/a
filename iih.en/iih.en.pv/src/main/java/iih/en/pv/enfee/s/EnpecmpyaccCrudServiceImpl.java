package iih.en.pv.enfee.s;
import iih.en.pv.enfee.d.EnPeCmpyACCDO;
import iih.en.pv.enfee.d.desc.EnPeCmpyACCDODesc;
import iih.en.pv.enfee.i.IEnpecmpyaccCudService;
import iih.en.pv.enfee.i.IEnpecmpyaccRService;
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
 * 团检账户AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnpecmpyaccCudService.class,IEnpecmpyaccRService.class}, binding=Binding.JSONRPC)
public class EnpecmpyaccCrudServiceImpl extends BaseDOService<EnPeCmpyACCDO> implements IEnpecmpyaccCudService,IEnpecmpyaccRService {
    public EnpecmpyaccCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnPeCmpyACCDODesc.class),IAppFwTempTbl.tmp_iaw_28.name()); 
    }
    
    @Override
    protected void addInsertAfterRule(AroundProcesser<EnPeCmpyACCDO> processor) {
    	super.addInsertAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<EnPeCmpyACCDO>(EuOperTp.INSERT));
    }
    
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<EnPeCmpyACCDO> processor, EnPeCmpyACCDO[] originvos) {
    	super.addUpdateAfterRule(processor, originvos);
    	processor.addAfterRule(new ScLogRule<EnPeCmpyACCDO>(EuOperTp.UPDATE, originvos));
    }
    
    @Override
    protected void addRealDeleteAfterRule(AroundProcesser<EnPeCmpyACCDO> processor) {
    	super.addRealDeleteAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<EnPeCmpyACCDO>(EuOperTp.DELETE));
    }
}
