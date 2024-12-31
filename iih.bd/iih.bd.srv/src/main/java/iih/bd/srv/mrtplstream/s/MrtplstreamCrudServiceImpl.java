package iih.bd.srv.mrtplstream.s;
import iih.bd.srv.mrtplstream.d.EmrTplStreamDO;
import iih.bd.srv.mrtplstream.d.desc.EmrTplStreamDODesc;
import iih.bd.srv.mrtplstream.i.IMrtplstreamCudService;
import iih.bd.srv.mrtplstream.i.IMrtplstreamRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医疗记录模板流数据AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMrtplstreamCudService.class,IMrtplstreamRService.class}, binding=Binding.JSONRPC)
public class MrtplstreamCrudServiceImpl extends BaseDOService<EmrTplStreamDO> implements IMrtplstreamCudService,IMrtplstreamRService {

    public MrtplstreamCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EmrTplStreamDODesc.class),IAppFwTempTbl.tmp_iaw_08.name()); 
    }
}

