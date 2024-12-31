package iih.ci.mr.cimrsfmsec.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mr.cimrsfmsec.d.desc.CimrsfmsecitmDODesc;
import iih.ci.mr.cimrsfmsec.d.CimrsfmsecitmDO;
import iih.ci.mr.cimrsfmsec.i.ICimrsfmsecitmDOCudService;
import iih.ci.mr.cimrsfmsec.i.ICimrsfmsecitmDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 医疗记录智能表单段落主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICimrsfmsecitmDOCudService.class,ICimrsfmsecitmDORService.class}, binding=Binding.JSONRPC)
public class CimrsfmsecitmDOCrudServiceImpl extends BaseDOService<CimrsfmsecitmDO> implements ICimrsfmsecitmDOCudService,ICimrsfmsecitmDORService {

    public CimrsfmsecitmDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CimrsfmsecitmDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

