package iih.bl.st.blpaypatiplog.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.st.blpaypatiplog.d.desc.BlPayItmPatIpLogDODesc;
import iih.bl.st.blpaypatiplog.d.BlPayItmPatIpLogDO;
import iih.bl.st.blpaypatiplog.i.IBlpaypatiplogCudService;
import iih.bl.st.blpaypatiplog.i.IBlpaypatiplogRService;


/**
 * 住院收付款日志AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlpaypatiplogCudService.class,IBlpaypatiplogRService.class}, binding=Binding.JSONRPC)
public class BlpaypatiplogCrudServiceImpl extends BaseDOService<BlPayItmPatIpLogDO> implements IBlpaypatiplogCudService,IBlpaypatiplogRService {
    public BlpaypatiplogCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlPayItmPatIpLogDODesc.class),IAppFwTempTbl.tmp_iaw_05.name()); 
    }
}
