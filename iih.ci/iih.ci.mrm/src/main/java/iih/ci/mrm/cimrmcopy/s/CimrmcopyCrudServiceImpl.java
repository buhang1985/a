package iih.ci.mrm.cimrmcopy.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrm.cimrmcopy.d.desc.CiMrmCopyDODesc;
import iih.ci.mrm.cimrmcopy.d.CiMrmCopyDO;
import iih.ci.mrm.cimrmcopy.i.ICimrmcopyCudService;
import iih.ci.mrm.cimrmcopy.i.ICimrmcopyRService;


/**
 * 病案复印登记AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimrmcopyCudService.class,ICimrmcopyRService.class}, binding=Binding.JSONRPC)
public class CimrmcopyCrudServiceImpl extends BaseDOService<CiMrmCopyDO> implements ICimrmcopyCudService,ICimrmcopyRService {
    public CimrmcopyCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrmCopyDODesc.class),IAppFwTempTbl.tmp_iaw_28.name()); 
    }
}
