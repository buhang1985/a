package iih.bd.srv.reportcardtpl.s;
import iih.bd.srv.reportcardtpl.d.ReportCardTplDo;
import iih.bd.srv.reportcardtpl.d.desc.ReportCardTplDoDesc;
import iih.bd.srv.reportcardtpl.i.IReportcardtplCudService;
import iih.bd.srv.reportcardtpl.i.IReportcardtplRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 报卡模板AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IReportcardtplCudService.class,IReportcardtplRService.class}, binding=Binding.JSONRPC)
public class ReportcardtplCrudServiceImpl extends BaseDOService<ReportCardTplDo> implements IReportcardtplCudService,IReportcardtplRService {
    public ReportcardtplCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ReportCardTplDoDesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
}
