package iih.ci.ord.s.ems.op.orderv1.bp.ope;

import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.pres.d.CiPresDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.itf.bp.IOrderOperateBP;

/**
 * 高端商保患者医嘱退费逻辑
 * @author Young
 *
 */
public class OrderDeleteHBIOperateBP implements IOrderOperateBP {

	@Override
	public OrderRstDTO exec(String[] idors, CiEnContextDTO ciEnContextDTO, FMap2 extension)
			throws BizException {
		// TODO Auto-generated method stub
		OrderRstDTO rstDTO = new OrderRstDTO();
		if (idors == null || idors.length <= 0
				|| ciEnContextDTO == null
				|| StringUtils.isNullOrEmpty(ciEnContextDTO.getId_emp_or())
				|| StringUtils.isNullOrEmpty(ciEnContextDTO.getId_org())
				|| StringUtils.isNullOrEmpty(ciEnContextDTO.getId_pat())
				|| StringUtils.isNullOrEmpty(ciEnContextDTO.getCode_entp())) {
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}
		
		String id_psndoc = ciEnContextDTO.getId_emp_or();
		String id_org = ciEnContextDTO.getId_org();
		String id_pat = ciEnContextDTO.getId_pat();
		String code_entp = ciEnContextDTO.getCode_entp();
		
		String strIdors = "";
		for (String idor : idors) {
			strIdors += ",'" + idor + "'";
		}
		strIdors = strIdors.substring(1);
		
		List<Map<String, Object>> lstOrsrvs = this.getId_orsrvs(strIdors);
		if (lstOrsrvs == null || lstOrsrvs.size() == 0) {
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}

		String strIdpres = "";
		BlOrderAppendBillParamDTO[] blParamDTOs = new BlOrderAppendBillParamDTO[lstOrsrvs.size()];
		for (int i = 0; i < lstOrsrvs.size(); i++) {
			Map<String, Object> map = lstOrsrvs.get(i);
			BlOrderAppendBillParamDTO blParamDTO = new BlOrderAppendBillParamDTO();
			blParamDTO.setId_org(id_org);
			blParamDTO.setId_pat(id_pat);
			blParamDTO.setId_or(map.get("Id_or").toString());
			blParamDTO.setId_orsrv(map.get("Id_orsrv").toString());
			blParamDTO.setId_emp_cg(id_psndoc);
			blParamDTOs[i] = blParamDTO;
			strIdpres += ",'" + map.get("Id_pres").toString() + "'";
		}

		CiOrdAppUtils.getIBLOrderAppendBillService().SetOrderRefundBill_ByIdor_cancelReserve(blParamDTOs, code_entp);
		
		if (strIdpres.length() > 0) {
			deletePres(strIdpres.substring(1));
		}
		rstDTO.setIsSuccess(FBoolean.TRUE);
		return rstDTO;
	}

	/**
	 * 删除处方
	 * @param idpres
	 * @throws BizException
	 */
	private void deletePres(String idpres) throws BizException {
		if (!StringUtils.isNullOrEmpty(idpres)) {
			String strwhere = CiPresDO.ID_PRES + "  in (" + idpres + ")";
			new DAFacade().deleteByWhere(CiPresDO.class, strwhere);
		}
	}

	/**
	 * 根据医嘱id查询可退费的医嘱项目
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	private List<Map<String, Object>> getId_orsrvs(String idors) throws BizException {
		// 当前医生 已签署、未作废、可退费的、已记账、未销账、未结算（由费用判断）  去掉未执行判断，因为第三方可取消执行，但应我们中的执行状态还是已执行
		String sqlStr = "select Id_or,Id_orsrv,Id_pres from ci_or_srv "
				+ "where fg_bl='Y' and sd_su_bl='" + ICiDictCodeConst.SD_SU_BL_ACCOUNT + "' and fg_feertnable='Y' "
				+ "and (eu_feereversetp is null or eu_feereversetp=0) and ds=0 and id_or in "
				+ "(select id_or from ci_order where fg_sign='Y' and fg_canc='N' and id_or in (" + idors + "))";
		return CiOrdUtils.getRsMapList(sqlStr);
	}
}
