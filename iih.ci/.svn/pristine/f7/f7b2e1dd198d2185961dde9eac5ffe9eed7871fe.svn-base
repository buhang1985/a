package iih.ci.mr.cimrsource.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mr.cimrsource.d.desc.CiMrSourceDODesc;
import iih.ci.mr.cimrsource.d.CiMrSourceDO;
import iih.ci.mr.cimrsource.i.ICimrsourceCudService;
import iih.ci.mr.cimrsource.i.ICimrsourceRService;


/**
 * 病历源内容AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimrsourceCudService.class,ICimrsourceRService.class}, binding=Binding.JSONRPC)
public class CimrsourceCrudServiceImpl extends BaseDOService<CiMrSourceDO> implements ICimrsourceCudService,ICimrsourceRService {
    public CimrsourceCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrSourceDODesc.class),IAppFwTempTbl.tmp_iaw_03.name()); 
    }
}
