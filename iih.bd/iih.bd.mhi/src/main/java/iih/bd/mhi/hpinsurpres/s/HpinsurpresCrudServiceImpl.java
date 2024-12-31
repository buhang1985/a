package iih.bd.mhi.hpinsurpres.s;
import iih.bd.mhi.hpinsurpres.d.HpInsurPresDO;
import iih.bd.mhi.hpinsurpres.d.desc.HpInsurPresDODesc;
import iih.bd.mhi.hpinsurpres.i.IHpinsurpresCudService;
import iih.bd.mhi.hpinsurpres.i.IHpinsurpresRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医保计划医保处方权AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHpinsurpresCudService.class,IHpinsurpresRService.class}, binding=Binding.JSONRPC)
public class HpinsurpresCrudServiceImpl extends BaseDOService<HpInsurPresDO> implements IHpinsurpresCudService,IHpinsurpresRService {
    public HpinsurpresCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpInsurPresDODesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }
}
