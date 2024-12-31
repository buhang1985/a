package iih.bd.res.depcont.s;
import iih.bd.res.depcont.d.DepContDO;
import iih.bd.res.depcont.d.DepcontAggDO;
import iih.bd.res.depcont.d.desc.DepContDODesc;
import iih.bd.res.depcont.i.IDepcontCudService;
import iih.bd.res.depcont.i.IDepcontRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医技科室对照AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IDepcontCudService.class,IDepcontRService.class}, binding=Binding.JSONRPC)
public class DepcontCrudServiceImpl extends BaseAggService<DepcontAggDO,DepContDO> implements IDepcontCudService,IDepcontRService {
    public DepcontCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(DepContDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
    }
}
