package iih.ci.rcm.hospitalreport.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.rcm.hospitalreport.d.desc.HospitalReportDODesc;
import iih.ci.rcm.hospitalreport.d.HospitalReportDO;
import iih.ci.rcm.hospitalreport.i.IHospitalreportCudService;
import iih.ci.rcm.hospitalreport.i.IHospitalreportRService;


/**
 * 院感上报AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHospitalreportCudService.class,IHospitalreportRService.class}, binding=Binding.JSONRPC)
public class HospitalreportCrudServiceImpl extends BaseDOService<HospitalReportDO> implements IHospitalreportCudService,IHospitalreportRService {
    public HospitalreportCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HospitalReportDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
    }
}
