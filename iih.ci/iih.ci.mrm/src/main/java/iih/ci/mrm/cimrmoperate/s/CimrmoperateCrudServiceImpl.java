package iih.ci.mrm.cimrmoperate.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrm.cimrmoperate.d.desc.CiMrmOperateDODesc;
import iih.ci.mrm.cimrmoperate.d.CiMrmOperateDO;
import iih.ci.mrm.cimrmoperate.i.ICimrmoperateCudService;
import iih.ci.mrm.cimrmoperate.i.ICimrmoperateRService;


/**
 * 病案操作AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimrmoperateCudService.class,ICimrmoperateRService.class}, binding=Binding.JSONRPC)
public class CimrmoperateCrudServiceImpl extends BaseDOService<CiMrmOperateDO> implements ICimrmoperateCudService,ICimrmoperateRService {
    public CimrmoperateCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrmOperateDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
}
