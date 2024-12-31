package iih.ci.mb.dcmo.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mb.dcmo.d.desc.DoctorMemoFileDODesc;
import iih.ci.mb.dcmo.d.DoctorMemoFileDO;
import iih.ci.mb.dcmo.i.IDoctorMemoFileDOCudService;
import iih.ci.mb.dcmo.i.IDoctorMemoFileDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 医生备忘录主实体CRUD服务实现
 */
@Service(serviceInterfaces={IDoctorMemoFileDOCudService.class,IDoctorMemoFileDORService.class}, binding=Binding.JSONRPC)
public class DoctorMemoFileDOCrudServiceImpl extends BaseDOService<DoctorMemoFileDO> implements IDoctorMemoFileDOCudService,IDoctorMemoFileDORService {

    public DoctorMemoFileDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(DoctorMemoFileDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

