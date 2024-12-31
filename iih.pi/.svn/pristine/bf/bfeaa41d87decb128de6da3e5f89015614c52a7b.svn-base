package iih.pi.reg.s.bp.help;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import iih.pi.banner.d.PatientBannerDTO;
import iih.pi.common.idcheck.IDChecker;
import iih.pi.params.PiParams;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.s.bp.GetPatiBannerBP;
import iih.pi.reg.s.bp.qry.PiBannerQry;
import iih.pi.reg.s.customer.guoji.SyncPatiInfoFromChisBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 患者banner检索,从chis同步患者信息
 * @author ly 2018/09/02
 *
 */
public class GetPatiBannerFromChisBP {

	/**
	 * 从chis同步患者信息
	 * @param sqlStr
	 * @param services
	 * @param valueText
	 * @return
	 * @throws BizException
	 */
	public PatientBannerDTO exec(String sqlStr, String[] services,String valueText) throws BizException{
		 
		if(!this.ifSyncFromChis(services))
			return null;
			
		//解析身份证号
		String idCode = this.findIdCode(sqlStr);
		if(!StringUtil.isEmpty(idCode)){
			valueText = idCode;
		}
		
		PatDO patDo = this.syncFromChis(valueText);//chis同步患者数据
		if(patDo == null)
			return null;
		
		String newCond = "and id_pat = '" + patDo.getId_pat() + "'";
		PiBannerQry qry = new PiBannerQry(null, newCond);
		PatientBannerDTO[] result = (PatientBannerDTO[])AppFwUtil.getDORstWithDao(qry, PatientBannerDTO.class);
		
		if(ArrayUtil.isEmpty(result)){
			return null;
		}else if(patDo.getAttrVal("Msg") != null){
			result[0].setMsg((String)patDo.getAttrVal("Msg"));
		}
		
		return result[0];
	}
	
	/**
	 * 是否从chis同步数据
	 * @param services
	 * @return
	 * @throws BizException
	 */
	private boolean ifSyncFromChis(String[] services) throws BizException{
		
		if(ArrayUtil.isEmpty(services))
			return false;
		
		boolean contain = false;
		for (String service : services) {
			if(GetPatiBannerBP.SYNC_FROM_CHIS.equals(service)){
				contain = true;
				break;
			}
		}
		
		if(contain == false)
			return false;
		
		FBoolean syncFromChis = new PiParams().PIPAT0002();
		if (FBoolean.TRUE.equals(syncFromChis))
			return true;
		return false;
	}
	
	/**
	 * 解析身份证号
	 * @param sqlStr
	 * @return
	 */
	private String findIdCode(String sqlStr){
		
		String reg = "'[0-9a-zA-Z]{18}'";
		Pattern pat = Pattern.compile(reg);
		Matcher matcher = pat.matcher(sqlStr);
		
		List<String> codeList = new ArrayList<String>();
		while (matcher.find()) {
			String code = sqlStr.substring(matcher.start() + 1, matcher.end() - 1);
			if(!codeList.contains(code)){
				codeList.add(code);
			}
		}
		
		if(codeList.size() == 0)
			return null;
			
		for (String code : codeList) {
			if(IDChecker.checkIDCard(code)){
				return code;
			}
		}
		
		return null;
	}
	
	/**
	 * 从chis同步数据
	 * @param valueText
	 * @return
	 * @throws BizException
	 */
	private PatDO syncFromChis(String valueText)throws BizException{
		
		if(StringUtil.isEmpty(valueText))
			return null;
		
		SyncPatiInfoFromChisBP bp = new SyncPatiInfoFromChisBP();
		PatiAggDO aggDo = bp.exec(valueText);
		
		if(aggDo == null || aggDo.getParentDO() == null)
			return null;
		
		return aggDo.getParentDO();
	}
}
