package iih.bd.srv.emreditor.i;

import iih.bd.srv.emreditor.d.EmrEditorDO;
import xap.mw.core.data.BizException;

public interface IEmreditorService {
	
	/**
	 * 获取当年code分组的最大版本值
	 * @param code
	 * @return
	 */
	public abstract int getMaxVersionByCode(String code) throws BizException;
	
	/**
	 * 复制一相同的一条数据存入数据库
	 * @param emrEditorDO
	 * @return
	 * @throws BizException
	 */
	public abstract String CopyEmreditor(EmrEditorDO emrEditorDO) throws BizException;

}
