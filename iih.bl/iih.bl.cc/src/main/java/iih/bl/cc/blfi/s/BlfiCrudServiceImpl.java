package iih.bl.cc.blfi.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.cc.blfi.d.desc.BlFiDODesc;
import iih.bl.cc.blfi.d.BlFiDO;
import iih.bl.cc.blfi.i.IBlfiCudService;
import iih.bl.cc.blfi.i.IBlfiRService;


/**
 * 财务交割AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlfiCudService.class,IBlfiRService.class}, binding=Binding.JSONRPC)
public class BlfiCrudServiceImpl extends BaseDOService<BlFiDO> implements IBlfiCudService,IBlfiRService {
    public BlfiCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlFiDODesc.class),IAppFwTempTbl.tmp_iaw_05.name()); 
    }
}
