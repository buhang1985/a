package iih.bl.prop.blproparip.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.bl.prop.blproparip.d.BlPropArIpDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.bl.prop.blproparip.d.desc.BlPropArIpDODesc;
import iih.bl.prop.blproparip.d.BlproparipAggDO;
import iih.bl.prop.blproparip.i.IBlproparipCudService;
import iih.bl.prop.blproparip.i.IBlproparipRService;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlproparipCudService.class,IBlproparipRService.class}, binding=Binding.JSONRPC)
public class BlproparipCrudServiceImpl extends BaseAggService<BlproparipAggDO,BlPropArIpDO> implements IBlproparipCudService,IBlproparipRService {
    public BlproparipCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlPropArIpDODesc.class),IAppFwTempTbl.tmp_iaw_23.name()); 
    }
}
