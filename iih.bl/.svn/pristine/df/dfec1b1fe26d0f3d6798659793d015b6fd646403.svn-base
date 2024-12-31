package iih.bl.cc.blcc.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.bl.cc.blcc.d.BlCcDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.bl.cc.blcc.d.desc.BlCcDODesc;
import iih.bl.cc.blcc.d.BlccAggDO;
import iih.bl.cc.blcc.i.IBlccCudService;
import iih.bl.cc.blcc.i.IBlccRService;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlccCudService.class,IBlccRService.class}, binding=Binding.JSONRPC)
public class BlccCrudServiceImpl extends BaseAggService<BlccAggDO,BlCcDO> implements IBlccCudService,IBlccRService {
    public BlccCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlCcDODesc.class),IAppFwTempTbl.tmp_iaw_15.name()); 
    }
}
