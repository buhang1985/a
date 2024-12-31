package iih.ci.mrfp.di2mrfp.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrfp.di2mrfp.d.desc.CiMrFpXydiDODesc;
import iih.ci.mrfp.di2mrfp.d.CiMrFpXydiDO;
import iih.ci.mrfp.di2mrfp.i.ICiMrFpXydiDOCudService;
import iih.ci.mrfp.di2mrfp.i.ICiMrFpXydiDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 住院病案首页_诊断主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiMrFpXydiDOCudService.class,ICiMrFpXydiDORService.class}, binding=Binding.JSONRPC)
public class CiMrFpXydiDOCrudServiceImpl extends BaseDOService<CiMrFpXydiDO> implements ICiMrFpXydiDOCudService,ICiMrFpXydiDORService {

    public CiMrFpXydiDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrFpXydiDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

