package iih.nm.nhr.i;

import iih.nm.nhr.dto.nhrschedweekdto.d.SchedWeekDTO;
import iih.nm.nhr.dto.nmoptpldto.d.NmOptPlDTO;
import iih.nm.nhr.dto.nurinfo.d.NurInfoDTO;
import iih.nm.nhr.dto.weeksched.d.SchedDataTableDTO;
import iih.nm.nhr.nhrsched.d.NhrschedAggDO;
import iih.nm.nhr.nmnhrschedlv.d.NmNhrSchedLvDO;
import iih.nm.nhr.nmnhrschedrp.d.NhrSchedRpDO;
import iih.nm.nhr.nmnhrsigrp.d.NmnhrsigrpAggDO;
import iih.nm.nhr.nmnurtrpt.d.NmNurTrptDO;
import iih.nm.nhr.nmoptpl.d.NmoptplAggDO;
import iih.nm.nhr.nmpsndoc.d.NmNurDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.sys.bdfw.bbd.d.PsnDocDO;

public interface INmNhrMaintainService {

	/**
	 * 周排班——保存排班信息
	 * 
	 * @param schedData排版信息
	 * @return
	 * @throws BizException
	 */
	public abstract SchedDataTableDTO SaveSchedDataByWeek(SchedDataTableDTO schedData) throws BizException;

	/**
	 * 保存排班分组数据
	 * 
	 * @param aggdos
	 * @return
	 * @throws BizException
	 */
	public abstract NmnhrsigrpAggDO[] SaveSiGrpData(FDate dt_monday, String id_dep_nur, NmnhrsigrpAggDO[] aggdos) throws BizException;

	/**
	 * 通用排班分组保存
	 * 
	 * @param dt_monday
	 * @param aggdos
	 * @return
	 * @throws BizException
	 */
	public abstract NmnhrsigrpAggDO[] ComSaveSiGrpData(FDate dt_monday, NmnhrsigrpAggDO[] aggdos) throws BizException;

	/**
	 * 保存小组排班计划
	 * 
	 * @param dtos
	 * @return
	 * @throws BizException
	 */
	public abstract NmoptplAggDO[] SavePlanData(NmOptPlDTO[] dtos) throws BizException;

	/**
	 * 保存班次排班信息
	 * 
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public abstract SchedWeekDTO saveSchedData(SchedWeekDTO dto) throws BizException;

	/**
	 * 保存调岗记录信息
	 */
	public abstract NmNurTrptDO[] SaveNurTrpt(NmNurTrptDO nurTrpt) throws BizException;

	/**
	 * 护理人员同步
	 * 
	 * @param id_dep_nur
	 * @throws BizException
	 */
	public abstract void NmNurPsnSync(String id_dep_nur) throws BizException;

	/**
	 * 人员分组护士层级信息同步
	 * 
	 * @param dt_monday
	 * @param id_dep_nur
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean siGrpNurInfoSync(FDate dt_monday, String id_dep_nur) throws BizException;

	/**
	 * 排班分组人员信息同步
	 * 
	 * @param dt_month
	 * @param id_dep_nur
	 * @throws BizException
	 */
	public abstract void NmSiGrpNurInfoSync(FDate dt_month, String id_dep_nur) throws BizException;

	/**
	 * 更改排班状态信息
	 * 
	 * @param schedData
	 * @return
	 * @throws BizException
	 * @author lijm
	 */
	public FBoolean SchedStausChangeData(SchedDataTableDTO schedData, String cmdtp) throws BizException;

	/**
	 * 替班申请审核完成后，同步工时调整
	 * 
	 * @param schedRpData
	 * @return
	 * @throws BizException
	 */
	public void updateNurLaborBySchedRp(NhrSchedRpDO schedRpData) throws BizException;

	/**
	 * 请假申请审核通过，同步工时调整
	 * 
	 * @param schedLvDO
	 * @throws BizException
	 */
	public FBoolean updateNurLaborDataBySchedLv(NmNhrSchedLvDO schedLvDO) throws BizException;

	/**
	 * 保存人员基本信息
	 * 
	 * @author lijm
	 * @param psnDocDo
	 * @return
	 * @throws BizException
	 */
	public NurInfoDTO savePsnDoc(PsnDocDO psnDocDo) throws BizException;

	/**
	 * 保存人员护理信息
	 * 
	 * @author lijm
	 * @param nurDo
	 * @return
	 * @throws BizException
	 */
	public NurInfoDTO saveNurInfo(NmNurDO nurDo) throws BizException;

	/**
	 * 排班分组人员交换组内选序号
	 * 
	 * @param id_nhr_sigrp排班分组id
	 * @param id_nur_fir护理人员1
	 * @param id_nur_sec护理人员2
	 * @throws BizException
	 * @author lijm
	 * @DateTime2019-1-15 21:02:08
	 */
	public void siGrpPsnSwopSortno(String id_nhr_sigrp, String id_nur_fir, String id_nur_sec) throws BizException;

	/**
	 * 复制上周排班
	 * 
	 * @param dt_monday
	 *            生成排班周 周一
	 * @return
	 * @throws BizException
	 */
	public NhrschedAggDO[] copyPreSchedulData(FDate dt_monday, String id_dep_nur) throws BizException;
}
