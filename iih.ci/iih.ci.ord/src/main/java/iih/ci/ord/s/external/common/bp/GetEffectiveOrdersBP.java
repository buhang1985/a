package iih.ci.ord.s.external.common.bp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.i.external.common.meta.EffectiveOrderDTO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取有效医嘱查询BP
 * 
 * @author HUMS
 *
 */
public class GetEffectiveOrdersBP {

	// 查询门诊有效医嘱基础语句
	private final static String EFFECTIVE_ORDER_QRY_OP = "select id_or, id_en, code_entp,name_or,fg_feertnable ,sd_su_bl ,sd_su_mp,sd_su_or,sv  from ci_order where ds = 0 and code_entp = '00'  and fg_sign = 'Y' and fg_canc= 'N' and sd_su_bl!="
			+ ICiDictCodeConst.SD_SU_BL_REFOUND;

	// 查询住院有效医嘱基础语句
	private final static String EFFECTIVE_ORDER_QRY_IP = "select id_or,id_en, code_entp,name_or,fg_feertnable ,sd_su_bl ,sd_su_mp,sd_su_or,sv from ci_order where ds = 0 and code_entp = '10'  and fg_sign = 'Y' and fg_chk_canc= 'N'";

	private final static Map<String, String> ORDER_QRY_MAP = new HashMap<String, String>() {

		private static final long serialVersionUID = 1L;

		{
			put(IBdFcDictCodeConst.SD_CODE_ENTP_OP, EFFECTIVE_ORDER_QRY_OP);
			put(IBdFcDictCodeConst.SD_CODE_ENTP_IP, EFFECTIVE_ORDER_QRY_IP);
		}
	};

	/**
	 * 根据医嘱id获取当前有效的医嘱
	 * 
	 * @param idOrListMap
	 *            就诊类型对应的医嘱id集合
	 * @return 有效的医嘱对象集合
	 * @throws DAException
	 */
	public List<EffectiveOrderDTO> getEffectiveOrderListByIdors(Map<String, List<String>> idOrListMap)
			throws DAException {

		StringBuffer qryBuffer = new StringBuffer();

		StringBuffer paramBuffer = new StringBuffer();

		SqlParam sqlParam = new SqlParam();
		DAFacade dAFacade = new DAFacade();

		for (String code_entp : idOrListMap.keySet()) {

			if (paramBuffer.length() != 0) {

				paramBuffer.setLength(0);
			}

			List<String> idOrList = idOrListMap.get(code_entp);
			for (String id_or : idOrList) {
				paramBuffer.append(",?");
				sqlParam.addParam(id_or);
			}

			if (qryBuffer.length() > 0) {
				qryBuffer.append(" union all ");
			}
			qryBuffer.append(ORDER_QRY_MAP.get(code_entp)).append(" and id_or in (").append(paramBuffer.substring(1))
					.append(")");
		}

		List<EffectiveOrderDTO> orderList = (List<EffectiveOrderDTO>) dAFacade.execQuery(qryBuffer.toString(), sqlParam,
				new BeanListHandler(EffectiveOrderDTO.class));

		return orderList;
	}
}
