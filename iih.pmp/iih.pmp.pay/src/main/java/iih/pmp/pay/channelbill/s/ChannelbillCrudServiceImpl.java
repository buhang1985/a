package iih.pmp.pay.channelbill.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pmp.pay.channelbill.d.desc.ChannelBillDODesc;
import iih.pmp.pay.channelbill.d.ChannelBillDO;
import iih.pmp.pay.channelbill.i.IChannelbillCudService;
import iih.pmp.pay.channelbill.i.IChannelbillRService;


/**
 * 渠道账单AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IChannelbillCudService.class,IChannelbillRService.class}, binding=Binding.JSONRPC)
public class ChannelbillCrudServiceImpl extends BaseDOService<ChannelBillDO> implements IChannelbillCudService,IChannelbillRService {
    public ChannelbillCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ChannelBillDODesc.class),IAppFwTempTbl.tmp_iaw_22.name()); 
    }
}
