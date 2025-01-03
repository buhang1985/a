package iih.en.comm.bp;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.comm.validator.EnValidator;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 就诊banner自定义查询信息
 * 
 * @author liubin
 *
 */
public class GetBannerDefBP {
	/**
	 * 就诊banner查询条件
	 */
	private static final String EN_COND_IDFACE = "id_face";//面部id
	private static final String EN_COND_CARDNO = "patcode";//就诊卡号
	private static final String EN_COND_IDCODE = "id_code";//证件号
	private static final String EN_COND_PATCODE = "code_pat";//患者编码
	private static final String EN_COND_TEL = "Phonenum";//联系方式
	private static final String EN_COND_ENTCODE = "code_ent";//就诊编码
	private static final String EN_COND_CODEIP = "code_amr_ip";//住院号
	private static final String EN_COND_NOHP = "no_hp";//医保号
	private static final String EN_COND_NAMEPAT = "name_pat";//患者姓名
	private static final String EN_COND_BARCODE = "barcode_chis";//条码号
	private static final String EN_COND_NEMEBED = "name_bed";//床位号
	
	/**
	 * 根据就诊banner查询条件查询患者
	 * 
	 * @param selectConditions
	 * @param inputValue
	 * @return
	 * @throws BizException
	 */
	public String[] getPatIdFromEntBanner(String[] selectConditions, String inputValue) throws BizException{
		if(EnValidator.isEmpty(selectConditions))
			return null;
		List<String> whereList = new ArrayList<String>();
		for(String selectCondition : selectConditions){
			if(EN_COND_IDCODE.equalsIgnoreCase(selectCondition)){
				whereList.add(" (PAT.ID_CODE = ? ) ");
			}
			if(EN_COND_PATCODE.equalsIgnoreCase(selectCondition)){
				whereList.add(" (PAT.CODE = ? ) ");
			}
			if(EN_COND_TEL.equalsIgnoreCase(selectCondition)){
				whereList.add(" (NVL(PAT.MOB,PAT.TEL) = ? ) ");
			}
			if(EN_COND_CODEIP.equalsIgnoreCase(selectCondition)){
				whereList.add(" (PAT.CODE_AMR_IP = ? ) ");
			}
			if(EN_COND_NAMEPAT.equalsIgnoreCase(selectCondition)){
				whereList.add(" (PAT.NAME = ? ) ");
			}
			if(EN_COND_BARCODE.equalsIgnoreCase(selectCondition)){
				whereList.add(" (PAT.BARCODE_CHIS = ? ) ");
			}
			if(EN_COND_CARDNO.equalsIgnoreCase(selectCondition)){
				whereList.add(" (EXISTS (SELECT * FROM PI_PAT_CARD CARD WHERE CARD.ID_PAT = PAT.ID_PAT AND CARD.FG_ACT='Y' AND CARD.CODE = ? )) ");
			}
			if(EN_COND_NOHP.equalsIgnoreCase(selectCondition)){
				whereList.add(" (EXISTS (SELECT * FROM PI_PAT_HP HP WHERE HP.ID_PAT = PAT.ID_PAT AND HP.NO_HP = ? )) ");
			}
			if(EN_COND_ENTCODE.equalsIgnoreCase(selectCondition)){
				whereList.add(" (EXISTS (SELECT * FROM EN_ENT ENT WHERE ENT.ID_PAT = PAT.ID_PAT AND ENT.CODE = ? )) ");
			}
			if(EN_COND_IDFACE.equalsIgnoreCase(selectCondition)){
				whereList.add(" (EXISTS (SELECT * FROM PI_PAT_CARD CARD WHERE CARD.ID_PAT = PAT.ID_PAT AND CARD.FG_ACT='Y' AND CARD.SD_PATCARDTP IN (SELECT CODE FROM PI_PAT_CARDTP WHERE SD_PATCARDTP = '"+IPiDictCodeConst.SD_CARD_TYPE_FACEID+"') AND CARD.CODE = ? )) ");
			}
		}
		if(EnValidator.isEmpty(whereList))
			return null;
		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		boolean isFirst = true;
		for(String whereStr : whereList){
			if(isFirst){
				isFirst = false;
			}else{
				sqlBuilder.append(" UNION ");
			}
			sqlBuilder.append("SELECT PAT.ID_PAT FROM PI_PAT PAT WHERE PAT.FG_INVD = 'N' and pat.fg_active = 'Y' AND ");
			sqlBuilder.append(whereStr);
			param.addParam(inputValue);
		}
		List<String> list = (List<String>) new DAFacade().execQuery(sqlBuilder.toString(), param, new ColumnListHandler());
		return EnValidator.isEmpty(list) ? null : list.toArray(new String[0]);
	}
	/**
	 * 根据就诊banner查询条件查询就诊
	 * 
	 * @param selectConditions
	 * @param inputValue
	 * @return
	 * @throws BizException
	 */
	public String[] getEntIdFromEntBanner(String[] selectConditions, String inputValue) throws BizException{
		if(EnValidator.isEmpty(selectConditions))
			return null;
		List<String> whereList = new ArrayList<String>();
		for(String selectCondition : selectConditions){
			if(EN_COND_IDCODE.equalsIgnoreCase(selectCondition)){
				whereList.add(" (PAT.ID_CODE = ? ) ");
			}
			if(EN_COND_PATCODE.equalsIgnoreCase(selectCondition)){
				whereList.add(" (PAT.CODE = ? ) ");
			}
			if(EN_COND_TEL.equalsIgnoreCase(selectCondition)){
				whereList.add(" (NVL(PAT.MOB,PAT.TEL) = ? ) ");
			}
			if(EN_COND_CODEIP.equalsIgnoreCase(selectCondition)){
				whereList.add(" (PAT.CODE_AMR_IP = ? ) ");
			}
			if(EN_COND_NAMEPAT.equalsIgnoreCase(selectCondition)){
				whereList.add(" (PAT.NAME = ? ) ");
			}
			if(EN_COND_BARCODE.equalsIgnoreCase(selectCondition)){
				whereList.add(" (PAT.BARCODE_CHIS = ? ) ");
			}
			if(EN_COND_CARDNO.equalsIgnoreCase(selectCondition)){
				whereList.add(" (EXISTS (SELECT * FROM PI_PAT_CARD CARD WHERE CARD.ID_PAT = PAT.ID_PAT AND CARD.FG_ACT='Y' AND CARD.CODE = ? )) ");
			}
			if(EN_COND_NOHP.equalsIgnoreCase(selectCondition)){
				whereList.add(" (EXISTS (SELECT * FROM PI_PAT_HP HP WHERE HP.ID_PAT = PAT.ID_PAT AND HP.NO_HP = ? )) ");
			}
			if(EN_COND_ENTCODE.equalsIgnoreCase(selectCondition)){
				whereList.add(" (EN.CODE = ? ) ");
			}
		}
		if(EnValidator.isEmpty(whereList))
			return null;
		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		boolean isFirst = true;
		for(String whereStr : whereList){
			if(isFirst){
				isFirst = false;
			}else{
				sqlBuilder.append(" UNION ");
			}
			sqlBuilder.append("SELECT EN.ID_ENT FROM EN_ENT EN INNER JOIN PI_PAT PAT ON EN.ID_PAT = PAT.ID_PAT WHERE PAT.FG_INVD = 'N' and pat.fg_active = 'Y' AND ");
			sqlBuilder.append(whereStr);
			param.addParam(inputValue);
		}
		List<String> list = (List<String>) new DAFacade().execQuery(sqlBuilder.toString(), param, new ColumnListHandler());
		return EnValidator.isEmpty(list) ? null : list.toArray(new String[0]);
	}
}
