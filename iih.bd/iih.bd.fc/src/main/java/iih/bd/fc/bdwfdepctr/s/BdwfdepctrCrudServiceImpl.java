package iih.bd.fc.bdwfdepctr.s;
import iih.bd.fc.bdwfdepctr.d.BdWfDepCtrDO;
import iih.bd.fc.bdwfdepctr.d.desc.BdWfDepCtrDODesc;
import iih.bd.fc.bdwfdepctr.i.IBdwfdepctrCudService;
import iih.bd.fc.bdwfdepctr.i.IBdwfdepctrRService;
import iih.bd.fc.bdwfdepctr.s.validator.WfDepCtrValidator;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 流程配置_医嘱流向_整体控制AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBdwfdepctrCudService.class,IBdwfdepctrRService.class}, binding=Binding.JSONRPC)
public class BdwfdepctrCrudServiceImpl extends BaseDOService<BdWfDepCtrDO> implements IBdwfdepctrCudService,IBdwfdepctrRService {
    public BdwfdepctrCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdWfDepCtrDODesc.class),IAppFwTempTbl.tmp_iaw_19.name()); 
    }
    
    @Override
    protected Validator[] getDeleteValidator() {
    	return new Validator[] { BDReferenceChecker.getInstance() };
    }
    
//    @Override
//    protected Validator[] getInsertValidator() {
//    	return new Validator[] { new BDUniqueRuleValidate(), new WfDepCtrValidator() };
//    }
  
//    @Override
//    protected Validator[] getUpdateValidator(BdWfDepCtrDO[] oldDOs) {
//    	return new Validator[] { new BDUniqueRuleValidate(), new WfDepCtrValidator() };
//    }
}
 