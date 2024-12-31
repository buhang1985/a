package iih.bl.prop.blproparoep.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.bl.prop.blproparoep.d.BlPropArOepDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.bl.prop.blproparoep.d.desc.BlPropArOepDODesc;
import iih.bl.prop.blproparoep.d.BlproparoepAggDO;
import iih.bl.prop.blproparoep.i.IBlproparoepCudService;
import iih.bl.prop.blproparoep.i.IBlproparoepRService;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlproparoepCudService.class,IBlproparoepRService.class}, binding=Binding.JSONRPC)
public class BlproparoepCrudServiceImpl extends BaseAggService<BlproparoepAggDO,BlPropArOepDO> implements IBlproparoepCudService,IBlproparoepRService {
    public BlproparoepCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlPropArOepDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
}
