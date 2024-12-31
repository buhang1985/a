package iih.en.pv.s.bp.ip;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.pv.dto.d.DeptCountInfoDTO;

import java.util.Map;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 病区科室统计
 *
 */
public class GetDepStatsBP {
	/**
	 * 获取科室统计信息
	 * 
	 * @param depId
	 * @return
	 * @throws BizException
	 * @author ren_ying
	 * @author zhengcm(修改)
	 */
	public DeptCountInfoDTO exec(String depId) throws BizException {

		// 查询数据列字段别名
		String[] columns = { "total_num", "bed_num", "in_hos_num", "turn_in_num", "out_hos_num",
				"turn_out_num", "died_num", "surgery_num", "danger_num", "serious_num",
				"spec_care_num", "a_level_care_num", "child_birth_num", "baby_num", "bed_num_use",
				"hp_num"};

		// 入院和入科
		String inCond = "'" + IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN + "','"
				+ IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN + "'";
		// 出院
		String outCond = "'" + IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALOUT + "'";
		//使用中床位
		String bedUseCond = "'1', '2', '3'";

		// 组装查询SQL
		StringBuilder sb = new StringBuilder();
		sb.append("select * from ");

		// 当前科室或病区的所有病人
		sb.append("(select count(*) as "
				+ columns[0]
				+ " from en_ent ent inner join en_ent_ip ip on ent.id_ent = ip.id_ent and ent.id_dep_nur = ? and ip.sd_status in ("
				+ inCond + ") and ent.fg_ip = 'Y') t1,");

		// 当前科室下的所有床位数量
		sb.append("(select count(*) as " + columns[1]
				+ " from bd_bed bed  where bed.id_dep_belong = ?) t2,");

		// 当天 入院 并且 入院科室为当前科室的病人数量
		sb.append("(select count(*) as "
				+ columns[2]
				+ " from en_ent ent inner join en_ent_ip ip on ent.id_ent = ip.id_ent and ent.id_dep_nur = ? and ip.sd_status in ("
				+ inCond
				+ ") and ent.fg_ip = 'Y' and substr(ent.dt_acpt,0,10) = to_char(sysdate,'YYYY-MM-dd')) t3,");

		// 当天转入当前科室的病人数量
		sb.append("(select count(distinct ent.id_ent) as "
				+ columns[3]
				+ " from en_ent ent inner join en_ent_dep dep on ent.id_ent = dep.id_ent "
				+ " where dep.id_dep_to = ? and substr(dep.dt_b,0,10) = to_char(sysdate,'YYYY-MM-dd')) t4,");

		// 当天 出院 并且 出院科室为当前科室的病人数量
		sb.append("(select count(*) as "
				+ columns[4]
				+ " from en_ent ent inner join en_ent_ip ip on ent.id_ent = ip.id_ent and ent.id_dep_nur = ? and ip.sd_status = "
				+ outCond
				+ " and ip.fg_newborn = 'N' and substr(ent.dt_end,0,10) = to_char(sysdate,'YYYY-MM-dd')) t5,");

		// 当天转出当前科室的病人数量
		sb.append("(select count(*) as "
				+ columns[5]
				+ " from en_ent ent inner join en_ent_dep dep on ent.id_ent = dep.id_ent"
				+ " where dep.id_dep_from = ? and substr(dep.dt_b,0,10) = to_char(sysdate,'YYYY-MM-dd')) t6,");

		// 当天在当前科室 死亡的病人数量
		sb.append("(select count(*) as "
				+ columns[6]
				+ " from en_ent ent inner join en_ent_ip ip on ip.id_ent = ent.id_ent where ip.sd_outcomes = '"
				+ IEnDictCodeConst.SD_GOWHERE_INPATIENT
				+ "' and ip.id_dep_phydisc = ? and substr(ent.dt_end,0,10) = to_char(sysdate,'YYYY-MM-dd')) t7,");

		// 当天 在当前科室 进行手术的病人数量
		sb.append("(select count(*) as "
				+ columns[7]
				+ " from en_ent ent inner join en_ent_ip ip on ent.id_ent = ip.id_ent and ip.sd_status in ("
				+ inCond
				+ ") and ent.fg_ip = 'Y' inner join en_ent_state stt on stt.id_ent = ent.id_ent and stt.id_enstatetp='"
				+ IBdFcDictCodeConst.ID_ENSTATE_OPDRATE + "' and stt.val = '"
				+ IBdFcDictCodeConst.VAL_ENSTATE_OPDRATE + "' where ent.id_dep_nur = ?) t8,");

		// 当天 当前科室下病情为病危的病人数量
		sb.append("(select count(*) as "
				+ columns[8]
				+ " from en_ent ent inner join en_ent_ip ip on ent.id_ent = ip.id_ent and ip.sd_status in ("
				+ inCond
				+ ") inner join en_ent_state stt on stt.id_ent = ent.id_ent and stt.id_enstatetp='"
				+ IBdFcDictCodeConst.ID_ENSTSTATETP_DISE + "' and stt.val = '"
				+ IBdFcDictCodeConst.CONDITION_GRADE_DYING
				+ "' where ent.fg_ip = 'Y' and ent.id_dep_nur = ?) t9,");

		// 当天 当前科室下病情为病重的病人数量
		sb.append("(select count(*) as "
				+ columns[9]
				+ " from en_ent ent inner join en_ent_ip ip on ent.id_ent = ip.id_ent and ip.sd_status in ("
				+ inCond
				+ ") inner join en_ent_state stt on stt.id_ent = ent.id_ent and stt.id_enstatetp='"
				+ IBdFcDictCodeConst.ID_ENSTSTATETP_DISE + "' and stt.val = '"
				+ IBdFcDictCodeConst.CONDITION_GRADE_SEVERITY
				+ "' where ent.fg_ip = 'Y' and ent.id_dep_nur = ?) t10,");

		// 在当前科室下，护理等级为特级护理的病人数量
		sb.append("(select count(*) as "
				+ columns[10]
				+ " from en_ent ent inner join en_ent_ip ip on ent.id_ent = ip.id_ent and ip.sd_status in ("
				+ inCond
				+ ") inner join en_ent_state stt on stt.id_ent = ent.id_ent and stt.id_enstatetp = '"
				+ IBdFcDictCodeConst.ID_UDIDOCLIST_NUR_DEF + "'and stt.val = '"
				+ IBdFcDictCodeConst.NURSING_STATUS_SERIOUS
				+ "' where ent.fg_ip = 'Y' and ent.id_dep_nur = ?) t11,");

		// 在当期科室下，护理等级为一级护理的病人数量
		sb.append("(select count(*) as "
				+ columns[11]
				+ " from en_ent ent inner join en_ent_ip ip on ent.id_ent = ip.id_ent and ip.sd_status in ("
				+ inCond
				+ ") inner join en_ent_state stt on stt.id_ent = ent.id_ent and stt.id_enstatetp = '"
				+ IBdFcDictCodeConst.ID_UDIDOCLIST_NUR_DEF + "'and stt.val = '"
				+ IBdFcDictCodeConst.NURSING_STATUS_FIRST
				+ "' where ent.fg_ip = 'Y' and ent.id_dep_nur = ?) t12,");

		// 在当前科室分娩的病人数量
		sb.append("(select count(*) as "
				+ columns[12]
				+ " from en_ent ent inner join en_ent_ip ip on ent.id_ent = ip.id_ent and ip.sd_status in ("
				+ inCond
				+ ") and ip.num_newborn > 0 where ent.fg_ip = 'Y' and ent.id_dep_nur = ?) t13,");

		// 当前科室的婴儿数量
		sb.append("(select count(*) as "
				+ columns[13]
				+ " from en_ent ent inner join en_ent_ip ip on ent.id_ent = ip.id_ent and ip.sd_status in ("
				+ inCond
				+ ") and ip.fg_newborn = 'Y' where ent.fg_ip = 'Y' and ent.id_dep_nur = ?) t14,");
		// 当前科室下所有使用中的床位数量
		sb.append("(select count(*) as " + columns[14]
				+ " from bd_bed bed  where bed.id_dep_belong = ? and bed.sd_bedsu in ("+ bedUseCond +") t15,");
		// 社保人数
		sb.append("(select count(*) as " + columns[15] + " from en_ent ent "
				+ "inner join en_ent_ip ip on ent.id_ent = ip.id_ent and ent.id_dep_nur = ? "
                + "and ip.sd_status in() and ent.fg_ip = 'Y' "
                + "inner join bd_hp hp on hp.id_hp = ent.id_hp and hp.sd_hptp like '1%' ) t16");

		// Sql占位参数
		SqlParam param = new SqlParam();
		for (int i = 0; i < columns.length; i++) {
			param.addParam(depId);
		}

		// 查询数据
		@SuppressWarnings("unchecked")
		Map<String, Integer> datas = (Map<String, Integer>) new DAFacade().execQuery(sb.toString(),
				param, new MapHandler());

		// 设置返回值DTO数据
		DeptCountInfoDTO dto = new DeptCountInfoDTO();
		if (null != datas && !datas.isEmpty()) {
			dto.setDate(EnAppUtils.getServerDateTime().getDate());
			dto.setTotal_num(datas.get(columns[0]));
			dto.setBed_num(datas.get(columns[1]));

			int inDeptNum = datas.get(columns[2]) + datas.get(columns[3]);
			int outDeptNum = datas.get(columns[4]) + datas.get(columns[5]) + datas.get(columns[6]);
			dto.setIn_dept_num(inDeptNum);
			dto.setOut_dept_num(outDeptNum);

			dto.setIn_hospital_num(datas.get(columns[2]));
			dto.setTurn_in_num(datas.get(columns[3]));

			dto.setOut_hospital_num(datas.get(columns[4]));
			dto.setTurn_out_num(datas.get(columns[5]));
			dto.setDied_num(datas.get(columns[6]));

			dto.setSurgery_num(datas.get(columns[7]));

			dto.setDanger_num(datas.get(columns[8]));
			dto.setSerious_num(datas.get(columns[9]));

			dto.setSpecial_care_num(datas.get(columns[10]));
			dto.setAlevel_care_num(datas.get(columns[11]));

			dto.setChild_birth_num(datas.get(columns[12]));
			dto.setBaby_num(datas.get(columns[13]));
			dto.setBed_num_use(datas.get(columns[14]));
			dto.setHp_num(datas.get(columns[15]));
		}

		return dto;
	}
}
