package iih.bd.srv.reportcardtypediagdo.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.srv.reportcardtypediagdo.d.desc.ReportCardTypeDiagDODesc;
import iih.bd.srv.reportcardtypediagdo.d.ReportCardTypeDiagDO;
import iih.bd.srv.reportcardtypediagdo.i.IReportcardtypediagdoCudService;
import iih.bd.srv.reportcardtypediagdo.i.IReportcardtypediagdoRService;


/**
 * 报卡类型关联诊断AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IReportcardtypediagdoCudService.class,IReportcardtypediagdoRService.class}, binding=Binding.JSONRPC)
public class ReportcardtypediagdoCrudServiceImpl extends BaseDOService<ReportCardTypeDiagDO> implements IReportcardtypediagdoCudService,IReportcardtypediagdoRService {
    public ReportcardtypediagdoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ReportCardTypeDiagDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
    }
}
