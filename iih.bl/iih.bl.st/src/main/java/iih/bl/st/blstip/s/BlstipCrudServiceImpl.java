package iih.bl.st.blstip.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.st.blstip.d.desc.BlStIpDODesc;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstip.i.IBlstipCudService;
import iih.bl.st.blstip.i.IBlstipRService;


/**
 * 住院结算AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlstipCudService.class,IBlstipRService.class}, binding=Binding.JSONRPC)
public class BlstipCrudServiceImpl extends BaseDOService<BlStIpDO> implements IBlstipCudService,IBlstipRService {

    public BlstipCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlStIpDODesc.class),IAppFwTempTbl.tmp_iaw_13.name()); 
    }
}

