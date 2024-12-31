package iih.bl.pay.prepaypatrcpt.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.pay.prepaypatrcpt.d.desc.BlPrepayPatRcptDODesc;
import iih.bl.pay.prepaypatrcpt.d.BlPrepayPatRcptDO;
import iih.bl.pay.prepaypatrcpt.i.IPrepaypatrcptCudService;
import iih.bl.pay.prepaypatrcpt.i.IPrepaypatrcptRService;


/**
 * 预交金票据记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IPrepaypatrcptCudService.class,IPrepaypatrcptRService.class}, binding=Binding.JSONRPC)
public class PrepaypatrcptCrudServiceImpl extends BaseDOService<BlPrepayPatRcptDO> implements IPrepaypatrcptCudService,IPrepaypatrcptRService {
    public PrepaypatrcptCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlPrepayPatRcptDODesc.class),IAppFwTempTbl.tmp_iaw_17.name()); 
    }
}
