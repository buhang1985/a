package iih.bl.pay.s.bp;

import java.util.List;

import iih.bd.base.validator.ParamValidator;
import iih.bl.pay.dto.d.BlPayPmDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取挂号支付明细
 * @author yankan
 * @since 2017-07-06
 *
 */
public class GetOpRegPayDetailBP {
	/**
	 * 获取挂号支付明细
	 * @param cgId
	 * @return
	 * @throws BizException
	 */
	public BlPayPmDTO[] exec(String cgId) throws BizException{
		ParamValidator.validateNotNull("记账ID", cgId);
		
		//1、获取付款主表ID
		String payPatId = this.getPayPatIdByCgId(cgId);
		
		//2、获取支付明细
		return getPayItmList(payPatId);
	}
	/**
	 * 根据记账ID获取付款ID
	 * @param cgId 记账ID
	 * @return
	 * @throws BizException
	 */
	private String getPayPatIdByCgId(String cgId) throws BizException{
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT ST.ID_PAYPATOEP ");
		sqlBuilder.append(" FROM BL_ST_OEP ST ");
		sqlBuilder.append(" LEFT JOIN BL_CG_ITM_OEP CGITM ON CGITM.ID_STOEP=ST.ID_STOEP");
		sqlBuilder.append(" WHERE CGITM.ID_CGOEP=?");
		
		SqlParam param = new SqlParam();
		param.addParam(cgId);
		String payPatId = (String)new DAFacade().execQuery(sqlBuilder.toString(), param, new ColumnHandler());
		return payPatId;
	}
	/**
	 * 获取付款明细
	 * @param payId 付款ID
	 * @return
	 * @throws BizException
	 */
	private BlPayPmDTO[] getPayItmList(String payId) throws BizException {
		if(StringUtil.isEmpty(payId)){
			return null;
		}
		
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT PAYITM.ID_PM,PAYITM.SD_PM,PM.NAME,");
		sqlBuilder.append("PAYITM.AMT,PAYITM.EU_DIRECT AS PM_EU_DIRECT,FG_REALPAY,");
		sqlBuilder.append("ID_BANK,BANKNO,");
		sqlBuilder.append("PAYITM.ID_CUST,CUST.NAME AS ID_CUST_NAME,");
		sqlBuilder.append("PAYITM.PAYMODENODE, ");
		sqlBuilder.append(" OEP.Sd_Pttp, ");
		sqlBuilder.append(" STOEP.ID_STOEP AS ID_ST ");
		sqlBuilder.append(" FROM BL_PAY_PAT_OEP OEP  ");
		sqlBuilder.append(" INNER JOIN BL_PAY_ITM_PAT_OEP  PAYITM  ON OEP.ID_PAYPATOEP =PAYITM.ID_PAYPATOEP ");
		sqlBuilder.append(" INNER JOIN BL_ST_OEP STOEP ON STOEP.ID_PAYPATOEP =OEP.ID_PAYPATOEP ");
		sqlBuilder.append(" LEFT JOIN BD_CUST CUST ON CUST.ID_CUST = PAYITM.ID_CUST ");
		sqlBuilder.append(" LEFT JOIN BD_PRI_PM PM ON PM.ID_PM = PAYITM.ID_PM");
		sqlBuilder.append(" WHERE OEP.ID_PAYPATOEP=?");
		
		SqlParam param= new SqlParam();
		param.addParam(payId);
		List<BlPayPmDTO> payPmList = (List<BlPayPmDTO>)new DAFacade().execQuery(sqlBuilder.toString(), param,new BeanListHandler(BlPayPmDTO.class));
		if(ListUtil.isEmpty(payPmList)){
			return null;
		}
		
		return payPmList.toArray(new BlPayPmDTO[0]);
	}
}
