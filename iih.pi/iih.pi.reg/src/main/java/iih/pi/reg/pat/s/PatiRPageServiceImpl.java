package iih.pi.reg.pat.s;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pi.dic.patcatehp.d.PiPatCaHpDO;
import iih.pi.dic.patcatehp.i.IPatcatehpRService;
import iih.pi.dic.patientcategory.d.desc.PiPatCaDODesc;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatCardDO;
import iih.pi.reg.pat.d.desc.PatDODesc;
import iih.pi.reg.pat.i.IPatiRPageService;
import iih.pi.reg.pat.s.bp.FindPatEntCardByIdBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 患者查询分页服务
 * 
 * @author ly 2017/09/03
 *
 */
@Service(serviceInterfaces = { IPatiRPageService.class }, binding = Binding.JSONRPC)
public class PatiRPageServiceImpl extends BaseAggService<PatiAggDO, PatDO> implements IPatiRPageService {

	public PatiRPageServiceImpl() {
		super(DescManager.getInstance().getDODesc(PatDODesc.class), IAppFwTempTbl.tmp_iaw_29.name());
	}

	@Override
	protected String getQueryForceIndex() {
		// 并行度
		return "/*+ parallel(4) */";
	}

	@Override
	public PagingRtnData<PatiAggDO> findByPageInfo(PaginationInfo pg, String whereStr, String orderStr, FBoolean isLazy)
			throws BizException {

		if (!StringUtil.isEmpty(whereStr)) {
			// 添加索引条件
			whereStr += " and a0.code IS NOT NULL ";
		} else {
			whereStr = " a0.code IS NOT NULL ";
		}

		return super.findByPageInfo(pg, whereStr, orderStr, isLazy);
	}

	@Override
	public PagingRtnData<PatiAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO, String orderStr,
			PaginationInfo pg, FBoolean isLazy) throws BizException {

		PagingRtnData<PatiAggDO> result = super.findByQCondAndPageInfo(qryRootNodeDTO, orderStr, pg, isLazy);

		if (result.getPageData() == null || result.getPageData().size() == 0)
			return result;

		List<String> caIdList = new ArrayList<String>();

		for (int i = 0; i < result.getPageData().size(); i++) {
			PatiAggDO patiAggDO = (PatiAggDO) result.getPageData().get(i);
			PatDO pat = patiAggDO.getParentDO();

			// 处理卡信息
			PiPatCardDO[] cardDos = patiAggDO.getPiPatCardDO();
			if (!ArrayUtil.isEmpty(cardDos)) {
				for (PiPatCardDO piCardDo : cardDos) {
					
					if(piCardDo.getEu_cardsu()==null){
						continue;
					}
					if (IPiDictCodeConst.SD_PICARD_LOSS.equals(piCardDo.getEu_cardsu().toString())) {
						piCardDo.setFg_picardloss(FBoolean.TRUE);
					}
					if (FBoolean.TRUE.equals(piCardDo.getFg_act()) && IPiDictCodeConst.SD_CARD_TYPE_TREATMENT.equals(piCardDo.getSd_patcardtp_udi())&&IPiDictCodeConst.SD_PICARD_USE.equals(piCardDo.getEu_cardsu().toString())) {
						pat.setCode_encard(piCardDo.getCard_code());
					}
				}
			}

			// 处理患者分类医保计划
			if (!caIdList.contains(pat.getId_paticate()))
				caIdList.add(pat.getId_paticate());
		}

		String inSql = "(";
		for (String str : caIdList) {
			inSql += "'" + str + "',";
		}
		inSql = inSql.substring(0, inSql.length() - 1);
		inSql += ")";

		IPatcatehpRService rService = ServiceFinder.find(IPatcatehpRService.class);
		String whereSql = PiPatCaDODesc.TABLE_ALIAS_NAME + ".id_patca in " + inSql;
		PiPatCaHpDO[] caHpDos = rService.find(whereSql, "", FBoolean.FALSE);

		if (!ArrayUtil.isEmpty(caHpDos)) {
			Map<String, PiPatCaHpDO> cahpMap = new HashMap<String, PiPatCaHpDO>();
			for (PiPatCaHpDO piPatCaHpDO : caHpDos) {
				cahpMap.put(piPatCaHpDO.getId_patca(), piPatCaHpDO);
			}

			for (int i = 0; i < result.getPageData().size(); i++) {
				PatiAggDO patiAggDO = (PatiAggDO) result.getPageData().get(i);
				PatDO pat = patiAggDO.getParentDO();

				PiPatCaHpDO cahpDo = cahpMap.get(pat.getId_paticate());
				if (cahpDo != null) {
					pat.setCa_id_hp(cahpDo.getId_hp());
					pat.setCa_name_hp(cahpDo.getName_hp());
				}
			}
		}

		return result;
	}

	@Override
	public String[] findPatEntCardCodeById(String patId) throws BizException {
		FindPatEntCardByIdBp bp = new FindPatEntCardByIdBp();
		String[] entCardCodes = bp.exec(patId);
		return entCardCodes;
	}

	@Override
	public PatiAggDO findById(String idPat) throws BizException {
		PatiAggDO patiAggDO = super.findById(idPat);

		if (patiAggDO == null || patiAggDO.getParentDO() == null)
			return patiAggDO;

		List<String> caIdList = new ArrayList<String>();
		PatDO pat = patiAggDO.getParentDO();

		// 处理卡信息
		PiPatCardDO[] cardDos = patiAggDO.getPiPatCardDO();
		if (!ArrayUtil.isEmpty(cardDos)) {
			for (PiPatCardDO piCardDo : cardDos) {
				
				if(piCardDo.getEu_cardsu()==null){
					continue;
				}
				if (IPiDictCodeConst.SD_PICARD_LOSS.equals(piCardDo.getEu_cardsu().toString())) {
					piCardDo.setFg_picardloss(FBoolean.TRUE);
				}
				if (FBoolean.TRUE.equals(piCardDo.getFg_act()) && IPiDictCodeConst.SD_CARD_TYPE_TREATMENT.equals(piCardDo.getSd_patcardtp_udi())&&IPiDictCodeConst.SD_PICARD_USE.equals(piCardDo.getEu_cardsu().toString())) {
					pat.setCode_encard(piCardDo.getCard_code());
				}
			}
		}

		// 处理患者分类医保计划
		if (!caIdList.contains(pat.getId_paticate()))
			caIdList.add(pat.getId_paticate());

		String inSql = "(";
		for (String str : caIdList) {
			inSql += "'" + str + "',";
		}
		inSql = inSql.substring(0, inSql.length() - 1);
		inSql += ")";

		IPatcatehpRService rService = ServiceFinder.find(IPatcatehpRService.class);
		String whereSql = PiPatCaDODesc.TABLE_ALIAS_NAME + ".id_patca in " + inSql;
		PiPatCaHpDO[] caHpDos = rService.find(whereSql, "", FBoolean.FALSE);

		if (!ArrayUtil.isEmpty(caHpDos)) {
			Map<String, PiPatCaHpDO> cahpMap = new HashMap<String, PiPatCaHpDO>();
			for (PiPatCaHpDO piPatCaHpDO : caHpDos) {
				cahpMap.put(piPatCaHpDO.getId_patca(), piPatCaHpDO);
			}
			PiPatCaHpDO cahpDo = cahpMap.get(pat.getId_paticate());
			if (cahpDo != null) {
				pat.setCa_id_hp(cahpDo.getId_hp());
				pat.setCa_name_hp(cahpDo.getName_hp());
			}
		}
		return patiAggDO;
	}
}
