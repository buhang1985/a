package iih.ci.ord.printmanage.srv.ord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.mysql.jdbc.StringUtils;
import iih.ci.ord.printmanage.dto.HeadDTO;
import iih.ci.ord.printmanage.dto.ItemDTO;
import iih.ci.ord.printmanage.dto.UtilsDTO;
import iih.ci.ord.printmanage.srv.CiorderPrintUtils;
import xap.mw.coreitf.d.FDouble;

/** 
 * 南大检验导引单
 * @code 
 * @author LiYue
 * @date 2019年4月25日,下午7:43:30
 */
public class CiorderGuideLisPrintService  extends CiorderBaseOrdPrintService {

	@Override
	public List<HeadDTO> exec(String ids) throws Exception {
		if (StringUtils.isNullOrEmpty(ids))return null;
		//获取检验申请单打印数据ID集合
		String strIdciapplissheets=getIDciapplissheets(ids);
		if(StringUtils.isNullOrEmpty(strIdciapplissheets))return null;
		//患者就诊信息查询
		List<HeadDTO> headDTOs = this.getOrderList(this.getOrdInfoSqlQry(strIdciapplissheets));
		
		List<ItemDTO> itemDTOs = this.getItemList(this.getItmInfoSqlQry(strIdciapplissheets));
		//筛选拼接注意事项
		String announcements = getAnnouncementsSql(itemDTOs.get(0).getInnercode());
		
		//新数据组合
		List<HeadDTO> headDTOlist = new ArrayList<>();
		List<ItemDTO> itemDTOlist = new ArrayList<>() ;

		Map<String,List<ItemDTO>> maps=new HashMap<String,List<ItemDTO>>();
		for(ItemDTO dto:itemDTOs){
			if(maps.containsKey(dto.getId_ciapplissheet())){
				maps.get(dto.getId_ciapplissheet()).add(dto);
			}
			else{
				List<ItemDTO> lst=new ArrayList<ItemDTO>();
				lst.add(dto);
				maps.put(dto.getId_ciapplissheet(), lst);
			}
		}
		/**
		 * 总金额
		 */
		FDouble pri = FDouble.ZERO_DBL;
		for (List<ItemDTO> DTOlist : maps.values()) {
			ItemDTO dto = new ItemDTO();
			for (ItemDTO itemDTO : DTOlist) {
				
				if(StringUtils.isNullOrEmpty(dto.getName_srv())){
					dto.setName_srv(itemDTO.getName_srv());//名称拼接
					dto.setAmount(itemDTO.getAmount());//金额叠加
					pri = pri.add(itemDTO.getAmount());//总金额叠加
					dto.setName_samptp(itemDTO.getName_samptp());//标本类型
					dto.setAnnouncements(announcements);//注意
					dto.setName_dep_mp(itemDTO.getName_dep_mp());//执行科室
					dto.setId_ciapplissheet(itemDTO.getId_ciapplissheet());
				}else
				{
					dto.setName_srv(dto.getName_srv()+" + "+itemDTO.getName_srv());
					dto.setAmount(dto.getAmount().add(itemDTO.getAmount()));
					pri = pri.add(itemDTO.getAmount());//总金额叠加
				}
			}
			itemDTOlist.add(dto);
		}
		
		if(headDTOs == null || headDTOs.size() == 0)return null;
		
		headDTOlist.add(headDTOs.get(0));
		for (HeadDTO headDTO : headDTOs) {
			headDTOlist.get(0).setAmt_total(pri);
		}
		
		this.setOrdInfo(headDTOlist);
		for(int i = 0; i < headDTOlist.size(); i++){
		//	headDTOs.get(i).setItemdtolist(maps.get(headDTOs.get(i).getId_ciapplissheet()));
			headDTOs.get(i).setItemdtolist(itemDTOlist);
			if (headDTOs.get(i).getSd_sampcollecttimetp() == "0101") {
				headDTOs.get(i).setName_sampcoltime("");
			} else {
				String name = headDTOs.get(i).getName_sampcoltime();
				if (name != null && !("").equals(name)) {
					headDTOs.get(i).setName_sampcoltime("建议执行时间：" + name);
				}
			}
			if("Y".equals(headDTOs.get(i).getFg_specill())){
				headDTOs.get(i).setFg_orhp("N");
			}
			headDTOs.get(i).setDataMatrix(this.getQRCodeById_or(ids));
		//	headDTOs.get(i).setAmt_total(pri);
		}
		
		
		
		return headDTOlist;
	}
	
