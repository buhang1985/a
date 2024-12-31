package iih.ci.mr.middle.cons.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mr.middle.cons.d.desc.CiMrMiddleConsDODesc;
import iih.ci.mr.middle.cons.d.CiMrMiddleConsDO;
import iih.ci.mr.middle.cons.i.ICimrmiddleconsdoCudService;
import iih.ci.mr.middle.cons.i.ICimrmiddleconsdoRService;


/**
 * 病历中间表会诊记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimrmiddleconsdoCudService.class,ICimrmiddleconsdoRService.class}, binding=Binding.JSONRPC)
public class CimrmiddleconsdoCrudServiceImpl extends BaseDOService<CiMrMiddleConsDO> implements ICimrmiddleconsdoCudService,ICimrmiddleconsdoRService {
    public CimrmiddleconsdoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrMiddleConsDODesc.class),IAppFwTempTbl.tmp_iaw_28.name()); 
    }
}
