package iih.bl.hp.hptranactoep.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.hp.hptranactoep.d.desc.HpTransactOepDODesc;
import iih.bl.hp.hptranactoep.d.HpTransactOepDO;
import iih.bl.hp.hptranactoep.i.IHptranactoepCudService;
import iih.bl.hp.hptranactoep.i.IHptranactoepRService;


/**
 * 交易记录表AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHptranactoepCudService.class,IHptranactoepRService.class}, binding=Binding.JSONRPC)
public class HptranactoepCrudServiceImpl extends BaseDOService<HpTransactOepDO> implements IHptranactoepCudService,IHptranactoepRService {
    public HptranactoepCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpTransactOepDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
    }
}
