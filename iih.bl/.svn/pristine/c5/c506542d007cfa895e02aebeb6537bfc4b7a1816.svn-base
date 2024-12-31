package iih.bl.inc.s.bp;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 获取当前票号是否作废
 * @author LIM
 *
 */
public class GetCurnoCancStatusBP {
	/**
	 * 获取当前票号是否作废
	 * @param invoiceNo 票号
	 * @param strCodeIncca 票包编码
	 * @return
	 * @throws BizException
	 */
	public FBoolean  exec(String invoiceNo, String strCodeIncca) throws BizException {
		FBoolean bCanc= FBoolean.FALSE;
		//1.参数校验
		this.validata(invoiceNo,strCodeIncca);
		//2.获取数据
		bCanc=this.validateCancInvoiceNo(invoiceNo,strCodeIncca);
		return bCanc;
	}
	
	/**
	 * 校验参数
	 * @param invoiceNo
	 * @param strCodeIncca
	 * @throws BizException
	 */
	private void validata(String invoiceNo, String strCodeIncca) throws BizException{
		if(StringUtils.isEmpty(invoiceNo)){
			throw new BizException("票号不能为空！");
		}
		if(StringUtils.isEmpty(strCodeIncca)){
			throw new BizException("票据包编码不能为空！");
		}
	}
	/**
	 * 检查票号是否是已作废的空白票
	 * 
	 * @return已作废票：返回为TRUE;非作废票：返回False
	 */
	private FBoolean validateCancInvoiceNo(String invoiceNo, String strCodeIncca) throws BizException {
		// 检查下一票是否属于已作废的废票
		ColumnHandler handler1 = new ColumnHandler();

		StringBuffer strWhere = new StringBuffer();
		strWhere.append(" SELECT B.INCNO FROM BL_INC_CANC B");
		strWhere.append(" INNER JOIN BL_INC_ISS A ON A.ID_GRP=B.ID_GRP AND A.ID_ORG=B.ID_ORG");
		strWhere.append(" INNER JOIN BD_INCCA C ON C.ID_INCCA=B.ID_INCCA");
		strWhere.append(" WHERE A.FG_CURUSE='Y' AND A.DS=0 AND A.FG_ACTIVE='Y'");
		strWhere.append(" AND C.CODE=?");
		strWhere.append(" AND A.ID_ORG=?");
		strWhere.append(" AND A.ID_GRP=?");
		strWhere.append(" AND B.INCNO=?");
		DAFacade cade = new DAFacade();
		SqlParam sqlP = new SqlParam();
		sqlP.addParam(strCodeIncca);
		sqlP.addParam(invoiceNo);
		sqlP.addParam(Context.get().getOrgId());
		sqlP.addParam(Context.get().getGroupId());
		Object id_incisso = cade.execQuery(strWhere.toString(), sqlP, handler1);
		if (id_incisso == null) {
			return FBoolean.FALSE; // 未被作废
		}
		return FBoolean.TRUE; // 被作废
	}
}

