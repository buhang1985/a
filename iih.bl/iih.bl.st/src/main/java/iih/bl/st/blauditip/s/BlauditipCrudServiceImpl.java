package iih.bl.st.blauditip.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.bl.st.blauditip.d.BlAuditIp;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.bl.st.blauditip.d.desc.BlAuditIpDesc;
import iih.bl.st.blauditip.d.BlauditipAggDO;
import iih.bl.st.blauditip.i.IBlauditipCudService;
import iih.bl.st.blauditip.i.IBlauditipRService;


/**
 * 住院费用审核AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlauditipCudService.class,IBlauditipRService.class}, binding=Binding.JSONRPC)
public class BlauditipCrudServiceImpl extends BaseAggService<BlauditipAggDO,BlAuditIp> implements IBlauditipCudService,IBlauditipRService {
    public BlauditipCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlAuditIpDesc.class),IAppFwTempTbl.tmp_iaw_08.name()); 
    }
}
