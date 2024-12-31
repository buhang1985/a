package iih.bd.srv.mrelement.i;

import iih.bd.srv.dataspecilchar.d.DataSpecilCharDO;
import iih.mkr.std.commonde.d.DataElementDO;
import iih.mkr.std.commondeval.d.DataElementValDO;
import iih.mkr.std.dedg.d.DeDataGrpDO;
import xap.mw.core.data.BizException;

public interface IBdmrdeService {
	/**
	 * 查询所有数据组的列表
	 * @return
	 * @throws BizException
	 */
	public abstract DeDataGrpDO[] getDataGroupList() throws BizException;
	/**
	 * 查询数据元的值域
	 * @return
	 * @throws BizException
	 */
	public abstract DataElementValDO[] getDataElementValDomain(String idDe) throws BizException;
	/**
	 * 查询特殊字符字典
	 * @return
	 * @throws BizException
	 */
	public DataSpecilCharDO[] getSpecialChar() throws BizException;
	/**
	 * 查询数据元
	 * @return
	 * @throws BizException
	 */
	public DataElementDO[] getDataElementList(String idDg) throws BizException;
	/**
	 * 获取病历元素编码
	 * @throws BizException
	 */
	public abstract String getElementCode() throws BizException;
	/**
	 * 将未保存的病历元素编码回滚，下次可以继续使用
	 * @return
	 * @throws BizException
	 */
	public abstract void rollBackElementCode(String code) throws BizException;
}
