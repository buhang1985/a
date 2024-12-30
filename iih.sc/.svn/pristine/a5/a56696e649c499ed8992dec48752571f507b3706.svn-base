package iih.sc.sch.s;

import java.util.Map;

import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDO;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDsDO;
import iih.sc.sch.dto.d.LockResultDTO;
import iih.sc.sch.dto.d.SchLockDTO;
import iih.sc.sch.dto.d.SchTickMdTimeDTO;
import iih.sc.sch.i.IScSchOutCmdService;
import iih.sc.sch.s.bp.AddTicketBP;
import iih.sc.sch.s.bp.DrawbackTicketBP;
import iih.sc.sch.s.bp.OccupyChlTickBP;
import iih.sc.sch.s.bp.OccupyChlTickByAchAndTimeBP;
import iih.sc.sch.s.bp.OccupyChlTickBySchAndSrvBP;
import iih.sc.sch.s.bp.OccupyChlTickBySrvBP;
import iih.sc.sch.s.bp.OccupyChlTimeBySchQuick4ManualBP;
import iih.sc.sch.s.bp.OccupyMultTickBP;
import iih.sc.sch.s.bp.OccupyTickBP;
import iih.sc.sch.s.bp.OccupyTickBySchAndSrvBP;
import iih.sc.sch.s.bp.OccupyTickBySchBP;
import iih.sc.sch.s.bp.RevokeTickBP;
import iih.sc.sch.s.bp.UpdateSchSugestExmintBP;
import iih.sc.sch.s.bp.mt.apt.OccupyChlTickByAchAndTime4ManualBP;
import iih.sc.sch.s.bp.mt.apt.bp.OccupyChlTick4ManualAptBP;
import iih.sc.sch.s.bp.mt.apt.bp.OccupyChlTickByAchAndTime4ChangeAptBP;
import iih.sc.sch.s.bp.mt.apt.bp.OccupyChlTickBySch4ManualAptBP;
import iih.sc.sch.s.bp.mt.apt.bp.OccupyChlTickBySchAndSrv4ManualAptBP;
import iih.sc.sch.s.bp.mt.apt.bp.OccupyChlTickBySrv4ManualAptBP;
import iih.sc.sch.s.bp.mt.apt.bp.OccupyChlTimeBySch4AutoBP;
import iih.sc.sch.s.bp.mt.apt.bp.OccupyChlTimeBySch4AutoLocateBP;
import iih.sc.sch.s.bp.mt.apt.bp.auto.OccupyChlTick4AutoBP;
import iih.sc.sch.s.bp.mt.apt.bp.auto.OccupyChlTickBySch4AutoAptBP;
import iih.sc.sch.s.bp.mt.apt.bp.auto.OccupyChlTickBySch4AutoLocateAptBP;
import iih.sc.sch.s.bp.op.LockSchOpBP;
import iih.sc.sch.s.bp.op.UnLockSchOpBP;
import iih.sc.sch.s.bp.op.UseLockSchOpBP;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.scp.scplan.d.ScPlanDO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;

/**
 * 排班对外命令服务
 * 
 * @author yank
 *
 */
@Service(serviceInterfaces = { IScSchOutCmdService.class }, binding = Binding.JSONRPC)
public class ScSchOutCmdServiceImpl implements IScSchOutCmdService {
	/***
	 * @Description:门诊排班加锁
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	@Override
	public LockResultDTO lockSchOp(SchLockDTO dto) throws BizException{
		return new LockSchOpBP().exec(dto);
	}
	/***
	 * @Description:门诊排班解锁
	 * @param id_schlock
	 * @return
	 * @throws BizException
	 */
	@Override
	public String unlockSchOp(String id_schlock) throws BizException{
		return new UnLockSchOpBP().exec(id_schlock);
	}
	/***
	 * @Description:门诊排班使用锁
	 * @param id_schlock
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	@Override
	public LockResultDTO useLockSchOp(String id_schlock,String id_pat,String id_ent) throws BizException{
		return new UseLockSchOpBP().exec(id_schlock, id_pat, id_ent);
	}
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
	@Override
	public ScSchTickDO[] addTick(String schId, int amount, Integer addEnum, Integer polCn) throws BizException {
		AddTicketBP addTicketBP = new AddTicketBP();
		return addTicketBP.addTick(schId, amount, addEnum, polCn, null, null);
	}

	/**
	 * 占用号位最小号，如果没有可用资源抛异常
	 * 
	 * @param schId 排班id
	 * @param polcn 号源池编号，0-9，默认为0
	 * @param ticksId 号段id，可为null
	 * @param scchlId 渠道id
	 * @return 号位
	 * @throws BizException 异常
	 */
	@Override
	public ScSchTickDO occupyTickBySch(String schId, Integer polcn, String ticksId, String scchlId) throws BizException {
		OccupyTickBySchBP occupyBP = new OccupyTickBySchBP();
		return occupyBP.exec(schId, polcn, ticksId, scchlId,FBoolean.FALSE);
	}

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
	@Override
	public ScSchTickDO occupyTickBySchAndSrv(String schId, Integer polcn, String ticksId, String srvId)
			throws BizException {
		OccupyTickBySchAndSrvBP occupyBP = new OccupyTickBySchAndSrvBP();
		return occupyBP.exec(schId, polcn, ticksId, srvId);
	}

