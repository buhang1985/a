package iih.sc.sch.i;

import java.util.Map;

import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDO;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDsDO;
import iih.sc.sch.dto.d.LockResultDTO;
import iih.sc.sch.dto.d.SchLockDTO;
import iih.sc.sch.dto.d.SchTickMdTimeDTO;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.scp.scplan.d.ScPlanDO;
import xap.mw.core.data.BizException;

/**
 * 排班对外命令服务
 * 
 * @author yank
 *
 */
public interface IScSchOutCmdService {
	
	/***
	 * @Description:门诊排班加锁
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	LockResultDTO lockSchOp(SchLockDTO dto) throws BizException;
	/***
	 * @Description:门诊排班解锁
	 * @param id_schlock
	 * @return
	 * @throws BizException
	 */
	String unlockSchOp(String id_schlock) throws BizException;
	/***
	 * @Description:门诊排班使用锁
	 * @param id_schlock
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	LockResultDTO useLockSchOp(String id_schlock,String id_pat,String id_ent) throws BizException;
	/**
	 * 快捷预约占用号位
	 * @param planDO
	 * @param appDTO
	 * @param id_scchl
	 * @param chlDOs
	 * @return
	 * @throws BizException
	 * @auther yaohl
	 * @date 2018年11月29日
	 */
	ScSchTickDO OccupyChlTimeBySchQuick4Manual(ScPlanDO planDO, MtAppDTO appDTO, String id_scchl,ScSchChlDO[] chlDOs,ScSchDO schDO,MtResDTO resDTO)throws BizException;
	/**
	 * 占用号位
	 * @author yaohl
	 * @param planDO  
	 * @param appDTO
	 * @param schDO
	 * @param id_scchl
	 * @param resDTO
	 * @return
	 * @throws BizException
	 */
	ScSchTickDO occupyChlTimeBySch4Auto(ScPlanDO planDO, MtAppDTO appDTO, String id_scchl,ScSchChlDO[] chlDOs,ScSchDO schDO,MtResDTO resDTO) throws BizException;
	/**
	 * 占用号位 自动定位预约日期
	 * @author yaohl
	 * @param planDO  
	 * @param appDTO
	 * @param schDO
	 * @param id_scchl
	 * @param resDTO
	 * @return
	 * @throws BizException
	 */
	ScSchTickDO occupyChlTimeBySch4AutoLocate(ScPlanDO planDO, MtAppDTO appDTO, String id_scchl,ScSchChlDO[] chlDOs,ScSchDO schDO,MtResDTO resDTO) throws BizException;
	/**
	 * 号源加号
	 * 
	 * @param schId 排班id
	 * @param amount 加号个数
	 * @param addEnum 加号类型, 0：正常号；1：加号；2：补号
	 * @param polCn号源池
	 * @return
	 * @throws BizException
	 */
	ScSchTickDO[] addTick(String schId, int amount, Integer addEnum, Integer polCn) throws BizException;

	/**
	 * 占用号位
	 * 
	 * @param tickId 号位id
	 * @param polcn 号源池编号，0-9，默认为0
	 * @return 号位
	 * @throws BizException 异常
	 */
	ScSchTickDO occupyTick(String tickId, Integer polcn) throws BizException;

	/**
	 * 占用多个号位
	 * 
	 * @param tickId 号位id
	 * @param polcn 号源池编号，0-9，默认为0
	 * @param tickDOs 号位集合
	 * @return 号位
	 * @throws BizException 异常
	 */
	ScSchTickDO[] occupyMultTick(ScSchTickDO[] tickDOs, Integer polcn) throws BizException;

	/**
	 * 占用排班号位最小号 如果没有可用资源抛异常
	 * 
	 * @param schId 排班id
	 * @param polcn 号源池编号，0-9，默认为0
	 * @param ticksId 号段id，可为null
	 * @param scchlId 渠道id
	 * @return 号位
	 * @throws BizException 异常
	 */
	ScSchTickDO occupyTickBySch(String schId, Integer polcn, String ticksId, String scchlId) throws BizException;

	/**
	 * 占用排班号位最小号 如果没有可用资源抛异常
	 * 
	 * @param schId 排班id
	 * @param polcn 号源池编号，0-9，默认为0
	 * @param ticks 号段id
	 * @param srvId 服务id
	 * @return 号位
	 * @throws BizException 异常
	 */
	ScSchTickDO occupyTickBySchAndSrv(String schId, Integer polcn, String ticksId, String srvId) throws BizException;

	/**
	 * 退号
	 * 
	 * @param tickId 号位
	 * @throws BizException
	 */
	void drawbackTick(String tickId) throws BizException;

	/**
	 * 作废票号
	 * 
	 * @param tickId 号位
	 * @param supplyTicketType 补号类型
	 * @throws BizException
	 */
	void revokeTick(String tickId, String supplyTicketType) throws BizException;

	/**
	 * 根据渠道占用号位
	 * 
	 * @author zhengcm
	 * 
	 * @param tickId 号位id
	 * @param polcn 号源池编号，0-9，默认为0
	 * @return 号位
	 * @throws BizException 异常
	 */
	ScSchTickDO occupyChlTick(String tickId, Integer polcn, String id_scchl) throws BizException;
	
