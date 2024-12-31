package iih.ci.mrm.healthsystem.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrm.healthsystem.d.desc.ValueContrastDetailDODesc;
import iih.ci.mrm.healthsystem.d.ValueContrastDetailDO;
import iih.ci.mrm.healthsystem.i.IValuecontrastdetailCudService;
import iih.ci.mrm.healthsystem.i.IValuecontrastdetailRService;


/**
 * 值对照明细AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IValuecontrastdetailCudService.class,IValuecontrastdetailRService.class}, binding=Binding.JSONRPC)
public class ValuecontrastdetailCrudServiceImpl extends BaseDOService<ValueContrastDetailDO> implements IValuecontrastdetailCudService,IValuecontrastdetailRService {
    public ValuecontrastdetailCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ValueContrastDetailDODesc.class),IAppFwTempTbl.tmp_iaw_15.name()); 
    }
}
