package iih.pi.reg.patcust.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.reg.patcust.d.desc.PiPatCustDODesc;
import iih.pi.reg.patcust.d.PiPatCustDO;
import iih.pi.reg.patcust.i.IPatcustCudService;
import iih.pi.reg.patcust.i.IPatcustRService;


/**
 * 团体患者关系AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IPatcustCudService.class,IPatcustRService.class}, binding=Binding.JSONRPC)
public class PatcustCrudServiceImpl extends BaseDOService<PiPatCustDO> implements IPatcustCudService,IPatcustRService {
    public PatcustCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatCustDODesc.class),IAppFwTempTbl.tmp_iaw_04.name()); 
    }
}
