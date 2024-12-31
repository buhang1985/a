package iih.pmp.pay.paychannels.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pmp.pay.paychannels.d.desc.PaychannelsDODesc;
import iih.pmp.pay.paychannels.d.PaychannelsDO;
import iih.pmp.pay.paychannels.i.IPaychannelsCudService;
import iih.pmp.pay.paychannels.i.IPaychannelsRService;


/**
 * 支付渠道AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IPaychannelsCudService.class,IPaychannelsRService.class}, binding=Binding.JSONRPC)
public class PaychannelsCrudServiceImpl extends BaseDOService<PaychannelsDO> implements IPaychannelsCudService,IPaychannelsRService {
    public PaychannelsCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PaychannelsDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
}
