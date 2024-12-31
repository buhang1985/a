package iih.ci.tsip.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.tsip.d.desc.CiTsApObsDODesc;
import iih.ci.tsip.d.CiTsApObsDO;
import iih.ci.tsip.i.ICitsapobsCudService;
import iih.ci.tsip.i.ICitsapobsRService;


/**
 * 治疗方案检查申请AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICitsapobsCudService.class,ICitsapobsRService.class}, binding=Binding.JSONRPC)
public class CitsapobsCrudServiceImpl extends BaseDOService<CiTsApObsDO> implements ICitsapobsCudService,ICitsapobsRService {
    public CitsapobsCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiTsApObsDODesc.class),IAppFwTempTbl.tmp_iaw_19.name()); 
    }
}
