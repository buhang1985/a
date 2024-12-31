package iih.ci.ord.cons.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.ci.ord.cons.d.OrdApConsDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.ci.ord.cons.d.desc.OrdApConsDODesc;
import iih.ci.ord.cons.d.CiorappconsultAggDO;
import iih.ci.ord.cons.i.ICiorappconsultCudService;
import iih.ci.ord.cons.i.ICiorappconsultRService;


/**
 * 会诊申请单AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICiorappconsultCudService.class,ICiorappconsultRService.class}, binding=Binding.JSONRPC)
public class CiorappconsultCrudServiceImpl extends BaseAggService<CiorappconsultAggDO,OrdApConsDO> implements ICiorappconsultCudService,ICiorappconsultRService {
    public CiorappconsultCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrdApConsDODesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
    }
}