	/**
	 * 占用号位
	 * 
	 * @param tickId 号位id
	 * @param polcn 号源池编号，0-9，默认为0
	 * @return 号位
	 * @throws BizException 异常
	 */
	@Override
	public ScSchTickDO occupyTick(String tickId, Integer polcn) throws BizException {
		OccupyTickBP occupyBP = new OccupyTickBP();
		return occupyBP.exec(tickId, polcn);
	}

	/**
	 * 占用多个号位
	 * 
	 * @param tickId 号位id
	 * @param polcn 号源池编号，0-9，默认为0
	 * @param tickDOs 号位集合
	 * @return 号位
	 * @throws BizException 异常
	 */
	@Override
	public ScSchTickDO[] occupyMultTick(ScSchTickDO[] tickDOs, Integer polcn) throws BizException {
		OccupyMultTickBP occupyBP = new OccupyMultTickBP();
		return occupyBP.exec(tickDOs, polcn);
	}

	/**
	 * 退号
	 * 
	 * @param tickId 号位
	 * @param needBh 是否补号
	 * @throws BizException
	 */
	@Override
	public void drawbackTick(String tickId) throws BizException {
		DrawbackTicketBP drawbackBP = new DrawbackTicketBP();
		drawbackBP.exec(tickId);
	}

