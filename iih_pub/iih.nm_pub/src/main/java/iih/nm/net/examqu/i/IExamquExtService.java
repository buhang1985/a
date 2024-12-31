package iih.nm.net.examqu.i;

import iih.nm.net.examqu.d.ExamquAggDO;
import iih.nm.net.examquca.d.ExamQuCaDO;
import iih.nm.net.examquescontral.d.ExamQuDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FBinaryArray;

public interface IExamquExtService {

	/**
	 * 获取试题结构数据
	 * 
	 * @param id_qu
	 * @return
	 * @throws BizException
	 */
	public abstract ExamQuDTO getExamQuDTO(String id_qu) throws BizException;

	/**
	 *	根据试题ID查询试题分类集合 
	 * @param id_qu
	 * @return
	 * @throws BizException
	 */
	public abstract ExamQuCaDO[] getCaDOs(String id_qu) throws BizException;

	/**
	 * 保存
	 * 
	 * @param aggDO
	 * @return
	 * @throws BizException
	 */
	public ExamquAggDO save(ExamquAggDO aggDO, ExamQuDTO structDTO) throws BizException;

}
