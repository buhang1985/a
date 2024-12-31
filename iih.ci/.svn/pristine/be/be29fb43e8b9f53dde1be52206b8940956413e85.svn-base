package iih.ci.mr.cimrvt.s;
import iih.ci.mr.cimrvt.d.CiMrVtDO;
import iih.ci.mr.cimrvt.d.CimrvtAggDO;
import iih.ci.mr.cimrvt.d.desc.CiMrVtDODesc;
import iih.ci.mr.cimrvt.i.ICimrvtCudService;
import iih.ci.mr.cimrvt.i.ICimrvtRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 临床生命体征测量AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimrvtCudService.class,ICimrvtRService.class}, binding=Binding.JSONRPC)
public class CimrvtCrudServiceImpl extends BaseAggService<CimrvtAggDO,CiMrVtDO> implements ICimrvtCudService,ICimrvtRService {

    public CimrvtCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrVtDODesc.class),IAppFwTempTbl.tmp_iaw_17.name()); 
    }
}

