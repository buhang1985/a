package iih.bl.hp.s.bp.qry;

import org.apache.commons.lang.StringUtils;

import iih.bl.params.BlParams;
import iih.mi.itf.bizgrpitf.constant.BdMhiParamValueConst;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询住院记账明细
 * @author hanJQ
 * @Date 2018-12-06
 */
public class GetIpBillItmDtosUnEntQry implements ITransQry{

	FBoolean isUploaded = FBoolean.FALSE;
	FBoolean isMerge = null;
	
	String condition;
	String orderBy;
	String uploadMode;
	public GetIpBillItmDtosUnEntQry(String condition,String orderBy,FBoolean isUpload,String uploadMode) throws BizException
	{
		//判断母婴是否合并结算
		this.isMerge = BlParams.BLSTIP0005();
		this.isUploaded = isUpload;
		this.condition = condition;
		this.orderBy = orderBy;
		this.uploadMode = uploadMode;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {		
		StringBuilder sqlBF = new StringBuilder();		
		sqlBF.append(" SELECT ");
		
		sqlBF.append(" CGIP.ID_ENT,CGIP.ID_PAT,ENT.NAME_PAT,CGIP.ID_CGIP,CGIP.PRICE,ENT.id_hp,CGIP.fg_selfpay Fg_selfpay, ");
		sqlBF.append(" ENT.CODE  CODE_ENT,CGIP.PRICE_RATIO,CGIP.ID_SRV,CGIP.SRVU,MEASDOC.NAME  NAME_SRVU, ");
		sqlBF.append(" PSNDOC.CODE  ID_EMP_OR,PSNDOC.NAME  NAME_EMP_OR,CGIP.ID_DEP_OR,DEP.NAME  NAME_DEP_OR,DEP.code  Code_dep_or, ");
		sqlBF.append(" CGIP.FG_HP,CGIP.EU_DIRECT, CGIP.CODE_MM,CGIP.ID_SRVTP,CGIP.DT_SRV, ");
		sqlBF.append(" CGIP.DT_CG,CGIP.SD_SRVTP,CGIP.ID_MM,CGIP.NAME_MM,CGIP.ID_ORSRV,CGIP.CODE_INCCAITM,CGIP.NAME_INCCAITM, ");
		sqlBF.append(" CGIP.FG_BB,CGIP.ID_ENT_MOM,CGIP.NAME_SRV,CGIP.CODE_SRV,CGIP.FG_MM,CGIP.ID_PAR  ID_CGPAR  , ");
		
		if(BdMhiParamValueConst.BDMHI2009_ONLYFORWARD.equals(this.uploadMode)){
			sqlBF.append(" CGIP.QUAN - CGIP.QUAN_RET QUAN, ");
			sqlBF.append(" (CGIP.QUAN - CGIP.QUAN_RET) * PRICE_RATIO AMT_RATIO, ");
		}else{
			sqlBF.append(" CGIP.QUAN * CGIP.EU_DIRECT  QUAN, ");
			sqlBF.append(" CGIP.AMT_RATIO*CGIP.EU_DIRECT  AMT_RATIO, ");
		}
		
		if(FBoolean.TRUE.equals(this.isUploaded)){
			sqlBF.append(" CGITM_IP.amt_payzl , CGITM_IP.amt_payzf , CGITM_IP.rate_payzl , ");
		}
		
		sqlBF.append(" sum(CGIP.AMT_RATIO * CGIP.EU_DIRECT) over() amtsum ");
		sqlBF.append(" FROM  BL_CG_IP  CGIP ");
		sqlBF.append(" INNER  JOIN  EN_ENT  ENT  ON  ENT.ID_ENT=CGIP.ID_ENT ");
		sqlBF.append(" INNER  JOIN  BD_MEASDOC  MEASDOC  ON  CGIP.SRVU=MEASDOC.ID_MEASDOC ");
		sqlBF.append(" INNER  JOIN  BD_PSNDOC  PSNDOC  ON  CGIP.ID_EMP_OR=PSNDOC.ID_PSNDOC ");
		sqlBF.append(" INNER  JOIN  BD_DEP  DEP  ON  CGIP.ID_DEP_OR=DEP.ID_DEP ");
		
		if(FBoolean.TRUE.equals(this.isUploaded)){
			sqlBF.append(" LEFT  JOIN  BL_HP_CGITM_IP  CGITM_IP  ON  CGITM_IP.ID_CGIP=CGIP.ID_CGIP ");
		}
		
		sqlBF.append(" WHERE cgip.fg_st='N' and nvl(ENT.id_hp,'~') != '~' ");
		
		if(BdMhiParamValueConst.BDMHI2009_ONLYFORWARD.equals(this.uploadMode)){
			sqlBF.append(" AND cgip.EU_DIRECT = 1 ");
			sqlBF.append(" AND cgip.FG_REFUND = 'N' ");
		}
		
		if(FBoolean.TRUE.equals(this.isUploaded)){
			sqlBF.append(" and cgip.fg_hp = 'Y' ");
		}else{
			sqlBF.append(" and cgip.fg_hp = 'N' ");
		}
		if(StringUtils.isNotBlank(this.condition)){
			sqlBF.append("  and ").append(this.condition);
		}		
		sqlBF.append("  order by CGIP.id_ent,cgip.EU_DIRECT DESC,cgip.dt_cg ");
		
		return sqlBF.toString();
	}
	
	
}
