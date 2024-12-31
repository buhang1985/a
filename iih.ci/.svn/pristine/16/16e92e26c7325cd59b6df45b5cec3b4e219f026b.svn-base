package iih.ci.mr.mrlog.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mr.mrlog.d.desc.CiMrLogDODesc;
import iih.ci.mr.mrlog.d.CiMrLogDO;
import iih.ci.mr.mrlog.i.ICimrlogCudService;
import iih.ci.mr.mrlog.i.ICimrlogRService;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimrlogCudService.class,ICimrlogRService.class}, binding=Binding.JSONRPC)
public class CimrlogCrudServiceImpl extends BaseDOService<CiMrLogDO> implements ICimrlogCudService,ICimrlogRService {

    public CimrlogCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrLogDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
    }
}

