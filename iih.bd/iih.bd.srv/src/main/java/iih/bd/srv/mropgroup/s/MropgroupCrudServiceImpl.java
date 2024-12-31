package iih.bd.srv.mropgroup.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.srv.mropgroup.d.desc.MrOpGroupDODesc;
import iih.bd.srv.mropgroup.d.MrOpGroupDO;
import iih.bd.srv.mropgroup.i.IMropgroupCudService;
import iih.bd.srv.mropgroup.i.IMropgroupRService;


/**
 * 病历业务组AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMropgroupCudService.class,IMropgroupRService.class}, binding=Binding.JSONRPC)
public class MropgroupCrudServiceImpl extends BaseDOService<MrOpGroupDO> implements IMropgroupCudService,IMropgroupRService {
    public MropgroupCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrOpGroupDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
    }
}
