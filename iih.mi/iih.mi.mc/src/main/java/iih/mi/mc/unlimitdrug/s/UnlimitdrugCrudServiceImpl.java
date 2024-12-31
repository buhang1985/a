package iih.mi.mc.unlimitdrug.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.mc.unlimitdrug.d.desc.MiMcUnlimitDrugDODesc;
import iih.mi.mc.unlimitdrug.d.MiMcUnlimitDrugDO;
import iih.mi.mc.unlimitdrug.i.IUnlimitdrugCudService;
import iih.mi.mc.unlimitdrug.i.IUnlimitdrugRService;


/**
 * 不限量药品AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IUnlimitdrugCudService.class,IUnlimitdrugRService.class}, binding=Binding.JSONRPC)
public class UnlimitdrugCrudServiceImpl extends BaseDOService<MiMcUnlimitDrugDO> implements IUnlimitdrugCudService,IUnlimitdrugRService {
    public UnlimitdrugCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MiMcUnlimitDrugDODesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
    }
    
    @Override
    protected Validator[] getDeleteValidator() {
    	// TODO Auto-generated method stub
    	return new Validator[]{ BDReferenceChecker.getInstance() };
    }
    
    @Override
    protected Validator[] getInsertValidator() {
    	
    	return new Validator[]{ new BDUniqueRuleValidate() };
    }
    @Override
    protected Validator[] getUpdateValidator(MiMcUnlimitDrugDO[] oldDOs) {
    	return new Validator[]{ new BDUniqueRuleValidate() };
    }
    
}
