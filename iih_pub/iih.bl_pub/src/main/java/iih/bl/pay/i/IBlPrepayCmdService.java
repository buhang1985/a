package iih.bl.pay.i;

import java.util.Map;

import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.dto.prepay.d.BlPrepayCDTO;
import iih.bl.pay.dto.prepay.d.BlPrepayRDTO;
import iih.bl.pay.dto.prepay.d.BlPrepaySTDTO;
import iih.bl.pay.dto.prepay.d.BlPrepaySetDTO;
import iih.bl.pay.dto.prepay.d.BlPrepayTDTO;
import iih.bl.pay.dto.prepay.d.BlPrepayVDTO;
import xap.mw.core.data.BizException;

/**
 * 预交金命令服务
 * @author ly 2018/07/19
 *
 */
public interface IBlPrepayCmdService {

	/**
	 * 预交金充值
	 * @param dto 充值数据
	 * @param setDto 配置数据
	 * @throws BizException
	 * @return 预交金DO
	 * @author ly 2018/07/19
	 */
	public abstract BlPrePayPatDO recharge(BlPrepayRDTO dto, BlPrepaySetDTO setDto) throws BizException;
	
	/**
	 * 预交金退充值
	 * @param dto 退充值数据
	 * @param setDto 配置数据
	 * @throws BizException
	 * @return 预交金DO
	 * @author ly 2018/07/19
	 */
	public abstract BlPrePayPatDO refund(BlPrepayRDTO dto, BlPrepaySetDTO setDto) throws BizException;
	
	/**
	 * 预交金作废
	 * @param dto 退充值数据
	 * @param setDto 配置数据
	 * @return 预交金DO
	 * @throws BizException
	  * @author ly 2019/04/01
	 */
	public abstract BlPrePayPatDO abolish(BlPrepayRDTO dto, BlPrepaySetDTO setDto) throws BizException;
	
	/**
	 * 预交金消费
	 * @param dto 消费数据
	 * @param setDto 配置数据
	 * @throws BizException
	 * @return 预交金DO数组
	 * @author ly 2018/07/19
	 */
	public abstract BlPrePayPatDO[] consume(BlPrepayCDTO dto, BlPrepaySetDTO setDto) throws BizException;
	
	/**
	 * 预交金消费(直接金额消费)
	 * @param dto 消费数据
	 * @param setDto 配置数据
	 * @return 预交金DO
	 * @throws BizException
	 * @author ly 2018/12/08
	 */
	public abstract BlPrePayPatDO consumeAmt(BlPrepayCDTO dto, BlPrepaySetDTO setDto) throws BizException;
	
	/**
	 * 预交金退消费(直接金额消费)
	 * @param dto 消费数据
	 * @param setDto 配置数据
	 * @return 预交金DO
	 * @throws BizException
	 * @author ly 2018/12/21
	 */
	public abstract BlPrePayPatDO consumeAmtRefund(BlPrepayCDTO dto, BlPrepaySetDTO setDto) throws BizException;
	
	/**
	 * 预交金转移
	 * 门诊转住院，住院转住院
	 * @param dto 转移数据
	 * @param setDto 配置数据
	 * @throws BizException
	 * @return 预交金DO
	 * @author ly 2018/07/19
	 */
	public abstract BlPrePayPatDO[] transfer(BlPrepayTDTO dto, BlPrepaySetDTO setDto) throws BizException;
	
	/**
	 * 预交金结转
	 * @param dto 结转数据
	 * @param setDto 配置数据
	 * @throws BizException
	 * @return 预交金DO
	 * @author ly 2018/07/19
	 */
	public abstract BlPrePayPatDO[] stTransfer(BlPrepaySTDTO[] dto, BlPrepaySetDTO setDto) throws BizException;
	
	/**
	 * 预交金退费冲账
	 * @param dto 退费数据
	 * @param setDto 配置数据
	 * @throws BizException
	 * @return 预交金DO
	 * @author ly 2018/07/19
	 */
	public abstract BlPrePayPatDO reverse(BlPrepaySTDTO dto, BlPrepaySetDTO setDto) throws BizException;
	
	/**
	 * 预交金取消出纳
	 * @param dto 还原数据
	 * @param setDto 配置数据
	 * @return key:原预交金数据 value:新预交金数据
	 * @throws BizException
	 * @author ly 2018/07/19
	 */
	public abstract Map<String, BlPrePayPatDO> cancelTrade(BlPrepayVDTO dto, BlPrepaySetDTO setDto) throws BizException;
	
	/**
	 * 预交金住院转门诊
	 * @param dto
	 * @param setDto
	 * @return
	 * @throws BizException
	 * @author hanjq 2020/05/12
	 */
	public abstract BlPrePayPatDO prepayIpToOep(BlPrepayRDTO dto, BlPrepaySetDTO setDto) throws BizException;
	
}
