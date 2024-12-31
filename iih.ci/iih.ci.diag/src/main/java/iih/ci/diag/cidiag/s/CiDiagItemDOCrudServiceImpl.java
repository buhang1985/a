package iih.ci.diag.cidiag.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.diag.cidiag.d.desc.CiDiagItemDODesc;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.cidiag.i.ICiDiagItemDOCudService;
import iih.ci.diag.cidiag.i.ICiDiagItemDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 临床诊断主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiDiagItemDOCudService.class,ICiDiagItemDORService.class}, binding=Binding.JSONRPC)
public class CiDiagItemDOCrudServiceImpl extends BaseDOService<CiDiagItemDO> implements ICiDiagItemDOCudService,ICiDiagItemDORService {

    public CiDiagItemDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiDiagItemDODesc.class),IAppFwTempTbl.tmp_iaw_01.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

