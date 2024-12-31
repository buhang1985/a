package iih.mi.mibd.dep.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.mibd.dep.d.desc.DepDoDesc;
import iih.mi.mibd.dep.d.DepDo;
import iih.mi.mibd.dep.i.IDepCudService;
import iih.mi.mibd.dep.i.IDepRService;
import iih.mi.mibd.medorg.d.MedorgDo;


/**
 * 医保平台_科别AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IDepCudService.class,IDepRService.class}, binding=Binding.JSONRPC)
public class DepCrudServiceImpl extends BaseDOService<DepDo> implements IDepCudService,IDepRService {
    public DepCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(DepDoDesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
    @Override
    protected Validator[] getInsertValidator() {
    	return new Validator[] {new BDUniqueRuleValidate(),};
    }
    
    @Override
    protected Validator[] getUpdateValidator(DepDo[] oldDOs) {
    	
    	return new Validator[] { new BDUniqueRuleValidate()};
    }
    
    @Override
    protected Validator[] getDeleteValidator() {
    	return new Validator[] { BDReferenceChecker.getInstance() };
    }
}