	/**
	 * 作废票号
	 * 
	 * @param tickId 号位
	 * @param supplyTicketType 补号类型
	 * @throws BizException
	 */
	@Override
	public void revokeTick(String tickId, String supplyTicketType) throws BizException {
		RevokeTickBP revokeBP = new RevokeTickBP();
		revokeBP.exec(tickId, supplyTicketType);
	}

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
	@Override
	public ScSchTickDO occupyChlTick(String tickId, Integer polcn, String id_scchl) throws BizException {
		return new OccupyChlTickBP().exec(tickId, polcn, id_scchl);
	}
	/**
	 * 医技自动预约使用根据渠道占用号位
	 * 
	 * @author zhengcm
	 * 
	 * @param tickId 号位id
	 * @param polcn 号源池编号，0-9，默认为0
	 * @return 号位
	 * @throws BizException 异常
	 */
	@Override
	public ScSchTickDO occupyChlTick4Auto(String tickId, Map<Integer,Integer> polcnMap, String id_scchl,MtResDTO resDTO,String id_srv) throws BizException {
		return new OccupyChlTick4AutoBP().exec(tickId, polcnMap, id_scchl, resDTO, id_srv);
	}
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
	@Override
	public ScSchTickDO occupyChlTick4Manual(String tickId, Map<Integer,Integer> polcnMap, String id_scchl,MtResDTO resDTO,String id_srv) throws BizException {
		return new OccupyChlTick4ManualAptBP().exec(tickId, polcnMap, id_scchl, resDTO, id_srv);
	}
	/**
	 * 根据渠道占用号位
	 * 通过排斥日期过滤
	 * @author zhengcm
	 * 
	 * @param tickId 号位id
	 * @param polcn 号源池编号，0-9，默认为0
	 * @param exclDateList 排斥日期集合
	 * @return 号位
	 * @throws BizException 异常
	 */
	@Override
	public ScSchTickDO occupyChlTick8ExclDate(String tickId, Map<Integer,Integer> polcnMap, String id_scchl, MtResDTO resDTO,String id_srv)
			throws BizException {
		return new OccupyChlTick4ManualAptBP().exec(tickId, polcnMap, id_scchl, resDTO,id_srv);
	}
	/**
	 * 根据渠道占用排班号位最小号 如果没有可用资源抛异常
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
	@Override
	public ScSchTickDO occupyChlTickBySch(String schId, Integer polcn, String ticksId, String id_scchl)
			throws BizException {
		OccupyTickBySchBP occupyBP = new OccupyTickBySchBP();
		return occupyBP.exec(schId, polcn, ticksId, id_scchl,FBoolean.FALSE);
	}
	
	
	/**
	 * 医技自动预约使用根据渠道占用排班号位最小号 如果没有可用资源抛异常
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
	@Override
	public ScSchTickDO occupyChlTickBySch4Auto(String schId,Map<Integer,Integer> polcnMap, String ticksId, String id_scchl,String id_enttp,MtResDTO resDTO,String idSrv)
			throws BizException {
		return new OccupyChlTickBySch4AutoAptBP().exec(schId, polcnMap, ticksId, id_scchl,id_enttp,resDTO,idSrv);
	}
	
	/**
	 * 医技自动预约使用根据渠道占用排班号位最小号 如果没有可用资源抛异常
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
	@Override
	public ScSchTickDO occupyChlTickBySch4AutoLocate(String schId,Map<Integer,Integer> polcnMap, String ticksId, String id_scchl,String id_enttp,MtResDTO resDTO,String idSrv)
			throws BizException {
		return new OccupyChlTickBySch4AutoLocateAptBP().exec(schId, polcnMap, ticksId, id_scchl,id_enttp,resDTO,idSrv);
	}
	/**
	 * 根据渠道占用排班号位最小号 如果没有可用资源抛异常
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
	@Override
	public ScSchTickDO occupyChlTickBySch4Manual(String schId,Map<Integer,Integer> polcnMap, String ticksId, String id_scchl,String id_enttp,MtResDTO resDTO,String idSrv)
			throws BizException {
		return new OccupyChlTickBySch4ManualAptBP().exec(schId, polcnMap, ticksId, id_scchl,id_enttp,resDTO,idSrv);
	}
	/**
	 * 根据渠道占用排班号位最小号 如果没有可用资源抛异常
	 * 通过排斥日期过滤数据
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
	@Override
	public ScSchTickDO occupyChlTickBySch8ExclDate(String schId, Map<Integer,Integer> polcnMap, String ticksId, String id_scchl,String idEnttp,MtResDTO resDTO,String idSrv)
			throws BizException {
		return new OccupyChlTickBySch4ManualAptBP().exec(schId, polcnMap, ticksId, id_scchl,idEnttp, resDTO,idSrv);
	}

	/**
	 * 根据渠道占用排班号位最小号 如果没有可用资源抛异常
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
	@Override
	public ScSchTickDO occupyChlTickBySchAndSrv(String schId, Integer polcn, String ticksId, String srvId,
			String id_scchl) throws BizException {
		return new OccupyChlTickBySchAndSrvBP().exec(schId, polcn, ticksId, srvId, id_scchl);
	}
	
	
	/**
	 * 手动预约根据渠道占用排班号位最小号 如果没有可用资源抛异常
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
	@Override
	public ScSchTickDO occupyChlTickBySchAndSrv4Manual(String schId, Map<Integer,Integer> polcnMap, String ticksId, String srvId,
			String id_scchl,String idEnttp) throws BizException {
		return new OccupyChlTickBySchAndSrv4ManualAptBP().exec(schId, polcnMap, ticksId, srvId, id_scchl,idEnttp,null);
	}
	/**
	 * 根据渠道占用排班号位最小号 如果没有可用资源抛异常
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
	@Override
	public ScSchTickDO occupyChlTickBySchAndSrv8ExclDate(String schId, Map<Integer,Integer> polcnMap, String ticksId, String srvId,
			String id_scchl,String idEnttp,MtResDTO resDTO) throws BizException {
		return new OccupyChlTickBySchAndSrv4ManualAptBP().exec(schId, polcnMap, ticksId, srvId, id_scchl,idEnttp,resDTO);
	}
	/**
	 * 根据排班和时间片时段占用号位  如果没有可用资源抛异常
	 * 
	 * @author liubin
	 * 
	 * @param schId
	 * @param schTickMdTime
	 * @param id_scchl
	 * @return
	 * @throws BizException
	 */
	@Override
	public ScSchTickDO occupyChlTickByAchAndTime(String schId, SchTickMdTimeDTO schTickMdTime, String id_scchl)
			throws BizException {
		return new OccupyChlTickByAchAndTimeBP().exec(schId, schTickMdTime, id_scchl);
	}
	/**
	 * 根据排班和时间片时段占用号位  如果没有可用资源抛异常
	 * 
	 * @author liubin
	 * 
	 * @param schId
	 * @param schTickMdTime
	 * @param id_scchl
	 * @return
	 * @throws BizException
	 */
	@Override
	public ScSchTickDO occupyChlTickByAchAndTime4ChangeApt(String schId, SchTickMdTimeDTO schTickMdTime, String id_scchl,String id_enttp)
			throws BizException {
		return new OccupyChlTickByAchAndTime4ChangeAptBP().exec(schId, schTickMdTime, id_scchl,id_enttp);
	}
	/**
	 * 根据排班和时间片时段占用号位  如果没有可用资源抛异常
	 * 
	 * @author liubin
	 * 
	 * @param schId
	 * @param schTickMdTime
	 * @param id_scchl
	 * @return
	 * @throws BizException
	 */
	@Override
	public ScSchTickDO occupyChlTickByAchAndTime4Manual(String schId, SchTickMdTimeDTO schTickMdTime, String id_scchl,String id_enttp,MtResDTO resDTO)
			throws BizException {
		return new OccupyChlTickByAchAndTime4ManualBP().exec(schId, schTickMdTime, id_scchl,id_enttp,resDTO);
	}
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
	@Override
	public ScSchTickDO occupyChlTickBySrv(String tickId, Integer polcn, String srvId, String id_scchl)
			throws BizException {
		return new OccupyChlTickBySrvBP().exec(tickId, polcn, srvId, id_scchl);
	}
	
