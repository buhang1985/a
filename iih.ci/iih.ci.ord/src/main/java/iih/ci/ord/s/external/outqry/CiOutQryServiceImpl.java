package iih.ci.ord.s.external.outqry;

import java.lang.reflect.InvocationTargetException;

import org.springframework.transaction.TransactionStatus;

import iih.ci.ord.external.outqry.d.OrdQueryParamDTO;
import iih.ci.ord.i.external.outqry.ICiOutQryService;
import iih.ci.ord.s.external.outqry.bp.CiOutQueryUtils;
import iih.ci.ord.s.external.outqry.bp.OpCiOutQryBP;
import xap.mw.core.data.BizException;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
/**
 * 提供给第三方的临床查询接口
 * @author iih-pc
 *
 */
public class CiOutQryServiceImpl implements ICiOutQryService {

	@Override
	public String ciOrdQry(String xmlParam) {
		final String xmlstr=xmlParam;
		try {
		// TODO Auto-generated method stub
		return TransactionExecutor.executeNewTransaction(new TransactionalOperation<String>() {

			@Override
			public String doInTransaction(TransactionStatus arg0) throws InvocationTargetException {
				// TODO Auto-generated method stub
				
				try {
					OrdQueryParamDTO param=(OrdQueryParamDTO)CiOutQueryUtils.PraseXmlToDTO(xmlstr, OrdQueryParamDTO.class);
					return new OpCiOutQryBP().OpCiOutQryBP(param);
				} catch (BizException e) {
					// TODO Auto-generated catch block
					throw new RuntimeException(e.getMessage());
				}
			}
		});
		}catch(Exception ex) {
			return CiOutQueryUtils.getErrMsg(ex.getMessage());
		}

	}

}
