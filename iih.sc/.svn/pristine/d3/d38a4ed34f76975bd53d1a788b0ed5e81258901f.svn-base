package iih.sc.sch.s;

import iih.sc.sch.dto.d.MtSchDTO;
import iih.sc.sch.dto.d.MtSchDetailDTO;
import iih.sc.sch.dto.d.MtSchMgrDTO;
import iih.sc.sch.dto.d.OpSchTplDTO;
import iih.sc.sch.dto.d.SchCancDTO;
import iih.sc.sch.dto.d.SchOralInfoDTO;
import iih.sc.sch.i.IScSchCmdService;
import iih.sc.sch.s.bp.AddSchBP;
import iih.sc.sch.s.bp.AddTicketBP;
import iih.sc.sch.s.bp.BatchGenOpSchBP;
import iih.sc.sch.s.bp.DeleteSchBP;
import iih.sc.sch.s.bp.RevokeTickBP;
import iih.sc.sch.s.bp.SaveMtSchBP;
import iih.sc.sch.s.bp.SaveMtSchMgrBP;
import iih.sc.sch.s.bp.SaveOralSchBP;
import iih.sc.sch.s.bp.SaveSchBp;
import iih.sc.sch.s.bp.SaveTickByTicksBp;
import iih.sc.sch.s.bp.SchBatchAdjBp;
import iih.sc.sch.s.bp.SetActiveStateOfSchBP;
import iih.sc.sch.s.bp.SetSchActiveBP;
import iih.sc.sch.s.bp.op.OpSchChangeAptBP;
import iih.sc.sch.s.bp.op.OpSchReplaceEntBP;
import iih.sc.sch.s.bp.op.StopSchAndCancelAptBP;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.scticks.d.ScSchTicksDO;

import java.util.Arrays;
import java.util.List;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FTime;

/**
 * 排班命令服务
 * 
 * @author yank
 * 
 */
@Service(serviceInterfaces = { IScSchCmdService.class }, binding = Binding.JSONRPC)
public class ScSchCmdServiceImpl implements IScSchCmdService {
	/**
	 * 号源加号
	 * 
	 * @param schId 排班id
	 * @param amount 加号个数
	 * @param addEnum 加号类型, 0：正常号；1：加号；2：补号
	 * @param polCn号源池
	 * @param schDetailDTO 排班详细信息
	 * @return
	 * @throws BizException
	 */
	@Override
	public ScSchTickDO[] addTick(String schId, int amount, Integer addEnum, Integer polCn, String scchlId, MtSchDetailDTO schDetailDTO) throws BizException {
		AddTicketBP addTicketBP = new AddTicketBP();
		return addTicketBP.addTick(schId, amount, addEnum, polCn, scchlId, schDetailDTO);
	}

	/**
	 * 作废票号
	 * 
	 * @param tickId 号位
	 * @param supplyTicketType 补号类型
	 * @throws BizException
	 */
	@Override
	public void revoke(String tickId, String supplyTicketType) throws BizException {
		RevokeTickBP revokeBP = new RevokeTickBP();
		revokeBP.exec(tickId, supplyTicketType);
	}

	/**
	 * 号段生成号位
	 * 
	 * @param ticksDOs 号段arrays
	 * @param sd_schrule 规则编码
	 * @throws BizException
	 */
	@Override
	public void saveTickByTicks(ScSchTicksDO[] ticksDOs, String sd_schrule) throws BizException {
		SaveTickByTicksBp byTicksBp = new SaveTickByTicksBp();
		byTicksBp.exec(ticksDOs, sd_schrule);
	}

	/**
	 * 新增或修改排班 ccj
	 * 
	 * @param schDO 排班do
	 */
	@Override
	public void saveSch(ScSchDO schDO) throws BizException {
		SaveSchBp saveSchBp = new SaveSchBp();
		saveSchBp.exec(schDO);
	}

	/**
	 * 生成排班
	 * 
	 * @param startStr 开始时间
	 * @param endStr 结束时间
	 * @param Id_dep 科室
	 * @param Id_scpl 计划
	 * @param Fg_recover 是否覆盖
	 * @param sctp 排班分类code
	 * @return 返回本次排班所有未排班的情况
	 * @throws Exception
	 */
	@Override
	public String addSch(String startStr, String endStr, String id_dep, String id_scpl, FBoolean fg_recover, String sctp)
			throws BizException {
		AddSchBP addSchBP = new AddSchBP();
		String infomation = addSchBP.exec(startStr, endStr, id_dep, id_scpl, fg_recover, sctp);
		return infomation;
	}

