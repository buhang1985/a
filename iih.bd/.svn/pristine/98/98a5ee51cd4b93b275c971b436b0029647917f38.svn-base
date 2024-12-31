package iih.bd.srv.operateprocess.s;
import iih.bd.srv.operateprocess.d.OperateProcessDO;
import iih.bd.srv.operateprocess.d.desc.OperateProcessDODesc;
import iih.bd.srv.operateprocess.i.IOperateprocessCudService;
import iih.bd.srv.operateprocess.i.IOperateprocessRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 操作流程AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IOperateprocessCudService.class,IOperateprocessRService.class}, binding=Binding.JSONRPC)
public class OperateprocessCrudServiceImpl extends BaseDOService<OperateProcessDO> implements IOperateprocessCudService,IOperateprocessRService {
    public OperateprocessCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OperateProcessDODesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }
    
    @Override
    protected Validator[] getInsertValidator() {
    	return new Validator[] { new BDUniqueRuleValidate() };
    }
    
    @Override
    protected Validator[] getUpdateValidator(OperateProcessDO[] oldDOs) {
    	return new Validator[] { new BDUniqueRuleValidate() };
    }
    
    @Override
    protected Validator[] getDeleteValidator() {
    	return new Validator[] { BDReferenceChecker.getInstance() };
    }
}
