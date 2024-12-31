package iih.mi.biz.hpsignin.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.biz.hpsignin.d.desc.MiHpSignInDODesc;
import iih.mi.biz.hpsignin.d.MiHpSignInDO;
import iih.mi.biz.hpsignin.i.IHpsigninCudService;
import iih.mi.biz.hpsignin.i.IHpsigninRService;


/**
 * 医保签到AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHpsigninCudService.class,IHpsigninRService.class}, binding=Binding.JSONRPC)
public class HpsigninCrudServiceImpl extends BaseDOService<MiHpSignInDO> implements IHpsigninCudService,IHpsigninRService {
    public HpsigninCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MiHpSignInDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }
}
