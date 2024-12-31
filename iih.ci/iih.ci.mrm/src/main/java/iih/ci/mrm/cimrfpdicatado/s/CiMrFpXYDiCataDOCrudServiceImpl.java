package iih.ci.mrm.cimrfpdicatado.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrm.cimrfpdicatado.d.desc.CiMrFpXYDiCataDODesc;
import iih.ci.mrm.cimrfpdicatado.d.CiMrFpXYDiCataDO;
import iih.ci.mrm.cimrfpdicatado.i.ICiMrFpXYDiCataDOCudService;
import iih.ci.mrm.cimrfpdicatado.i.ICiMrFpXYDiCataDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 病案编目诊断主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiMrFpXYDiCataDOCudService.class,ICiMrFpXYDiCataDORService.class}, binding=Binding.JSONRPC)
public class CiMrFpXYDiCataDOCrudServiceImpl extends BaseDOService<CiMrFpXYDiCataDO> implements ICiMrFpXYDiCataDOCudService,ICiMrFpXYDiCataDORService {

    public CiMrFpXYDiCataDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrFpXYDiCataDODesc.class),IAppFwTempTbl.tmp_iaw_08.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

