package iih.sc.scbd.schedulechl.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.sc.scbd.schedulechl.d.desc.ScChlPeriodDODesc;
import iih.sc.scbd.schedulechl.d.ScChlPeriodDO;
import iih.sc.scbd.schedulechl.i.IScChlPeriodDOCudService;
import iih.sc.scbd.schedulechl.i.IScChlPeriodDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 排班预约渠道主实体CRUD服务实现
 */
@Service(serviceInterfaces={IScChlPeriodDOCudService.class,IScChlPeriodDORService.class}, binding=Binding.JSONRPC)
public class ScChlPeriodDOCrudServiceImpl extends BaseDOService<ScChlPeriodDO> implements IScChlPeriodDOCudService,IScChlPeriodDORService {

    public ScChlPeriodDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScChlPeriodDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

