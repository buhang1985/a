package iih.bd.srv.maintenanceexeclog.s;
import iih.bd.srv.maintenanceexeclog.d.MainTenanceExecLogDO;
import iih.bd.srv.maintenanceexeclog.d.desc.MainTenanceExecLogDODesc;
import iih.bd.srv.maintenanceexeclog.i.IMaintenanceexeclogCudService;
import iih.bd.srv.maintenanceexeclog.i.IMaintenanceexeclogRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 运维工具-运行日志AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMaintenanceexeclogCudService.class,IMaintenanceexeclogRService.class}, binding=Binding.JSONRPC)
public class MaintenanceexeclogCrudServiceImpl extends BaseDOService<MainTenanceExecLogDO> implements IMaintenanceexeclogCudService,IMaintenanceexeclogRService {
    public MaintenanceexeclogCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MainTenanceExecLogDODesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }
}
