package iih.bd.srv.bddsdef.s;
import iih.bd.srv.bddsdef.d.BdDsDefDO;
import iih.bd.srv.bddsdef.d.desc.BdDsDefDODesc;
import iih.bd.srv.bddsdef.i.IBddsdefCudService;
import iih.bd.srv.bddsdef.i.IBddsdefRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 疾病病种定义AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBddsdefCudService.class,IBddsdefRService.class}, binding=Binding.JSONRPC)
public class BddsdefCrudServiceImpl extends BaseDOService<BdDsDefDO> implements IBddsdefCudService,IBddsdefRService {
    public BddsdefCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdDsDefDODesc.class),IAppFwTempTbl.tmp_iaw_15.name()); 
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
    protected Validator[] getUpdateValidator(BdDsDefDO[] oldDOs) {
    	return new Validator[]{ new BDUniqueRuleValidate() };
    }
    
}
