package iih.bd.pp.anhuisrvorca.s.bp;

import java.util.ArrayList;

import iih.bd.pp.anhuisrvorca.d.TreatCompDTO;
import iih.bd.pp.anhuisrvorca.s.bp.sql.FindTreatAndFwssCompSql;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hpsrvorca.d.HpSrvTpEnum;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 查询可以同步审核信息 的诊疗和服务设施对照信息
 * 
 * @author hao_wu
 *
 */
public class FindCanSyncApprovalCompBp {

	@SuppressWarnings("unchecked")
	public TreatCompDTO[] exec(String hpCode) throws BizException {
		String hpId = GetHpId(hpCode);

		String wherePart = String.format("EU_STATUS IN ('%s','%s','%s','%s')", HpStatusEnum.CONTRAST,
				HpStatusEnum.UPLOAD, HpStatusEnum.REVIEW, HpStatusEnum.REJECT);
		FindTreatAndFwssCompSql sql = new FindTreatAndFwssCompSql(hpId, wherePart);

		DAFacade daFacade = new DAFacade();
		TreatCompDTO[] result = ((ArrayList<TreatCompDTO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(TreatCompDTO.class))).toArray(new TreatCompDTO[0]);

		ModifyFwssCode(result);

		return result;
	}

	/**
	 * 修改Fwss编码_因有-F后缀，必须删除
	 * 
	 * @param result
	 */
	private void ModifyFwssCode(TreatCompDTO[] result) {
		for (TreatCompDTO treatCompDTO : result) {
			if (HpSrvTpEnum.FWSS.toString().equals(treatCompDTO.getEu_hpsrvtp())
					&& treatCompDTO.getCode().endsWith("-F")) {
				String code = treatCompDTO.getCode();
				treatCompDTO.setCode(code.substring(0, code.length() - 2));
			}
		}

	}

	/**
	 * 获取医保计划主键
	 * 
	 * @param hpCode
	 * @return
	 * @throws BizException
	 */
	private String GetHpId(String hpCode) throws BizException {
		FindHpDoByCodeBp bp = new FindHpDoByCodeBp();
		HPDO hpdo = bp.exec(hpCode);
		return hpdo.getId_hp();
	}
}
