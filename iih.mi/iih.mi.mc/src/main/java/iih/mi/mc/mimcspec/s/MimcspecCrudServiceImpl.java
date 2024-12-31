package iih.mi.mc.mimcspec.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.mi.mc.mimcspec.d.MiMcSpecDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.permfw.pub.BDUniqueRuleValidate;
import iih.mi.mc.mimcspec.d.desc.MiMcSpecDODesc;
import iih.mi.mc.mimcspec.d.MimcspecAggDO;
import iih.mi.mc.mimcspec.i.IMimcspecCudService;
import iih.mi.mc.mimcspec.i.IMimcspecRService;


/**
 * 医保特殊病AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMimcspecCudService.class,IMimcspecRService.class}, binding=Binding.JSONRPC)
public class MimcspecCrudServiceImpl extends BaseAggService<MimcspecAggDO,MiMcSpecDO> implements IMimcspecCudService,IMimcspecRService {
    public MimcspecCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MiMcSpecDODesc.class),IAppFwTempTbl.tmp_iaw_22.name()); 
    }
    @Override
    protected Validator[] getInsertValidator() {
    	// TODO Auto-generated method stub
    	return new Validator[]{ new BDUniqueRuleValidate() };
    }
    
    @Override
    protected Validator[] getUpdateValidator(MimcspecAggDO[] oldDOs) {
    	// TODO Auto-generated method stub
    	return new Validator[]{ new BDUniqueRuleValidate() };
    }
}
