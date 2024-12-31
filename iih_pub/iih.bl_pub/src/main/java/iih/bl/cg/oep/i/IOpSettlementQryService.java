package iih.bl.cg.oep.i;

import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.st.dto.d.IncDataInfoOepDTO;
import xap.mw.core.data.BizException;

/**
 * 门诊结算业务相关的一些查询集合
 * @author yangyang
 *
 */
public interface IOpSettlementQryService {

	public abstract IncDataInfoOepDTO[] getIncData(String strIdPat,String dtBegin ,String dtEnd) throws BizException;

	/**
	 * 获取未记账医嘱信息
	 * @throws BizException 
	 */
	public abstract BlOrderAppendBillParamDTO[] getNoBookkeepingCiSrv(String patId) throws BizException; 

}
