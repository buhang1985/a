package iih.sc.apt.scaptappl.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.sc.apt.scaptappl.d.desc.ScAptApplItmDODesc;
import iih.sc.apt.scaptappl.d.ScAptApplItmDO;
import iih.sc.apt.scaptappl.i.IScAptApplItmDOCudService;
import iih.sc.apt.scaptappl.i.IScAptApplItmDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 计划排班_预约_申请主实体CRUD服务实现
 */
@Service(serviceInterfaces={IScAptApplItmDOCudService.class,IScAptApplItmDORService.class}, binding=Binding.JSONRPC)
public class ScAptApplItmDOCrudServiceImpl extends BaseDOService<ScAptApplItmDO> implements IScAptApplItmDOCudService,IScAptApplItmDORService {

    public ScAptApplItmDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScAptApplItmDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

