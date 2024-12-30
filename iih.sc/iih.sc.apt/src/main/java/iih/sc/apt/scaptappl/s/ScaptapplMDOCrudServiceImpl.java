package iih.sc.apt.scaptappl.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.sc.apt.scaptappl.d.desc.ScAptApplDODesc;
import iih.sc.apt.scaptappl.d.ScAptApplDO;
import iih.sc.apt.scaptappl.i.IScaptapplMDOCudService;
import iih.sc.apt.scaptappl.i.IScaptapplMDORService;
import iih.sc.scbd.log.d.EuOperTp;
import iih.sc.scbd.log.rule.ScLogRule;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 计划排班_预约_申请主实体CRUD服务实现
 */
@Service(serviceInterfaces={IScaptapplMDOCudService.class,IScaptapplMDORService.class}, binding=Binding.JSONRPC)
public class ScaptapplMDOCrudServiceImpl extends BaseDOService<ScAptApplDO> implements IScaptapplMDOCudService,IScaptapplMDORService {

    public ScaptapplMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScAptApplDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
    
    @Override
    protected void addInsertAfterRule(AroundProcesser<ScAptApplDO> processor) {
    	super.addInsertAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<ScAptApplDO>(EuOperTp.INSERT));
    }
    
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<ScAptApplDO> processor, ScAptApplDO[] originvos) {
    	super.addUpdateAfterRule(processor, originvos);
    	processor.addAfterRule(new ScLogRule<ScAptApplDO>(EuOperTp.UPDATE, originvos));
    }
    
    @Override
    protected void addRealDeleteAfterRule(AroundProcesser<ScAptApplDO> processor) {
    	super.addRealDeleteAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<ScAptApplDO>(EuOperTp.DELETE));
    }
}

