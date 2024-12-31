package iih.ci.mr.cimrvt.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mr.cimrvt.d.desc.CiMrVtDODesc;
import iih.ci.mr.cimrvt.d.CiMrVtDO;
import iih.ci.mr.cimrvt.i.ICimrvtMDOCudService;
import iih.ci.mr.cimrvt.i.ICimrvtMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 临床生命体征测量主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICimrvtMDOCudService.class,ICimrvtMDORService.class}, binding=Binding.JSONRPC)
public class CimrvtMDOCrudServiceImpl extends BaseDOService<CiMrVtDO> implements ICimrvtMDOCudService,ICimrvtMDORService {

    public CimrvtMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrVtDODesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

