package iih.bd.mhi.admstatus.s;
import iih.bd.mhi.admstatus.d.AdmStatusDO;
import iih.bd.mhi.admstatus.d.desc.AdmStatusDODesc;
import iih.bd.mhi.admstatus.i.IAdmstatusCudService;
import iih.bd.mhi.admstatus.i.IAdmstatusRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 入院状态AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IAdmstatusCudService.class,IAdmstatusRService.class}, binding=Binding.JSONRPC)
public class AdmstatusCrudServiceImpl extends BaseDOService<AdmStatusDO> implements IAdmstatusCudService,IAdmstatusRService {
    public AdmstatusCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(AdmStatusDODesc.class),IAppFwTempTbl.tmp_iaw_15.name()); 
    }
}
