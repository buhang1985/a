package iih.en.er.i;

import iih.en.er.dto.d.EnErBasic4EditDTO;
import iih.en.er.dto.d.EnErPrQueryDTO;
import iih.en.er.dto.d.EnErPreInfoDTO;
import iih.en.er.dto.d.EnErPreTriageDTO;
import iih.en.er.dto.d.EnObsPermitDTO;
import iih.en.er.dto.d.UrgInOutTransMgrDTO;
import iih.en.er.dto.d.UrgStayOutDTO;
import iih.en.er.dto.d.UrgStayRegistryDTO;
import iih.en.pv.inpatient.dto.d.BedBigCardDTO;
import iih.en.pv.outpatient.dto.d.OpRegPatDTO;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import xap.mw.core.data.BizException;

/**
 * 急诊操作服务
 * 
 * @author liubin
 *
 */
public interface IEnErCmdService {
	/**
	 * 保存急诊预检
	 * 
	 * @param erPreTriage
	 * @return
	 * @throws BizException
	 */
	EnErPreTriageDTO saveErPre(EnErPreTriageDTO erPreTriage) throws BizException;
	/**
	 * 急诊换患者处理
	 * 
	 * @param opRegPatDto
	 * @throws BizException
	 */
	void changePatHandle(OpRegPatDTO opRegPatDto) throws BizException;
	/**
	 * 急诊挂号处理
	 * 
	 * @param regInfo
	 * @throws BizException
	 */
	void handleErRegist(RegInfoDTO regInfo) throws BizException;
	/**
	 * 急诊退号处理
	 * 
	 * @param entId
	 * @throws BizException
	 */
	void handleErCancRegist(String entId) throws BizException;
	/**
	 * 保存留观许可
	 * 
	 * @param obspermit
	 * @return
	 * @throws BizException
	 */
	EnObsPermitDTO saveObsPer(EnObsPermitDTO obspermit) throws BizException;
	/**
	 * 取消留观许可
	 * 
	 * @param obspermit
	 * @return
	 * @throws BizException
	 */
	void cancelObsPer(EnObsPermitDTO obspermit) throws BizException;
	/**
	 * 保存留观登记
	 * 
	 * @param urgstayregistry
	 * @return
	 * @throws BizException
	 */
	UrgStayRegistryDTO saveUrgStayRegist(UrgStayRegistryDTO urgstayregistry) throws BizException;
	/**
	 * 取消留观登记信息
	 * 
	 * @param urgstayregistry
	 * @return
	 * @throws BizException
	 */
	void cancelUrgStayReg(UrgStayRegistryDTO urgstayregistry) throws BizException;
	/**
	 * 急诊入出转操作
	 * 
	 * @param data
	 * @param euUrgInOutTransMgrType
	 * @return
	 * @throws BizException
	 */
	UrgInOutTransMgrDTO urgInOutTransMgr(UrgInOutTransMgrDTO data, String euUrgInOutTransMgrType) throws BizException;
	/**
     * 抢救-计算并更新腕带打印次数
     * 
     * @param idEnt
	 * @throws BizException 
     */
	public void updateRescuePrintTimes(String idEnt) throws BizException;
	/**
	 * 保存出留观信息
	 * 
	 * @param urgstayout
	 * @return
	 * @throws BizException
	 */
	UrgStayOutDTO saveUrgStayOut(UrgStayOutDTO urgstayout) throws BizException;
	/***
	 * 抢救换床
	 * @param mainStateDTO
	 * @throws BizException
	 */
	void rescueChangeBed(BedBigCardDTO source,BedBigCardDTO target) throws BizException;
	/***
	 * 预检查询取消预检
	 * @param mainStateDTO
	 * @throws BizException
	 */
	void cancelPreExam(EnErPrQueryDTO[] dtos) throws BizException;
	/**
	 * 更新急诊患者基本信息
	 * @param enErBasic4EditDTO
	 * @return
	 * @throws BizException 
	 * @auther yaohl
	 * @date 2018年12月28日
	 */
	EnErBasic4EditDTO saveEnErBasic4Edit(EnErBasic4EditDTO enErBasic4EditDTO) throws BizException;
	/***
	 * 急诊抢救医生站患者接诊校验控制
	 * @param id_ent
	 * @throws BizException
	 */
    void urgDocStationRecivePat(EnErPreInfoDTO dto) throws BizException;
}
