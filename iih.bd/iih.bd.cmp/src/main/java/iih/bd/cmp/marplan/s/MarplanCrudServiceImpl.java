package iih.bd.cmp.marplan.s;
import iih.bd.cmp.marplan.d.BdCmpMarPlanDO;
import iih.bd.cmp.marplan.d.MarplanAggDO;
import iih.bd.cmp.marplan.d.desc.BdCmpMarPlanDODesc;
import iih.bd.cmp.marplan.i.IMarplanCudService;
import iih.bd.cmp.marplan.i.IMarplanRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 营销方案AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMarplanCudService.class,IMarplanRService.class}, binding=Binding.JSONRPC)
public class MarplanCrudServiceImpl extends BaseAggService<MarplanAggDO,BdCmpMarPlanDO> implements IMarplanCudService,IMarplanRService {
    public MarplanCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdCmpMarPlanDODesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }
}
