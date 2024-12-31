package iih.en.pv.enentbankacc.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.en.pv.enentbankacc.d.desc.EnEntBankaccDODesc;
import iih.en.pv.enentbankacc.d.EnEntBankaccDO;
import iih.en.pv.enentbankacc.i.IEnentbankaccCudService;
import iih.en.pv.enentbankacc.i.IEnentbankaccRService;


/**
 * 患者银行账户AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnentbankaccCudService.class,IEnentbankaccRService.class}, binding=Binding.JSONRPC)
public class EnentbankaccCrudServiceImpl extends BaseDOService<EnEntBankaccDO> implements IEnentbankaccCudService,IEnentbankaccRService {
    public EnentbankaccCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnEntBankaccDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
}
