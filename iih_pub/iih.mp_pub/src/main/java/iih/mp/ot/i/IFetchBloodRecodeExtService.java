package iih.mp.ot.i;

import iih.mp.ne.mptb.d.MpTbDO;
import iih.mp.ot.fetchrecoder.d.FetchrecoderDTO;
import iih.mp.ot.fetchrecoder.d.FetchrecoderitmDTO;
import xap.mw.core.data.BizException;

public interface IFetchBloodRecodeExtService {

	/**
	 * 取血申请单信息查询
	 * 
	 * @param Id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract FetchrecoderDTO getFetchInfo(String Id_ent) throws BizException;

	/**
	 * 获取取血生清单明细
	 * 
	 * @param Id_rptbttest
	 *            (医嘱_备血检验结果主表主键)
	 * @return
	 * @throws BizException
	 */
	public abstract FetchrecoderitmDTO[] getFetchBloodList(String Id_rptbttest) throws BizException;

	/**
	 * 取血信息保存
	 * 
	 * @param DTOS(本次取血信息)
	 * @param No_aplyfrom用血申请单号      
	 * @return
	 * @throws BizException
	 */
	public abstract FetchrecoderitmDTO[] fetchBloodSave(FetchrecoderitmDTO[] DTOS, FetchrecoderDTO DTO) throws BizException;
	
	/**
	 * 获取发血单
	 * @param No_aplyfrom 用血申请单号
	 * @return
	 * @throws BizException
	 */
	public abstract MpTbDO getMpTbDO (String No_aplyfrom) throws BizException;

}
