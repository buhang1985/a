package iih.bd.mm.comm.i;

import xap.mw.core.data.BizException;

/**
 * 树形结构的编码生成服务。
 * @author wu.junhui
 *
 */
public interface ICodeGeneratorService {

	/**
	 * 生成物品分类编码
	 * @param parentId 父物品分类主键
	 * @return 物品分类编码
	 * @throws BizException
	 */
	public String generatorMMCategoryCode(String parentId) throws BizException;
}
