package iih.bd.mhi.referralstatus.s;
import iih.bd.mhi.referralstatus.d.ReferralStatusDO;
import iih.bd.mhi.referralstatus.d.desc.ReferralStatusDODesc;
import iih.bd.mhi.referralstatus.i.IReferralstatusCudService;
import iih.bd.mhi.referralstatus.i.IReferralstatusRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医保产品 _转诊状态AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IReferralstatusCudService.class,IReferralstatusRService.class}, binding=Binding.JSONRPC)
public class ReferralstatusCrudServiceImpl extends BaseDOService<ReferralStatusDO> implements IReferralstatusCudService,IReferralstatusRService {
    public ReferralstatusCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ReferralStatusDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
}
