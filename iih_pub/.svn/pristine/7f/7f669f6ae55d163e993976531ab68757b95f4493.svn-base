package iih.ci.ord.bloodbadreaction.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.bloodbadreaction.d.desc.CiBloodAdverseReactionDODesc;
import iih.ci.ord.bloodbadreaction.d.CiBloodAdverseReactionDO;
import iih.ci.ord.bloodbadreaction.i.ICibloodadversereactionCudService;
import iih.ci.ord.bloodbadreaction.i.ICibloodadversereactionRService;


/**
 * 输血不良反应回报单AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICibloodadversereactionCudService.class,ICibloodadversereactionRService.class}, binding=Binding.JSONRPC)
public class CibloodadversereactionCrudServiceImpl extends BaseDOService<CiBloodAdverseReactionDO> implements ICibloodadversereactionCudService,ICibloodadversereactionRService {
    public CibloodadversereactionCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiBloodAdverseReactionDODesc.class),IAppFwTempTbl.tmp_iaw_03.name()); 
    }
}
