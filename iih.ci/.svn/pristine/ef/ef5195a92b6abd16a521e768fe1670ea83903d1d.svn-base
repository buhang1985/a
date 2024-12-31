package iih.ci.mrqc.mrtask.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrqc.mrtask.d.desc.MrTaskDODesc;
import iih.ci.mrqc.mrtask.d.MrTaskDO;
import iih.ci.mrqc.mrtask.i.IMrtaskCudService;
import iih.ci.mrqc.mrtask.i.IMrtaskRService;


/**
 * 病历任务AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMrtaskCudService.class,IMrtaskRService.class}, binding=Binding.JSONRPC)
public class MrtaskCrudServiceImpl extends BaseDOService<MrTaskDO> implements IMrtaskCudService,IMrtaskRService {
    public MrtaskCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrTaskDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
    }
}
