package iih.ci.tsip.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.ci.tsip.d.CiTsOrDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.ci.tsip.d.desc.CiTsOrDODesc;
import iih.ci.tsip.d.CitsorderAggDO;
import iih.ci.tsip.i.ICitsorderCudService;
import iih.ci.tsip.i.ICitsorderRService;


/**
 * 治疗方案医嘱AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICitsorderCudService.class,ICitsorderRService.class}, binding=Binding.JSONRPC)
public class CitsorderCrudServiceImpl extends BaseAggService<CitsorderAggDO,CiTsOrDO> implements ICitsorderCudService,ICitsorderRService {
    public CitsorderCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiTsOrDODesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
    }
}
