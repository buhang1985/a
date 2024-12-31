package iih.bd.pp.opmutextset.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.pp.opmutextset.d.desc.BdOpMutextSetDODesc;
import iih.bd.pp.opmutextset.d.BdOpMutextSetDO;
import iih.bd.pp.opmutextset.i.IOpmutextsetCudService;
import iih.bd.pp.opmutextset.i.IOpmutextsetRService;


/**
 * 门诊调入互斥配置AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IOpmutextsetCudService.class,IOpmutextsetRService.class}, binding=Binding.JSONRPC)
public class OpmutextsetCrudServiceImpl extends BaseDOService<BdOpMutextSetDO> implements IOpmutextsetCudService,IOpmutextsetRService {
    public OpmutextsetCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdOpMutextSetDODesc.class),IAppFwTempTbl.tmp_iaw_22.name()); 
    }
}
