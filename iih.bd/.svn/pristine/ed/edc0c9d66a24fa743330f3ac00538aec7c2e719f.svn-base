package iih.bd.srv.mropgrouplevelpsn.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.srv.mropgrouplevelpsn.d.desc.MrOpGroupLevelPsnDODesc;
import iih.bd.srv.mropgrouplevelpsn.d.MrOpGroupLevelPsnDO;
import iih.bd.srv.mropgrouplevelpsn.i.IMropgrouplevelpsnCudService;
import iih.bd.srv.mropgrouplevelpsn.i.IMropgrouplevelpsnRService;


/**
 * 操作人员AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMropgrouplevelpsnCudService.class,IMropgrouplevelpsnRService.class}, binding=Binding.JSONRPC)
public class MropgrouplevelpsnCrudServiceImpl extends BaseDOService<MrOpGroupLevelPsnDO> implements IMropgrouplevelpsnCudService,IMropgrouplevelpsnRService {
    public MropgrouplevelpsnCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrOpGroupLevelPsnDODesc.class),IAppFwTempTbl.tmp_iaw_01.name()); 
    }
}
