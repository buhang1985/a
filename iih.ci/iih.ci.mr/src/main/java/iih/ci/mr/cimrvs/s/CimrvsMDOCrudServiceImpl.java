package iih.ci.mr.cimrvs.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mr.cimrvs.d.desc.CiMrVsDODesc;
import iih.ci.mr.cimrvs.d.CiMrVsDO;
import iih.ci.mr.cimrvs.i.ICimrvsMDOCudService;
import iih.ci.mr.cimrvs.i.ICimrvsMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 临床生命体征测量主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICimrvsMDOCudService.class,ICimrvsMDORService.class}, binding=Binding.JSONRPC)
public class CimrvsMDOCrudServiceImpl extends BaseDOService<CiMrVsDO> implements ICimrvsMDOCudService,ICimrvsMDORService {

    public CimrvsMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrVsDODesc.class),IAppFwTempTbl.tmp_iaw_23.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

