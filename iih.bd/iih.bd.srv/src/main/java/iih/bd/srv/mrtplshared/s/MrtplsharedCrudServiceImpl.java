package iih.bd.srv.mrtplshared.s;
import iih.bd.srv.mrtplshared.d.MrtplSharedDO;
import iih.bd.srv.mrtplshared.d.desc.MrtplSharedDODesc;
import iih.bd.srv.mrtplshared.i.IMrtplsharedCudService;
import iih.bd.srv.mrtplshared.i.IMrtplsharedRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 病历模板共享AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMrtplsharedCudService.class,IMrtplsharedRService.class}, binding=Binding.JSONRPC)
public class MrtplsharedCrudServiceImpl extends BaseDOService<MrtplSharedDO> implements IMrtplsharedCudService,IMrtplsharedRService {
    public MrtplsharedCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrtplSharedDODesc.class),IAppFwTempTbl.tmp_iaw_13.name()); 
    }
}

