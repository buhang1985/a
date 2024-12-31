package iih.bd.srv.mropgrouplevelrank.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.srv.mropgrouplevelrank.d.desc.MrOpGroupLevelRankDODesc;
import iih.bd.srv.mropgrouplevelrank.d.MrOpGroupLevelRankDO;
import iih.bd.srv.mropgrouplevelrank.i.IMropgrouplevelrankCudService;
import iih.bd.srv.mropgrouplevelrank.i.IMropgrouplevelrankRService;


/**
 * 操作职称AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMropgrouplevelrankCudService.class,IMropgrouplevelrankRService.class}, binding=Binding.JSONRPC)
public class MropgrouplevelrankCrudServiceImpl extends BaseDOService<MrOpGroupLevelRankDO> implements IMropgrouplevelrankCudService,IMropgrouplevelrankRService {
    public MropgrouplevelrankCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrOpGroupLevelRankDODesc.class),IAppFwTempTbl.tmp_iaw_01.name()); 
    }
}
