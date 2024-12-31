package iih.bd.srv.autoitm.s;
import iih.bd.srv.autoitm.d.AutoItmDO;
import iih.bd.srv.autoitm.d.desc.AutoItmDODesc;
import iih.bd.srv.autoitm.i.IAutoitmCudService;
import iih.bd.srv.autoitm.i.IAutoitmRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 自动质控控制表bdAggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IAutoitmCudService.class,IAutoitmRService.class}, binding=Binding.JSONRPC)
public class AutoitmCrudServiceImpl extends BaseDOService<AutoItmDO> implements IAutoitmCudService,IAutoitmRService {
    public AutoitmCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(AutoItmDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }
}

