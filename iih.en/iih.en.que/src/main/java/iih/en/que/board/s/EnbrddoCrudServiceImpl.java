package iih.en.que.board.s;
import iih.en.que.board.d.EnBrdDO;
import iih.en.que.board.d.EnbrddoAggDO;
import iih.en.que.board.d.desc.EnBrdDODesc;
import iih.en.que.board.i.IEnbrddoCudService;
import iih.en.que.board.i.IEnbrddoRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 患者就诊_大屏AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnbrddoCudService.class,IEnbrddoRService.class}, binding=Binding.JSONRPC)
public class EnbrddoCrudServiceImpl extends BaseAggService<EnbrddoAggDO,EnBrdDO> implements IEnbrddoCudService,IEnbrddoRService {
    public EnbrddoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnBrdDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
}
