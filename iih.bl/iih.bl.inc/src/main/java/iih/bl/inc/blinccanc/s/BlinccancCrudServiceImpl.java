package iih.bl.inc.blinccanc.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.inc.blinccanc.d.desc.BlIncCancDODesc;
import iih.bl.inc.blinccanc.d.BlIncCancDO;
import iih.bl.inc.blinccanc.i.IBlinccancCudService;
import iih.bl.inc.blinccanc.i.IBlinccancRService;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlinccancCudService.class,IBlinccancRService.class}, binding=Binding.JSONRPC)
public class BlinccancCrudServiceImpl extends BaseDOService<BlIncCancDO> implements IBlinccancCudService,IBlinccancRService {
    public BlinccancCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlIncCancDODesc.class),IAppFwTempTbl.tmp_iaw_07.name()); 
    }
}
