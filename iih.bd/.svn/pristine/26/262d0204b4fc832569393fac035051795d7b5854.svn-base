package iih.bd.pp.bdhpspec.s;
import iih.bd.pp.bdhpspec.d.BdHpSpecDO;
import iih.bd.pp.bdhpspec.d.desc.BdHpSpecDODesc;
import iih.bd.pp.bdhpspec.i.IBdhpspecMDOCudService;
import iih.bd.pp.bdhpspec.i.IBdhpspecMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 医保特殊病主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBdhpspecMDOCudService.class,IBdhpspecMDORService.class}, binding=Binding.JSONRPC)
public class BdhpspecMDOCrudServiceImpl extends BaseDOService<BdHpSpecDO> implements IBdhpspecMDOCudService,IBdhpspecMDORService {

    public BdhpspecMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdHpSpecDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

