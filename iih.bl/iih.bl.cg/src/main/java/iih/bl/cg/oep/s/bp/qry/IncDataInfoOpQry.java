package iih.bl.cg.oep.s.bp.qry;

import iih.bl.params.BlParams;

import org.apache.commons.lang.StringUtils;

import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/** 获取门诊发票信息
 * @author yangyang
 * @date 2018-05-28
 */
public class IncDataInfoOpQry implements ITransQry{

	//患者主键
	private String strIdPat;
	//开始时间
	private String strDtBegin;
	//截止时间
	private String dtEnd;
	
	public IncDataInfoOpQry(String strIdPat,String strDtBegin, String dtEnd)
	{
		this.strIdPat=strIdPat;
		this.strDtBegin=strDtBegin;
		this.dtEnd = dtEnd;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
        SqlParam param=new SqlParam();
        param.addParam(this.strIdPat);
        if(StringUtils.isNotBlank(this.strDtBegin)){
        	param.addParam(this.strDtBegin);
        }        
        if(StringUtils.isNotBlank(this.dtEnd)){
        	param.addParam(this.dtEnd);
        }
        return param;
	}

	@Override
	public String getQrySQLStr() {
    	StringBuilder sb=new StringBuilder();
    	sb.append(" SELECT STOEP.ID_STOEP,INCOEP.ID_INCOEP,STOEP.EU_STTP,STOEP.CODE_ST,");
    	sb.append(" INCOEP.INCNO,STOEP.EU_DIRECT,INCOEP.AMT_RATIO AS AMT_INC,STOEP.AMT_RATIO AS AMT_ALL,");
        sb.append(" INCOEP.FG_CC_OUT,INCOEP.ID_EMP_INC,INCOEP.DT_INC,STOEP.DT_ST,incp.incno p_incno,");
        sb.append(" case when incp.incno is null then 'N' else 'Y' end fg_pinc ");
        sb.append(" FROM BL_ST_OEP STOEP");
        sb.append(" INNER JOIN BL_INC_OEP INCOEP ON STOEP.ID_STOEP=INCOEP.ID_STOEP");
        sb.append(" left join bl_inc_oep_paper incp on INCOEP.id_incoep = incp.id_incoep and incp.fg_canc = 'N' ");
        sb.append(" WHERE STOEP.ID_PAT=? AND STOEP.EU_DIRECT=1 AND INCOEP.FG_CC_OUT='N' AND INCOEP.FG_PRINT='Y' AND STOEP.FG_CANC='N'");
        if(StringUtils.isNotBlank(this.strDtBegin)){
        	sb.append(" AND INCOEP.dt_inc>? ");
        }        
        if(StringUtils.isNotBlank(this.dtEnd)){
        	sb.append(" AND INCOEP.dt_inc <= ? ");
        }
        
		//根据参数过滤零元发票
		FBoolean isPrintZero = BlParams.BLSTOEP0008();
		if(FBoolean.FALSE.equals(isPrintZero)){
			sb.append(" and INCOEP.amt <>0 ");
		}
		return sb.toString();
	}
}
