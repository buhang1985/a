package iih.bl.pay.blpaypat.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.pay.blpaypat.d.desc.BlPrepayPatReprintDODesc;
import iih.bl.pay.blpaypat.d.BlPrepayPatReprintDO;
import iih.bl.pay.blpaypat.i.IBlpaypatreprintCudService;
import iih.bl.pay.blpaypat.i.IBlpaypatreprintRService;


/**
 * 预交金凭条重打组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlpaypatreprintCudService.class,IBlpaypatreprintRService.class}, binding=Binding.JSONRPC)
public class BlpaypatreprintCrudServiceImpl extends BaseDOService<BlPrepayPatReprintDO> implements IBlpaypatreprintCudService,IBlpaypatreprintRService {
    public BlpaypatreprintCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlPrepayPatReprintDODesc.class),IAppFwTempTbl.tmp_iaw_23.name()); 
    }
}
