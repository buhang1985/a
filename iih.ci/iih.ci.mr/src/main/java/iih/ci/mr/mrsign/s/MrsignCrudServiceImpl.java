package iih.ci.mr.mrsign.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.ci.mr.mrsign.d.CiMrSignDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.ci.mr.mrsign.d.desc.CiMrSignDODesc;
import iih.ci.mr.mrsign.d.MrsignAggDO;
import iih.ci.mr.mrsign.i.IMrsignCudService;
import iih.ci.mr.mrsign.i.IMrsignRService;


/**
 * 临床医疗记录签名AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMrsignCudService.class,IMrsignRService.class}, binding=Binding.JSONRPC)
public class MrsignCrudServiceImpl extends BaseAggService<MrsignAggDO,CiMrSignDO> implements IMrsignCudService,IMrsignRService {
    public MrsignCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrSignDODesc.class),IAppFwTempTbl.tmp_iaw_14.name()); 
    }
}
