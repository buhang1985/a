package iih.bd.mhi.hptreat.s;
import iih.bd.mhi.hptreat.d.HpTreatDO;
import iih.bd.mhi.hptreat.d.desc.HpTreatDODesc;
import iih.bd.mhi.hptreat.i.IHptreatCudService;
import iih.bd.mhi.hptreat.i.IHptreatRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医保产品_诊疗项目AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHptreatCudService.class,IHptreatRService.class}, binding=Binding.JSONRPC)
public class HptreatCrudServiceImpl extends BaseDOService<HpTreatDO> implements IHptreatCudService,IHptreatRService {
    public HptreatCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpTreatDODesc.class),IAppFwTempTbl.tmp_iaw_02.name()); 
    }
}
