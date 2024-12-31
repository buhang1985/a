package iih.bd.pp.bdpripkg.s;
import iih.bd.pp.bdpripkg.d.BdPriPkgDO;
import iih.bd.pp.bdpripkg.d.desc.BdPriPkgDODesc;
import iih.bd.pp.bdpripkg.i.IBdpripkgMDOCudService;
import iih.bd.pp.bdpripkg.i.IBdpripkgMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 组件主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBdpripkgMDOCudService.class,IBdpripkgMDORService.class}, binding=Binding.JSONRPC)
public class BdpripkgMDOCrudServiceImpl extends BaseDOService<BdPriPkgDO> implements IBdpripkgMDOCudService,IBdpripkgMDORService {

    public BdpripkgMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdPriPkgDODesc.class),IAppFwTempTbl.tmp_iaw_22.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

