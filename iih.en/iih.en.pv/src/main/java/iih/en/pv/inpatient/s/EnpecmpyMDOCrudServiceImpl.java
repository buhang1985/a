package iih.en.pv.inpatient.s;
import iih.en.pv.inpatient.d.EnPeCmpyDO;
import iih.en.pv.inpatient.d.desc.EnPeCmpyDODesc;
import iih.en.pv.inpatient.i.IEnpecmpyMDOCudService;
import iih.en.pv.inpatient.i.IEnpecmpyMDORService;
import iih.sc.scbd.log.d.EuOperTp;
import iih.sc.scbd.log.rule.ScLogRule;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 团检记录主实体CRUD服务实现
 */
@Service(serviceInterfaces={IEnpecmpyMDOCudService.class,IEnpecmpyMDORService.class}, binding=Binding.JSONRPC)
public class EnpecmpyMDOCrudServiceImpl extends BaseDOService<EnPeCmpyDO> implements IEnpecmpyMDOCudService,IEnpecmpyMDORService {

    public EnpecmpyMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnPeCmpyDODesc.class),IAppFwTempTbl.tmp_iaw_03.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
    
    @Override
    protected void addInsertAfterRule(AroundProcesser<EnPeCmpyDO> processor) {
    	super.addInsertAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<EnPeCmpyDO>(EuOperTp.INSERT));
    }
    
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<EnPeCmpyDO> processor, EnPeCmpyDO[] originvos) {
    	super.addUpdateAfterRule(processor, originvos);
    	processor.addAfterRule(new ScLogRule<EnPeCmpyDO>(EuOperTp.UPDATE, originvos));
    }
    
    @Override
    protected void addRealDeleteAfterRule(AroundProcesser<EnPeCmpyDO> processor) {
    	super.addRealDeleteAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<EnPeCmpyDO>(EuOperTp.DELETE));
    }
}
