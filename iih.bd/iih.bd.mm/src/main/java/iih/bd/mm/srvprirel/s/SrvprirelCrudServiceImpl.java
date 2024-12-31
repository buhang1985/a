package iih.bd.mm.srvprirel.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.mm.srvprirel.d.desc.MmSrvPriRelDODesc;
import iih.bd.mm.srvprirel.d.MmSrvPriRelDO;
import iih.bd.mm.srvprirel.i.ISrvprirelCudService;
import iih.bd.mm.srvprirel.i.ISrvprirelRService;


/**
 * 物品服务对应价格服务AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISrvprirelCudService.class,ISrvprirelRService.class}, binding=Binding.JSONRPC)
public class SrvprirelCrudServiceImpl extends BaseDOService<MmSrvPriRelDO> implements ISrvprirelCudService,ISrvprirelRService {
    public SrvprirelCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MmSrvPriRelDODesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
    }
}
