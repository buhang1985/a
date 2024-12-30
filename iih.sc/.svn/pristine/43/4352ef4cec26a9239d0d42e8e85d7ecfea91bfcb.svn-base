package iih.sc.att.sctaskplweek.s;
import iih.sc.att.sctaskplweek.d.ScTaskPlWeekDO;
import iih.sc.att.sctaskplweek.d.desc.ScTaskPlWeekDODesc;
import iih.sc.att.sctaskplweek.i.ISctaskplweekCudService;
import iih.sc.att.sctaskplweek.i.ISctaskplweekRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISctaskplweekCudService.class,ISctaskplweekRService.class}, binding=Binding.JSONRPC)
public class SctaskplweekCrudServiceImpl extends BaseDOService<ScTaskPlWeekDO> implements ISctaskplweekCudService,ISctaskplweekRService {

    public SctaskplweekCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScTaskPlWeekDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
    }
}

