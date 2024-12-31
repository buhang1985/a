package iih.bl.inc.blincip.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.bl.inc.blincip.d.BlIncIpDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.bl.inc.blincip.d.desc.BlIncIpDODesc;
import iih.bl.inc.blincip.d.BlincipAggDO;
import iih.bl.inc.blincip.i.IBlincipCudService;
import iih.bl.inc.blincip.i.IBlincipRService;


/**
 * 住院发票AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlincipCudService.class,IBlincipRService.class}, binding=Binding.JSONRPC)
public class BlincipCrudServiceImpl extends BaseAggService<BlincipAggDO,BlIncIpDO> implements IBlincipCudService,IBlincipRService {
    public BlincipCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlIncIpDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }
}
