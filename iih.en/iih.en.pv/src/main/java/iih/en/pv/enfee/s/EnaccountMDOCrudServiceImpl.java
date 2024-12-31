package iih.en.pv.enfee.s;
import iih.en.pv.enfee.d.EnAccountDO;
import iih.en.pv.enfee.d.desc.EnAccountDODesc;
import iih.en.pv.enfee.i.IEnaccountMDOCudService;
import iih.en.pv.enfee.i.IEnaccountMDORService;
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
 * 患者就诊_就诊账户主实体CRUD服务实现
 */
@Service(serviceInterfaces={IEnaccountMDOCudService.class,IEnaccountMDORService.class}, binding=Binding.JSONRPC)
public class EnaccountMDOCrudServiceImpl extends BaseDOService<EnAccountDO> implements IEnaccountMDOCudService,IEnaccountMDORService {

    public EnaccountMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnAccountDODesc.class),IAppFwTempTbl.tmp_iaw_17.name()); 
    }
    
    @Override
    protected void addInsertAfterRule(AroundProcesser<EnAccountDO> processor) {
    	super.addInsertAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<EnAccountDO>(EuOperTp.INSERT));
    }
    
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<EnAccountDO> processor, EnAccountDO[] originvos) {
    	super.addUpdateAfterRule(processor, originvos);
    	processor.addAfterRule(new ScLogRule<EnAccountDO>(EuOperTp.UPDATE, originvos));
    }
    
    @Override
    protected void addRealDeleteAfterRule(AroundProcesser<EnAccountDO> processor) {
    	super.addRealDeleteAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<EnAccountDO>(EuOperTp.DELETE));
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

