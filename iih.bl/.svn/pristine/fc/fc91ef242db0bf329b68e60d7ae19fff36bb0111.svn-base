package iih.bl.cg.s.bp.et;

import java.util.List;

import iih.bl.cg.dto.d.BlIpStDTO;
import iih.bl.params.BlParams;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 
* @ClassName: GetEtPatStDataBP  
* @Description: 获取留观患者结算信息 
* @author xy.zhou
* @date 2019年3月16日
 */
public class GetEtPatStDataBP {

	public BlIpStDTO[] exec(String id_ent)throws BizException{
		if(StringUtil.isEmpty(id_ent)){
			return new BlIpStDTO []{};
		}
		
		Integer blst0002 = BlParams.BLST0002();
		String sql=null;
		
		if(blst0002==1){
			sql=this.getOepSql(id_ent);
		}else if(blst0002==2){
			sql=this.getIpSql(id_ent);
		}else{
			throw new BizException("参数BLST0002为空或者维护范围错误，参数 为："+blst0002);
		}
		@SuppressWarnings("unchecked")
		List<BlIpStDTO> list = (List<BlIpStDTO>) new DAFacade().execQuery(sql, new BeanListHandler(BlIpStDTO.class));
		if(ListUtil.isEmpty(list)){
			return null;
		}
		return list.toArray(new BlIpStDTO []{});
	}
	
	/**
	 * 获取门诊记账sql
	 */
	private String getOepSql(String id_ent){
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("SELECT ITEM.ID_STOEP ID_ST, ");
		sqlSb.append("       ITEM.FG_ST FG_ST, ");
		sqlSb.append("       STOEP.DT_ST DT_ST, ");
		sqlSb.append("       SUM(ITEM.AMT_RATIO * CG.EU_DIRECT) AMT_RATIO, ");
		sqlSb.append("       INCOEP.INCNO INCNO, ");
		sqlSb.append("       STOEP.CODE_ST CODE_ST ");
		sqlSb.append("  FROM BL_CG_ITM_OEP ITEM ");
		sqlSb.append("  LEFT JOIN BL_CG_OEP CG ");
		sqlSb.append("    ON ITEM.ID_CGOEP = CG.ID_CGOEP ");
		sqlSb.append("  LEFT JOIN BL_ST_OEP STOEP ");
		sqlSb.append("    ON STOEP.ID_STOEP = ITEM.ID_STOEP ");
		sqlSb.append("  LEFT JOIN BL_INC_OEP INCOEP ");
		sqlSb.append("    ON STOEP.ID_STOEP = INCOEP.ID_STOEP ");
		sqlSb.append(" WHERE ITEM.ID_ENT ='").append(id_ent).append("'");
		sqlSb.append(" ");
		sqlSb.append("   AND NVL(STOEP.FG_CANC, 'N') = 'N' ");
		sqlSb.append("   AND NVL(STOEP.EU_DIRECT, '1') = '1' ");

		sqlSb.append(" GROUP BY (ITEM.ID_STOEP, ITEM.FG_ST, STOEP.DT_ST, INCOEP.INCNO, ");
		sqlSb.append("           STOEP.CODE_ST) ");
		sqlSb.append(" ORDER BY STOEP.DT_ST");

		return sqlSb.toString();
	}
	/**
	 * 获取住院记账sql
	 */
	private String getIpSql(String id_ent){
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("SELECT CGIP.ID_STIP ID_ST, ");
		sqlSb.append("       CGIP.FG_ST FG_ST, ");
		sqlSb.append("       STIP.DT_ST DT_ST, ");
		sqlSb.append("       SUM(CGIP.AMT_RATIO * CGIP.EU_DIRECT) AMT_RATIO, ");
		sqlSb.append("       INCIP.INCNO INCNO, ");
		sqlSb.append("       STIP.CODE_ST CODE_ST ");
		sqlSb.append("  FROM BL_CG_IP CGIP ");
		sqlSb.append("  LEFT JOIN BL_ST_IP STIP ");
		sqlSb.append("    ON STIP.ID_STIP = CGIP.ID_STIP ");
		sqlSb.append("  LEFT JOIN BL_INC_IP INCIP ");
		sqlSb.append("    ON STIP.ID_STIP = INCIP.ID_STIP ");
		
		sqlSb.append(" WHERE CGIP.ID_ENT ='").append(id_ent).append("'");
		sqlSb.append("   AND NVL(STIP.FG_CANC, 'N') = 'N' ");
		sqlSb.append("   AND NVL(STIP.EU_DIRECT, '1') = '1' ");
		sqlSb.append(" GROUP BY (CGIP.ID_STIP, CGIP.FG_ST, STIP.DT_ST, INCIP.INCNO, STIP.CODE_ST) ");
		sqlSb.append(" ORDER BY STIP.DT_ST");

		return sqlSb.toString();
	}
}
