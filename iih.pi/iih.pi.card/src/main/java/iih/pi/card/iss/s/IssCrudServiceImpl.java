package iih.pi.card.iss.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.card.iss.d.desc.PiCardIssDODesc;
import iih.pi.card.iss.d.PiCardIssDO;
import iih.pi.card.iss.i.IIssCudService;
import iih.pi.card.iss.i.IIssRService;


/**
 * 就诊卡发放AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IIssCudService.class,IIssRService.class}, binding=Binding.JSONRPC)
public class IssCrudServiceImpl extends BaseDOService<PiCardIssDO> implements IIssCudService,IIssRService {

    public IssCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiCardIssDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
}

