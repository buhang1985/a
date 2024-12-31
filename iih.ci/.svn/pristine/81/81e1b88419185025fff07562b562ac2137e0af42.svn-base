package iih.ci.mr.cimrvs.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mr.cimrvs.d.desc.CiMrVsItmDODesc;
import iih.ci.mr.cimrvs.d.CiMrVsItmDO;
import iih.ci.mr.cimrvs.i.ICiMrVsItmDOCudService;
import iih.ci.mr.cimrvs.i.ICiMrVsItmDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 临床生命体征测量主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiMrVsItmDOCudService.class,ICiMrVsItmDORService.class}, binding=Binding.JSONRPC)
public class CiMrVsItmDOCrudServiceImpl extends BaseDOService<CiMrVsItmDO> implements ICiMrVsItmDOCudService,ICiMrVsItmDORService {

    public CiMrVsItmDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrVsItmDODesc.class),IAppFwTempTbl.tmp_iaw_05.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

