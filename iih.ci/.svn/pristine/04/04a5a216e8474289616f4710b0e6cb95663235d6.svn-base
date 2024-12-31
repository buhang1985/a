package iih.ci.tsip.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.tsip.d.desc.CiTsApLabDODesc;
import iih.ci.tsip.d.CiTsApLabDO;
import iih.ci.tsip.i.ICitsaplabCudService;
import iih.ci.tsip.i.ICitsaplabRService;


/**
 * 治疗方案检验申请AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICitsaplabCudService.class,ICitsaplabRService.class}, binding=Binding.JSONRPC)
public class CitsaplabCrudServiceImpl extends BaseDOService<CiTsApLabDO> implements ICitsaplabCudService,ICitsaplabRService {
    public CitsaplabCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiTsApLabDODesc.class),IAppFwTempTbl.tmp_iaw_14.name()); 
    }
}
