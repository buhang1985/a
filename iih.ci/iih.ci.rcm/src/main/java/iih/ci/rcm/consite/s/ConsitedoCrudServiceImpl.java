package iih.ci.rcm.consite.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.rcm.consite.d.desc.ConSiteDODesc;
import iih.ci.rcm.consite.d.ConSiteDO;
import iih.ci.rcm.consite.i.IConsitedoCudService;
import iih.ci.rcm.consite.i.IConsitedoRService;


/**
 * 院感感染部位AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IConsitedoCudService.class,IConsitedoRService.class}, binding=Binding.JSONRPC)
public class ConsitedoCrudServiceImpl extends BaseDOService<ConSiteDO> implements IConsitedoCudService,IConsitedoRService {
    public ConsitedoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ConSiteDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
}
