package iih.ci.rcm.pathogen.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.rcm.pathogen.d.desc.PathogenDODesc;
import iih.ci.rcm.pathogen.d.PathogenDO;
import iih.ci.rcm.pathogen.i.IPathogenCudService;
import iih.ci.rcm.pathogen.i.IPathogenRService;


/**
 * 病原体AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IPathogenCudService.class,IPathogenRService.class}, binding=Binding.JSONRPC)
public class PathogenCrudServiceImpl extends BaseDOService<PathogenDO> implements IPathogenCudService,IPathogenRService {
    public PathogenCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PathogenDODesc.class),IAppFwTempTbl.tmp_iaw_15.name()); 
    }
}
