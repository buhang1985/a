package iih.bd.srv.mrtplsec.s;
import iih.bd.srv.mrtplsec.d.MrTplSegFsDO;
import iih.bd.srv.mrtplsec.d.desc.MrTplSegFsDODesc;
import iih.bd.srv.mrtplsec.i.IMrtplsecCudService;
import iih.bd.srv.mrtplsec.i.IMrtplsecRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医疗记录模板片段流数据AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMrtplsecCudService.class,IMrtplsecRService.class}, binding=Binding.JSONRPC)
public class MrtplsecCrudServiceImpl extends BaseDOService<MrTplSegFsDO> implements IMrtplsecCudService,IMrtplsecRService {

    public MrtplsecCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrTplSegFsDODesc.class),IAppFwTempTbl.tmp_iaw_01.name()); 
    }
}

