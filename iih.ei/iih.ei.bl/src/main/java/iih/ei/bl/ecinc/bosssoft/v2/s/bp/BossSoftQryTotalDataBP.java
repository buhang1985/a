package iih.ei.bl.ecinc.bosssoft.v2.s.bp;

import java.util.Map;

import com.alibaba.fastjson.JSON;

import iih.bd.base.utils.FBooleanUtils;
import iih.bl.inc.blecinccomp.d.BlEcIncCompDO;
import iih.bl.inc.dto.blelecbillcheckdto.d.CheckTotalDataDTO;
import iih.ei.bl.ecinc.bosssoft.constant.IEcIncBossSoftConst;
import iih.ei.bl.ecinc.bosssoft.v2.s.data.ReturnParam;
import iih.ei.bl.ecinc.bosssoft.v2.s.http.BossSoftHttpClient;
import iih.ei.bl.ecinc.d.EcIncResultDTO;
import iih.ei.bl.ecinc.d.EcIncTotalChkInputDTO;
import iih.ei.bl.ecinc.d.EcIncTotalChkOutDTO;
import iih.ei.bl.ecinc.util.EcIncCompUtil;
import iih.ei.bl.ecinc.util.EcIncDataUtil;
import iih.ei.bl.util.EIThirdLogger;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.sys.bdfw.bbd.d.PsnDocDO;

public class BossSoftQryTotalDataBP {
	
	/**
	 *  01	住院
		02	门诊
		03	急诊
		04	门特
		05	体检中心
		06	挂号
		07	住院预交金
		08	体检预交金
	 */
	private String[] busTypes = {"01","02","03","04","05","06","07","08"};

	public EcIncResultDTO<EcIncTotalChkOutDTO> exec(CheckTotalDataDTO dto) throws BizException {
		//收费还是退费
		if (dto.getEudirect() == 1) {
			//收费 = 全部- 退费
			EcIncResultDTO<EcIncTotalChkOutDTO> allDataCheck = allDataCheck(dto);
			EcIncResultDTO<EcIncTotalChkOutDTO> refundDataCheck = refundDataCheck(dto);
			if (FBooleanUtils.isTrue(allDataCheck.getFg_success()) 
			    && FBooleanUtils.isTrue(refundDataCheck.getFg_success())) {
				EcIncTotalChkOutDTO all = allDataCheck.getData();
				EcIncTotalChkOutDTO refund = refundDataCheck.getData();
				all.setAllTotalNum(all.getAllTotalNum() - refund.getAllTotalNum());
				all.setAllTotalAmt(all.getAllTotalAmt().sub(refund.getAllTotalAmt()));
				allDataCheck.setData(all);
				return allDataCheck;
			}else {
				return null;
			}
		}else if (dto.getEudirect() == -1) {
			//退费
			return refundDataCheck(dto);
		}else{
			//全部
			return allDataCheck(dto);
		}
	}
	
