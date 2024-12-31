package iih.ci.mr.mrdocrefvalue.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mr.mrdocrefvalue.d.desc.MrDocRefValueDODesc;
import iih.ci.mr.mrdocrefvalue.d.MrDocRefValueDO;
import iih.ci.mr.mrdocrefvalue.i.IMrdocrefvalueCudService;
import iih.ci.mr.mrdocrefvalue.i.IMrdocrefvalueRService;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMrdocrefvalueCudService.class,IMrdocrefvalueRService.class}, binding=Binding.JSONRPC)
public class MrdocrefvalueCrudServiceImpl extends BaseDOService<MrDocRefValueDO> implements IMrdocrefvalueCudService,IMrdocrefvalueRService {

    public MrdocrefvalueCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrDocRefValueDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
    }
}

