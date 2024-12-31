package iih.mp.orm.surgplansearch;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.handler.BeanListHandler;

public class SurgPatCheckCardImpl {

	/**
	 * 取得手术患者核对卡信息
	 * @param dt_begin
	 * @param dt_end
	 * @return
	 * @throws Exception 
	 */
	public SurgPatCheckCardDTO[] exec(String id_apops) throws Exception{
		String[] id_apop = null;
		id_apop = id_apops.split(",");
		
		//拼接SQL
		String surgSql = getSurgSql(id_apop);
		String itemSql = getItemSql(id_apop);
		
		//分别查询手术信息和人员安排信息
		SqlReader surgReader = new SqlReader(null, surgSql);
		surgReader.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl surgCached_rs = surgReader.getCacheRowSet();
		
		BeanListHandler surgListHandler = new BeanListHandler(SurgPatCheckCardDTO.class);
		@SuppressWarnings("unchecked")
		List<SurgPatCheckCardDTO> surglist = (List<SurgPatCheckCardDTO>) surgListHandler.processRs(surgCached_rs);
		SurgPatCheckCardDTO[] surg = surglist.toArray(new SurgPatCheckCardDTO[surglist.size()]);
		
		SqlReader itemReader = new SqlReader(null, itemSql);
		itemReader.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl itemCached_rs = itemReader.getCacheRowSet();
		
		BeanListHandler itemListHandler = new BeanListHandler(SurgItemDTO.class);
		@SuppressWarnings("unchecked")
		List<SurgItemDTO> itemlist = (List<SurgItemDTO>) itemListHandler.processRs(itemCached_rs);
		SurgItemDTO[] item = itemlist.toArray(new SurgItemDTO[surglist.size()]);
		//DAFacade daFacade = new DAFacade();
		//ArrayList<SurgPatCheckCardDTO> surglist = (ArrayList<SurgPatCheckCardDTO>) daFacade.execQuery(surgSql, new BeanListHandler(SurgPatCheckCardDTO.class));
		//SurgPatCheckCardDTO[] surg = surglist.toArray(new SurgPatCheckCardDTO[surglist.size()]);
		
		//@SuppressWarnings("unchecked")
		//ArrayList<SurgItemDTO> itemlist = (ArrayList<SurgItemDTO>) daFacade.execQuery(itemSql, new BeanListHandler(SurgItemDTO.class));
		//SurgItemDTO[] item = itemlist.toArray(new SurgItemDTO[itemlist.size()]);
		
		//合并两个结果集
		surg = combine(surg, item);
		
		//计算年龄
		surg = calAge(surg);
		return surg;
	}

	/**
	 * 计算年龄
	 * @param surg
	 * @return
	 */
	private SurgPatCheckCardDTO[] calAge(SurgPatCheckCardDTO[] surg) {
		for(int i = 0; i < surg.length; i++){
			surg[i].setAge(AgeCalcUtil.getAge(new FDate(surg[i].getBirth())));
		}
		return surg;
	}

