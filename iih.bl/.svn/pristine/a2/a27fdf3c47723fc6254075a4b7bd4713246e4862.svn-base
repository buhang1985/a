package iih.bl.cg.s.bp.et;

import java.util.List;

import iih.bl.cg.dto.d.BlInccaItmDTO;
import iih.bl.cg.dto.d.BlIpCgDTO;
import iih.bl.params.BlParams;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
* @ClassName: GetOepCgListByInccaItmBP  
* @Description: 获取账单项的记账信息
* @author xy.zhou
* @date 2019年3月16日
 */
public class GetOepCgListByInccaItmBP {

	public BlIpCgDTO[] exec(String entId,BlInccaItmDTO inccaItmDto) throws BizException{
		

		if(StringUtil.isEmpty(entId)){
			throw new BizException("就诊id为空！");
		}
		
		Integer blst0002 = BlParams.BLST0002();
		String sql=null;
		SqlParam param=new SqlParam();
		if(blst0002==1){
			sql=this.getOepSql(entId,inccaItmDto,param);
		}else if(blst0002==2){
			sql=this.getIpSql(entId,inccaItmDto,param);
		}else{
			throw new BizException("参数BLST0002为空或者维护范围错误，参数 为："+blst0002);
		}
		@SuppressWarnings("unchecked")
		List<BlIpCgDTO> list = (List<BlIpCgDTO>) new DAFacade().execQuery(sql,param, new BeanListHandler(BlIpCgDTO.class));
		if(ListUtil.isEmpty(list)){
			return null;
		}
		
		return list.toArray(new BlIpCgDTO []{});
	}
	/**
	 * 获取门诊sql
	 */
	private  String getOepSql(String entId,BlInccaItmDTO inccaItmDto ,SqlParam param){
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("SELECT CG.DT_CG DT_CG, ");
		sqlSb.append("       ITEM.NAME_SRV NAME_SRV, ");
		sqlSb.append("       ITEM.NAME_MM NAME_MM, ");
		sqlSb.append("       NVL(ITEM.SPEC, '/') SPEC, ");
		sqlSb.append("       ITEM.PRICE_RATIO PRICE_RATIO, ");
		sqlSb.append("       ITEM.QUAN * CG.EU_DIRECT QUAN_MEND, ");
		sqlSb.append("       ITEM.AMT_RATIO * CG.EU_DIRECT AMT_RATIO, ");
		sqlSb.append("       DOC_OR.NAME NAME_EMP_OR, ");
		sqlSb.append("       DOC_CG.NAME NAME_EMP_CG, ");
		sqlSb.append("       OEPOR.NAME NAME_DEP_OR, ");
		sqlSb.append("       OEPMP.NAME NAME_DEP_MP, ");
		sqlSb.append("       DECODE(HPSRV.SD_HPSRVTP, '1', '甲类', '2', '乙类', '丙类') SD_HPSRVTP, ");
		sqlSb.append("       CIOR.NAME_OR NAME_OR, ");
		sqlSb.append("       ITEM.ID_MM, ");
		sqlSb.append("       MEASDOC_CUR.ID_MEASDOC IDUNIT ");
		sqlSb.append("  FROM BL_CG_ITM_OEP ITEM ");
		sqlSb.append("  LEFT JOIN BL_CG_OEP CG ");
		sqlSb.append("    ON CG.ID_CGOEP = ITEM.ID_CGOEP ");
		sqlSb.append("  LEFT JOIN BL_ST_OEP STOEP ");
		sqlSb.append("    ON ITEM.ID_STOEP = STOEP.ID_STOEP ");
		sqlSb.append("  LEFT JOIN BD_DEP OEPOR ");
		sqlSb.append("    ON OEPOR.ID_DEP = ITEM.ID_DEP_OR ");
		sqlSb.append("  LEFT JOIN BD_DEP OEPMP ");
		sqlSb.append("    ON OEPMP.ID_DEP = ITEM.ID_DEP_MP ");
		sqlSb.append("  LEFT JOIN BD_PSNDOC DOC_OR ");
		sqlSb.append("    ON DOC_OR.ID_PSNDOC = ITEM.ID_EMP_OR ");
		sqlSb.append("  LEFT JOIN BD_PSNDOC DOC_CG ");
		sqlSb.append("    ON DOC_CG.ID_PSNDOC = CG.ID_EMP_CG ");
		sqlSb.append("  LEFT JOIN CI_ORDER CIOR ");
		sqlSb.append("    ON CIOR.ID_OR = ITEM.ID_OR ");
		sqlSb.append("  LEFT OUTER JOIN BD_MEASDOC MEASDOC_CUR ");
		sqlSb.append("    ON MEASDOC_CUR.ID_MEASDOC = ITEM.PGKU_CUR ");
		sqlSb.append("  JOIN BD_HP_SRVORCA HPSRV ");
		sqlSb.append("    ON (ITEM.ID_SRV = HPSRV.ID_SRV AND ITEM.FG_MM = 'N') ");
		sqlSb.append("    OR (ITEM.ID_MM = HPSRV.ID_MM AND ITEM.FG_MM = 'Y') ");
		sqlSb.append(" WHERE ITEM.ID_ENT = ? ");
		param.addParam(entId);
		sqlSb.append("   AND ITEM.CODE_INCCAITM = ? ");
		param.addParam(inccaItmDto.getCode_inccaitm());
		sqlSb.append("   AND CG.DT_CG >= ? ");
		sqlSb.append("   AND CG.DT_CG <= ? ");
		param.addParam(new FDateTime(inccaItmDto.getDt_cg().toLocalString() + " 00:00:00"));
		param.addParam(new FDateTime(inccaItmDto.getDt_cg().toLocalString() + " 23:59:59"));
		sqlSb.append("   AND ITEM.ID_DEP_OR = ? ");
		sqlSb.append("   AND ITEM.ID_DEP_MP = ? ");
		param.addParam(inccaItmDto.getId_dep_or());
		param.addParam(inccaItmDto.getId_dep_mp());
		sqlSb.append("   AND NVL(STOEP.FG_CANC, 'N') = 'N' ");
		sqlSb.append("   AND NVL(STOEP.EU_DIRECT, '1') = '1' ");
		sqlSb.append(" ORDER BY CG.DT_CG DESC ");
		return sqlSb.toString();
	}
	/**
	 * 获取住院sql
	 */
	private  String getIpSql(String entId,BlInccaItmDTO inccaItmDto ,SqlParam param){
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("SELECT CGIP.DT_CG DT_CG, ");
		sqlSb.append("       CGIP.NAME_SRV NAME_SRV, ");
		sqlSb.append("       CGIP.NAME_MM NAME_MM, ");
		sqlSb.append("       NVL(CGIP.SPEC, '/') SPEC, ");
		sqlSb.append("       CGIP.PRICE_RATIO PRICE_RATIO, ");
		sqlSb.append("       CGIP.QUAN * CGIP.EU_DIRECT QUAN_MEND, ");
		sqlSb.append("       CGIP.AMT_RATIO * CGIP.EU_DIRECT AMT_RATIO, ");
		sqlSb.append("       DOC_OR.NAME NAME_EMP_OR, ");
		sqlSb.append("       DOC_CG.NAME NAME_EMP_CG, ");
		sqlSb.append("       OEPOR.NAME NAME_DEP_OR, ");
		sqlSb.append("       OEPMP.NAME NAME_DEP_MP, ");
		sqlSb.append("       DECODE(HPSRV.SD_HPSRVTP, '1', '甲类', '2', '乙类', '丙类') SD_HPSRVTP, ");
		sqlSb.append("       CIOR.NAME_OR NAME_OR, ");
		sqlSb.append("       CGIP.FG_BB FG_BB, ");
		sqlSb.append("       CGIP.ID_MM, ");
		sqlSb.append("       MEASDOC_CUR.ID_MEASDOC IDUNIT, ");
		sqlSb.append("       CGIP.ID_ENT_MOM ID_ENT_MOM ");
		sqlSb.append("  FROM BL_CG_IP CGIP ");
		sqlSb.append("  LEFT JOIN BL_ST_IP STIP ");
		sqlSb.append("    ON CGIP.ID_STIP = STIP.ID_STIP ");
		sqlSb.append("  LEFT JOIN BD_DEP OEPOR ");
		sqlSb.append("    ON OEPOR.ID_DEP = CGIP.ID_DEP_OR ");
		sqlSb.append("  LEFT JOIN BD_DEP OEPMP ");
		sqlSb.append("    ON OEPMP.ID_DEP = CGIP.ID_DEP_MP ");
		sqlSb.append("  LEFT JOIN BD_PSNDOC DOC_OR ");
		sqlSb.append("    ON DOC_OR.ID_PSNDOC = CGIP.ID_EMP_OR ");
		sqlSb.append("  LEFT JOIN BD_PSNDOC DOC_CG ");
		sqlSb.append("    ON DOC_CG.ID_PSNDOC = CGIP.ID_EMP_CG ");
		sqlSb.append("  LEFT JOIN CI_ORDER CIOR ");
		sqlSb.append("    ON CIOR.ID_OR = CGIP.ID_OR ");
		sqlSb.append("  LEFT OUTER JOIN BD_MEASDOC MEASDOC_CUR ");
		sqlSb.append("    ON MEASDOC_CUR.ID_MEASDOC = CGIP.PGKU_CUR ");
		sqlSb.append("  JOIN BD_HP_SRVORCA HPSRV ");
		sqlSb.append("    ON (CGIP.ID_SRV = HPSRV.ID_SRV AND CGIP.FG_MM = 'N') ");
		sqlSb.append("    OR (CGIP.ID_MM = HPSRV.ID_MM AND CGIP.FG_MM = 'Y') ");
		sqlSb.append(" WHERE CGIP.ID_ENT = ? ");
		param.addParam(entId);
		sqlSb.append("   AND CGIP.CODE_INCCAITM = ? ");
		param.addParam(inccaItmDto.getCode_inccaitm());
		sqlSb.append("   AND CGIP.DT_CG >= ? ");
		sqlSb.append("   AND CGIP.DT_CG <= ? ");
		param.addParam(new FDateTime(inccaItmDto.getDt_cg().toLocalString() + " 00:00:00"));
		param.addParam(new FDateTime(inccaItmDto.getDt_cg().toLocalString() + " 23:59:59"));
		sqlSb.append("   AND CGIP.ID_DEP_OR = ? ");
		sqlSb.append("   AND CGIP.ID_DEP_MP = ? ");
		param.addParam(inccaItmDto.getId_dep_or());
		param.addParam(inccaItmDto.getId_dep_mp());
		sqlSb.append("   AND NVL(STIP.FG_CANC, 'N') = 'N' ");
		sqlSb.append("   AND NVL(STIP.EU_DIRECT, '1') = '1' ");
		sqlSb.append(" ORDER BY CGIP.DT_CG DESC");

		return sqlSb.toString();
	}
}
