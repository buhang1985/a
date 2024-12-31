package iih.ci.mrqc.amrapply.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrqc.amrapply.d.desc.AmrApplyDODesc;
import iih.ci.mrqc.amrapply.d.AmrApplyDO;
import iih.ci.mrqc.amrapply.i.IAmrapplyCudService;
import iih.ci.mrqc.amrapply.i.IAmrapplyRService;


/**
 * 病案召回申请AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IAmrapplyCudService.class,IAmrapplyRService.class}, binding=Binding.JSONRPC)
public class AmrapplyCrudServiceImpl extends BaseDOService<AmrApplyDO> implements IAmrapplyCudService,IAmrapplyRService {

    public AmrapplyCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(AmrApplyDODesc.class),IAppFwTempTbl.tmp_iaw_14.name()); 
    }
}

