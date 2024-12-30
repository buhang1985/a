package iih.sc.sch.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.ScSqlUtils;
import iih.sc.comm.ScValidator;
import iih.sc.pub.ScGroupControlUtils;
import iih.sc.sch.dto.d.SchOralInfoDTO;
import iih.sc.sch.s.ep.OralSchEP;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.d.SchOcpResDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询口腔排班数据BP
 * 
 * @author zhengcm
 * @date 2016-11-15 19:17:36
 *
 */
public class GetOralSchArrayBP {

	/**
	 * 查询口腔排班数据
	 *
	 * @param id_dep 科室id
	 * @param dt_begin 开始日期
	 * @param dt_end 结束日期
	 * @param name_room 诊间
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	@SuppressWarnings("unchecked")
	public SchOralInfoDTO[] exec(String id_dep, String dt_begin, String dt_end, String name_room,String paramId)
			throws BizException {
		// 1、检查参数
		ScValidator.validateParam("id_dep", id_dep);
		ScValidator.validateParam("dt_begin", dt_begin);
		ScValidator.validateParam("dt_end", dt_end);

		// 2、查询数据
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("sch.id_sch,");
		sb.append("sch.id_quesite,");
		sb.append("sch.id_emp_nurse,");
		sb.append("psn.name as name_emp_nurse,");
		sb.append("sch.id_scpl,");
		sb.append("pl.name as name_scpl,");
		sb.append("sch.Max_num_add,");
		sb.append("sch.d_sch,");
		sb.append("sch.id_dayslot,");
		sb.append("lot.name as name_dayslot,");
		sb.append("sch.fg_active,");
		sb.append("sch.scpolcn,");
		sb.append("sch.quan_total,");
		sb.append("sch.quan_total_used,");
		sb.append("sch.quan0_appt,");
		sb.append("sch.quan1_appt,");
		sb.append("sch.quan2_appt,");
		sb.append("sch.quan3_appt,");
		sb.append("sch.quan4_appt,");
		sb.append("sch.quan5_appt,");
		sb.append("sch.quan6_appt,");
		sb.append("sch.quan7_appt,");
		sb.append("sch.quan8_appt,");
		sb.append("sch.quan9_appt,");
		sb.append("sch.quan0_used,");
		sb.append("sch.quan1_used,");
		sb.append("sch.quan2_used,");
		sb.append("sch.quan3_used,");
		sb.append("sch.quan4_used,");
		sb.append("sch.quan5_used,");
		sb.append("sch.quan6_used,");
		sb.append("sch.quan7_used,");
		sb.append("sch.quan8_used,");
		sb.append("sch.quan9_used ");
	    sb.append(",site.room name_room, ");
	    sb.append("  sch.id_depparam ");
		sb.append("from ");
		sb.append("sc_sch sch ");
		sb.append("inner join sc_pl pl on sch.id_scpl = pl.id_scpl ");
		sb.append("left join bd_psndoc psn on psn.id_psndoc = sch.id_emp_nurse ");
		sb.append("left join bd_dayslot lot on lot.id_dayslot = sch.id_dayslot ");

		sb.append("left join bd_que_site site on site.id_quesite = sch.id_quesite  ");

		// 诊间不为空就按照诊间过滤
		if (!StringUtil.isEmptyWithTrim(name_room) && !name_room.equals("%")) {
			sb.append("and site.room = ? ");
		}
		sb.append("where ");
		sb.append("pl.id_dep = ? ");
		sb.append("and sch.d_sch >= ? ");
		sb.append("and sch.d_sch <= ? ");
		if(!StringUtil.isEmptyWithTrim(paramId)){
			sb.append(" and sch.id_depparam = ('");
			sb.append(paramId);
			sb.append("')");
		}
		sb.append("and pl.eu_edit_tp =?");
		sb.append(" and sch.sd_sctp = ?");
		String sqlStr =ScGroupControlUtils.getGroupControlFitler(new ScSchDO(), "sch");
		sb.append("and ");	
		sb.append(sqlStr);
		SqlParam params = new SqlParam();
		if (!StringUtil.isEmptyWithTrim(name_room) && !name_room.equals("%")) {
			params.addParam(name_room);
		}
		params.addParam(id_dep);
		params.addParam(dt_begin);
		params.addParam(dt_end);
		params.addParam(IScDictCodeConst.EU_EDIT_TP_ORAL);
		params.addParam(IScDictCodeConst.SD_SCTP_OP);
		List<SchOralInfoDTO> datas = (List<SchOralInfoDTO>) new DAFacade().execQuery(sb.toString(),
				params, new BeanListHandler(SchOralInfoDTO.class));

		if (ListUtil.isEmpty(datas)) {
			return null;
		}

		List<String> schIds = new ArrayList<String>();
		for (SchOralInfoDTO schDTO : datas) {
			schIds.add(schDTO.getId_sch());
		}
		String where = ScSqlUtils.getInSqlByIds("id_sch", schIds);

		// 查询排班资源占用数据
		Map<String, List<SchOcpResDO>> schOcpResMap = this.querySchOcpResByCond(where);

		// 处理排班资源占用数据
		datas = this.processSchOcpRes(datas, schOcpResMap);

		return datas.toArray(new SchOralInfoDTO[0]);
	}

	/**
	 * 处理排班资源占用
	 *
	 * @param schDTOList
	 * @param schOcpResMap
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private List<SchOralInfoDTO> processSchOcpRes(List<SchOralInfoDTO> schDTOList,
			Map<String, List<SchOcpResDO>> schOcpResMap) throws BizException {
		if (ListUtil.isEmpty(schDTOList)) {
			return null;
		}
		List<SchOralInfoDTO> newDataList = new ArrayList<SchOralInfoDTO>();
		for (SchOralInfoDTO schDTO : schDTOList) {
			schDTO.setFg_occupy(FBoolean.FALSE);
			newDataList.add(schDTO);
			List<SchOcpResDO> ocpResDOs = null;
			if (schOcpResMap != null && schOcpResMap.containsKey(schDTO.getId_sch())) {
				ocpResDOs = schOcpResMap.get(schDTO.getId_sch());
			}
			if (!ListUtil.isEmpty(ocpResDOs)) {
				for (SchOcpResDO resDO : ocpResDOs) {
					SchOralInfoDTO newDTO = new SchOralInfoDTO();
					newDTO.setId_sch(schDTO.getId_sch());
					newDTO.setD_sch(schDTO.getD_sch());
					newDTO.setId_scpl(schDTO.getId_scpl());
					newDTO.setName_scpl(schDTO.getName_scpl());
					newDTO.setId_depparam(schDTO.getId_depparam());
					newDTO.setId_quesite(resDO.getId_quesite());
					newDTO.setId_dayslot(schDTO.getId_dayslot());
					newDTO.setName_dayslot(schDTO.getName_dayslot());
					newDTO.setId_schocpres(resDO.getId_schocpres());
					newDTO.setFg_occupy(FBoolean.TRUE);
					newDataList.add(newDTO);
				}
			}
		}
		return newDataList;
	}

	/**
	 * 获取排班占用资源
	 *
	 * @param cond
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private Map<String, List<SchOcpResDO>> querySchOcpResByCond(String cond) throws BizException {
		if (StringUtil.isEmpty(cond)) {
			return null;
		}
		SchOcpResDO[] ocpResDOs = new OralSchEP().getSchOcpResByCond(cond, null);
		if (ArrayUtil.isEmpty(ocpResDOs)) {
			return null;
		}
		Map<String, List<SchOcpResDO>> map = new HashMap<String, List<SchOcpResDO>>();
		for (SchOcpResDO resDO : ocpResDOs) {
			String key = resDO.getId_sch();
			if (map.containsKey(key)) {
				map.get(key).add(resDO);
			} else {
				List<SchOcpResDO> list = new ArrayList<SchOcpResDO>();
				list.add(resDO);
				map.put(key, list);
			}
		}
		return map;
	}

}
