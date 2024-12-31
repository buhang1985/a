package iih.ci.event.ord.bps.refund.logicbp.common;

import java.util.HashMap;

import iih.bl.cg.dto.d.OpRefund4IpEsDTO;
import iih.ci.event.ord.bps.zcommon.parambp.CommonParamBP;
import iih.ci.event.ord.utils.OrdEventUtil;
/**
 * 门诊退费公共逻辑类
 * @author F
 *
 * @date 2019年9月17日上午10:27:46
 *
 * @classpath iih.ci.event.ord.bps.refund.logicbp.common.OpRefundCommonLogicDealWithBP
 */
public class OpRefundCommonLogicDealWithBP extends CommonParamBP{

	/**
	 * 获得服务主键
	 * 
	 * @param refund4IpEsDTOs
	 * @return
	 */
	public String getIdOrSrvs(OpRefund4IpEsDTO[] refund4IpEsDTOs) {
		String idOrsrvs = "";
		for (OpRefund4IpEsDTO es : refund4IpEsDTOs) {
			idOrsrvs += es.getId_orsrv() + OrdEventUtil.COMMA_STR;
		}
		if (idOrsrvs.length() > 0) {
			idOrsrvs = idOrsrvs.substring(0, idOrsrvs.length() - 1);
		}
		return idOrsrvs;
	}

	/**
	 * 获得医嘱id_or，以，隔开
	 * 
	 * @param refund4IpEsDTOs
	 * @return
	 */
	public String getIdOrs(OpRefund4IpEsDTO[] refund4IpEsDTOs) {
		String idors = "";
		for (OpRefund4IpEsDTO es : refund4IpEsDTOs) {
			idors += es.getId_or() + OrdEventUtil.COMMA_STR;
		}
		if (idors.length() > 0) {
			idors = idors.substring(0, idors.length() - 1);
		}
		return idors;
	}
	/**
	 * 获得处方主键
	 * @param refund4IpEsDTOs
	 * @return
	 */
	public String getIdPreses(OpRefund4IpEsDTO[] refund4IpEsDTOs) {
		String idpreses = "";
		for (OpRefund4IpEsDTO es : refund4IpEsDTOs) {
			idpreses += es.getId_pres() + OrdEventUtil.COMMA_STR;
		}
		if (idpreses.length() > 0) {
			idpreses = idpreses.substring(0, idpreses.length() - 1);
		}
		return idpreses;
	}
	/**
	 * 获得以服务主键作为key的退费DTO的Map
	 * @param refundDTOs
	 * @return
	 */
	public HashMap<String, OpRefund4IpEsDTO> getOpRefundDTOMapKeyIdorsrv(OpRefund4IpEsDTO[] refundDTOs) {
		HashMap<String, OpRefund4IpEsDTO> refundMap = new HashMap<String,OpRefund4IpEsDTO>();
		for (OpRefund4IpEsDTO es : refundDTOs) {
			refundMap.put(es.getId_orsrv(), es);
		}
		return refundMap;
	}
	/**
	 * 获得以处方主键作为key的退费DTO的Map
	 * @param refundDTOs
	 * @return
	 */
	public HashMap<String, OpRefund4IpEsDTO> getOpRefundDTOMapKeyIdpres(OpRefund4IpEsDTO[] refundDTOs) {
		HashMap<String, OpRefund4IpEsDTO> refundMap = new HashMap<String,OpRefund4IpEsDTO>();
		for (OpRefund4IpEsDTO es : refundDTOs) {
			if(!refundMap.containsKey(es.getId_pres())){
				refundMap.put(es.getId_pres(), es);
			}
		}
		return refundMap;
	}
	/**
	 * 获得以医嘱主键作为key的退费DTO的Map
	 * @param refundDTOs
	 * @return
	 */
	public HashMap<String, OpRefund4IpEsDTO> getOpRefundDTOMapKeyIdor(OpRefund4IpEsDTO[] refundDTOs) {
		HashMap<String, OpRefund4IpEsDTO> refundMap = new HashMap<String,OpRefund4IpEsDTO>();
		for (OpRefund4IpEsDTO es : refundDTOs) {
			if(!refundMap.containsKey(es.getId_or())){
				refundMap.put(es.getId_or(), es);
			}
		}
		return refundMap;
	}
}
