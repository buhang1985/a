package iih.mc.itf.hvitem.i;

import iih.mc.itf.hvitem.d.McHvUseOutDTO;
import xap.mw.core.data.BizException;
import iih.mc.itf.hvitem.d.McHvCheckDTO;

/**
 * 耗材出库_Service
 * 
 * @author hao_wu 2018-11-23
 *
 */
public interface IMcHvItemService {

	/**
	 * 高值耗材使用出库
	 * 
	 * @param paramDto
	 * @return 字符串，若有值代表有错误信息
	 */
	public abstract McHvUseOutDTO[] McHvItemUseOut(McHvUseOutDTO[] paramDto) throws BizException;
	
	/**
	 * 医技补费通过唯一码查询耗材信息，服务id
	 * @param onlycode
	 * @return
	 */
	public abstract McHvCheckDTO HvCheckByOnlycode(String onlycode) throws BizException;
	
	/**
	 * 通过医嘱绑定的高值申请单，验证库存是否充足，缺少的生成耗材管理的申领计划单
	 * @param paramDto
	 * @return
	 * @throws BizException
	 */
	public McHvCheckDTO[] getHvDtoByORAp(McHvUseOutDTO[] paramDto) throws BizException;
	
}
