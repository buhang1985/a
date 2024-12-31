package iih.mi.mibd.treatdircomp.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.mibd.treatdircomp.d.desc.TreatdircompDODesc;
import iih.mi.mibd.treatdircomp.d.TreatdircompDO;
import iih.mi.mibd.treatdircomp.i.ITreatdircompCudService;
import iih.mi.mibd.treatdircomp.i.ITreatdircompRService;


/**
 * 医保平台_诊疗对照AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ITreatdircompCudService.class,ITreatdircompRService.class}, binding=Binding.JSONRPC)
public class TreatdircompCrudServiceImpl extends BaseDOService<TreatdircompDO> implements ITreatdircompCudService,ITreatdircompRService {
    public TreatdircompCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(TreatdircompDODesc.class),IAppFwTempTbl.tmp_iaw_21.name()); 
    }

	
}
