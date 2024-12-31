package iih.ci.preip.order.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.preip.order.d.desc.CiOrPipDODesc;
import iih.ci.preip.order.d.CiOrPipDO;
import iih.ci.preip.order.i.ICiorpipCudService;
import iih.ci.preip.order.i.ICiorpipRService;


/**
 * 预住院医嘱记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICiorpipCudService.class,ICiorpipRService.class}, binding=Binding.JSONRPC)
public class CiorpipCrudServiceImpl extends BaseDOService<CiOrPipDO> implements ICiorpipCudService,ICiorpipRService {
    public CiorpipCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiOrPipDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
    }
}
