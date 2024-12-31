package iih.bd.pp.modifypriplan.s;
import iih.bd.pp.modifypriplan.d.ModifyPriPlanDO;
import iih.bd.pp.modifypriplan.d.ModifypriplanAggDO;
import iih.bd.pp.modifypriplan.d.desc.ModifyPriPlanDODesc;
import iih.bd.pp.modifypriplan.i.IModifypriplanCudService;
import iih.bd.pp.modifypriplan.i.IModifypriplanRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 调价计划AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IModifypriplanCudService.class,IModifypriplanRService.class}, binding=Binding.JSONRPC)
public class ModifypriplanCrudServiceImpl extends BaseAggService<ModifypriplanAggDO,ModifyPriPlanDO> implements IModifypriplanCudService,IModifypriplanRService {
    public ModifypriplanCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ModifyPriPlanDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }
    
    @Override
    protected Validator[] getInsertValidator() {
    	return new Validator[]{new BDUniqueRuleValidate()};
    }
    
    @Override
    protected Validator[] getUpdateValidator(ModifypriplanAggDO[] oldDOs) {
    	return new Validator[]{new BDUniqueRuleValidate()};
    }
}
