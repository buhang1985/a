package iih.bl.comm.s.bp;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.dataaccess.DBUtil;

/**
 * 创建主键
 * @author ly 2019/07/10
 *
 */
public class BlCreatePksBP {

	/**
	 * 创建指定数量的主键
	 * @param num
	 * @return
	 * @throws BizException
	 */
	public String[] exec(Integer num) throws BizException{
		
		if (num == null || num <= 0) {
			throw new BizException("创建主键:入参数量需要大于0");
		}
		return new DBUtil().getOIDs(num);
	} 
}
