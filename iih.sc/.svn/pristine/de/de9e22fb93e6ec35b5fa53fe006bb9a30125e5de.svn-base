package iih.sc.scp.scplweek.s;
import iih.sc.scp.scplweek.d.ScPlanWeekEnDO;
import iih.sc.scp.scplweek.d.desc.ScPlanWeekEnDODesc;
import iih.sc.scp.scplweek.i.IScPlanWeekEnDOCudService;
import iih.sc.scp.scplweek.i.IScPlanWeekEnDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 计划排班_计划_周主实体CRUD服务实现
 */
@Service(serviceInterfaces={IScPlanWeekEnDOCudService.class,IScPlanWeekEnDORService.class}, binding=Binding.JSONRPC)
public class ScPlanWeekEnDOCrudServiceImpl extends BaseDOService<ScPlanWeekEnDO> implements IScPlanWeekEnDOCudService,IScPlanWeekEnDORService {

    public ScPlanWeekEnDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScPlanWeekEnDODesc.class),IAppFwTempTbl.tmp_iaw_05.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

