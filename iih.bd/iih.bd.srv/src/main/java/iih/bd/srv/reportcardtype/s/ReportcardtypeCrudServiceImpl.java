package iih.bd.srv.reportcardtype.s;
import iih.bd.srv.reportcardtype.d.EmrReportCardTypeDO;
import iih.bd.srv.reportcardtype.d.desc.EmrReportCardTypeDODesc;
import iih.bd.srv.reportcardtype.i.IReportcardtypeCudService;
import iih.bd.srv.reportcardtype.i.IReportcardtypeRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 报卡类型AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IReportcardtypeCudService.class,IReportcardtypeRService.class}, binding=Binding.JSONRPC)
public class ReportcardtypeCrudServiceImpl extends BaseDOService<EmrReportCardTypeDO> implements IReportcardtypeCudService,IReportcardtypeRService {
    public ReportcardtypeCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EmrReportCardTypeDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
    }
    
    
}
