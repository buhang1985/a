package iih.mc.itf.hvitem.i;

import iih.mc.itf.hvitem.d.McHvUseOutDTO;
import xap.mw.core.data.BizException;
import iih.mc.itf.hvitem.d.McHvCheckDTO;

/**
 * 高值耗材出库调用测试
 * 
 * @author liyong 2019-07-18
 *
 */
public interface IMcTestService {

	/**
	 * 测试高值耗材使用出库
	 * 
	 * @param paramDto
	 * @return 字符串，若有值代表有错误信息
	 */
	public abstract McHvUseOutDTO[] HvUseOut(McHvUseOutDTO[] paramDto) throws BizException;
	
	/**
	 * 通过唯一码查询高值耗材相关信息
	 * 
	 * @param onlyode
	 * @return 
	 */
	public abstract McHvCheckDTO HvCheckByOnlycode(String onlycode) throws BizException;
	
	/**
	 * 测试用
	 * 
	 * @param onlyode
	 * @return 
	 */
	public abstract void testSrv(Object obj) throws BizException;
}
