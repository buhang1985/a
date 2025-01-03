package iih.bl.cg.s.bp.ip.backcg;

import java.util.List;

import iih.bd.base.validator.ParamValidator;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bl.cg.dto.d.IpCgPatDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取预记账患者列表
 * 
 * @author yankan
 * @since 2017-09-18
 * @version ly 2018/06/04 排除团检患者
 *          ly 2018/11/13 添加就诊id
 */
public class GetNeedCgPatListBP {
	/**
	 * 获取预记费患者列表
	 * @param chargeTime 记账时间
	 * @param patId 患者ID
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public List<IpCgPatDTO> exec(FDateTime chargeTime, String patId, String entId) throws BizException {
		ParamValidator.validateNotNull("记账日期", chargeTime);
		
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT ENT.ID_ENT,ENT.ID_PRIPAT,IP.TIMES_IP,");
		sqlBuilder.append("ENT.ID_PAT,ENT.NAME_PAT,PAT.CODE AS CODE_PAT,");
		sqlBuilder.append("ENT.ID_ORG,ENT.ID_GRP,");
		sqlBuilder.append("ENT.DT_ENTRY,ENT.DT_END,");
		sqlBuilder.append("ENT.DT_ACPT,");
		sqlBuilder.append("ENT.ID_ENTP,ENT.CODE_ENTP,");
		sqlBuilder.append("ENT.ID_DEP_PHY,ENT.ID_DEP_NUR,ENT.FG_IP,");
		sqlBuilder.append("ENT.ID_EMP_PHY,");
		sqlBuilder.append("IP.FG_NEWBORN FG_BB,");
		sqlBuilder.append("CASE WHEN ACC.DT_BACKCGLASTACT IS NULL THEN NULL ELSE ACC.DT_BACKCG END DT_BACKCG,"); 
		sqlBuilder.append("ACC.ID_ENTACC,ACC.DT_BACKCGLASTACT,");
		sqlBuilder.append("ACC.FG_FREEZE ");
		sqlBuilder.append(" FROM EN_ENT ENT ");
		sqlBuilder.append(" INNER JOIN EN_ENT_IP IP ON IP.ID_ENT = ENT.ID_ENT ");
		sqlBuilder.append(" AND IP.SD_STATUS <> ? "); //2018/06/27 ly  添加入科状态判断
		sqlBuilder.append(" INNER JOIN PI_PAT PAT ON PAT.ID_PAT = ENT.ID_PAT ");
		sqlBuilder.append(" INNER JOIN EN_ENT_ACC ACC ON ACC.ID_ENT = ENT.ID_ENT ");
		sqlBuilder.append(" WHERE ENT.CODE_ENTP in (?,?) ");
		sqlBuilder.append(" AND NVL(ENT.FG_CANC,'N')='N' ");
		sqlBuilder.append(" AND ACC.DT_BACKCG<? ");

		//排除团检患者
		sqlBuilder.append(" AND NOT EXISTS(SELECT 1 FROM EN_PE_CMPY_ITM CMPTIEM WHERE CMPTIEM.ID_ENT = ENT.ID_ENT) ");
		
		SqlParam param = new SqlParam();
		param.addParam(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN);
		param.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_IP);// 住院
		param.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE);// 预住院

		param.addParam(chargeTime);
		if(!StringUtil.isEmpty(patId) && !patId.equals("*")){
			sqlBuilder.append(" AND ENT.ID_PAT=?");//患者过滤
			sqlBuilder.append(" AND ISNULL(FG_ST,'N')='N'");//未结算
			
			param.addParam(patId);
		}else if(!StringUtil.isEmpty(entId)){
			
			sqlBuilder.append(" AND ENT.ID_ENT = ?");//患者过滤
			sqlBuilder.append(" AND ISNULL(FG_ST,'N')='N'");//未结算
			
			param.addParam(entId);
		}else{
			sqlBuilder.append(" AND ENT.FG_IP='Y'");//如果非单患者，必须是在院患者
		}
		
		//根据病区排序
		sqlBuilder.append(" ORDER BY ENT.ID_DEP_NUR ");
		
		List<IpCgPatDTO> ipPatList = (List<IpCgPatDTO>) new DAFacade().execQuery(sqlBuilder.toString(), param,
				new BeanListHandler(IpCgPatDTO.class));
		return ipPatList;
	}
	
	/**
	 * 获取急诊滚张患者(仍使用就诊账户)
	 * @param chargeTime
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public List<IpCgPatDTO> execEt(FDateTime chargeTime, String entId) throws BizException {
		ParamValidator.validateNotNull("记账日期", chargeTime);
		
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT ENT.ID_ENT,ENT.ID_PRIPAT,IP.TIMES_IP,");
		sqlBuilder.append("ENT.ID_PAT,ENT.NAME_PAT,PAT.CODE AS CODE_PAT,");
		sqlBuilder.append("ENT.ID_ORG,ENT.ID_GRP,");
		sqlBuilder.append("ENT.DT_ENTRY,ENT.DT_END,");
		sqlBuilder.append("ENT.DT_ACPT,");
		sqlBuilder.append("ENT.ID_ENTP,ENT.CODE_ENTP,");
		sqlBuilder.append("ENT.ID_DEP_PHY,ENT.ID_DEP_NUR,ENT.FG_IP,");
		sqlBuilder.append("IP.FG_NEWBORN FG_BB,");
		sqlBuilder.append("ACC.DT_BACKCG,ACC.DT_BACKCGLASTACT ");
		//sqlBuilder.append("ACC.ID_ENTACC,ACC.DT_BACKCG,ACC.DT_BACKCGLASTACT,");
		//sqlBuilder.append("ACC.FG_FREEZE ");
		sqlBuilder.append(" FROM EN_ENT ENT ");
		sqlBuilder.append(" INNER JOIN EN_ENT_IP IP ON IP.ID_ENT = ENT.ID_ENT ");
		sqlBuilder.append(" AND IP.SD_STATUS <> ? "); 
		sqlBuilder.append(" INNER JOIN PI_PAT PAT ON PAT.ID_PAT = ENT.ID_PAT ");
		sqlBuilder.append(" INNER JOIN EN_ENT_ACC ACC ON ACC.ID_ENT = ENT.ID_ENT ");
		sqlBuilder.append(" WHERE ENT.CODE_ENTP=? ");
		sqlBuilder.append(" AND NVL(ENT.FG_CANC,'N')='N' ");
		sqlBuilder.append(" AND ACC.DT_BACKCG<? ");

		SqlParam param = new SqlParam();
		param.addParam(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN);
		param.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS);// 留观
		param.addParam(chargeTime);
		if(!StringUtil.isEmpty(entId)){
			
			sqlBuilder.append(" AND ENT.ID_ENT = ?");//患者过滤
			sqlBuilder.append(" AND nvl(FG_ST,'N')='N'");//未结算
			
			param.addParam(entId);
		}else{
			sqlBuilder.append(" AND ENT.FG_IP='Y'");//如果非单患者，必须是在院患者
		}
		
		//根据病区排序
		sqlBuilder.append(" ORDER BY ENT.ID_DEP_NUR ");
		
		List<IpCgPatDTO> ipPatList = (List<IpCgPatDTO>) new DAFacade().execQuery(sqlBuilder.toString(), param,
				new BeanListHandler(IpCgPatDTO.class));
		return ipPatList;
	}
}
