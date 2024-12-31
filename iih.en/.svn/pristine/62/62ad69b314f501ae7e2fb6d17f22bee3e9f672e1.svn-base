package iih.en.que.empque.s;
import iih.en.que.empque.d.EnQueEmpDO;
import iih.en.que.empque.d.desc.EnQueEmpDODesc;
import iih.en.que.empque.i.IEnempqueCudService;
import iih.en.que.empque.i.IEnempqueRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 患者就诊_队列医生AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnempqueCudService.class,IEnempqueRService.class}, binding=Binding.JSONRPC)
public class EnempqueCrudServiceImpl extends BaseDOService<EnQueEmpDO> implements IEnempqueCudService,IEnempqueRService {
    public EnempqueCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnQueEmpDODesc.class),IAppFwTempTbl.tmp_iaw_09.name()); 
    }
}
