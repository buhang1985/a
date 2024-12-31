package iih.en.comm.ep;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.fc.entp.d.EnTypeDO;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.bp.GetEntpBP;
import iih.en.comm.bp.PatQryBP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnCodeUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.OpRegPiContDTO;
import iih.en.pv.outpatient.dto.d.PayInfoDTO;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitCudService;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.sc.sch.reg.dto.d.RegResDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 就诊信息扩展
 * 
 * @author yank
 * 
 */
public class PvEP {
	/**
	 * 根据就诊id获取就诊DO
	 * 
	 * @param entId 就诊id
	 * @throws BizException
	 */
	public PatiVisitDO getPvById(String entId) throws BizException {
		IPativisitRService pvRService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO pvDO = pvRService.findById(entId);
		return pvDO;
	}
	/**
	 * 根据就诊id获取就诊DO
	 * (不查询关联字段)
	 * 
	 * @param entId 就诊id
	 * @throws BizException
	 */
	public PatiVisitDO getPvByPK(String entId) throws BizException {
		if(EnValidator.isEmpty(entId))
			return null;
		return (PatiVisitDO) new DAFacade().findByPK(PatiVisitDO.class, entId);
	}
	/**
	 * 根据就诊id获取就诊DO
	 * (不查询关联字段)
	 * 
	 * @param entIds
	 * @return
	 * @throws BizException
	 */
	public PatiVisitDO[] getPvsByPKs(String[] entIds)throws BizException {
		if(EnValidator.isEmpty(entIds))
			return null;
		List<PatiVisitDO> list = (List<PatiVisitDO>) new DAFacade().findByPKs(PatiVisitDO.class, entIds);
		if(!EnValidator.isEmpty(list))
			return list.toArray(new PatiVisitDO[0]);
		return null;
	}

	/**
	 * 根据就诊id获取就诊DO
	 * 
	 * @param entIds 就诊id
	 * @throws BizException
	 */
	public PatiVisitDO[] getPvByIds(String[] entIds) throws BizException {
		IPativisitRService pvRService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO[] pvDOs = pvRService.findByBIds(entIds, FBoolean.TRUE);
		return pvDOs;
	}

	/**
	 * 根据就诊id获取就诊DO
	 * 
	 * @param entId 就诊id
	 * @throws BizException
	 */
	public PatiVisitDO[] getPvByWhereStr(String whereStr, String orderStr) throws BizException {
		IPativisitRService pvRService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO[] pvDOs = pvRService.find(whereStr, orderStr, FBoolean.FALSE);
		return pvDOs;
	}

