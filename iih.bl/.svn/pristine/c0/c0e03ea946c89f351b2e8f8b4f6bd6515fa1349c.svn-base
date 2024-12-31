package iih.bl.inc.blinccgip.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.inc.blinccgip.d.desc.BlIncCgIpDODesc;
import iih.bl.inc.blinccgip.d.BlIncCgIpDO;
import iih.bl.inc.blinccgip.i.IBlinccgipCudService;
import iih.bl.inc.blinccgip.i.IBlinccgipRService;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlinccgipCudService.class,IBlinccgipRService.class}, binding=Binding.JSONRPC)
public class BlinccgipCrudServiceImpl extends BaseDOService<BlIncCgIpDO> implements IBlinccgipCudService,IBlinccgipRService {

    public BlinccgipCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlIncCgIpDODesc.class),IAppFwTempTbl.tmp_iaw_03.name()); 
    }
}

