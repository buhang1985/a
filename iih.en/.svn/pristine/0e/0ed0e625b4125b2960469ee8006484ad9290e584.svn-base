package iih.en.pv.enfee.s;
import iih.en.pv.enfee.d.EnFixedFeeDO;
import iih.en.pv.enfee.d.EnfixedfeeAggDO;
import iih.en.pv.enfee.d.desc.EnFixedFeeDODesc;
import iih.en.pv.enfee.i.IEnfixedfeeCudService;
import iih.en.pv.enfee.i.IEnfixedfeeRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 患者就诊_固定费用AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnfixedfeeCudService.class,IEnfixedfeeRService.class}, binding=Binding.JSONRPC)
public class EnfixedfeeCrudServiceImpl extends BaseAggService<EnfixedfeeAggDO,EnFixedFeeDO> implements IEnfixedfeeCudService,IEnfixedfeeRService {
    public EnfixedfeeCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnFixedFeeDODesc.class),IAppFwTempTbl.tmp_iaw_14.name()); 
    }
}
