package iih.bd.mhi.hpmedpaytp.s;
import iih.bd.mhi.hpmedpaytp.d.HpMedPayTpDO;
import iih.bd.mhi.hpmedpaytp.d.desc.HpMedPayTpDODesc;
import iih.bd.mhi.hpmedpaytp.i.IHpmedpaytpCudService;
import iih.bd.mhi.hpmedpaytp.i.IHpmedpaytpRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医保产品_医疗付款方式AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHpmedpaytpCudService.class,IHpmedpaytpRService.class}, binding=Binding.JSONRPC)
public class HpmedpaytpCrudServiceImpl extends BaseDOService<HpMedPayTpDO> implements IHpmedpaytpCudService,IHpmedpaytpRService {
    public HpmedpaytpCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpMedPayTpDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
    }
}
