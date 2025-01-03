package iih.ci.mb.dcmo.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mb.dcmo.d.desc.DoctorMemoDODesc;
import iih.ci.mb.dcmo.d.DoctorMemoDO;
import iih.ci.mb.dcmo.i.IDoctormemoMDOCudService;
import iih.ci.mb.dcmo.i.IDoctormemoMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 医生备忘录主实体CRUD服务实现
 */
@Service(serviceInterfaces={IDoctormemoMDOCudService.class,IDoctormemoMDORService.class}, binding=Binding.JSONRPC)
public class DoctormemoMDOCrudServiceImpl extends BaseDOService<DoctorMemoDO> implements IDoctormemoMDOCudService,IDoctormemoMDORService {

    public DoctormemoMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(DoctorMemoDODesc.class),IAppFwTempTbl.tmp_iaw_05.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

