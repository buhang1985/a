package iih.ci.mr.cimrvt.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mr.cimrvt.d.desc.CiMrVtItmDODesc;
import iih.ci.mr.cimrvt.d.CiMrVtItmDO;
import iih.ci.mr.cimrvt.i.ICiMrVtItmDOCudService;
import iih.ci.mr.cimrvt.i.ICiMrVtItmDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 临床生命体征测量主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiMrVtItmDOCudService.class,ICiMrVtItmDORService.class}, binding=Binding.JSONRPC)
public class CiMrVtItmDOCrudServiceImpl extends BaseDOService<CiMrVtItmDO> implements ICiMrVtItmDOCudService,ICiMrVtItmDORService {

    public CiMrVtItmDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrVtItmDODesc.class),IAppFwTempTbl.tmp_iaw_13.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

