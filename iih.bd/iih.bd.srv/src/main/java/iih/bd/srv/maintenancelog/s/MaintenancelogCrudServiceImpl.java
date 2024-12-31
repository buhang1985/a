package iih.bd.srv.maintenancelog.s;
import iih.bd.srv.maintenancelog.d.MainTenanceLogDO;
import iih.bd.srv.maintenancelog.d.desc.MainTenanceLogDODesc;
import iih.bd.srv.maintenancelog.i.IMaintenancelogCudService;
import iih.bd.srv.maintenancelog.i.IMaintenancelogRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 运维工具—管理日志AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMaintenancelogCudService.class,IMaintenancelogRService.class}, binding=Binding.JSONRPC)
public class MaintenancelogCrudServiceImpl extends BaseDOService<MainTenanceLogDO> implements IMaintenancelogCudService,IMaintenancelogRService {
    public MaintenancelogCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MainTenanceLogDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
    }
}
