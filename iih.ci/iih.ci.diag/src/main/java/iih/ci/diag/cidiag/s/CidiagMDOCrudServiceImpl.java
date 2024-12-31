package iih.ci.diag.cidiag.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.diag.cidiag.d.desc.CiDiagDODesc;
import iih.ci.diag.cidiag.d.CiDiagDO;
import iih.ci.diag.cidiag.i.ICidiagMDOCudService;
import iih.ci.diag.cidiag.i.ICidiagMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 临床诊断主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICidiagMDOCudService.class,ICidiagMDORService.class}, binding=Binding.JSONRPC)
public class CidiagMDOCrudServiceImpl extends BaseDOService<CiDiagDO> implements ICidiagMDOCudService,ICidiagMDORService {

    public CidiagMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiDiagDODesc.class),IAppFwTempTbl.tmp_iaw_16.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

