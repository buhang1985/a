package iih.en.pv.inpatient.s;
import iih.en.pv.inpatient.d.EmgStayDO;
import iih.en.pv.inpatient.d.desc.EmgStayDODesc;
import iih.en.pv.inpatient.i.IEmgstayCudService;
import iih.en.pv.inpatient.i.IEmgstayRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 出留观AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEmgstayCudService.class,IEmgstayRService.class}, binding=Binding.JSONRPC)
public class EmgstayCrudServiceImpl extends BaseDOService<EmgStayDO> implements IEmgstayCudService,IEmgstayRService {
    public EmgstayCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EmgStayDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
    }
}
