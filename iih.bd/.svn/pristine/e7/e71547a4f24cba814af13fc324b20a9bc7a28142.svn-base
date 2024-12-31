package iih.bd.srv.bdmrsigntype.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.srv.bdmrsigntype.d.desc.BdMrLvlDODesc;
import iih.bd.srv.bdmrsigntype.d.BdMrLvlDO;
import iih.bd.srv.bdmrsigntype.i.IBdmrlvlCudService;
import iih.bd.srv.bdmrsigntype.i.IBdmrlvlRService;


/**
 * 病历审签层级定义AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBdmrlvlCudService.class,IBdmrlvlRService.class}, binding=Binding.JSONRPC)
public class BdmrlvlCrudServiceImpl extends BaseDOService<BdMrLvlDO> implements IBdmrlvlCudService,IBdmrlvlRService {
    public BdmrlvlCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdMrLvlDODesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
    }
}
