package iih.ci.rcm.trackafterexposure.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.rcm.trackafterexposure.d.desc.LabFollowupResultDODesc;
import iih.ci.rcm.trackafterexposure.d.LabFollowupResultDO;
import iih.ci.rcm.trackafterexposure.i.ILabFollowupResultDOCudService;
import iih.ci.rcm.trackafterexposure.i.ILabFollowupResultDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 暴露后追踪记录登记表主实体CRUD服务实现
 */
@Service(serviceInterfaces={ILabFollowupResultDOCudService.class,ILabFollowupResultDORService.class}, binding=Binding.JSONRPC)
public class LabFollowupResultDOCrudServiceImpl extends BaseDOService<LabFollowupResultDO> implements ILabFollowupResultDOCudService,ILabFollowupResultDORService {

    public LabFollowupResultDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(LabFollowupResultDODesc.class),IAppFwTempTbl.tmp_iaw_01.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

