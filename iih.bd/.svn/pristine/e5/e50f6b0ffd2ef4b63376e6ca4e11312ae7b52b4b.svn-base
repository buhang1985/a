package iih.bd.mhi.referralapprcate.s;
import iih.bd.mhi.referralapprcate.d.ReferralApprCateDO;
import iih.bd.mhi.referralapprcate.d.desc.ReferralApprCateDODesc;
import iih.bd.mhi.referralapprcate.i.IReferralapprcateCudService;
import iih.bd.mhi.referralapprcate.i.IReferralapprcateRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医保产品_转诊审批类别AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IReferralapprcateCudService.class,IReferralapprcateRService.class}, binding=Binding.JSONRPC)
public class ReferralapprcateCrudServiceImpl extends BaseDOService<ReferralApprCateDO> implements IReferralapprcateCudService,IReferralapprcateRService {
    public ReferralapprcateCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ReferralApprCateDODesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
    }
}
