package iih.sc.apt.out.cmd.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.apt.i.IScAptCmdService;
import iih.sc.apt.i.IScAptQryService;
import iih.sc.apt.out.ci.d.MtAptParamDTO;
import iih.sc.apt.out.ci.d.MtAptResDTO;
import iih.sc.comm.IScMsgConst;
import iih.sc.scbd.bdsrv.d.ScBdsrvDO;
import iih.sc.scbd.bdsrv.i.IScbdsrvMDORService;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvRelDO;
import iih.sc.scbd.schedulesrv.i.IScheduleSrvRelDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class SaveApt4CiBP {
	/**
	 * CI 保存预约
	 * @param paramDTO
	 * @return
	 * @throws BizException
	 */
	public MtAptResDTO exec(MtAptParamDTO paramDTO) throws BizException{
		MtAptResDTO mtAptResDTO = this.ValidData(paramDTO);
		if(!mtAptResDTO.getSuccess().booleanValue())
		{
			return mtAptResDTO;
		}
		
		MtAppDTO mtAppDTO = this.getAppDTO(paramDTO);
		if(IScDictCodeConst.CI_AUTO_SC_APT_MODE.equals(paramDTO.getSc_mt_mode())){// 自动预约模式
			return this.autoApt(mtAppDTO, mtAptResDTO);
		}else if(IScDictCodeConst.CI_DIALOG_SC_APT_MODE.equals(paramDTO.getSc_mt_mode())){// 手动预约模式
			return this.manualApt(mtAppDTO, mtAptResDTO);
		}
		return null;
	}
	/**
	 * 自动预约
	 * @param mtAppDTO
	 * @param mtAptResDTO
	 * @return
	 * @throws BizException
	 */
	private MtAptResDTO autoApt(MtAppDTO mtAppDTO,MtAptResDTO mtAptResDTO) throws BizException{
		MtResDTO mtresdto = new MtResDTO();
		mtresdto.setId_dep(mtAppDTO.getId_dep_mp());
		mtresdto.setId_scchl(mtAppDTO.getId_scchl());
		mtresdto.setFg_autofilter(FBoolean.FALSE);
		IScAptCmdService iScAptCmdService = ServiceFinder.find(IScAptCmdService.class);
		MtResDTO rResDTO = null ;
		try
		{
			rResDTO = iScAptCmdService.saveAutoMtApt(mtresdto, mtAppDTO);
		}
		catch(BizException  e)
		{
			mtAptResDTO = new MtAptResDTO();
			mtAptResDTO.setSuccess(FBoolean.FALSE);
			mtAptResDTO.setError_msg("预约失败:"+e.getMessage());
			return mtAptResDTO;
		}
		mtAptResDTO.setSuccess(FBoolean.TRUE);
		return mtAptResDTO;
	}
	/**
	 * 手动预约返回要弹出的节点
	 * @param mtAppDTO
	 * @param mtAptResDTO
	 * @return
	 * @throws BizException
	 */
	private MtAptResDTO manualApt(MtAppDTO mtAppDTO,MtAptResDTO mtAptResDTO) throws BizException{
		IScheduleSrvRelDORService relQryService = ServiceFinder.find(IScheduleSrvRelDORService.class);
		String where = String.format(ScheduleSrvRelDO.ID_MDSRV + " = '%s'", mtAppDTO.getId_srv());
		ScheduleSrvRelDO[] relDOs = relQryService.find(where, null, FBoolean.FALSE);
		if (ArrayUtil.isEmpty(relDOs)) {
			mtAptResDTO.setSuccess(FBoolean.FALSE);
		}else{
			mtAptResDTO.setFunc_code(IScDictCodeConst.PSN_SC_APT_FUNC_CODE);
			mtAptResDTO.setSuccess(FBoolean.TRUE);
		}
		return mtAptResDTO;
	}
	/**
	 * 拼装预约参数
	 * @param paramDTO
	 * @return
	 * @throws BizException 
	 */
	private MtAppDTO getAppDTO(MtAptParamDTO paramDTO) throws BizException{
		MtAppDTO appDTO = new MtAppDTO();
		appDTO.setId_pat(paramDTO.getId_pat());
		appDTO.setId_or(paramDTO.getId_or());
		appDTO.setId_srv(paramDTO.getId_srv());
		appDTO.setName_or(paramDTO.getName_or());
		appDTO.setId_enttp(paramDTO.getId_entp());
		appDTO.setId_ent(paramDTO.getId_ent());
		appDTO.setId_dep_mp(paramDTO.getId_dep_mp());
		appDTO.setId_emp_apply(paramDTO.getId_emp_appl());
		appDTO.setFg_urgent(paramDTO.getFg_urgent());
		appDTO.setNo_applyform(paramDTO.getApplyno());
		appDTO.setDt_effe_or(paramDTO.getDt_effe_or());
		appDTO.setDt_apply(paramDTO.getD_begin());
		appDTO.setDt_plan(paramDTO.getDt_effe_or());
		appDTO.setId_dep_apply(paramDTO.getId_dep_apply());
		appDTO.setContent_or(paramDTO.getContent_or());
		if(StringUtil.isEmpty(appDTO.getId_srv())){
			appDTO.setFg_needcfm(FBoolean.FALSE);
		}else{
			IScbdsrvMDORService iscbdsrvmdorservice = ServiceFinder.find(IScbdsrvMDORService.class);
			ScBdsrvDO[] scbdsrvs = iscbdsrvmdorservice.find("id_srv='"+appDTO.getId_srv()+"'", null, FBoolean.FALSE);
			if(ArrayUtil.isEmpty(scbdsrvs)){
				appDTO.setFg_needcfm(FBoolean.FALSE);
			}else{
				appDTO.setFg_needcfm(scbdsrvs[0].getFg_needcfm());
			}
		}
		if(StringUtil.isEmpty(paramDTO.getId_scchl())){
			IScAptQryService iscaptqryservice = ServiceFinder.find(IScAptQryService.class);
			SchedulechlDO[] chlDOs = iscaptqryservice.valAptHaveChannel(paramDTO.getCode_scchl());
			if(!ArrayUtil.isEmpty(chlDOs)){
				appDTO.setId_scchl(chlDOs[0].getId_scchl());
			}
		}else{
			appDTO.setId_scchl(paramDTO.getId_scchl());
		}
		return appDTO;
	}
	/**
	 * 校验入参
	 * @param appDTO
	 * @return
	 */
	private MtAptResDTO ValidData(MtAptParamDTO paramDTO)
	{
		MtAptResDTO resDTO = new MtAptResDTO();
		resDTO.setSuccess(FBoolean.TRUE);
		resDTO.setError_msg("");
		if(paramDTO == null)
		{
			resDTO.setSuccess(FBoolean.FALSE);
			resDTO.setError_msg("预约失败：入参为null");
			return resDTO;
		}
		if(StringUtil.isEmpty(paramDTO.getId_or()))
		{
			resDTO.setSuccess(FBoolean.FALSE);
			resDTO.setError_msg("预约失败：医嘱id(id_or)为空");
			return resDTO;
		}
		if(StringUtil.isEmpty(paramDTO.getId_scchl()) && StringUtil.isEmpty(paramDTO.getCode_scchl()))
		{
			resDTO.setSuccess(FBoolean.FALSE);
			resDTO.setError_msg("预约失败：渠道为空(id_scchl)为空");
			return resDTO;
		}
		if(StringUtil.isEmpty(paramDTO.getSc_mt_mode()))
		{
			resDTO.setSuccess(FBoolean.FALSE);
			resDTO.setError_msg("预约失败:预约模式为空(sc_mt_mode)为空");
			return resDTO;
		}
		return resDTO;
	}
}
