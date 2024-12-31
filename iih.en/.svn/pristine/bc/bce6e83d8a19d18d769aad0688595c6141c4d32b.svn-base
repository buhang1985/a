package iih.en.pv.enres.s;
import iih.en.pv.enres.d.EnExtDO;
import iih.en.pv.enres.d.desc.EnExtDODesc;
import iih.en.pv.enres.i.IEnextCudService;
import iih.en.pv.enres.i.IEnextRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 患者就诊_扩展AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnextCudService.class,IEnextRService.class}, binding=Binding.JSONRPC)
public class EnextCrudServiceImpl extends BaseDOService<EnExtDO> implements IEnextCudService,IEnextRService {
    public EnextCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnExtDODesc.class),IAppFwTempTbl.tmp_iaw_08.name()); 
    }
}
