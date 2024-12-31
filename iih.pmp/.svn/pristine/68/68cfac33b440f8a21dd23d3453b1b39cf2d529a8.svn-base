package iih.pmp.pay.billcheckexception.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pmp.pay.billcheckexception.d.desc.BillCheckExceptionDODesc;
import iih.pmp.pay.billcheckexception.d.BillCheckExceptionDO;
import iih.pmp.pay.billcheckexception.i.IBillcheckexceptionCudService;
import iih.pmp.pay.billcheckexception.i.IBillcheckexceptionRService;


/**
 * 对账异常数据AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBillcheckexceptionCudService.class,IBillcheckexceptionRService.class}, binding=Binding.JSONRPC)
public class BillcheckexceptionCrudServiceImpl extends BaseDOService<BillCheckExceptionDO> implements IBillcheckexceptionCudService,IBillcheckexceptionRService {
    public BillcheckexceptionCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BillCheckExceptionDODesc.class),IAppFwTempTbl.tmp_iaw_15.name()); 
    }
}
