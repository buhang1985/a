package iih.mi.biz.mirefundrecord.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.biz.mirefundrecord.d.desc.MiRefundRecordDODesc;
import iih.mi.biz.mirefundrecord.d.MiRefundRecordDO;
import iih.mi.biz.mirefundrecord.i.IMirefundrecordCudService;
import iih.mi.biz.mirefundrecord.i.IMirefundrecordRService;


/**
 * 医保退费记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMirefundrecordCudService.class,IMirefundrecordRService.class}, binding=Binding.JSONRPC)
public class MirefundrecordCrudServiceImpl extends BaseDOService<MiRefundRecordDO> implements IMirefundrecordCudService,IMirefundrecordRService {
    public MirefundrecordCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MiRefundRecordDODesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
    }
}
