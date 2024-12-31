package iih.bl.cg.s.cglogic.util;

import iih.bl.comm.util.BlPeCmpyUtil;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.i.IEnOutCmdService;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.out.i.IEn4BlQryService;

import java.math.BigDecimal;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 账户处理工具类
 * @author ly 2018/06/04
 *
 */
public class BlCgAccUtil {

	/**
	 * 住院记账插入数据后更新账户数据
	 * @param entId 就诊id
	 * @param fgSupport 是否支持后付费
	 * @param amt 金额
	 */
	public static void updateAccAfterIpCg(String entId,FBoolean fgSupport,FDouble amt) throws BizException{
		//入参不校验
		
		//1.判断是否团检患者
		String peCmpyId = BlPeCmpyUtil.isPecmpy(entId);
		
		if(StringUtil.isEmpty(peCmpyId)){
			updateIpAcc(entId, fgSupport, amt);
		}else{
			updatePeCmpyAcc(peCmpyId, fgSupport, amt);
		}
	}
	
	/**
	 * 更新就诊账户
	 * @param entId
	 * @param fgSupport
	 * @param amt
	 * @throws BizException
	 */
	private static void updateIpAcc(String entId,FBoolean fgSupport,FDouble amt)throws BizException{
		
		IEnOutQryService rService = ServiceFinder.find(IEnOutQryService.class);
		BalanceDTO balanceDTO = rService.getBalanceDTO(entId);
		if (balanceDTO.getAvailable().compareTo(amt) < 0 && !FBoolean.TRUE.equals(fgSupport)) {

			throw new BizException("住院预交金余额不足，不支持后付费！\r\n本次执行金额："
					+ amt.setScale(-2, BigDecimal.ROUND_HALF_UP).toString()
					+ "\r\n差额："
					+ amt.sub(balanceDTO.getAvailable()).setScale(-2, BigDecimal.ROUND_HALF_UP).toString());
		}
		
		IEnOutCmdService cmdService = ServiceFinder.find(IEnOutCmdService.class);
		cmdService.consume(entId, amt);
	}
	
	/**
	 * 更新团检账户
	 * @param peCmpyId
	 * @param fgSupport
	 * @param amt
	 * @throws BizException
	 */
	private static void updatePeCmpyAcc(String peCmpyId,FBoolean fgSupport,FDouble amt)throws BizException{
	
		IEn4BlQryService rService = ServiceFinder.find(IEn4BlQryService.class);
		BalanceDTO balanceDTO = rService.getPeCmpyBalance(peCmpyId);
		
		if (balanceDTO.getAvailable().compareTo(amt) < 0 && !FBoolean.TRUE.equals(fgSupport)) {

			throw new BizException("住院预交金余额不足，不支持后付费！\r\n本次执行金额："
					+ amt.setScale(-2, BigDecimal.ROUND_HALF_UP).toString()
					+ "\r\n差额："
					+ amt.sub(balanceDTO.getAvailable()).setScale(-2, BigDecimal.ROUND_HALF_UP).toString());
		}
		
		IEnOutCmdService cmdService = ServiceFinder.find(IEnOutCmdService.class);
		cmdService.cmpyConsume(peCmpyId, amt);
	}
}
