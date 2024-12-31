package iih.ci.rcm.operinciinfect.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.rcm.operinciinfect.d.desc.OperIncInfectDODesc;
import iih.ci.rcm.operinciinfect.d.OperIncInfectDO;
import iih.ci.rcm.operinciinfect.i.IOperinciinfectCudService;
import iih.ci.rcm.operinciinfect.i.IOperinciinfectRService;


/**
 * 手术切口感染AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IOperinciinfectCudService.class,IOperinciinfectRService.class}, binding=Binding.JSONRPC)
public class OperinciinfectCrudServiceImpl extends BaseDOService<OperIncInfectDO> implements IOperinciinfectCudService,IOperinciinfectRService {
    public OperinciinfectCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OperIncInfectDODesc.class),IAppFwTempTbl.tmp_iaw_09.name()); 
    }
}
