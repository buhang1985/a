package iih.bl.inc.blinctf.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.inc.blinctf.d.desc.BlIncTfDODesc;
import iih.bl.inc.blinctf.d.BlIncTfDO;
import iih.bl.inc.blinctf.i.IBlinctfCudService;
import iih.bl.inc.blinctf.i.IBlinctfRService;


/**
 * 票据转移记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlinctfCudService.class,IBlinctfRService.class}, binding=Binding.JSONRPC)
public class BlinctfCrudServiceImpl extends BaseDOService<BlIncTfDO> implements IBlinctfCudService,IBlinctfRService {
    public BlinctfCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlIncTfDODesc.class),IAppFwTempTbl.tmp_iaw_14.name()); 
    }
}
