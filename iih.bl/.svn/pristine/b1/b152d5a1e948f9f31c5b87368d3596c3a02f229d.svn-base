package iih.bl.inc.blincoepcanclog.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.inc.blincoepcanclog.d.desc.BlIncOepCancLogDODesc;
import iih.bl.inc.blincoepcanclog.d.BlIncOepCancLogDO;
import iih.bl.inc.blincoepcanclog.i.IBlincoepcanclogCudService;
import iih.bl.inc.blincoepcanclog.i.IBlincoepcanclogRService;


/**
 * 门诊发票作废日志AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlincoepcanclogCudService.class,IBlincoepcanclogRService.class}, binding=Binding.JSONRPC)
public class BlincoepcanclogCrudServiceImpl extends BaseDOService<BlIncOepCancLogDO> implements IBlincoepcanclogCudService,IBlincoepcanclogRService {
    public BlincoepcanclogCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlIncOepCancLogDODesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
    }
}
