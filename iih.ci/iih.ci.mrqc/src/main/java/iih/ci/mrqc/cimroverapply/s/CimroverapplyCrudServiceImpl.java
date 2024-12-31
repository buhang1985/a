package iih.ci.mrqc.cimroverapply.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrqc.cimroverapply.d.desc.CiMrOverApplyDODesc;
import iih.ci.mrqc.cimroverapply.d.CiMrOverApplyDO;
import iih.ci.mrqc.cimroverapply.i.ICimroverapplyCudService;
import iih.ci.mrqc.cimroverapply.i.ICimroverapplyRService;


/**
 * 病历超时申请AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimroverapplyCudService.class,ICimroverapplyRService.class}, binding=Binding.JSONRPC)
public class CimroverapplyCrudServiceImpl extends BaseDOService<CiMrOverApplyDO> implements ICimroverapplyCudService,ICimroverapplyRService {
    public CimroverapplyCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrOverApplyDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
}
