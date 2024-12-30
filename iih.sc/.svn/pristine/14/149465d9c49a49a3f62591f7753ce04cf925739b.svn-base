package iih.sc.apt.aptip.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.sc.apt.aptip.d.AptIpDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.sc.apt.aptip.d.desc.AptIpDODesc;
import iih.sc.apt.aptip.d.AptipAggDO;
import iih.sc.apt.aptip.i.IAptipCudService;
import iih.sc.apt.aptip.i.IAptipRService;


/**
 * 住院预约AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IAptipCudService.class,IAptipRService.class}, binding=Binding.JSONRPC)
public class AptipCrudServiceImpl extends BaseAggService<AptipAggDO,AptIpDO> implements IAptipCudService,IAptipRService {
    public AptipCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(AptIpDODesc.class),IAppFwTempTbl.tmp_iaw_07.name()); 
    }
}
