package iih.ci.mrm.healthsystem.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrm.healthsystem.d.desc.ContrastClassifyDODesc;
import iih.ci.mrm.healthsystem.d.ContrastClassifyDO;
import iih.ci.mrm.healthsystem.i.IHealthsystemCudService;
import iih.ci.mrm.healthsystem.i.IHealthsystemRService;


/**
 * 对照分类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHealthsystemCudService.class,IHealthsystemRService.class}, binding=Binding.JSONRPC)
public class HealthsystemCrudServiceImpl extends BaseDOService<ContrastClassifyDO> implements IHealthsystemCudService,IHealthsystemRService {
    public HealthsystemCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ContrastClassifyDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
}
