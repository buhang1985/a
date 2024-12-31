package iih.bl.cg.blcghist.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.cg.blcghist.d.desc.BlCgIpHistDODesc;
import iih.bl.cg.blcghist.d.BlCgIpHistDO;
import iih.bl.cg.blcghist.i.IBlcghistCudService;
import iih.bl.cg.blcghist.i.IBlcghistRService;


/**
 * 住院记账自费标识修改历史AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlcghistCudService.class,IBlcghistRService.class}, binding=Binding.JSONRPC)
public class BlcghistCrudServiceImpl extends BaseDOService<BlCgIpHistDO> implements IBlcghistCudService,IBlcghistRService {
    public BlcghistCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlCgIpHistDODesc.class),IAppFwTempTbl.tmp_iaw_13.name()); 
    }
}
