package iih.ci.mrqc.autoitmconfig.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrqc.autoitmconfig.d.desc.AutoItmConfigDODesc;
import iih.ci.mrqc.autoitmconfig.d.AutoItmConfigDO;
import iih.ci.mrqc.autoitmconfig.i.IAutoitmconfigCudService;
import iih.ci.mrqc.autoitmconfig.i.IAutoitmconfigRService;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IAutoitmconfigCudService.class,IAutoitmconfigRService.class}, binding=Binding.JSONRPC)
public class AutoitmconfigCrudServiceImpl extends BaseDOService<AutoItmConfigDO> implements IAutoitmconfigCudService,IAutoitmconfigRService {

    public AutoitmconfigCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(AutoItmConfigDODesc.class),IAppFwTempTbl.tmp_iaw_09.name()); 
    }
}

