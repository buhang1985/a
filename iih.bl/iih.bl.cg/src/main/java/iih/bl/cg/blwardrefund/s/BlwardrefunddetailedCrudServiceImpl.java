package iih.bl.cg.blwardrefund.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.cg.blwardrefund.d.desc.BlRefundItemDODesc;
import iih.bl.cg.blwardrefund.d.BlRefundItemDO;
import iih.bl.cg.blwardrefund.i.IBlwardrefunddetailedCudService;
import iih.bl.cg.blwardrefund.i.IBlwardrefunddetailedRService;


/**
 * 住院病区退费申请明细AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlwardrefunddetailedCudService.class,IBlwardrefunddetailedRService.class}, binding=Binding.JSONRPC)
public class BlwardrefunddetailedCrudServiceImpl extends BaseDOService<BlRefundItemDO> implements IBlwardrefunddetailedCudService,IBlwardrefunddetailedRService {
    public BlwardrefunddetailedCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlRefundItemDODesc.class),IAppFwTempTbl.tmp_iaw_16.name()); 
    }
}
