package iih.pi.reg.pat.s.rule;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 检查患者数据业务逻辑
 * 
 * @author hao_wu 2018-6-6
 *
 */
public class CheckPatAggDataBp {

	public void exec(PatiAggDO[] patAggs) throws BizException {
		for (int i = 0; i < patAggs.length; i++) {
			PatiAggDO patiAggDo = patAggs[i];
			checkData(patiAggDo);
		}
	}

	private void checkData(PatiAggDO patiAggDo) throws BizException {
		// 检查证件号是否已注册
		checkIdCodeIsRegistered(patiAggDo.getParentDO());

//		// 检查医保号是否已注册
//		checkHpCodeIsRegistered(patiAggDo);

		// 检查是否存在相同患者(患者姓名,移动电话,出生日期相同认为是一个人)
		checkPatRepeat(patiAggDo.getParentDO());

		// 验证条码号
		checkChisBarCodeRepeat(patiAggDo.getParentDO());
	}

	/**
	 * 检查CHIS条码是否重复
	 * 
	 * @param patDo
	 * @throws BizException
	 */
	private void checkChisBarCodeRepeat(PatDO patDo) throws BizException {
		if ("provide by chis".equals(patDo.getBarcode_chis())) {
			return;
		}

		String wherePart = String.format("barcode_chis = '%s'", patDo.getBarcode_chis());
		if (StringUtils.isNotEmpty(patDo.getId_pat())) {
			wherePart = String.format("%s and id_pat <> '%s'", wherePart, patDo.getId_pat());
		}

		PatDO[] pats = this.findPatDosByWherePart(wherePart);
		if (pats != null && pats.length > 0) {
			String msg = String.format("患者【%s】的CHIS条码号与该患者重复。", pats[0].getCode());
			throw new BizException(msg);
		}
	}

	/**
	 * 检查患者是否重复
	 * 
	 * @param patDo
	 * @throws BizException
	 */
	private void checkPatRepeat(PatDO patDo) throws BizException {
		if (patDo == null || patDo.getDt_birth() == null || StringUtil.isEmpty(patDo.getMob())
				|| StringUtils.isEmpty(patDo.getName())) {
			return;
		}

		StringBuilder wherePartBuilder = new StringBuilder();
		String wherePart = String.format("name = '%s' and mob = '%s' and dt_birth = '%s' and fg_invd = 'N' and fg_active = 'Y'", patDo.getName(),
				patDo.getMob(), patDo.getDt_birth().toString());
		wherePartBuilder.append(wherePart);

		// 排除当前更新的数据
		if (StringUtils.isNotEmpty(patDo.getId_pat())) {
			wherePart = String.format(" and id_pat <> '%s'", patDo.getId_pat());
			wherePartBuilder.append(wherePart);
		}

		PatDO[] pados = this.findPatDosByWherePart(wherePartBuilder.toString());

		if (pados == null || pados.length <= 0) {
			return;
		}

		String msg = String.format("患者【%s】的(患者姓名,移动电话,出生日期)都与该患者重复,请确认患者信息。", pados[0].getCode());
		throw new BizException(msg);
	}

//	/**
//	 * 检查医保号是否被注册
//	 * 
//	 * @param patiAggDo
//	 * @throws BizException
//	 */
//	private void checkHpCodeIsRegistered(PatiAggDO patiAggDo) throws BizException {
//		PiPatHpDO[] pathpdos = patiAggDo.getPiPatHpDO();
//		if (pathpdos == null || pathpdos.length <= 0) {
//			return;
//		}
//
//		IPiPatHpDORService piPatHpDORService = ServiceFinder.find(IPiPatHpDORService.class);
//		PatDO patDO = patiAggDo.getParentDO();
//		for (PiPatHpDO hpDo : pathpdos) {
//			if (hpDo.getStatus() == DOStatus.UNCHANGED || hpDo.getStatus() == DOStatus.DELETED
//					|| StringUtil.isEmpty(hpDo.getNo_hp()) || StringUtils.isEmpty(hpDo.getId_hp())) {
//				continue;
//			}
//
//			String wherePart = String.format("no_hp = '%s' and id_hp = '%s'", hpDo.getNo_hp(), hpDo.getId_hp());
//			if (StringUtils.isNotEmpty(patDO.getId_pat())) {
//				wherePart = String.format("%s and id_pat <> '%s'", wherePart, patDO.getId_pat());
//			}
//			PiPatHpDO[] hpdos = piPatHpDORService.find(wherePart, "", FBoolean.FALSE);
//			if (hpdos == null || hpdos.length <= 0) {
//				continue;
//			}
//
//			String[] patIds = getPatIds(hpdos);
//			PatDO[] pats = findPatsByIds(patIds);
//			if (pats != null && pats.length >= 1) {
//				String msg = String.format("该医保号[%s]已经被注册,使用该医保号患者编码:%s。", hpDo.getNo_hp(), pats[0].getCode());
//				throw new BizException(msg);
//			}
//		}
//	}

//	/**
//	 * 获取患者主键集合
//	 * 
//	 * @param hpdos
//	 * @return
//	 */
//	private String[] getPatIds(PiPatHpDO[] hpdos) {
//		if (hpdos == null || hpdos.length <= 0) {
//			return null;
//		}
//
//		ArrayList<String> patIdList = new ArrayList<String>();
//		for (PiPatHpDO piPatHpDO : hpdos) {
//			patIdList.add(piPatHpDO.getId_pat());
//		}
//
//		return patIdList.toArray(new String[0]);
//	}
//
//	/**
//	 * 根据患者主键集合查询患者信息 集合
//	 * 
//	 * @param patIds
//	 * @return
//	 * @throws BizException
//	 */
//	private PatDO[] findPatsByIds(String[] patIds) throws BizException {
//		if (patIds == null || patIds.length <= 0) {
//			return null;
//		}
//		String wherePart = SqlUtils.getInSqlByIds(PatDO.ID_PAT, patIds);
//		PatDO[] pats = findPatDosByWherePart(wherePart);
//		return pats;
//	}

