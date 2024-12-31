package iih.ci.mr.mrlogitm.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mr.mrlogitm.d.desc.CiMrLogItmDODesc;
import iih.ci.mr.mrlogitm.d.CiMrLogItmDO;
import iih.ci.mr.mrlogitm.i.IMrlogitmCudService;
import iih.ci.mr.mrlogitm.i.IMrlogitmRService;


/**
 * 病历记录操作明细AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMrlogitmCudService.class,IMrlogitmRService.class}, binding=Binding.JSONRPC)
public class MrlogitmCrudServiceImpl extends BaseDOService<CiMrLogItmDO> implements IMrlogitmCudService,IMrlogitmRService {

    public MrlogitmCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrLogItmDODesc.class),IAppFwTempTbl.tmp_iaw_14.name()); 
    }
}

