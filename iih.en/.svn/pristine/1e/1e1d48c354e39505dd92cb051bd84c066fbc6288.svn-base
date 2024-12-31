package iih.en.comm.ep;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.fc.enstate.d.BdEnStateDO;
import iih.bd.fc.enstate.d.desc.BdEnStateDODesc;
import iih.bd.fc.enstate.i.IEnstateRService;
import iih.bd.fc.enstatetpext.d.BdEnStateTpExtDO;
import iih.bd.fc.enstatetpext.d.desc.BdEnStateTpExtDODesc;
import iih.bd.fc.enstatetpext.i.IBdenstatetpextRService;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.enclin.d.EntStateDO;
import iih.en.pv.enclin.d.desc.EntStateDODesc;
import iih.en.pv.enclin.i.IEntstateCudService;
import iih.en.pv.enclin.i.IEntstateRService;
import iih.sc.pub.ScGroupControlUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.TransactionStatus;

import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.TmpTableFactory;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocServiceExt;

/**
 * 就诊状况扩展
 * @author renying
 *
 */
public class EntStateEP {	
	
	/**
	 * 查询就诊状况定义
	 * <就诊状况类型, <就诊状况值, 就诊状况定义>>
	 * @param entstatetps
	 * @return
	 * @throws BizException
	 */
	public Map<String, Map<String, BdEnStateDO>> getBdEnStateMap(String[] entstatetps) throws BizException{
		if(EnValidator.isEmpty(entstatetps))
			return null;
		IEnstateRService serv = ServiceFinder.find(IEnstateRService.class);
		BdEnStateDO[] bdEnStateDOs = serv.findByAttrValStrings(BdEnStateDO.SD_ENSTATETP, entstatetps);
		if(EnValidator.isEmpty(bdEnStateDOs))
			return null;
		Map<String, Map<String, BdEnStateDO>> map = new HashMap<String, Map<String,BdEnStateDO>>();
		for(BdEnStateDO bdEnStateDO : bdEnStateDOs){
			if(!FBoolean.TRUE.equals(bdEnStateDO.getFg_active()))
				continue;
			if(map.containsKey(bdEnStateDO.getSd_enstatetp()))
				map.get(bdEnStateDO.getSd_enstatetp()).put(bdEnStateDO.getVal(), bdEnStateDO);
			else{
				Map<String, BdEnStateDO> m = new HashMap<String, BdEnStateDO>();
				m.put(bdEnStateDO.getVal(), bdEnStateDO);
				map.put(bdEnStateDO.getSd_enstatetp(), m);
			}
		}
		return map;
	}
	/**
	 * 获取患者就诊状况
	 * <就诊id, <就诊状况类型, 就诊状况>>
	 * 
	 * @param entIds
	 * @param entstatetps
	 * @return
	 * @throws BizException
	 */
	public Map<String,Map<String, EntStateDO>> getEntStateDOMap(final String[] entIds, final String[] entstatetps) throws BizException{
		if(EnValidator.isEmpty(entIds))
			return null;
		List<EntStateDO> entStateDOs =  TransactionExecutor.executeRequired(new TransactionalOperation<List<EntStateDO>>() {
			@Override
			public List<EntStateDO> doInTransaction(TransactionStatus status) {
				String tmpTableName = null;
			    try{
			    	// 生成临时表
				    tmpTableName = new TmpTableFactory().get(entIds);
					// 查询数据
				    return getEntStates(tmpTableName, entstatetps);
			    }catch (BizException e) {
					throw new BizRuntimeException(e.getMessage());
				}
			}
			
			@SuppressWarnings("unchecked")
			private List<EntStateDO> getEntStates(String tmpTableName, String[] entstatetps) throws BizException{
				String stateExtOrgWhere = ScGroupControlUtils.getGroupControlFitler(new BdEnStateTpExtDODesc(), "EXTSTATE");//集团管控
				StringBuilder sqlBuilder  = new StringBuilder();
				sqlBuilder.append(" SELECT ENTSTATE.*, ENT.ID_ENT, ENT.ID_PAT FROM EN_ENT_STATE ENTSTATE ");
				sqlBuilder.append(" INNER JOIN BD_EN_STATETP_EXT EXTSTATE ");
				sqlBuilder.append(" ON ENTSTATE.ID_ENSTATETP = EXTSTATE.ID_ENSTATETP AND EXTSTATE.FG_ENT = 'Y' ");
				sqlBuilder.append(" INNER JOIN ( ");
				sqlBuilder.append(" SELECT ID_ENT,ID_PAT FROM EN_ENT EN INNER JOIN ").append(tmpTableName).append(" TEMPTABLE ON EN.ID_ENT = TEMPTABLE.ID1 ");
				sqlBuilder.append(" ) ENT ON ENTSTATE.ID_ENT = ENT.ID_ENT ");
				sqlBuilder.append(" WHERE 1 =1 ");
				if(!EnValidator.isEmpty(stateExtOrgWhere)){
					sqlBuilder.append(" AND ").append(stateExtOrgWhere);
				}
				sqlBuilder.append(" UNION ");
				sqlBuilder.append(" SELECT ENTSTATE.*, ENT.ID_ENT, ENT.ID_PAT FROM EN_ENT_STATE ENTSTATE ");
				sqlBuilder.append(" INNER JOIN BD_EN_STATETP_EXT EXTSTATE ");
				sqlBuilder.append(" ON ENTSTATE.ID_ENSTATETP = EXTSTATE.ID_ENSTATETP AND EXTSTATE.FG_ENT = 'N' ");
				sqlBuilder.append(" INNER JOIN ( ");
				sqlBuilder.append(" SELECT ID_ENT,ID_PAT FROM EN_ENT EN INNER JOIN ").append(tmpTableName).append(" TEMPTABLE ON EN.ID_ENT = TEMPTABLE.ID1 ");
				sqlBuilder.append(" ) ENT ON ENTSTATE.ID_PAT = ENT.ID_PAT ");
				sqlBuilder.append(" WHERE 1 =1 ");
				if(!EnValidator.isEmpty(stateExtOrgWhere)){
					sqlBuilder.append(" AND ").append(stateExtOrgWhere);
				}
				if(!EnValidator.isEmpty(entstatetps)){
					sqlBuilder.append(" AND ").append(EnSqlUtils.getInSqlByIds("ENTSTATE.SD_ENSTATETP", entstatetps));
				}
				String sql = sqlBuilder.toString();
				return (List<EntStateDO>) new DAFacade().execQuery(sql, new xap.sys.jdbc.handler.BeanListHandler(EntStateDO.class));
			}
		});
		if(EnValidator.isEmpty(entStateDOs)){
			return null;
		}
		Map<String,Map<String, EntStateDO>> map = new HashMap<String,Map<String, EntStateDO>>();
		for(EntStateDO stateDO: entStateDOs){
			if(EnValidator.isEmpty(stateDO.getId_ent()))
				continue;
			if(map.containsKey(stateDO.getId_ent())){
			    map.get(stateDO.getId_ent()).put(stateDO.getSd_enstatetp(), stateDO);
			}
			else{
				Map<String, EntStateDO> stateMap = new HashMap<>();
				stateMap.put(stateDO.getSd_enstatetp(), stateDO);
				map.put(stateDO.getId_ent(), stateMap);
			}
		}
		return map;
	}
	/**
	 * 保存就诊状况
	 * 
	 * @param entStateDOs
	 * @return
	 * @throws BizException
	 */
	public EntStateDO[] save(EntStateDO[] entStateDOs) throws BizException {
		IEntstateCudService serv = ServiceFinder.find(IEntstateCudService.class);
		return serv.save(entStateDOs);
	}
	/**
	 * 
	 * 
	 * @param statetpCode
	 * @param code
	 * @return
	 * @throws BizException
	 */
	public UdidocDO getStateIdByVal(String statetpCode, String val) throws BizException{
		IUdidocServiceExt serv = ServiceFinder.find(IUdidocServiceExt.class);
		return serv.findByCode(statetpCode, val);
	}
	/**
	 * 获取就诊状况
	 * 
	 * @param entId
	 * @param patId
	 * @param codeEntp
	 * @return
	 * @throws BizException
	 */
	public EntStateDO[] getEntstates(String entId, String patId, String codeEntp)
			throws BizException {
		return getEntstates(entId, patId, codeEntp, null);
	} 
	/**
	 * 获取就诊状况
	 * 
	 * @param entId
	 * @param patId
	 * @param codeEntp
	 * @return
	 * @throws BizException
	 */
	public EntStateDO[] getEntstates(String entId, String patId, String codeEntp, String[] fileterStates)
			throws BizException {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT ENTSTATE.ID_ENTSTATE ");
		sqlBuilder.append(" FROM EN_ENT_STATE ENTSTATE ");
		sqlBuilder.append(" INNER JOIN BD_EN_STATETP_EXT STATEEXT ON ENTSTATE.ID_ENSTATETP = STATEEXT.ID_ENSTATETP ");
		sqlBuilder.append(" WHERE ");
		if(IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(codeEntp))
			sqlBuilder.append(" STATEEXT.FG_OP = ? ");
		else if(IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(codeEntp))
			sqlBuilder.append(" STATEEXT.FG_ER = ? ");
		else if(IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(codeEntp))
			sqlBuilder.append(" STATEEXT.FG_IP = ? ");
		else
			return null;
		if(!EnValidator.isEmpty(fileterStates)){
			sqlBuilder.append(" AND ").append(EnSqlUtils.getInSqlByIds("ENTSTATE.SD_ENSTATETP", fileterStates));
		}
		sqlBuilder.append(" AND ((STATEEXT.FG_ENT = ? AND ENTSTATE.ID_ENT = ?) OR (STATEEXT.FG_ENT = ? AND ENTSTATE.ID_PAT = ?)) ");
		String sql = sqlBuilder.toString();
		SqlParam param = new SqlParam();
		param.addParam(FBoolean.TRUE);
		param.addParam(FBoolean.TRUE);
		param.addParam(entId);
		param.addParam(FBoolean.FALSE);
		param.addParam(patId);
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
		if(EnValidator.isEmpty(list))
			return null;
		IEntstateRService serv = ServiceFinder.find(IEntstateRService.class);
		EntStateDO[] entStates = serv.findByIds(list.toArray(new String[0]), FBoolean.FALSE);
		return entStates;
	} 
	/**
	 * 获取就诊状况类型字典
	 * 
	 * @param entstatetps
	 * 	当entstatetps为null，查询全部
	 * 
	 * @return
	 * @throws BizException
	 */
	public Map<String, BdEnStateTpExtDO> getBdEnStateTpExtMap(String[] entstatetps) throws BizException {
		Map<String, BdEnStateTpExtDO> map = new HashMap<>();
		IBdenstatetpextRService serv = ServiceFinder.find(IBdenstatetpextRService.class);
		BdEnStateTpExtDO[] enStateTpExtDOs = null;
		if(EnValidator.isEmpty(entstatetps)){
			enStateTpExtDOs = serv.find("1=1", null, FBoolean.FALSE);
		}else{
			enStateTpExtDOs = serv.findByAttrValStrings(BdEnStateTpExtDO.SD_ENSTATETP, entstatetps);
		}
		if(!EnValidator.isEmpty(enStateTpExtDOs)){
			for(BdEnStateTpExtDO enStateTpExtDO : enStateTpExtDOs){
				map.put(enStateTpExtDO.getSd_enstatetp(), enStateTpExtDO);
			}
		}
		return map;
	}
	
