package iih.sc.apt.scapt.s;
import iih.sc.apt.scapt.d.ScAptOptDO;
import iih.sc.apt.scapt.d.desc.ScAptOptDODesc;
import iih.sc.apt.scapt.i.IScAptOptDOCudService;
import iih.sc.apt.scapt.i.IScAptOptDORService;
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
 * 计划排班_预约主实体CRUD服务实现
 */
@Service(serviceInterfaces={IScAptOptDOCudService.class,IScAptOptDORService.class}, binding=Binding.JSONRPC)
public class ScAptOptDOCrudServiceImpl extends BaseDOService<ScAptOptDO> implements IScAptOptDOCudService,IScAptOptDORService {

    public ScAptOptDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScAptOptDODesc.class),IAppFwTempTbl.tmp_iaw_28.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
    
    @Override
    protected void addInsertAfterRule(AroundProcesser<ScAptOptDO> processor) {
    	super.addInsertAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<ScAptOptDO>(EuOperTp.INSERT));
    }
    
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<ScAptOptDO> processor, ScAptOptDO[] originvos) {
    	super.addUpdateAfterRule(processor, originvos);
    	processor.addAfterRule(new ScLogRule<ScAptOptDO>(EuOperTp.UPDATE, originvos));
    }
    
    @Override
    protected void addRealDeleteAfterRule(AroundProcesser<ScAptOptDO> processor) {
    	super.addRealDeleteAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<ScAptOptDO>(EuOperTp.DELETE));
    }
}

