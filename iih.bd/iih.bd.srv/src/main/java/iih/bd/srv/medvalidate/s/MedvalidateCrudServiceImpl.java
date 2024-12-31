package iih.bd.srv.medvalidate.s;
import iih.bd.srv.medvalidate.d.BDErrorInfoDO;
import iih.bd.srv.medvalidate.d.MedvalidateAggDO;
import iih.bd.srv.medvalidate.d.desc.BDErrorInfoDODesc;
import iih.bd.srv.medvalidate.i.IMedvalidateCudService;
import iih.bd.srv.medvalidate.i.IMedvalidateRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 基础数据服务校验AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMedvalidateCudService.class,IMedvalidateRService.class}, binding=Binding.JSONRPC)
public class MedvalidateCrudServiceImpl extends BaseAggService<MedvalidateAggDO,BDErrorInfoDO> implements IMedvalidateCudService,IMedvalidateRService {
    public MedvalidateCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BDErrorInfoDODesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }
}
