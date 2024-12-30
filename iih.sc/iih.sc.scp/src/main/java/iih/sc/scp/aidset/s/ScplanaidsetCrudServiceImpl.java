package iih.sc.scp.aidset.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.sc.scp.aidset.d.ScPlanAidSetDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.sc.scp.aidset.d.desc.ScPlanAidSetDODesc;
import iih.sc.scp.aidset.d.ScplanaidsetAggDO;
import iih.sc.scp.aidset.i.IScplanaidsetCudService;
import iih.sc.scp.aidset.i.IScplanaidsetRService;


/**
 * 辅助样本设置AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IScplanaidsetCudService.class,IScplanaidsetRService.class}, binding=Binding.JSONRPC)
public class ScplanaidsetCrudServiceImpl extends BaseAggService<ScplanaidsetAggDO,ScPlanAidSetDO> implements IScplanaidsetCudService,IScplanaidsetRService {
    public ScplanaidsetCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScPlanAidSetDODesc.class),IAppFwTempTbl.tmp_iaw_02.name()); 
    }
}
