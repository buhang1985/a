package iih.bl.cg.bldcevent.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.cg.bldcevent.d.desc.BlDcEventDODesc;
import iih.bl.cg.bldcevent.d.BlDcEventDO;
import iih.bl.cg.bldcevent.i.IBldceventCudService;
import iih.bl.cg.bldcevent.i.IBldceventRService;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBldceventCudService.class,IBldceventRService.class}, binding=Binding.JSONRPC)
public class BldceventCrudServiceImpl extends BaseDOService<BlDcEventDO> implements IBldceventCudService,IBldceventRService {

    public BldceventCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlDcEventDODesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
    }
}

