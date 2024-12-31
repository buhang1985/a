package iih.ci.mrqc.divide.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrqc.divide.d.desc.DivideDODesc;
import iih.ci.mrqc.divide.d.DivideDO;
import iih.ci.mrqc.divide.i.IDivideCudService;
import iih.ci.mrqc.divide.i.IDivideRService;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IDivideCudService.class,IDivideRService.class}, binding=Binding.JSONRPC)
public class DivideCrudServiceImpl extends BaseDOService<DivideDO> implements IDivideCudService,IDivideRService {
    public DivideCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(DivideDODesc.class),IAppFwTempTbl.tmp_iaw_28.name()); 
    }
}
