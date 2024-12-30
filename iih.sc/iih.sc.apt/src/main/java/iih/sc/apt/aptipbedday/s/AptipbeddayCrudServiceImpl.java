package iih.sc.apt.aptipbedday.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.sc.apt.aptipbedday.d.desc.AptIpBeddayDODesc;
import iih.sc.apt.aptipbedday.d.AptIpBeddayDO;
import iih.sc.apt.aptipbedday.i.IAptipbeddayCudService;
import iih.sc.apt.aptipbedday.i.IAptipbeddayRService;


/**
 * 预住院预约日间诊疗AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IAptipbeddayCudService.class,IAptipbeddayRService.class}, binding=Binding.JSONRPC)
public class AptipbeddayCrudServiceImpl extends BaseDOService<AptIpBeddayDO> implements IAptipbeddayCudService,IAptipbeddayRService {
    public AptipbeddayCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(AptIpBeddayDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
    }
}