	public String getAnnouncementsSql(String id_srvca)throws Exception{
		String name = "";
		String str = "select name as Announcements "
				+ "from ( "
				+ "select ca.lv, min(lv) over () minlv, notice.NAME "
				+ "from BD_NOTICE notice "
				+ "inner join ( "
				+ "select LEVEL lv, srvca.ID_SRVCA, srvca.NAME, srvca.INNERCODE "
				+ "from bd_srvca srvca "
				+ "start with srvca.ID_SRVCA = '"+id_srvca+"' "
				+ "connect by srvca.ID_SRVCA = prior srvca.ID_PARENT "
				+ "order by LEVEL)  ca on notice.ID_SRVCA = ca.ID_SRVCA) "
				+ "where lv = minlv ";
		List<ItemDTO> dtos = CiorderPrintUtils.GetQueryResulte(ItemDTO.class, str);
		for(ItemDTO dto:dtos){
			name += dto.getAnnouncements()+",";
		}
		return name.substring(0,name.length()-1);
	}

	@Override
	public String getOrdInfoSqlQry(String ids) {
		StringBuilder str = new StringBuilder();
		str.append("select PI_PAT.Id_pat as Id_pati,");
		str.append("PI_PAT.Name as Name_pati,");
		str.append("PI_PAT.code as Code_pat,");
		str.append("PI_PAT.Dt_Birth,");
		str.append("PI_PAT.Workunit,");
		str.append("PI_PAT.Code_amr_oep,");
		str.append("(case APP_LIS.Code_entp when '10' then ENT_IP.code_amr_ip else PI_PAT.code end) as Barcode,");
		str.append("ENTHP.No_hp as HpCode,");//医保卡号
		str.append("picard.code as PiCardCode,");//患者的就诊卡卡号
		str.append("PI_PAT_SEX.Name as Gender,");
		str.append("APP_LIS.Id_en,");
		str.append("APP_LIS.Id_entp,");
		str.append("APP_LIS.Code_entp,");
		str.append("ENT_OP.Times_op as Num_pv,");

		str.append("APP_LIS.Id_ciapplissheet,");
		str.append("APP_LIS.Code_app as code,");
		str.append("APP_LIS.Name_app,");
		str.append("DEP_MP.Name as Name_mp_dep,");
		str.append("DEP_MP.id_plc as Guidance, ");//导引信息
		str.append("EMP_APP.Name as Name_emp_or,");
		str.append("DEP_APP.Name as Name_dep_or,");
		str.append("APP_LIS.Dt_app as Dt_entry,");
		str.append("APP_LIS.Announcements,");
		str.append("APP_LIS.Amt_app_total as Amt_total,");

		str.append("APP_LIS.Fg_opspecial as fg_special,");
		str.append("APP_LIS.Id_sampcoltime,");
		str.append("APP_LIS.Sd_sampcollecttimetp,");
		str.append("SAMPCOL.Name as Name_sampcoltime,");
		str.append("APP_LIS.Fg_hecominsur,");
		str.append("APP_LIS.Hecominsurinfo,");
		str.append("APP_LIS.Researchinfo as Name_research,");
		str.append("APP_LIS.Fg_prepay,");
		str.append("APP_LIS.Fg_lishp as Fg_orhp,");
		str.append("APP_LIS.Fg_vip,");
		str.append("APP_LIS.Fg_blsettled,");
		str.append("APP_LIS.Fg_specill,");
		str.append("GRP.Name as Name_grp,");
		str.append("ORG.Name as Name_org,");
		str.append("ORG.ENName as Name_org_en, ");//增加组织英文字段
		str.append("ORG.Shortname as Name_org_short,");//机构简称
		//兰陵人民需求，检验、检查添加加急标识
		str.append("APP_LIS.fg_urgent as fg_urgent,");
		//郑州骨伤需求，检验、检查增加显示住院号
		str.append("PI_PAT.Code_amr_ip as Code_amr_ip,");
		//郑州骨伤需求，检验增加显示诊断信息
		str.append("APP_LIS.Str_name_di as Str_name_di,");
		//郑州骨伤需求，检验增加显示床号
		str.append("ENT_IP.NAME_BED as Bed_num, ");
		//病区
		str.append("dep_nur.name as Unit ");

		str.append("from      ci_app_lis      APP_LIS ");
		
		//郑州骨伤需求，检验增加显示床号
		str.append("left join en_ent_ip ENT_IP on  ENT_IP.Id_Ent=APP_LIS.Id_En ");
		str.append("left join pi_pat          PI_PAT     on APP_LIS.Id_Pat = PI_PAT.Id_Pat ");
		str.append("left join en_ent_op       ENT_OP     on APP_LIS.Id_En = ENT_OP.Id_Ent ");
		str.append("left outer join en_ent_hp ENTHP on APP_LIS.Id_en = ENTHP.Id_ent ");
		str.append("left join bd_udidoc       PI_PAT_SEX on PI_PAT.Id_Sex = PI_PAT_SEX.Id_Udidoc ");
		str.append("left join bd_dep          DEP_MP     on APP_LIS.Id_Dep_Mp = DEP_MP.Id_Dep ");
		str.append("left join bd_dep          DEP_APP    on APP_LIS.Id_Dep_App = DEP_APP.Id_Dep ");
		str.append("left join bd_psndoc       EMP_APP    on APP_LIS.Id_Emp_App = EMP_APP.Id_Psndoc ");
		str.append("left join bd_grp          GRP        on GRP.id_grp = APP_LIS.Id_group ");
		str.append("left join bd_org          ORG        on ORG.id_org = APP_LIS.id_org ");
		str.append("left join bd_sampcol_time SAMPCOL    on APP_LIS.Id_sampcoltime = SAMPCOL.Id_sampcollecttime ");
		str.append("left join bd_dep          dep_nur    on dep_nur.id_dep = ent_ip.id_dep_nuradm ");
		str.append("left join pi_pat_card picard on picard.id_pat = PI_PAT.Id_pat and picard.fg_def='Y' and picard.fg_act='Y' ");//患者的就诊卡
		String wherestr = "";
		if (!StringUtils.isNullOrEmpty(ids)) {

			if (wherestr.length() > 0) {
				wherestr += " and ";
			} else {
				wherestr += " where ";
			}
			wherestr += " APP_LIS.Id_ciapplissheet in (" + ids + ") ";//+CiorderPrintUtils.GetBlStatetpStr(this.Bl_State, "APP_LIS");
		}
		str.append(wherestr);
		return str.toString();
	}

