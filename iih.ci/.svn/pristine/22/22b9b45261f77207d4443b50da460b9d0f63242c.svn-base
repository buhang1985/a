package iih.ci.rcm.reportcarddoc.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.rcm.reportcarddoc.d.desc.ReportCardDocDoDesc;
import iih.ci.rcm.reportcarddoc.d.ReportCardDocDo;
import iih.ci.rcm.reportcarddoc.i.IReportcarddocCudService;
import iih.ci.rcm.reportcarddoc.i.IReportcarddocRService;


/**
 * 报卡文书AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IReportcarddocCudService.class,IReportcarddocRService.class}, binding=Binding.JSONRPC)
public class ReportcarddocCrudServiceImpl extends BaseDOService<ReportCardDocDo> implements IReportcarddocCudService,IReportcarddocRService {
    public ReportcarddocCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ReportCardDocDoDesc.class),IAppFwTempTbl.tmp_iaw_22.name()); 
    }
}
