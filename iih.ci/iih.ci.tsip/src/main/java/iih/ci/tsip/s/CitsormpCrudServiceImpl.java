package iih.ci.tsip.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.tsip.d.desc.CiTsOrMpDODesc;
import iih.ci.tsip.d.CiTsOrMpDO;
import iih.ci.tsip.i.ICitsormpCudService;
import iih.ci.tsip.i.ICitsormpRService;


/**
 * 治疗方案_医嘱生成记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICitsormpCudService.class,ICitsormpRService.class}, binding=Binding.JSONRPC)
public class CitsormpCrudServiceImpl extends BaseDOService<CiTsOrMpDO> implements ICitsormpCudService,ICitsormpRService {
    public CitsormpCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiTsOrMpDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
}
