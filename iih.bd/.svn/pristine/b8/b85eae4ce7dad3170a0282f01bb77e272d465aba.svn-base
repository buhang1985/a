package iih.bd.srv.mrcompleterule.s;
import iih.bd.srv.mrcompleterule.d.MrCompleteRuleDO;
import iih.bd.srv.mrcompleterule.d.desc.MrCompleteRuleDODesc;
import iih.bd.srv.mrcompleterule.i.IMrcompleteruleCudService;
import iih.bd.srv.mrcompleterule.i.IMrcompleteruleRService;
import iih.bd.srv.mrcompleterule.s.validate.MrcompleteruleValidate;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 病历完成规则AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMrcompleteruleCudService.class,IMrcompleteruleRService.class}, binding=Binding.JSONRPC)
public class MrcompleteruleCrudServiceImpl extends BaseDOService<MrCompleteRuleDO> implements IMrcompleteruleCudService,IMrcompleteruleRService {
    public MrcompleteruleCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrCompleteRuleDODesc.class),IAppFwTempTbl.tmp_iaw_21.name()); 
    }
    @Override
    protected Validator[] getInsertValidator() {
    	return new Validator[]{new BDUniqueRuleValidate(), new MrcompleteruleValidate()};
    }
    
    @Override
    protected Validator[] getUpdateValidator(MrCompleteRuleDO[] oldDOs) {
    	return new Validator[]{new BDUniqueRuleValidate(), new MrcompleteruleValidate()};
    }
}
