package iih.ci.mr.cimr.s;
import java.util.List;

import iih.bd.bc.udi.pub.SuMrConst;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.d.desc.CiMrDODesc;
import iih.ci.mr.cimr.i.ICiemrCudService;
import iih.ci.mr.cimr.i.ICiemrRService;
import iih.ci.mr.mraudit.i.IMrAuitExt;
import iih.ci.mr.mraudit.s.IMrAuitExtImpl;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.jdbc.facade.DAFacade;
import xap.wf.af.server.WfFormInfoCtx;


/**
 * 临床医疗记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICiemrCudService.class,ICiemrRService.class}, binding=Binding.JSONRPC)
public class CiemrCrudServiceImpl extends BaseDOService<CiMrDO> implements ICiemrCudService,ICiemrRService {
    public CiemrCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
    
    @Override
	public boolean deleteAndStop(String userid, WfFormInfoCtx formInfo)
			throws BizException {
		// TODO Auto-generated method stub
		boolean b = false;
		try {
			CiMrDO ciMrDo = (CiMrDO) formInfo;
			
			if(ciMrDo.getSd_su_mr().equals(SuMrConst.SD_SUMR_RETRIEVE) || ciMrDo.getSd_su_mr().equals(SuMrConst.SD_SUMR_REJECT)){
				IMrAuitExt imr = new IMrAuitExtImpl();
				imr.stopProcess(userid, formInfo);
			}
			
			/*String sql = "update ci_mr mr set mr.delete_reasion = '"+ciMrDo.getDelete_reasion()+"',mr.ds = 1 where mr.id_mr = '"+ciMrDo.getId_mr()+"'";
			DAFacade daf = new DAFacade();
			daf.execUpdate(sql);*/
			this.logicDelete(ciMrDo);
			
			b = true;
		} catch (BizException e) {
			e.printStackTrace();
//			throw new WfServiceException("单据出错，审批流中止异常");
		}
		return b;
	}

//	@Override
//	public boolean deleteAndStop(String userid, WfFormInfoCtx formInfo) {
//		boolean b = false;
//		try {
//			CiMrDO ciMrDo = (CiMrDO) formInfo;
//			
//			if(ciMrDo.getSd_su_mr().equals(SuMrConst.SD_SUMR_RETRIEVE) || ciMrDo.getSd_su_mr().equals(SuMrConst.SD_SUMR_REJECT)){
//				IMrAuitExt imr = new IMrAuitExtImpl();
//				imr.stopProcess(userid, formInfo);
//			}
//			this.logicDelete(ciMrDo);
//			
//			b = true;
//		} catch (BizException e) {
//			e.printStackTrace();
////			throw new WfServiceException("单据出错，审批流中止异常");
//		}
//		return b;
//	}
    
}
