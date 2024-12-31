package iih.pi.concern.concern.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.concern.concern.d.desc.PiPatIndDODesc;
import iih.pi.concern.concern.d.PiPatIndDO;
import iih.pi.concern.concern.i.IConcernCudService;
import iih.pi.concern.concern.i.IConcernRService;


/**
 * 患者关注指标AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IConcernCudService.class,IConcernRService.class}, binding=Binding.JSONRPC)
public class ConcernCrudServiceImpl extends BaseDOService<PiPatIndDO> implements IConcernCudService,IConcernRService {

    public ConcernCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatIndDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }
}

