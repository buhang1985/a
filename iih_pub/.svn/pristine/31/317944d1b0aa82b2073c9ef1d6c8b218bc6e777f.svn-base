package iih.nm.nhr.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmpsnshift.d.NmNurTransDO;
import iih.nm.nhr.psnshiftdto.d.NurTransDTO;
import iih.nm.nhr.psnshiftdto.d.PsnShiftInfoDTO;

/**
 * @author 作者 :huang_junhao
 * @version 创建时间：2016年12月30日 下午2:10:07
 * 类说明：护理管理 -人员调动自定义服务
 * Company: Copyright 2016 by PKU healthcare IT Co.Ltd.
 */
public interface INmPsnShiftExtService {

	/**
	 * 调动人员信息回写
	 * @param dto
	 */
	public abstract PsnShiftInfoDTO getPsnInfo(PsnShiftInfoDTO dto)throws BizException;
	
	/**
	 * 保存调动信息
	 * @param transDTOs
	 * @param psnShiftInfoDTOs
	 * @throws BizException
	 */
	public abstract void saveTransInfo(NurTransDTO transDTO,PsnShiftInfoDTO[] psnShiftInfoDTOs)throws BizException;

	/**
	 * 人员调动_接收动作
	 * @param nmNurTransDOs
	 * @throws BizException
	 */
	public abstract void receiveNurPsn(NmNurTransDO[] nmNurTransDOs)throws BizException;
	
	/**
	 * 人员调动_提交（调动申请）
	 * @param nmNurTransDOs
	 * @throws BizException
	 */
	public abstract void commitTransInfo(NmNurTransDO[] nmNurTransDOs)throws BizException;
	
	/**
	 * 人员调动_审核通过（调动申请）
	 * @param nmNurTransDOs
	 * @throws BizException
	 */
	public abstract void passTransInfo(NmNurTransDO[] nmNurTransDOs)throws BizException;
	
	/**
	 * 人员调动_审核驳回（调动申请）
	 * @param nmNurTransDOs
	 * @throws BizException
	 */
	public abstract void rejectTransInfo(NmNurTransDO[] nmNurTransDOs)throws BizException;
}