	/**
	 * 排班调整所涉及的所有信息
	 * 
	 * @param adjTypeCode 排班类型编码
	 * @param id_dept 科室id
	 * @param oldDate 原日期
	 * @param targetDate 调整到日期
	 * @param idScplList 排除计划
	 * @throws BizException
	 */
	@Override
	public void saveAdj(String adjTypeCode, String id_dept, FDate oldDate, FDate targetDate, List<String> idScplList)
			throws BizException {
		SchBatchAdjBp adjBp = new SchBatchAdjBp();
		adjBp.exec(adjTypeCode, id_dept, oldDate, targetDate, idScplList);
	}

	/**
	 * 保存医技排班信息
	 * 
	 * @param mtschdto
	 * @return
	 * @throws BizException
	 */
	@Override
	public String saveMtSch(MtSchDTO[] mtschdto, Boolean fg_cover, FDate dt_b, FDate dt_e, String tp, String depId)
			throws BizException {
		SaveMtSchBP saveBp = new SaveMtSchBP();
		return saveBp.exec(mtschdto, fg_cover, dt_b, dt_e, tp, depId);
	}

	/**
	 * 保存医技排班管理信息
	 * 
	 * @param mtschMgrDTO
	 * @throws BizException
	 */
	@Override
	public void saveMtSchMgr(MtSchDetailDTO mtschMgrDTO) throws BizException {
		SaveMtSchMgrBP saveMtSchMgrBp = new SaveMtSchMgrBP();
		saveMtSchMgrBp.exec(mtschMgrDTO);
	}

	/**
	 * 停用或者启用排班数据
	 * 
	 * @param mtschMgrDTO
	 * @throws BizException
	 */
	@Override
	public void SetSchActive(MtSchMgrDTO mtschMgrDTO) throws BizException {
		SetSchActiveBP setActiveBp = new SetSchActiveBP();
		setActiveBp.exec(mtschMgrDTO);
	}

	/**
	 * 新增、修改时保存口腔科排班
	 * 
	 * @param oralSchDTOList 口腔科排班信息DTO列表
	 * @throws BizException
	 * @author zhengcm
	 */
	@Override
	public void saveOralSch(SchOralInfoDTO[] oralSchDTOs) throws BizException {
		new SaveOralSchBP().exec(oralSchDTOs);
	}

	/**
	 * 批量生成排班
	 * 
	 * @param planIds 排班计划ID
	 * @param tpls 排班模板
	 * @param fgCover 是否覆盖
	 * @throws BizException
	 * @author yankan
	 */
	@Override
	public void batchGenOpSch(String[] planIds, OpSchTplDTO[] tpls, FBoolean fgCover) throws BizException {
		BatchGenOpSchBP batchGenBP = new BatchGenOpSchBP();
		batchGenBP.exec(planIds, tpls, fgCover);
	}

	/**
	 * 停诊门诊排班
	 * 
	 * @param schIds 排班ID集合
	 * @throws BizException
	 */
	@Override
	public String[] setActiveStateOfSch(String[] schIds, FBoolean IsActive) throws BizException {
		SetActiveStateOfSchBP stopBP = new SetActiveStateOfSchBP();
		return stopBP.exec(schIds, IsActive);
	}

	/**
	 * 批量删除门诊排班
	 * 
	 * @param schIds
	 * @throws BizException
	 */
	@Override
	public boolean batchDelOpSch(String[] schIds) throws BizException {
		DeleteSchBP delSchBP = new DeleteSchBP();
		return delSchBP.exec(Arrays.asList(schIds));
	}

	/**
	 * 门诊排班停诊：停诊并取消预约
	 * 
	 * @author zhengcm
	 * @date 2017-11-21 09:52:33
	 *
	 * @param id_sch
	 * @throws BizException
	 */
	@Override
	public void stopOpSchAndCancApt(String id_sch) throws BizException {
		new StopSchAndCancelAptBP().exec(id_sch);
	}

	/**
	 * 门诊排班停诊改约
	 * 
	 * @author zhengcm
	 * @date 2017-11-21 09:41:43
	 *
	 * @param datas
	 * @param id_sch
	 * @throws BizException
	 */
	@Override
	public void changeOpSchApt(SchCancDTO[] datas, String id_sch) throws BizException {
		new OpSchChangeAptBP().exec(datas, id_sch);
	}

	/**
	 * 门诊排班停诊替诊
	 * 
	 * @author zhengcm
	 * @date 2017-11-21 09:43:10
	 *
	 * @param originSchId
	 * @param currentSchId
	 * @throws BizException
	 */
	@Override
	public void replaceOpSchEnt(String originSchId, String currentSchId) throws BizException {
		new OpSchReplaceEntBP().exec(originSchId, currentSchId);
	}
}
