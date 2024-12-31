package iih.ci.rcm.liqexpcontact.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.rcm.liqexpcontact.d.desc.LiqExpContactDODesc;
import iih.ci.rcm.liqexpcontact.d.LiqExpContactDO;
import iih.ci.rcm.liqexpcontact.i.ILiqexpcontactCudService;
import iih.ci.rcm.liqexpcontact.i.ILiqexpcontactRService;


/**
 * 血液/体液暴露接触登记表AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ILiqexpcontactCudService.class,ILiqexpcontactRService.class}, binding=Binding.JSONRPC)
public class LiqexpcontactCrudServiceImpl extends BaseDOService<LiqExpContactDO> implements ILiqexpcontactCudService,ILiqexpcontactRService {
    public LiqexpcontactCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(LiqExpContactDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }
}
