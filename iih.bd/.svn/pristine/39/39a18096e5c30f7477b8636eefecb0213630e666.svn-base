package iih.bd.pp.hpdivshisdto.s.bp;

import iih.bd.pp.hpdivshisdto.d.HpDiVsHisDTO;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 保存医保病种目录对照数据业务逻辑
 * 
 * @author hao_wu
 *
 */
public class SaveHpDiVsHisDataBp {

	private DAFacade _daFacade = new DAFacade();

	public HpDiVsHisDTO[] exec(HpDiVsHisDTO[] hpDiVsHisDtos) throws BizException {

		for (HpDiVsHisDTO hpDiVsHisDTO : hpDiVsHisDtos) {
			SaveHpDiVsHis(hpDiVsHisDTO);
			hpDiVsHisDTO.setEu_status(HpStatusEnum.REVIEW);
			hpDiVsHisDTO.setStatus(DOStatus.UNCHANGED);
		}
		return hpDiVsHisDtos;
	}

	/**
	 * 保存医保病种目录对照数据
	 * 
	 * @param hpDiVsHisDTO
	 * @throws BizException
	 */
	private void SaveHpDiVsHis(HpDiVsHisDTO hpDiVsHisDTO) throws BizException {
		if (hpDiVsHisDTO.getStatus() == DOStatus.UNCHANGED) {
			return;
		}
		SqlParam sqlParam = BuildSqlParam(hpDiVsHisDTO);
		String updateSql = "UPDATE BD_HP_DI_VS_HIS SET ID_HP = ?, CODE = ?, NAME = ?, EU_STATUS = ? WHERE ID_HPDIVSHIS = ?";
		this._daFacade.execUpdate(updateSql, sqlParam);
	}

	/**
	 * 构建sql参数
	 * 
	 * @param hpDiVsHisDTO
	 * @return
	 */
	private SqlParam BuildSqlParam(HpDiVsHisDTO hpDiVsHisDTO) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(hpDiVsHisDTO.getId_hp());
		sqlParam.addParam(hpDiVsHisDTO.getHpdidict_code());
		sqlParam.addParam(hpDiVsHisDTO.getHpdidict_name());
		sqlParam.addParam(HpStatusEnum.REVIEW);
		sqlParam.addParam(hpDiVsHisDTO.getId_hpdivshis());
		return sqlParam;
	}
}
