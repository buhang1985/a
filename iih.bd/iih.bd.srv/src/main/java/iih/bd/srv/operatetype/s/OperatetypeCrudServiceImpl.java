package iih.bd.srv.operatetype.s;
import iih.bd.srv.operatetype.d.OperateTypeDO;
import iih.bd.srv.operatetype.d.desc.OperateTypeDODesc;
import iih.bd.srv.operatetype.i.IOperatetypeCudService;
import iih.bd.srv.operatetype.i.IOperatetypeRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 操作类型AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IOperatetypeCudService.class,IOperatetypeRService.class}, binding=Binding.JSONRPC)
public class OperatetypeCrudServiceImpl extends BaseDOService<OperateTypeDO> implements IOperatetypeCudService,IOperatetypeRService {
    public OperatetypeCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OperateTypeDODesc.class),IAppFwTempTbl.tmp_iaw_16.name()); 
    }
    
    @Override
    protected Validator[] getInsertValidator() {
    	return new Validator[] { new BDUniqueRuleValidate() };
    }
    
    @Override
    protected Validator[] getUpdateValidator(OperateTypeDO[] oldDOs) {
    	return new Validator[] { new BDUniqueRuleValidate() };
    }
    
    @Override
    protected Validator[] getDeleteValidator() {
    	return new Validator[] { BDReferenceChecker.getInstance() };
    }
}
