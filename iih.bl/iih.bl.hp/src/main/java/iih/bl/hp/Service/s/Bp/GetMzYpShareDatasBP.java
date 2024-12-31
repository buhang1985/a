package iih.bl.hp.Service.s.Bp;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bl.cg.i.IBlOutQryService;
import iih.bl.hp.Service.s.Bp.qry.GetPatDrugOrdersQry;
import iih.bl.hp.dto.MzYpShareDataDTO;
import iih.bl.hp.viewmziihypshare.d.ViewMzIihYpShareDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;

/**
 * 获取患者药品信息（IIH+CHIS)
 * 
 * @author ly 2017/05/20
 *
 */
public class GetMzYpShareDatasBP extends GetMzYpDataFromChisViewBp {

	/**
	 * 根据病人ID获得该病人在本院近query_days天的药品类医嘱信息（IIH+CHIS)，已翻译成CHIS格式，CHIS可直接使用
	 * 
	 * @param Patient_id
	 *            患者ID
	 * @param query_days
	 *            查询病人从今日往前的天数
	 * @param target_sys
	 *            查询目标系统(0:全部 1:chis 2:iih)
	 * @return 该病人在本院近query_days天的药品类医嘱信息
	 * @throws BizException
	 */
	public MzYpShareDataDTO[] exec(String patientId, int queryDays, String target_sys) throws BizException {

		this.validateParam(patientId, queryDays, target_sys);

		ViewMzIihYpShareDTO[] iihDatas = null;// IIH数据
		ViewMzIihYpShareDTO[] chisDatas = null;// CHIS数据

		if ("0".equals(target_sys) || "2".equals(target_sys)) {
			// 1.调用IIH的信息，转成CHIS格式的数据
			iihDatas = this.getIIHDatas(patientId, queryDays);
		}

		if ("0".equals(target_sys) || "1".equals(target_sys)) {
			// 2.调用CHIS的视图数据
			chisDatas = this.getEBSBatchDTOs(patientId);
		}

		// 3.组织1和2的数据，返回给CHIS
		List<MzYpShareDataDTO> mzYpShareDataList = new ArrayList<MzYpShareDataDTO>();
		if (!ArrayUtil.isEmpty(iihDatas)) {
			for (ViewMzIihYpShareDTO data : iihDatas) {
				mzYpShareDataList.add(this.convertToBean(data));
			}
		}

		if (!ArrayUtil.isEmpty(chisDatas)) {
			for (ViewMzIihYpShareDTO data : chisDatas) {
				mzYpShareDataList.add(this.convertToBean(data));
			}
		}

		return mzYpShareDataList.toArray(new MzYpShareDataDTO[0]);
	}

	/**
	 * 参数校验
	 * 
	 * @param patientId
	 * @param queryDays
	 * @throws BizException
	 */
	private void validateParam(String patientId, int queryDays, String target_sys) throws BizException {

		if (StringUtil.isEmpty(patientId)) {
			throw new BizException("传入的参数患者id为空");
		}

		if (queryDays <= 0 || queryDays > 50) {
			throw new BizException("传入的参数查询天数需大于0小于等于50");
		}

		if (!"0".equals(target_sys) && !"1".equals(target_sys) && !"2".equals(target_sys)) {
			throw new BizException("传入的参数查询目标系统需设值范围为：0,1,2");
		}
	}

	/**
	 * 查询iih医嘱信息
	 * 
	 * @param patientId
	 * @param queryDays
	 * @return
	 * @throws BizException
	 */
	private ViewMzIihYpShareDTO[] getIIHDatas(String patientId, int queryDays) throws BizException {

		// 1.调用IIH的信息，转成CHIS格式的数据
		FDate date = new FDate().getDateBefore(queryDays - 1);

		IBlOutQryService oqService = ServiceFinder.find(IBlOutQryService.class);

		GetPatDrugOrdersQry qry = new GetPatDrugOrdersQry(patientId, date.toString() + " 00:00:00");
		ViewMzIihYpShareDTO[] iihDatas = oqService.getChisEffeData((ViewMzIihYpShareDTO[]) AppFwUtil.getDORstWithDao(qry, ViewMzIihYpShareDTO.class));

		if (ArrayUtil.isEmpty(iihDatas))
			return null;

		List<String> orsrvList = new ArrayList<String>();// 转换收费状态用医嘱服务集合
		for (ViewMzIihYpShareDTO data : iihDatas) {
			// 处方类型转换
			data.setOrder_properties(this.translatePresType(data.getSd_prestp(), data.getSd_prestpword()));

			// 收费状态
			if (ICiDictCodeConst.SD_SU_BL_NONE.equals(data.getSd_su_bl()) || StringUtil.isEmpty(data.getSd_su_bl())) {
				data.setCharge_status("1");// 未收费
			} else {
				orsrvList.add(data.getId_orsrv());
			}
		}

		if (!ListUtil.isEmpty(orsrvList)) {
			Map<String, Map<String, Object>> blMap = this.getBlState(orsrvList);
			for (ViewMzIihYpShareDTO data : iihDatas) {

				if (!orsrvList.contains(data.getId_orsrv()))
					continue;

				Map<String, Object> judgeData = blMap.get(data.getId_orsrv());
				if (judgeData == null) {
					data.setCharge_status("1");
					continue;
				}

				// 收费状态转换
				if (judgeData.get("id_stoep") == null || StringUtil.isEmpty(judgeData.get("id_stoep").toString())) {
					data.setCharge_status("2");// 已记账
				} else if (judgeData.get("id_paypatoep") == null || StringUtil.isEmpty(judgeData.get("id_paypatoep").toString())) {
					data.setCharge_status("3");// 已结算
				} else {
					data.setCharge_status("4");// 已收费
				}
			}
		}

		return iihDatas;
	}

