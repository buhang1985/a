package iih.ci.mrm.cimrfpothercatado.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrm.cimrfpothercatado.d.desc.CiMrFpOtherCataDODesc;
import iih.ci.mrm.cimrfpothercatado.d.CiMrFpOtherCataDO;
import iih.ci.mrm.cimrfpothercatado.i.ICimrfpothercatadoMDOCudService;
import iih.ci.mrm.cimrfpothercatado.i.ICimrfpothercatadoMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 病案编目其他主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICimrfpothercatadoMDOCudService.class,ICimrfpothercatadoMDORService.class}, binding=Binding.JSONRPC)
public class CimrfpothercatadoMDOCrudServiceImpl extends BaseDOService<CiMrFpOtherCataDO> implements ICimrfpothercatadoMDOCudService,ICimrfpothercatadoMDORService {

    public CimrfpothercatadoMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrFpOtherCataDODesc.class),IAppFwTempTbl.tmp_iaw_21.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

