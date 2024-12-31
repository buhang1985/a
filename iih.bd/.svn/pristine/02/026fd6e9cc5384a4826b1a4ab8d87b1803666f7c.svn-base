package iih.bd.fc.querule.s;
import iih.bd.fc.querule.d.QueRuleDO;
import iih.bd.fc.querule.d.desc.QueRuleDODesc;
import iih.bd.fc.querule.i.IQueruleMDOCudService;
import iih.bd.fc.querule.i.IQueruleMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;

/**
 * 队列规则主实体CRUD服务实现
 */
@Service(serviceInterfaces={IQueruleMDOCudService.class,IQueruleMDORService.class}, binding=Binding.JSONRPC)
public class QueruleMDOCrudServiceImpl extends BaseDOService<QueRuleDO> implements IQueruleMDOCudService,IQueruleMDORService {

    public QueruleMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(QueRuleDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }
    
//    @Override
//	protected Validator[] getDeleteValidator() {
//		return new Validator[] {
//				BDReferenceChecker.getInstance()
//		};
//	}
}

