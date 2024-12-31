package iih.en.pv.opurregnote;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.sys.jdbc.handler.BeanHandler;

public class OpurregNoteService {
	public OpurregNoteDTO fillBeanInfo(String entId, String idCg) throws Exception {
		StringBuilder str_buf = new StringBuilder();
		
		str_buf.append("select ENT.NAME_PAT AS namePat,"
				+ "ENT.CODE AS codeEnt,"
				+ "ENT.ID_ENT AS entId,"
				+ "(CASE WHEN ENT.SD_SEX_PAT='1' THEN '男' ELSE '女' END) AS sex,"
				+ "SUBSTR(ENT.DT_ENTRY, 0, 10) AS dateReg,"
				+ "LOT.NAME AS dayslot,"
				+ "OP.ID_TICKS AS ticksId,"
				+ "OP.TICKETNO AS tickNo,"
				+ "SRV.NAME AS scsrvName,"
				+ "TCKS.ID_TICKS AS ticksId,"
				+ "(SUBSTR(TCKS.T_B, 0, 5) || '-' || SUBSTR(TCKS.T_E, 0, 5)) AS period,"
				+ "DEP.NAME AS deptName,"
				+ "(select rst.amt from (select oep.*,rownum as rum from bl_cg_itm_oep oep where oep.id_cgoep='"+ idCg +"') rst where rst.rum=1) AS amtReg,"
				+ "(select rst.amt from (select oep.*,rownum as rum from bl_cg_itm_oep oep where oep.id_cgoep='"+ idCg +"') rst where rst.rum=2) AS amtZl,"
				+ "PSN.CODE AS OPRATOR,"
				+ "PAT.CODE AS codePat ");
		str_buf.append("FROM EN_ENT ENT ");
		str_buf.append("LEFT JOIN EN_ENT_OP OP ");
		str_buf.append("ON OP.ID_ENT = ENT.ID_ENT ");
		str_buf.append("LEFT JOIN BD_DAYSLOT LOT ");
		str_buf.append("ON OP.ID_DATESLOT = LOT.ID_DAYSLOT ");
		str_buf.append("LEFT JOIN SC_SRV SRV ");
		str_buf.append("ON OP.ID_SCSRV = SRV.ID_SCSRV ");
		str_buf.append("LEFT JOIN SC_TICKS TCKS ");
		str_buf.append("ON OP.ID_TICKS = TCKS.ID_TICKS ");
		str_buf.append("LEFT JOIN BD_DEP DEP ");
		str_buf.append("ON OP.ID_DEP_REG = DEP.ID_DEP ");
		str_buf.append("LEFT JOIN BD_PSNDOC PSN ");
		str_buf.append("ON ENT.ID_EMP_ENTRY = PSN.ID_PSNDOC ");
		str_buf.append("LEFT JOIN PI_PAT PAT ");
		str_buf.append("ON ENT.ID_PAT = PAT.ID_PAT ");
		str_buf.append("WHERE ENT.ID_ENT='"+ entId +"'");
		
		String str_sql = str_buf.toString().trim();
		str_buf.setLength(0);	str_buf.trimToSize();
		
		// 执行sql查询数据记录(SqlReader中自带宏定义的替换功能)
		SqlReader sql_rdr = new SqlReader(null, str_sql);
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		
		// 转换成对应 DTO 对象
		BeanHandler beanlist_handler = new BeanHandler(OpurregNoteDTO.class);
		OpurregNoteDTO bean_info =
				(OpurregNoteDTO) beanlist_handler.processRs(cached_rs);
		
		sql_rdr.destroy();
		if(bean_info == null){
			return new OpurregNoteDTO();
		}
		return bean_info;
	}
}
