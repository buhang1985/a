package iih.bd.pp.hp.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bd.base.validator.ParamValidator;
import iih.bd.pp.hp.dto.d.HpSrvCtrDiDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取医保服务限制诊断集合
 * @author yankan
 * @since 2017-11-23
 *
 */
public class GetHpSrvCtrDiListBP {
	/**
	 * 获取医保服务限制诊断集合
	 * @param hpId 医保计划ID
	 * @param srvIds 服务ID集合 
	 * @return map，【key:服务ID,value:List<诊断ID>】
	 * @throws BizException
	 */
	public FMap exec(String hpId,String[] srvIds) throws BizException{
		ParamValidator.validateNotNull("医保计划ID", hpId);
		ParamValidator.validateNotNull("服务ID集合", srvIds);
		
		//1、获取诊断控制集合
		List<HpSrvCtrDiDTO> ctrDiList = this.getHpSrvCtrDiList(hpId, srvIds);
		//2、转为Map
		FMap fmap = this.convertToMap(ctrDiList);
		
		return fmap;
	}
	/**
	 * 获取服务控制诊断集合
	 * @param hpId
	 * @param srvIds
	 * @return
	 * @throws BizException
	 */
	private List<HpSrvCtrDiDTO> getHpSrvCtrDiList(String hpId,String[] srvIds) throws BizException{
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT HPSRV.ID_SRV,CTRDI.ID_DI_DEF ");
		sqlBuilder.append(" FROM BD_HP_SRVCTR_DI CTRDI");
		sqlBuilder.append(" INNER JOIN BD_HP_SRVORCA HPSRV ON HPSRV.ID_SRV=CTRDI.ID_SRV ");
		sqlBuilder.append("  inner join bd_hp_srvctr bd_hp_srvctr on bd_hp_srvctr.id_srv =  HPSRV.id_srv ");
		sqlBuilder.append(" WHERE 1=1");
		sqlBuilder.append(" and bd_hp_srvctr.eu_hpsrvctrtp='11' ");
		sqlBuilder.append(" AND HPSRV.ID_HP=?");
		sqlBuilder.append(" AND " + SqlUtils.getInSqlByIds("HPSRV.ID_SRV", srvIds));
		
		SqlParam param = new SqlParam();
		param.addParam(hpId);
		
		List<HpSrvCtrDiDTO> ctrDiList = (List<HpSrvCtrDiDTO>)new DAFacade().execQuery(sqlBuilder.toString(), param,new BeanListHandler(HpSrvCtrDiDTO.class));
		return ctrDiList;
	}
	/**
	 * 转换为map
	 * @param ctrDiList
	 * @return
	 */
	private FMap convertToMap(List<HpSrvCtrDiDTO> ctrDiList){
		FMap ctrDiMap = new FMap();
		if(ListUtil.isEmpty(ctrDiList)){
			return ctrDiMap;
		}
		
		for(HpSrvCtrDiDTO ctrDiDTO : ctrDiList){
			List<String> diIdList = (List<String>) ctrDiMap.get(ctrDiDTO.getId_srv());
			if(diIdList==null){
				diIdList = new ArrayList<String>();
				ctrDiMap.put(ctrDiDTO.getId_srv(), diIdList);
			}
			diIdList.add(ctrDiDTO.getId_di_def());
		}
		return ctrDiMap;
	}
	
}
