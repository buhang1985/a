package iih.sc.scbd.schedulesrv.s;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvRelDO;
import iih.sc.scbd.schedulesrv.d.desc.ScheduleSrvRelDODesc;
import iih.sc.scbd.schedulesrv.i.IScheduleSrvRelDOCudService;
import iih.sc.scbd.schedulesrv.i.IScheduleSrvRelDORService;
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
@Service(serviceInterfaces={IScheduleSrvRelDOCudService.class,IScheduleSrvRelDORService.class}, binding=Binding.JSONRPC)
public class ScheduleSrvRelDOCrudServiceImpl extends BaseDOService<ScheduleSrvRelDO> implements IScheduleSrvRelDOCudService,IScheduleSrvRelDORService {

    public ScheduleSrvRelDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScheduleSrvRelDODesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
    }
}

