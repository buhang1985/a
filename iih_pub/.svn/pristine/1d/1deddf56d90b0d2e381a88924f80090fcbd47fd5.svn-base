package iih.mi.biz.service.i;

import iih.mi.biz.miorderrecord.d.MiOrderrecordDO;
import iih.mi.biz.mirecordstrecord.d.MiOrderStRecordDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 医保相关记录信息查询
 * @author liming06 
 * @since 2019-08-22
 *
 */
public interface IMiBizQueService {
	
	/**
	 * 根据结算号查询重收的交易记录
	 * @param code_st 结算编号
	 * @return
	 * @throws BizException
	 */
	public abstract MiOrderrecordDO[] findMiOrderReCharge(String code_st) throws BizException;
	
	/**
	 * 根据结算号查询退费重收的结算交易记录
	 * @param code_st
	 * @param bCharge 查询收或退
	 * @return
	 * @throws BizException
	 */
	public abstract MiOrderStRecordDO[] findMiOrderSTForReFund(String code_st,FBoolean bCharge) throws BizException;
}
