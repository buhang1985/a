package iih.pis.cqs.i;

import javax.jws.WebService;

import xap.mw.core.data.BizException;
/***
 * 显示屏对外接口
 * @author fanlq
 * @date: 2019年10月14日 下午1:56:17
 */
@WebService
public interface ICqsOutCmdService {

	/***
	 * @Description:注册显示屏
	 * @param xml
	 */
	void registCqs(String xml) throws BizException;
	/***
	 * @Description:获取叫号模板参数值
	 * @param xml
	 */
	String getCallModParam(String id_pc,String paramCode) throws BizException;
	/***
	 * @Description:查询显示屏站点记录
	 * @param where  查询条件
	 * @param order  排序条件
	 */
	String getEnBrdSite(String  id_pc) throws BizException;
	/***
	 * @Description:注册分诊显示屏
	 * @param xml
	 */
	void registTriageCqs(String id_pc) throws BizException;
	/***
	 * @Description:获取显示屏配置
	 * @param id_pc
	 * @return
	 * @throws BizException
	 */
	String getEnBrd(String  id_pc) throws BizException;
	/***
	 * @Description:查询门诊分诊屏站点记录
	 * @param id_pc
	 * @return
	 * @throws BizException
	 */
	String getEnBrdSiteByPcId(String id_pc) throws BizException;
}
