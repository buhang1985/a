package iih.sc.att.sctaskplemp.s;
import iih.sc.att.sctaskplemp.d.ScTaskPlEmpDO;
import iih.sc.att.sctaskplemp.d.desc.ScTaskPlEmpDODesc;
import iih.sc.att.sctaskplemp.i.ISctaskplempCudService;
import iih.sc.att.sctaskplemp.i.ISctaskplempRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISctaskplempCudService.class,ISctaskplempRService.class}, binding=Binding.JSONRPC)
public class SctaskplempCrudServiceImpl extends BaseDOService<ScTaskPlEmpDO> implements ISctaskplempCudService,ISctaskplempRService {

    public SctaskplempCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScTaskPlEmpDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
    }
}

