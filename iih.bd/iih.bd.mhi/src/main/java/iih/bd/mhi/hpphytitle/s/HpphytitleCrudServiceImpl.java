package iih.bd.mhi.hpphytitle.s;
import iih.bd.mhi.hpphytitle.d.HpPhyTitleDO;
import iih.bd.mhi.hpphytitle.d.desc.HpPhyTitleDODesc;
import iih.bd.mhi.hpphytitle.i.IHpphytitleCudService;
import iih.bd.mhi.hpphytitle.i.IHpphytitleRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医保计划医师职称AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHpphytitleCudService.class,IHpphytitleRService.class}, binding=Binding.JSONRPC)
public class HpphytitleCrudServiceImpl extends BaseDOService<HpPhyTitleDO> implements IHpphytitleCudService,IHpphytitleRService {
    public HpphytitleCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpPhyTitleDODesc.class),IAppFwTempTbl.tmp_iaw_16.name()); 
    }
}
