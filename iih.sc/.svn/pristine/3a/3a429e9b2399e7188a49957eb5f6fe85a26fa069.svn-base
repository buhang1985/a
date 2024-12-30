package iih.sc.apt.scaptappl.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.sc.apt.scaptappl.d.desc.ScAptApplOptDODesc;
import iih.sc.apt.scaptappl.d.ScAptApplDO;
import iih.sc.apt.scaptappl.d.ScAptApplOptDO;
import iih.sc.apt.scaptappl.i.IScAptApplOptDOCudService;
import iih.sc.apt.scaptappl.i.IScAptApplOptDORService;
import iih.sc.scbd.log.d.EuOperTp;
import iih.sc.scbd.log.rule.ScLogRule;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 计划排班_预约_申请主实体CRUD服务实现
 */
@Service(serviceInterfaces={IScAptApplOptDOCudService.class,IScAptApplOptDORService.class}, binding=Binding.JSONRPC)
public class ScAptApplOptDOCrudServiceImpl extends BaseDOService<ScAptApplOptDO> implements IScAptApplOptDOCudService,IScAptApplOptDORService {

    public ScAptApplOptDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScAptApplOptDODesc.class),IAppFwTempTbl.tmp_iaw_16.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
    
    @Override
    protected void addInsertAfterRule(AroundProcesser<ScAptApplOptDO> processor) {
    	super.addInsertAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<ScAptApplOptDO>(EuOperTp.INSERT));
    }
    
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<ScAptApplOptDO> processor, ScAptApplOptDO[] originvos) {
    	super.addUpdateAfterRule(processor, originvos);
    	processor.addAfterRule(new ScLogRule<ScAptApplOptDO>(EuOperTp.UPDATE, originvos));
    }
    
    @Override
    protected void addRealDeleteAfterRule(AroundProcesser<ScAptApplOptDO> processor) {
    	super.addRealDeleteAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<ScAptApplOptDO>(EuOperTp.DELETE));
    }
}