	@Override
	public String getItmInfoSqlQry(String ids) {
		StringBuilder str = new StringBuilder();
		str.append("select APP_LIS_OR.Id_ciapplissheet,");
//		str.append("APP_LIS_OR.Id_Or,");
		str.append("UDIDOC.Name as name_samptp,");
//		str.append("nvl(NOTICE.NAME,NOTICESUP.NAME) AS Announcements, ");
		str.append("srvca.id_srvca as Innercode,");
//		str.append("ORD.Id_Srv,");
//		str.append("ORD.Id_Dep_Mp,");
		str.append("SRV.Name as name_srv,");
		str.append("(case SRV.Code when '691143' then '此项目需要到窗口缴费' when '691145' then '此项目需要到窗口缴费' else '' end) as code_srv,");
		str.append("ORD.Des_or as des_labsamp,");
		str.append("DEP.Name as name_dep_mp,");
		str.append("APP_LIS_OR.Amt_app as amount ");
		
		str.append("from ci_app_lis_or APP_LIS_OR ");
		str.append("left join ci_ap_lab AP_LAB on APP_LIS_OR.Id_Or = AP_LAB.Id_Or ");
		str.append("left join ci_order ORD on APP_LIS_OR.Id_Or = ORD.Id_Or ");
		str.append("left join bd_udidoc UDIDOC on AP_LAB.Id_Samptp = UDIDOC.Id_Udidoc ");
		str.append("left join bd_dep DEP on ORD.Id_Dep_Mp = DEP.Id_Dep ");
		str.append("left join bd_srv SRV on ORD.Id_Srv = SRV.Id_Srv ");
		str.append("left join bd_srvca srvca on ORD.Id_Srvca = srvca.id_srvca");
//		str.append("LEFT JOIN BD_NOTICE NOTICE ON NOTICE.id_srvca = ORD.id_srvca and NOTICE.sd_noticetp ='21' ");//子类
//		str.append("LEFT JOIN BD_NOTICE NOTICESUP ON NOTICESUP.id_srvca = '0001Z810000000001FSY'  and NOTICESUP.sd_noticetp ='21' ");//检验
		String wherestr = " where 1=1"; // ORD.sd_su_bl!=2 
		if (!StringUtils.isNullOrEmpty(ids)) {

			if (wherestr.length() > 0) {
				wherestr += " and ";
			} else {
				wherestr += " where ";
			}
			wherestr += " APP_LIS_OR.Id_ciapplissheet in (" + ids + ")";
		}
		str.append(wherestr);
		return str.toString();
	}

	/**
	 * 
	 * @param strIdors
	 * @return
	 * @throws Exception
	 */
	private String getIDciapplissheets(String strIdors) throws Exception{
		String sql = "select distinct LISOR.id_ciapplissheet as def1 "
				+ "from ci_app_lis_or LISOR "
				+ "left outer join ci_order ORD on LISOR.Id_or = ORD.Id_or "
				+ "where  LISOR.id_or in (" + strIdors + ")";
		List<UtilsDTO> result = CiorderPrintUtils.GetQueryResulte(UtilsDTO.class, sql);
		String strIdciapplissheets = "";
		if (result != null && result.size() > 0) {
			for (UtilsDTO dto : result) {
				strIdciapplissheets += "'" + dto.getDef1() + "',";
			}
		}

		return strIdciapplissheets.length() > 0 ? strIdciapplissheets.substring(0, strIdciapplissheets.length() - 1)
				: strIdciapplissheets;
	}
}

