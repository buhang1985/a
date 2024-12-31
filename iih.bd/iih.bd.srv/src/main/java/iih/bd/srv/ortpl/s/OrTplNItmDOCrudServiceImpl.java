package iih.bd.srv.ortpl.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.srv.ortpl.d.desc.OrTplNItmDODesc;
import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.bd.srv.ortpl.i.IOrTplNItmDOCudService;
import iih.bd.srv.ortpl.i.IOrTplNItmDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 医嘱模板主实体CRUD服务实现
 */
@Service(serviceInterfaces={IOrTplNItmDOCudService.class,IOrTplNItmDORService.class}, binding=Binding.JSONRPC)
public class OrTplNItmDOCrudServiceImpl extends BaseDOService<OrTplNItmDO> implements IOrTplNItmDOCudService,IOrTplNItmDORService {

    public OrTplNItmDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrTplNItmDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

