package iih.mkr.std.commonde.i;

import iih.mkr.std.de.d.DeDTO;
import xap.mw.core.data.BizException;

/**
 * 公共数据元扩展服务接口
 * 
 * @author hao_wu 2019-5-15
 *
 */
public interface ICommondeExtCudService {

	/**
	 * 保存数据元DTO
	 * 
	 * @param deDtos 数据元DTO集合
	 * @return
	 * @throws BizException
	 */
	public DeDTO[] saveDeDto(DeDTO[] deDtos) throws BizException;

	/**
	 * 删除数据元DTO</br>
	 * 删除数据集与数据元关系，如果不存在其他关系，则删除数据元
	 * 
	 * @param deDtos
	 * @throws BizException
	 */
	public void deleteDeDto(DeDTO[] deDtos) throws BizException;
}
