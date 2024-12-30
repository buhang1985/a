package iih.sc.scbd.screleaserule.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.sc.scbd.screleaserule.d.desc.ScaptrlsruleDODesc;
import iih.sc.scbd.screleaserule.d.ScaptrlsruleDO;
import iih.sc.scbd.screleaserule.i.IScaptrlsruleCudService;
import iih.sc.scbd.screleaserule.i.IScaptrlsruleRService;


/**
 * 预约释放规则DOAggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IScaptrlsruleCudService.class,IScaptrlsruleRService.class}, binding=Binding.JSONRPC)
public class ScaptrlsruleCrudServiceImpl extends BaseDOService<ScaptrlsruleDO> implements IScaptrlsruleCudService,IScaptrlsruleRService {
    public ScaptrlsruleCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScaptrlsruleDODesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
    }
}
