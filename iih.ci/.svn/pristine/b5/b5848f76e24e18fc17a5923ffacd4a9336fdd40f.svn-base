package iih.ci.mr.cimrfs.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mr.cimrfs.d.desc.CiMrFsDODesc;
import iih.ci.mr.cimrfs.d.CiMrFsDO;
import iih.ci.mr.cimrfs.i.ICimrfsCudService;
import iih.ci.mr.cimrfs.i.ICimrfsRService;


/**
 * 临床医疗记录流数据AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimrfsCudService.class,ICimrfsRService.class}, binding=Binding.JSONRPC)
public class CimrfsCrudServiceImpl extends BaseDOService<CiMrFsDO> implements ICimrfsCudService,ICimrfsRService {

    public CimrfsCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrFsDODesc.class),IAppFwTempTbl.tmp_iaw_13.name()); 
    }
}

