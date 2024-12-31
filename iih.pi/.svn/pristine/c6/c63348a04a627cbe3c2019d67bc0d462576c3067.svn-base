package iih.pi.overview.overview.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.overview.overview.d.desc.PiPatDrugDODesc;
import iih.pi.overview.overview.d.PiPatDrugDO;
import iih.pi.overview.overview.i.IPiPatDrugDOCudService;
import iih.pi.overview.overview.i.IPiPatDrugDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 患者临床摘要主实体CRUD服务实现
 */
@Service(serviceInterfaces={IPiPatDrugDOCudService.class,IPiPatDrugDORService.class}, binding=Binding.JSONRPC)
public class PiPatDrugDOCrudServiceImpl extends BaseDOService<PiPatDrugDO> implements IPiPatDrugDOCudService,IPiPatDrugDORService {

    public PiPatDrugDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatDrugDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

