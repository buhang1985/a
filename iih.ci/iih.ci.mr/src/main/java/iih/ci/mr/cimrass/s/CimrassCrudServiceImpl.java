package iih.ci.mr.cimrass.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mr.cimrass.d.desc.CimrassDODesc;
import iih.ci.mr.cimrass.d.CimrassDO;
import iih.ci.mr.cimrass.i.ICimrassCudService;
import iih.ci.mr.cimrass.i.ICimrassRService;


/**
 * 医疗记录评估AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimrassCudService.class,ICimrassRService.class}, binding=Binding.JSONRPC)
public class CimrassCrudServiceImpl extends BaseDOService<CimrassDO> implements ICimrassCudService,ICimrassRService {

    public CimrassCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CimrassDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
    }
}

