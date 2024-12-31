package iih.sc.scbd.bdsrv.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.sc.scbd.bdsrv.d.ScBdsrvDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.sc.scbd.bdsrv.d.desc.ScBdsrvDODesc;
import iih.sc.scbd.bdsrv.d.ScbdsrvAggDO;
import iih.sc.scbd.bdsrv.i.IScbdsrvCudService;
import iih.sc.scbd.bdsrv.i.IScbdsrvRService;


/**
 * 排班计划-医疗服务AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IScbdsrvCudService.class,IScbdsrvRService.class}, binding=Binding.JSONRPC)
public class ScbdsrvCrudServiceImpl extends BaseAggService<ScbdsrvAggDO,ScBdsrvDO> implements IScbdsrvCudService,IScbdsrvRService {
    public ScbdsrvCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScBdsrvDODesc.class),IAppFwTempTbl.tmp_iaw_28.name());
    }
}
