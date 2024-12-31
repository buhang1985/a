package iih.bl.pay.s.bp;

import java.util.List;

import iih.bl.pay.dto.d.BlPayPatQyDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class BlPayPatQyBp {

	/**
	 * 根据就诊类型来查询所有的门诊预交金和住院的某次住院的预交金缴费记录
	 * @param strEnt
	 * @param strPat
	 * @param strEnttp
	 * @return
	 * @throws BizException
	 */

	public BlPayPatQyDTO[] getPayItmList(String strPat ,String strEnttp) throws BizException {
		if(StringUtil.isEmpty(strPat) && StringUtil.isEmpty(strEnttp) ){
			return null;
		}
		
		StringBuilder sqlSB = new StringBuilder();
		sqlSB.append(" SELECT    BL_PAY.ID_PAYPAT, ");
		sqlSB.append(" BL_PAY.ID_GRP, ");
		sqlSB.append(" BL_PAY.ID_ORG, ");
		sqlSB.append(" BL_PAY.ID_ENTTP, ");
		sqlSB.append(" ENT_IP.CODE_AMR_IP, ");
		sqlSB.append(" ENT_IP.TIMES_IP, ");
		sqlSB.append(" PRI_PM.NAME  AS  NAME_PM, ");
		sqlSB.append(" BL_PAY.AMT*BL_PAY.EU_DIRECT    AS  AMT, ");
		sqlSB.append(" BL_PAY.DT_PAY, ");
		sqlSB.append(" PSNDOC.NAME  AS  ID_EMP_PAY, ");
		sqlSB.append(" BL_PAY.NOTE, ");
		sqlSB.append(" BL_PAY.FG_CANC ");
		sqlSB.append(" FROM    BL_PREPAY_PAT    BL_PAY ");
		sqlSB.append(" LEFT    JOIN    EN_ENT_IP    ENT_IP    ON    BL_PAY.ID_ENT    =    ENT_IP.ID_ENT ");
		sqlSB.append(" LEFT    JOIN    BD_PSNDOC    PSNDOC    ON    BL_PAY.ID_EMP_PAY  =  PSNDOC.ID_PSNDOC ");
		sqlSB.append(" LEFT    JOIN    BD_PRI_PM    PRI_PM    ON    BL_PAY.ID_PM  =  PRI_PM.ID_PM ");
		sqlSB.append(" WHERE  BL_PAY.ID_PAT  = ?    AND    BL_PAY.ID_ENTTP  = ? ");
		sqlSB.append(" ORDER  BY  BL_PAY.DT_PAY ");
		SqlParam param= new SqlParam();
		param.addParam(strPat);
		param.addParam(strEnttp);
		
		List<BlPayPatQyDTO> payPmList = (List<BlPayPatQyDTO>)new DAFacade().execQuery(sqlSB.toString(), param,new BeanListHandler(BlPayPatQyDTO.class));
		if(ListUtil.isEmpty(payPmList)){
			return null;
		}
		
		return payPmList.toArray(new BlPayPatQyDTO[0]);
	}
}
