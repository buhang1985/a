package iih.bd.srv.mropgrouplevel.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.srv.mropgrouplevel.d.desc.MrOpGroupLevelDODesc;
import iih.bd.srv.mropgrouplevel.d.MrOpGroupLevelDO;
import iih.bd.srv.mropgrouplevel.i.IMropgrouplevelCudService;
import iih.bd.srv.mropgrouplevel.i.IMropgrouplevelRService;


/**
 * 操作层级AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMropgrouplevelCudService.class,IMropgrouplevelRService.class}, binding=Binding.JSONRPC)
public class MropgrouplevelCrudServiceImpl extends BaseDOService<MrOpGroupLevelDO> implements IMropgrouplevelCudService,IMropgrouplevelRService {
    public MropgrouplevelCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrOpGroupLevelDODesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }
}
