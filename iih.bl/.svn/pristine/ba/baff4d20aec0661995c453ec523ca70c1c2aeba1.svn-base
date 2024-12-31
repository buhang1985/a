package iih.bl.st.s.bp;

import java.util.List;

import iih.bl.st.stsheet.d.StSheetDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取患者结算单数据
 * 
 * @author wq.li
 *
 */
public class GetStSheetInfoBP {
	/**
	 * 获取患者结算单数据
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	public StSheetDTO[] exec(String patId) throws BizException {

		if (StringUtil.isEmpty(patId)) {
			return null;
		}

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT	");
		sql.append("	st.id_stoep Id_st,	");
		sql.append("	st.id_ent Id_ent,	");
		sql.append("	st.id_pat Id_pat,	");
		sql.append("	st.code_st CODE_ST,	");
		sql.append("	st.DT_ST DT_ST,		");
		sql.append("	ent.code Code_ent,	");
		sql.append("	HP.Id_Hp,			");
		sql.append("	hp.code Code_hp,	");
		sql.append("	PAT.NAME NAME_PAT,	");
		sql.append("	SEX.NAME SEX,		");
		sql.append("	pri.name NAME_PRI 	");

		sql.append("FROM   bl_st_oep st		");
		sql.append("INNER JOIN PI_PAT pat ON st.ID_PAT = PAT.ID_PAT		");
		sql.append("INNER JOIN en_ent ent on ent.id_ent = st.id_ent		");
		sql.append("LEFT JOIN BD_HP HP ON HP.id_hp = ent.id_hp			");
		sql.append("LEFT JOIN bd_pri_pat pri ON pri.id_pripat = pat.id_patpritp		");
		sql.append("LEFT JOIN bd_udidoc sex ON sex.ID_UDIDOC = pat.id_sex	");
		
		sql.append("WHERE   ST.FG_CANC = 'N'	AND ST.EU_DIRECT = 1	");
		sql.append("	and st.id_pat=? and st.eu_sttp != '31' ");
		SqlParam param = new SqlParam();
		param.addParam(patId);
		DAFacade facade = new DAFacade();
		List<StSheetDTO> stSheetList = (List<StSheetDTO>) facade.execQuery(sql.toString(), param,
				new BeanListHandler(StSheetDTO.class));
		return stSheetList.toArray(new StSheetDTO[0]);
	}
}
