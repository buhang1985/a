package iih.bd.mm.autoreplenishconfigure.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.mm.autoreplenishconfigure.d.desc.AutoReplenishConfigureDODesc;
import iih.bd.mm.autoreplenishconfigure.d.AutoReplenishConfigureDO;
import iih.bd.mm.autoreplenishconfigure.i.IAutoreplenishconfigureCudService;
import iih.bd.mm.autoreplenishconfigure.i.IAutoreplenishconfigureRService;


/**
 * 自动补货配置AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IAutoreplenishconfigureCudService.class,IAutoreplenishconfigureRService.class}, binding=Binding.JSONRPC)
public class AutoreplenishconfigureCrudServiceImpl extends BaseDOService<AutoReplenishConfigureDO> implements IAutoreplenishconfigureCudService,IAutoreplenishconfigureRService {
    public AutoreplenishconfigureCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(AutoReplenishConfigureDODesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
    }
}
