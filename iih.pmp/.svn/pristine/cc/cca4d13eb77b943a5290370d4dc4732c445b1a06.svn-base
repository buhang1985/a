package iih.pmp.pay.merchantinformation.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pmp.pay.merchantinformation.d.desc.MerchantInformationDODesc;
import iih.pmp.pay.merchantinformation.d.MerchantInformationDO;
import iih.pmp.pay.merchantinformation.i.IMerchantinformationCudService;
import iih.pmp.pay.merchantinformation.i.IMerchantinformationRService;


/**
 * 商户信息AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMerchantinformationCudService.class,IMerchantinformationRService.class}, binding=Binding.JSONRPC)
public class MerchantinformationCrudServiceImpl extends BaseDOService<MerchantInformationDO> implements IMerchantinformationCudService,IMerchantinformationRService {
    public MerchantinformationCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MerchantInformationDODesc.class),IAppFwTempTbl.tmp_iaw_28.name()); 
    }
}
