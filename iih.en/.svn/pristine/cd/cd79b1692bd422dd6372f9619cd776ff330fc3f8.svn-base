package iih.en.pv.enstatwardsay.s;
import iih.en.pv.enstatwardsay.d.EnStatWardDay;
import iih.en.pv.enstatwardsay.d.desc.EnStatWardDayDesc;
import iih.en.pv.enstatwardsay.i.IEnstatwardsayCudService;
import iih.en.pv.enstatwardsay.i.IEnstatwardsayRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * enstatwarddayAggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnstatwardsayCudService.class,IEnstatwardsayRService.class}, binding=Binding.JSONRPC)
public class EnstatwardsayCrudServiceImpl extends BaseDOService<EnStatWardDay> implements IEnstatwardsayCudService,IEnstatwardsayRService {
    public EnstatwardsayCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnStatWardDayDesc.class),IAppFwTempTbl.tmp_iaw_09.name()); 
    }
}
