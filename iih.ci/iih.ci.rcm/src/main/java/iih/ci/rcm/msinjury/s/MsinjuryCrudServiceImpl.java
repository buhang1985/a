package iih.ci.rcm.msinjury.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.rcm.msinjury.d.desc.MsInjuryDODesc;
import iih.ci.rcm.msinjury.d.MsInjuryDO;
import iih.ci.rcm.msinjury.i.IMsinjuryCudService;
import iih.ci.rcm.msinjury.i.IMsinjuryRService;


/**
 * 医疗锐器伤登记表AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMsinjuryCudService.class,IMsinjuryRService.class}, binding=Binding.JSONRPC)
public class MsinjuryCrudServiceImpl extends BaseDOService<MsInjuryDO> implements IMsinjuryCudService,IMsinjuryRService {
    public MsinjuryCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MsInjuryDODesc.class),IAppFwTempTbl.tmp_iaw_22.name()); 
    }
}
