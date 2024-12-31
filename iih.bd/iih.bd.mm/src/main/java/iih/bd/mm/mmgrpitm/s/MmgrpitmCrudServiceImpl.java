package iih.bd.mm.mmgrpitm.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.mm.mmgrpitm.d.desc.MmGrpItmDODesc;
import iih.bd.mm.mmgrpitm.d.MmGrpItmDO;
import iih.bd.mm.mmgrpitm.i.IMmgrpitmCudService;
import iih.bd.mm.mmgrpitm.i.IMmgrpitmRService;


/**
 * 物品组明细AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMmgrpitmCudService.class,IMmgrpitmRService.class}, binding=Binding.JSONRPC)
public class MmgrpitmCrudServiceImpl extends BaseDOService<MmGrpItmDO> implements IMmgrpitmCudService,IMmgrpitmRService {
    public MmgrpitmCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MmGrpItmDODesc.class),IAppFwTempTbl.tmp_iaw_16.name()); 
    }
}
