package iih.ci.mrm.healthsystem.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.ci.mrm.healthsystem.d.ExtractDataDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.ci.mrm.healthsystem.d.desc.ExtractDataDODesc;
import iih.ci.mrm.healthsystem.d.HealthsystemextractdataAggDO;
import iih.ci.mrm.healthsystem.i.IHealthsystemextractdataCudService;
import iih.ci.mrm.healthsystem.i.IHealthsystemextractdataRService;


/**
 * 数据抽取任务AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHealthsystemextractdataCudService.class,IHealthsystemextractdataRService.class}, binding=Binding.JSONRPC)
public class HealthsystemextractdataCrudServiceImpl extends BaseAggService<HealthsystemextractdataAggDO,ExtractDataDO> implements IHealthsystemextractdataCudService,IHealthsystemextractdataRService {
    public HealthsystemextractdataCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ExtractDataDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
}
