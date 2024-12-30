package iih.sc.apt.scapt.s;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.d.desc.ScAptDODesc;
import iih.sc.apt.scapt.i.IScaptMDOCudService;
import iih.sc.apt.scapt.i.IScaptMDORService;
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
@Service(serviceInterfaces={IScaptMDOCudService.class,IScaptMDORService.class}, binding=Binding.JSONRPC)
public class ScaptMDOCrudServiceImpl extends BaseDOService<ScAptDO> implements IScaptMDOCudService,IScaptMDORService {

    public ScaptMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScAptDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
    
    @Override
    protected void addInsertAfterRule(AroundProcesser<ScAptDO> processor) {
    	super.addInsertAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<ScAptDO>(EuOperTp.INSERT));
    }
    
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<ScAptDO> processor, ScAptDO[] originvos) {
    	super.addUpdateAfterRule(processor, originvos);
    	processor.addAfterRule(new ScLogRule<ScAptDO>(EuOperTp.UPDATE, originvos));
    }
    
    @Override
    protected void addRealDeleteAfterRule(AroundProcesser<ScAptDO> processor) {
    	super.addRealDeleteAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<ScAptDO>(EuOperTp.DELETE));
    }
}

