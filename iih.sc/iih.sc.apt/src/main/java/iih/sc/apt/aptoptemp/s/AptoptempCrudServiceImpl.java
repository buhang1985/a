package iih.sc.apt.aptoptemp.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.sc.apt.aptoptemp.d.desc.ScAptOptEmpDODesc;
import iih.sc.apt.aptoptemp.d.ScAptOptEmpDO;
import iih.sc.apt.aptoptemp.i.IAptoptempCudService;
import iih.sc.apt.aptoptemp.i.IAptoptempRService;


/**
 * 手术人员AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IAptoptempCudService.class,IAptoptempRService.class}, binding=Binding.JSONRPC)
public class AptoptempCrudServiceImpl extends BaseDOService<ScAptOptEmpDO> implements IAptoptempCudService,IAptoptempRService {
    public AptoptempCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScAptOptEmpDODesc.class),IAppFwTempTbl.tmp_iaw_17.name()); 
    }
}
