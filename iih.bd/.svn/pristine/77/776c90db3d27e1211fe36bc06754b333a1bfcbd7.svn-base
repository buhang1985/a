package iih.bd.bs.workcalendar.s;
import iih.bd.bs.workcalendar.d.WorkCalendDateDO;
import iih.bd.bs.workcalendar.d.desc.WorkCalendDateDODesc;
import iih.bd.bs.workcalendar.i.IWorkCalendDateDOCudService;
import iih.bd.bs.workcalendar.i.IWorkCalendDateDORService;
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
@Service(serviceInterfaces={IWorkCalendDateDOCudService.class,IWorkCalendDateDORService.class}, binding=Binding.JSONRPC)
public class WorkCalendDateDOCrudServiceImpl extends BaseDOService<WorkCalendDateDO> implements IWorkCalendDateDOCudService,IWorkCalendDateDORService {

    public WorkCalendDateDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(WorkCalendDateDODesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

