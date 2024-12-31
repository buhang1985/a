package iih.ci.mrqc.cimrqcrandomrule.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrqc.cimrqcrandomrule.d.desc.CiMrQcRandomRuleDODesc;
import iih.ci.mrqc.cimrqcrandomrule.d.CiMrQcRandomRuleDO;
import iih.ci.mrqc.cimrqcrandomrule.i.ICimrqcrandomruleCudService;
import iih.ci.mrqc.cimrqcrandomrule.i.ICimrqcrandomruleRService;


/**
 * 质控抽查设置规则AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimrqcrandomruleCudService.class,ICimrqcrandomruleRService.class}, binding=Binding.JSONRPC)
public class CimrqcrandomruleCrudServiceImpl extends BaseDOService<CiMrQcRandomRuleDO> implements ICimrqcrandomruleCudService,ICimrqcrandomruleRService {
    public CimrqcrandomruleCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrQcRandomRuleDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }
}
