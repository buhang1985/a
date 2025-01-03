package iih.bl.inc.blreinclog.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.inc.blreinclog.d.desc.BlReIncLogDesc;
import iih.bl.inc.blreinclog.d.BlReIncLog;
import iih.bl.inc.blreinclog.i.IBlreinclogCudService;
import iih.bl.inc.blreinclog.i.IBlreinclogRService;


/**
 * 重拆票记录表AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlreinclogCudService.class,IBlreinclogRService.class}, binding=Binding.JSONRPC)
public class BlreinclogCrudServiceImpl extends BaseDOService<BlReIncLog> implements IBlreinclogCudService,IBlreinclogRService {
    public BlreinclogCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlReIncLogDesc.class),IAppFwTempTbl.tmp_iaw_08.name()); 
    }
}
