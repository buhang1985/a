package iih.mi.biz.insureprop.lyneusoftoep.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.biz.insureprop.lyneusoftoep.d.desc.MiPropArOepLYNeusoftDODesc;
import iih.mi.biz.insureprop.lyneusoftoep.d.MiPropArOepLYNeusoftDO;
import iih.mi.biz.insureprop.lyneusoftoep.i.IMiproparoeplyneusoftoepCudService;
import iih.mi.biz.insureprop.lyneusoftoep.i.IMiproparoeplyneusoftoepRService;


/**
 * 临沂医保门诊分摊表AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMiproparoeplyneusoftoepCudService.class,IMiproparoeplyneusoftoepRService.class}, binding=Binding.JSONRPC)
public class MiproparoeplyneusoftoepCrudServiceImpl extends BaseDOService<MiPropArOepLYNeusoftDO> implements IMiproparoeplyneusoftoepCudService,IMiproparoeplyneusoftoepRService {
    public MiproparoeplyneusoftoepCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MiPropArOepLYNeusoftDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
}
