package iih.ci.mrm.cimrmsp.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrm.cimrmsp.d.desc.CiMrmMailDODesc;
import iih.ci.mrm.cimrmsp.d.CiMrmMailDO;
import iih.ci.mrm.cimrmsp.i.ICimrmspCudService;
import iih.ci.mrm.cimrmsp.i.ICimrmspRService;


/**
 * 病案邮寄AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimrmspCudService.class,ICimrmspRService.class}, binding=Binding.JSONRPC)
public class CimrmspCrudServiceImpl extends BaseDOService<CiMrmMailDO> implements ICimrmspCudService,ICimrmspRService {
    public CimrmspCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrmMailDODesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
    }
}
