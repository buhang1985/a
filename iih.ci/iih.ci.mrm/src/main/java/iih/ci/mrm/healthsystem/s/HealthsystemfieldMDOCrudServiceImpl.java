package iih.ci.mrm.healthsystem.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrm.healthsystem.d.desc.FieldContrastDODesc;
import iih.ci.mrm.healthsystem.d.FieldContrastDO;
import iih.ci.mrm.healthsystem.i.IHealthsystemfieldMDOCudService;
import iih.ci.mrm.healthsystem.i.IHealthsystemfieldMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 字段转换主实体CRUD服务实现
 */
@Service(serviceInterfaces={IHealthsystemfieldMDOCudService.class,IHealthsystemfieldMDORService.class}, binding=Binding.JSONRPC)
public class HealthsystemfieldMDOCrudServiceImpl extends BaseDOService<FieldContrastDO> implements IHealthsystemfieldMDOCudService,IHealthsystemfieldMDORService {

    public HealthsystemfieldMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(FieldContrastDODesc.class),IAppFwTempTbl.tmp_iaw_29.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