	/**
	 * 拼接手术信息SQL
	 * @param dt_begin
	 * @param dt_end
	 * @return
	 */
	private String getSurgSql(String[] id_apop) {
		StringBuilder sql = new StringBuilder();
		sql.append("select APP_SUG.Id_Apop    AS ID_APOP, ");
		sql.append("ENT_IP.Code_Amr_Ip   AS SURGNO, ");
		sql.append("OPT.name             AS OPT_NAME, ");
		sql.append("APP_SUG.Num_Opt      AS NUM_OPT, ");
		sql.append("PAT.Name             AS PAT_NAME, ");
		sql.append("UDIDOC1.Name         AS SEX, ");
		sql.append("DEP.Name             AS ROOM, ");
		sql.append("ENT_IP.Name_Bed      AS BEDNO, ");
		sql.append("PAT.Dt_Birth         AS BIRTH, ");
		sql.append("APP_SUG.Str_Name_Di AS DI_NAME, ");
		sql.append("SRV.Name             AS SURG_NAME, ");
		sql.append("UDIDOC2.Name         AS ANESTP_NAME, ");
		sql.append("APP_SUG.Sugplandate  AS DT_SURG, ");
		sql.append("PAT_AL.Name_Alcla    AS ALLERGY ");
		sql.append("from mp_orm_app_sug APP_SUG ");

		sql.append("left join en_ent_ip ENT_IP ");
		sql.append("on ENT_IP.Id_Ent = APP_SUG.Id_Ent ");
		sql.append("left join bd_opt OPT ");
		sql.append("on OPT.Id_Opt = APP_SUG.Id_Opt ");
		sql.append("left join pi_pat PAT ");
		sql.append("on PAT.Id_Pat = APP_SUG.Id_Pat ");
		sql.append("left join bd_udidoc UDIDOC1 ");
		sql.append("on UDIDOC1.Id_Udidoc = PAT.Id_Sex ");
		sql.append("left join bd_dep DEP ");
		sql.append("on DEP.Id_Dep = APP_SUG.Id_Dept_App ");
		sql.append("left join en_ent_ip ENT_IP ");
		sql.append("on ENT_IP.Id_Ent = APP_SUG.Id_Ent ");
		sql.append("left join bd_srv SRV ");
		sql.append("on SRV.Id_Srv = APP_SUG.Id_Srv ");
		sql.append("left join bd_udidoc UDIDOC2 ");
		sql.append("on UDIDOC2.Id_Udidoc = APP_SUG.Id_Anestp ");
		sql.append("left join pi_pat_al PAT_AL ");
		sql.append("on PAT_AL.Id_Pat = APP_SUG.Id_Pat ");
		sql.append("where 1 = 1 ");
		sql.append("and APP_SUG.Ds = 0 ");
		sql.append(" and APP_SUG.Id_Apop in ('");
		sql.append(id_apop[0]);
		sql.append("'");
		for(int i = 1; i < id_apop.length; i++){
			sql.append(",'");
			sql.append(id_apop[i]);
			sql.append("'");
		}
		sql.append(")");
		sql.append(" order by APP_SUG.Sugplandate, OPT.name, APP_SUG.Num_Opt ");

		return sql.toString();
	}
	
	/**
	 * 拼接手术关注指标SQL
	 * @param dt_begin
	 * @param dt_end
	 * @return
	 */
	private String getItemSql(String[] id_apop) {
		StringBuilder sql = new StringBuilder();
		sql.append("select ITEM.Id_Apop      AS ID_APOP, ");
		sql.append("ITEM.Name_Srv     AS SRV_NAME, ");
		sql.append("ITEM.Val_Rstrptla AS VAL, ");
		sql.append("ITEM.Name_Srv || ' ' || ITEM.Val_Rstrptla AS ITEMS ");
		sql.append("from ci_ap_sug_viewitm ITEM  ");
		sql.append("where 1 = 1 ");
		sql.append(" and ITEM.Id_Apop in ('");
		sql.append(id_apop[0]);
		sql.append("'");
		for(int i = 1; i < id_apop.length; i++){
			sql.append(",'");
			sql.append(id_apop[i]);
			sql.append("'");
		}
		sql.append(")");
		
		return sql.toString();
	}
	
	/**
	 * 根据申请单id将手术信息和关注指标项合并
	 * @param surg
	 * @param item
	 * @return
	 */
	private SurgPatCheckCardDTO[] combine(SurgPatCheckCardDTO[] surg, SurgItemDTO[] item) {
		for(int i = 0; i < surg.length; i++){
			StringBuilder items = new StringBuilder("");
			for(int j = 0; j < item.length; j++){
				if(item[j] != null){
					if(StringUtils.equals(surg[i].getId_apop(), item[j].getId_apop())){
						items.append(item[j].getItems());
					}
				}	
			}
			surg[i].setSurgitem(items.toString());
		}
		return surg;
	}
}
