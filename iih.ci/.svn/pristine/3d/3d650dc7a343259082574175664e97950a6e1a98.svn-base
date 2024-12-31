package iih.ci.mrqc.qcreport.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrqc.qcreport.d.desc.QcReportDODesc;
import iih.ci.mrqc.qcreport.d.QcReportDO;
import iih.ci.mrqc.qcreport.i.IQcreportCudService;
import iih.ci.mrqc.qcreport.i.IQcreportRService;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IQcreportCudService.class,IQcreportRService.class}, binding=Binding.JSONRPC)
public class QcreportCrudServiceImpl extends BaseDOService<QcReportDO> implements IQcreportCudService,IQcreportRService {

    public QcreportCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(QcReportDODesc.class),IAppFwTempTbl.tmp_iaw_13.name()); 
    }
}

