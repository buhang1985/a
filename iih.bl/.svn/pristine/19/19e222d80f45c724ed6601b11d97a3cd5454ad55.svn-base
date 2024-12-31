package iih.bl.hp.s.bp;

import iih.bl.hp.dto.d.AccountCheckDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取就诊结算费用信息 （住院医保明细对账）
 * @author yangyang
 */
public class GetEntIpFeeBp {

	/**
	 * @param strIdEnt 就诊主键ID
	 * @return 费用信息
	 * @throws BizException
	 */
	public AccountCheckDTO[] exec(String strIdEnt) throws BizException
	{
		StringBuilder sb=new StringBuilder();
		sb.append(" SELECT STIP.ID_PAT,PAT.NAME AS NAME_PAT,ENENT.CODE AS CODE_ENENT,STIP.AMT_RATIO AS AMTST,STIP.EU_STTP,");
		sb.append(" PAYIP.AMT AS AMTPAY");
		sb.append(" FROM BL_ST_IP STIP");
		sb.append(" INNER JOIN BL_PAY_PAT_IP PAYIP ON PAYIP.ID_STIP=STIP.ID_STIP");
		sb.append(" INNER JOIN PI_PAT PAT ON STIP.ID_PAT=PAT.ID_PAT");
		sb.append(" INNER JOIN EN_ENT ENENT ON STIP.ID_ENT=ENENT.ID_ENT");
		sb.append(" WHERE STIP.EU_DIRECT=1 AND STIP.FG_CANC='N' AND STIP.ID_ENT=? AND STIP.FG_PAY='Y'");
		SqlParam param=new SqlParam();
		param.addParam(strIdEnt);
		
        @SuppressWarnings("unchecked")
        List<AccountCheckDTO> list = (List<AccountCheckDTO>) new DAFacade().execQuery(sb.toString(), param, new BeanListHandler(AccountCheckDTO.class));
		return list.toArray(new AccountCheckDTO[0]);
	}
}
