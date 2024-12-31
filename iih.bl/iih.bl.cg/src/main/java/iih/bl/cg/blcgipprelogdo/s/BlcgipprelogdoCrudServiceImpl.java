package iih.bl.cg.blcgipprelogdo.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.cg.blcgipprelogdo.d.desc.BlCgIppreLogDODesc;
import iih.bl.cg.blcgipprelogdo.d.BlCgIppreLogDO;
import iih.bl.cg.blcgipprelogdo.i.IBlcgipprelogdoCudService;
import iih.bl.cg.blcgipprelogdo.i.IBlcgipprelogdoRService;


/**
 * 预住院费用转出日志AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlcgipprelogdoCudService.class,IBlcgipprelogdoRService.class}, binding=Binding.JSONRPC)
public class BlcgipprelogdoCrudServiceImpl extends BaseDOService<BlCgIppreLogDO> implements IBlcgipprelogdoCudService,IBlcgipprelogdoRService {
    public BlcgipprelogdoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlCgIppreLogDODesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
    }
}
