package iih.ci.mr.cimracrecords.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mr.cimracrecords.d.desc.CiMrACUCDODesc;
import iih.ci.mr.cimracrecords.d.CiMrACUCDO;
import iih.ci.mr.cimracrecords.i.ICiMrACUCDOCudService;
import iih.ci.mr.cimracrecords.i.ICiMrACUCDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 产程数据记录主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiMrACUCDOCudService.class,ICiMrACUCDORService.class}, binding=Binding.JSONRPC)
public class CiMrACUCDOCrudServiceImpl extends BaseDOService<CiMrACUCDO> implements ICiMrACUCDOCudService,ICiMrACUCDORService {

    public CiMrACUCDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrACUCDODesc.class),IAppFwTempTbl.tmp_iaw_09.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