	/**
	 * 总笔数核对接口
	 * @param dto
	 * @return
	 * @throws BizException 
	 */
	private EcIncResultDTO<EcIncTotalChkOutDTO> allDataCheck(CheckTotalDataDTO dto) throws BizException{
		FDate starDate = dto.getBgbusdate().getDate();
		FDate endDate = dto.getEndbusdate().getDate();
		if (starDate.compareTo(endDate) > 0) return null;
		
		EcIncResultDTO<EcIncTotalChkOutDTO> rlt = new EcIncResultDTO<EcIncTotalChkOutDTO>();
		EcIncTotalChkOutDTO result = new EcIncTotalChkOutDTO();
		
		while (endDate.compareTo(starDate) > 0 || endDate.compareTo(starDate) == 0) {
			
			EcIncTotalChkInputDTO inParam = new EcIncTotalChkInputDTO();
			
			PsnDocDO psnDO = EcIncDataUtil.getPsnData(Context.get().getStuffId());
			Map<String, BlEcIncCompDO> psnCompMap = EcIncCompUtil.getCompData("07");
			BlEcIncCompDO psnCompDO = psnCompMap.get(psnDO.getCode());
			if(psnCompDO != null){
				inParam.setPlaceCode(psnCompDO.getEcinc_code());//开票点编码
			}else{
				inParam.setPlaceCode(psnDO.getCode());//开票点编码
			}
			inParam.setBusDate(starDate);
			inParam.setPageNo(1);
			inParam.setPageSize(10);
			
			ReturnParam rtnParam = null;
			
			try {
				BossSoftHttpClient httpClient = new BossSoftHttpClient(IEcIncBossSoftConst.METHOD_CHECKTOTALDATACODE,
						IEcIncBossSoftConst.METHOD_CHECKTOTALDATANAME);
				String data = JSON.toJSONString(inParam);
				rtnParam = httpClient.invoke(data);
			} catch (Exception e) {
				e.printStackTrace();
				EIThirdLogger.error(String.format("%s失败", IEcIncBossSoftConst.METHOD_CHECKTOTALDATANAME) + e.getMessage(), e);
				rlt.setFg_success(FBoolean.FALSE);
				rlt.setErrormsg(e.getMessage());
				rlt.setOutparam(e.getMessage());
				return rlt;
			}
			rlt.setFg_success(new FBoolean(rtnParam.getFgSuccess()));
			//如果成功
			if (FBoolean.TRUE.equals(rlt.getFg_success())) {
				
				EcIncTotalChkOutDTO outData = JSON.parseObject(rtnParam.getData(), EcIncTotalChkOutDTO.class);;
				result.setAllTotalNum(result.getAllTotalNum() + outData.getAllTotalNum());
				result.setAllTotalAmt(result.getAllTotalAmt().add(outData.getAllTotalAmt()));
				starDate = starDate.getDateAfter(1);
			}else {
				rlt.setErrormsg(rtnParam.getErrorMsg());
				return rlt;
			}
		}
		rlt.setData(result);
		return rlt;
	}
	
	
	/**
	 * 退费数据核对接口
	 * @param dto
	 * @return
	 * @throws BizException 
	 */
	private EcIncResultDTO<EcIncTotalChkOutDTO> refundDataCheck(CheckTotalDataDTO dto) throws BizException{
		FDate starDate = dto.getBgbusdate().getDate();
		FDate endDate = dto.getEndbusdate().getDate();
		if (starDate.compareTo(endDate) > 0) return null;
		
		EcIncResultDTO<EcIncTotalChkOutDTO> rlt = new EcIncResultDTO<EcIncTotalChkOutDTO>();
		EcIncTotalChkOutDTO result = new EcIncTotalChkOutDTO();
		
		while (endDate.compareTo(starDate) > 0 || endDate.compareTo(starDate) == 0) {
			
			for (int i = 0; i < busTypes.length; i++) {
				
				EcIncTotalChkInputDTO inParam = new EcIncTotalChkInputDTO();
				
				PsnDocDO psnDO = EcIncDataUtil.getPsnData(Context.get().getStuffId());
				Map<String, BlEcIncCompDO> psnCompMap = EcIncCompUtil.getCompData("07");
				BlEcIncCompDO psnCompDO = psnCompMap.get(psnDO.getCode());
				if(psnCompDO != null){
					inParam.setPlaceCode(psnCompDO.getEcinc_code());//开票点编码
				}else{
					inParam.setPlaceCode(psnDO.getCode());//开票点编码
				}
				inParam.setBusType(busTypes[i]);
				inParam.setBusDate(starDate);
				inParam.setPageNo(1);
				inParam.setPageSize(10);
				
				ReturnParam rtnParam = null;
				
				try {
					BossSoftHttpClient httpClient = new BossSoftHttpClient(IEcIncBossSoftConst.METHOD_CHECKWRITEOFFDATACODE,
							IEcIncBossSoftConst.METHOD_CHECKWRITEOFFDATANAME);
					String data = JSON.toJSONString(inParam);
					rtnParam = httpClient.invoke(data);
				} catch (Exception e) {
					e.printStackTrace();
					EIThirdLogger.error(String.format("%s失败", IEcIncBossSoftConst.METHOD_CHECKWRITEOFFDATANAME) + e.getMessage(), e);
					rlt.setFg_success(FBoolean.FALSE);
					rlt.setErrormsg(e.getMessage());
					rlt.setOutparam(e.getMessage());
					return rlt;
				}
				rlt.setFg_success(new FBoolean(rtnParam.getFgSuccess()));
				//如果成功
				if (FBoolean.TRUE.equals(rlt.getFg_success())) {
					
					EcIncTotalChkOutDTO outData = JSON.parseObject(rtnParam.getData(), EcIncTotalChkOutDTO.class);;
					result.setAllTotalNum(result.getAllTotalNum() + outData.getAllTotalNum());
					result.setAllTotalAmt(result.getAllTotalAmt().add(outData.getAllTotalAmt()));
					starDate = starDate.getDateAfter(1);//下一天
					
				}else {
					rlt.setErrormsg(rtnParam.getErrorMsg());
					return rlt;
				}
			}
		}
		rlt.setData(result);
		return rlt;
	}
	


}