	/**
	 * 根据就诊id获取就诊DO,不查关联字段
	 * 
	 * @param entId 就诊id
	 * @throws BizException
	 */
	public PatiVisitDO[] getPvByWhereStrWithOutRef(String whereStr, String orderStr) throws BizException {
		List<PatiVisitDO> patientDOList =  (List<PatiVisitDO>) new DAFacade().findByCond(PatiVisitDO.class,whereStr) ;
		if(EnValidator.isEmpty(patientDOList))
			return null;
		return patientDOList.toArray(new PatiVisitDO[]{});
	}
	/**
	 * 登录患者就诊数据
	 * 
	 * @param patDO 患者信息
	 * @param regInfo 注册信息
	 * @param payInfoDTO 付费信息
	 * @return
	 * @throws BizException
	 */
	public PatiVisitDO savePv(PatDO patDO, RegInfoDTO regInfo, PayInfoDTO payInfoDTO) throws BizException {
		FArrayList array = regInfo.getRegresarray();
		if (array == null || array.size() <= 0) {
			throw new BizException("挂号信息为空");
		}
		RegResDTO resDTO = (RegResDTO) array.get(0);
		PatiVisitDO pvDO = new PatiVisitDO();
		pvDO.setStatus(DOStatus.NEW);
		pvDO.setId_grp(EnContextUtils.getGrpId());// 集团
		pvDO.setId_org(EnContextUtils.getOrgId()); // 机构
		EnTypeDO entpDo = new GetEntpBP().exec(regInfo.getCode_entp(), regInfo.getId_erpre());
		pvDO.setId_entp(entpDo.getId_entp());// 就诊类型
		pvDO.setCode_entp(entpDo.getCode());// 就诊类型
		String entCode = EnCodeUtils.createEntCode();
		pvDO.setCode(entCode); // wjy-add
		pvDO.setDes("");	
		// 患者信息
		pvDO.setId_pat(patDO.getId_pat());// 患者id
		pvDO.setName_pat(patDO.getName());// 患者姓名
		pvDO.setId_sex_pat(patDO.getId_sex());// 性别id
		pvDO.setSd_sex_pat(patDO.getSd_sex());// 性别编码
		pvDO.setId_mari_pat(patDO.getId_marry());//婚姻状况id
		pvDO.setSd_mari_pat(patDO.getSd_marry());// 婚姻状况
		pvDO.setDt_birth_pat(patDO.getDt_birth());// 出生日期
		if (!EnValidator.isEmpty(patDO.getMob())) {
			pvDO.setTelno_pat(patDO.getMob());// 优先取手机号码
		} else {
			pvDO.setTelno_pat(patDO.getTel());// 联系电话
		}
		PatQryBP patQryBp = new PatQryBP();
		PatiAddrDO addrDo = patQryBp.getPatAddressDO(patDO.getId_pat(), IPiDictCodeConst.SD_ADDR_TYPE_NOW);
		if (addrDo != null) {
			pvDO.setAddr_pat(addrDo.getAdmdiv_fullname()); // 地址
			pvDO.setId_admdiv_addr(addrDo.getId_admdiv()); // 区县码
		}
		pvDO.setDt_entry(new FDateTime(regInfo.getRegisted_date().asLocalBegin().toDate())); // 就诊登记日期时间
		pvDO.setFg_acptvalid(FBoolean.FALSE); // 接诊有效
		pvDO.setId_dep_phy(resDTO.getId_dep()); // 当前就诊科室
		pvDO.setId_emp_entry(regInfo.getId_emp_entry()); // 登记人员
		pvDO.setId_hp(regInfo.getId_hp()); // 主医保计划
		pvDO.setId_patca(regInfo.getId_patca()); // 患者分类
		pvDO.setId_pripat(regInfo.getId_pripat()); // 价格分类
		pvDO.setId_patcret(regInfo.getId_patcredtp()); // 信用分类
		pvDO.setCode_hpmedkind(regInfo.getCode_hpmedkind());//医疗类别
		if (payInfoDTO == null || FBoolean.TRUE.equals(payInfoDTO.getFg_acc())) {
			pvDO.setFg_st(FBoolean.FALSE); // 
		} else {
			pvDO.setFg_st(FBoolean.TRUE); // 结算标志
		}
	    pvDO.setFg_ip(FBoolean.FALSE); // 在院标志
		pvDO.setFg_flup(FBoolean.FALSE); // 随访标志
		pvDO.setFg_canc(FBoolean.FALSE); // 退诊标志
		pvDO.setFg_data_transf(FBoolean.FALSE);// 可转移标识
		pvDO.setDt_insert(EnAppUtils.getServerDateTime()); // 插入时间
		if(payInfoDTO!=null && 
				(IBdPripmCodeConst.CODE_PRI_PM_COMPANY.equals(payInfoDTO.getPaystyle()) 
						|| IBdPripmCodeConst.CODE_PRI_PM_TRANSFE.equals(payInfoDTO.getPaystyle()))){
			pvDO.setId_cust_cmpy(payInfoDTO.getId_cust());//付款单位
		}else{
			if(regInfo.getMore()!=null && regInfo.getMore().size()>0) {
				OpRegPiContDTO regPiCont = (OpRegPiContDTO) regInfo.getMore().get(0);
				pvDO.setId_cust_cmpy(regPiCont.getId_cust_cmpy());//付款单位
			}
		}
		pvDO = this.savePv(pvDO);
		return pvDO;
	}

