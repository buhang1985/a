package iih.bd.fc.orpltpmatch.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.bd.fc.orpltpmatch.d.OrpltpMatchDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.bd.fc.orpltpmatch.d.desc.OrpltpMatchDODesc;
import iih.bd.fc.orpltpmatch.d.OrpltpmatchAggDO;
import iih.bd.fc.orpltpmatch.i.IOrpltpmatchCudService;
import iih.bd.fc.orpltpmatch.i.IOrpltpmatchRService;


/**
 * 医嘱闭环匹配AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IOrpltpmatchCudService.class,IOrpltpmatchRService.class}, binding=Binding.JSONRPC)
public class OrpltpmatchCrudServiceImpl extends BaseAggService<OrpltpmatchAggDO,OrpltpMatchDO> implements IOrpltpmatchCudService,IOrpltpmatchRService {
    public OrpltpmatchCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrpltpMatchDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
    }
}
