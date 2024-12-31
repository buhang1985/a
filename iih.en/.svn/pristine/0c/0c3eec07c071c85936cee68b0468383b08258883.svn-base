package iih.en.pv.ci.s;
import iih.en.pv.ci.d.MedReferralDO;
import iih.en.pv.ci.d.desc.MedReferralDODesc;
import iih.en.pv.ci.i.IMedreferralCudService;
import iih.en.pv.ci.i.IMedreferralRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医疗转诊单AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMedreferralCudService.class,IMedreferralRService.class}, binding=Binding.JSONRPC)
public class MedreferralCrudServiceImpl extends BaseDOService<MedReferralDO> implements IMedreferralCudService,IMedreferralRService {
    public MedreferralCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MedReferralDODesc.class),IAppFwTempTbl.tmp_iaw_02.name()); 
    }
}
