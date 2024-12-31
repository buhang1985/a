package iih.ci.mrfp.di2mrfp.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrfp.di2mrfp.d.desc.CiMrfpZydiDODesc;
import iih.ci.mrfp.di2mrfp.d.CiMrfpZydiDO;
import iih.ci.mrfp.di2mrfp.i.ICiMrfpZydiDOCudService;
import iih.ci.mrfp.di2mrfp.i.ICiMrfpZydiDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 住院病案首页_诊断主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiMrfpZydiDOCudService.class,ICiMrfpZydiDORService.class}, binding=Binding.JSONRPC)
public class CiMrfpZydiDOCrudServiceImpl extends BaseDOService<CiMrfpZydiDO> implements ICiMrfpZydiDOCudService,ICiMrfpZydiDORService {

    public CiMrfpZydiDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrfpZydiDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

