package iih.bl.pay.blprepaypatacc.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.pay.blprepaypatacc.d.desc.BlPrepayPatAccDODesc;
import iih.bl.pay.blprepaypatacc.d.BlPrepayPatAccDO;
import iih.bl.pay.blprepaypatacc.i.IBlprepaypataccCudService;
import iih.bl.pay.blprepaypatacc.i.IBlprepaypataccRService;


/**
 * 预交金账目流水AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlprepaypataccCudService.class,IBlprepaypataccRService.class}, binding=Binding.JSONRPC)
public class BlprepaypataccCrudServiceImpl extends BaseDOService<BlPrepayPatAccDO> implements IBlprepaypataccCudService,IBlprepaypataccRService {
    public BlprepaypataccCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlPrepayPatAccDODesc.class),IAppFwTempTbl.tmp_iaw_15.name()); 
    }
}
