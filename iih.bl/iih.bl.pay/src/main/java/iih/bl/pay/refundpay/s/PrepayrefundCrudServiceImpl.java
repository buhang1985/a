package iih.bl.pay.refundpay.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.pay.prepayrefund.d.desc.BlPrepayPatRefundDODesc;
import iih.bl.pay.prepayrefund.d.BlPrepayPatRefundDO;
import iih.bl.pay.prepayrefund.i.IPrepayrefundCudService;
import iih.bl.pay.prepayrefund.i.IPrepayrefundRService;


/**
 * 预交金强制退费记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IPrepayrefundCudService.class,IPrepayrefundRService.class}, binding=Binding.JSONRPC)
public class PrepayrefundCrudServiceImpl extends BaseDOService<BlPrepayPatRefundDO> implements IPrepayrefundCudService,IPrepayrefundRService {
    public PrepayrefundCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlPrepayPatRefundDODesc.class),IAppFwTempTbl.tmp_iaw_19.name()); 
    }
}
