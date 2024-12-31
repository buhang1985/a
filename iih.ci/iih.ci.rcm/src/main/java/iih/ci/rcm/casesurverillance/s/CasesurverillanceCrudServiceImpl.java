package iih.ci.rcm.casesurverillance.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.rcm.casesurverillance.d.desc.CaseSurveDODesc;
import iih.ci.rcm.casesurverillance.d.CaseSurveDO;
import iih.ci.rcm.casesurverillance.i.ICasesurverillanceCudService;
import iih.ci.rcm.casesurverillance.i.ICasesurverillanceRService;


/**
 * ICU病例监测AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICasesurverillanceCudService.class,ICasesurverillanceRService.class}, binding=Binding.JSONRPC)
public class CasesurverillanceCrudServiceImpl extends BaseDOService<CaseSurveDO> implements ICasesurverillanceCudService,ICasesurverillanceRService {
    public CasesurverillanceCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CaseSurveDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
}
