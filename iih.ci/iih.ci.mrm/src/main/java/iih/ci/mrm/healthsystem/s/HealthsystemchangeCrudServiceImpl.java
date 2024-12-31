package iih.ci.mrm.healthsystem.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrm.healthsystem.d.desc.ChangeClassifyDODesc;
import iih.ci.mrm.healthsystem.d.ChangeClassifyDO;
import iih.ci.mrm.healthsystem.i.IHealthsystemchangeCudService;
import iih.ci.mrm.healthsystem.i.IHealthsystemchangeRService;


/**
 * 转换分类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHealthsystemchangeCudService.class,IHealthsystemchangeRService.class}, binding=Binding.JSONRPC)
public class HealthsystemchangeCrudServiceImpl extends BaseDOService<ChangeClassifyDO> implements IHealthsystemchangeCudService,IHealthsystemchangeRService {
    public HealthsystemchangeCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ChangeClassifyDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
    }
}
