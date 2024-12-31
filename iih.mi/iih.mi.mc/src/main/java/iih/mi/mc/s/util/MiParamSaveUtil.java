package iih.mi.mc.s.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.SqlUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.devcfg.paramset.d.ParamSetDO;
import xap.sys.devcfg.paramset.i.IParamsetCudServiceExt;
import xap.sys.devcfg.paramtmplset.d.ParamTmplSetDO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 医保实体参数批量保存工具
 * @author ly 2019/06/15
 *
 */
public class MiParamSaveUtil {

	/**
	 * 保存参数
	 * @param hpId 医保产品id
	 * @param paramMap 参数map key:参数编码 value:值
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static void save(String hpId, Map<String, String> paramMap) throws BizException {

		if(StringUtil.isEmpty(hpId) || paramMap == null || paramMap.size() <= 0){
			throw new BizException("保存参数:入参为空");
		}
		
		String[] paramCodes = paramMap.keySet().toArray(new String[0]);
		
		DAFacade daf = new DAFacade();
		
		// 查询模板数据
		List<ParamTmplSetDO> tmplList = (List<ParamTmplSetDO>)daf.findByAttrVals(
				ParamTmplSetDO.class, ParamTmplSetDO.PARAMCODE, paramCodes, null);
		
		Map<String,ParamTmplSetDO> tmplMap = new HashMap<String,ParamTmplSetDO>();
		for (ParamTmplSetDO paramTmplSetDO : tmplList) {
			tmplMap.put(paramTmplSetDO.getParamcode(), paramTmplSetDO);
		}

		String whereSql = "id_instance = ? and ";
		whereSql += SqlUtils.getInSqlByIds("paramcode", paramCodes);
		
		SqlParam param = new SqlParam();
		param.addParam(hpId);
		List<ParamSetDO> paramSetList = (List<ParamSetDO>)daf.findByCond(ParamSetDO.class, whereSql, param);
		if(ListUtil.isEmpty(paramSetList)){
			paramSetList = new ArrayList<ParamSetDO>();
		}
		
		List<ParamSetDO> updateList = new ArrayList<ParamSetDO>();
		for (String key : paramMap.keySet()) {
			
			boolean has = false;
			for (ParamSetDO paramSetDO : paramSetList) {
				
				if(key.equals(paramSetDO.getParamcode())){
					paramSetDO.setValue(paramMap.get(key));
					paramSetDO.setStatus(DOStatus.UPDATED);
					updateList.add(paramSetDO);
					
					has = true;
					break;
				}
			}
			
			if(!has){
				ParamSetDO setDO = createParamSetDO(tmplMap.get(key), hpId, paramMap.get(key));
				updateList.add(setDO);
			}
		}
		
		IParamsetCudServiceExt cudService = ServiceFinder.find(IParamsetCudServiceExt.class);
		cudService.saveParamSetDOs(updateList.toArray(new ParamSetDO[0]));
	}
	
	/**
	 * 删除参数
	 * @param hpId 医保产品id
	 * @param paramCodes 参数编码集合
	 * @throws BizException
	 */
	public static void delete(String hpId, String[] paramCodes) throws BizException{
		
		if(StringUtil.isEmpty(hpId) || ArrayUtil.isEmpty(paramCodes)){
			throw new BizException("删除参数:入参为空");
		}
		
		DAFacade daf = new DAFacade();
		
		String sql = "delete from sys_paramset where id_instance = ? and ";
		sql += SqlUtils.getInSqlByIds("paramcode", paramCodes);
		
		SqlParam param = new SqlParam();
		param.addParam(hpId);
		
		daf.execUpdate(sql, param);
	}

	/**
	 * 创建参数
	 * @param tmplDO
	 * @param instanceId
	 * @param value
	 * @return
	 */
	private static ParamSetDO createParamSetDO(ParamTmplSetDO tmplDO, String instanceId, String value) {

		ParamSetDO paramSetDO = new ParamSetDO();
		paramSetDO.setId_paramtmplset(tmplDO.getId_paramtmplset());
		paramSetDO.setValue(value);
		paramSetDO.setId_org(Context.get().getOrgId());
		paramSetDO.setParamcode(tmplDO.getParamcode());
		paramSetDO.setParamname(tmplDO.getParamname());
		paramSetDO.setIseditable(FBoolean.TRUE);
		paramSetDO.setIsctldownlevel(FBoolean.FALSE);
		paramSetDO.setDatafromtype(0);
		paramSetDO.setId_instance(instanceId);
		paramSetDO.setStatus(DOStatus.NEW);
		return paramSetDO;
	}
}
