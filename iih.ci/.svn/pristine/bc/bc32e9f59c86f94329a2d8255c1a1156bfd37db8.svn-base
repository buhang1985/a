package iih.ci.mrqc.randomcheck.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrqc.randomcheck.d.desc.CiMrQcRandomRecordItmDODesc;
import iih.ci.mrqc.randomcheck.d.CiMrQcRandomRecordItmDO;
import iih.ci.mrqc.randomcheck.i.ICiMrQcRandomRecordItmDOCudService;
import iih.ci.mrqc.randomcheck.i.ICiMrQcRandomRecordItmDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 门诊病历抽查主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiMrQcRandomRecordItmDOCudService.class,ICiMrQcRandomRecordItmDORService.class}, binding=Binding.JSONRPC)
public class CiMrQcRandomRecordItmDOCrudServiceImpl extends BaseDOService<CiMrQcRandomRecordItmDO> implements ICiMrQcRandomRecordItmDOCudService,ICiMrQcRandomRecordItmDORService {

    public CiMrQcRandomRecordItmDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrQcRandomRecordItmDODesc.class),IAppFwTempTbl.tmp_iaw_14.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

