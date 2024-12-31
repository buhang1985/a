package iih.ci.mr.cimracrecords.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mr.cimracrecords.d.desc.CiMrACFetusDesc;
import iih.ci.mr.cimracrecords.d.CiMrACFetus;
import iih.ci.mr.cimracrecords.i.ICiMrACFetusCudService;
import iih.ci.mr.cimracrecords.i.ICiMrACFetusRService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 产程数据记录主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiMrACFetusCudService.class,ICiMrACFetusRService.class}, binding=Binding.JSONRPC)
public class CiMrACFetusCrudServiceImpl extends BaseDOService<CiMrACFetus> implements ICiMrACFetusCudService,ICiMrACFetusRService {

    public CiMrACFetusCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrACFetusDesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

