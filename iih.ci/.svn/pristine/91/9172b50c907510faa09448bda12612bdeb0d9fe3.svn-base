package iih.ci.mrfp.di2mrfp.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrfp.di2mrfp.d.desc.CiMrfpDiDODesc;
import iih.ci.mrfp.di2mrfp.d.CiMrfpDiDO;
import iih.ci.mrfp.di2mrfp.i.IDi2mrfpMDOCudService;
import iih.ci.mrfp.di2mrfp.i.IDi2mrfpMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 住院病案首页_诊断主实体CRUD服务实现
 */
@Service(serviceInterfaces={IDi2mrfpMDOCudService.class,IDi2mrfpMDORService.class}, binding=Binding.JSONRPC)
public class Di2mrfpMDOCrudServiceImpl extends BaseDOService<CiMrfpDiDO> implements IDi2mrfpMDOCudService,IDi2mrfpMDORService {

    public Di2mrfpMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrfpDiDODesc.class),IAppFwTempTbl.tmp_iaw_01.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

