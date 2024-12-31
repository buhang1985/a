package iih.ci.mr.middle.nuscore.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mr.middle.nuscore.d.desc.CiMrNuScoreMiddleDODesc;
import iih.ci.mr.middle.nuscore.d.CiMrNuScoreMiddleDO;
import iih.ci.mr.middle.nuscore.i.ICimrnuscoremiddledoCudService;
import iih.ci.mr.middle.nuscore.i.ICimrnuscoremiddledoRService;


/**
 * 评分量中间表AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimrnuscoremiddledoCudService.class,ICimrnuscoremiddledoRService.class}, binding=Binding.JSONRPC)
public class CimrnuscoremiddledoCrudServiceImpl extends BaseDOService<CiMrNuScoreMiddleDO> implements ICimrnuscoremiddledoCudService,ICimrnuscoremiddledoRService {
    public CimrnuscoremiddledoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrNuScoreMiddleDODesc.class),IAppFwTempTbl.tmp_iaw_04.name()); 
    }
}