	/**
	 * 根据查询条件查询患者信息集合</br>
	 * 带失效判断
	 * 
	 * @param wherePart
	 * @return
	 * @throws BizException
	 */
	private PatDO[] findPatDosByWherePart(String wherePart) throws BizException {
		wherePart = String.format("(%s) and FG_INVD = 'N'", wherePart);
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT a0.Barcode_chis, a0.Code, a0.Code_amr_ip, a0.Code_amr_oep, a0.Createdby    ");
		sql.append("    , a0.Createdtime, a0.Def1, a0.Def2, a0.Def3, a0.Def4    ");
		sql.append("    , a0.Def5, a0.Def6, a0.Ds, a0.Dt_birth, a0.Dt_birth_hms    ");
		sql.append("    , a0.Email, a0.Fg_active, a0.Fg_invd, a0.Fg_realname, a0.Id_code    ");
		sql.append("    , a0.Id_country, a0.Id_educ, a0.Id_emp_create, a0.Id_grp, a0.Id_idtp    ");
		sql.append("    , a0.Id_log, a0.Id_marry, a0.Id_nation, a0.Id_occu, a0.Id_org    ");
		sql.append("    , a0.Id_pat, a0.Id_patcrettp, a0.Id_paticate, a0.Id_patpritp, a0.Id_patsrctp    ");
		sql.append("    , a0.Id_person, a0.Id_piinvdmd, a0.Id_sex, a0.Id_srcregiontp, a0.Id_third    ");
		sql.append("    , a0.Id_unkwrsn, a0.Last_times_ip, a0.Last_times_oep, a0.Mnecode, a0.Mob    ");
		sql.append("    , a0.Modifiedby, a0.Modifiedtime, a0.Name, a0.Password, a0.Photo    ");
		sql.append("    , a0.Priinvddes, a0.Pycode, a0.Sd_country, a0.Sd_educ, a0.Sd_idtp    ");
		sql.append("    , a0.Sd_marry, a0.Sd_nation, a0.Sd_occu, a0.Sd_patsrctp, a0.Sd_piinvdmd    ");
		sql.append("    , a0.Sd_sex, a0.Sd_srcregiontp, a0.Sd_unkwrsn, a0.Sv, a0.Tel    ");
		sql.append("    , a0.Wbcode, a0.Workunit    ");
		sql.append("FROM pi_pat a0    where ");
		sql.append(wherePart);
		//IPatiMDORService patiMDORService = ServiceFinder.find(IPatiMDORService.class);
		//PatDO[] result = patiMDORService.find(wherePart, "", FBoolean.FALSE);
		DAFacade facade = new DAFacade();
		ArrayList list = (ArrayList) facade.execQuery(sql.toString(), new BeanListHandler(PatDO.class));
		PatDO[] result = (PatDO[]) list.toArray(new PatDO[list.size()]);
		return result;
	}

	/**
	 * 验证患者证件号是否已注册过,不校验其他证件
	 * 
	 * @param patDo
	 * @throws BizException
	 */
	private void checkIdCodeIsRegistered(PatDO patDo) throws BizException {
		if (!IPiDictCodeConst.SD_IDTP_QTFDZ.equals(patDo.getSd_idtp()) && !StringUtil.isEmpty(patDo.getId_code())) {
			IPatiMDORService patiMDORService = ServiceFinder.find(IPatiMDORService.class);
			String wherePart = String.format("id_code = '%s' and id_idtp = '%s' and fg_invd = 'N' and fg_active = 'Y'", patDo.getId_code(),
					patDo.getId_idtp());
			if (StringUtils.isNotEmpty(patDo.getId_pat())) {
				// 更新时也调用，排除原患者
				wherePart = String.format("%s and id_pat <> '%s'", wherePart, patDo.getId_pat());
			}
			PatDO[] patdos = patiMDORService.find(wherePart, "", FBoolean.FALSE);
			if (patdos != null && patdos.length >= 1) {
				String msg = String.format("该证件号[%s]已经被注册,已注册患者编码:%s。", patDo.getId_code(), patdos[0].getCode());
				throw new BizException(msg);
			}
		}
	}
}
