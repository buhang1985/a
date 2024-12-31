package iih.bl.prop.blpropip.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.prop.blpropip.d.desc.BlPropIpDODesc;
import iih.bl.prop.blpropip.d.BlPropIpDO;
import iih.bl.prop.blpropip.i.IBlpropipCudService;
import iih.bl.prop.blpropip.i.IBlpropipRService;


/**
 * 住院分摊AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlpropipCudService.class,IBlpropipRService.class}, binding=Binding.JSONRPC)
public class BlpropipCrudServiceImpl extends BaseDOService<BlPropIpDO> implements IBlpropipCudService,IBlpropipRService {
    public BlpropipCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlPropIpDODesc.class),IAppFwTempTbl.tmp_iaw_02.name()); 
    }
}
