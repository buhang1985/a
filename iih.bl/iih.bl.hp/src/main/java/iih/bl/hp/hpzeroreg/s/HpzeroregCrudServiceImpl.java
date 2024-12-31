package iih.bl.hp.hpzeroreg.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.hp.hpzeroreg.d.desc.HpZeroRegDODesc;
import iih.bl.hp.hpzeroreg.d.HpZeroRegDO;
import iih.bl.hp.hpzeroreg.i.IHpzeroregCudService;
import iih.bl.hp.hpzeroreg.i.IHpzeroregRService;


/**
 * 医保零挂DOAggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHpzeroregCudService.class,IHpzeroregRService.class}, binding=Binding.JSONRPC)
public class HpzeroregCrudServiceImpl extends BaseDOService<HpZeroRegDO> implements IHpzeroregCudService,IHpzeroregRService {
    public HpzeroregCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpZeroRegDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
}
