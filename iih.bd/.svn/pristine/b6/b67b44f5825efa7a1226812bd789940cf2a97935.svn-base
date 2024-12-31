package iih.bd.pp.anhuisrvorca.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.anhuisrvorca.d.DrugCompDTO;
import iih.bd.pp.anhuisrvorca.s.bp.sql.SaveInsurDrugCompSql;
import iih.bd.pp.hpsrvorca.d.HpSrvTpEnum;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 保存药品目录对照业务逻辑
 * 
 * @author hao_wu
 *
 */
public class SaveDrugCompBp {
	public DrugCompDTO[] exec(DrugCompDTO[] drugCompDTOs) throws BizException {
		if (drugCompDTOs == null || drugCompDTOs.length <= 0) {
			throw new BizException("没有需要保存的品对照。");
		}

		DrugCompDTO[] result = SaveDrugComp(drugCompDTOs);
		if (result != null && result.length > 0) {
			AutoGenerateSrvctr(result[0].getId_hp());
			String[] pks = GetPks(result);
			SyncInsurDrugData(result[0].getId_hp(), pks);
		}
		return result;
	}

	/**
	 * 获取主键集合
	 * 
	 * @param result
	 * @return
	 */
	private String[] GetPks(DrugCompDTO[] result) {
		ArrayList<String> pkList = new ArrayList<String>();
		for (DrugCompDTO drugCompDTO : result) {
			if (drugCompDTO != null && !StringUtils.isEmpty(drugCompDTO.getId_hpsrvorca())) {
				pkList.add(drugCompDTO.getId_hpsrvorca());
			}
		}
		return pkList.toArray(new String[0]);
	}

	/**
	 * 同步医保药品信息
	 * 
	 * @throws BizException
	 */
	private void SyncInsurDrugData(String hpId, String[] pks) throws BizException {
		SyncInsurDrugDataBp bp = new SyncInsurDrugDataBp();
		bp.exec(hpId, pks);
	}

	/**
	 * 自动生成医保计划控制策略
	 * 
	 * @throws BizException
	 */
	private void AutoGenerateSrvctr(String hpId) throws BizException {
		AutoGenerateSrvctrBp bp = new AutoGenerateSrvctrBp();
		bp.exec(hpId, HpSrvTpEnum.DRUG);
	}

	/**
	 * 保存药品对照信息
	 * 
	 * @param drugCompDTOs
	 * @return
	 * @throws BizException
	 */
	private DrugCompDTO[] SaveDrugComp(DrugCompDTO[] drugCompDTOs) throws BizException {
		SaveSrvOrCa(drugCompDTOs);
		return drugCompDTOs;
	}

	/**
	 * 保存医保目录对照
	 * 
	 * @param drugCompDTOs
	 * @throws BizException
	 */
	private void SaveSrvOrCa(DrugCompDTO[] drugCompDTOs) throws BizException {
		for (DrugCompDTO drugCompDTO : drugCompDTOs) {
			SaveSrvOrCa(drugCompDTO);
			drugCompDTO.setEu_status(HpStatusEnum.CONTRAST);
			drugCompDTO.setStatus(DOStatus.UNCHANGED);
		}
	}

	/**
	 * 保存医保目录对照
	 * 
	 * @param drugCompDTO
	 * @throws BizException
	 */
	private void SaveSrvOrCa(DrugCompDTO drugCompDTO) throws BizException {
		SaveInsurDrugCompSql sql = new SaveInsurDrugCompSql(drugCompDTO);
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate(sql.getQrySQLStr(), sql.getQryParameter(null));
		SaveSrvCtr(drugCompDTO);
	}

	/**
	 * 保存医保计划控制策略
	 * 
	 * @param drugCompDTO
	 */
	private void SaveSrvCtr(DrugCompDTO drugCompDTO) {
		// TODO Auto-generated method stub

	}
}
