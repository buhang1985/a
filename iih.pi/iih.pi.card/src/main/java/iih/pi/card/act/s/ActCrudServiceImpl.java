package iih.pi.card.act.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.card.act.d.desc.PiCardActDODesc;
import iih.pi.card.act.d.PiCardActDO;
import iih.pi.card.act.i.IActCudService;
import iih.pi.card.act.i.IActRService;


/**
 * 就诊卡操作记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IActCudService.class,IActRService.class}, binding=Binding.JSONRPC)
public class ActCrudServiceImpl extends BaseDOService<PiCardActDO> implements IActCudService,IActRService {

    public ActCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiCardActDODesc.class),IAppFwTempTbl.tmp_iaw_01.name()); 
    }
}

