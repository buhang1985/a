package iih.mi.biz.mireferralinfo.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.biz.mireferralinfo.d.desc.MiReferralDODesc;
import iih.mi.biz.mireferralinfo.d.MiReferralDO;
import iih.mi.biz.mireferralinfo.i.IMireferralinfoCudService;
import iih.mi.biz.mireferralinfo.i.IMireferralinfoRService;


/**
 * 转诊申请单信息AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMireferralinfoCudService.class,IMireferralinfoRService.class}, binding=Binding.JSONRPC)
public class MireferralinfoCrudServiceImpl extends BaseDOService<MiReferralDO> implements IMireferralinfoCudService,IMireferralinfoRService {
    public MireferralinfoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MiReferralDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
    }
}
