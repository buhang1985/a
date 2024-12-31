package iih.mi.biz.miorderrecord.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.biz.miorderrecord.d.desc.MiOrderrecordDODesc;
import iih.mi.biz.miorderrecord.d.MiOrderrecordDO;
import iih.mi.biz.miorderrecord.i.IMiorderrecordCudService;
import iih.mi.biz.miorderrecord.i.IMiorderrecordRService;


/**
 * 医保订单记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMiorderrecordCudService.class,IMiorderrecordRService.class}, binding=Binding.JSONRPC)
public class MiorderrecordCrudServiceImpl extends BaseDOService<MiOrderrecordDO> implements IMiorderrecordCudService,IMiorderrecordRService {
    public MiorderrecordCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MiOrderrecordDODesc.class),IAppFwTempTbl.tmp_iaw_21.name()); 
    }
}
