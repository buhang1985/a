package iih.bd.mhi.hpfeecate.s;
import iih.bd.mhi.hpfeecate.d.HpFeeCateDO;
import iih.bd.mhi.hpfeecate.d.desc.HpFeeCateDODesc;
import iih.bd.mhi.hpfeecate.i.IHpfeecateCudService;
import iih.bd.mhi.hpfeecate.i.IHpfeecateRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医保产品_费用类别AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHpfeecateCudService.class,IHpfeecateRService.class}, binding=Binding.JSONRPC)
public class HpfeecateCrudServiceImpl extends BaseDOService<HpFeeCateDO> implements IHpfeecateCudService,IHpfeecateRService {
    public HpfeecateCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpFeeCateDODesc.class),IAppFwTempTbl.tmp_iaw_01.name()); 
    }
}
