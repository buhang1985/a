package iih.en.pv.enmsg.s;
import iih.en.pv.enmsg.d.EnMsgDO;
import iih.en.pv.enmsg.d.desc.EnMsgDODesc;
import iih.en.pv.enmsg.i.IEnmsgCudService;
import iih.en.pv.enmsg.i.IEnmsgRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 就诊短信AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnmsgCudService.class,IEnmsgRService.class}, binding=Binding.JSONRPC)
public class EnmsgCrudServiceImpl extends BaseDOService<EnMsgDO> implements IEnmsgCudService,IEnmsgRService {
    public EnmsgCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnMsgDODesc.class),IAppFwTempTbl.tmp_iaw_23.name()); 
    }
}
