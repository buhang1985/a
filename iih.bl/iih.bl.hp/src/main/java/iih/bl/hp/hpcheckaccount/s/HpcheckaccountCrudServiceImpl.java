package iih.bl.hp.hpcheckaccount.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.hp.hpcheckaccount.d.desc.BlHpCheckAccountDODesc;
import iih.bl.hp.hpcheckaccount.d.BlHpCheckAccountDO;
import iih.bl.hp.hpcheckaccount.i.IHpcheckaccountCudService;
import iih.bl.hp.hpcheckaccount.i.IHpcheckaccountRService;


/**
 * 医保医疗费统计查询对账日志AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHpcheckaccountCudService.class,IHpcheckaccountRService.class}, binding=Binding.JSONRPC)
public class HpcheckaccountCrudServiceImpl extends BaseDOService<BlHpCheckAccountDO> implements IHpcheckaccountCudService,IHpcheckaccountRService {
    public HpcheckaccountCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlHpCheckAccountDODesc.class),IAppFwTempTbl.tmp_iaw_28.name()); 
    }
}
