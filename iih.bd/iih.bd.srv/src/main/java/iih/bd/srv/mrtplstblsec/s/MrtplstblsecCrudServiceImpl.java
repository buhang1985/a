package iih.bd.srv.mrtplstblsec.s;
import iih.bd.srv.mrtplstblsec.d.MrTplSTblSecDO;
import iih.bd.srv.mrtplstblsec.d.MrtplstblsecAggDO;
import iih.bd.srv.mrtplstblsec.d.desc.MrTplSTblSecDODesc;
import iih.bd.srv.mrtplstblsec.i.IMrtplstblsecCudService;
import iih.bd.srv.mrtplstblsec.i.IMrtplstblsecRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医疗记录模板智能表格段落AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMrtplstblsecCudService.class,IMrtplstblsecRService.class}, binding=Binding.JSONRPC)
public class MrtplstblsecCrudServiceImpl extends BaseAggService<MrtplstblsecAggDO,MrTplSTblSecDO> implements IMrtplstblsecCudService,IMrtplstblsecRService {

    public MrtplstblsecCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrTplSTblSecDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
    }
}