	/**
	 * 转换处方类型
	 * 
	 * @param sdPrestp
	 * @param sdPrestpWord
	 * @return
	 */
	private String translatePresType(String sdPrestp, String sdPrestpWord) {

		if (ICiDictCodeConst.SD_PRESCRIPTION_FLAG_WPY.equals(sdPrestpWord))
			return "013";// 外配药处方笺
		else if (ICiDictCodeConst.SD_UDIDOC_PRESCRIPTION_MZCFJ.equals(sdPrestp))
			return "001";// 门诊处方笺
		else if (ICiDictCodeConst.SD_UDIDOC_PRESCRIPTION_JZCFJ.equals(sdPrestp))
			return "002";// 急诊处方笺
		else if (ICiDictCodeConst.SD_UDIDOC_PRESCRIPTION_GFYLCFJ.equals(sdPrestp))
			return "003";// 公费医疗处方笺
		else if (ICiDictCodeConst.SD_UDIDOC_PRESCRIPTION_YLBXCFJ.equals(sdPrestp) && ICiDictCodeConst.SD_PRESCRIPTION_FLAG_TSB.equals(sdPrestpWord))
			return "011";// 特殊病处方笺
		else if (ICiDictCodeConst.SD_UDIDOC_PRESCRIPTION_YLBXCFJ.equals(sdPrestp) && ICiDictCodeConst.SD_PRESCRIPTION_FLAG_JSY.equals(sdPrestpWord))
			return "012";// 特定药处方笺
		else if (ICiDictCodeConst.SD_UDIDOC_PRESCRIPTION_YLBXCFJ.equals(sdPrestp))
			return "004";// 医疗保险处方笺
		else if (ICiDictCodeConst.SD_UDIDOC_PRESCRIPTION_MJZMZJYY.equals(sdPrestp))
			return "007";// 门（急）诊麻醉、精一药品处方笺
		else if (ICiDictCodeConst.SD_UDIDOC_PRESCRIPTION_MZELJSYP.equals(sdPrestp))
			return "009";// 门诊二类精神药品处方笺
		else if (ICiDictCodeConst.SD_UDIDOC_PRESCRIPTION_GSBXCFJ.equals(sdPrestp))
			return "010";// 工伤保险处方笺

		return null;
	}

	/**
	 * 获取服务记账状态
	 * 
	 * @param orsrvList
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private Map<String, Map<String, Object>> getBlState(List<String> orsrvList) throws BizException {

		String inSql = "(";
		for (String str : orsrvList) {
			inSql += "'" + str + "',";
		}

		inSql = inSql.substring(0, inSql.length() - 1);
		inSql += ")";

		String sql = "select a.id_orsrv,b.id_stoep,b.id_paypatoep " + "from bl_cg_itm_oep a " + "left join bl_st_oep b " + "on a.id_stoep = b.id_stoep " + "where a.id_orsrv in " + inSql;

		DAFacade daf = new DAFacade();
		List<Map<String, Object>> data = (List<Map<String, Object>>) daf.execQuery(sql, new MapListHandler());

		Map<String, Map<String, Object>> rlt = new HashMap<String, Map<String, Object>>();
		if (ListUtil.isEmpty(data))
			return rlt;

		for (Map<String, Object> map : data) {
			rlt.put(map.get("id_orsrv").toString(), map);
		}

		return rlt;
	}

	/**
	 * 将dto转为返回值需要的javabean
	 * 
	 * @param data
	 * @return
	 */
	private MzYpShareDataDTO convertToBean(ViewMzIihYpShareDTO data) {
		MzYpShareDataDTO bean = new MzYpShareDataDTO();
		bean.setPatient_id(data.getPatient_id());
		bean.setTimes(data.getTimes());
		bean.setDrugname(data.getDrugname());
		bean.setCharge_code(data.getCharge_code());
		bean.setSerial_no(data.getSerial_no());
		bean.setCharge_amount(data.getCharge_amount() == null ? 0d : data.getCharge_amount().doubleValue());
		bean.setCaoyao_fu(data.getCaoyao_fu());
		bean.setHappen_date(data.getHappen_date() == null ? "" : data.getHappen_date().toString());
		bean.setFit_type(data.getFit_type());
		bean.setPersist_days(data.getPersist_days());
		bean.setOrder_properties(data.getOrder_properties());
		bean.setCharge_status(data.getCharge_status());
		bean.setVisit_dept(data.getVisit_dept());
		bean.setInfusion_flag(data.getInfusion_flag());
		bean.setApply_unit(data.getApply_unit());
		bean.setFreq_req(data.getFreq_code());
		bean.setDrug_flag(data.getDrug_flag());
		bean.setSrc_sys(data.getSrc_sys());
		bean.setDoctor_code(data.getDoctor_code());

		return bean;
	}
}
