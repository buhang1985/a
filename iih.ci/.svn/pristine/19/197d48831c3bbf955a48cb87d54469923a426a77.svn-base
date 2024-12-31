package iih.ci.ord.ciorder.s;
import org.apache.commons.lang.StringUtils;

import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.ciorder.i.ICiorderMDOCudService;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 临床医嘱主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiorderMDOCudService.class,ICiorderMDORService.class}, binding=Binding.JSONRPC)
public class CiorderMDOCrudServiceImpl extends BaseDOService<CiOrderDO> implements ICiorderMDOCudService,ICiorderMDORService {

    public CiorderMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiOrderDODesc.class),IAppFwTempTbl.tmp_iaw_07.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
    
	@Override
	public  CiOrderDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException {
		// 定位条件不合理的SQL  0183358: 条件不合理，需要优化  
		if(StringUtils.isEmpty(whereStr)) {
			StackTraceElement[] mStacks = Thread.currentThread().getStackTrace();
			if(mStacks != null) {
				 OrdEventLogger.info(this.getClass().getSimpleName(), "查询条件不合理的SQL医嘱入口");
				for(StackTraceElement s: mStacks){
				     OrdEventLogger.info("类名："+s.getClassName(), "方法名："+s.getMethodName()+"; 行数："+s.getLineNumber()+"; 文件名："+s.getFileName()+"; "+s);
				  }
			}
		}
		return super.find( whereStr, orderStr, isLazy);
	}
}

