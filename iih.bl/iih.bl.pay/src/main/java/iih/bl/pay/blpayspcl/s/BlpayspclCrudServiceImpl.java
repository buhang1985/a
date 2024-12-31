package iih.bl.pay.blpayspcl.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.bl.pay.blpayspcl.d.BlPaySpclDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.bl.pay.blpayspcl.d.desc.BlPaySpclDODesc;
import iih.bl.pay.blpayspcl.d.BlpayspclAggDO;
import iih.bl.pay.blpayspcl.i.IBlpayspclCudService;
import iih.bl.pay.blpayspcl.i.IBlpayspclRService;


/**
 * 收付款_专用款AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlpayspclCudService.class,IBlpayspclRService.class}, binding=Binding.JSONRPC)
public class BlpayspclCrudServiceImpl extends BaseAggService<BlpayspclAggDO,BlPaySpclDO> implements IBlpayspclCudService,IBlpayspclRService {
    public BlpayspclCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlPaySpclDODesc.class),IAppFwTempTbl.tmp_iaw_13.name()); 
    }
}