	/**
	 * 保存就诊DO
	 * 
	 * @param pvDO
	 * @return
	 * @throws BizException
	 */
	public PatiVisitDO savePv(PatiVisitDO pvDO) throws BizException {
		IPativisitCudService pvCudService = ServiceFinder.find(IPativisitCudService.class);
		PatiVisitDO[] pvDOs = pvCudService.save(new PatiVisitDO[] { pvDO });
		return pvDOs[0];
	}
	/**
	 * 保存就诊DO
	 * 
	 * @param pvs
	 * @return
	 * @throws BizException
	 */
	public PatiVisitDO[] save(PatiVisitDO[] pvs) throws BizException {
		IPativisitCudService pvCudService = ServiceFinder.find(IPativisitCudService.class);
		return pvCudService.save(pvs);
	}
	/**
	 * 批量查找就诊do
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public PatiVisitDO[] getPVs(List<String> entIdList) throws BizException {
		IPativisitRService iPativisitRService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO[] patiVisitDOs = iPativisitRService.findByIds(entIdList.toArray(new String[] {}), FBoolean.FALSE);
		return patiVisitDOs;
	}

	/**
	 * 获取就诊类型ID
	 * 
	 * @param entpCode
	 * @return
	 */
	public String getEntpId(String entpCode) {
		String entpId = null;
		switch (entpCode) {
		case IBdFcDictCodeConst.SD_CODE_ENTP_OP:
			entpId = IBdFcDictCodeConst.ID_CODE_ENTP_OP;
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET:
			entpId = IBdFcDictCodeConst.ID_CODE_ENTP_ET;
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_PE:
			entpId = IBdFcDictCodeConst.ID_CODE_ENTP_PE;
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_IP:
			entpId = IBdFcDictCodeConst.ID_CODE_ENTP_IP;
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_FA:
			entpId = IBdFcDictCodeConst.ID_CODE_ENTP_FA;
			break;
		}
		return entpId;
	}
	/**
	 * 患者数据发生状态改变，页面数据没刷新的情况
	 * @param endId
	 * @throws BizException
	 */
	public void validatePativisitDOEndTime(String endId) throws BizException{
		IPativisitRService rservice = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO entDo= rservice.findById(endId);
		if(entDo == null)return ;
		if(entDo.getDt_end()!=null){
			throw new BizException("该患者状态已更新，请刷新重试");
		}
	}
	/**
	 * 根据就诊ID删除就诊信息DO
	 * 
	 * @author zhengcm
	 * @param entId 就诊ID
	 * @throws BizException
	 */
	public void deleteEntById(String entId) throws BizException {
		EnValidator.validateParam("就诊ID", entId);
		// 患者就诊维护服务
		
		PatiVisitDO nbEntDO = this.getPvById(entId);
		IPativisitCudService cmdService = ServiceFinder.find(IPativisitCudService.class);
		cmdService.delete(new PatiVisitDO[] { nbEntDO });
	}
	/**
	 * 更新归档标志
	 * @param entId 就诊ID
	 * @param fgArchive 已归档标志
	 * @throws BizException
	 * @author yank
	 */
	public void updateArchiveFlag(String entId, FBoolean fgArchive) throws BizException {
		EnValidator.validateParam("就诊ID", entId);
		PatiVisitDO pvDO = this.getPvById(entId);
		if (pvDO == null) {
			throw new BizException(IEnMsgConst.ERROR_ENT_NOT_EXIST);
		}
		if (fgArchive == null) {
			fgArchive = FBoolean.FALSE;
		}
		pvDO.setFg_data_transf(fgArchive);
		pvDO.setStatus(DOStatus.UPDATED);
		this.savePv(pvDO);
	}
	/***
	 * 更新结算标志fg_st
	 * 
	 * @author fanlq 2017年11月16日
	 * @throws BizException
	 */
	public void ubpdateFgst(String entId) throws BizException {
		EnValidator.validateParam("就诊ID", entId);
		PatiVisitDO pvDO = this.getPvById(entId);
		if (pvDO == null) {
			throw new BizException(IEnMsgConst.ERROR_ENT_NOT_EXIST);
		}
		if(pvDO.getFg_st()!=null && pvDO.getFg_st().booleanValue()){
			return ;
		}
		pvDO.setFg_st(FBoolean.TRUE);
		pvDO.setStatus(DOStatus.UPDATED);
		this.savePv(pvDO);
	}
	/***
	 * 预约取号换患者之后修改en_ent
	 * @param patId -换患者之后的患者id
	 * @param entId -就诊id
	 * @throws BizException
	 */
	public void updateAfterChangePat(String patId,String entId) throws BizException {
		EnValidator.validateParam("就诊ID", entId);
		PatiVisitDO pvDO = this.getPvById(entId);
		if (pvDO == null) {
			throw new BizException(IEnMsgConst.ERROR_ENT_NOT_EXIST);
		}
		PatEP patEp = new PatEP();
		PatDO patDO =patEp.getPatById(patId); 
		if(patDO == null){
			throw new BizException(IEnMsgConst.ERROR_PAT_NOT_EXIST);
		}
		pvDO.setName_pat(patDO.getName());
		pvDO.setSd_sex_pat(patDO.getSd_sex());
		pvDO.setSd_mari_pat(patDO.getSd_marry());
		pvDO.setDt_birth_pat(patDO.getDt_birth());
		pvDO.setTelno_pat(patDO.getTel() == null ? patDO.getMob() : patDO.getTel());
		pvDO.setAddr_pat("");
		pvDO.setFg_st(FBoolean.TRUE);
		this.savePv(pvDO);
	}
}