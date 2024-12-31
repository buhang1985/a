package iih.bd.fc.portallet.s;
import iih.bd.fc.portallet.d.MatchScopeDO;
import iih.bd.fc.portallet.d.desc.MatchScopeDODesc;
import iih.bd.fc.portallet.i.IMatchscopeCudService;
import iih.bd.fc.portallet.i.IMatchscopeRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMatchscopeCudService.class,IMatchscopeRService.class}, binding=Binding.JSONRPC)
public class MatchscopeCrudServiceImpl extends BaseDOService<MatchScopeDO> implements IMatchscopeCudService,IMatchscopeRService {

    public MatchscopeCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MatchScopeDODesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
    }
}

