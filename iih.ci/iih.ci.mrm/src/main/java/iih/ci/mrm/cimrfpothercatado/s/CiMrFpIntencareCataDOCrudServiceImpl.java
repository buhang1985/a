package iih.ci.mrm.cimrfpothercatado.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrm.cimrfpothercatado.d.desc.CiMrFpIntencareCataDODesc;
import iih.ci.mrm.cimrfpothercatado.d.CiMrFpIntencareCataDO;
import iih.ci.mrm.cimrfpothercatado.i.ICiMrFpIntencareCataDOCudService;
import iih.ci.mrm.cimrfpothercatado.i.ICiMrFpIntencareCataDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 病案编目其他主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiMrFpIntencareCataDOCudService.class,ICiMrFpIntencareCataDORService.class}, binding=Binding.JSONRPC)
public class CiMrFpIntencareCataDOCrudServiceImpl extends BaseDOService<CiMrFpIntencareCataDO> implements ICiMrFpIntencareCataDOCudService,ICiMrFpIntencareCataDORService {

    public CiMrFpIntencareCataDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrFpIntencareCataDODesc.class),IAppFwTempTbl.tmp_iaw_22.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

