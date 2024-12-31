package iih.bl.st.blpreauditip.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.bl.st.blpreauditip.d.BlPreAuditIpDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.bl.st.blpreauditip.d.desc.BlPreAuditIpDODesc;
import iih.bl.st.blpreauditip.d.BlpreauditipAggDO;
import iih.bl.st.blpreauditip.i.IBlpreauditipCudService;
import iih.bl.st.blpreauditip.i.IBlpreauditipRService;


/**
 * 医保预审核_住院AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlpreauditipCudService.class,IBlpreauditipRService.class}, binding=Binding.JSONRPC)
public class BlpreauditipCrudServiceImpl extends BaseAggService<BlpreauditipAggDO,BlPreAuditIpDO> implements IBlpreauditipCudService,IBlpreauditipRService {
    public BlpreauditipCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlPreAuditIpDODesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
    }
}
