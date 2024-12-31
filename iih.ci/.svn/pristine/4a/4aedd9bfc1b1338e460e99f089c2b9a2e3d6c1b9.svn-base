package iih.ci.mrm.healthsystem.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrm.healthsystem.d.desc.ContrastClassifyDODesc;
import iih.ci.mrm.healthsystem.d.ContrastClassifyDO;
import iih.ci.mrm.healthsystem.i.IHealthsystemMDOCudService;
import iih.ci.mrm.healthsystem.i.IHealthsystemMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 对照分类主实体CRUD服务实现
 */
@Service(serviceInterfaces={IHealthsystemMDOCudService.class,IHealthsystemMDORService.class}, binding=Binding.JSONRPC)
public class HealthsystemMDOCrudServiceImpl extends BaseDOService<ContrastClassifyDO> implements IHealthsystemMDOCudService,IHealthsystemMDORService {

    public HealthsystemMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ContrastClassifyDODesc.class),IAppFwTempTbl.tmp_iaw_21.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

