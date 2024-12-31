package iih.mi.biz.service.s;

import iih.mi.biz.dto.miorderstrecorddto.d.MiOrderStRecordDTO;
import iih.mi.biz.miorderrecord.d.MiOrderrecordDO;
import iih.mi.biz.mirecordstrecord.d.MiOrderStRecordDO;
import iih.mi.biz.service.i.IMiBizQueService;
import iih.mi.biz.service.s.bp.FindMiOrderReCharge;
import iih.mi.biz.service.s.bp.FindMiOrderSTForReFund;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;

/**
 * 医保相关记录信息查询
 * @author liming06 
 * @since 2019-08-22
 *
 */
@Service(serviceInterfaces = { IMiBizQueService.class }, binding = Binding.JSONRPC)
public class MiBizQueServiceImpl implements IMiBizQueService{

	/**
	 * 根据结算号查询重收的交易记录
	 * @param code_st 结算编号
	 * @return
	 * @throws BizException
	 */
	@Override
	public MiOrderrecordDO[] findMiOrderReCharge(String code_st)throws BizException {
		FindMiOrderReCharge bp= new FindMiOrderReCharge();
		return bp.exec(code_st);
	}

	/**
	 * 根据结算号查询退费重收的结算交易记录
	 * @param code_st
	 * @param code_st 查询收退方式
	 * @return
	 * @throws BizException
	 */
	@Override
	public MiOrderStRecordDO[] findMiOrderSTForReFund(String code_st,FBoolean bCharge) throws BizException {
		FindMiOrderSTForReFund bp= new FindMiOrderSTForReFund();
		return bp.exec(code_st,bCharge);
	}

}
