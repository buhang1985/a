package iih.bd.pp.anhuisrvorca.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.anhuisrvorca.d.TreatCompDTO;
import iih.bd.pp.anhuisrvorca.s.bp.sql.SaveInsurZlCompSql;
import iih.bd.pp.hpsrvorca.d.HpSrvTpEnum;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 保存诊疗目录对照业务逻辑
 * 
 * @author hao_wu
 *
 */
public class SaveTreatCompBp {
	public TreatCompDTO[] exec(TreatCompDTO[] treatCompDTOs) throws BizException {
		if (treatCompDTOs == null || treatCompDTOs.length <= 0) {
			throw new BizException("没有需要保存的诊疗对照。");
		}

		TreatCompDTO[] result = SaveZlComp(treatCompDTOs);
		if (result != null && result.length > 0) {
			AutoGenerateSrvctr(result[0].getId_hp());
			String[] pks = GetPks(result);
			SyncInsurZlData(result[0].getId_hp(), pks);
		}
		return result;
	}

	/**
	 * 获取主键集合
	 * 
	 * @param result
	 * @return
	 */
	private String[] GetPks(TreatCompDTO[] result) {
		ArrayList<String> pkList = new ArrayList<String>();
		for (TreatCompDTO treatCompDTO : result) {
			if (treatCompDTO != null && !StringUtils.isEmpty(treatCompDTO.getId_hpsrvorca())) {
				pkList.add(treatCompDTO.getId_hpsrvorca());
			}
		}
		return pkList.toArray(new String[0]);
	}

	/**
	 * 同步医保诊疗信息
	 * 
	 * @throws BizException
	 */
	private void SyncInsurZlData(String hpId, String[] pks) throws BizException {
		SyncInsurZlDataBp bp = new SyncInsurZlDataBp();
		bp.exec(hpId, pks);
	}

	/**
	 * 自动生成医保计划控制策略
	 * 
	 * @throws BizException
	 */
	private void AutoGenerateSrvctr(String hpId) throws BizException {
		AutoGenerateSrvctrBp bp = new AutoGenerateSrvctrBp();
		bp.exec(hpId, HpSrvTpEnum.ZL);
	}

	private TreatCompDTO[] SaveZlComp(TreatCompDTO[] treatCompDTOs) throws BizException {
		SaveSrvOrCa(treatCompDTOs);
		return treatCompDTOs;
	}

	/**
	 * 保存医保目录对照
	 * 
	 * @param drugCompDTOs
	 * @throws BizException
	 */
	private void SaveSrvOrCa(TreatCompDTO[] treatCompDTOs) throws BizException {
		for (TreatCompDTO treatCompDTO : treatCompDTOs) {
			SaveSrvOrCa(treatCompDTO);
			treatCompDTO.setEu_status(HpStatusEnum.CONTRAST);
			treatCompDTO.setStatus(DOStatus.UNCHANGED);
		}
	}

	/**
	 * 保存医保目录对照
	 * 
	 * @param drugCompDTO
	 * @throws BizException
	 */
	private void SaveSrvOrCa(TreatCompDTO treatCompDTO) throws BizException {
		SaveInsurZlCompSql sql = new SaveInsurZlCompSql(treatCompDTO);
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate(sql.getQrySQLStr(), sql.getQryParameter(null));
		SaveSrvCtr(treatCompDTO);
	}

	/**
	 * 保存医保计划控制策略
	 * 
	 * @param drugCompDTO
	 */
	private void SaveSrvCtr(TreatCompDTO treatCompDTO) {
		// TODO Auto-generated method stub

	}
}