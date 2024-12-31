package iih.ei.bl.ecinc.bosssoft.v2.s.bp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import iih.bl.inc.blecinccomp.d.BlEcIncCompDO;
import iih.ei.bl.ecinc.bosssoft.constant.IEcIncBossSoftConst;
import iih.ei.bl.ecinc.bosssoft.v2.s.data.ReturnParam;
import iih.ei.bl.ecinc.bosssoft.v2.s.data.manage.EcManageIncCodeParam;
import iih.ei.bl.ecinc.bosssoft.v2.s.data.manage.EcManageIncTypeParam;
import iih.ei.bl.ecinc.bosssoft.v2.s.data.manage.EcManagePaperActCodeParam;
import iih.ei.bl.ecinc.bosssoft.v2.s.data.manage.EcManagePaperActOutParam;
import iih.ei.bl.ecinc.bosssoft.v2.s.http.BossSoftHttpClient;
import iih.ei.bl.ecinc.d.EcIncManagePaperIncCodeInDTO;
import iih.ei.bl.ecinc.d.EcIncManagePaperIncCodeOutDTO;
import iih.ei.bl.ecinc.d.EcIncResultDTO;
import iih.ei.bl.ecinc.util.EcIncCompUtil;
import iih.ei.bl.ecinc.util.EcIncDataUtil;
import iih.ei.bl.util.EIThirdLogger;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.bdfw.bbd.d.PsnDocDO;

/**
 * 
 * 获取纸质发票有效票据代码
 * @author ly 2020/01/02
 *
 */
public class BossSoftEcIncManageGetActicePIncCodeBP {

	/**
	 * 获取纸质票据有效票据代码
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public EcIncResultDTO<List<EcIncManagePaperIncCodeOutDTO>> exec(EcIncManagePaperIncCodeInDTO dto) throws BizException {
		
		EcManagePaperActCodeParam inParam = new EcManagePaperActCodeParam();
		PsnDocDO psnDO = EcIncDataUtil.getPsnData(Context.get().getStuffId());
		Map<String, BlEcIncCompDO> psnCompMap = EcIncCompUtil.getCompData("07");
		BlEcIncCompDO psnCompDO = psnCompMap.get(psnDO.getCode());
		if(psnCompDO != null){
			inParam.setPlaceCode(psnCompDO.getEcinc_code());//开票点编码
		}else{
			inParam.setPlaceCode(psnDO.getCode());//开票点编码
		}
		
		ReturnParam rtnParam = null;
		try {
			BossSoftHttpClient httpClient = new BossSoftHttpClient(IEcIncBossSoftConst.METHOD_GETVALIDBILLBATCHCODE,
					IEcIncBossSoftConst.METHOD_GETVALIDBILLBATCHCODE_NAME);
			String data = JSON.toJSONString(inParam);
			rtnParam = httpClient.invoke(data);
		} catch (Exception e) {
			e.printStackTrace();
			EIThirdLogger.error(String.format("%s失败", IEcIncBossSoftConst.METHOD_GETVALIDBILLBATCHCODE_NAME) + e.getMessage(), e);
			EcIncResultDTO<List<EcIncManagePaperIncCodeOutDTO>> rlt = new EcIncResultDTO<List<EcIncManagePaperIncCodeOutDTO>>();
			rlt.setFg_success(FBoolean.FALSE);
			rlt.setErrormsg(e.getMessage());
			rlt.setOutparam(e.getMessage());
			return rlt;
		}
		
		EcIncResultDTO<List<EcIncManagePaperIncCodeOutDTO>> rlt = new EcIncResultDTO<List<EcIncManagePaperIncCodeOutDTO>>();
		rlt.setFg_success(new FBoolean(rtnParam.getFgSuccess()));
		
		if(FBoolean.TRUE.equals(rlt.getFg_success())){
			EcManagePaperActOutParam outData = JSON.parseObject(rtnParam.getData(), EcManagePaperActOutParam.class);;
			
			List<EcIncManagePaperIncCodeOutDTO> dataList = new ArrayList<EcIncManagePaperIncCodeOutDTO>();
			for (EcManageIncTypeParam incTypeParam : outData.getBillCodeList()) {
				for (EcManageIncCodeParam incCodeParam : incTypeParam.getBillBatchCodeList()) {
					
					EcIncManagePaperIncCodeOutDTO outDto = new EcIncManagePaperIncCodeOutDTO();
					outDto.setEcinc_type(incTypeParam.getBillCode());
					outDto.setEcinc_code(incCodeParam.getBillBatchCode());
					dataList.add(outDto);
				}
			}
			
			rlt.setData(dataList);
		}else{
			rlt.setErrormsg(rtnParam.getErrorMsg());
		}
			
		rlt.setInparam(rtnParam.getInputStr());
		rlt.setOutparam(rtnParam.getOutputStr());
		
		return rlt;
	}
}
