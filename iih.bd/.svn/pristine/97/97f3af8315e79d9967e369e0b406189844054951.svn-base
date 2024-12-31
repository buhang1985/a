package iih.bd.fc.orpltp.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.bd.fc.orpltp.d.OrpltpDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.bd.fc.orpltp.d.desc.OrpltpDODesc;
import iih.bd.fc.orpltp.d.OrpltpAggDO;
import iih.bd.fc.orpltp.i.IOrpltpCudService;
import iih.bd.fc.orpltp.i.IOrpltpRService;


/**
 * 医嘱执行计划状态AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IOrpltpCudService.class,IOrpltpRService.class}, binding=Binding.JSONRPC)
public class OrpltpCrudServiceImpl extends BaseAggService<OrpltpAggDO,OrpltpDO> implements IOrpltpCudService,IOrpltpRService {
    public OrpltpCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrpltpDODesc.class),IAppFwTempTbl.tmp_iaw_17.name()); 
    }
}
