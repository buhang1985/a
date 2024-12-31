package iih.bd.pp.anhuisrvorca.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.anhuisrvorca.d.FwssCompDTO;
import iih.bd.pp.anhuisrvorca.s.bp.sql.SaveInsurFwssCompSql;
import iih.bd.pp.hpsrvorca.d.HpSrvTpEnum;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 保存服务设施对照业务逻辑
 * 
 * @author hao_wu
 *
 */
public class SaveFwssCompBp {

	public FwssCompDTO[] exec(FwssCompDTO[] fwssCompDTOs) throws BizException {
		if (fwssCompDTOs == null || fwssCompDTOs.length <= 0) {
			throw new BizException("没有需要保存的服务设施对照。");
		}

		FwssCompDTO[] result = SaveFwssComp(fwssCompDTOs);
		if (result != null && result.length > 0) {
			AutoGenerateSrvctr(result[0].getId_hp());
			String[] pks = GetPks(result);
			SyncInsurFwssData(result[0].getId_hp(), pks);
		}
		return result;
	}

	/**
	 * 获取主键集合
	 * 
	 * @param result
	 * @return
	 */
	private String[] GetPks(FwssCompDTO[] result) {
		ArrayList<String> pkList = new ArrayList<String>();
		for (FwssCompDTO fwssCompDTO : result) {
			if (fwssCompDTO != null && !StringUtils.isEmpty(fwssCompDTO.getId_hpsrvorca())) {
				pkList.add(fwssCompDTO.getId_hpsrvorca());
			}
		}
		return pkList.toArray(new String[0]);
	}

	/**
	 * 同步医保服务设施数据
	 * 
	 * @throws BizException
	 */
	private void SyncInsurFwssData(String hpId, String[] pks) throws BizException {
		SyncInsurFwssDataBp bp = new SyncInsurFwssDataBp();
		bp.exec(hpId, pks);
	}

	/**
	 * 自动生成医保计划控制策略
	 * 
	 * @throws BizException
	 */
	private void AutoGenerateSrvctr(String hpId) throws BizException {
		AutoGenerateSrvctrBp bp = new AutoGenerateSrvctrBp();
		bp.exec(hpId, HpSrvTpEnum.FWSS);
	}

	private FwssCompDTO[] SaveFwssComp(FwssCompDTO[] fwssCompDTOs) throws BizException {
		SaveSrvOrCa(fwssCompDTOs);
		return fwssCompDTOs;
	}

	/**
	 * 保存医保目录对照
	 * 
	 * @param drugCompDTOs
	 * @throws BizException
	 */
	private void SaveSrvOrCa(FwssCompDTO[] fwssCompDTOs) throws BizException {
		for (FwssCompDTO fwssCompDTO : fwssCompDTOs) {
			SaveSrvOrCa(fwssCompDTO);
			fwssCompDTO.setEu_status(HpStatusEnum.CONTRAST);
			fwssCompDTO.setStatus(DOStatus.UNCHANGED);
		}
	}

	/**
	 * 保存医保目录对照
	 * 
	 * @param drugCompDTO
	 * @throws BizException
	 */
	private void SaveSrvOrCa(FwssCompDTO fwssCompDTO) throws BizException {
		SaveInsurFwssCompSql sql = new SaveInsurFwssCompSql(fwssCompDTO);
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate(sql.getQrySQLStr(), sql.getQryParameter(null));
		SaveSrvCtr(fwssCompDTO);
	}

	/**
	 * 保存医保计划控制策略
	 * 
	 * @param drugCompDTO
	 */
	private void SaveSrvCtr(FwssCompDTO fwssCompDTO) {
		// TODO Auto-generated method stub

	}
}
