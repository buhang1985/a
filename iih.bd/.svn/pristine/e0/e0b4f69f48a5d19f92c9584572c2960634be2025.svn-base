package iih.bd.srv.ortpl.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.srv.ortpl.d.desc.OrTmplDODesc;
import iih.bd.srv.ortpl.d.OrTmplDO;
import iih.bd.srv.ortpl.i.IOrtmplMDOCudService;
import iih.bd.srv.ortpl.i.IOrtmplMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 医嘱模板主实体CRUD服务实现
 */
@Service(serviceInterfaces={IOrtmplMDOCudService.class,IOrtmplMDORService.class}, binding=Binding.JSONRPC)
public class OrtmplMDOCrudServiceImpl extends BaseDOService<OrTmplDO> implements IOrtmplMDOCudService,IOrtmplMDORService {

    public OrtmplMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrTmplDODesc.class),IAppFwTempTbl.tmp_iaw_26.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

