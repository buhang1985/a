package iih.ci.diag.cidiag.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.ci.diag.cidiag.d.CiDiagDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.ci.diag.cidiag.d.desc.CiDiagDODesc;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.cidiag.i.ICidiagCudService;
import iih.ci.diag.cidiag.i.ICidiagRService;


/**
 * 临床诊断AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICidiagCudService.class,ICidiagRService.class}, binding=Binding.JSONRPC)
public class CidiagCrudServiceImpl extends BaseAggService<CidiagAggDO,CiDiagDO> implements ICidiagCudService,ICidiagRService {
    public CidiagCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiDiagDODesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
    }
}

