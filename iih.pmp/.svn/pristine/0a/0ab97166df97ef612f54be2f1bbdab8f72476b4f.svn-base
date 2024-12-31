package iih.pmp.pay.trademonitor.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pmp.pay.trademonitor.d.desc.TradeMonitorDODesc;
import iih.pmp.pay.trademonitor.d.TradeMonitorDO;
import iih.pmp.pay.trademonitor.i.ITrademonitorCudService;
import iih.pmp.pay.trademonitor.i.ITrademonitorRService;


/**
 * 交易监控AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ITrademonitorCudService.class,ITrademonitorRService.class}, binding=Binding.JSONRPC)
public class TrademonitorCrudServiceImpl extends BaseDOService<TradeMonitorDO> implements ITrademonitorCudService,ITrademonitorRService {
    public TrademonitorCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(TradeMonitorDODesc.class),IAppFwTempTbl.tmp_iaw_08.name()); 
    }
}
