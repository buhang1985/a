package iih.en.pv.shiftturnover.s;
import iih.en.pv.shiftturnover.d.ShiftTurnOverDO;
import iih.en.pv.shiftturnover.d.ShiftturnoverAggDO;
import iih.en.pv.shiftturnover.d.desc.ShiftTurnOverDODesc;
import iih.en.pv.shiftturnover.i.IShiftturnoverCudService;
import iih.en.pv.shiftturnover.i.IShiftturnoverRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医生交接班AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IShiftturnoverCudService.class,IShiftturnoverRService.class}, binding=Binding.JSONRPC)
public class ShiftturnoverCrudServiceImpl extends BaseAggService<ShiftturnoverAggDO,ShiftTurnOverDO> implements IShiftturnoverCudService,IShiftturnoverRService {
    public ShiftturnoverCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ShiftTurnOverDODesc.class),IAppFwTempTbl.tmp_iaw_22.name()); 
    }
}
