package iih.ci.or.i;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 住院医生站主服务接口
 * @author wangqingzhu
 *
 */
public interface ICiIpOrderMainService extends ICiOrderMainService {

	/**
	 * 取消作废医嘱
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO revertcancel(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException;
	
	/**
	 * 停止医嘱
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO stop(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException;
	
	/**
	 * 取消停止医嘱
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO revertstop(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException;
	
	/**
	 * 医嘱科研项目确认
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO reserchconfirm(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException;
	/**
	 * 更新签署医嘱的生效时间
	 * @param ctx
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO updatedteffe(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException;
	
	public abstract OrderRstDTO updatedteffe1(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException;
	
	/**
	 * 追加临时医嘱
	 * @param ctx
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO apendstatord(CiEnContextDTO ctx,OrderOperateDTO arg,FBoolean isApend) throws BizException;
	/**
	 * 不补临时更新医嘱生效时间
	 * @param ctx
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO updatedteffenotapendstate(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException;
	
	public abstract OrderRstDTO updatedteffenotapendstate1(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException;
	
	/**
	 * 批量修改未签署医嘱的生效时间
	 * @param ctx
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO updateordersdteffe(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException;
	/**
	 * 校验是否存在有效的分级护理医嘱
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean checkHasGradingNursingOr(CiEnContextDTO ctx) throws BizException;
	
	/**
	 * 获取最近医嘱生成日期时间
	 * @param id_freq
	 * @param dt_effe
	 * @param firstdaytimes
	 * @param fg_long
	 * @return
	 * @throws BizException
	 */
	public FDateTime getOrderLastDate4DtEffe(String id_freq,FDateTime dt_effe,Integer firstdaytimes,FBoolean fg_long) throws BizException;

	/**
	 * 从预住院医嘱加载医疗单
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract String loadPrePati(String cardID,String beginEmpID_Doct) throws BizException;
}
