package iih.pmp.pay.thirdpartyconfig.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pmp.pay.thirdpartyconfig.d.desc.ThirdPartyConfigDODesc;
import iih.pmp.pay.thirdpartyconfig.d.ThirdPartyConfigDO;
import iih.pmp.pay.thirdpartyconfig.i.IThirdpartyconfigCudService;
import iih.pmp.pay.thirdpartyconfig.i.IThirdpartyconfigRService;


/**
 * 第三方对接配置AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IThirdpartyconfigCudService.class,IThirdpartyconfigRService.class}, binding=Binding.JSONRPC)
public class ThirdpartyconfigCrudServiceImpl extends BaseDOService<ThirdPartyConfigDO> implements IThirdpartyconfigCudService,IThirdpartyconfigRService {
    public ThirdpartyconfigCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ThirdPartyConfigDODesc.class),IAppFwTempTbl.tmp_iaw_17.name()); 
    }
}
