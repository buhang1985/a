package iih.bl.hp.hpentrefunddetail.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.hp.hpentrefunddetail.d.desc.HpEntRefundDetailDODesc;
import iih.bl.hp.hpentrefunddetail.d.HpEntRefundDetailDO;
import iih.bl.hp.hpentrefunddetail.i.IHpentrefunddetailCudService;
import iih.bl.hp.hpentrefunddetail.i.IHpentrefunddetailRService;


/**
 * 医保半退明细记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHpentrefunddetailCudService.class,IHpentrefunddetailRService.class}, binding=Binding.JSONRPC)
public class HpentrefunddetailCrudServiceImpl extends BaseDOService<HpEntRefundDetailDO> implements IHpentrefunddetailCudService,IHpentrefunddetailRService {
    public HpentrefunddetailCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpEntRefundDetailDODesc.class),IAppFwTempTbl.tmp_iaw_29.name()); 
    }
}
