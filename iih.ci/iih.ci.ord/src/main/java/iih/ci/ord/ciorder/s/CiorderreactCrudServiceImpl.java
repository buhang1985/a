package iih.ci.ord.ciorder.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.ciorder.d.desc.CiOrderReactDODesc;
import iih.ci.ord.ciorder.d.CiOrderReactDO;
import iih.ci.ord.ciorder.i.ICiorderreactCudService;
import iih.ci.ord.ciorder.i.ICiorderreactRService;


/**
 * 医嘱互斥记录表AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICiorderreactCudService.class,ICiorderreactRService.class}, binding=Binding.JSONRPC)
public class CiorderreactCrudServiceImpl extends BaseDOService<CiOrderReactDO> implements ICiorderreactCudService,ICiorderreactRService {
    public CiorderreactCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiOrderReactDODesc.class),IAppFwTempTbl.tmp_iaw_09.name()); 
    }
}
