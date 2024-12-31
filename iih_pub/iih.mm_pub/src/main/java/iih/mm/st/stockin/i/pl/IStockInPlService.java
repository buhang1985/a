package iih.mm.st.stockin.i.pl;

import xap.mw.core.data.BizException;

/**
 * 采购入库对接第三方平台接口
 * 
 * @author dj.zhang
 *
 */
public interface IStockInPlService {

	/**
	 * 核对入库单数据
	 * 
	 * @param ids
	 * @return
	 * @throws BizException
	 */
	public abstract String checkStoDt(String[] ids) throws BizException;
	
	
	/**
	 * 下载平台数据
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract String pullStoDt() throws BizException;

}
