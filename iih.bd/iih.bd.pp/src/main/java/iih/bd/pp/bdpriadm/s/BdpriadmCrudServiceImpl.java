package iih.bd.pp.bdpriadm.s;
import iih.bd.pp.bdpriadm.d.BDPriAdmDO;
import iih.bd.pp.bdpriadm.d.desc.BDPriAdmDODesc;
import iih.bd.pp.bdpriadm.i.IBdpriadmCudService;
import iih.bd.pp.bdpriadm.i.IBdpriadmRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 入院登记收费项目配置AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBdpriadmCudService.class,IBdpriadmRService.class}, binding=Binding.JSONRPC)
public class BdpriadmCrudServiceImpl extends BaseDOService<BDPriAdmDO> implements IBdpriadmCudService,IBdpriadmRService {
    public BdpriadmCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BDPriAdmDODesc.class),IAppFwTempTbl.tmp_iaw_02.name()); 
    }
}
