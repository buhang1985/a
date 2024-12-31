package iih.en.pv.s.bp.op;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.OpBasicDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.log.logging.Logger;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取诊毕患者列表
 * @author liubin
 *
 */
public class GetOpDignosedBP {
	/**
	 * 获取诊毕患者列表
	 * @param pageInfo 分页信息
	 * @param deptId 科室ID
	 * @param beginDate 开始日期
	 * @param endDate 结束日期
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<OpBasicDTO> exec(PaginationInfo pageInfo,String deptId,FDate beginDate,FDate endDate) throws BizException{
		if(this.volidate(pageInfo, deptId, beginDate, endDate)){
			return new PagingRtnData<OpBasicDTO>();
		}
		StringBuilder sb = new StringBuilder();
		SqlParam param = new SqlParam();
		this.wrapSql(sb, param, deptId, beginDate, endDate);
		String sql = sb.toString();
		Logger.info(sql);
		PagingServiceImpl<OpBasicDTO> pageQryService = new PagingServiceImpl<OpBasicDTO>();
		return pageQryService.findByPageInfo(new OpBasicDTO(), pageInfo, sql, null, param);
	}
	/**
	 * 组装查询语句
	 * 
	 * @param sb
	 * @param param
	 * @param deptId
	 * @param beginDate
	 * @param endDate
	 */
	private void wrapSql(StringBuilder sb, SqlParam param, String deptId,FDate beginDate,FDate endDate){
		sb.append("SELECT EN.ID_ENT AS ID_ENT,");
		sb.append("EN.CODE AS CODE_ENT,");
		sb.append("OP.CODE_AMR_OEP AS CODE_AMR_OEP,");
		sb.append("OP.TIMES_OP AS TIMES_OP,");
		sb.append("EN.ID_PAT AS ID_PAT,");
		sb.append("PAT.CODE AS CODE_PAT,");
		sb.append("EN.NAME_PAT AS NAME_PAT,");
		sb.append("EN.DT_BIRTH_PAT AS DT_BIRTH_PAT,");
		sb.append("EN.SD_SEX_PAT AS SD_SEX,");
		sb.append("SEX.NAME AS NAME_SEX,");
		sb.append("EN.TELNO_PAT AS TELNO_PAT,");
		sb.append("EN.SD_MARI_PAT AS SD_MARI_PAT,");
		sb.append("MARI.NAME AS NAME_MARI_PAT,");
		sb.append("EN.ID_DEP_PHY AS ID_DEP_PHY,");
		sb.append("DEP.NAME AS NAME_DEP_PHY,");
		sb.append("EN.ID_EMP_PHY AS ID_EMP_PHY,");
		sb.append("EMP.NAME AS NAME_EMP_PHY,");
		sb.append("EN.ID_HP AS ID_HP,");
		sb.append("HP.NAME AS NAME_HP,");
		sb.append("ENTHP.NO_HP AS NO_HP,");
		sb.append("EN.DT_ENTRY AS DT_ENTRY,");
		sb.append("EN.ID_PATCA AS ID_PATCA,");
		sb.append("PATCA.NAME AS NAME_PATCA,");
		sb.append("EN.ID_PRIPAT AS ID_PRIPAT,");
		sb.append("PRI.NAME AS NAME_PRIPAT,");
		sb.append("EN.ID_PATCRET AS ID_PATCRET,");
		sb.append("CRET.NAME AS NAME_PATCRET,");
		sb.append("DI.ID_DIDEF_DIS AS ID_DI,");
		sb.append("DI.NAME_DIDEF_DIS AS NAME_DI,");
		sb.append("DI.SUPPLEMENT AS SUPPLEMENT_DI ");
		sb.append("FROM EN_ENT EN ");
		sb.append("INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT ");
		sb.append("INNER JOIN PI_PAT PAT ON EN.ID_PAT = PAT.ID_PAT ");
		sb.append("LEFT JOIN BD_UDIDOC SEX ON EN.ID_SEX_PAT = SEX.ID_UDIDOC ");
		sb.append("LEFT JOIN BD_UDIDOC MARI ON EN.ID_MARI_PAT = MARI.ID_UDIDOC ");
		sb.append("LEFT JOIN BD_DEP DEP ON EN.ID_DEP_PHY = DEP.ID_DEP ");
		sb.append("LEFT JOIN BD_PSNDOC EMP ON EN.ID_EMP_PHY = EMP.ID_PSNDOC ");
		sb.append("LEFT JOIN BD_HP HP ON EN.ID_HP = HP.ID_HP ");
		sb.append("LEFT JOIN EN_ENT_HP ENTHP ON EN.ID_ENT = ENTHP.ID_ENT AND EN.ID_HP = ENTHP.ID_HP ");
		sb.append("LEFT JOIN PI_PAT_CA PATCA ON EN.ID_PATCA = PATCA.ID_PATCA ");
		sb.append("LEFT JOIN BD_PRI_PAT PRI ON EN.ID_PRIPAT = PRI.ID_PRIPAT ");
		sb.append("LEFT JOIN PI_PAT_CRET CRET ON EN.ID_PATCRET = CRET.ID_PATCRET ");
		sb.append("LEFT JOIN EN_ENT_DI DI ON EN.ID_ENT = DI.ID_ENT AND DI.FG_MAJ = ? ");
		param.addParam(FBoolean.TRUE);
		sb.append("WHERE OP.SD_STATUS = ? ");
		param.addParam(IEnDictCodeConst.SD_ENSTATUS_OP_FINISH);
		sb.append("AND EN.FG_CANC = ? ");
		param.addParam(FBoolean.FALSE);
		sb.append("AND EN.ID_DEP_PHY = ? ");
		param.addParam(deptId);
		if(beginDate != null) {
			sb.append("AND EN.DT_ACPT >= ? ");
			param.addParam(beginDate);
		}
		if(endDate != null){
			sb.append("AND EN.DT_ACPT < ? ");
			param.addParam(endDate.getDateAfter(1));
		}
		sb.append("ORDER BY EN.DT_ACPT ");
	}
	/**
	 * 参数验证
	 * 
	 * @param pageInfo 
	 * @param deptId 
	 * @param beginDate 
	 * @param endDate 
	 * @return
	 */
	private boolean volidate(PaginationInfo pageInfo,String deptId,FDate beginDate,FDate endDate){
		if(pageInfo == null){
			Logger.error("pageInfo不能为空！");
			return false;
		}
		if(EnValidator.isEmpty(deptId)) {
			Logger.error("deptId不能为空！");
			return false;
		}
		return true;
	}
}

