package iih.bd.pp.s.bp.prinew;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.dto.priview.d.BdPriViewDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 计算服务价格
 * @author ly 2018/06/27
 *
 */
public class BdPpCalSrvPriceBP {

	/**
	 * 计算服务价格
	 * @param srvIds
	 * @param pripatIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public BdPriViewDTO[] exec(String[] srvIds, String[] pripatIds) throws BizException {
		if(ArrayUtil.isEmptyNoNull(srvIds)){	
			throw new BizException("未维护就诊卡收费项目，请联系管理员");
		}
			
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select * from view_price_rp ");
		sqlSb.append("where ");
		
		String srvWhereSql = SqlUtils.getInSqlByIds("id_srv", srvIds);
		sqlSb.append(srvWhereSql);
		
		if(!ArrayUtil.isEmpty(pripatIds)){
			ArrayList<String> idPriPats = new ArrayList<>();
			for(String pripatId:pripatIds){
				if(StringUtils.isNotBlank(pripatId)){
					idPriPats.add(pripatId);
				}
			}
			if(idPriPats.size() > 0){
				String priWhereSql = SqlUtils.getInSqlByIds("id_pripat", idPriPats);
				sqlSb.append(" and " + priWhereSql);
			}
		}
		
		DAFacade daf = new DAFacade();
		List<BdPriViewDTO> priList = (List<BdPriViewDTO>)daf.execQuery(
				sqlSb.toString(), new BeanListHandler(BdPriViewDTO.class));
		if(ListUtil.isEmpty(priList)){
			return null;
		}
		
		for (BdPriViewDTO bdPriViewDTO : priList) {
			if(bdPriViewDTO.getPrice_std() == null){
				bdPriViewDTO.setPrice_std(FDouble.ZERO_DBL);
			}
			
			if(bdPriViewDTO.getPrice_ratio() == null){
				bdPriViewDTO.setPrice_ratio(FDouble.ZERO_DBL);
			}
		}
		
		return priList.toArray(new BdPriViewDTO[0]);
	}
}
