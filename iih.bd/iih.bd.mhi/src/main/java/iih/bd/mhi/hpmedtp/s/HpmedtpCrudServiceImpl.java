package iih.bd.mhi.hpmedtp.s;
import iih.bd.mhi.hpmedtp.d.HpMedTpDO;
import iih.bd.mhi.hpmedtp.d.desc.HpMedTpDODesc;
import iih.bd.mhi.hpmedtp.i.IHpmedtpCudService;
import iih.bd.mhi.hpmedtp.i.IHpmedtpRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医保产品_医疗类型AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHpmedtpCudService.class,IHpmedtpRService.class}, binding=Binding.JSONRPC)
public class HpmedtpCrudServiceImpl extends BaseDOService<HpMedTpDO> implements IHpmedtpCudService,IHpmedtpRService {
    public HpmedtpCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpMedTpDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
    }
}
