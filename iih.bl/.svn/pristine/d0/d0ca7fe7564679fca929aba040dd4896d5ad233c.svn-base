package iih.bl.cg.bp;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 医嘱补费：获得门诊和住院预交金余额
 * @author tcy
 *
 */
public class GetPerpaymentAmount {
	/**
	 * 获得门诊账户余额
	 * @param pat_Id
	 * @return
	 */
	public FDouble GetOutpPrepaymentAmount(String pat_Id) throws BizException 
	{
		//判断门诊账户是否已被锁定，已被锁定的账户不能执行记账操作
		ColumnHandler handler = new ColumnHandler();
		StringBuffer sql=new StringBuffer();
		sql.append(" SELECT A.SD_ACCSTA "); //-- 0 正常 1 冻结
		sql.append(" FROM PI_PAT_ACC A ");
		sql.append(" WHERE A.ID_PAT = ?");
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(pat_Id);
		DAFacade cade = new DAFacade();
		Object  SD_ACCSTA = cade.execQuery(sql.toString(), sqlParam, handler);
		if (SD_ACCSTA.equals(null)) {
			throw new BizException("门诊患者账户不存在");
		}
		if (SD_ACCSTA.toString().equals("1")) {
			throw new BizException("门诊患者账户被冻结");
		}
		
		
		
		StringBuffer sql2=new StringBuffer();
		sql2.append(" SELECT A.PREPAY + A.CRED - A.ACC_LOCK "); //
		sql2.append(" FROM PI_PAT_ACC A ");
		sql2.append(" WHERE A.ID_PAT = ?");
		SqlParam sqlParam2 = new SqlParam();
		sqlParam2.addParam(pat_Id);
		DAFacade cade2 = new DAFacade();
		Object  amount = cade.execQuery(sql2.toString(),sqlParam2,handler);
		if (amount.equals(null)) {
			throw new BizException("门诊患者账户余额不存在");
		}
		
		return (FDouble)amount;
	}
	/**
	 * 获得住院账户余额
	 * @param pat_Id病人ID
	 * @param ID_ENT就诊ID
	 * @return
	 */
	public FDouble GetInpPrepaymentAmount(String PAT_ID,String ID_ENT)  throws BizException {
		//如何获取账户数据锁？？？？		
			
		ColumnHandler handler = new ColumnHandler();
		StringBuffer sql2=new StringBuffer();
		sql2.append(" SELECT A.AMT_PREPAY + A.AMT_CRED - A.AMT_UNCG"); //
		sql2.append(" FROM EN_ENT_ACC A ");
		sql2.append(" WHERE A.ID_PAT = ? AND A.ID_ENT=?");
		SqlParam sqlParam2 = new SqlParam();
		sqlParam2.addParam(PAT_ID);
		sqlParam2.addParam(ID_ENT);
		DAFacade cade2 = new DAFacade();
		Object  amount = cade2.execQuery(sql2.toString(),sqlParam2,handler);
		if (amount.equals(null)) {
			throw new BizException("住院患者账户余额不存在");
		}
		
		return (FDouble)amount;
	}

}