	/**
	 * 通过类型sd，获取就诊状况类型表中的默认值 zhangpp 2019.10.25
	 * @param sdEnstatetp
	 * @return
	 * @throws BizException
	 */
	public String getEnStateDefVal(String sdEnstatetp) throws BizException{
		if (EnValidator.isEmpty(sdEnstatetp)) {
			return null;
		}
		IBdenstatetpextRService serv = ServiceFinder.find(IBdenstatetpextRService.class);
		BdEnStateTpExtDO[] enStateTpExtDOs = serv.findByAttrValString(BdEnStateTpExtDO.SD_ENSTATETP, sdEnstatetp);
		return enStateTpExtDOs[0].getDef_val();
	}
	
	/**
	 * 插入新数据到就诊状况表中  2020.1.14  zhang,zl
	 * 
	 * @param inpatient
	 * @param Dt_b
	 * @throws BizException
	 */
	public void insertEntStatus(String entId,String val, String sd_status,String id_status,FDateTime Dt_b) throws BizException {
		IEntstateRService stateRService = ServiceFinder.find(IEntstateRService.class);
		IEntstateCudService stateCudService = ServiceFinder.find(IEntstateCudService.class);
		EntStateDO[] entStateDOs = stateRService.find(EntStateDODesc.TABLE_ALIAS_NAME + ".id_ent ='" + entId + "' and " + EntStateDODesc.TABLE_ALIAS_NAME 
				+ ".sd_enstatetp ='" + sd_status + "'", "", FBoolean.FALSE);
		EntStateDO stateDO = new EntStateDO();
		if (ArrayUtil.isEmpty(entStateDOs)) {
			stateDO.setStatus(DOStatus.NEW);
			stateDO.setId_ent(entId);
			stateDO.setDt_occ(Dt_b);
		} else {
			stateDO.setStatus(DOStatus.UPDATED);
		}
		stateDO.setId_enstatetp(id_status);
		stateDO.setSd_enstatetp(sd_status);
		stateDO.setVal(val);
		IEnstateRService  rService = ServiceFinder.find(IEnstateRService.class);
		BdEnStateDO[] bdenstateDOs =  rService.find(BdEnStateDODesc.TABLE_ALIAS_NAME+".sd_enstatetp ='"+sd_status+"' and "+BdEnStateDODesc.TABLE_ALIAS_NAME+".val ='"+val+"'" , "", FBoolean.FALSE);
		if(!ArrayUtil.isEmpty(bdenstateDOs))
			stateDO.setId_entstatedef(bdenstateDOs[0].getId_enstate());
		stateCudService.save(new EntStateDO[] { stateDO });
	}
}
