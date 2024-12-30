package iih.sc.apt.scapt.s;
import iih.sc.apt.scapt.d.ScAptOpDO;
import iih.sc.apt.scapt.d.desc.ScAptOpDODesc;
import iih.sc.apt.scapt.i.IScAptOpDOCudService;
import iih.sc.apt.scapt.i.IScAptOpDORService;
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
@Service(serviceInterfaces={IScAptOpDOCudService.class,IScAptOpDORService.class}, binding=Binding.JSONRPC)
public class ScAptOpDOCrudServiceImpl extends BaseDOService<ScAptOpDO> implements IScAptOpDOCudService,IScAptOpDORService {

    public ScAptOpDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScAptOpDODesc.class),IAppFwTempTbl.tmp_iaw_15.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}

    @Override
    protected void addInsertAfterRule(AroundProcesser<ScAptOpDO> processor) {
    	super.addInsertAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<ScAptOpDO>(EuOperTp.INSERT));
    }
    
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<ScAptOpDO> processor, ScAptOpDO[] originvos) {
    	super.addUpdateAfterRule(processor, originvos);
    	processor.addAfterRule(new ScLogRule<ScAptOpDO>(EuOperTp.UPDATE, originvos));
    }
    
    @Override
    protected void addRealDeleteAfterRule(AroundProcesser<ScAptOpDO> processor) {
    	super.addRealDeleteAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<ScAptOpDO>(EuOperTp.DELETE));
    }
}

