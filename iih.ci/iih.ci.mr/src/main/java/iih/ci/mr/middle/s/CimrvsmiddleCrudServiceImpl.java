package iih.ci.mr.middle.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mr.middle.d.desc.CiMrVSMiddleDODesc;
import iih.ci.mr.middle.d.CiMrVSMiddleDO;
import iih.ci.mr.middle.i.ICimrvsmiddleCudService;
import iih.ci.mr.middle.i.ICimrvsmiddleRService;


/**
 * 生命体征中间表AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimrvsmiddleCudService.class,ICimrvsmiddleRService.class}, binding=Binding.JSONRPC)
public class CimrvsmiddleCrudServiceImpl extends BaseDOService<CiMrVSMiddleDO> implements ICimrvsmiddleCudService,ICimrvsmiddleRService {
    public CimrvsmiddleCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrVSMiddleDODesc.class),IAppFwTempTbl.tmp_iaw_19.name()); 
    }
}
