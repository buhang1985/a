package iih.ci.mr.cimrvt.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mr.cimrvt.d.desc.CiMrVtEvDODesc;
import iih.ci.mr.cimrvt.d.CiMrVtEvDO;
import iih.ci.mr.cimrvt.i.ICiMrVtEvDOCudService;
import iih.ci.mr.cimrvt.i.ICiMrVtEvDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 临床生命体征测量主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiMrVtEvDOCudService.class,ICiMrVtEvDORService.class}, binding=Binding.JSONRPC)
public class CiMrVtEvDOCrudServiceImpl extends BaseDOService<CiMrVtEvDO> implements ICiMrVtEvDOCudService,ICiMrVtEvDORService {

    public CiMrVtEvDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrVtEvDODesc.class),IAppFwTempTbl.tmp_iaw_28.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

