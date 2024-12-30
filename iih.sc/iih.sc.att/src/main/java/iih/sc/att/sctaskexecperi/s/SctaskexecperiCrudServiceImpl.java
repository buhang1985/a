package iih.sc.att.sctaskexecperi.s;
import iih.sc.att.sctaskexecperi.d.ScTaskExecPeriDO;
import iih.sc.att.sctaskexecperi.d.desc.ScTaskExecPeriDODesc;
import iih.sc.att.sctaskexecperi.i.ISctaskexecperiCudService;
import iih.sc.att.sctaskexecperi.i.ISctaskexecperiRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 考勤执行期间AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISctaskexecperiCudService.class,ISctaskexecperiRService.class}, binding=Binding.JSONRPC)
public class SctaskexecperiCrudServiceImpl extends BaseDOService<ScTaskExecPeriDO> implements ISctaskexecperiCudService,ISctaskexecperiRService {

    public SctaskexecperiCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScTaskExecPeriDODesc.class),IAppFwTempTbl.tmp_iaw_04.name()); 
    }
}

