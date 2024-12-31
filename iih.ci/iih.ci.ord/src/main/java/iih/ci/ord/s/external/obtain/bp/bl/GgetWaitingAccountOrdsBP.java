package iih.ci.ord.s.external.obtain.bp.bl;

import java.util.List;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bl.params.BlParams;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取待记账医嘱信息
 * @author HUMS
 *
 */
public class GgetWaitingAccountOrdsBP {

	public String[] getIdOrSrv(String idEn, String codeEntp, String idDepMp) throws BizException {
		
		SqlParam sqlParam = new SqlParam();
		DAFacade dAFacade = new DAFacade();
		String qrySql = null;
		sqlParam.addParam(idEn);
//		String qrySql = "select id_or from ci_order where ds = 0 and id_en = ?  and fg_sign = 'Y' and fg_canc= 'N' and sd_su_bl='"
//				+ ICiDictCodeConst.SD_SU_BL_NONE + "'";
		if(BlParams.BLSTOEP0063() == null){
			throw new BizException("未获取到参数BLSTOEP0063值！");
		}
		if(BlParams.BLSTOEP0063() == 1){
			 qrySql = "select id_orsrv "
			 		+ "from ci_or_srv srv left outer join ci_order ord on ord.id_or = srv.id_or "
			 		+ "where ord.ds = 0 and srv.id_en = ? and ord.fg_sign= 'Y' and ord.fg_canc = 'N' and srv.fg_bl = 'Y' "
			 		+ "and srv.sd_su_bl = '"+ICiDictCodeConst.SD_SU_BL_NONE+"'";
		}else if(BlParams.BLSTOEP0063() == 2){
			sqlParam.addParam(idDepMp);
			 qrySql = "select srv.id_orsrv "
					+ "from ci_or_srv srv  left outer join ci_order ord on ord.id_or = srv.id_or "
					+ "where ord.ds = 0 and srv.id_en = ? and ord.fg_sign = 'Y' and ord.fg_canc = 'N' and srv.fg_bl = 'Y' and srv.id_dep_mp = ? and srv.sd_srvtp not like '01%' "
					+ "and srv.sd_su_bl = '"+ICiDictCodeConst.SD_SU_BL_NONE + "'";
		}else if(BlParams.BLSTOEP0063() == 3){
			sqlParam.addParam(Context.get().getStuffId());
			qrySql = "select id_orsrv "
			 		+ "from ci_or_srv srv left outer join ci_order ord on ord.id_or = srv.id_or "
			 		+ "where ord.ds = 0 and srv.id_en = ? and ord.id_emp_sign=? and ord.ord.fg_sign= 'Y' and ord.fg_canc = 'N' and srv.fg_bl = 'Y' "
			 		+ "and srv.sd_su_bl = '"+ICiDictCodeConst.SD_SU_BL_NONE+"'";
		}else{
			throw new BizException("参数BLSTOEP0063值："+BlParams.BLSTOEP0063() +"设置错误，不存在对应业务逻辑！");
		}
		List<String> idOrList = (List<String>)dAFacade.execQuery(qrySql, sqlParam,new ColumnListHandler());

		return idOrList.toArray(new String[idOrList.size()]);

	}

}
