package iih.ci.ord.printmanage.srv.ord;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

import iih.ci.ord.printmanage.common.CiOrderPrintDiagService;
import iih.ci.ord.printmanage.dto.CiAppHocSheetDTO;
import iih.ci.ord.printmanage.srv.CiorderPrintUtils;
import xap.dp.report.data.reader.sqlqryutil.RptQryUtil;
import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

/**
 * @code 高压氧申请单打印
 * @author LiYue
 * @date 2020年3月9日,下午4:27:51
 */
public class CiAppHocPrintService {
	public List<CiAppHocSheetDTO> exec(String ids){
		if(StringUtils.isEmpty(ids)) return null;
		
		// 查库
		String strSql = getSql(ids);
		CiAppHocSheetDTO[] resultArr = RptQryUtil.qryRptBeansArr( strSql, null, CiAppHocSheetDTO.class);
		if(resultArr==null && resultArr.length<=0) return null;
		// 数据重组
		recom(resultArr);
		// 数组转List
		List<CiAppHocSheetDTO> resyltList = new ArrayList<>(resultArr.length);
		Collections.addAll(resyltList, resultArr);
		return resyltList;
	}

	private void recom(CiAppHocSheetDTO[] resultArr) {
		for (CiAppHocSheetDTO ciAppHocSheetDTO : resultArr) {
			// 设置年龄（格式）
			if (ciAppHocSheetDTO.getDt_birth() != null) {
				Date birth = new Date();
				try {
					birth = CiorderPrintUtils.ConvertStrToDate(ciAppHocSheetDTO.getDt_birth());
				} catch (ParseException e) {
				}
				FDate dt = new FDate(birth);
				ciAppHocSheetDTO.setAge(AgeCalcUtil.getAge(dt));
			}
			
			// 设置诊断
			CiOrderPrintDiagService diag = new CiOrderPrintDiagService();
			try {
				ciAppHocSheetDTO.setDiag(diag.exec(ciAppHocSheetDTO.getId_en()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	private String getSql(String ids) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select DISTINCT org.NAME Name_org, ");
		sb.append(" pat.name Name_pat, ");
		sb.append(" sex.name Name_sex, ");
		sb.append(" pat.DT_BIRTH, ");
		sb.append(" 0 as Age, ");
		sb.append(" ord.id_en, ");
		sb.append(" dep.name Name_dep, ");
		sb.append(" enip.NAME_BED bednum, ");
		sb.append(" enip.Code_amr_ip code_ip, ");
		sb.append(" picard.code code_op, ");
		sb.append(" ord.code_or code_or, ");
		sb.append(" ord.DES_OR DES, ");
		sb.append(" di_itm.ID_DIDEF_NAME Subjective, ");
		sb.append(" hoc.des_sympsign , ");
		sb.append(" '' as diag, ");
		sb.append(" sln.name Name_sln,  ");
		sb.append(" sln.num_press, ");
		sb.append(" sln.mint_press, ");
		sb.append(" sln.mint_oxinh, ");
		sb.append(" sln.times_oxinh, ");
		sb.append(" sln.mint_rest, ");
		sb.append(" sln.times_rest, ");
		sb.append(" sln.mint_dpress, ");
		sb.append(" sln.total_time, ");
		sb.append(" sln.note, ");
		sb.append(" way_oxinh.name Name_way_oxinh, ");
		sb.append(" cbnseat_pos.name Name_cbnseat_pos, ");
		sb.append(" psn.name Name_doc, ");
		sb.append(" ord.dt_sign ");
		sb.append(" from ci_order ord ");
		sb.append(" left JOIN bd_org org on ord.id_org = org.id_org ");
		sb.append(" left JOIN en_ent en on en.ID_ENT = ORD.ID_EN ");
		sb.append(" left JOIN en_ent_ip enip on enip.id_ent = ord.id_en  ");
		sb.append(" left JOIN pi_pat pat on en.ID_PAT = pat.ID_PAT ");
		sb.append(" left JOIN bd_udidoc sex on pat.id_sex = sex.id_udidoc ");
		sb.append(" left JOIN ci_or_srv srv on srv.id_srv = ord.id_srv ");
		sb.append(" left JOIN bd_dep dep on ord.id_dep_or = dep.id_dep ");
		sb.append(" left JOIN pi_pat_card picard on picard.id_pat = PAT.Id_pat and picard.fg_def='Y' and picard.fg_act='Y'  ");
		sb.append(" left JOIN ci_ap_hoc hoc on hoc.id_or = ord.id_or ");
		sb.append(" left JOIN ci_di_itm di_itm on di_itm.ID_DI = hoc.id_di and di_itm.fg_majdi ='Y' ");
		sb.append(" left JOIN HOC_SLN sln on sln.ID_HOC_SLN = hoc.ID_HOC_SLN ");
		sb.append(" left JOIN bd_udidoc way_oxinh on way_oxinh.id_udidoc = hoc.ID_WAY_OXINH ");
		sb.append(" left JOIN bd_udidoc cbnseat_pos on cbnseat_pos.id_udidoc = hoc.id_cbnseat_pos ");
		sb.append(" left JOIN bd_psndoc psn on psn.id_psndoc = ord.id_emp_sign ");
		sb.append(String.format(" where ord.id_or in (%s) ", ids));
		return sb.toString();
	}

}
