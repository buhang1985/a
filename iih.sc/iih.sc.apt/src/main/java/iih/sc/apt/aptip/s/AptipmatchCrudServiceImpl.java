package iih.sc.apt.aptip.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.sc.apt.aptip.d.desc.AptIpMatchDODesc;
import iih.sc.apt.aptip.d.AptIpMatchDO;
import iih.sc.apt.aptip.i.IAptipmatchCudService;
import iih.sc.apt.aptip.i.IAptipmatchRService;


/**
 * 住院预约匹配AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IAptipmatchCudService.class,IAptipmatchRService.class}, binding=Binding.JSONRPC)
public class AptipmatchCrudServiceImpl extends BaseDOService<AptIpMatchDO> implements IAptipmatchCudService,IAptipmatchRService {

    public AptipmatchCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(AptIpMatchDODesc.class),IAppFwTempTbl.tmp_iaw_08.name()); 
    }
}

