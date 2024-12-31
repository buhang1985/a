package iih.syn.common.userinit.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.syn.common.userinit.d.SynUserInitDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.syn.common.userinit.d.desc.SynUserInitDODesc;
import iih.syn.common.userinit.d.UserinitAggDO;
import iih.syn.common.userinit.i.IUserinitCudService;
import iih.syn.common.userinit.i.IUserinitRService;


/**
 * 用户同步初始化AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IUserinitCudService.class,IUserinitRService.class}, binding=Binding.JSONRPC)
public class UserinitCrudServiceImpl extends BaseAggService<UserinitAggDO,SynUserInitDO> implements IUserinitCudService,IUserinitRService {
    public UserinitCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SynUserInitDODesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }
}
