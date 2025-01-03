package iih.ci.ord.printmanage.srv.ord;

import java.util.Date;
import java.util.List;

import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

import com.mysql.jdbc.StringUtils;

import iih.ci.ord.printmanage.dto.CiAppOpSheetDTO;
import iih.ci.ord.printmanage.srv.CiorderPrintUtils;
import iih.ci.ord.printmanage.srv.ICiorderPrintService;

public class CiorderOpPrintService implements ICiorderPrintService<CiAppOpSheetDTO, CiAppOpSheetDTO> {

	/**
	 * 获取手术申请单数据集
	 */
	@Override
	public List<CiAppOpSheetDTO> exec(String ids) throws Exception {
		if (StringUtils.isNullOrEmpty(ids))
			return null;
		List<CiAppOpSheetDTO> ordlist = this.getOrderList(this.getOrdInfoSqlQry(ids));
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
	public List<CiAppOpSheetDTO> exec(String ids, String blstatetp) throws Exception{
		if (StringUtils.isNullOrEmpty(ids))
			return null;
		return this.exec(ids);
	}
	
	/**
	 * 拼接查询SQL
	 */
	@Override
	public String getOrdInfoSqlQry(String ids) {
		StringBuilder str = new StringBuilder();
		str.append("select ORG.Name as Name_org,");//机构名称
		str.append("PAT.Name as Name_pati,");//患者姓名
		str.append("PATSEX.Name as Gender,");//患者性别
		str.append("PAT.Dt_birth,");//患者生日
		str.append("0 as Age,");//患者年龄
		//str.append("ENT.Code as Code_en,");//住院号   
		str.append("ENTIP.CODE_AMR_IP as Code_en,");//住院号    0122273: 手术预约申请单住院号显示不全及术前诊断没有显示 住院号获取字段不正确
		str.append("UNIT.Name as Name_unit,");//病区
		str.append("ENTIP.Name_bed,");//床号
		str.append("APPOP.Str_name_di,");//术前诊断
		str.append("SRV.Name as Name_srv_op,");//手术
		str.append(" SITE.NAME as Name_site, ");//手术部位
		//0194769:	山东邹城市人民医院项目 【报表】医生站手术预约单，增加部位字段
		str.append(" CONCAT(CONCAT(CONCAT(SRV.Name, '【'), site.NAME), '】') as Name_srv_site, ");
		str.append("APPOP.Dt_plan Dt_plan_op,");//手术日期
		str.append("APPOP.Specialinstrument as Instruments,");//手术器械
		str.append("ANESTP.Name as Name_anestp,");//麻醉方式
		str.append("EMPOP.Name as Name_emp_oper,");//主刀医师
		str.append("AIDE1.Name as Name_emp_aide1,");//第一助手
		str.append("APPOP.Quan_bt_paln Quan_bt_plan,");//输血量
		str.append("EMPOR.Name Name_emp_or,");//预约医生
		str.append("SRV.Note_srv Des_or ");//备注

		str.append("from ci_ap_sug APPOP ");
		str.append("left outer join ci_order ORD on APPOP.Id_or = ORD.Id_or ");
		str.append("left outer join ci_or_srv SRV on SRV.Id_or = ORD.Id_or and SRV.Id_srv = ORD.Id_srv ");
		str.append("left outer join en_ent ENT on ORD.Id_en = ENT.Id_ent ");
		str.append("left outer join en_ent_ip ENTIP on ORD.Id_en = ENTIP.Id_ent ");
		str.append("left outer join pi_pat PAT on ORD.Id_pat = PAT.Id_pat ");
		str.append("left outer join bd_udidoc PATSEX on PAT.Id_sex = PATSEX.Id_udidoc ");
		str.append("left outer join bd_org ORG on ORG.Id_org = ORD.Id_org ");
		str.append("left outer join bd_dep UNIT on UNIT.Id_dep = ENT.Id_dep_nur ");
		str.append("left outer join bd_udidoc ANESTP on ANESTP.Id_udidoc = APPOP.Id_anestp ");
		str.append("left outer join bd_psndoc EMPOP on EMPOP.Id_psndoc = APPOP.Id_emp_operate ");
		str.append("left outer join bd_psndoc AIDE1 on AIDE1.Id_psndoc = APPOP.Id_emp_helper ");
		str.append("left outer join bd_psndoc EMPOR on ORD.Id_emp_or = EMPOR.Id_psndoc ");
		str.append(" left join BD_UDIDOC site on APPOP.ID_SURGICAL_SITE = site.ID_UDIDOC ");
		str.append("where ORD.sd_su_bl!=2 and APPOP.Id_or in (" + ids + ") order by APPOP.Sv");
		
		return str.toString();
	}

	/**
	 * 
	 */
	@Override
	public List<CiAppOpSheetDTO> getOrderList(String sqlQry) throws Exception {
		List<CiAppOpSheetDTO> result = CiorderPrintUtils.GetQueryResulte(CiAppOpSheetDTO.class, sqlQry);

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
	public List<CiAppOpSheetDTO> getItemList(String sqlQry) throws Exception {
		List<CiAppOpSheetDTO> result = CiorderPrintUtils.GetQueryResulte(CiAppOpSheetDTO.class, sqlQry);
		
		return result;
	}

	/**
	 * 
	 */
	@Override
	public void setOrdInfo(List<CiAppOpSheetDTO> dtos) throws Exception {
		for (CiAppOpSheetDTO dto : dtos) {
			// 设置年龄（格式）
			if (dto.getDt_birth() != null) {
				Date birth = new Date();
				birth = CiorderPrintUtils.ConvertStrToDate(dto.getDt_birth());
				FDate dt = new FDate(birth);
				dto.setAge(AgeCalcUtil.getAge(dt));
			}
		}
	}
}
