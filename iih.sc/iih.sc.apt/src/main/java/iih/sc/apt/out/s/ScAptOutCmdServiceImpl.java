package iih.sc.apt.out.s;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.apt.dto.d.ScAptMtDto;
import iih.sc.apt.out.ci.d.MtAptParamDTO;
import iih.sc.apt.out.ci.d.MtAptResDTO;
import iih.sc.apt.out.ci.d.ScAddApplInParamDTO;
import iih.sc.apt.out.cmd.bp.SaveApt4CiBP;
import iih.sc.apt.out.cmd.bp.SaveAutoApt4CiBP;
import iih.sc.apt.out.i.ISc4CiCmdService;
import iih.sc.apt.out.i.ISc4MpCmdService;
import iih.sc.apt.out.i.ISc4OutThirdCmdService;
import iih.sc.apt.out.i.ISc4PisCmdService;
import iih.sc.apt.s.bp.mt.AddBatchScAptApplBP;
import iih.sc.apt.s.bp.mt.AddScAptApplBP;
import iih.sc.apt.s.bp.mt.CancMtAptBP;
import iih.sc.apt.s.bp.mt.CancScAptApplBP;
import iih.sc.apt.s.bp.mt.GetScAptByIdOrsBP;
import iih.sc.apt.s.bp.mt.SaveMtAptBP;
import iih.sc.apt.s.bp.mt.SaveMtAptPubBP;
import iih.sc.apt.s.bp.mt.ScAptApplCancExecBP;
import iih.sc.apt.s.bp.mt.ScAptApplUndoCancExecBP;
import iih.sc.apt.s.bp.mt.UpdateMtApplAryBP;
import iih.sc.apt.s.bp.mt.apt.SaveManualMtAptBP;
import iih.sc.apt.s.bp.op.GetAptNotConfirm4CiBP;
import iih.sc.apt.s.bp.op.UpdateAptStatusForOptBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 预约域对外接口统一实现
 * @author renying
 *
 */
public class ScAptOutCmdServiceImpl  implements ISc4PisCmdService, ISc4CiCmdService,ISc4OutThirdCmdService,ISc4MpCmdService{

	/********************ISc4PisCmdService***********************/
	/**
	 * 保存医技预约信息
	 *
	 * @param mtresdto
	 * @param appdto
	 * @throws BizException
	 */
	@Override
	public MtResDTO saveMtApt(MtResDTO mtresdto, MtAppDTO appdto) throws BizException {
		SaveMtAptBP saveMtAptBp = new SaveMtAptBP();
		return saveMtAptBp.exec(mtresdto, appdto, IScDictCodeConst.SD_SCTP_MT);
	}

	/**
	 * 保存医技预约信息
	 *
	 * @param mtresdto
	 * @param appdto
	 * @throws BizException
	 */
	@Override
	public MtResDTO saveManualMtApt(MtResDTO mtresdto, MtAppDTO appdto) throws BizException {
		SaveManualMtAptBP saveMtAptBp = new SaveManualMtAptBP();
		return saveMtAptBp.exec(mtresdto, appdto, IScDictCodeConst.SD_SCTP_MT);
	}

	/**
	 * 取消医技预约
	 *
	 * @param appdto
	 * @throws BizException
	 */
	@Override
	public void cancelMtApt(MtAppDTO appdto) throws BizException {
		new CancMtAptBP().exec(appdto, IScDictCodeConst.SD_SCTP_MT);
	}

	/**
	 * 自动预约接口
	 * @param appDTP  id_or(医嘱id),id_scch(渠道) 不能为空
	 * @return  预约时间
	 */
	@Override
	public MtAptResDTO saveAutoApt4Ci(MtAppDTO appDTO) throws BizException {
		SaveAutoApt4CiBP bp = new SaveAutoApt4CiBP();
		return bp.exec(appDTO);
	}
	/**
	 * 第三方调用预约(医生站)
	 * @param appDTP  id_or(医嘱id),id_scch(渠道) 不能为空
	 * @return  预约结果相关信息
	 */
	@Override
	public MtAptResDTO saveApt4Ci(MtAptParamDTO paramDTO) throws BizException {
		SaveApt4CiBP bp = new SaveApt4CiBP();
		return bp.exec(paramDTO);
	}
	/********************ISc4CiCmdService***********************/

