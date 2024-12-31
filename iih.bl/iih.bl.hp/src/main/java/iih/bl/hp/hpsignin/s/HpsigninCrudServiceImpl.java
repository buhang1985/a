package iih.bl.hp.hpsignin.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.hp.hpsignin.d.desc.HpSignInDODesc;
import iih.bl.hp.hpsignin.d.HpSignInDO;
import iih.bl.hp.hpsignin.i.IHpsigninCudService;
import iih.bl.hp.hpsignin.i.IHpsigninRService;


/**
 * 医保签到AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHpsigninCudService.class,IHpsigninRService.class}, binding=Binding.JSONRPC)
public class HpsigninCrudServiceImpl extends BaseDOService<HpSignInDO> implements IHpsigninCudService,IHpsigninRService {
    public HpsigninCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpSignInDODesc.class),IAppFwTempTbl.tmp_iaw_21.name()); 
    }
}
