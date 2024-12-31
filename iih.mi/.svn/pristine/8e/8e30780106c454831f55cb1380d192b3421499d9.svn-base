package iih.mi.mc.limitpsd.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.mc.limitpsd.d.desc.MiMcLimitPsdDODesc;
import iih.mi.mc.limitpsd.d.MiMcLimitPsdDO;
import iih.mi.mc.limitpsd.i.ILimitpsdCudService;
import iih.mi.mc.limitpsd.i.ILimitpsdRService;


/**
 * 禁止单方服务列表AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ILimitpsdCudService.class,ILimitpsdRService.class}, binding=Binding.JSONRPC)
public class LimitpsdCrudServiceImpl extends BaseDOService<MiMcLimitPsdDO> implements ILimitpsdCudService,ILimitpsdRService {
    public LimitpsdCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MiMcLimitPsdDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
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
    protected Validator[] getUpdateValidator(MiMcLimitPsdDO[] oldDOs) {
    	return new Validator[]{ new BDUniqueRuleValidate() };
    }
}
