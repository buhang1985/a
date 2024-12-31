package iih.ei.bl.ecinc.bosssoft.v2.s.bp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import iih.bl.inc.blecinccomp.d.BlEcIncCompDO;
import iih.bl.inc.dto.blelecbillcheckdto.d.CheckTotalDataDTO;
import iih.ei.bl.ecinc.bosssoft.constant.IEcIncBossSoftConst;
import iih.ei.bl.ecinc.bosssoft.v2.s.data.ReturnParam;
import iih.ei.bl.ecinc.bosssoft.v2.s.http.BossSoftHttpClient;
import iih.ei.bl.ecinc.d.EcIncBillInfoInputDTO;
import iih.ei.bl.ecinc.d.EcIncBillInfoOutputDTO;
import iih.ei.bl.ecinc.d.EcIncBillListDTO;
import iih.ei.bl.ecinc.d.EcIncResultDTO;
import iih.ei.bl.ecinc.util.EcIncCompUtil;
import iih.ei.bl.util.EIThirdLogger;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 根据业务时间获取开票信息接口BP
 * @author jiangdk
 *
 */
public class BossSoftQryBillInfoListBP {
	
	private final String DATATYPE_NORMALINC = "1";// 正常电子
	private final String DATATYPE_REFUNDINC = "2";//电子红票
	private final String DATATYPE_PAPER = "3";//换开纸质
	private final String DATATYPE_REFUNDPAPER = "4";//换开纸质红票
	private final String DATATYPE_PAPERNULL = "5";//空白纸质

	private final Integer PAPER_SIZE = 200;
	private Integer pageNo = 1;
	
	
	public EcIncResultDTO<List<EcIncBillListDTO>> exec(CheckTotalDataDTO dto) throws BizException {
		List<EcIncBillListDTO> list = new ArrayList<EcIncBillListDTO>();
		List<EcIncBillListDTO> paperList = new ArrayList<EcIncBillListDTO>();
		EcIncBillInfoInputDTO inParam = getInputParam(dto);
		if (dto.getEudirect() == 1) {
			//收费
			EcIncResultDTO<List<EcIncBillListDTO>> paperBills = getIncBills(inParam, DATATYPE_PAPER, paperList);
			EcIncResultDTO<List<EcIncBillListDTO>> incBills = getIncBills(inParam, DATATYPE_NORMALINC, list);
			return proccess(incBills, paperBills);
		}else if (dto.getEudirect() == -1) {
			//退费
			EcIncResultDTO<List<EcIncBillListDTO>> incBills = getIncBills(inParam, DATATYPE_REFUNDINC, list);
			EcIncResultDTO<List<EcIncBillListDTO>> paperBills = getIncBills(inParam, DATATYPE_REFUNDPAPER, paperList);
			return proccess(incBills, paperBills);
		}else {
			//全部
			return getIncBills(inParam, null, list);
		}
	}
	
	/**
	 * 结果处理
	 * @param incBills
	 * @param paperBills
	 * @return
	 */
	private EcIncResultDTO<List<EcIncBillListDTO>> proccess(EcIncResultDTO<List<EcIncBillListDTO>> incBills,
			EcIncResultDTO<List<EcIncBillListDTO>> paperBills) {
		List<EcIncBillListDTO> incData = incBills.getData();
		List<EcIncBillListDTO> paperData = paperBills.getData();
		incData.addAll(paperData);
		incBills.setData(incData);
		return incBills;
	}

	/**
	 * 获取电子发票明细数据
	 * @param inParam
	 * @param dataType
	 * @return
	 */
	private EcIncResultDTO<List<EcIncBillListDTO>> getIncBills(EcIncBillInfoInputDTO inParam, String dataType, List<EcIncBillListDTO> list){
		inParam.setDataType(dataType);	//数据类型
		EcIncResultDTO<List<EcIncBillListDTO>> rlt = new EcIncResultDTO<List<EcIncBillListDTO>>();
		
		ReturnParam rtnParam = null;
		try {
			BossSoftHttpClient httpClient = new BossSoftHttpClient(IEcIncBossSoftConst.METHOD_GETBILLBYBUSDATECODE,
					IEcIncBossSoftConst.METHOD_GETBILLBYBUSDATENAME);
			String data = JSON.toJSONString(inParam);
			rtnParam = httpClient.invoke(data);
		} catch (Exception e) {
			e.printStackTrace();
			EcIncBillInfoOutputDTO ut = new EcIncBillInfoOutputDTO();
			EIThirdLogger.error(String.format("%s失败", IEcIncBossSoftConst.METHOD_GETVALIDBILLBATCHCODE_NAME) + e.getMessage(), e);
			
			rlt.setFg_success(FBoolean.FALSE);
			rlt.setErrormsg(e.getMessage());
			rlt.setOutparam(e.getMessage());
			return rlt;
		}
		rlt.setFg_success(new FBoolean(rtnParam.getFgSuccess()));
		//如果成功
		if (FBoolean.TRUE.equals(rlt.getFg_success())) {
			
			EcIncBillInfoOutputDTO outData = JSON.parseObject(rtnParam.getData(), EcIncBillInfoOutputDTO.class);
			if (null == outData) {
				return rlt;
			}
			list.addAll(outData.getBillList());
			if (Integer.compare(outData.getTotal(), PAPER_SIZE) == 0) {
				//继续调用当前方法，pageNo+1
				pageNo += 1;
				inParam.setPageNo(pageNo);
				getIncBills(inParam, dataType, list);
			}else {
				rlt.setData(list);
				return rlt;
			}
		}else {
			rlt.setErrormsg(rtnParam.getErrorMsg());
			return rlt;
		}
		return null;
	}
	
	
	/**
	 * 获取入参
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	private EcIncBillInfoInputDTO getInputParam(CheckTotalDataDTO dto) throws BizException{
		//PsnDocDO psnDO = EcIncDataUtil.getPsnData(Context.get().getStuffId());
		Map<String, BlEcIncCompDO> psnCompMap = EcIncCompUtil.getCompData("07");
		BlEcIncCompDO psnCompDO = psnCompMap.get(dto.getPlacecode());
		//组装入参
		EcIncBillInfoInputDTO inParam = new EcIncBillInfoInputDTO();
		inParam.setBusBgnDate(dto.getBgbusdate());
		inParam.setBusEndDate(dto.getEndbusdate());
		if(psnCompDO != null){
			inParam.setPlaceCode(psnCompDO.getEcinc_code());//开票点编码
		}else{
			inParam.setPlaceCode(dto.getPlacecode());//开票点编码
		}
		inParam.setBusBgnDate(dto.getBgbusdate());
		inParam.setBusEndDate(dto.getEndbusdate());
		//dataType 数据类型 在各自方法赋值
		inParam.setPageNo(pageNo);
		inParam.setPageSize(PAPER_SIZE);
		return inParam;
	}
}
