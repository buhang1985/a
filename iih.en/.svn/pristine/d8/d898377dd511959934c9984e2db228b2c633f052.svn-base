package iih.en.pv.s.bp.ippre.qry;

import java.util.List;

import iih.en.pv.inpatient.dto.d.EnIppreInfoDTO;
import iih.en.pv.s.bp.ippre.IppreTransHosCheckBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;

/***
 * 查询预住院在院患者信息
 * @author zhangpp
 *
 */
public class GetIppreConterListBP extends GetIpPreInfoAbstact {

	/**
	 * 获取患者信息
	 * @param str
	 * @return
	 * @throws BizException
	 */
	public EnIppreInfoDTO[] exec(String str) throws BizException{
		
		String[] entIds = getEntIds(str);
		EnIppreInfoDTO[] ippreInfoDTO = getIpPreByEntIds(entIds);
		this.getCheckInfo(ippreInfoDTO);
		return ippreInfoDTO;
	}
	
	/**
	 * 获取转住院的查询信息
	 * @param ippreInfoDTO
	 * @throws BizException 
	 */
	private void getCheckInfo(EnIppreInfoDTO[] ippreInfoDTO) throws BizException {
		IppreTransHosCheckBP bp = new IppreTransHosCheckBP();
		bp.exec(ippreInfoDTO);
	}

	/**
	 * 获取entIds
	 * @param qrySchm
	 * @param param
	 * @return
	 * @throws DAException 
	 */
	@SuppressWarnings("unchecked")
	private String[] getEntIds(String str) throws DAException{
		
		if (StringUtil.isEmptyWithTrim(str)) {
			return null;
		}
		
		List<String> dtoList=  (List<String>) new DAFacade().execQuery(str,new ColumnListHandler()); 
    	if (ListUtil.isEmpty(dtoList)) {
 			return null;
 		}
    	
		return dtoList.toArray(new String[0]);
	}
	
	/**
	 * 获取sql
	 * @return
	 */
	private String getSql(){
		
		StringBuffer sql = new StringBuffer();
		sql.append("select distinct ippre.id_ent ");
		sql.append(" from en_ippre ippre " );
		sql.append(" inner join en_ent_ip ip on ip.id_ent = ippre.id_ent ");
		sql.append(" where ");
		sql.append(" ip.fg_ippre = 'Y' ");
		sql.append(" and ippre.sd_status = '2' ");
		
		return sql.toString();
	}
}
