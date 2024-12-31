package iih.pi.overview.i;

import iih.pi.overview.dto.d.PatAlDTO;
import xap.mw.core.data.BizException;

/**
 * 患者临床摘要维护服务
 * @author ly
 *
 */
public interface IPiOverviewMaintainService {

	/**
	 * 插入患者过敏史数据
	 * 相同日期相同的物品不保存
	 * 目前主要是皮试结果成阳性时调用该接口
	 * @param dto 过敏史dto
	 * @throws BizException 患者id为空|发生日期为空
	 */
	public abstract void insertPatAlData(PatAlDTO[] dtos) throws BizException;
	
	/**
	 * 删除患者过敏史数据
	 * 依据条件查询不到数据时不做处理
	 * 目前主要是取消皮试结果时调用该接口
	 * @param dto 过敏史dto
	 * @throws BizException 患者id为空|发生日期为空
	 */
	public abstract void deletePatAlData(PatAlDTO dto) throws BizException;

}
