package iih.bd.fc.enstate.s;
import iih.bd.fc.enstate.d.BdEnStateDepDO;
import iih.bd.fc.enstate.d.desc.BdEnStateDepDODesc;
import iih.bd.fc.enstate.i.IEnstatedepCudService;
import iih.bd.fc.enstate.i.IEnstatedepRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 科室就诊状况AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnstatedepCudService.class,IEnstatedepRService.class}, binding=Binding.JSONRPC)
public class EnstatedepCrudServiceImpl extends BaseDOService<BdEnStateDepDO> implements IEnstatedepCudService,IEnstatedepRService {

    public EnstatedepCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdEnStateDepDODesc.class),IAppFwTempTbl.tmp_iaw_08.name()); 
    }
}

