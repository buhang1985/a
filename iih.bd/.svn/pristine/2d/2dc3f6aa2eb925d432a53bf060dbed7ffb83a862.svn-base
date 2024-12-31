package iih.bd.mhi.hpmedorglevel.s;
import iih.bd.mhi.hpmedorglevel.d.HpMedorgLevelDO;
import iih.bd.mhi.hpmedorglevel.d.desc.HpMedorgLevelDODesc;
import iih.bd.mhi.hpmedorglevel.i.IHpmedorglevelCudService;
import iih.bd.mhi.hpmedorglevel.i.IHpmedorglevelRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医保产品_医疗机构级别AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHpmedorglevelCudService.class,IHpmedorglevelRService.class}, binding=Binding.JSONRPC)
public class HpmedorglevelCrudServiceImpl extends BaseDOService<HpMedorgLevelDO> implements IHpmedorglevelCudService,IHpmedorglevelRService {
    public HpmedorglevelCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpMedorgLevelDODesc.class),IAppFwTempTbl.tmp_iaw_19.name()); 
    }
}
