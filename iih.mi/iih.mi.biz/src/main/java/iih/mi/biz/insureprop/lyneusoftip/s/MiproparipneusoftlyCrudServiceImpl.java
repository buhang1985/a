package iih.mi.biz.insureprop.lyneusoftip.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.biz.insureprop.lyneusoftip.d.desc.MiPropArIPLYNeusoftDODesc;
import iih.mi.biz.insureprop.lyneusoftip.d.MiPropArIPLYNeusoftDO;
import iih.mi.biz.insureprop.lyneusoftip.i.IMiproparipneusoftlyCudService;
import iih.mi.biz.insureprop.lyneusoftip.i.IMiproparipneusoftlyRService;


/**
 * 临沂住院医保分摊AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMiproparipneusoftlyCudService.class,IMiproparipneusoftlyRService.class}, binding=Binding.JSONRPC)
public class MiproparipneusoftlyCrudServiceImpl extends BaseDOService<MiPropArIPLYNeusoftDO> implements IMiproparipneusoftlyCudService,IMiproparipneusoftlyRService {
    public MiproparipneusoftlyCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MiPropArIPLYNeusoftDODesc.class),IAppFwTempTbl.tmp_iaw_04.name()); 
    }
}
