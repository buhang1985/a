package iih.bl.comm.util;

import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.PersistMgr;
import xap.sys.jdbc.kernel.PersistSession;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 回写医嘱记账状态工具
 * @author ly 2018/11/29
 *
 */
public class BlUpdateOrChargeStateUtil {

	/*原逻辑 --> UpdateOrdMpInfoBP
	  1、医嘱-记账状态
	  1）医嘱下所有SRV都是【未记账】状态时，医嘱为【未记账】
	  2）医嘱下所有SRV都是【已退费】状态时，医嘱为【已退费】
	  3）医嘱下只要有一条SRV为【已记账】状态时，医嘱为【已记账】
	  2、srv -记账状态
	  1）SRV未记账时，记账状态为【未记账】医嘱保存处理
	  2）SRV已记账后，记账状态为【已记账】
	  3）SRV全部退费后，记账状态为【已退费】
	  */
	
	/**
	 * 更新记账状态
	 * @param orsrvIds
	 * @param dtlastCg
	 * @param feereversetp
	 * @throws BizException
	 */
	public static void  updateChargeStatus(String[] orsrvIds, FDateTime dtlastCg, Integer feereversetp) throws BizException{
		
		DAFacade daf = new DAFacade();
		String sql = "select distinct id_or from ci_or_srv where " + SqlUtils.getInSqlByIds("id_orsrv", orsrvIds);
		@SuppressWarnings("unchecked")
		List<String> orIdList = (List<String>)daf.execQuery(sql, new ColumnListHandler());
		
		PersistMgr persist = null;
		PersistSession session = null;
		
		String updateSrvTmpl = "update ci_or_srv set id_su_bl = ?,sd_su_bl = ?,dt_last_cg = ?,eu_feereversetp = ? where ";
		String updateSrvSql = updateSrvTmpl + "id_orsrv = ? ";
		String updateSrvSql2 = updateSrvTmpl + "id_or = ? and fg_bl ='N' and sd_su_bl ='0' and fg_or ='Y' ";
		String updateOrSql = "update ci_order set id_su_bl = ?,sd_su_bl = ? where id_or = ? ";
		
		try {
			persist = (PersistMgr) PersistMgr.getInstance();
			session = persist.getPersistSession();
			
			SqlParam[] srvParams = new SqlParam[orsrvIds.length];
			SqlParam[] srvParams2 = new SqlParam[orIdList.size()];
			SqlParam[] orParams = new SqlParam[orIdList.size()];
			
			for (int i = 0; i < orsrvIds.length; i++) {
				SqlParam srvParam = new SqlParam();
				srvParam.addParam(ICiDictCodeConst.SD_SU_BL_ACCOUNT_ID);
				srvParam.addParam(ICiDictCodeConst.SD_SU_BL_ACCOUNT);
				srvParam.addParam(dtlastCg);
				srvParam.addParam(feereversetp);
				srvParam.addParam(orsrvIds[i]);
				srvParams[i] = srvParam;
			}
			session.addBatch(updateSrvSql, srvParams);
			
			for (int i = 0; i < orIdList.size(); i++) {
				
				SqlParam srvParam2 = new SqlParam();
				srvParam2.addParam(ICiDictCodeConst.SD_SU_BL_ACCOUNT_ID);
				srvParam2.addParam(ICiDictCodeConst.SD_SU_BL_ACCOUNT);
				srvParam2.addParam(dtlastCg);
				srvParam2.addParam(feereversetp);
				srvParam2.addParam(orIdList.get(i));
				srvParams2[i] = srvParam2;
				
				SqlParam orParam = new SqlParam();
				orParam.addParam(ICiDictCodeConst.SD_SU_BL_ACCOUNT_ID);
				orParam.addParam(ICiDictCodeConst.SD_SU_BL_ACCOUNT);
				orParam.addParam(orIdList.get(i));
				orParams[i] = orParam;
			}
			
			session.addBatch(updateSrvSql2, srvParams2);
			session.addBatch(updateOrSql, orParams);
			
			session.execBatch();
		} catch (Exception e) {
			throw new BizException("回写医嘱记账状态失败，失败原因为："+e.getMessage());
		} finally {
			if (session != null)
				session.closeAll();

			if (persist != null)
				persist.release();
		}
		
	}
	
	/**
	 * 更新退记账状态
	 * @param orsrvIds
	* @param dtlastCg
	 * @param feereversetp
	 * @throws BizException
	 */
	public static void  updateRefundStatus(String[] orsrvIds, FDateTime dtlastCg, Integer feereversetp) throws BizException{
		
		//TODO
	}
}
