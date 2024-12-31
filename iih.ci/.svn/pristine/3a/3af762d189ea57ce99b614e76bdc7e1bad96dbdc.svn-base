package iih.ci.ciet.cievent.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ciet.cievent.d.desc.CiEventDODesc;
import iih.ci.ciet.cievent.d.CiEventDO;
import iih.ci.ciet.cievent.i.ICieventCudService;
import iih.ci.ciet.cievent.i.ICieventRService;


/**
 * 临床事件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICieventCudService.class,ICieventRService.class}, binding=Binding.JSONRPC)
public class CieventCrudServiceImpl extends BaseDOService<CiEventDO> implements ICieventCudService,ICieventRService {

    public CieventCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiEventDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }
}

