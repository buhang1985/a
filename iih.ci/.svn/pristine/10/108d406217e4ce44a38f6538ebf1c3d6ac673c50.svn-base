package iih.ci.ord.s.bp;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.i.ICiOrdCustomSysParamConst;
import iih.ci.ord.i.ICiOrdLogService;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.log.logging.Level;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.kernel.PersistMgr;
import xap.sys.jdbc.kernel.PersistSession;
import xap.sys.jdbc.kernel.exception.DbException;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 更新医嘱属性
 * 
 * @author HUMS
 *
 */
public class UpdateCiOrdePropertyBP {

	/**
	 * 更新医嘱是否打印到医嘱单标识
	 * 
	 * @return
	 * @throws BizException
	 */
	public FBoolean updateCiOrderFgPrn(String id_or, FBoolean fg_prn) throws BizException {

		PersistMgr persist = null;
		PersistSession session = null;
		try {
			ICiorderMDORService ciorderRService = CiOrdAppUtils.getCiorderMDORService();
			CiOrderDO ciorder = ciorderRService.findById(id_or);
			String sd_su_or = ciorder.getSd_su_or();
			FBoolean fg_canc_prnt = FBoolean.TRUE;
			try {
				// 医嘱列表是否可全部取消打印
			   fg_canc_prnt = ParamsetQryUtil.getParaBoolean(CiOrdAppUtils.getEnvContext().getOrgId(),
						ICiOrdCustomSysParamConst.TL_PARAM_PRNT);
			} catch (Exception ex) {

			}
			if (!ICiDictCodeConst.SD_SU_CANCEL.equals(sd_su_or) && !ICiDictCodeConst.SD_SU_CHECKCANCEL.equals(sd_su_or)&& !fg_canc_prnt.booleanValue()) {

				throw new BizException("仅作废医嘱支持该操作！");
			}

			persist = (PersistMgr) PersistMgr.getInstance();
			session = persist.getPersistSession();
			String sql = "update ci_order  set fg_prn = '" + fg_prn + "' where id_or =  '" + id_or + "'";
			session.addBatch(sql);
			int updateRowCnt = session.execBatch();
			if (updateRowCnt > 0) {
				ICiOrdLogService logService = ServiceFinder.find(ICiOrdLogService.class);
				logService.log("取消医嘱打印医生：" + Context.get().getUserId() + ","+"医嘱："+ id_or, Level.INFO);
				return FBoolean.TRUE;
			}
			return FBoolean.FALSE;

		} catch (DbException e) {
			Logger.error(e.getMessage(), e);
			throw new BizException(e.getMessage());

		} finally {
			if (session != null)
				session.closeAll();
			if (persist != null)
				persist.release();
		}
	}
}
