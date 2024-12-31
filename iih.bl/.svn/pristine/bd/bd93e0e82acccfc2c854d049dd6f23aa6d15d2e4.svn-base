package iih.bl.hp.blhptransbankpay.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.hp.blhptransbankpay.d.desc.BlHpTransBankPayDODesc;
import iih.bl.hp.blhptransbankpay.d.BlHpTransBankPayDO;
import iih.bl.hp.blhptransbankpay.i.IBlhptransbankpayCudService;
import iih.bl.hp.blhptransbankpay.i.IBlhptransbankpayRService;


/**
 * 医保登记记录银行交易扩展AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlhptransbankpayCudService.class,IBlhptransbankpayRService.class}, binding=Binding.JSONRPC)
public class BlhptransbankpayCrudServiceImpl extends BaseDOService<BlHpTransBankPayDO> implements IBlhptransbankpayCudService,IBlhptransbankpayRService {
    public BlhptransbankpayCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlHpTransBankPayDODesc.class),IAppFwTempTbl.tmp_iaw_13.name()); 
    }
}
