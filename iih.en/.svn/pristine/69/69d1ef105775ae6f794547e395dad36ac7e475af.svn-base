package iih.en.que.board.s;
import iih.en.que.board.d.EnBrdSiteDO;
import iih.en.que.board.d.desc.EnBrdSiteDODesc;
import iih.en.que.board.i.IEnbrdsitedoCudService;
import iih.en.que.board.i.IEnbrdsitedoRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 患者就诊_大屏_大屏站点AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnbrdsitedoCudService.class,IEnbrdsitedoRService.class}, binding=Binding.JSONRPC)
public class EnbrdsitedoCrudServiceImpl extends BaseDOService<EnBrdSiteDO> implements IEnbrdsitedoCudService,IEnbrdsitedoRService {
    public EnbrdsitedoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnBrdSiteDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
    }
}
