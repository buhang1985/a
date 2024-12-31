package iih.ci.event.ord.bps.refund.logicbp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bl.cg.dto.d.OpRefund4IpEsDTO;
import iih.ci.event.ord.bps.refund.logicbp.common.OpRefundCommonLogicDealWithBP;
import iih.ci.event.ord.bps.refund.query.OpRisLisRefundAllInfoQuery;
import iih.ci.event.ord.utils.OrdEventHelper;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.iemsg.d.IEOpOrCancStpDTO;
import iih.ci.ord.iemsg.d.IEOpOrCancStpEnDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
/**
 * 门诊检查检验退费逻辑处理BS005
 * @author F
 *
 * @date 2019年9月17日下午3:26:55
 *
 * @classpath iih.ci.event.ord.bps.refund.logicbp.OpRisLisRefundLogicDealWithBP
 */
public class OpRisLisRefundLogicDealWithBP extends OpRefundCommonLogicDealWithBP{

	/**
	 * 生成集成平台检查和检验医嘱服务退费数据信息 （门诊）
	 * 
	 * @param OpRefund4IpEsDTO[]
	 *            医嘱id串
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public IEOpOrCancStpEnDTO[] exec(OpRefund4IpEsDTO[] refundDTOs) throws BizException {
		String id_ors = this.getIdOrs(refundDTOs);
		HashMap<String, OpRefund4IpEsDTO> refundMap = this.getOpRefundDTOMapKeyIdor(refundDTOs);
		// 退费人的信息
		Map<String, String[]> cancPsnMaps = getCancIdPats(refundDTOs);
		if (OrdEventUtil.isEmpty(id_ors))
			return null;
		//查询出组装集成平台的主子do的数据
		List<Map<String, Object>> lisRisMaps = getLisRisIEData(id_ors);
		List<IEOpOrCancStpEnDTO> ieOpOrCancStpEnDTOs = new ArrayList<IEOpOrCancStpEnDTO>();
		for (Map<String, Object> map : lisRisMaps) {
			IEOpOrCancStpEnDTO ieOpOrCancStpEnDTO = new IEOpOrCancStpEnDTO();
			IEOpOrCancStpDTO iEOpOrCancStpDTO = new IEOpOrCancStpDTO();
			// 组装主do
			setIeOpOrCancStpEnDTO(ieOpOrCancStpEnDTO, map);
			// 组装子do
			setIEOpOrCancStpDTO(iEOpOrCancStpDTO, map, refundMap, cancPsnMaps);
			FArrayList2 list2 = new FArrayList2();
			list2.add(iEOpOrCancStpDTO);
			ieOpOrCancStpEnDTO.setId_ieorcancstps(list2);

			ieOpOrCancStpEnDTOs.add(ieOpOrCancStpEnDTO);
		}
		return ieOpOrCancStpEnDTOs.toArray(new IEOpOrCancStpEnDTO[0]);
	}
	/**
	 * 查询出组装集成平台的主子do的数据
	 * @param id_orsrvs
	 * @return
	 * @throws BizException
	 */
	private List<Map<String, Object>> getLisRisIEData(String id_ors) throws BizException {
		// 查询出检查和检验的集成平台数据
		OpRisLisRefundAllInfoQuery query= new OpRisLisRefundAllInfoQuery(id_ors);
		String sql = query.getQrySQLStr();
		List<Map<String, Object>> lisRisMaps = OrdEventUtil.getRsMapList(sql);
		return lisRisMaps;
	}

	/**
	 * 组装主DO
	 * 
	 * @param ieOpOrCancStpEnDTO
	 * @param map
	 */
	private void setIeOpOrCancStpEnDTO(IEOpOrCancStpEnDTO ieOpOrCancStpEnDTO, Map<String, Object> map) {
		ieOpOrCancStpEnDTO.setPatient_id(OrdEventUtil.nullHandle(map.get("patient_id")));
		ieOpOrCancStpEnDTO.setTimes(map.get("times")==null?"0":map.get("times").toString());
		ieOpOrCancStpEnDTO.setDomain_id("01");
		ieOpOrCancStpEnDTO.setDept_code(OrdEventUtil.nullHandle(map.get("dept_code")));
		ieOpOrCancStpEnDTO.setDept_name(OrdEventUtil.nullHandle(map.get("dept_name")));
		ieOpOrCancStpEnDTO.setOrg_code(OrdEventUtil.nullHandle(map.get("org_code")));
		ieOpOrCancStpEnDTO.setOrg_name(OrdEventUtil.nullHandle(map.get("org_name")));
		ieOpOrCancStpEnDTO.setVisitordno(OrdEventUtil.nullHandle(map.get("visitordno")));
		ieOpOrCancStpEnDTO.setVisittype(getParamCodeEntp(OrdEventUtil.nullHandle(map.get("visittype"))));
		ieOpOrCancStpEnDTO.setVisittypename(OrdEventUtil.nullHandle(map.get("visittypename")));
	}

