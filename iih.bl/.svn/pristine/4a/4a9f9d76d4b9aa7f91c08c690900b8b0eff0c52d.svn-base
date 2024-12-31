package iih.bl.pay.blprepaypatpmamtoep.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.pay.blprepaypatpmamtoep.d.desc.BlPrepayPatPmamtOepDODesc;
import iih.bl.pay.blprepaypatpmamtoep.d.BlPrepayPatPmamtOepDO;
import iih.bl.pay.blprepaypatpmamtoep.i.IBlprepaypatpmamtoepCudService;
import iih.bl.pay.blprepaypatpmamtoep.i.IBlprepaypatpmamtoepRService;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlprepaypatpmamtoepCudService.class,IBlprepaypatpmamtoepRService.class}, binding=Binding.JSONRPC)
public class BlprepaypatpmamtoepCrudServiceImpl extends BaseDOService<BlPrepayPatPmamtOepDO> implements IBlprepaypatpmamtoepCudService,IBlprepaypatpmamtoepRService {
    public BlprepaypatpmamtoepCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlPrepayPatPmamtOepDODesc.class),IAppFwTempTbl.tmp_iaw_23.name()); 
    }
}
