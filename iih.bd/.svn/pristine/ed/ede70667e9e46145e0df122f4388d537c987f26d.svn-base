package iih.bd.srv.reportcardtplstream.s;
import iih.bd.srv.reportcardtplstream.d.Reportcardtplstream;
import iih.bd.srv.reportcardtplstream.d.desc.ReportcardtplstreamDesc;
import iih.bd.srv.reportcardtplstream.i.IReportcardtplstreamCudService;
import iih.bd.srv.reportcardtplstream.i.IReportcardtplstreamRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 报卡模板流AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IReportcardtplstreamCudService.class,IReportcardtplstreamRService.class}, binding=Binding.JSONRPC)
public class ReportcardtplstreamCrudServiceImpl extends BaseDOService<Reportcardtplstream> implements IReportcardtplstreamCudService,IReportcardtplstreamRService {
    public ReportcardtplstreamCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ReportcardtplstreamDesc.class),IAppFwTempTbl.tmp_iaw_02.name()); 
    }
}
