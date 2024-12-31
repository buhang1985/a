package iih.ci.ord.ordext.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.ordext.d.desc.OrdSrvHpDODesc;
import iih.ci.ord.ordext.d.OrdSrvHpDO;
import iih.ci.ord.ordext.i.IOrdsrvhpCudService;
import iih.ci.ord.ordext.i.IOrdsrvhpRService;


/**
 * 医嘱扩展表AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IOrdsrvhpCudService.class,IOrdsrvhpRService.class}, binding=Binding.JSONRPC)
public class OrdsrvhpCrudServiceImpl extends BaseDOService<OrdSrvHpDO> implements IOrdsrvhpCudService,IOrdsrvhpRService {
    public OrdsrvhpCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrdSrvHpDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
}
