package iih.ci.ord.s.external.common.bp;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.i.external.common.meta.EffectiveOrSrvDTO;
import iih.ci.ord.i.external.common.meta.EffectiveOrderDTO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取有效的服务项目
 * 
 * @author HUMS
 *
 */
public class GetEffectiveOrSrvBP {

	/**
	 * 根据医嘱id获取当前有效的医嘱
	 * 
	 * @param idOrListMap
	 *            就诊类型对应的医嘱id集合
	 * @return 有效的医嘱对象集合
	 * @throws DAException
	 */
	public List<EffectiveOrSrvDTO> getEffectiveOrSrvListByIdOrsrvs(Map<String, List<String>> idOrSrvListMap)
			throws DAException {

		StringBuffer qrySqlBuffer = new StringBuffer();

		StringBuffer paramBuffer = new StringBuffer();

		SqlParam sqlParam = new SqlParam();
		DAFacade dAFacade = new DAFacade();
		
		// 获取门诊住院查询有效的服务项目集合
		Map<String,String> sqlMap = this.getOrdSrvQrySql();

		for (String code_entp : idOrSrvListMap.keySet()) {

			if (paramBuffer.length() != 0) {

				paramBuffer.setLength(0);
			}

			List<String> idOrList = idOrSrvListMap.get(code_entp);
			for (String id_or : idOrList) {
				paramBuffer.append(",?");
				sqlParam.addParam(id_or);
			}

			if (qrySqlBuffer.length() > 0) {
				qrySqlBuffer.append(" union all ");
			}
			qrySqlBuffer.append(sqlMap.get(code_entp)).append(" and srv.id_orsrv in (").append(paramBuffer.substring(1))
					.append(")");
		}

		List<EffectiveOrSrvDTO> orSrvList = (List<EffectiveOrSrvDTO>) dAFacade.execQuery(qrySqlBuffer.toString(), sqlParam,
				new BeanListHandler(EffectiveOrSrvDTO.class));

		return orSrvList;
	}

	/**
	 * 获取有效的服务项目集合
	 * @param code_entp 就诊类型
	 * @return 与就诊类型对应的有效服务项目查询语句
	 */
	private Map<String,String> getOrdSrvQrySql() {

		// 查询门诊有效的服务项目
		String effective_order_qry_op = "select ord.id_or, ord.id_en, ord.code_entp,ord.name_or ,ord.sd_su_or"
				+ ",srv.id_orsrv,srv.name,srv.fg_feertnable,srv.sd_su_bl,srv.fg_bl,srv.sv"
				+ " from ci_order ord, ci_or_srv srv"
				+ " where ord.id_or = srv.id_or and ord.ds = 0 and srv.ds = 0 and ord.code_entp = '00'  and ord.fg_sign = 'Y' and ord.fg_canc= 'N' "
				+ " and ord.sd_su_bl!=" + ICiDictCodeConst.SD_SU_BL_REFOUND + " and srv.sd_su_bl !=" + ICiDictCodeConst.SD_SU_BL_REFOUND ;

		// 查询住院有效的服务项目
		String effective_order_qry_ip = "select ord.id_or, ord.id_en, ord.code_entp,ord.name_or ,ord.sd_su_or"
				+ ",srv.id_orsrv,srv.name,srv.fg_feertnable,srv.sd_su_bl,srv.fg_bl,srv.sv "
				+ " from ci_order ord, ci_or_srv srv "
				+ " where ord.id_or = srv.id_or and ord.ds = 0 and srv.ds=0 and ord.code_entp = '10'  and ord.fg_sign = 'Y' and ord.fg_chk_canc= 'N'"
				+ " and ord.sd_su_bl!=" + ICiDictCodeConst.SD_SU_BL_REFOUND + " and srv.sd_su_bl !=" + ICiDictCodeConst.SD_SU_BL_REFOUND ;
		
		Map<String,String> sqlMap = new ConcurrentHashMap<String,String>();
		sqlMap.put(IBdFcDictCodeConst.SD_CODE_ENTP_OP, effective_order_qry_op);
		sqlMap.put(IBdFcDictCodeConst.SD_CODE_ENTP_IP, effective_order_qry_ip);
		
		return sqlMap;
	}
}
