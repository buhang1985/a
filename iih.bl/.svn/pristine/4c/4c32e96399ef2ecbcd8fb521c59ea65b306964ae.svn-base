package iih.bl.inc.blcpnin.s;
import iih.bl.inc.blcpnin.d.BlCpnInDO;
import iih.bl.inc.blcpnin.d.BlcpninAggDO;
import iih.bl.inc.blcpnin.d.desc.BlCpnInDODesc;
import iih.bl.inc.blcpnin.i.IBlcpninCudService;
import iih.bl.inc.blcpnin.i.IBlcpninRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlcpninCudService.class,IBlcpninRService.class}, binding=Binding.JSONRPC)
public class BlcpninCrudServiceImpl extends BaseAggService<BlcpninAggDO,BlCpnInDO> implements IBlcpninCudService,IBlcpninRService {

    public BlcpninCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlCpnInDODesc.class),IAppFwTempTbl.tmp_iaw_19.name()); 
    }
}