	/**
	 * 手动预约:按渠道根据服务占用指定号位， 如果没有可用资源抛异常
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
	@Override
	public ScSchTickDO occupyChlTickBySrv4Manual(String tickId, Map<Integer,Integer> polcnMap, String srvId, String id_scchl)
			throws BizException {
		return new OccupyChlTickBySrv4ManualAptBP().exec(tickId, polcnMap, srvId, id_scchl,null);
	}
	/**
	 * 按渠道根据服务占用指定号位， 如果没有可用资源抛异常
	 * 
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
	@Override
	public ScSchTickDO occupyChlTickBySrv8ExclDate(String tickId, Map<Integer,Integer> polcnMap, String srvId, String id_scchl,MtResDTO resDTO)
			throws BizException {
		return new OccupyChlTickBySrv4ManualAptBP().exec(tickId, polcnMap, srvId, id_scchl, resDTO);
	}
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
	@Override
	public void updateSchSugestExmint(ScDeptParamDO paramDO,ScDeptParamDsDO[] newDsDOs,ScDeptParamDsDO[] oldDsDOs) throws BizException {
		new UpdateSchSugestExmintBP().exec(paramDO,newDsDOs,oldDsDOs);
	}
	/**
	 * 查询可用时间段号段
	 * @author yaohl
	 * @param planDO  
	 * @param appDTO
	 * @param schDO
	 * @param id_scchl
	 * @param resDTO
	 * @return
	 * @throws BizException
	 */
	@Override
	public ScSchTickDO occupyChlTimeBySch4Auto(ScPlanDO planDO, MtAppDTO appDTO, String id_scchl,ScSchChlDO[] chlDOs,ScSchDO schDO,MtResDTO resDTO)
			throws BizException {
		return new OccupyChlTimeBySch4AutoBP().exec(planDO, appDTO, id_scchl,chlDOs,schDO,resDTO);
	}
	/**
	 * 查询可用时间段号段 自动定位预约日期
	 * @author yaohl
	 * @param planDO  
	 * @param appDTO
	 * @param schDO
	 * @param id_scchl
	 * @param resDTO
	 * @return
	 * @throws BizException
	 */
	@Override
	public ScSchTickDO occupyChlTimeBySch4AutoLocate(ScPlanDO planDO, MtAppDTO appDTO, String id_scchl,ScSchChlDO[] chlDOs,ScSchDO schDO,MtResDTO resDTO)
			throws BizException {
		return new OccupyChlTimeBySch4AutoLocateBP().exec(planDO, appDTO, id_scchl,chlDOs,schDO,resDTO);
	}
	@Override
	public ScSchTickDO OccupyChlTimeBySchQuick4Manual(ScPlanDO planDO, MtAppDTO appDTO, String id_scchl,ScSchChlDO[] chlDOs,ScSchDO schDO,MtResDTO resDTO) throws BizException {
		return new OccupyChlTimeBySchQuick4ManualBP().exec(planDO,appDTO,id_scchl,chlDOs,schDO,resDTO);
	}
}
