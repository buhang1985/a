package iih.mi.itf2.service.bp.bdservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.mi.itf2.dto.drugmanualcomp.d.DrugManualCompDTO;
import iih.mi.itf2.dto.midirdownload.d.MiDirEnum;
import iih.mi.itf2.dto.setownexpense.d.SetOwnExpenseInParam;
import iih.mi.itf2.dto.setownexpense.d.SetOwnExpenseOutParam;
import iih.mi.itf2.dto.treatandfwsscomp.d.TreatAndFwssCompDTO;
import iih.mi.itf2.service.bp.bdservice.util.ToolUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.sys.jdbc.facade.DAFacade;

public class SetOwnExpenseBP {

	
	public SetOwnExpenseOutParam exec(SetOwnExpenseInParam inParam) throws BizException {
		if (MiDirEnum.MIDIRDRUG.equals(inParam.getDirtype())) {
			return setDrugOwnExpense(inParam);
		}else if (MiDirEnum.MIDIRSRV.equals(inParam.getDirtype())) {
			return setTreatOwnExpense(inParam);
		}else if (MiDirEnum.MIDIRFACILITY.equals(inParam.getDirtype())) {
			return setFwssOwnExpense(inParam);
		}else if (MiDirEnum.MIDIRMC.equals(inParam.getDirtype())) {
			return setMcOwnExpense(inParam);
		}
		return null;
	}
	
	/**
	 * 材料自费操作
	 * @author zhang.hw
	 * @date 2019年7月19日
	 * @param inParam
	 * @return
	 */
	private SetOwnExpenseOutParam setMcOwnExpense(SetOwnExpenseInParam inParam) throws BizException {
		TreatAndFwssCompDTO[] treatCompDTO = ToolUtils.ToList(inParam.getDetail()).toArray(new TreatAndFwssCompDTO[inParam.getDetail().size()]);
		SetOwnExpenseOutParam outParam = new SetOwnExpenseOutParam();
		if (treatCompDTO == null || treatCompDTO.length <= 0) {
			return outParam;
		}
		String[] ids = getTreatNeedSetData(inParam.getEu_status(),treatCompDTO);
		setOwnExpense(ids,inParam.getEu_status(),treatCompDTO[0].getId_hp());
		
		FArrayList fArrayList = new FArrayList(treatCompDTO.length);
		Collections.addAll(fArrayList, treatCompDTO);
		outParam.setDetail(fArrayList);
		return outParam;
	}

	/**
	 * 服务设施自费操作
	 * @author zhang.hw
	 * @date 2019年7月19日
	 * @param inParam
	 * @return
	 */
	private SetOwnExpenseOutParam setFwssOwnExpense(SetOwnExpenseInParam inParam) throws BizException {
		TreatAndFwssCompDTO[] treatCompDTO = ToolUtils.ToList(inParam.getDetail()).toArray(new TreatAndFwssCompDTO[inParam.getDetail().size()]);
		SetOwnExpenseOutParam outParam = new SetOwnExpenseOutParam();
		if (treatCompDTO == null || treatCompDTO.length <= 0) {
			return outParam;
		}
		String[] ids = getTreatNeedSetData(inParam.getEu_status(),treatCompDTO);
		setOwnExpense(ids,inParam.getEu_status(),treatCompDTO[0].getId_hp());
		
		FArrayList fArrayList = new FArrayList(treatCompDTO.length);
		Collections.addAll(fArrayList, treatCompDTO);
		outParam.setDetail(fArrayList);
		return outParam;
	}

	/**
	 * 诊疗自费操作
	 * @author zhang.hw
	 * @date 2019年7月19日
	 * @param inParam
	 * @return
	 */
	private SetOwnExpenseOutParam setTreatOwnExpense(SetOwnExpenseInParam inParam) throws BizException {
		TreatAndFwssCompDTO[] treatCompDTO = ToolUtils.ToList(inParam.getDetail()).toArray(new TreatAndFwssCompDTO[inParam.getDetail().size()]);
		SetOwnExpenseOutParam outParam = new SetOwnExpenseOutParam();
		if (treatCompDTO == null || treatCompDTO.length <= 0) {
			return outParam;
		}
		String[] ids = getTreatNeedSetData(inParam.getEu_status(),treatCompDTO);
		setOwnExpense(ids,inParam.getEu_status(),treatCompDTO[0].getId_hp());
		
		FArrayList fArrayList = new FArrayList(treatCompDTO.length);
		Collections.addAll(fArrayList, treatCompDTO);
		outParam.setDetail(fArrayList);
		return outParam;
	}


	/**
	 * 诊疗获取数据
	 * @author zhang.hw
	 * @date 2019年7月19日
	 * @param eu_status
	 * @param treatCompDTO
	 * @return
	 */
	private String[] getTreatNeedSetData(String eu_status, TreatAndFwssCompDTO[] treatCompDTO) {
		List<String> ids = new ArrayList<String>();
		for (TreatAndFwssCompDTO treatAndFwssCompDTO : treatCompDTO) {
			treatAndFwssCompDTO.setEu_status(eu_status);
			ids.add(treatAndFwssCompDTO.getId_hpsrvorca());
		}
		return ids.toArray(new String[0]);
	}

	/**
	 * 药品自费操作
	 * @author zhang.hw
	 * @date 2019年7月19日
	 * @param inParam
	 * @return
	 * @throws BizException
	 */
	private SetOwnExpenseOutParam setDrugOwnExpense(SetOwnExpenseInParam inParam) throws BizException{
		DrugManualCompDTO[] drugManualCompdtos = ToolUtils.ToList(inParam.getDetail()).toArray(new DrugManualCompDTO[inParam.getDetail().size()]);
		if (drugManualCompdtos == null || drugManualCompdtos.length <= 0) {
			throw new BizException("没有设为自费的数据");
		}
		String[] ids = getNeedSetData(inParam.getEu_status(),drugManualCompdtos);
		setOwnExpense(ids,inParam.getEu_status(),drugManualCompdtos[0].getId_hp());
		SetOwnExpenseOutParam outParam = new SetOwnExpenseOutParam();
		FArrayList fArrayList = new FArrayList(drugManualCompdtos.length);
		Collections.addAll(fArrayList, drugManualCompdtos);
		outParam.setDetail(fArrayList);
		return outParam;
	}
	
	/**
	 * 药品获取数据
	 * 
	 * @param drugCompDTOs
	 * @return
	 */
	private String[] getNeedSetData(String eu_status,DrugManualCompDTO[] drugManualCompdtos) {
		List<String> ids = new ArrayList<String>();
		for (DrugManualCompDTO drugComp : drugManualCompdtos) {
			drugComp.setEu_status(eu_status);
			ids.add(drugComp.getId_hpsrvorca());
		}
		return ids.toArray(new String[0]);
	}
	
	/**
	 * 修改对照状态
	 * @author zhang.hw
	 * @date 2019年7月19日
	 * @param ids
	 * @param eu_status
	 * @throws BizException
	 */
	private void setOwnExpense(String[] ids,String eu_status,String id_hp) throws BizException {
		String needSetCodes = SqlUtils.getInSqlByBigIds(HPSrvorcaDO.ID_HPSRVORCA, ids);
		String sql = "update bd_hp_srvorca set eu_status = '" + eu_status + "' where " + needSetCodes+" and id_hp='"+id_hp+"'";
		DAFacade df = new DAFacade();
		df.execUpdate(sql);
	}
	
}
