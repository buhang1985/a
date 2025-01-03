package iih.en.er.bp.inouttransmgr;

import java.util.List;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.er.dto.d.UrgInOutTransMgrDTO;
import iih.en.er.dto.d.UrgMrgQueryDTO;
import iih.en.pv.pativisit.d.desc.PatiVisitDODesc;
import iih.sc.pub.ScGroupControlUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 急诊 入出转查询抽象基类
 * 
 * @author liubin
 *
 */
public class GetInOutTransMgrBaseBP implements IGetInOutTransMgr {
	/**
	 * 获取急诊患者入出转信息
	 * 
	 * @param condition
	 * @param pageInfo
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PagingRtnData<UrgInOutTransMgrDTO> exec(UrgMrgQueryDTO condition, PaginationInfo pageInfo) throws BizException {
		if(condition == null)
			return new PagingRtnData<UrgInOutTransMgrDTO>();
		SqlParam sqlParam = new SqlParam();
		StringBuilder sqlBuilder = new StringBuilder();
		assemlySql(sqlBuilder, sqlParam, condition);
		PagingServiceImpl<UrgInOutTransMgrDTO> pageQryService = new PagingServiceImpl<UrgInOutTransMgrDTO>();
		PagingRtnData<UrgInOutTransMgrDTO> pageData = pageQryService.findByPageInfo(new UrgInOutTransMgrDTO(), pageInfo, sqlBuilder.toString(), null, sqlParam);
		handleResult((UrgInOutTransMgrDTO[])pageData.getPageData().toArray(new UrgInOutTransMgrDTO[0]));
		return pageData;
	}
	/**
	 * 获取患者入出转信息
	 * 
	 * @param condition
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public UrgInOutTransMgrDTO[] exec(UrgMrgQueryDTO condition) throws BizException {
		SqlParam sqlParam = new SqlParam();
		StringBuilder sqlBuilder = new StringBuilder();
		assemlySql(sqlBuilder, sqlParam, condition);
		List<UrgInOutTransMgrDTO> list = (List<UrgInOutTransMgrDTO>) new DAFacade().execQuery(sqlBuilder.toString(), sqlParam, new BeanListHandler(UrgInOutTransMgrDTO.class));
		if(EnValidator.isEmpty(list))
			return null;
		UrgInOutTransMgrDTO[] dtos = list.toArray(new UrgInOutTransMgrDTO[0]);
		handleResult(dtos);
		return dtos;
	}
	/**
	 * 获取患者入出转信息
	 * 
	 * @param entId
	 * @return
	 */
	@Override
	public UrgInOutTransMgrDTO exec(String entId) throws BizException{
		if(EnValidator.isEmpty(entId))
			return null;
		UrgInOutTransMgrDTO[] dtos = exec(new String[]{ entId });
		return EnValidator.isEmpty(dtos) ? null : dtos[0];
	}
	/**
	 * 获取患者入出转信息
	 * 
	 * @param entId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public UrgInOutTransMgrDTO[] exec(String[] entIds) throws BizException {
		if(EnValidator.isEmpty(entIds))
			return null;
		SqlParam param = new SqlParam();
		StringBuilder sqlBuilder = new StringBuilder();
		UrgMrgQueryDTO condition = new UrgMrgQueryDTO();
		assemlySelectSql(sqlBuilder, param, condition);
		if(entIds.length == 1){
			sqlBuilder.append(" WHERE EN.ID_ENT = ? ");
			param.addParam(entIds[0]);
		}else{
			sqlBuilder.append(" WHERE ").append(EnSqlUtils.getInSqlByIds("EN.ID_ENT", entIds));
		}
		assemlyOrderSql(sqlBuilder, param, condition);
		List<UrgInOutTransMgrDTO> list = (List<UrgInOutTransMgrDTO>) new DAFacade().execQuery(sqlBuilder.toString(), param, new BeanListHandler(UrgInOutTransMgrDTO.class));
		if(EnValidator.isEmpty(list))
			return null;
		UrgInOutTransMgrDTO[] dtos = list.toArray(new UrgInOutTransMgrDTO[0]);
		handleResult(dtos);
		return dtos;
	}
	/**
	 * 组装sql
	 * 
	 * @param sqlBuilder
	 * @param param
	 * @param condition
	 * @throws BizException
	 */
	protected void assemlySql(StringBuilder sqlBuilder, SqlParam param, UrgMrgQueryDTO condition) throws BizException{
		assemlySelectSql(sqlBuilder, param, condition);
		assemlyWhereSql(sqlBuilder, param, condition);
		assemlyOrderSql(sqlBuilder, param, condition);
	}
	/**
	 * 组装sql - Select
	 * 
	 * @param sqlBuilder
	 * @param param
	 * @param condition
	 * @throws BizException
	 */
	protected void assemlySelectSql(StringBuilder sqlBuilder, SqlParam param, UrgMrgQueryDTO condition) throws BizException{
		sqlBuilder.append("SELECT EN.ID_ENT AS ID_ENT,  ");
		sqlBuilder.append("       EN.ID_PAT AS ID_PAT,  ");
		sqlBuilder.append("       ERPRE.ID_ERPRE AS ID_ERPRE,  ");
		sqlBuilder.append("       PAT.CODE AS CODE_PAT,  ");
		sqlBuilder.append("       EN.NAME_PAT AS NAME_PAT,  ");
		sqlBuilder.append("       EN.CODE_ENTP AS CODE_ENTP,  ");
		sqlBuilder.append("       ENTP.NAME AS NAME_ENTP,  ");
		sqlBuilder.append("       EN.ID_DEP_PHY AS ID_DEP_PHY,  ");
		sqlBuilder.append("       DEPPHY.NAME AS NAME_DEP_PHY,  ");
		sqlBuilder.append("       EN.ID_DEP_NUR AS ID_DEP_NUR,  ");
		sqlBuilder.append("       DEPNUR.NAME AS NAME_DEP_NUR,  ");
		sqlBuilder.append("       ER.ID_SCALE_TRIAGE AS ID_SCALE_TRIAGE,  ");
		sqlBuilder.append("       ER.SD_SCALE_TRIAGE AS SD_SCALE_TRIAGE,  ");
		sqlBuilder.append("       ERPRE.DT_ENTRY AS DT_ENTRY,  ");
		sqlBuilder.append("       EN.DT_ACPT AS DT_ACPT,  ");
		sqlBuilder.append("       ER.ID_BED AS ID_BED,  ");
		sqlBuilder.append("       BED.NAME AS NAME_BED,  ");
		sqlBuilder.append("       PAT.DT_BIRTH_HMS AS DT_BIRTH_HMS,  ");
		sqlBuilder.append("       ER.ID_LEVEL_NUR AS ID_LEVEL_NUR,  ");
		sqlBuilder.append("       ERPRE.IDS_GREEN_CHANNEL_SYM AS IDS_GREEN_CHANNEL_SYM,  ");
		sqlBuilder.append("       ERPRE.SDS_GREEN_CHANNEL_SYM AS SDS_GREEN_CHANNEL_SYM,  ");
		sqlBuilder.append("       GOWHERE.ID_UDIDOC AS ID_GOWHERE,  ");
		sqlBuilder.append("       GOWHERE.CODE AS SD_GOWHERE,  ");
		sqlBuilder.append("       GOWHERE.NAME AS NAME_GOWHERE,  ");
		sqlBuilder.append("       EN.ID_EMP_PHY AS ID_EMP_PHY,  ");
		sqlBuilder.append("       EMP.NAME AS NAME_EMP_PHY,  ");
		sqlBuilder.append("       ERPRE.DT_END AS DT_END,  ");
		sqlBuilder.append("       EN.ID_SEX_PAT AS ID_SEX, ");
		sqlBuilder.append("       OP.DT_VALID_E AS DT_VALID_E, ");
		sqlBuilder.append("       ERPRE.SD_STATUS AS SD_STATUS_ERPRE, ");
		sqlBuilder.append("       ERPRE.SD_TRIAGE_TO AS SD_TRIAGE_TO ");
		sqlBuilder.append(" FROM EN_ENT EN  ");
		sqlBuilder.append(" INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT  ");
		sqlBuilder.append(" INNER JOIN BD_ENTP ENTP ON EN.ID_ENTP = ENTP.ID_ENTP  ");
		sqlBuilder.append(" INNER JOIN EN_ENT_OP_ER ER ON EN.ID_ENT = ER.ID_ENT  ");
		sqlBuilder.append(" INNER JOIN PI_PAT PAT ON EN.ID_PAT = PAT.ID_PAT  ");
		sqlBuilder.append(" INNER JOIN EN_ERPRE ERPRE ON EN.ID_ENT = ERPRE.ID_ENT_LAST  ");
		sqlBuilder.append(" LEFT JOIN BD_DEP DEPPHY ON EN.ID_DEP_PHY = DEPPHY.ID_DEP  ");
		sqlBuilder.append(" LEFT JOIN BD_DEP DEPNUR ON EN.ID_DEP_NUR = DEPNUR.ID_DEP  ");
		sqlBuilder.append(" LEFT JOIN BD_BED BED ON ER.ID_BED = BED.ID_BED  ");
		sqlBuilder.append(" LEFT JOIN EN_ENT_DI DI ON EN.ID_ENT = DI.ID_ENT AND DI.FG_MAJ = 'Y'  ");
		sqlBuilder.append(" LEFT JOIN BD_PSNDOC EMP ON EN.ID_EMP_PHY = EMP.ID_PSNDOC ");
		sqlBuilder.append(" LEFT JOIN BD_UDIDOC GOWHERE ON ER.ID_GOWHERE_ER = GOWHERE.ID_UDIDOC ");
	}
	/**
	 * 组装sql - Where
	 * 
	 * @param sqlBuilder
	 * @param param
	 * @param condition
	 * @throws BizException
	 */
	protected void assemlyWhereSql(StringBuilder sqlBuilder, SqlParam sqlParam, UrgMrgQueryDTO condition) throws BizException{
		sqlBuilder.append(" WHERE EN.FG_CANC = 'N' ");
		String[] codeEntps = EnParamUtils.getErTpNoComm();
		if(codeEntps.length == 1){
			sqlBuilder.append(" AND EN.CODE_ENTP = ? ");
			sqlParam.addParam(codeEntps[0]);
		}else{
			sqlBuilder.append(" AND ").append(EnSqlUtils.getInSqlByIds("EN.CODE_ENTP", codeEntps));
		}
		
		String OrgWhere = ScGroupControlUtils.getGroupControlFitler(new PatiVisitDODesc(), "EN");
		if (!EnValidator.isEmpty(OrgWhere)) {
			sqlBuilder.append(" AND ").append(OrgWhere);
		}
		if(!EnValidator.isEmpty(condition.getId_ent())){
			sqlBuilder.append(" AND EN.ID_ENT = ? ");
			sqlParam.addParam(condition.getId_ent());
		}
		if(!EnValidator.isEmpty(condition.getId_dep())){
			sqlBuilder.append(" AND EN.ID_DEP_PHY = ? ");
			sqlParam.addParam(condition.getId_dep());
		}
		if(!EnValidator.isEmpty(condition.getValue())){
			sqlBuilder.append(" AND (PAT.NAME = ? OR PAT.CODE = ? OR PAT.ID_CODE = ? OR BED.NAME = ? OR ERPRE.CODE = ?) ");
			sqlParam.addParam(condition.getValue());
			sqlParam.addParam(condition.getValue());
			sqlParam.addParam(condition.getValue());
			sqlParam.addParam(condition.getValue());
			sqlParam.addParam(condition.getValue());
		}
		if(FBoolean.TRUE.equals(condition.getFg_unentry())
				|| FBoolean.TRUE.equals(condition.getFg_indep())
				|| FBoolean.TRUE.equals(condition.getFg_lvdep())){
			boolean isFirst = true;
			sqlBuilder.append(" AND ( ");
			if(FBoolean.TRUE.equals(condition.getFg_unentry())){
				isFirst = false;
				sqlBuilder.append(" (ERPRE.SD_STATUS = ? AND NVL(ER.ID_BED,'~') = '~') ");
				sqlParam.addParam(IEnDictCodeConst.SD_STATUS_ERPRE_VISIT);
			}
			if(FBoolean.TRUE.equals(condition.getFg_indep())){
				if(!isFirst){
					sqlBuilder.append(" OR ");
				}
				isFirst = false;
				sqlBuilder.append(" (ERPRE.SD_STATUS = ? AND NVL(ER.ID_BED,'~') <> '~') ");
				sqlParam.addParam(IEnDictCodeConst.SD_STATUS_ERPRE_VISIT);
			}
			if(FBoolean.TRUE.equals(condition.getFg_lvdep())){
				if(!isFirst){
					sqlBuilder.append(" OR ");
				}
				isFirst = false;
				sqlBuilder.append(" (ERPRE.SD_STATUS = ? AND ERPRE.DT_END >= ? ) ");
				sqlParam.addParam(IEnDictCodeConst.SD_STATUS_ERPRE_END);
				sqlParam.addParam(EnAppUtils.getServerDateTime().subSeconds(60 * 60 * EnParamUtils.getErLeaveListHours()));
			}
			sqlBuilder.append(" ) ");
		}else if(EnValidator.isEmpty(condition.getId_ent())){
			sqlBuilder.append(" AND (ERPRE.SD_STATUS = ? OR (ERPRE.SD_STATUS = ? AND ERPRE.DT_END >= ? )) ");
			sqlParam.addParam(IEnDictCodeConst.SD_STATUS_ERPRE_VISIT);
			sqlParam.addParam(IEnDictCodeConst.SD_STATUS_ERPRE_END);
			sqlParam.addParam(EnAppUtils.getServerDateTime().subSeconds(60 * 60 * EnParamUtils.getErLeaveListHours()));
		}
	}
	/**
	 * 组装sql - 
	 * 
	 * @param sqlBuilder
	 * @param param
	 * @param condition
	 * @throws BizException
	 */
	protected void assemlyOrderSql(StringBuilder sqlBuilder, SqlParam param, UrgMrgQueryDTO condition) throws BizException{
		if(FBoolean.TRUE.equals(condition.getFg_unentry()) && !FBoolean.TRUE.equals(condition.getFg_indep()) && !FBoolean.TRUE.equals(condition.getFg_lvdep())){
			sqlBuilder.append(" ORDER BY ERPRE.DT_ENTRY ");
		} else if(!FBoolean.TRUE.equals(condition.getFg_unentry()) && FBoolean.TRUE.equals(condition.getFg_indep()) && !FBoolean.TRUE.equals(condition.getFg_lvdep())){
			sqlBuilder.append(" ORDER BY EN.DT_ACPT DESC ");
		}else if(!FBoolean.TRUE.equals(condition.getFg_unentry()) && !FBoolean.TRUE.equals(condition.getFg_indep()) && FBoolean.TRUE.equals(condition.getFg_lvdep())){
			sqlBuilder.append(" ORDER BY ERPRE.DT_END DESC ");
		}else{
			sqlBuilder.append(" ORDER BY ERPRE.DT_ENTRY ");
		}
	}

	/**
	 * 结果数据处理
	 * 
	 * @param datas
	 * @throws BizException
	 */
	protected void handleResult(UrgInOutTransMgrDTO[] datas) throws BizException{
		new HandleUrgInOutTransMgrsBP().exec(datas);
	}
}
