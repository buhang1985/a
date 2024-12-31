package iih.ci.ord.printmanage.srv;

import iih.ci.ord.printmanage.dto.OutExecPrintHeadDTO;
import iih.ci.ord.printmanage.dto.OutExecPrintItemDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

import com.mysql.jdbc.StringUtils;

public class OutExecPrintService {

	public List<OutExecPrintHeadDTO> exec(String ids) throws Exception {
		if (StringUtils.isNullOrEmpty(ids))
			return null;
		//患者就诊信息查询
		List<OutExecPrintHeadDTO> headDTOs = this.getOrderList(this.getOrdInfoSqlQry(ids));

		List<OutExecPrintItemDTO> itemDTOs = this.getItemList(this.getItmInfoSqlQry(ids));

		if (headDTOs == null || headDTOs.size() == 0)
			return null;
		Map<String, List<OutExecPrintItemDTO>> maps = new HashMap<String, List<OutExecPrintItemDTO>>();
		for (OutExecPrintItemDTO dto : itemDTOs) {
			dto.setAmount(dto.getPri() == null || dto.getQuan_total_medu() == null ? 
					null : dto.getPri().multiply(dto.getQuan_total_medu()));
			if (maps.containsKey(dto.getId_or())) {
				maps.get(dto.getId_or()).add(dto);
			} else {
				List<OutExecPrintItemDTO> lst = new ArrayList<OutExecPrintItemDTO>();
				lst.add(dto);
				maps.put(dto.getId_or(), lst);
			}
		}

		for (int i = 0; i < headDTOs.size(); i++) {
			headDTOs.get(i).setItemdtolist(maps.get(headDTOs.get(i).getId_or()));
			if (headDTOs.get(i).getDt_birth() != null) {
				Date birth = new Date();
				birth = CiorderPrintUtils.ConvertStrToDate(headDTOs.get(i).getDt_birth());
				FDate dt = new FDate(birth);
				headDTOs.get(i).setAge(AgeCalcUtil.getAge(dt));
			}
		}

		return headDTOs;
	}
	
	private List<OutExecPrintHeadDTO> getOrderList(String sqlQry) throws Exception {
		List<OutExecPrintHeadDTO> result = CiorderPrintUtils.GetQueryResulte(OutExecPrintHeadDTO.class, sqlQry);
		return result;
	}

	private List<OutExecPrintItemDTO> getItemList(String sqlQry) throws Exception {
		List<OutExecPrintItemDTO> result = CiorderPrintUtils.GetQueryResulte(OutExecPrintItemDTO.class, sqlQry);
		return result;
	}
	
	private String getOrdInfoSqlQry(String ids) {
		StringBuilder str = new StringBuilder();
		str.append("select CIORD.Id_org as Id_org,");
		str.append("ORG.Name as Name_org,");
		str.append("CIORD.Id_or as Id_or,");
		str.append("CIORD.Id_pat as Id_pati,");
		str.append("PI_PAT.Name as Name_pati,");
		str.append("PI_PAT.Dt_Birth,");
		str.append("CIORD.Id_en,");
		str.append("ENT_IP.Code_amr_ip as Code_en,");
		str.append("ENT_IP.Name_bed as Code_bed,");
		str.append("DEP_OR.Name as Name_dep_or,");
		str.append("DEP_MP.Name as Name_dep_mp ");
		
		str.append("from ci_order CIORD ");
		str.append("left join bd_org ORG on ORG.id_org = CIORD.id_org ");
		str.append("left join pi_pat PI_PAT on CIORD.Id_pat = PI_PAT.Id_pat ");
		str.append("left join en_ent_ip ENT_IP on CIORD.Id_en = ENT_IP.Id_ent ");
		str.append("left join bd_dep DEP_MP on CIORD.Id_dep_mp = DEP_MP.Id_dep ");
		str.append("left join bd_dep DEP_OR on CIORD.Id_dep_or = DEP_OR.Id_dep ");
		
		String wherestr = "";
		if (!StringUtils.isNullOrEmpty(ids)) {

			if (wherestr.length() > 0) {
				wherestr += " and ";
			} else {
				wherestr += " where ";
			}
			wherestr += " CIORD.Id_or in (" + ids + ") order by CIORD.Id_en,CIORD.Dt_chk desc";
		}
		str.append(wherestr);
		return str.toString();
	}

	private String getItmInfoSqlQry(String ids) {
		StringBuilder str = new StringBuilder();
		str.append("select ORSRV.Id_or,");
		str.append("ORSRV.Id_Srv,");
		str.append("BDSRV.Name as Name_srv,");
		str.append("ORSRV.Quan_medu as Quan_total_medu,");
		str.append("(case ORSRV.Fg_mm when 'Y' then MEASDOC1.Name else MEASDOC.Name end)as Name_medu,");
		str.append("(case ORSRV.Fg_mm when 'Y' then SRVMM.Price_pgku_cur else ORSRV.Pri end)as Pri,");
		str.append("SUBLDOC.Name as Name_su_bl ");
		
		str.append("from ci_or_srv ORSRV ");
		str.append("left join bd_srv BDSRV on ORSRV.Id_srv=BDSRV.Id_srv ");
		str.append("left join ci_or_srv_mm SRVMM on ORSRV.Id_orsrv=SRVMM.Id_orsrv ");
		str.append("left join bd_mm BDMM ON SRVMM.Id_mm=BDMM.Id_mm ");
		str.append("left join bd_measdoc MEASDOC on ORSRV.Id_Medu = MEASDOC.Id_measdoc ");
		str.append("left join bd_measdoc MEASDOC1 on SRVMM.Id_pgku_cur = MEASDOC1.Id_measdoc ");
		str.append("left join bd_udidoc SUBLDOC on ORSRV.Id_su_bl = SUBLDOC.Id_udidoc ");
		
		String wherestr = "";
		if (!StringUtils.isNullOrEmpty(ids)) {

			if (wherestr.length() > 0) {
				wherestr += " and ";
			} else {
				wherestr += " where ";
			}
			wherestr += " ORSRV.Id_or in (" + ids + ") order by ORSRV.Id_or,ORSRV.Sortno";
		}
		str.append(wherestr);
		return str.toString();
	}
}
