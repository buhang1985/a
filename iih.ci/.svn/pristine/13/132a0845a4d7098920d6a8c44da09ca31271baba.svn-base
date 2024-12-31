package iih.ci.mr.cimrrs.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mr.cimrrs.d.desc.CiMrRsDODesc;
import iih.ci.mr.cimrrs.d.CiMrRsDO;
import iih.ci.mr.cimrrs.i.ICimrrsCudService;
import iih.ci.mr.cimrrs.i.ICimrrsRService;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimrrsCudService.class,ICimrrsRService.class}, binding=Binding.JSONRPC)
public class CimrrsCrudServiceImpl extends BaseDOService<CiMrRsDO> implements ICimrrsCudService,ICimrrsRService {
    public CimrrsCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrRsDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }
}

