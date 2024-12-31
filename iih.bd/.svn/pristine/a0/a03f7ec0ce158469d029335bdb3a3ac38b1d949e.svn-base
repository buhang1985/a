package iih.bd.pp.pripmscene.s;
import iih.bd.pp.pripmscene.d.PriPmSceneDO;
import iih.bd.pp.pripmscene.d.desc.PriPmSceneDODesc;
import iih.bd.pp.pripmscene.i.IPripmsceneCudService;
import iih.bd.pp.pripmscene.i.IPripmsceneRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 付款方式使用场景AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IPripmsceneCudService.class,IPripmsceneRService.class}, binding=Binding.JSONRPC)
public class PripmsceneCrudServiceImpl extends BaseDOService<PriPmSceneDO> implements IPripmsceneCudService,IPripmsceneRService {
    public PripmsceneCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PriPmSceneDODesc.class),IAppFwTempTbl.tmp_iaw_04.name()); 
    }
}
