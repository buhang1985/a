package iih.en.pv.enbeditem.s;
import iih.en.pv.enbeditem.d.Enbeditem;
import iih.en.pv.enbeditem.d.desc.EnbeditemDesc;
import iih.en.pv.enbeditem.i.IEnbeditemCudService;
import iih.en.pv.enbeditem.i.IEnbeditemRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * enbeditemAggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnbeditemCudService.class,IEnbeditemRService.class}, binding=Binding.JSONRPC)
public class EnbeditemCrudServiceImpl extends BaseDOService<Enbeditem> implements IEnbeditemCudService,IEnbeditemRService {
    public EnbeditemCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnbeditemDesc.class),IAppFwTempTbl.tmp_iaw_28.name()); 
    }
}
