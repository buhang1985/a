package iih.sc.scp.scploptsrv.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.sc.scp.scploptsrv.d.desc.ScPlOptSrvDODesc;
import iih.sc.scp.scploptsrv.d.ScPlOptSrvDO;
import iih.sc.scp.scploptsrv.i.IScploptsrvCudService;
import iih.sc.scp.scploptsrv.i.IScploptsrvRService;


/**
 * 排班计划候选服务AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IScploptsrvCudService.class,IScploptsrvRService.class}, binding=Binding.JSONRPC)
public class ScploptsrvCrudServiceImpl extends BaseDOService<ScPlOptSrvDO> implements IScploptsrvCudService,IScploptsrvRService {
    public ScploptsrvCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScPlOptSrvDODesc.class),IAppFwTempTbl.tmp_iaw_17.name()); 
    }
}
