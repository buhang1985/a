package iih.ci.mb.dcmo.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.ci.mb.dcmo.d.DoctorMemoDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.ci.mb.dcmo.d.desc.DoctorMemoDODesc;
import iih.ci.mb.dcmo.d.DoctormemoAggDO;
import iih.ci.mb.dcmo.i.IDoctormemoCudService;
import iih.ci.mb.dcmo.i.IDoctormemoRService;


/**
 * 医生备忘录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IDoctormemoCudService.class,IDoctormemoRService.class}, binding=Binding.JSONRPC)
public class DoctormemoCrudServiceImpl extends BaseAggService<DoctormemoAggDO,DoctorMemoDO> implements IDoctormemoCudService,IDoctormemoRService {
    public DoctormemoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(DoctorMemoDODesc.class),IAppFwTempTbl.tmp_iaw_01.name()); 
    }
}
