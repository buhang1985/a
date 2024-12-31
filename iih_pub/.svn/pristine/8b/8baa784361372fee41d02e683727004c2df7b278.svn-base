package iih.mp.orm.surgappconfirm.i;

import iih.mp.orm.querytime.d.QueryTimeDTO;
import iih.mp.orm.surgappconfirm.d.SurgAppEmpConfDO;
import iih.mp.orm.surgappconfirm.d.SurgappconfirmAggDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;

public interface ISurgappconfirmExtRService {
	
	/**
	 * 查询申请单确认信息(调用医嘱闭环接口获得数据后转化为自己数据返回)
	 * @param queryTimeDto
	 * @param entp
	 * @param id_dep
	 * @return
	 * @throws DAException
	 * @throws BizException
	 */
	public abstract SurgappconfirmAggDO[] findSurgAppItem(QueryTimeDTO queryTimeDto, String entp, String id_dep) throws DAException, BizException;
	
	/**
	 * 根据医嘱id查询sc域手术排班信息并转化为mp域SurgAppEmpConfDO[]返回
	 * @param idOr
	 * @return
	 * @throws BizException 
	 */
	public abstract SurgAppEmpConfDO[] findSurgAppEmpConf(String idOr) throws BizException;
}
