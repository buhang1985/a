package iih.ci.mr.middle.nmr.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mr.middle.nmr.d.desc.CiMrMiddleNmrDODesc;
import iih.ci.mr.middle.nmr.d.CiMrMiddleNmrDO;
import iih.ci.mr.middle.nmr.i.ICimrmiddlenmrdoCudService;
import iih.ci.mr.middle.nmr.i.ICimrmiddlenmrdoRService;


/**
 * 病历中间表护理文书AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimrmiddlenmrdoCudService.class,ICimrmiddlenmrdoRService.class}, binding=Binding.JSONRPC)
public class CimrmiddlenmrdoCrudServiceImpl extends BaseDOService<CiMrMiddleNmrDO> implements ICimrmiddlenmrdoCudService,ICimrmiddlenmrdoRService {
    public CimrmiddlenmrdoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrMiddleNmrDODesc.class),IAppFwTempTbl.tmp_iaw_14.name()); 
    }
}
