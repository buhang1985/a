package iih.ci.rcm.reportcarddocfs.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.rcm.reportcarddocfs.d.desc.ReportCardDocFsDoDesc;
import iih.ci.rcm.reportcarddocfs.d.ReportCardDocFsDo;
import iih.ci.rcm.reportcarddocfs.i.IReportcarddocfsCudService;
import iih.ci.rcm.reportcarddocfs.i.IReportcarddocfsRService;


/**
 * 报卡文书流表AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IReportcarddocfsCudService.class,IReportcarddocfsRService.class}, binding=Binding.JSONRPC)
public class ReportcarddocfsCrudServiceImpl extends BaseDOService<ReportCardDocFsDo> implements IReportcarddocfsCudService,IReportcarddocfsRService {
    public ReportcarddocfsCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ReportCardDocFsDoDesc.class),IAppFwTempTbl.tmp_iaw_26.name()); 
    }
}
