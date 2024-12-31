package iih.bl.cg.blrecgip.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.cg.blrecgip.d.desc.BlRecgIpDODesc;
import iih.bl.cg.blrecgip.d.BlRecgIpDO;
import iih.bl.cg.blrecgip.i.IBlrecgipCudService;
import iih.bl.cg.blrecgip.i.IBlrecgipRService;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlrecgipCudService.class,IBlrecgipRService.class}, binding=Binding.JSONRPC)
public class BlrecgipCrudServiceImpl extends BaseDOService<BlRecgIpDO> implements IBlrecgipCudService,IBlrecgipRService {

    public BlrecgipCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlRecgIpDODesc.class),IAppFwTempTbl.tmp_iaw_23.name()); 
    }
}

