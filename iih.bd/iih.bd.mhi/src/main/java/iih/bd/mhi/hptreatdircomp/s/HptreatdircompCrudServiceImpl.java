package iih.bd.mhi.hptreatdircomp.s;
import iih.bd.mhi.hptreatdircomp.d.HpTreatDirCompDO;
import iih.bd.mhi.hptreatdircomp.d.desc.HpTreatDirCompDODesc;
import iih.bd.mhi.hptreatdircomp.i.IHptreatdircompCudService;
import iih.bd.mhi.hptreatdircomp.i.IHptreatdircompRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医保产品_诊疗对照AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHptreatdircompCudService.class,IHptreatdircompRService.class}, binding=Binding.JSONRPC)
public class HptreatdircompCrudServiceImpl extends BaseDOService<HpTreatDirCompDO> implements IHptreatdircompCudService,IHptreatdircompRService {
    public HptreatdircompCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpTreatDirCompDODesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
    }
}
