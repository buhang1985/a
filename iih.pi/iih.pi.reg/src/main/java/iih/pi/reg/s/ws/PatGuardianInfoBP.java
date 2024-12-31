package iih.pi.reg.s.ws;

import iih.bd.base.exception.ArgumentNullException;
import iih.bl.hp.i.IBlHpOutQryService;
import iih.pi.acc.account.i.IPatAccServiceExt;
import iih.pi.reg.dto.d.PatGuardianDTO;
import iih.pi.reg.dto.ws.PatGuardianInfoBean;
import iih.pi.reg.pat.d.PiPatHpDO;
import iih.pi.reg.pat.i.IPiPatHpDORService;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询被监护人信息
 * 
 * @author LIM
 */
public class PatGuardianInfoBP {
	/**
	 * 查询被监护人信息
	 * 
	 * @param codeTp
	 *            证件编码类型
	 * @param code
	 *            身份证号
	 * @param operatorCode
	 *            操作员
	 * @throws BizException
	 */
	public PatGuardianInfoBean[] exec(String codeTp, String code, String operatorCode) throws BizException {
		// 1. 参数校验
		this.validData(codeTp, code);
		// 2.获取患者信息
		PatGuardianDTO[] patGuardianDtoArr = this.patGuardianQry(codeTp, code);
		// 3.组织返回的被监护人信息
		PatGuardianInfoBean[] patPatGuardianInfoBean = ConvertPatGuardianBean(patGuardianDtoArr);

		return patPatGuardianInfoBean;
	}

	/**
	 * 参数校验
	 * 
	 * @param codeTp
	 * @param code
	 * @throws BizException
	 */
	private void validData(String codeTp, String code) throws BizException {
		if (StringUtil.isEmpty(codeTp)) {
			throw new ArgumentNullException("监护人关联信息", "证件编码类型");
		}
		if (StringUtil.isEmpty(code)) {
			throw new ArgumentNullException("监护人关联信息", "证件号码");
		}
		// 1:社保卡 ；2：IC卡； 3：身份证；
		String[] codeTpArr = new String[] { "01", "02", "03", "04", "05" };
		if (!ArrayUtils.contains(codeTpArr, codeTp)) {
			throw new ArgumentNullException("监护人关联信息", "证件编码类型");
		}
	}

	/**
	 * 获取被监护人的信息
	 * 
	 * @param codeTp
	 * @param code
	 * @return
	 * @throws BizException
	 */
	private PatGuardianDTO[] patGuardianQry(String codeTp, String code) throws BizException {
		DAFacade da = new DAFacade();
		SqlParam param = new SqlParam();
		String sql = this.getSql(codeTp);
		// 如果是社保卡，自助机传入前9位，用like查询
		if("02".equals(codeTp)){
			param.addParam(code + "%");
		}else{
			param.addParam(code);
		}
		List<PatGuardianDTO> pat = (List<PatGuardianDTO>) da.execQuery(sql, param, new BeanListHandler(PatGuardianDTO.class));
		return pat.toArray(new PatGuardianDTO[0]);
	}

	/**
	 * 返回查询sql
	 * 
	 * @param codeTp
	 * @return
	 */
	private String getSql(String codeTp) {
		StringBuffer sb = new StringBuffer();
		String sWhere = "";
		sb.append(" select pat.id_pat as Id_pat,");
		sb.append(" pat.code as Code,");
		sb.append(" pat.name as Name, ");
		sb.append(" pat.barcode_chis as Barcode_chis,");
		sb.append(" pat.sd_sex as Sd_sex,");
		sb.append(" doc.name as Name_sex,");
		sb.append(" pat.Dt_birth as Dt_birth,");
		sb.append(" pat.Tel as Tel,");
		sb.append(" pat.Mob as Mob,");
		sb.append("  ca.code as Paticate_code,");
		sb.append("  ca.name as Paticate_name ");
		sb.append(" from pi_pat pat");
		sb.append(" inner join  pi_pat_cont con on pat.id_pat=con.id_pat");
		sb.append(" left join bd_udidoc doc on pat.id_sex=doc.id_udidoc");
		sb.append(" left join pi_pat_ca ca on pat.id_paticate=ca.id_patca ");
		sb.append(" where con.id_cont='@@@@AA1000000000MNLZ' and fg_guardian='Y' ");
		sb.append(" ");
		switch (codeTp) {
		case "01":// 身份证
			sWhere = " and con.contid = ?";
			break;
		case "02": // 社保卡
			sWhere = " and con.contid in (select id_code from pi_pat pat inner join pi_pat_hp hp on pat.id_pat=hp.id_pat " + " where pat.sd_idtp='01' and no_hp like ?)";
			break;
		case "03":// 条码号
			sWhere = " and con.contid in (select id_code from pi_pat where barcode_chis = ?)";
			break;
		case "04":// 患者编码
			sWhere = " and con.contid in (select id_code from pi_pat where code = ?)";
			break;
		case "05":// IC卡
			sWhere = " and con.contid in (select id_code from pi_pat pat inner join pi_pat_card card on pat.id_pat=card.id_pat " + " where pat.sd_idtp='01' and card.id_card=?)";
			break;
		}

		sb.append(sWhere);
		return sb.toString();
	}

