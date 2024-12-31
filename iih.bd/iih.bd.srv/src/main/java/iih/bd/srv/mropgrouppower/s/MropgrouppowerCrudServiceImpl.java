package iih.bd.srv.mropgrouppower.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.srv.mropgrouppower.d.desc.MrOpGroupPowerDODesc;
import iih.bd.srv.mropgrouppower.d.MrOpGroupPowerDO;
import iih.bd.srv.mropgrouppower.i.IMropgrouppowerCudService;
import iih.bd.srv.mropgrouppower.i.IMropgrouppowerRService;


/**
 * 病历业务组权限配置AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMropgrouppowerCudService.class,IMropgrouppowerRService.class}, binding=Binding.JSONRPC)
public class MropgrouppowerCrudServiceImpl extends BaseDOService<MrOpGroupPowerDO> implements IMropgrouppowerCudService,IMropgrouppowerRService {
    public MropgrouppowerCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrOpGroupPowerDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }
}
