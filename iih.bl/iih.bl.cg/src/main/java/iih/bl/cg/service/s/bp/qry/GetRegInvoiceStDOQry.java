package iih.bl.cg.service.s.bp.qry;

import iih.bl.params.BlParams;
import iih.bl.st.blstoep.d.StTypeEnum;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/*
 * 获取门诊挂号未打印的结算DO
 */
public class GetRegInvoiceStDOQry implements ITransQry {

	private String id_pat;	
	private String id_stoeps;
	public GetRegInvoiceStDOQry(String id_pat,String id_stoeps) {
		this.id_pat = id_pat;		
		this.id_stoeps = id_stoeps;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(this.id_pat);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT distinct A.*,c.code id_emp_st_code FROM BL_ST_OEP A");
		sb.append(" INNER JOIN BL_INC_OEP B ON A.ID_STOEP=B.ID_STOEP");
		sb.append(" LEFT JOIN bd_psndoc C ON A.id_emp_st=C.id_psndoc");
		sb.append(" LEFT JOIN BL_PROP_OEP propoep on propoep.ID_STOEP = A.ID_STOEP ");
		sb.append(" LEFT JOIN BL_PROP_AR_OEP aroep on aroep.ID_PROPOEP=propoep.ID_PROPOEP ");
		sb.append(" LEFT JOIN BD_HP bdhp on bdhp.id_hp=aroep.id_hp ");
		sb.append(" WHERE A.EU_STTP in ('").append(StTypeEnum.ST_OEP_REG).append("','").append(StTypeEnum.ST_REGISTER_RED).append("','").append(StTypeEnum.ST_REGISTER_MIDWAY).append("',");
		sb.append(" '").append(StTypeEnum.ST_OEP_CHARGE).append("','").append(StTypeEnum.ST_OEP_MIDWAY).append("','").append(StTypeEnum.ST_OEP_MIDWAY).append("') ");
		sb.append(" AND B.FG_PRINT='N'");
		sb.append(" AND A.ID_PAT=?");
		sb.append(" AND (ID_PAYPATOEP IS NOT NULL and id_paypatoep <> '~' )");
		sb.append(" AND A.FG_CANC='N'");
		sb.append(" AND NVL(CASE WHEN a.EU_DIRECT='1' THEN 'Y' ELSE CASE WHEN a.EU_DIRECT='-1' and A.EU_STTP='"+StTypeEnum.ST_REGISTER_RED+"' THEN nvl(bdhp.fg_sabinc_ent,'N') ELSE nvl(bdhp.fg_sabinc,'N') END END, 'Y')  = 'Y'");
//		sb.append("AND A.EU_DIRECT=1");
//		StTypeEnum.ST_OEP_REG 结算类型为挂号结算
		if(!"".equals(id_stoeps) ||id_stoeps.length() > 0)
			sb.append(" and a.id_stoep in ("+id_stoeps+")");
		//根据参数过滤零元发票
		FBoolean isPrintZero = BlParams.BLSTOEP0008();
		if(FBoolean.FALSE.equals(isPrintZero)){
			sb.append(" and B.amt <>0 ");
		}
		return sb.toString();
	}

}
