package iih.bd.fc.enstatetpext.s;
import iih.bd.fc.enstatetpext.d.BdEnStateTpExtDO;
import iih.bd.fc.enstatetpext.d.desc.BdEnStateTpExtDODesc;
import iih.bd.fc.enstatetpext.i.IBdenstatetpextCudService;
import iih.bd.fc.enstatetpext.i.IBdenstatetpextRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 就诊状况类型定义扩展AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBdenstatetpextCudService.class,IBdenstatetpextRService.class}, binding=Binding.JSONRPC)
public class BdenstatetpextCrudServiceImpl extends BaseDOService<BdEnStateTpExtDO> implements IBdenstatetpextCudService,IBdenstatetpextRService {
    public BdenstatetpextCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdEnStateTpExtDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
}
