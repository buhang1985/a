package iih.bl.prop.blpropoep.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.prop.blpropoep.d.desc.BlPropOepDODesc;
import iih.bl.prop.blpropoep.d.BlPropOepDO;
import iih.bl.prop.blpropoep.i.IBlpropoepCudService;
import iih.bl.prop.blpropoep.i.IBlpropoepRService;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlpropoepCudService.class,IBlpropoepRService.class}, binding=Binding.JSONRPC)
public class BlpropoepCrudServiceImpl extends BaseDOService<BlPropOepDO> implements IBlpropoepCudService,IBlpropoepRService {

    public BlpropoepCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlPropOepDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }
}

