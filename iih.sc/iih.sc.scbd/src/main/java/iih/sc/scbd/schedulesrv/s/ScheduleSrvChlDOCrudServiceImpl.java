package iih.sc.scbd.schedulesrv.s;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvChlDO;
import iih.sc.scbd.schedulesrv.d.desc.ScheduleSrvChlDODesc;
import iih.sc.scbd.schedulesrv.i.IScheduleSrvChlDOCudService;
import iih.sc.scbd.schedulesrv.i.IScheduleSrvChlDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 排班服务主实体CRUD服务实现
 */
@Service(serviceInterfaces={IScheduleSrvChlDOCudService.class,IScheduleSrvChlDORService.class}, binding=Binding.JSONRPC)
public class ScheduleSrvChlDOCrudServiceImpl extends BaseDOService<ScheduleSrvChlDO> implements IScheduleSrvChlDOCudService,IScheduleSrvChlDORService {

    public ScheduleSrvChlDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScheduleSrvChlDODesc.class),IAppFwTempTbl.tmp_iaw_19.name()); 
    }
}

