package iih.sc.apt.scaptapplexchl.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.sc.apt.scaptapplexchl.d.desc.ScAptApplExchlDODesc;
import iih.sc.apt.scaptapplexchl.d.ScAptApplExchlDO;
import iih.sc.apt.scaptapplexchl.i.IScaptapplexchlCudService;
import iih.sc.apt.scaptapplexchl.i.IScaptapplexchlRService;


/**
 * 计划排班_预约_申请_外部渠道AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IScaptapplexchlCudService.class,IScaptapplexchlRService.class}, binding=Binding.JSONRPC)
public class ScaptapplexchlCrudServiceImpl extends BaseDOService<ScAptApplExchlDO> implements IScaptapplexchlCudService,IScaptapplexchlRService {
    public ScaptapplexchlCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScAptApplExchlDODesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
    }
}
