package iih.bd.srv.mrpsnpower.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.srv.mrpsnpower.d.desc.MrPsnPowerDODesc;
import iih.bd.srv.mrpsnpower.d.MrPsnPowerDO;
import iih.bd.srv.mrpsnpower.i.IMrpsnpowerCudService;
import iih.bd.srv.mrpsnpower.i.IMrpsnpowerRService;


/**
 * 病历人员权限配置AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMrpsnpowerCudService.class,IMrpsnpowerRService.class}, binding=Binding.JSONRPC)
public class MrpsnpowerCrudServiceImpl extends BaseDOService<MrPsnPowerDO> implements IMrpsnpowerCudService,IMrpsnpowerRService {
    public MrpsnpowerCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrPsnPowerDODesc.class),IAppFwTempTbl.tmp_iaw_23.name()); 
    }
}
