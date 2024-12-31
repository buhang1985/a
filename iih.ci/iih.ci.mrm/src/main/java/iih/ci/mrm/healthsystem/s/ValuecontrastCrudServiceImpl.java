package iih.ci.mrm.healthsystem.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.ci.mrm.healthsystem.d.ValueContrastDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.ci.mrm.healthsystem.d.desc.ValueContrastDODesc;
import iih.ci.mrm.healthsystem.d.ValuecontrastAggDO;
import iih.ci.mrm.healthsystem.i.IValuecontrastCudService;
import iih.ci.mrm.healthsystem.i.IValuecontrastRService;


/**
 * 对照AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IValuecontrastCudService.class,IValuecontrastRService.class}, binding=Binding.JSONRPC)
public class ValuecontrastCrudServiceImpl extends BaseAggService<ValuecontrastAggDO,ValueContrastDO> implements IValuecontrastCudService,IValuecontrastRService {
    public ValuecontrastCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ValueContrastDODesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }
}
