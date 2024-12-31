package iih.bd.mhi.hpfeeca.s;
import iih.bd.mhi.hpfeeca.d.HpFeecaDO;
import iih.bd.mhi.hpfeeca.d.desc.HpFeecaDODesc;
import iih.bd.mhi.hpfeeca.i.IHpfeecaCudService;
import iih.bd.mhi.hpfeeca.i.IHpfeecaRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医保计划_费用分类字典AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHpfeecaCudService.class,IHpfeecaRService.class}, binding=Binding.JSONRPC)
public class HpfeecaCrudServiceImpl extends BaseDOService<HpFeecaDO> implements IHpfeecaCudService,IHpfeecaRService {
    public HpfeecaCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpFeecaDODesc.class),IAppFwTempTbl.tmp_iaw_16.name()); 
    }
}
