package iih.ci.mrqc.mrconnotationqc.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.ci.mrqc.mrconnotationqc.d.MrConnotationQcDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.ci.mrqc.mrconnotationqc.d.desc.MrConnotationQcDODesc;
import iih.ci.mrqc.mrconnotationqc.d.MrconnotationqcAggDO;
import iih.ci.mrqc.mrconnotationqc.i.IMrconnotationqcCudService;
import iih.ci.mrqc.mrconnotationqc.i.IMrconnotationqcRService;


/**
 * mrconnotationqcdoAggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMrconnotationqcCudService.class,IMrconnotationqcRService.class}, binding=Binding.JSONRPC)
public class MrconnotationqcCrudServiceImpl extends BaseAggService<MrconnotationqcAggDO,MrConnotationQcDO> implements IMrconnotationqcCudService,IMrconnotationqcRService {
    public MrconnotationqcCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrConnotationQcDODesc.class),IAppFwTempTbl.tmp_iaw_29.name()); 
    }
}
