package iih.pi.reg.s.ws;

import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pi.params.PiParams;
import iih.pi.reg.dto.ws.PatInfoBean;
import iih.pi.reg.i.PatCardTp;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatCardDO;
import iih.pi.reg.pat.d.PiPatContDO;
import iih.pi.reg.pat.d.PiPatHpDO;
import iih.pi.reg.pat.i.IPatiRService;
import iih.pi.reg.s.customer.guoji.SyncPatiInfoFromChisBP;
import iih.pi.reg.s.ws.sql.FindPatIdByCodeTpAndCodeSql;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询患者基本信息
 * 
 * @author hehuan 2017/07/24
 * @author hao_wu 2018年5月9日 通过身份证号码查询时，增加证件类型过滤
 *
 */
public class PatInfoQryWSBP {

	/**
	 * 查询患者基本信息
	 * 
	 * @param codeTp
	 *            编码类型{01:居民身份证,02:医保号,03:CHIS条码号,04:患者编码,05:其他卡}
	 * @param code
	 *            编码值
	 * @return
	 * @throws BizException
	 */
	public PatInfoBean exec(String codeTp, String code) throws BizException {

		if (StringUtil.isEmpty(codeTp) || StringUtil.isEmpty(code))
			return null;

		IPatiRService service = ServiceFinder.find(IPatiRService.class);
		PatiAggDO aggDO = null;
		String patId = this.getPatId(codeTp, code);
		if (patId != null) {
			aggDO = service.findById(patId);
		} else if (FBoolean.TRUE.equals(new PiParams().PIPAT0002()) && (PatCardTp.CODE_IDTYPE_CODE.equals(codeTp)
				|| PatCardTp.CODE_IDTYPE_BARCODE_CHIS.equals(codeTp) || PatCardTp.CODE_IDTYPE_IDCARD.equals(codeTp))
				|| PatCardTp.CODE_CARDTP_CODE.equals(codeTp)) {
			SyncPatiInfoFromChisBP bp = new SyncPatiInfoFromChisBP();
			aggDO = bp.exec(code);
		}

		return mapAggDO(aggDO);
	}

