package iih.ci.ord.printmanage.srv.ord;

import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.ci.ord.printmanage.dto.CiAppBuSheetDTO;
import iih.ci.ord.printmanage.srv.CiorderPrintUtils;
import iih.ci.ord.printmanage.srv.ICiorderPrintConst;
import iih.ci.ord.printmanage.srv.ICiorderPrintService;

/**
 * 取血申请单打印服务
 * @author Young
 *
 */
public class CiorderBuPrintService implements ICiorderPrintService<CiAppBuSheetDTO, CiAppBuSheetDTO> {
	
	protected String Bl_State = ICiorderPrintConst.BLSTATE_UNPAID;
	
	/**
	 * 获取取血申请单数据集
	 */
	@Override
	public List<CiAppBuSheetDTO> exec(String ids) throws Exception {
		if (StringUtils.isNullOrEmpty(ids))
			return null;
		List<CiAppBuSheetDTO> ordlist = this.getOrderList(this.getOrdInfoSqlQry(ids));
		if (ordlist == null || ordlist.size() == 0)
			return null;
		this.setOrdInfo(ordlist);
		return ordlist;
	}
	
	/**
	 * 执行查询
	 * @param ids
	 * @param blstatetp
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<CiAppBuSheetDTO> exec(String ids, String blstatetp) throws Exception{
		if (StringUtils.isNullOrEmpty(ids))
			return null;
		this.Bl_State = blstatetp;
		return this.exec(ids);
	}

	/**
	 * 拼接查询SQL
	 */
	@Override
	public String getOrdInfoSqlQry(String ids) {
		StringBuilder str = new StringBuilder();
		str.append("select APPBU.Id_or,");
		str.append("PAT.Name as Name_pati,");
		str.append("PAT_SEX.Name as Gender,");
		str.append("GRP.Name as Name_grp,");
		str.append("ORG.Name as Name_org,");
		str.append("ENT.Code as Code_en,");
		str.append("'QX'||APPBU.Code_app_bu as Code_app_bu,");
		str.append("APPBU.Code_app_bt,");
		str.append("ORSRV.Quan_medu as Quan_medu_bu,");
		str.append("ORSRV.Name as Name_blootp,");
		str.append("APPBLOOTP.Name as Name_app_bloodtype,");
		str.append("RHD.Name as Name_app_rhd,");
		str.append("APPBU.Quan_medu_bu,");
		str.append("MEASDOC.Name as Name_medu_unit,");
		str.append("APPBU.Dt_pl_bu,");
		str.append("PSNDOC.Name as Name_emp_bu,");
		str.append("APPBU.Applydoctortel ");

		str.append("from ci_app_bu APPBU ");
		str.append("left outer join ci_order ORD on APPBU.Id_or = ORD.Id_or ");
		str.append("left outer join ci_or_srv ORSRV on APPBU.Id_or = ORSRV.Id_or and ORSRV.Id_srv = ORD.Id_srv ");
		str.append("left outer join pi_pat PAT on APPBU.Id_pat = PAT.Id_pat ");
		str.append("left outer join bd_udidoc PAT_SEX on PAT.Id_sex = PAT_SEX.Id_udidoc ");
		str.append("left outer join bd_grp GRP on GRP.Id_grp = APPBU.Id_grp ");
		str.append("left outer join bd_org ORG on ORG.Id_org = APPBU.Id_org ");
		str.append("left outer join en_ent ENT on APPBU.Id_en = ENT.Id_ent ");
		str.append("left outer join bd_udidoc BLOOTP on APPBU.Id_blootp = BLOOTP.Id_udidoc ");
		str.append("left outer join bd_udidoc APPBLOOTP on APPBU.Id_app_bloodtype = APPBLOOTP.Id_udidoc ");
		str.append("left outer join bd_udidoc RHD on APPBU.Id_app_rhd = RHD.Id_udidoc ");
		str.append("left outer join bd_measdoc MEASDOC on ORSRV.Id_medu = MEASDOC.Id_measdoc ");
		str.append("left outer join bd_psndoc PSNDOC on APPBU.Id_emp_bu = PSNDOC.Id_psndoc ");

		str.append("where ORD.sd_su_bl!=2 and APPBU.Id_or in (" + ids + ")  order by APPBU.Sv");
		
		return str.toString();
	}

	/**
	 * 
	 */
	@Override
	public List<CiAppBuSheetDTO> getOrderList(String sqlQry) throws Exception {
		List<CiAppBuSheetDTO> result = CiorderPrintUtils.GetQueryResulte(CiAppBuSheetDTO.class, sqlQry);

		return result;
	}

	/**
	 * 
	 */
	@Override
	public String getItmInfoSqlQry(String id) {
		return "";
	}
	
	@Override
	public List<CiAppBuSheetDTO> getItemList(String sqlQry) throws Exception {
		List<CiAppBuSheetDTO> result = CiorderPrintUtils.GetQueryResulte(CiAppBuSheetDTO.class, sqlQry);
		
		return result;
	}

	/**
	 * 
	 */
	@Override
	public void setOrdInfo(List<CiAppBuSheetDTO> dtos) throws Exception {

	}
}
