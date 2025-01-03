package iih.sc.scbd.i;

import iih.sc.scbd.dto.d.ScPrtCfgQryDTO;
import iih.sc.scbd.dto.d.ScPrtTmplDTO;
import iih.sc.scbd.scdeptparam.d.ScdeptparamAggDO;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvDO;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvRelDO;
import xap.mw.core.data.BizException;

/**
 * 排班基础数据对外查询服务
 * 
 * @author yank
 *
 */
public interface IScBdOutQryService {
	/**
	 * 获取诊疗类型
	 * 
	 * @param scSrvId 排班服务id
	 * @return
	 * @throws BizException
	 */
	String getSrvTp(String scSrvId) throws BizException;

	/**
	 * 获取渠道
	 * 
	 * @param chlTp 渠道类型编码
	 * @return 预约渠道集合
	 * @throws BizException
	 * @author yank
	 */
	SchedulechlDO[] getChlByTp(String chlTp) throws BizException;

	/**
	 * 根据类型批量获取渠道
	 * 
	 * @param chlTps 渠道类型编码集合
	 * @return 预约渠道集合
	 * @throws BizException
	 * @author yank
	 */
	SchedulechlDO[] batchGetChlByTpBP(String[] chlTps) throws BizException;

	/**
	 * 根据排班渠道ID获取排班渠道DO
	 * 
	 * @author zhengcm
	 * @date 2017-11-20 11:00:26
	 *
	 * @param id_scchl
	 * @return
	 * @throws BizException
	 */
	SchedulechlDO getChlById(String id_scchl) throws BizException;

	/**
	 * 获取预约规则类型
	 * 
	 * @param id_scrule 预约规则id
	 * @return
	 * @throws BizException
	 */
	String getScRuleTpBp(String id_scrule) throws BizException;

	/**
	 * 根据医疗服务id 求所对应的 排班服务ids
	 * 
	 * @param id_srv 医疗服务id
	 * @throws BizException
	 */
	String getScSrvIdsByBdSrv(String id_srv) throws BizException;

	/**
	 * 获取科室参数
	 *
	 * @param id_dept 科室id
	 * @param sd_sctp 排班类型编码
	 * @return 科室参数AggDO
	 * @throws BizException
	 * @author zhengcm
	 */
	ScdeptparamAggDO[] getDeptParamList(String id_dept, String sd_sctp) throws BizException;

	/**
	 * 根据服务编码获取子服务的do数组
	 * 
	 * @param srvCode
	 * @return
	 * @throws BizException
	 */
	ScheduleSrvRelDO[] getSchSrvRelBP(String srvCode) throws BizException;
    /**
     * 获取非门诊排班的排班服务id
     * 
     * @return
     * @throws BizException
     */
    String getScsrvIdsNoOpSch() throws BizException;

	/**
	 * 根据排班服务ID查询排班服务DO
	 *
	 * @author zhengcm
	 * 
	 * @param id_scsrv
	 * @return
	 * @throws BizException
	 */
	public ScheduleSrvDO getScSrvById(String id_scsrv) throws BizException;
	
	/**
	 * 根据打印模板项目配置信息查询 打印模板
	 * @param qryDTO
	 * @return
	 * @throws BizException
	 */
	public ScPrtTmplDTO getScPrtTmplDTO(ScPrtCfgQryDTO qryDTO) throws BizException;
}
