package iih.bl.inc.s.util;

import iih.bl.comm.IBlMsgConst;
import iih.bl.comm.util.BlIncNumStrUtil;
import iih.bl.inc.blinccanc.d.BlIncCancDO;
import iih.bl.inc.blinciss.d.BlIncIssDO;
import iih.bl.inc.s.ep.CancIncEP;
import iih.bl.inc.s.ep.IncIssEP;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;

/**
 * 发票计算工具类
 * @author ly 2018/03/29
 *
 */
public class InvoiceCalUtil {
	
	/**
	 * 获取从当前号开始指定数量可用发票号
	 * @param num 发票数量
	 * @param incInfo 票据包信息
	 * @param cancInfos 作废票据信息
	 * @throws BizException
	 */
	public static String[] nextInvoice(Integer num, BlIncIssDO incInfo, BlIncCancDO[] cancInfos) throws BizException{
		
		int calNum = num;//计算用数量
		
		if(incInfo.getInccn_use() < calNum){
			throw new BizException(IBlMsgConst.ERROR_INCISS_NOT_ENOUGH + " 需要可用发票数量：" + num);
		}
		List<String> cancIncList = new ArrayList<String>();
		if(!ArrayUtil.isEmpty(cancInfos)){
			for (BlIncCancDO cancInfo : cancInfos) {
				cancIncList.add(cancInfo.getIncno());
			}
		}
		
		List<String> incList = new ArrayList<String>();
		
		String[] splits = BlIncNumStrUtil.splitComputable(incInfo.getIncno_cur());
		String head = splits[0];//头信息
		String incnoStr = splits[1];//数字部分
		Long incno = Long.valueOf(incnoStr);
		for (int i = 0; i < calNum; i++) {
			
			//计算下个票号
			String nextInc = BlIncNumStrUtil.addZero(incnoStr.length(), String.valueOf(incno + i));
			
			//最大位判断
			if(nextInc.length() > incnoStr.length()){
				throw new BizException(IBlMsgConst.ERROR_INCISS_NOT_ENOUGH + " 需要可用发票数量：" + num);
			}
			//补充头部
			nextInc = head + nextInc;
			
			//判断是否废票
			if (cancIncList.contains(nextInc)) {
				calNum++;
			} else {
				
				//判断数量是否超过最大值
				if(nextInc.compareTo(incInfo.getNum_e()) > 0){
					throw new BizException(IBlMsgConst.ERROR_INCISS_NOT_ENOUGH + " 需要可用发票数量：" + num);
				}
				
				incList.add(nextInc);
			}
		}
		
		return incList.toArray(new String[0]);
	}
	
	/**
	 * 获取从当前号开始指定数量可用发票号
	 * @param num 发票数量
	 * @param incInfo 票据包信息
	 * @return
	 * @throws BizException
	 */
	public static String[] nextInvoice(Integer num, BlIncIssDO incInfo) throws BizException{
		BlIncCancDO[] cancDos = new CancIncEP().findCancInc(
				incInfo.getId_incca(), incInfo.getCode_incpkg(),
				incInfo.getIncno_cur());
		return nextInvoice(num, incInfo, cancDos);
	}
	
	/**
	 * 获取当前在用票据包当前号开始指定数量可用发票号
	 * @param num 发票数量
	 * @param empId 人员id
	 * @param inccaId 发票分类id
	 * @return
	 * @throws BizException
	 */
	public static String[] nextInvoice(Integer num, String empId, String pcId, String inccaId) throws BizException{
		BlIncIssDO incInfo =new IncIssEP().findUsingInc(empId, pcId, inccaId);
		return nextInvoice(num, incInfo);
	}
	
	/**
	 * 计算下一个可用的发票号码
	 * @param incnoCur 当前号码
	 * @param cancInfos 作废票据信息
	 * @return
	 * @throws BizException
	 */
	public static String nextAvailableInvoice(String incnoCur, BlIncCancDO[] cancInfos) throws BizException {
		
		List<String> cancIncList = new ArrayList<String>();
		if(!ArrayUtil.isEmpty(cancInfos)){
			for (BlIncCancDO cancInfo : cancInfos) {
				cancIncList.add(cancInfo.getIncno());
			}
		}

		String[] splits = BlIncNumStrUtil.splitComputable(incnoCur);
		String head = splits[0];//头信息
		String incnoStr = splits[1];//数字部分
		Long incno = Long.valueOf(incnoStr);
		
		String nextInc = "";
		int i = 1;
		while(true){
			//计算下个票号
			nextInc = BlIncNumStrUtil.addZero(incnoStr.length(), String.valueOf(incno + i));
			if(nextInc.length() > incnoStr.length()){
				return null;
			}
			nextInc = head + nextInc;
			
			//判断是否废票
			if (cancIncList.contains(nextInc)) {
				i ++;
			}else{
				return nextInc;
			}
		}
	}
	
	/**
	 * 计算两个号之间的发票数量(含头尾)
	 * @param start
	 * @param end
	 * @return
	 * @throws BizException
	 */
	public static int calNumNetweenTwoInvoiceno(String start, String end) throws BizException {

		String[] startStrs = BlIncNumStrUtil.splitComputable(start);
		String[] endStrs = BlIncNumStrUtil.splitComputable(end);
		
		Long num = Math.abs(Long.parseLong(startStrs[1]) - Long.parseLong(endStrs[1]));
		return num.intValue() + 1;
	}
}
