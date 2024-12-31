package iih.ci.mr.per.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.ci.mr.per.d.PerDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.ci.mr.per.d.desc.PerDODesc;
import iih.ci.mr.per.d.PerAggDO;
import iih.ci.mr.per.i.IPerCudService;
import iih.ci.mr.per.i.IPerRService;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IPerCudService.class,IPerRService.class}, binding=Binding.JSONRPC)
public class PerCrudServiceImpl extends BaseAggService<PerAggDO,PerDO> implements IPerCudService,IPerRService {
    public PerCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PerDODesc.class),IAppFwTempTbl.tmp_iaw_17.name()); 
    }
}