	/**
	 * 组织返回数据
	 * 
	 * @param patGuardianDTO
	 * @return
	 * @throws BizException
	 */
	private PatGuardianInfoBean[] ConvertPatGuardianBean(PatGuardianDTO[] patGuardianDTO) throws BizException {
		List<PatGuardianInfoBean> patGuardianInfoBean = new ArrayList<PatGuardianInfoBean>();
		for (PatGuardianDTO patDo : patGuardianDTO) {
			PatGuardianInfoBean patBean = new PatGuardianInfoBean();
			patBean.setPatient_id(patDo.getCode());
			patBean.setName(patDo.getName());
			patBean.setCanuse(getPrepayAmount(patDo.getId_pat()).toDouble());
			patBean.setSex_code(patDo.getSd_sex());
			patBean.setSex_name(patDo.getName_sex());
			patBean.setDt_birth(patDo.getDt_birth().toString());
			patBean.setHome_tel(patDo.getTel());
			patBean.setRelation_tel(patDo.getMob());
			patBean.setAge(AgeCalcUtil.getAge(patDo.getDt_birth()));
			patBean.setP_bar_code(patDo.getBarcode_chis());
			patBean.setP_bycc00(null);
			patBean.setP_mess00("0");
			patBean.setIdentify_flag("1");
			// 是否医保持卡
			if ("97".equals(patDo.getPaticate_code())) {
				if (FBoolean.TRUE.equals(this.patType(patDo.getId_pat()))) {
					patBean.setResponse_type_code("98");
					patBean.setResponse_type_name("门诊特殊病");
				} else {
					patBean.setResponse_type_code(patDo.getPaticate_code());
					patBean.setResponse_type_name("医保");
				}
			} else {
				patBean.setResponse_type_code("01");
				patBean.setResponse_type_name("自费病人");
			}
			patGuardianInfoBean.add(patBean);
		}
		return patGuardianInfoBean.toArray(new PatGuardianInfoBean[0]);
	}

	/**
	 * 获取患者门诊预交金余额
	 * 
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	private FDouble getPrepayAmount(String id_pat) throws BizException {
		FDouble prepayAmount = new FDouble();
		IPatAccServiceExt patAccImpls = (IPatAccServiceExt) ServiceFinder.find(IPatAccServiceExt.class);
		prepayAmount = patAccImpls.GetOutpPrepaymentAmount(id_pat);
		return prepayAmount;
	}

	/**
	 * 查询患者是否特殊病身份
	 * 
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	private FBoolean patType(String id_pat) throws BizException {
		// 1.取患者医保计划
		IPiPatHpDORService hpService = ServiceFinder.find(IPiPatHpDORService.class);
		PiPatHpDO[] hpDO = hpService.find("id_pat='" + id_pat + "'", "", FBoolean.FALSE);
		
		IBlHpOutQryService checkService = ServiceFinder.find(IBlHpOutQryService.class);
		if (!ArrayUtil.isEmpty(hpDO)) {
			for (PiPatHpDO hp : hpDO) {
				FBoolean rlt = checkService.isSpecDi(hp.getId_hp(), hp.getNo_hp());
				if(FBoolean.TRUE.equals(rlt)){
					return rlt;
				}
			}
		}
		return FBoolean.FALSE;
	}
}
