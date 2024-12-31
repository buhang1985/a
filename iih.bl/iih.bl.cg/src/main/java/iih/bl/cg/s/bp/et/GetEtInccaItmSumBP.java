package iih.bl.cg.s.bp.et;

import java.util.List;

import iih.bl.cg.dto.d.BlInccaItmDTO;
import iih.bl.params.BlParams;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
* @ClassName: GetEtInccaItmSumBP  
* @Description: 获取门诊\住院账单项汇总信息
* @author xy.zhou
* @date 2019年3月16日
 */
public class GetEtInccaItmSumBP {
	
	public BlInccaItmDTO[] exec(String entId,FBoolean fgSt,String stId) throws BizException{
		
		if(StringUtil.isEmpty(entId)){
			throw new BizException("就诊id为空！");
		}
		
		Integer blst0002 = BlParams.BLST0002();
		String sql=null;
		SqlParam param=new SqlParam();
		if(blst0002==1){
			sql=this.getOepSql(entId,fgSt,stId,param);
		}else if(blst0002==2){
			sql=this.getIpSql(entId,fgSt,stId,param);
		}else{
			throw new BizException("参数BLST0002为空或者维护范围错误，参数 为："+blst0002);
		}
		@SuppressWarnings("unchecked")
		List<BlInccaItmDTO> list = (List<BlInccaItmDTO>) new DAFacade().execQuery(sql,param, new BeanListHandler(BlInccaItmDTO.class));
		if(ListUtil.isEmpty(list)){
			return null;
		}
		return list.toArray(new BlInccaItmDTO []{});
	}
	
	/**
	 * 获取门诊sql
	 */
	private  String getOepSql(String entId,FBoolean fgSt,String stId,SqlParam param){
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("SELECT ITEM.NAME_INCCAITM NAME_INCCAITM, ");
		sqlSb.append("       ITEM.CODE_INCCAITM CODE_INCCAITM, ");
		sqlSb.append("       SUM(ITEM.AMT_RATIO * CG.EU_DIRECT) AMT_RATIO ");
		sqlSb.append("  FROM BL_CG_ITM_OEP ITEM ");
		sqlSb.append("  LEFT JOIN BL_CG_OEP CG ");
		sqlSb.append("    ON CG.ID_CGOEP = ITEM.ID_CGOEP ");
		sqlSb.append("  LEFT JOIN BL_ST_OEP STOEP ");
		sqlSb.append("    ON ITEM.ID_STOEP = STOEP.ID_STOEP");
		sqlSb.append(" WHERE ITEM.ID_ENT =?");
		param.addParam(entId);
		sqlSb.append("   AND ITEM.FG_ST = ? ");
		param.addParam(fgSt);
		if (FBoolean.TRUE.equals(fgSt)) {
			sqlSb.append("AND ITEM.ID_STOEP=? ");
			sqlSb.append("AND STOEP.FG_CANC='N' ");
			sqlSb.append("AND STOEP.EU_DIRECT='1' ");
			param.addParam(stId);
		}
		sqlSb.append(" GROUP BY (ITEM.NAME_INCCAITM, ITEM.CODE_INCCAITM)");
		return sqlSb.toString();
	}
	/**
	 * 获取住院sql
	 */
	private String getIpSql(String entId,FBoolean fgSt,String stId,SqlParam param){
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("SELECT CGIP.NAME_INCCAITM NAME_INCCAITM, ");
		sqlSb.append("       CGIP.CODE_INCCAITM CODE_INCCAITM, ");
		sqlSb.append("       SUM(CGIP.AMT_RATIO * CGIP.EU_DIRECT) AMT_RATIO ");
		sqlSb.append("  FROM BL_CG_IP CGIP ");
		sqlSb.append("  LEFT JOIN BL_ST_IP STIP ");
		sqlSb.append("    ON CGIP.ID_STIP = STIP.ID_STIP ");
		sqlSb.append(" WHERE CGIP.ID_ENT =?");
		param.addParam(entId);
		sqlSb.append("   AND CGIP.FG_ST = ? ");
		param.addParam(fgSt);
		if (FBoolean.TRUE.equals(fgSt)) {
			sqlSb.append("AND cgip.ID_STIP=? ");
			sqlSb.append("AND stip.FG_CANC='N' ");
			sqlSb.append("AND stip.EU_DIRECT='1' ");
			param.addParam(stId);
		}

		sqlSb.append(" GROUP BY (CGIP.NAME_INCCAITM, CGIP.CODE_INCCAITM)");
		return sqlSb.toString();
	}
}
