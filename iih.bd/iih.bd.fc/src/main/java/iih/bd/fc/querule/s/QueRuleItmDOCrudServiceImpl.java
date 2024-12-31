package iih.bd.fc.querule.s;
import iih.bd.fc.querule.d.QueRuleItmDO;
import iih.bd.fc.querule.d.desc.QueRuleItmDODesc;
import iih.bd.fc.querule.i.IQueRuleItmDOCudService;
import iih.bd.fc.querule.i.IQueRuleItmDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;

/**
 * 队列规则主实体CRUD服务实现
 */
@Service(serviceInterfaces={IQueRuleItmDOCudService.class,IQueRuleItmDORService.class}, binding=Binding.JSONRPC)
public class QueRuleItmDOCrudServiceImpl extends BaseDOService<QueRuleItmDO> implements IQueRuleItmDOCudService,IQueRuleItmDORService {

    public QueRuleItmDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(QueRuleItmDODesc.class),IAppFwTempTbl.tmp_iaw_28.name()); 
    }
    
//    @Override
//	protected Validator[] getDeleteValidator() {
//		return new Validator[] {
//				BDReferenceChecker.getInstance()
//		};
//	}
}

