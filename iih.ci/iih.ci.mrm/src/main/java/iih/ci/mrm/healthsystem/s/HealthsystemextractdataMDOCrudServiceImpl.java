package iih.ci.mrm.healthsystem.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrm.healthsystem.d.desc.ExtractDataDODesc;
import iih.ci.mrm.healthsystem.d.ExtractDataDO;
import iih.ci.mrm.healthsystem.i.IHealthsystemextractdataMDOCudService;
import iih.ci.mrm.healthsystem.i.IHealthsystemextractdataMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 数据抽取任务主实体CRUD服务实现
 */
@Service(serviceInterfaces={IHealthsystemextractdataMDOCudService.class,IHealthsystemextractdataMDORService.class}, binding=Binding.JSONRPC)
public class HealthsystemextractdataMDOCrudServiceImpl extends BaseDOService<ExtractDataDO> implements IHealthsystemextractdataMDOCudService,IHealthsystemextractdataMDORService {

    public HealthsystemextractdataMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ExtractDataDODesc.class),IAppFwTempTbl.tmp_iaw_23.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

