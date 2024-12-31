package iih.bd.srv.connonationitm.s;
import iih.bd.srv.connonationitm.d.ConnonationItmDO;
import iih.bd.srv.connonationitm.d.desc.ConnonationItmDODesc;
import iih.bd.srv.connonationitm.i.IConnonationitmCudService;
import iih.bd.srv.connonationitm.i.IConnonationitmRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * connonationitmAggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IConnonationitmCudService.class,IConnonationitmRService.class}, binding=Binding.JSONRPC)
public class ConnonationitmCrudServiceImpl extends BaseDOService<ConnonationItmDO> implements IConnonationitmCudService,IConnonationitmRService {
    public ConnonationitmCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ConnonationItmDODesc.class),IAppFwTempTbl.tmp_iaw_13.name()); 
    }
}
