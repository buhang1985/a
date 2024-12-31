package iih.pi.reg.patvspsn.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.reg.patvspsn.d.desc.PiPatVsPsnDODesc;
import iih.pi.reg.patvspsn.d.PiPatVsPsnDO;
import iih.pi.reg.patvspsn.i.IPatvspsnCudService;
import iih.pi.reg.patvspsn.i.IPatvspsnRService;


/**
 * 患者人员关系AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IPatvspsnCudService.class,IPatvspsnRService.class}, binding=Binding.JSONRPC)
public class PatvspsnCrudServiceImpl extends BaseDOService<PiPatVsPsnDO> implements IPatvspsnCudService,IPatvspsnRService {
    public PatvspsnCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatVsPsnDODesc.class),IAppFwTempTbl.tmp_iaw_19.name()); 
    }
}