	/**
	 * 根据卡类型和卡号获取患者主键
	 * 
	 * @param codeTp
	 *            卡类型
	 * @param code
	 *            卡号
	 * @return
	 * @throws BizException
	 */
	private String getPatId(String codeTp, String code) throws BizException {

		FindPatIdByCodeTpAndCodeSql sql = new FindPatIdByCodeTpAndCodeSql(codeTp, code);

		DAFacade daFacade = new DAFacade();
		try {
			String patId = (String) daFacade.execQuery(sql.getQrySQLStr(), sql.getQryParameter(null),
					new ColumnHandler(1));
			return patId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private PatInfoBean mapAggDO(PatiAggDO aggdo) throws BizException {

		if (aggdo == null)
			return null;

		PatInfoBean bean = new PatInfoBean();
		PatDO p = aggdo.getParentDO();
		PatiAddrDO[] addrs = aggdo.getPatiAddrDO();
		PiPatHpDO[] hps = aggdo.getPiPatHpDO();
		PiPatCardDO[] cards = aggdo.getPiPatCardDO();
		PiPatContDO[] conts = aggdo.getPiPatContDO();

		bean.setPhone(!StringUtils.isNullOrEmpty(p.getMob()) ? p.getMob() : p.getTel());///设置手机号
		String cardStr = this.serCardTp(cards);
		bean.setCardStr(cardStr);//拼接卡类型名称和卡号
		
		bean.setPatient_id(p.getCode());
		bean.setP_bar_code(p.getBarcode_chis());
		bean.setName(p.getName());
		bean.setSex_code(p.getCode_sex());
		bean.setSex_name(p.getName_sex());
		bean.setMarry_code(p.getMarry_code());
		bean.setMarry_name(p.getMarry_name());
		bean.setCountry_code(p.getCountry_code());
		bean.setCountry_name(p.getCountry_name());
		bean.setNation_code(p.getNation_code());
		bean.setNation_name(p.getNation_name());
		bean.setReponse_type_code(p.getPaticate_code());
		bean.setResponse_type_name(p.getPaticate_name());
		bean.setBirthday(p.getDt_birth().toStdtString().substring(0, 10));
		bean.setOccupation_type_code(p.getOccu_code());
		bean.setOccupation_type_name(p.getOccu_name());
		bean.setPy_code(p.getPycode());
		bean.setCharge_grade_code(p.getPatpritp_code());
		bean.setCharge_grade_name(p.getPatpritp_name());
		bean.setIdentify_flag(p.getFg_realname().booleanValue() ? "Y" : "N");
		bean.setSrcregiontp_code(p.getSd_srcregiontp());
		bean.setSrcregointp_name(p.getName_srcregiontp());
		bean.setPatsrctp_code(p.getSd_patsrctp());
		bean.setPatsrctp_name(p.getName_patsrctp());
		bean.setCreate_date(p.getCreatedtime().toStdString().substring(0, 10));
		bean.setCreat_operator(p.getCreateby_code());

		if (IPiDictCodeConst.SD_IDTP_IDENTITY.equals(p.getIdtp_code())) {
			bean.setSocial_no(p.getId_code());
		}

		if (conts != null && conts.length > 0) {
			PiPatContDO cont = conts[0];
			bean.setRelation_code(cont.getConttp_code());
			bean.setRelation_code_name(cont.getConttp_name());
			bean.setRelation_name(cont.getName());
			bean.setRelation_tel(cont.getConttel());
		}

		if (hps != null && hps.length > 0) {
			for (PiPatHpDO hp : hps) {
				if (FBoolean.TRUE.equals(hp.getFg_deft())) {
					bean.setAddition_no1(hp.getNo_hp());
					break;
				}
			}
		}

		if (cards != null && cards.length > 0) {
			for (PiPatCardDO card : cards) {
				if (IPiDictCodeConst.SD_CARD_TYPE_TREATMENT.equals(card.getPatcardtp_code())) {
					bean.setHic_no(card.getCard_code());
					break;
				}
			}
		}
		if (addrs != null && addrs.length > 0) {
			for (PatiAddrDO addr : addrs) {
				if (IPiDictCodeConst.SD_ADDR_TYPE_BORN.equals(addr.getAddrtp_code())) {
					bean.setBirth_place_code(addr.getAdmdiv_code());
					bean.setBirth_place_name(addr.getAdmdiv_name());
				}
				if (IPiDictCodeConst.SD_ADDR_TYPE_FAMILY.equals(addr.getAddrtp_code())) {
					bean.setHome_district_code(addr.getAdmdiv_code());
					bean.setHome_district_name(addr.getAdmdiv_name());
					bean.setHome_street(addr.getStreet());
					bean.setHome_tel(addr.getTel());
					bean.setHome_zipcode(addr.getZip());
				}
				if (IPiDictCodeConst.SD_ADDR_TYPE_NOW.equals(addr.getAddrtp_code())) {
					bean.setTemp_district_code(addr.getAdmdiv_code());
					bean.setTemp_district_name(addr.getAdmdiv_name());
					bean.setTemp_street(addr.getStreet());
					bean.setTemp_zipcode(addr.getZip());
				}
			}
		}
		return bean;
	}
	
	/***
	 * 获取卡类型和卡号
	 * @param aggdo
	 * @throws BizException
	 */
	private String serCardTp(PiPatCardDO[] cards) throws BizException{
		if(cards == null || cards.length <= 0)
			return null;
		List<String> idcardlist=new ArrayList<String>();
		for (PiPatCardDO card : cards) {
			if(!StringUtils.isNullOrEmpty(card.getCode()) && !idcardlist.contains(card.getCode())){
				idcardlist.add(card.getCode());//获取卡号
			}
		}
		if(idcardlist == null || idcardlist.size() <= 0)
			return null;
		StringBuilder sql = new StringBuilder();
		sql.append("select tp.name as name_cardtp,card.code as no_card from pi_pat_card card " );
		sql.append("inner join pi_pat_cardtp tp on tp.id_cardtp = card.id_patcardtp ");
		sql.append("where "+SqlUtils.getInSqlByIds("card.code", idcardlist));
		SqlParam sp = new SqlParam();
	    @SuppressWarnings("unchecked")
	    List<PatInfoBean> cardlist = (List<PatInfoBean>) new DAFacade().execQuery(sql.toString(), sp,new BeanListHandler(PatInfoBean.class));
		if(cardlist==null || cardlist.size()<=0)
			return null;
		String cardStr="";
		for (PatInfoBean card : cardlist) {
			cardStr +=card.getName_cardtp()+","+card.getNo_card()+";";
		}
		return cardStr;
	}
}
