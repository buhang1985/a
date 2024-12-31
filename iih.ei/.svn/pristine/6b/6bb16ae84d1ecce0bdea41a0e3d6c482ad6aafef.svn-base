package iih.ei.bl.ecinc.bosssoft.v2.s.bp;

import java.util.Map;

import com.alibaba.fastjson.JSON;

import iih.bl.inc.blecinccomp.d.BlEcIncCompDO;
import iih.ei.bl.ecinc.bosssoft.constant.IEcIncBossSoftConst;
import iih.ei.bl.ecinc.bosssoft.v2.s.data.ReturnParam;
import iih.ei.bl.ecinc.bosssoft.v2.s.data.paper.EcPaperSwitchParam;
import iih.ei.bl.ecinc.bosssoft.v2.s.http.BossSoftHttpClient;
import iih.ei.bl.ecinc.d.EcIncPaperSwitchInDTO;
import iih.ei.bl.ecinc.d.EcIncPaperSwitchOutDTO;
import iih.ei.bl.ecinc.d.EcIncResultDTO;
import iih.ei.bl.ecinc.util.EcIncCompUtil;
import iih.ei.bl.ecinc.util.EcIncDataUtil;
import iih.ei.bl.util.EIThirdLogger;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.bdfw.bbd.d.PsnDocDO;

/**
 * 博思换开纸质发票
 * @author ly 2019/12/04
 *
 */
public class BossSoftEcIncPaperSwitchBP {

	/**
	 * 换开纸质发票
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public EcIncResultDTO<EcIncPaperSwitchOutDTO> exec(EcIncPaperSwitchInDTO dto) throws BizException {
		
		EcPaperSwitchParam inParam = new EcPaperSwitchParam();
		inParam.setBillBatchCode(dto.getEcinc_code());
		inParam.setBillNo(dto.getEcincno());
		inParam.setpBillBatchCode(dto.getPinc_code());
		inParam.setpBillNo(dto.getPincno());
		inParam.setBusDateTime(EcIncDataUtil.getBusiTime());
		
		PsnDocDO psnDO = EcIncDataUtil.getPsnData(Context.get().getStuffId());
		Map<String, BlEcIncCompDO> psnCompMap = EcIncCompUtil.getCompData("07");
		BlEcIncCompDO psnCompDO = psnCompMap.get(psnDO.getCode());
		if(psnCompDO != null){
			inParam.setPlaceCode(psnCompDO.getEcinc_code());//开票点编码
		}else{
			inParam.setPlaceCode(psnDO.getCode());//开票点编码
		}
		inParam.setOperator(psnDO.getName());
		
		String data = JSON.toJSONString(inParam);
		ReturnParam rtnParam = null;
		
		try {
			BossSoftHttpClient httpClient = new BossSoftHttpClient(IEcIncBossSoftConst.METHOD_TURNPAPER, IEcIncBossSoftConst.METHOD_TURNPAPER_NAME);
			rtnParam = httpClient.invoke(data);
		} catch (Exception e) {
			e.printStackTrace();
			EIThirdLogger.error(String.format("%s失败:", IEcIncBossSoftConst.METHOD_TURNPAPER_NAME) + e.getMessage(), e);
			EcIncResultDTO<EcIncPaperSwitchOutDTO> rlt = new EcIncResultDTO<EcIncPaperSwitchOutDTO>();
			rlt.setFg_success(FBoolean.FALSE);
			rlt.setErrormsg(e.getMessage());
			rlt.setOutparam(e.getMessage());
			return rlt;
		}
		
		EcIncResultDTO<EcIncPaperSwitchOutDTO> rlt = new EcIncResultDTO<EcIncPaperSwitchOutDTO>();
		rlt.setFg_success(new FBoolean(rtnParam.getFgSuccess()));
		if(FBoolean.TRUE.equals(rlt.getFg_success())){
			EcIncPaperSwitchOutDTO outDto = new EcIncPaperSwitchOutDTO();
			outDto.setPinc_code(dto.getPinc_code());
			outDto.setPincno(dto.getPincno());
			rlt.setData(outDto);
		}else{
			rlt.setErrormsg(rtnParam.getErrorMsg());
		}
		rlt.setInparam(rtnParam.getInputStr());
		rlt.setOutparam(rtnParam.getOutputStr());
		return rlt;
	}
}
