package iih.ci.mrm.cimrfpdicatado.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrm.cimrfpdicatado.d.desc.CiMrFpZYDiCataDODesc;
import iih.ci.mrm.cimrfpdicatado.d.CiMrFpZYDiCataDO;
import iih.ci.mrm.cimrfpdicatado.i.ICiMrFpZYDiCataDOCudService;
import iih.ci.mrm.cimrfpdicatado.i.ICiMrFpZYDiCataDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 病案编目诊断主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiMrFpZYDiCataDOCudService.class,ICiMrFpZYDiCataDORService.class}, binding=Binding.JSONRPC)
public class CiMrFpZYDiCataDOCrudServiceImpl extends BaseDOService<CiMrFpZYDiCataDO> implements ICiMrFpZYDiCataDOCudService,ICiMrFpZYDiCataDORService {

    public CiMrFpZYDiCataDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrFpZYDiCataDODesc.class),IAppFwTempTbl.tmp_iaw_29.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

