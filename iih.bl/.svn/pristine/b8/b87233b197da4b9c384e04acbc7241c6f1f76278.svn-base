package iih.bl.hp.hporshare.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.hp.hporshare.d.desc.BlHpOrShareLogDODesc;
import iih.bl.hp.hporshare.d.BlHpOrShareLogDO;
import iih.bl.hp.hporshare.i.IBlhporsharelogCudService;
import iih.bl.hp.hporshare.i.IBlhporsharelogRService;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlhporsharelogCudService.class,IBlhporsharelogRService.class}, binding=Binding.JSONRPC)
public class BlhporsharelogCrudServiceImpl extends BaseDOService<BlHpOrShareLogDO> implements IBlhporsharelogCudService,IBlhporsharelogRService {
    public BlhporsharelogCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlHpOrShareLogDODesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
    }
}
