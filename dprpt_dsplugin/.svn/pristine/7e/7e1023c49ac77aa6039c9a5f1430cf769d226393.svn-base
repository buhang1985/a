package iih.ci.ord.printmanage.srv.ord;

import java.util.Date;
import java.util.List;

import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import iih.ci.ord.printmanage.dto.HeadDTO;
import iih.ci.ord.printmanage.srv.CiorderPrintUtils;

public class CiorderTreatPrintService extends CiorderBaseOrdPrintService {

	@Override
	public String getOrdInfoSqlQry(String ids) {
		StringBuilder selstr = new StringBuilder();
		selstr.append("select A.id_or as id_or, "
				+ "A.id_en AS id_en,"
				+ "A.Code_Or AS code,"
				+ "A.id_srvtp as id_srvtp, "// 服务
				+ "A.sd_srvtp as sd_srvtp, "
				+ "B.name as name_srv, "
				+ "A.id_unit_med as id_medu, "// 计量单位
				+ "H.name as name_medu, "
				+ "A.times_cur as times_cur, "// 数量（次数）
				+ "A.id_dep_mp as id_mp_dep, "// 执行科室
				+ "I.name as name_mp_dep, "

				+ "A.id_pat as id_pati, "// 患者信息
				+ "C.name as name_pati, "
				+ "C.dt_birth as dt_birth, "
				+ "C.id_code as idno, "
				+ "C.code_amr_oep as code_amr_oep, "
				+ "C.workunit as workunit, "
				+ "C.barcode_chis as barcode, "
				+ "C.mob as pat_tel, "
				+ "E.name as gender, "

				+ "A.id_dep_or as id_dep_or, "// 申请科室
				+ "D.name as name_dep_or, "

				+ "F.times_op as num_pv, "// 就诊次数

				+ "G.name as name_emp_or, "// 申请医生
				+ "A.dt_entry as dt_entry, "// 申请日期

				+ "J.str_name_di as str_name_di, "// 诊断明细拼接
				+ "X.name as name_grp, " + "Y.name as name_org, "

				+ "'' as Fg_hecominsur, " + "'' as Hecominsurinfo, "
				+ "A.fg_prepay as Fg_prepay, " + "A.fg_orhp as Fg_orhp, "
				+ "A.fg_vip as Fg_vip, " + "A.des_or as Des_or, A.Fg_blsettled as Fg_blsettled, ");

		String amtstr = "";
		amtstr = "(select cast(sum((case when A1.fg_bl = 'Y' and A1.Fg_Mm = 'N' then nvl(A1.Pri * A1.Quan_total_medu, 0.0) "
				+ "when A1.Fg_Mm = 'Y' then nvl(B1.Price_Pgku_Cur * B1.Quan_Cur, 0.0) else 0.0 end)) as decimal(18,2)) as amt "
				+ "from ci_or_srv A1 left outer join ci_or_srv_mm B1 ON A1.Id_Orsrv = B1.Id_Orsrv where A1.Id_Or = A.Id_Or) as amt_total ";

		if (!amtstr.equals("")) {
			selstr.append(amtstr);
		}

		String fromstr = "";
		fromstr = "from ci_order A "
				+ "left join bd_srv B on B.id_srv = A.id_srv "
				+ "left join pi_pat C on C.id_pat = A.id_pat "
				+ "left join bd_dep D on D.id_dep = A.id_dep_or "
				+ "left outer join bd_udidoc E on E.id_udidoc = C.id_sex "
				+ "left join en_ent_op F on F.id_ent = A.id_en "
				+ "left join bd_psndoc G on G.id_psndoc = A.id_emp_or "
				+ "left join bd_measdoc H on H.id_measdoc =  A.id_unit_med "
				+ "left join bd_dep I on I.id_dep = A.id_dep_mp "
				+ "left join bd_grp X on X.id_grp = A.id_grp "
				+ "left join bd_org Y on Y.id_org = A.id_org "
				+ "left join "
				+ "(select id_ent,max(Str_name_di) as Str_name_di from (select K.id_ent, wmsys.wm_concat(K.name_didef_dis) over (partition by K.id_ent order by K.Sortno) as Str_name_di "
				+ "from en_ent_di K) group by id_ent) J on J.id_ent = A.id_en";

		if (!fromstr.equals("")) {
			selstr.append(fromstr);
		}

		String wherestr = " where A.eu_orsrcmdtp not in ('0C') and (A.eu_feereversetp not in (1) or A.eu_feereversetp is null) ";
		if (ids != null && !"".equals(ids)) {

			if (wherestr != "") {
				wherestr += " and ";
			} else {
				wherestr += " where ";
			}
			wherestr += " A.id_or in (" + ids + ")";
		}

//		String sqlexec = "and not exists(select A2.id_ciapptreatexec as id_ciapptreatexec,B2.id_or as id_or "
//				+ " from ci_app_treatexec A2 "
//				+ " left join ci_app_treatexec_or B2 on B2.id_ciapptreatexec = A2.id_ciapptreatexec"
//				+ " where A2.id_en='%s' and A2.sd_apptreatexectp='%s' and B2.Id_or=A.Id_or)";
//
//		sqlexec = fg_prn.equals("N") ? String.format(sqlexec, id_en,
//				ICiorderPrintConst.SD_ORTREATEAPPEXECTP_TREAT) : "";

		if (!wherestr.equals("")) {
			selstr.append(wherestr);
		}

		String orderbystr = " order by A.dt_entry";

		if (!orderbystr.equals("")) {
			selstr.append(orderbystr);
		}

		return selstr.toString();
	}

	@Override
	public void setOrdInfo(List<HeadDTO> dtos) throws Exception {
		for (HeadDTO dto : dtos) {
			if (dto.getDt_birth() != null) {
				Date birth = new Date();
				birth = CiorderPrintUtils.ConvertStrToDate(dto.getDt_birth());
				FDate dt = new FDate(birth);
				dto.setAge(AgeCalcUtil.getAge(dt));
			}

			String strTimes = dto.getTimes_cur();
			if (strTimes == null || strTimes.length() <= 0) {
				dto.setTimes_cur("1");
			}

			String strMedu = dto.getName_medu();
			if (strMedu == null || strMedu.length() <= 0) {
				dto.setName_medu("次");
			}
		}
	}
}
