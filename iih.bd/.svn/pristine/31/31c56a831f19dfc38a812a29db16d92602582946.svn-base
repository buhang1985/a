package iih.bd.srv.maintenance.s;
import iih.bd.srv.maintenance.d.MainTenanceDO;
import iih.bd.srv.maintenance.d.desc.MainTenanceDODesc;
import iih.bd.srv.maintenance.i.IMaintenanceCudService;
import iih.bd.srv.maintenance.i.IMaintenanceRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 业务数据运维AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMaintenanceCudService.class,IMaintenanceRService.class}, binding=Binding.JSONRPC)
public class MaintenanceCrudServiceImpl extends BaseDOService<MainTenanceDO> implements IMaintenanceCudService,IMaintenanceRService {
    public MaintenanceCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MainTenanceDODesc.class),IAppFwTempTbl.tmp_iaw_29.name()); 
    }
}
