package iih.mi.biz.mirecordstrecord.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.biz.mirecordstrecord.d.desc.MiOrderStRecordDODesc;
import iih.mi.biz.mirecordstrecord.d.MiOrderStRecordDO;
import iih.mi.biz.mirecordstrecord.i.IMirecordstrecordCudService;
import iih.mi.biz.mirecordstrecord.i.IMirecordstrecordRService;


/**
 * 医保交易结算状态关系表AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMirecordstrecordCudService.class,IMirecordstrecordRService.class}, binding=Binding.JSONRPC)
public class MirecordstrecordCrudServiceImpl extends BaseDOService<MiOrderStRecordDO> implements IMirecordstrecordCudService,IMirecordstrecordRService {
    public MirecordstrecordCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MiOrderStRecordDODesc.class),IAppFwTempTbl.tmp_iaw_04.name()); 
    }
}
