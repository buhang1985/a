package iih.ci.mrm.healthsystem.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.ci.mrm.healthsystem.d.FieldContrastDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.ci.mrm.healthsystem.d.desc.FieldContrastDODesc;
import iih.ci.mrm.healthsystem.d.HealthsystemfieldAggDO;
import iih.ci.mrm.healthsystem.i.IHealthsystemfieldCudService;
import iih.ci.mrm.healthsystem.i.IHealthsystemfieldRService;


/**
 * 字段转换AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHealthsystemfieldCudService.class,IHealthsystemfieldRService.class}, binding=Binding.JSONRPC)
public class HealthsystemfieldCrudServiceImpl extends BaseAggService<HealthsystemfieldAggDO,FieldContrastDO> implements IHealthsystemfieldCudService,IHealthsystemfieldRService {
    public HealthsystemfieldCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(FieldContrastDODesc.class),IAppFwTempTbl.tmp_iaw_21.name()); 
    }
}
