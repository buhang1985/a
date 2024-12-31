package iih.sc.apt.scaptappl.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.sc.apt.scaptappl.d.ScAptApplDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.sc.apt.scaptappl.d.desc.ScAptApplDODesc;
import iih.sc.apt.scaptappl.d.ScaptapplAggDO;
import iih.sc.apt.scaptappl.i.IScaptapplCudService;
import iih.sc.apt.scaptappl.i.IScaptapplRService;


/**
 * 计划排班_预约_申请AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IScaptapplCudService.class,IScaptapplRService.class}, binding=Binding.JSONRPC)
public class ScaptapplCrudServiceImpl extends BaseAggService<ScaptapplAggDO,ScAptApplDO> implements IScaptapplCudService,IScaptapplRService {
    public ScaptapplCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScAptApplDODesc.class),IAppFwTempTbl.tmp_iaw_22.name()); 
    }
}
