package iih.pi.reg.s.customer.guoji.util;

import java.util.List;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.res.params.BdResParams;
import iih.pi.reg.dto.patap.d.PiPatChisInfoDTO;
import iih.pi.reg.i.IPiPatConst;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatHpDO;
import iih.pi.reg.s.customer.guoji.PiPatCreateByChisMedInsBP;
import iih.pi.reg.s.customer.guoji.PiPatCreateByChisSelfPayBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * chis建档工具类
 * 
 * @author ly 2017/08/23
 *
 */
public class PiPatCreateByChisUtil {

	/**
	 * chis建档 </br>
	 * 自费和医保调用不同的存储过程
	 * 
	 * @param patAgg
	 * @throws BizException
	 */
	public static void createPat(PatiAggDO patAgg) throws BizException {

		/*
		 * IHpMDORService hpRservice = ServiceFinder.find(IHpMDORService.class);
		 * String whereSql = "fg_default = 'Y' "; HPDO[] hpDos =
		 * hpRservice.find(whereSql, "", FBoolean.FALSE);
		 * 
		 * String bjHp = null; if(!ArrayUtil.isEmpty(hpDos)){ bjHp =
		 * hpDos[0].getId_hp(); }else{ bjHp = IPiPatConst.BJ_ID_HP; }
		 */

		boolean medInsCreate = false;
		PiPatHpDO[] patHpDos = patAgg.getPiPatHpDO();
		if (!ArrayUtil.isEmpty(patHpDos)) {
			for (PiPatHpDO patHpDo : patHpDos) {
				if (DOStatus.DELETED != patHpDo.getStatus() && IPiPatConst.BJ_ID_HP.equals(patHpDo.getId_hp())) {
					medInsCreate = true;
					patHpDo.setFg_chisuse(FBoolean.TRUE);
					break;
				}
			}
		}

		if (medInsCreate) {
			new PiPatCreateByChisMedInsBP().exec(patAgg);
		} else {
			new PiPatCreateByChisSelfPayBP().exec(patAgg);
		}
	}

	/**
	 * 判断chis中存在患者
	 * 
	 * @param code
	 * @return
	 * @throws BizException
	 */
	public static boolean existsPatInChis(String code) throws BizException {

		String dataSource = new BdResParams().CHISDB();
		if (StringUtil.isEmpty(dataSource)) {
			throw new BizException("未定义chis数据源");
		}

		String sql = "select count(1) from view_mz_patient_mi_iih where patient_id = ? ";
		SqlParam param = new SqlParam();
		param.addParam(code);

		DAFacade daf = new DAFacade(dataSource);
		Integer count = (Integer) daf.execQuery(sql, param, new ColumnHandler());

		if (count != null && count == 1)
			return true;

		return false;
	}

	/**
	 * 判断患者在chis是否存在，如果查询到，则同步患者编码
	 * 
	 * @param pat
	 * @return
	 * @throws BizException
	 */
	public static boolean existsPatInChis(PatDO pat) throws BizException {

		String dataSource = new BdResParams().CHISDB();
		if (StringUtil.isEmpty(dataSource)) {
			throw new BizException("未定义chis数据源");
		}

		StringBuilder sqlSb = new StringBuilder();
		SqlParam param = new SqlParam();

		sqlSb.append("select * ");
		sqlSb.append("from  view_mz_patient_mi_iih ");
		sqlSb.append("where patient_id = ? ");

		param.addParam(pat.getCode());
		if (IPiDictCodeConst.SD_CARD_TYPE_IDENTITY.equals(pat.getSd_idtp())) {
			sqlSb.append(" or (social_no = ? and (black_flag = '01' or black_flag = '1')) ");
			param.addParam(pat.getId_code());
		}

		sqlSb.append(" order by max_times desc,lv_data desc ");

		@SuppressWarnings("unchecked")
		List<PiPatChisInfoDTO> result = (List<PiPatChisInfoDTO>) new DAFacade(dataSource).execQuery(sqlSb.toString(),
				param, new BeanListHandler(PiPatChisInfoDTO.class));

		if (!ListUtil.isEmpty(result)) {
			PiPatChisInfoDTO chisInfo = result.get(0);
			pat.setCode(chisInfo.getPatient_id());
			pat.setMnecode(pat.getCode());
			pat.setBarcode_chis(chisInfo.getP_bar_code());
			return true;
		}

		return false;
	}
}