package iih.bd.srv.bdmrsigntype.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.srv.bdmrsigntype.d.desc.BdMrLvlItmEmpDODesc;
import iih.bd.srv.bdmrsigntype.d.BdMrLvlItmEmpDO;
import iih.bd.srv.bdmrsigntype.i.IBdmrlvlitmempCudService;
import iih.bd.srv.bdmrsigntype.i.IBdmrlvlitmempRService;


/**
 * 病历审签层级明细对应人员AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBdmrlvlitmempCudService.class,IBdmrlvlitmempRService.class}, binding=Binding.JSONRPC)
public class BdmrlvlitmempCrudServiceImpl extends BaseDOService<BdMrLvlItmEmpDO> implements IBdmrlvlitmempCudService,IBdmrlvlitmempRService {
    public BdmrlvlitmempCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdMrLvlItmEmpDODesc.class),IAppFwTempTbl.tmp_iaw_03.name()); 
    }
}
