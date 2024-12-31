package iih.bd.srv.mrtplvst.s;
import iih.bd.srv.mrtplvst.d.BdMrtplVstDO;
import iih.bd.srv.mrtplvst.d.desc.BdMrtplVstDODesc;
import iih.bd.srv.mrtplvst.i.IMrtplvstMDOCudService;
import iih.bd.srv.mrtplvst.i.IMrtplvstMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 生命体征模版主实体CRUD服务实现
 */
@Service(serviceInterfaces={IMrtplvstMDOCudService.class,IMrtplvstMDORService.class}, binding=Binding.JSONRPC)
public class MrtplvstMDOCrudServiceImpl extends BaseDOService<BdMrtplVstDO> implements IMrtplvstMDOCudService,IMrtplvstMDORService {

    public MrtplvstMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdMrtplVstDODesc.class),IAppFwTempTbl.tmp_iaw_09.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

