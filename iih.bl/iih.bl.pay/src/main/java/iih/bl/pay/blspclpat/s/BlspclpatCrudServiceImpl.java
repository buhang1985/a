package iih.bl.pay.blspclpat.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.bl.pay.blspclpat.d.BlSpclPatDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.bl.pay.blspclpat.d.desc.BlSpclPatDODesc;
import iih.bl.pay.blspclpat.d.BlspclpatAggDO;
import iih.bl.pay.blspclpat.i.IBlspclpatCudService;
import iih.bl.pay.blspclpat.i.IBlspclpatRService;


/**
 * 患者专用款AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlspclpatCudService.class,IBlspclpatRService.class}, binding=Binding.JSONRPC)
public class BlspclpatCrudServiceImpl extends BaseAggService<BlspclpatAggDO,BlSpclPatDO> implements IBlspclpatCudService,IBlspclpatRService {
    public BlspclpatCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlSpclPatDODesc.class),IAppFwTempTbl.tmp_iaw_16.name()); 
    }
}