	/**
	 * 组装子DO
	 * 
	 * @param iEOpOrCancStpDTO
	 * @param map
	 * @param refundMap
	 * @param cancPsnMaps
	 */
	private void setIEOpOrCancStpDTO(IEOpOrCancStpDTO iEOpOrCancStpDTO, Map<String, Object> map,
			HashMap<String, OpRefund4IpEsDTO> refundMap, Map<String, String[]> cancPsnMaps) {
		iEOpOrCancStpDTO.setOrder_id(OrdEventUtil.nullHandle(map.get("order_id")));
		iEOpOrCancStpDTO.setOrder_type(OrdEventUtil.nullHandle(map.get("order_type")));//医嘱类型
		iEOpOrCancStpDTO.setOrder_type_name(OrdEventUtil.nullHandle(map.get("order_type_name")));//医嘱的类型编码
		//执行科室编码
		iEOpOrCancStpDTO.setExec_unit(OrdEventUtil.nullHandle(map.get("exec_unit")));
		//执行科室名称
		iEOpOrCancStpDTO.setExec_unit_name(OrdEventUtil.nullHandle(map.get("exec_unit_name")));
		//集成分类
		iEOpOrCancStpDTO.setIemsgca(OrdEventUtil.nullHandle(map.get("iemsgca_code")));
		//申请科室
		iEOpOrCancStpDTO.setApply_code(OrdEventUtil.nullHandle(map.get("apply_code")));
		String id_or = OrdEventUtil.nullHandle(map.get("id_or"));
		if (!OrdEventUtil.isEmpty(id_or)) {
			OpRefund4IpEsDTO opRefund = refundMap.get(id_or);
			if (!OrdEventUtil.isEmpty(opRefund)) {
				iEOpOrCancStpDTO.setCancel_date(opRefund.getDt_refund());
				iEOpOrCancStpDTO.setCancel_reason(opRefund.getReason());
				String[] cancPsnArr = cancPsnMaps.get(opRefund.getId_emp_refund());
				if (!OrdEventUtil.isEmpty(cancPsnArr)) {
					iEOpOrCancStpDTO.setCancel_opera(cancPsnArr[0]);
					iEOpOrCancStpDTO.setCancel_opera_name(cancPsnArr[1]);
				}
			}
			//收费标识
			OrdSrvDO[] ordSrvDOs;
			try {
				ordSrvDOs = OrdEventHelper.getOrdSrvDO(id_or);
				if(!OrdEventUtil.isEmpty(ordSrvDOs)) {
					iEOpOrCancStpDTO.setPayflag(ordSrvDOs[0].getSd_su_bl());
				}
			} catch (BizException e) {
				iEOpOrCancStpDTO.setPayflag("");
			}
		}
	}
	/**
	 * 查询退费人信息
	 * 
	 * @param refundDTOs
	 * @return
	 * @throws BizException
	 */
	private Map<String, String[]> getCancIdPats(OpRefund4IpEsDTO[] refundDTOs) throws BizException {
		String id_pats = "";
		for (OpRefund4IpEsDTO es : refundDTOs) {
			id_pats += es.getId_emp_refund() + OrdEventUtil.COMMA_STR;
		}
		if (!OrdEventUtil.isEmpty(id_pats)) {
			Map<String, String[]> psnDocMap = new HashMap<String, String[]>();
			id_pats = id_pats.substring(0, id_pats.length() - 1).replaceAll(OrdEventUtil.COMMA_STR,
					OrdEventUtil.SQUOTE_MARK_STR + OrdEventUtil.COMMA_STR + OrdEventUtil.SQUOTE_MARK_STR);
			String sql = " select bd_psndoc.code,bd_psndoc.name,bd_psndoc.id_psndoc from bd_psndoc where bd_psndoc.id_psndoc in ('"
					+ id_pats + "')";
			List<Map<String, Object>> psnDocs = OrdEventUtil.getRsMapList(sql);
			for (Map<String, Object> map : psnDocs) {
				String id_psndoc = OrdEventUtil.nullHandle(map.get("id_psndoc"));
				if (!OrdEventUtil.isEmpty(id_psndoc)) {
					String[] psnArray = new String[2];
					String code = OrdEventUtil.nullHandle(map.get("code"));
					if (!OrdEventUtil.isEmpty(code)) {
						psnArray[0] = code;
					}
					String name = OrdEventUtil.nullHandle(map.get("name"));
					if (!OrdEventUtil.isEmpty(name)) {
						psnArray[1] = name;
					}
					psnDocMap.put(id_psndoc, psnArray);
				}
			}
			return psnDocMap;
		}

		return null;
	}
}
