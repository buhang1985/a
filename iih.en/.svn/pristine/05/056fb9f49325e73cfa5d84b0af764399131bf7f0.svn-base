package iih.en.pv.inpatient.s;
import iih.en.pv.inpatient.d.EnPeCmpyItmDO;
import iih.en.pv.inpatient.d.desc.EnPeCmpyItmDODesc;
import iih.en.pv.inpatient.i.IEnPeCmpyItmDOCudService;
import iih.en.pv.inpatient.i.IEnPeCmpyItmDORService;
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
@Service(serviceInterfaces={IEnPeCmpyItmDOCudService.class,IEnPeCmpyItmDORService.class}, binding=Binding.JSONRPC)
public class EnPeCmpyItmDOCrudServiceImpl extends BaseDOService<EnPeCmpyItmDO> implements IEnPeCmpyItmDOCudService,IEnPeCmpyItmDORService {

    public EnPeCmpyItmDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnPeCmpyItmDODesc.class),IAppFwTempTbl.tmp_iaw_22.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
    
    @Override
    protected void addInsertAfterRule(AroundProcesser<EnPeCmpyItmDO> processor) {
    	super.addInsertAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<EnPeCmpyItmDO>(EuOperTp.INSERT));
    }
    
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<EnPeCmpyItmDO> processor, EnPeCmpyItmDO[] originvos) {
    	super.addUpdateAfterRule(processor, originvos);
    	processor.addAfterRule(new ScLogRule<EnPeCmpyItmDO>(EuOperTp.UPDATE, originvos));
    }
    
    @Override
    protected void addRealDeleteAfterRule(AroundProcesser<EnPeCmpyItmDO> processor) {
    	super.addRealDeleteAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<EnPeCmpyItmDO>(EuOperTp.DELETE));
    }
}

