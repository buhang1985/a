package iih.mp.ot.totalquery.i;

import iih.mp.ot.totalquery.d.MpOtItemDataDTO;
import iih.mp.ot.totalquery.d.MpOtItemQueryCondDTO;
import xap.mw.core.data.BizException;

/**
 * 医技项目汇总统计查询
 * @Description:
 * @author: huang_junhao@founder.com.cn
 * @version：2019年4月3日 下午2:36:30 创建
 */
public interface IMpOtItemTotalQueryService {

	/**
	 * 就诊类型维度汇总
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract MpOtItemDataDTO[] loadEntpGrid(MpOtItemQueryCondDTO param) throws BizException;

	/**
	 * 科室维度汇总
	 * @param entp
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract MpOtItemDataDTO[] loadDepOrByEntp(String entp, MpOtItemQueryCondDTO param) throws BizException;

	/**
	 * 项目维度汇总
	 * @param entp
	 * @param id_dep_or
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract MpOtItemDataDTO[] loadsrvinfoBydepor(String entp, String id_dep_or,MpOtItemQueryCondDTO param) throws BizException;
	
	/**
	 * 显示患者维度
	 * @param entp
	 * @param id_dep_or
	 * @param id_srv
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract MpOtItemDataDTO[] loadpatBySrv(String entp, String id_dep_or,String id_srv, MpOtItemQueryCondDTO param) throws BizException;
	
	/**
	 * 项目维度汇总一次查询全部数据
	 * @param entp
	 * @param id_dep_or
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract MpOtItemDataDTO[] loadsrvinfoByCondAll(MpOtItemQueryCondDTO param) throws BizException;
	
	/**
	 * 项目执行患者明细一次查询全部数据
	 * @param entp
	 * @param id_dep_or
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract MpOtItemDataDTO[] loadpatinfoByCondAll(MpOtItemQueryCondDTO param) throws BizException;
}
