package iih.ci.mrm.cimrfpdicatado.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrm.cimrfpdicatado.d.desc.CiMrFpDiCataDODesc;
import iih.ci.mrm.cimrfpdicatado.d.CiMrFpDiCataDO;
import iih.ci.mrm.cimrfpdicatado.i.ICimrfpdicatadoMDOCudService;
import iih.ci.mrm.cimrfpdicatado.i.ICimrfpdicatadoMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 病案编目诊断主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICimrfpdicatadoMDOCudService.class,ICimrfpdicatadoMDORService.class}, binding=Binding.JSONRPC)
public class CimrfpdicatadoMDOCrudServiceImpl extends BaseDOService<CiMrFpDiCataDO> implements ICimrfpdicatadoMDOCudService,ICimrfpdicatadoMDORService {

    public CimrfpdicatadoMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrFpDiCataDODesc.class),IAppFwTempTbl.tmp_iaw_09.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

