package iih.en.pv.deptcountinfo;

import java.util.List;

import com.sun.rowset.CachedRowSetImpl;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 病区统计信息打印模板DTO查询服务
 * 
 * @author jizb
 * @date 
 *
 */
public class DeptCountInfoService {
	/**
	 * 获取病区统计信息
	 * 
	 * @param depId
	 * @return
	 * @throws BizException
	 * @author jizb
	 */
	public DeptCountInfoDTO[] exec(String depId) throws Exception {

		// 查询数据列字段别名
		String[] columns = { "total_num", "bed_num", "in_hospital_num", "turn_in_num", "out_hospital_num",
				"turn_out_num", "died_num", "surgery_num", "danger_num", "serious_num",
				"special_care_num", "alevel_care_num", "child_birth_num", "baby_num", "bed_num_use",
				"hp_num", "bed_num_rend", "bed_num_hold"};

		// 入院和入科
		String inCond = "'25'";
		// 出院
		String outCond = "'28'";
		//使用中床位
		String bedUseCond = "'1', '2', '3'";

		// 组装查询SQL
		StringBuilder sb = new StringBuilder();
		sb.append("select * from ");

		// 当前科室或病区的所有病人
		sb.append("(select count(*) as "
				+ columns[0]
				+ " from en_ent ent inner join en_ent_ip ip on ent.id_ent = ip.id_ent and ent.id_dep_nur = '" + depId + "' and ip.sd_status in ("
				+ inCond + ") and ent.fg_ip = 'Y' and ip.fg_newborn <> 'Y') t1,");

		// 当前科室下的所有床位数量
		sb.append("(select count(*) as " + columns[1]
				+ " from bd_bed bed  where bed.id_dep_belong = '" + depId + "') t2,");

		// 当天 入院 并且 入院科室为当前科室的病人数量
		sb.append("(select count(*) as "
				+ columns[2]
				+ " from en_ent ent inner join en_ent_ip ip on ent.id_ent = ip.id_ent and ent.id_dep_nur = '" + depId + "' and ip.sd_status in ("
				+ inCond
				+ ") and ent.fg_ip = 'Y' and substr(ent.dt_acpt,0,10) = to_char(sysdate,'YYYY-MM-dd')) t3,");

		// 当天转入当前科室的病人数量
		sb.append("(select count(distinct ent.id_ent) as "
				+ columns[3]
				+ " from en_ent ent inner join en_ent_dep dep on ent.id_ent = dep.id_ent "
				+ " where dep.id_dep_to = '" + depId + "' and substr(dep.dt_b,0,10) = to_char(sysdate,'YYYY-MM-dd')) t4,");

		// 当天 出院 并且 出院科室为当前科室的病人数量
		sb.append("(select count(*) as "
				+ columns[4]
				+ " from en_ent ent inner join en_ent_ip ip on ent.id_ent = ip.id_ent and ent.id_dep_nur = '" + depId + "' and ip.sd_status = "
				+ outCond
				+ " and ip.fg_newborn = 'N' and substr(ent.dt_end,0,10) = to_char(sysdate,'YYYY-MM-dd')) t5,");

		// 当天转出当前科室的病人数量
		sb.append("(select count(*) as "
				+ columns[5]
				+ " from en_ent ent inner join en_ent_dep dep on ent.id_ent = dep.id_ent"
				+ " where dep.id_dep_from = '" + depId + "' and substr(dep.dt_b,0,10) = to_char(sysdate,'YYYY-MM-dd')) t6,");

		// 当天在当前科室 死亡的病人数量
		sb.append("(select count(*) as "
				+ columns[6]
				+ " from en_ent ent inner join en_ent_ip ip on ip.id_ent = ent.id_ent where ip.sd_outcomes = '"
				+ "3"
				+ "' and ip.id_dep_phydisc = '" + depId + "' and substr(ent.dt_end,0,10) = to_char(sysdate,'YYYY-MM-dd')) t7,");

		// 当天 在当前科室 进行手术的病人数量
		sb.append("(select count(*) as "
				+ columns[7]
				+ " from en_ent ent inner join en_ent_ip ip on ent.id_ent = ip.id_ent and ip.sd_status in ("
				+ inCond
				+ ") and ent.fg_ip = 'Y' inner join en_ent_state stt on stt.id_ent = ent.id_ent and stt.id_enstatetp='"
				+ "@@@@AA1000000008FO3Q" + "' and stt.val = '"
				+ "1" + "' where ent.id_dep_nur = '" + depId + "') t8,");

		// 当天 当前科室下病情为病危的病人数量
		sb.append("(select count(*) as "
				+ columns[8]
				+ " from en_ent ent inner join en_ent_ip ip on ent.id_ent = ip.id_ent and ip.sd_status in ("
				+ inCond
				+ ") inner join en_ent_state stt on stt.id_ent = ent.id_ent and stt.id_enstatetp='"
				+ "@@@@AA1000000008FO3Y" + "' and stt.val = '"
				+ "00"
				+ "' where ent.fg_ip = 'Y' and ent.id_dep_nur = '" + depId + "') t9,");

		// 当天 当前科室下病情为病重的病人数量
		sb.append("(select count(*) as "
				+ columns[9]
				+ " from en_ent ent inner join en_ent_ip ip on ent.id_ent = ip.id_ent and ip.sd_status in ("
				+ inCond
				+ ") inner join en_ent_state stt on stt.id_ent = ent.id_ent and stt.id_enstatetp='"
				+ "@@@@AA1000000008FO3Y" + "' and stt.val = '"
				+ "01"
				+ "' where ent.fg_ip = 'Y' and ent.id_dep_nur = '" + depId + "') t10,");

		// 在当前科室下，护理等级为特级护理的病人数量
		sb.append("(select count(*) as "
				+ columns[10]
				+ " from en_ent ent inner join en_ent_ip ip on ent.id_ent = ip.id_ent and ip.sd_status in ("
				+ inCond
				+ ") inner join en_ent_state stt on stt.id_ent = ent.id_ent and stt.id_enstatetp = '"
				+ "@@@@AA1000000008FO40" + "'and stt.val = '"
				+ "00"
				+ "' where ent.fg_ip = 'Y' and ent.id_dep_nur = '" + depId + "') t11,");

		// 在当期科室下，护理等级为一级护理的病人数量
		sb.append("(select count(*) as "
				+ columns[11]
				+ " from en_ent ent inner join en_ent_ip ip on ent.id_ent = ip.id_ent and ip.sd_status in ("
				+ inCond
				+ ") inner join en_ent_state stt on stt.id_ent = ent.id_ent and stt.id_enstatetp = '"
				+ "@@@@AA1000000008FO40" + "'and stt.val = '"
				+ "01"
				+ "' where ent.fg_ip = 'Y' and ent.id_dep_nur = '" + depId + "') t12,");

		// 在当前科室分娩的病人数量
		sb.append("(select count(*) as "
				+ columns[12]
				+ " from en_ent ent inner join en_ent_ip ip on ent.id_ent = ip.id_ent and ip.sd_status in ("
				+ inCond
				+ ") and ip.num_newborn > 0 where ent.fg_ip = 'Y' and ent.id_dep_nur = '" + depId + "') t13,");

		// 当前科室的婴儿数量
		sb.append("(select count(*) as "
				+ columns[13]
				+ " from en_ent ent inner join en_ent_ip ip on ent.id_ent = ip.id_ent and ip.sd_status in ("
				+ inCond
				+ ") and ip.fg_newborn = 'Y' where ent.fg_ip = 'Y' and ent.id_dep_nur = '" + depId + "') t14,");
		// 当前科室下所有使用中的床位数量
		sb.append("(select count(*) as " + columns[14]
				+ " from bd_bed bed  where bed.id_dep_belong = '" + depId + "' and bed.sd_bedsu in ('1')) t15,");
		// 社保人数
		sb.append("(select count(*) as " + columns[15] + " from en_ent ent "
				+ "inner join en_ent_ip ip on ent.id_ent = ip.id_ent and ent.id_dep_nur = '" + depId + "' "
                + "and ip.sd_status in(" + inCond + ") and ent.fg_ip = 'Y' "
                + "inner join bd_hp hp on hp.id_hp = ent.id_hp and hp.sd_hptp like '1%' ) t16,");
		// 当前科室下包床数量
				sb.append("(select count(*) as " + columns[16]
						+ " from bd_bed bed  where bed.id_dep_belong = '" + depId + "' and bed.sd_bedsu in ('2')) t17,");
		// 当前科室下入院占用床位数量
		sb.append("(select count(*) as " + columns[17]
				+ " from bd_bed bed  where bed.id_dep_belong = '" + depId + "' and bed.sd_bedsu in ('3')) t18");
		
		// 查询数据
		SqlReader sql_rdr = new SqlReader(null, sb.toString());
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(DeptCountInfoDTO.class);
		@SuppressWarnings("unchecked")
		List<DeptCountInfoDTO> datas = (List<DeptCountInfoDTO>) beanlist_handler
				.processRs(cached_rs);
		sql_rdr.destroy();

		// 设置返回值DTO数据
//		DeptCountInfoDTO dto = new DeptCountInfoDTO();
//		if (null != datas && !datas.isEmpty()) {
//			dto.setTotal_num(datas.get(columns[0]));
//			dto.setBed_num(datas.get(columns[1]));
//
//			int inDeptNum = datas.get(columns[2]) + datas.get(columns[3]);
//			int outDeptNum = datas.get(columns[4]) + datas.get(columns[5]) + datas.get(columns[6]);
//			dto.setIn_dept_num(inDeptNum);
//			dto.setOut_dept_num(outDeptNum);
//
//			dto.setIn_hospital_num(datas.get(columns[2]));
//			dto.setTurn_in_num(datas.get(columns[3]));
//
//			dto.setOut_hospital_num(datas.get(columns[4]));
//			dto.setTurn_out_num(datas.get(columns[5]));
//			dto.setDied_num(datas.get(columns[6]));
//
//			dto.setSurgery_num(datas.get(columns[7]));
//
//			dto.setDanger_num(datas.get(columns[8]));
//			dto.setSerious_num(datas.get(columns[9]));
//
//			dto.setSpecial_care_num(datas.get(columns[10]));
//			dto.setAlevel_care_num(datas.get(columns[11]));
//
//			dto.setChild_birth_num(datas.get(columns[12]));
//			dto.setBaby_num(datas.get(columns[13]));
//			dto.setBed_num_use(datas.get(columns[14]));
//			dto.setHp_num(datas.get(columns[15]));
//		}
		if(null == datas || datas.size() <= 0){
			return null;
		}
		return datas.toArray(new DeptCountInfoDTO[]{});
	}
}
