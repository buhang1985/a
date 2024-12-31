package iih.bd.bs.workcalendar.s;
import iih.bd.bs.workcalendar.d.WorkCalendarDO;
import iih.bd.bs.workcalendar.d.WorkcalendarAggDO;
import iih.bd.bs.workcalendar.d.desc.WorkCalendarDODesc;
import iih.bd.bs.workcalendar.i.IWorkcalendarCudService;
import iih.bd.bs.workcalendar.i.IWorkcalendarRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 工作日历AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IWorkcalendarCudService.class,IWorkcalendarRService.class}, binding=Binding.JSONRPC)
public class WorkcalendarCrudServiceImpl extends BaseAggService<WorkcalendarAggDO,WorkCalendarDO> implements IWorkcalendarCudService,IWorkcalendarRService {
    public WorkcalendarCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(WorkCalendarDODesc.class),IAppFwTempTbl.tmp_iaw_28.name()); 
    }
}
