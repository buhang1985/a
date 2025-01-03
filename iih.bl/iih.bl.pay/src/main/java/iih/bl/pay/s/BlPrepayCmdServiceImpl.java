package iih.bl.pay.s;

import java.util.Map;

import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.dto.prepay.d.BlPrepayCDTO;
import iih.bl.pay.dto.prepay.d.BlPrepayRDTO;
import iih.bl.pay.dto.prepay.d.BlPrepaySTDTO;
import iih.bl.pay.dto.prepay.d.BlPrepaySetDTO;
import iih.bl.pay.dto.prepay.d.BlPrepayTDTO;
import iih.bl.pay.dto.prepay.d.BlPrepayVDTO;
import iih.bl.pay.i.IBlPrepayCmdService;
import iih.bl.pay.s.bp.prepay.BlPrepayAbolishBP;
import iih.bl.pay.s.bp.prepay.BlPrepayCancelTradeBP;
import iih.bl.pay.s.bp.prepay.BlPrepayConsumeAmtBP;
import iih.bl.pay.s.bp.prepay.BlPrepayConsumeBP;
import iih.bl.pay.s.bp.prepay.BlPrepayIpToOepBP;
import iih.bl.pay.s.bp.prepay.BlPrepayRechargeBP;
import iih.bl.pay.s.bp.prepay.BlPrepayRefundAmtBP;
import iih.bl.pay.s.bp.prepay.BlPrepayRefundBP;
import iih.bl.pay.s.bp.prepay.BlPrepayReverseBP;
import iih.bl.pay.s.bp.prepay.BlPrepayStTransferBP;
import iih.bl.pay.s.bp.prepay.BlPrepayTransferBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 预交金命令服务
 * @author ly 2018/07/19
 *
 */
@Service(serviceInterfaces = { IBlPrepayCmdService.class }, binding = Binding.JSONRPC)
public class BlPrepayCmdServiceImpl implements IBlPrepayCmdService {

	/**
	 * 预交金充值
	 * @param dto 充值数据
	 * @param setDto 配置
	 * @throws BizException
	 * @return 预交金DO
	 * @author ly 2018/07/19
	 */
	@Override
	public BlPrePayPatDO recharge(BlPrepayRDTO dto, BlPrepaySetDTO setDto) throws BizException {
		BlPrepayRechargeBP bp = new BlPrepayRechargeBP(setDto);
		return bp.exec(dto);
	}

	/**
	 * 预交金退充值
	 * @param dto 退充值数据
	 * @param setDto 配置数据
	 * @throws BizException
	 * @return 预交金DO
	 * @author ly 2018/07/19
	 */
	@Override
	public BlPrePayPatDO refund(BlPrepayRDTO dto, BlPrepaySetDTO setDto) throws BizException {
		BlPrepayRefundBP bp = new BlPrepayRefundBP(setDto);
		return bp.exec(dto);
	}
	
	/**
	 * 预交金作废
	 * @param dto 退充值数据
	 * @param setDto 配置数据
	 * @return 预交金DO
	 * @throws BizException
	 * @author ly 2019/04/01
	 */
	@Override
	public BlPrePayPatDO abolish(BlPrepayRDTO dto, BlPrepaySetDTO setDto) throws BizException {
		BlPrepayAbolishBP bp = new BlPrepayAbolishBP(setDto);
		return bp.exec(dto);
	}

	/**
	 * 预交金消费
	 * @param dto 消费数据
	 * @param setDto 配置数据
	 * @throws BizException
	 * @return 预交金DO数组
	 * @author ly 2018/07/19
	 */
	@Override
	public BlPrePayPatDO[] consume(BlPrepayCDTO dto, BlPrepaySetDTO setDto) throws BizException {
		BlPrepayConsumeBP bp = new BlPrepayConsumeBP(setDto);
		return bp.exec(dto);
	}
	
	/**
	 * 预交金消费(直接金额消费)
	 * @param dto 消费数据
	 * @param setDto 配置数据
	 * @return 预交金DO
	 * @throws BizException
	 * @author ly 2018/12/08
	 */
	@Override
	public BlPrePayPatDO consumeAmt(BlPrepayCDTO dto, BlPrepaySetDTO setDto) throws BizException {
		BlPrepayConsumeAmtBP bp = new BlPrepayConsumeAmtBP(setDto);
		return bp.exec(dto);
	}
	
	/**
	 * 预交金退消费(直接金额消费)
	 * @param dto 消费数据
	 * @param setDto 配置数据
	 * @return 预交金DO
	 * @throws BizException
	 * @author ly 2018/12/21
	 */
	@Override
	public BlPrePayPatDO consumeAmtRefund(BlPrepayCDTO dto, BlPrepaySetDTO setDto) throws BizException{
		BlPrepayRefundAmtBP bp = new BlPrepayRefundAmtBP(setDto);
		return bp.exec(dto);
	}

	/**
	 * 预交金转移
	 * 门诊转住院，住院转住院
	 * @param dto 转移数据
	 * @param setDto 配置数据
	 * @throws BizException
	 * @return 预交金DO
	 * @author ly 2018/07/19
	 */
	public BlPrePayPatDO[] transfer(BlPrepayTDTO dto, BlPrepaySetDTO setDto) throws BizException{
		BlPrepayTransferBP bp = new BlPrepayTransferBP(setDto);
		return bp.exec(dto);
	}
	
	/**
	 * 预交金结转
	 * @param dto 结转数据
	 * @param setDto 配置数据
	 * @throws BizException
	 * @return 预交金DO
	 * @author ly 2018/07/19
	 */
	@Override
	public BlPrePayPatDO[] stTransfer(BlPrepaySTDTO[] dto, BlPrepaySetDTO setDto) throws BizException {
		BlPrepayStTransferBP bp = new BlPrepayStTransferBP(setDto);
		return bp.exec(dto);
	}

	/**
	 * 预交金退费冲账
	 * @param dto 退费数据
	 * @param setDto 配置数据
	 * @throws BizException
	 * @return 预交金DO
	 * @author ly 2018/07/19
	 */
	@Override
	public BlPrePayPatDO reverse(BlPrepaySTDTO dto, BlPrepaySetDTO setDto) throws BizException {
		BlPrepayReverseBP bp = new BlPrepayReverseBP(setDto);
		return bp.exec(dto);
	}

	/**
	 * 预交金取消出纳
	 * @param dto 还原数据
	 * @param setDto 配置数据
	 * @return key:原预交金数据 value:新预交金数据
	 * @throws BizException 
	 * @author ly 2018/07/19
	 */
	@Override
	public Map<String, BlPrePayPatDO> cancelTrade(BlPrepayVDTO dto, BlPrepaySetDTO setDto) throws BizException {
		BlPrepayCancelTradeBP bp = new BlPrepayCancelTradeBP(setDto);
		return bp.exec(dto);
	}

	/**
	 * 预交金转门诊
	 */
	@Override
	public BlPrePayPatDO prepayIpToOep(BlPrepayRDTO dto, BlPrepaySetDTO setDto) throws BizException {
		BlPrepayIpToOepBP bp = new BlPrepayIpToOepBP(setDto);
		return bp.exec(dto);
	}
}
