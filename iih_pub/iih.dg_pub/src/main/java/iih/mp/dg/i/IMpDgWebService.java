package iih.mp.dg.i;

import iih.mp.dg.wsbean.OpDispPresBean;
import iih.mp.dg.wsbean.OpDispedPresBean;
import iih.mp.dg.wsbean.OpICDrugBean;
import iih.mp.dg.wsbean.OpPatDrugQryInfoBean;
import iih.mp.dg.wsbean.OpPatDrugQryParamBean;
import iih.mp.dg.wsbean.OpPresStateBean;
import xap.mw.core.data.BizException;

/**
 * 药品域webservice服务
 * @author ly 2016/09/06
 *
 */
public interface IMpDgWebService {

	/**
	 * 查询已经摆药的处方
	 * 第一次查询时，更新处方执行状态表的发药数据获取标志
	 * 第二次查询时，直接查询数据
	 * (国药调用)
	 * @param uuid 唯一标识
	 * @param queryTimes 查询次数 1,2
	 * @return 已经摆药处方数据
	 * @throws BizException 唯一标识为空，查询次数不是1或2
	 */
	OpDispedPresBean[] getDispensedPres(String uuid,Integer queryTimes) throws BizException;
	
	/**
	 * 查询待摆药的处方
	 * 第一次查询时，更新处方执行状态表的摆药数据获取标志
	 * 第二次查询时，直接查询数据
	 * (国药调用)
	 * @param uuid 唯一标识
	 * @param queryTimes 查询次数 1,2
	 * @return 已经摆药处方数据
	 * @throws BizException 唯一标识为空，查询次数不是1或2
	 */
	OpDispPresBean[] getDispensePres(String uuid,Integer queryTimes) throws BizException;

	/**
	 * 摆药机摆药完成后，回写处方摆药状态
	 * 同时向门诊摆药单主表中插入数据
	 * (国药调用)
	 * @param bean 入参
	 * @return true:处理成功 false:处理失败
	 * @throws BizException
	 */
	Boolean updatePresState(OpPresStateBean bean) throws BizException;
	
	/**
	 * 患者用药查询(手机APP)
	 * 收费后可查
	 * @param param 传入参数
	 * @return 用药信息
	 * @throws BizException 必须输入项目校验
	 */
	OpPatDrugQryInfoBean[] getPatDrugInfo(OpPatDrugQryParamBean param) throws BizException;
	
	/**
	 * 查询缴费未发药的毒麻药品
	 * 门诊智能柜轮询
	 * @param dtOr 开立时间
	 * @return 智能柜药品信息
	 * @throws BizException
	 */
	OpICDrugBean[] getOpICDrugInfo(String dtOr) throws BizException;
}
