package iih.ci.mrqc.recallapply.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrqc.recallapply.d.desc.ReCallApplyDODesc;
import iih.ci.mrqc.recallapply.d.ReCallApplyDO;
import iih.ci.mrqc.recallapply.i.IRecallapplyCudService;
import iih.ci.mrqc.recallapply.i.IRecallapplyRService;


/**
 * 病历召回申请DOAggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IRecallapplyCudService.class,IRecallapplyRService.class}, binding=Binding.JSONRPC)
public class RecallapplyCrudServiceImpl extends BaseDOService<ReCallApplyDO> implements IRecallapplyCudService,IRecallapplyRService {
    public RecallapplyCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ReCallApplyDODesc.class),IAppFwTempTbl.tmp_iaw_28.name()); 
    }
}
