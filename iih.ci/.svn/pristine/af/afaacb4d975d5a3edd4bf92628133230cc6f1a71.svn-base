package iih.ci.rcm.trackafterexposure.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.rcm.trackafterexposure.d.desc.TreatPeMeaAfExpDODesc;
import iih.ci.rcm.trackafterexposure.d.TreatPeMeaAfExpDO;
import iih.ci.rcm.trackafterexposure.i.ITreatPeMeaAfExpDOCudService;
import iih.ci.rcm.trackafterexposure.i.ITreatPeMeaAfExpDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 暴露后追踪记录登记表主实体CRUD服务实现
 */
@Service(serviceInterfaces={ITreatPeMeaAfExpDOCudService.class,ITreatPeMeaAfExpDORService.class}, binding=Binding.JSONRPC)
public class TreatPeMeaAfExpDOCrudServiceImpl extends BaseDOService<TreatPeMeaAfExpDO> implements ITreatPeMeaAfExpDOCudService,ITreatPeMeaAfExpDORService {

    public TreatPeMeaAfExpDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(TreatPeMeaAfExpDODesc.class),IAppFwTempTbl.tmp_iaw_03.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

