package iih.bd.srv.bdmrsigntype.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.srv.bdmrsigntype.d.desc.BdMrLvlItmDODesc;
import iih.bd.srv.bdmrsigntype.d.BdMrLvlItmDO;
import iih.bd.srv.bdmrsigntype.i.IBdmrlvlitmCudService;
import iih.bd.srv.bdmrsigntype.i.IBdmrlvlitmRService;


/**
 * 病历审签层级明细AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBdmrlvlitmCudService.class,IBdmrlvlitmRService.class}, binding=Binding.JSONRPC)
public class BdmrlvlitmCrudServiceImpl extends BaseDOService<BdMrLvlItmDO> implements IBdmrlvlitmCudService,IBdmrlvlitmRService {
    public BdmrlvlitmCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdMrLvlItmDODesc.class),IAppFwTempTbl.tmp_iaw_29.name()); 
    }
}
