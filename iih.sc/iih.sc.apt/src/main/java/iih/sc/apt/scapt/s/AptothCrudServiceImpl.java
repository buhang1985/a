package iih.sc.apt.scapt.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.sc.apt.scapt.d.desc.AptOthDODesc;
import iih.sc.apt.scapt.d.AptOthDO;
import iih.sc.apt.scapt.i.IAptothCudService;
import iih.sc.apt.scapt.i.IAptothRService;


/**
 * 计划排班-预约-其他AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IAptothCudService.class,IAptothRService.class}, binding=Binding.JSONRPC)
public class AptothCrudServiceImpl extends BaseDOService<AptOthDO> implements IAptothCudService,IAptothRService {
    public AptothCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(AptOthDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
}
