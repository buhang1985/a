package iih.bd.fc.orwf.s;
import iih.bd.fc.orwf.d.OrWfCfgDO;
import iih.bd.fc.orwf.d.OrwfAggDO;
import iih.bd.fc.orwf.d.desc.OrWfCfgDODesc;
import iih.bd.fc.orwf.i.IOrwfCudService;
import iih.bd.fc.orwf.i.IOrwfRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医嘱流向AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IOrwfCudService.class,IOrwfRService.class}, binding=Binding.JSONRPC)
public class OrwfCrudServiceImpl extends BaseAggService<OrwfAggDO,OrWfCfgDO> implements IOrwfCudService,IOrwfRService {
    public OrwfCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrWfCfgDODesc.class),IAppFwTempTbl.tmp_iaw_14.name()); 
    }
}