	/**
	 * 根据渠道占用号位
	 * 
	 * @author zhengcm
	 * 
	 * @param tickId 号位id
	 * @param polcn 号源池编号，0-9，默认为0
	 * @return 号位
	 * @throws BizException 异常
	 */
	ScSchTickDO occupyChlTick4Auto(String tickId, Map<Integer,Integer> polcnMap, String id_scchl,MtResDTO resDTO,String id_srv) throws BizException;
	
	/**
	 * 手动预约根据渠道占用号位
	 * 
	 * @author zhengcm
	 * 
	 * @param tickId 号位id
	 * @param polcn 号源池编号，0-9，默认为0
	 * @return 号位
	 * @throws BizException 异常
	 */
	ScSchTickDO occupyChlTick4Manual(String tickId, Map<Integer,Integer> polcnMap, String id_scchl,MtResDTO resDTO,String id_srv) throws BizException;
	
	/**
	 * 根据渠道占用号位
	 * 通过排斥日期过滤
	 * @author zhengcm
	 * @param tickId 号位id
	 * @param polcn 号源池编号，0-9，默认为0
	 * @param exclDateList 排斥日期集合
	 * @return 号位
	 * @throws BizException 异常
	 */
	ScSchTickDO occupyChlTick8ExclDate(String tickId, Map<Integer,Integer> polcn, String id_scchl,MtResDTO resDTO,String id_stv) throws BizException;

	/**
	 * 按渠道根据排班占用排班号位最小号 如果没有可用资源抛异常
	 * 
	 * @author zhengcm
	 * 
	 * @param schId 排班id
	 * @param polcn 号源池编号，0-9，默认为0
	 * @param ticksId 号段id，可为null
	 * @param id_scchl 渠道ID
	 * 
	 * @return 号位
	 * @throws BizException 异常
	 */
	ScSchTickDO occupyChlTickBySch(String schId, Integer polcn, String ticksId, String id_scchl) throws BizException;
	
	
	/**
	 * 手动预约按渠道根据排班占用排班号位最小号 如果没有可用资源抛异常
	 * 
	 * @author zhengcm
	 * 
	 * @param schId 排班id
	 * @param polcn 号源池编号，0-9，默认为0
	 * @param ticksId 号段id，可为null
	 * @param id_scchl 渠道ID
	 * 
	 * @return 号位
	 * @throws BizException 异常
	 */
	ScSchTickDO occupyChlTickBySch4Auto(String schId, Map<Integer,Integer> polnMap, String ticksId, String id_scchl,String id_enttp,MtResDTO resDTO,String idSrv) throws BizException;
	
