package iih.ci.mrqc.qcreport.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrqc.qcreport.d.desc.QcReportGrpDODesc;
import iih.ci.mrqc.qcreport.d.QcReportGrpDO;
import iih.ci.mrqc.qcreport.i.IQcreportgrpCudService;
import iih.ci.mrqc.qcreport.i.IQcreportgrpRService;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IQcreportgrpCudService.class,IQcreportgrpRService.class}, binding=Binding.JSONRPC)
public class QcreportgrpCrudServiceImpl extends BaseDOService<QcReportGrpDO> implements IQcreportgrpCudService,IQcreportgrpRService {

    public QcreportgrpCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(QcReportGrpDODesc.class),IAppFwTempTbl.tmp_iaw_23.name()); 
    }
}