	/**
	 *
	 * 添加手术医技预约申请(单体)
	 *
	 * @param scAddApplInParam 手术预约申请信息
	 * @param scAptOptEmps 手术角色人员
	 * @throws BizException
	 */
	@Override
	public void addScAptAppl(ScAddApplInParamDTO scAddApplInParam) throws BizException{
		new AddScAptApplBP().exec(scAddApplInParam);
	}
	/**
	 *
	 * 添加手术医技预约申请(批量)
	 *
	 * @param scAddApplInParam 手术预约申请信息
	 * @throws BizException
	 */
	@Override
	public void addBatchScAptAppl(FArrayList scAddApplInParams) throws BizException {
		new AddBatchScAptApplBP().exec(scAddApplInParams);
	}

	/**
	 *
	 * 撤销手术预约申请
	 *
	 * @param id_or 医嘱id
	 * @param id_emp_canc 取消人员
	 * @param dt_canc 取消时间
	 * @param sd_su_or 医嘱状态
	 * @throws BizException
	 */
	@Override
	public void cancScAptAppl(String id_or, String id_emp_canc, FDateTime dt_canc, String sd_su_or) throws BizException{
		new CancScAptApplBP().exec(id_or, id_emp_canc, dt_canc, sd_su_or);
	}

	/**
	 * 医技预约 (与第三方调用共同方法)
	 * @param mtresdto
	 * @param appdto
	 * @param fg_out 第三方标识
	 * @return
	 * @throws BizException
	 */
	@Override
	public FMap saveMtAptPub(MtResDTO resDTO, MtAppDTO appDTO, String sd_sctp, FBoolean fg_out) throws BizException {
		return new SaveMtAptPubBP().exec(resDTO, appDTO, sd_sctp, fg_out);
	}

	/****
	 * 手术申请单确认、取消确认之后，修改手术预约状态
	 * fanlq-2018-09-16
	 * @param applNo
	 * @param isFinish
	 * @throws BizException
	 */
	@Override
	public void updateAptStatusForOpt(String applNo,FBoolean isFinish,FBoolean isBefConf) throws BizException{
		new UpdateAptStatusForOptBP().exec(applNo, isFinish,isBefConf);
	}

	/****
	 * 门诊医生站撤回、删除医技医嘱是否已确认判断
	 * @author yu.b 2020-07-20
	 * @param idOrs 医嘱id
	 * @return FMap key为msg,value为已预约医嘱错误信息，可为空；其他key为医嘱id，value为是否可撤回bool值
	 */
	@Override
	public FMap getAptNotConfirm4CI(FArrayList idOrs) throws BizException {
		return new GetAptNotConfirm4CiBP().exec(idOrs);
	}

	/********************ISc4MpCmdService***********************/

	/**
	 * MP域接收BS024消息后调用该接口接收MP参数修改医技预约申请单到检状态
	 * @author yzh
	 * @param params
	 * @throws BizException
	 */
	@Override
	public void updateMtApplAry(FArrayList params) throws BizException {
		new UpdateMtApplAryBP().exec(params);
	}

	/**
	 * 提供 给MP域设置预约申请-取消执行状态
	 * @author yaohl
	 * @param
	 * @throws BizException
	 */
	@Override
	public void setScAptApplCancExec(String[] idOrs,String id_emp,String dt_canc) throws BizException {
		ScAptApplCancExecBP cancExec = new ScAptApplCancExecBP();
		cancExec.exec(idOrs, id_emp, dt_canc);
	}

	/**
	 * 提供 给MP域设置预约申请-撤销取消执行状态
	 * @author yaohl
	 * @param
	 * @throws BizException
	 */
	@Override
	public void setScAptApplUndoCancExec(String[] idOrs,String id_emp,String dt_opera) throws BizException {
		ScAptApplUndoCancExecBP undoCancExecBP = new ScAptApplUndoCancExecBP();
		undoCancExecBP.exec(idOrs, id_emp, dt_opera);
	}
}
