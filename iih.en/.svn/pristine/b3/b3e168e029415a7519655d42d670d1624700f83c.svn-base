package iih.en.pv.inpatient.s;
import iih.en.pv.inpatient.d.EntIpntDO;
import iih.en.pv.inpatient.d.desc.EntIpntDODesc;
import iih.en.pv.inpatient.i.IEnipntMDOCudService;
import iih.en.pv.inpatient.i.IEnipntMDORService;
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
 * 入院通知单主实体CRUD服务实现
 */
@Service(serviceInterfaces={IEnipntMDOCudService.class,IEnipntMDORService.class}, binding=Binding.JSONRPC)
public class EnipntMDOCrudServiceImpl extends BaseDOService<EntIpntDO> implements IEnipntMDOCudService,IEnipntMDORService {

    public EnipntMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EntIpntDODesc.class),IAppFwTempTbl.tmp_iaw_09.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
    
    @Override
    protected void addInsertAfterRule(AroundProcesser<EntIpntDO> processor) {
    	super.addInsertAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<EntIpntDO>(EuOperTp.INSERT));
    }
    
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<EntIpntDO> processor, EntIpntDO[] originvos) {
    	super.addUpdateAfterRule(processor, originvos);
    	processor.addAfterRule(new ScLogRule<EntIpntDO>(EuOperTp.UPDATE, originvos));
    }
    
    @Override
    protected void addRealDeleteAfterRule(AroundProcesser<EntIpntDO> processor) {
    	super.addRealDeleteAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<EntIpntDO>(EuOperTp.DELETE));
    }
}

