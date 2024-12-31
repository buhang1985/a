package iih.bd.srv.mrtplvs.s;
import iih.bd.srv.mrtplvs.d.BdMrtplVsItmDO;
import iih.bd.srv.mrtplvs.d.desc.BdMrtplVsItmDODesc;
import iih.bd.srv.mrtplvs.i.IBdMrtplVsItmDOCudService;
import iih.bd.srv.mrtplvs.i.IBdMrtplVsItmDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 生命体征项主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBdMrtplVsItmDOCudService.class,IBdMrtplVsItmDORService.class}, binding=Binding.JSONRPC)
public class BdMrtplVsItmDOCrudServiceImpl extends BaseDOService<BdMrtplVsItmDO> implements IBdMrtplVsItmDOCudService,IBdMrtplVsItmDORService {

    public BdMrtplVsItmDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdMrtplVsItmDODesc.class),IAppFwTempTbl.tmp_iaw_17.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

