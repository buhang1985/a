package iih.bd.bs.workcalendar.s;
import iih.bd.bs.workcalendar.d.WorkCalendYearDO;
import iih.bd.bs.workcalendar.d.desc.WorkCalendYearDODesc;
import iih.bd.bs.workcalendar.i.IWorkCalendYearDOCudService;
import iih.bd.bs.workcalendar.i.IWorkCalendYearDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 工作日历主实体CRUD服务实现
 */
@Service(serviceInterfaces={IWorkCalendYearDOCudService.class,IWorkCalendYearDORService.class}, binding=Binding.JSONRPC)
public class WorkCalendYearDOCrudServiceImpl extends BaseDOService<WorkCalendYearDO> implements IWorkCalendYearDOCudService,IWorkCalendYearDORService {

    public WorkCalendYearDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(WorkCalendYearDODesc.class),IAppFwTempTbl.tmp_iaw_05.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

