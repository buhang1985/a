package iih.bl.st.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 门诊重划重收查询
 * @author hanjq 上午10:32:05
 *
 */
public class OepRechargeQry implements ITransQry {

	String id_pat;
	String dt_b;
	String dt_e;
	String codest;
	String incno;
	String id_stoep;
	String eu_direct;
	String fg_canc;

	/*
	 * 获取退款导入时的相关收款数据
	 */
	public OepRechargeQry(String id_pat, String dt_b, String dt_e) {

		this.id_pat = id_pat;
		this.dt_b = dt_b;
		this.dt_e = dt_e;
		this.eu_direct = "1";
		this.fg_canc = "N";
	}

	/*
	 * 获取退款导入时的相关收款数据录入结算号 与发票号 返回对应的数据
	 */
	public OepRechargeQry(String id_pat, String codest, String incno, String nullKey) {
		this.id_pat = id_pat;
		this.codest = codest;
		this.incno = incno;
		this.eu_direct = "1";
		this.fg_canc = "N";
	}

	/*
	 * 获取相关异常数据 导入
	 */
	public OepRechargeQry(String id_stoep) {
		this.id_stoep = id_stoep;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		SqlParam param = new SqlParam();
		if (id_pat != null)
			param.addParam(this.id_pat);
		if (dt_b != null)
			param.addParam(this.dt_b);
		if (dt_e != null)
			param.addParam(this.dt_e);
		if (codest != null)
			param.addParam(this.codest);
		if (incno != null)
			param.addParam(this.incno);
		if (id_stoep != null)
			param.addParam(this.id_stoep);
		if (eu_direct != null)
			param.addParam(this.eu_direct);
		if (fg_canc != null)
			param.addParam(this.fg_canc);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT A.DT_ST,A.CODE_ST,B.INCNO,A.ID_STOEP,B.ID_INCOEP,D.Id_cust,h.name AS NAME_CUST,");
		sql.append(" G.NAME NAME_EMP_PAY,C.DT_PAY,D.ID_PM,D.NAME NAME_PM,B.AMT,A.EU_DIRECT,F.CODE_HP,F.inputinfo,F.outputinfo,A.FG_CANC");//d.id_payitmpatoep, 
		sql.append(" FROM BL_ST_OEP A");
		sql.append(" INNER JOIN BL_INC_OEP B ON A.ID_STOEP=B.ID_STOEP");
		sql.append(" INNER JOIN BL_PAY_PAT_OEP C ON A.ID_PAYPATOEP=C.ID_PAYPATOEP");
		
		sql.append(" INNER JOIN (select D.ID_PAYPATOEP,D.ID_PM, PM.name,D.ID_CUST, sum(D.eu_direct * D.amt) ");
		sql.append(" from BL_PAY_ITM_PAT_OEP D  ");
		sql.append(" INNER JOIN BD_PRI_PM PM ON D.ID_PM=PM.ID_PM ");
		sql.append(" group by D.ID_PAYPATOEP,D.ID_PM, PM.name,D.ID_CUST ");
		sql.append(" having sum(D.eu_direct * D.amt) > 0) D on C.ID_PAYPATOEP = D.ID_PAYPATOEP ");
		
//		sql.append(" INNER JOIN BL_PAY_ITM_PAT_OEP D ON C.ID_PAYPATOEP=D.ID_PAYPATOEP");
//		sql.append(" INNER JOIN BD_PRI_PM PM ON D.ID_PM=PM.ID_PM");
		
		sql.append(" INNER JOIN BD_PSNDOC G ON C.ID_EMP_PAY=G.ID_PSNDOC");		
		sql.append(" LEFT JOIN BL_PROP_OEP E ON A.ID_STOEP=E.ID_STOEP");
		sql.append(" LEFT JOIN BL_PROP_AR_OEP F ON E.ID_PROPOEP=f.id_propoep");
		sql.append(" LEFT JOIN bd_cust H ON H.ID_CUST=D.ID_CUST");
		sql.append(" LEFT JOIN BL_HP_ERROR ERRO ON ERRO.ID_STOEP=A.ID_STOEP AND ERRO.fg_rollback<>'Y'");
		sql.append(" WHERE 1 = 1 ");
		if (id_pat != null)
			sql.append(" AND A.ID_PAT=?");
		if (dt_b != null)
			sql.append(" AND A.DT_ST >= TO_CHAR(?)");
		if (dt_e != null)
			sql.append(" AND A.DT_ST <= TO_CHAR(?)");
		if (codest != null)
			sql.append(" AND A.Code_st=?");
		if (incno != null)
			sql.append(" AND B.INCNO=?");
		if (id_stoep != null){
			sql.append(" AND A.ID_STOEP=?");	
			sql.append(" AND NVL(ERRO.fg_rollback,'Y')<>'Y'");
		}
		else
			sql.append(" AND NVL(ERRO.fg_rollback,'Y')<>'N'");
		if (eu_direct != null)
			sql.append(" AND A.EU_DIRECT=?");
		if (fg_canc != null)
			sql.append(" AND A.FG_CANC =?");
        sql.append(" ORDER BY A.DT_ST DESC, B.INCNO ASC");
		return sql.toString();

	}

}
