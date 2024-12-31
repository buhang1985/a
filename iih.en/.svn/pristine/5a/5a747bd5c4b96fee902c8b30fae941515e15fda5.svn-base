package iih.en.pv.enres.s;
import iih.en.pv.enres.d.EnMedGrpDO;
import iih.en.pv.enres.d.desc.EnMedGrpDODesc;
import iih.en.pv.enres.i.IEnmedgrpCudService;
import iih.en.pv.enres.i.IEnmedgrpRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnmedgrpCudService.class,IEnmedgrpRService.class}, binding=Binding.JSONRPC)
public class EnmedgrpCrudServiceImpl extends BaseDOService<EnMedGrpDO> implements IEnmedgrpCudService,IEnmedgrpRService {

    public EnmedgrpCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnMedGrpDODesc.class),IAppFwTempTbl.tmp_iaw_21.name()); 
    }
}

