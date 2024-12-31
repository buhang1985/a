package iih.bd.rsc.project.s;
import iih.bd.rsc.project.d.ResearchProjectDO;
import iih.bd.rsc.project.d.desc.ResearchProjectDODesc;
import iih.bd.rsc.project.i.IProjectCudService;
import iih.bd.rsc.project.i.IProjectRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 科研项目AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IProjectCudService.class,IProjectRService.class}, binding=Binding.JSONRPC)
public class ProjectCrudServiceImpl extends BaseDOService<ResearchProjectDO> implements IProjectCudService,IProjectRService {
    public ProjectCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ResearchProjectDODesc.class),IAppFwTempTbl.tmp_iaw_23.name()); 
    }
}
