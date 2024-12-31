package iih.bd.mhi.hpdosage.s;
import iih.bd.mhi.hpdosage.d.HpDosageDO;
import iih.bd.mhi.hpdosage.d.desc.HpDosageDODesc;
import iih.bd.mhi.hpdosage.i.IHpdosageCudService;
import iih.bd.mhi.hpdosage.i.IHpdosageRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医保剂型目录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHpdosageCudService.class,IHpdosageRService.class}, binding=Binding.JSONRPC)
public class HpdosageCrudServiceImpl extends BaseDOService<HpDosageDO> implements IHpdosageCudService,IHpdosageRService {
    public HpdosageCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpDosageDODesc.class),IAppFwTempTbl.tmp_iaw_22.name()); 
    }
}
