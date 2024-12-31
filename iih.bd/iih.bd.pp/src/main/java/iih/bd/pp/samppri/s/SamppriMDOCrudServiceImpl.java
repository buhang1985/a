package iih.bd.pp.samppri.s;
import iih.bd.pp.samppri.d.SampPriDO;
import iih.bd.pp.samppri.d.desc.SampPriDODesc;
import iih.bd.pp.samppri.i.ISamppriMDOCudService;
import iih.bd.pp.samppri.i.ISamppriMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 标本费用对照主实体CRUD服务实现
 */
@Service(serviceInterfaces={ISamppriMDOCudService.class,ISamppriMDORService.class}, binding=Binding.JSONRPC)
public class SamppriMDOCrudServiceImpl extends BaseDOService<SampPriDO> implements ISamppriMDOCudService,ISamppriMDORService {

    public SamppriMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SampPriDODesc.class),IAppFwTempTbl.tmp_iaw_09.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