	/**
	 * 手动预约按渠道根据排班占用排班号位最小号 如果没有可用资源抛异常
	 * 
	 * @author zhengcm
	 * 
	 * @param schId 排班id
	 * @param polcn 号源池编号，0-9，默认为0
	 * @param ticksId 号段id，可为null
	 * @param id_scchl 渠道ID
	 * 
	 * @return 号位
	 * @throws BizException 异常
	 */
	ScSchTickDO occupyChlTickBySch4AutoLocate(String schId, Map<Integer,Integer> polnMap, String ticksId, String id_scchl,String id_enttp,MtResDTO resDTO,String idSrv) throws BizException;
	/**
	 * 按渠道根据排班占用排班号位最小号 如果没有可用资源抛异常
	 * 通过排斥日期过滤
	 * @author zhengcm
	 * 
	 * @param schId 排班id
	 * @param polcn 号源池编号，0-9，默认为0
	 * @param ticksId 号段id，可为null
	 * @param id_scchl 渠道ID
	 * @param exclDateList 排斥日期集合
	 * @return 号位
	 * @throws BizException 异常
	 */
	ScSchTickDO occupyChlTickBySch8ExclDate(String schId, Map<Integer,Integer> polcnMap, String ticksId, String id_scchl,String idEnttp,MtResDTO resDTO,String idSrv) throws BizException;
	/**
	 * 手动预约按渠道根据排班占用排班号位最小号 如果没有可用资源抛异常
	 * 
	 * @author zhengcm
	 * 
	 * @param schId 排班id
	 * @param polcn 号源池编号，0-9，默认为0
	 * @param ticksId 号段id，可为null
	 * @param id_scchl 渠道ID
	 * 
	 * @return 号位
	 * @throws BizException 异常
	 */
	ScSchTickDO occupyChlTickBySch4Manual(String schId, Map<Integer,Integer> polnMap, String ticksId, String id_scchl,String id_enttp,MtResDTO resDTO,String idSrv) throws BizException;
	/**
	 * 按渠道根据排班和号段占用排班号位最小号 如果没有可用资源抛异常
	 * 
	 * @author zhengcm
	 * 
	 * @param schId 排班id
	 * @param polcn 号源池编号，0-9，默认为0
	 * @param ticks 号段id
	 * @param srvId 服务id
	 * @param id_scchl 渠道id
	 * @return 号位
	 * @throws BizException 异常
	 */
	ScSchTickDO occupyChlTickBySchAndSrv(String schId, Integer polcn, String ticksId, String srvId, String id_scchl)
			throws BizException;
	/**
	 * 按渠道根据排班和号段占用排班号位最小号 如果没有可用资源抛异常
	 * 
	 * @author zhengcm
	 * 
	 * @param schId 排班id
	 * @param polcn 号源池编号，0-9，默认为0
	 * @param ticks 号段id
	 * @param srvId 服务id
	 * @param id_scchl 渠道id
	 * @return 号位
	 * @throws BizException 异常
	 */
	ScSchTickDO occupyChlTickBySchAndSrv4Manual(String schId, Map<Integer,Integer> polcnMap, String ticksId, String srvId, String id_scchl,String idEnttp)
			throws BizException;
	/**
	 * 按渠道根据排班和号段占用排班号位最小号 如果没有可用资源抛异常
	 * 
	 * @author zhengcm
	 * 
	 * @param schId 排班id
	 * @param polcn 号源池编号，0-9，默认为0
	 * @param ticks 号段id
	 * @param srvId 服务id
	 * @param id_scchl 渠道id
	 * @return 号位
	 * @throws BizException 异常
	 */
	ScSchTickDO occupyChlTickBySchAndSrv8ExclDate(String schId, Map<Integer,Integer> polcnMap, String ticksId, String srvId, String id_scchl,String idEnttp,MtResDTO resDTO)
			throws BizException;
	/**
	 * 按渠道根据排班和时间段占用排班  如果没有可用资源抛异常
	 * 
	 * @author liubin
	 * 
	 * @param schId
	 * @param schTickMdTime
	 * @param id_scchl
	 * @return
	 * @throws BizException
	 */
	ScSchTickDO occupyChlTickByAchAndTime(String schId, SchTickMdTimeDTO schTickMdTime, String id_scchl) throws BizException;
	/**
	 * 按渠道根据排班和时间段占用排班  如果没有可用资源抛异常
	 * 
	 * @author liubin
	 * 
	 * @param schId
	 * @param schTickMdTime
	 * @param id_scchl
	 * @return
	 * @throws BizException
	 */
	ScSchTickDO occupyChlTickByAchAndTime4ChangeApt(String schId, SchTickMdTimeDTO schTickMdTime, String id_scchl,String id_enttp) throws BizException;
	/**
	 * 按渠道根据排班和时间段占用排班  如果没有可用资源抛异常
	 * 
	 * @author liubin
	 * 
	 * @param schId
	 * @param schTickMdTime
	 * @param id_scchl
	 * @return
	 * @throws BizException
	 */
	ScSchTickDO occupyChlTickByAchAndTime4Manual(String schId, SchTickMdTimeDTO schTickMdTime, String id_scchl,String id_enttp,MtResDTO resDTO) throws BizException;
	/**
	 * 按渠道根据服务占用指定号位， 如果没有可用资源抛异常
	 * 
	 * @author zhengcm
	 * 
	 * @param tickId 号位id
	 * @param polcn 号源池编号，0-9，默认为0
	 * @param srvId 服务id
	 * @param id_scchl 渠道id
	 * @return 号位
	 * @throws BizException 异常
	 */
	ScSchTickDO occupyChlTickBySrv(String tickId, Integer polcn, String srvId, String id_scchl) throws BizException;
	
	/**
	 * 按渠道根据服务占用指定号位， 如果没有可用资源抛异常
	 * 
	 * @author zhengcm
	 * 
	 * @param tickId 号位id
	 * @param polcn 号源池编号，0-9，默认为0
	 * @param srvId 服务id
	 * @param id_scchl 渠道id
	 * @return 号位
	 * @throws BizException 异常
	 */
	ScSchTickDO occupyChlTickBySrv4Manual(String tickId, Map<Integer,Integer> polcnMap, String srvId, String id_scchl) throws BizException;
	/**
	 * 按渠道根据服务占用指定号位， 如果没有可用资源抛异常
	 * 根据排斥日期过滤数据
	 * @author zhengcm
	 * 
	 * @param tickId 号位id
	 * @param polcn 号源池编号，0-9，默认为0
	 * @param srvId 服务id
	 * @param id_scchl 渠道id
	 * @param exclDateList 排斥日期集合
	 * @return 号位
	 * @throws BizException 异常
	 */
	ScSchTickDO occupyChlTickBySrv8ExclDate(String tickId, Map<Integer,Integer> polcn, String srvId, String id_scchl,MtResDTO resDTO) throws BizException;
	/**
	 * 更新指定科室排班的建议提前报到时间（当前日期及之后的排班）
	 * 
	 * @author zhengcm
	 * @date 2017-11-29 09:59:13
	 *
	 * @param deptId
	 * @param sugestVal
	 * @param id_deptparam
	 * @throws BizException
	 */
	public void updateSchSugestExmint(ScDeptParamDO paramDO,ScDeptParamDsDO[] newDsDO,ScDeptParamDsDO[] oldDsDO) throws BizException;
}
