package iih.bl.cc.s.bp;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.CollectionUtils;
import iih.bl.cc.blcc.d.BlccAggDO;
import iih.bl.cc.blcc.i.IBlccCudService;
import iih.bl.cc.dto.d.BlCcInParamDTO;
import iih.bl.cc.dto.d.BlCcOutParamDTO;
import iih.bl.cc.ep.CcEP;
import iih.bl.cc.service.i.IBLCcMaintainService;
import iih.bl.cc.service.i.IBLCcQueService;
import iih.bl.comm.log.BLTaskLogger;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 对外结账接口
 * 
 * @author liming06
 * @since 2020-05-13
 */
public class DoBlccCheckoutBP {
	public BlCcOutParamDTO[] exec(BlCcInParamDTO blCcInparamDTO) throws BizException {
		// 1.参数校验
		valid(blCcInparamDTO);
		// 2.结账
		BlCcOutParamDTO[] blCcOutParamDTOArr = this.doCheckOut(blCcInparamDTO);
		return blCcOutParamDTOArr;
	}

	/**
	 * 结账
	 * 
	 * @param blCcInparamDTO
	 * @return
	 * @throws BizException
	 */
	private BlCcOutParamDTO[] doCheckOut(BlCcInParamDTO blCcInparamDTO) throws BizException {

		List<BlCcOutParamDTO> outParamDTOList = new ArrayList<BlCcOutParamDTO>();
		FBoolean bBlcc = FBoolean.FALSE; // 是否结过账
		String id_grp = blCcInparamDTO.getId_grp();
		String id_org = blCcInparamDTO.getId_org();
		String sd_cctp = blCcInparamDTO.getCctp();
		FBoolean fgCrossDay = blCcInparamDTO.getCrossday_flag();// 是否跨天
		String cctime = blCcInparamDTO.getCctime();
		FBoolean fgEmptyCC = blCcInparamDTO.getCreateblcc_flag();// 是否生成空记账数据
		// 参与此次结账人员id
		List<String> psnCC = new ArrayList<String>();
		// 获取当前时间
		FDateTime fdTime = AppUtils.getServerDateTime();
		if (FBoolean.TRUE.equals(fgCrossDay)) {
			fdTime = fdTime.getDateTimeBefore(1);
		}
		if (cctime != null && !StringUtil.isEmpty(cctime.toString())) {
			// 设置当前日期与传入的时间为结算时间
			fdTime = new FDateTime(fdTime.getDate().toString() + " " + cctime);
		}
		// 1创建服务
		IBLCcQueService ccQueService = ServiceFinder.find(IBLCcQueService.class);
		IBLCcMaintainService ccMaService = ServiceFinder.find(IBLCcMaintainService.class);
		IBlccCudService blccService = ServiceFinder.find(IBlccCudService.class);

		// 2循环获取出的人员数据 获取待结账数据
		for (Object obj : blCcInparamDTO.getId_psndoc()) {
			String idPsn = (String) obj;
			BLTaskLogger.info(String.format("人员(%s)自动结账开始", idPsn));
			Context.get().setGroupId(id_grp);
			Context.get().setOrgId(blCcInparamDTO.getId_org());
			Context.get().setStuffId(idPsn);
			// Context.get().setDeptId(psnDo.getId_dep());
			
			BlCcOutParamDTO outparamDTO= new BlCcOutParamDTO();
			outparamDTO.setId_psndoc(idPsn);
			try {
				// 2.2 获取待结账数据
				BlccAggDO[] blccAfterAggDOArr =null; //结账后返回数据
				BlccAggDO[] blccAggDOArr = ccQueService.previewChechOut(idPsn, id_grp, sd_cctp, fdTime);
				if (!ArrayUtil.isEmpty(blccAggDOArr)) {
					bBlcc = FBoolean.TRUE;
					// 2.3对应 结账人员 进行结账
					BlccAggDO[] ccAgg = ccMaService.doCheckoutChange(blccAggDOArr, sd_cctp, fdTime);
					// 获取结账数据后 修改结账时间为当前时间
					if (!ArrayUtil.isEmpty(ccAgg)) {
						for (BlccAggDO ccAggDO : ccAgg) {
							ccAggDO.getParentDO().setDt_cc(fdTime);
							ccAggDO.getParentDO().setStatus(DOStatus.UPDATED);
						}
						blccAfterAggDOArr = blccService.save(ccAgg);
					}
				}
				if (FBoolean.FALSE.equals(bBlcc) && !psnCC.contains(idPsn)) {
					psnCC.add(idPsn);
				}
				
				outparamDTO.setResult_flag(FBoolean.TRUE);
				if (!ArrayUtil.isEmpty(blccAfterAggDOArr)) {
					outparamDTO.setCode_cc(blccAfterAggDOArr[0].getParentDO().getCode_cc());
				}
				outParamDTOList.add(outparamDTO);

			} catch (Exception e) {
				BLTaskLogger.error(String.format("人员(%s)自动结账失败。原因:%s", idPsn, e.getMessage()), e);
				outparamDTO.setResult_flag(FBoolean.FALSE);
				outparamDTO.setErrormsg(e.getMessage());
				outParamDTOList.add(outparamDTO);
			}

			BLTaskLogger.info(String.format("人员(%s)自动结账结束", idPsn));
		}
		//3对于结账参数中的人员，如果没有结账数据，则默认插入一条结账数据
		if (FBoolean.TRUE.equals(fgEmptyCC)) {
			List<String> cctpList = new ArrayList<String>();
			cctpList.add(sd_cctp);
			String[] idPsnArr = (String[]) blCcInparamDTO.getId_psndoc().toArray(new String[]{});
			Context.get().setOrgId(id_org);
			Context.get().setGroupId(id_grp);
			CcEP ccep = new CcEP();
			ccep.saveEmptyBlccAggDO(idPsnArr, cctpList, fdTime, psnCC);
		}

		return outParamDTOList.toArray(new BlCcOutParamDTO[] {});
	}

	/**
	 * 参数校验
	 * 
	 * @param blCcInparamDTO
	 * @throws BizException
	 */
	private void valid(BlCcInParamDTO blCcInparamDTO) throws BizException {
		if (blCcInparamDTO == null) {
			throw new BizException("参数不能为空！");
		}
		if (StringUtil.isEmpty(blCcInparamDTO.getCctp())) {
			throw new BizException("结账类型不能为空！");
		}
		if (StringUtil.isEmpty(blCcInparamDTO.getId_grp())) {
			throw new BizException("集团不能为空！");
		}
		if (StringUtil.isEmpty(blCcInparamDTO.getId_org())) {
			throw new BizException("组织不能为空！");
		}
		if (CollectionUtils.isEmpty(blCcInparamDTO.getId_psndoc())) {
			throw new BizException("结账人员不能为空！");
		}
	}
}
