package iih.sc.apt.scapt.s;
import iih.sc.apt.scapt.d.ScAptMtDO;
import iih.sc.apt.scapt.d.desc.ScAptMtDODesc;
import iih.sc.apt.scapt.i.IScAptMtDOCudService;
import iih.sc.apt.scapt.i.IScAptMtDORService;
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
@Service(serviceInterfaces={IScAptMtDOCudService.class,IScAptMtDORService.class}, binding=Binding.JSONRPC)
public class ScAptMtDOCrudServiceImpl extends BaseDOService<ScAptMtDO> implements IScAptMtDOCudService,IScAptMtDORService {

    public ScAptMtDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScAptMtDODesc.class),IAppFwTempTbl.tmp_iaw_21.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}

    @Override
    protected void addInsertAfterRule(AroundProcesser<ScAptMtDO> processor) {
    	super.addInsertAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<ScAptMtDO>(EuOperTp.INSERT));
    }
    
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<ScAptMtDO> processor, ScAptMtDO[] originvos) {
    	super.addUpdateAfterRule(processor, originvos);
    	processor.addAfterRule(new ScLogRule<ScAptMtDO>(EuOperTp.UPDATE, originvos));
    }
    
    @Override
    protected void addRealDeleteAfterRule(AroundProcesser<ScAptMtDO> processor) {
    	super.addRealDeleteAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<ScAptMtDO>(EuOperTp.DELETE));
    }
}

