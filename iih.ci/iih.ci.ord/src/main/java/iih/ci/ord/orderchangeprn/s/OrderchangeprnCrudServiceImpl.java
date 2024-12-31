package iih.ci.ord.orderchangeprn.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.orderchangeprn.d.desc.CiOrChangePrnDODesc;
import iih.ci.ord.orderchangeprn.d.CiOrChangePrnDO;
import iih.ci.ord.orderchangeprn.i.IOrderchangeprnCudService;
import iih.ci.ord.orderchangeprn.i.IOrderchangeprnRService;


/**
 * 医嘱变更打印AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IOrderchangeprnCudService.class,IOrderchangeprnRService.class}, binding=Binding.JSONRPC)
public class OrderchangeprnCrudServiceImpl extends BaseDOService<CiOrChangePrnDO> implements IOrderchangeprnCudService,IOrderchangeprnRService {
    public OrderchangeprnCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiOrChangePrnDODesc.class),IAppFwTempTbl.tmp_iaw_19.name()); 
    }
}
