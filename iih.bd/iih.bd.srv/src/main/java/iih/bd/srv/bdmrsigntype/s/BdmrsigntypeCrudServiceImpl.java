package iih.bd.srv.bdmrsigntype.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.srv.bdmrsigntype.d.desc.BdMrSignTypeDODesc;
import iih.bd.srv.bdmrsigntype.d.BdMrSignTypeDO;
import iih.bd.srv.bdmrsigntype.i.IBdmrsigntypeCudService;
import iih.bd.srv.bdmrsigntype.i.IBdmrsigntypeRService;


/**
 * 病历审签类型AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBdmrsigntypeCudService.class,IBdmrsigntypeRService.class}, binding=Binding.JSONRPC)
public class BdmrsigntypeCrudServiceImpl extends BaseDOService<BdMrSignTypeDO> implements IBdmrsigntypeCudService,IBdmrsigntypeRService {
    public BdmrsigntypeCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdMrSignTypeDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }
}
