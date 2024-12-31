package iih.ci.mr.cimrvsrec.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mr.cimrvsrec.d.desc.CiMrVsRecDODesc;
import iih.ci.mr.cimrvsrec.d.CiMrVsRecDO;
import iih.ci.mr.cimrvsrec.i.ICimrvsrecCudService;
import iih.ci.mr.cimrvsrec.i.ICimrvsrecRService;


/**
 * 出入院体征时间修改记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimrvsrecCudService.class,ICimrvsrecRService.class}, binding=Binding.JSONRPC)
public class CimrvsrecCrudServiceImpl extends BaseDOService<CiMrVsRecDO> implements ICimrvsrecCudService,ICimrvsrecRService {
    public CimrvsrecCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrVsRecDODesc.class),IAppFwTempTbl.tmp_iaw_21.name()); 
    }
}
