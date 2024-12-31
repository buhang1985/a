package iih.bd.mhi.hpopepermapply.s;
import iih.bd.mhi.hpopepermapply.d.HpOpePermApplyDO;
import iih.bd.mhi.hpopepermapply.d.desc.HpOpePermApplyDODesc;
import iih.bd.mhi.hpopepermapply.i.IHpopepermapplyCudService;
import iih.bd.mhi.hpopepermapply.i.IHpopepermapplyRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 权限申请_操作员权限维护AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHpopepermapplyCudService.class,IHpopepermapplyRService.class}, binding=Binding.JSONRPC)
public class HpopepermapplyCrudServiceImpl extends BaseDOService<HpOpePermApplyDO> implements IHpopepermapplyCudService,IHpopepermapplyRService {
    public HpopepermapplyCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpOpePermApplyDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }
}
