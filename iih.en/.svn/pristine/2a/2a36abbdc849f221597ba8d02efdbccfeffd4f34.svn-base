package iih.en.comm.ep;

import iih.bd.res.dayslot.d.DaysLotDO;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.OpRegDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 午别Ep
 * @author fanlq
 * @date: 2019年10月28日 下午1:59:41
 */
public class DayslotEP {

	/***
	 * @Description:通过就诊id获取挂号午别
	 * @param id_ent
	 * @return
	 * @throws BizException 
	 */
	public DaysLotDO getDayslotByEntId(String id_ent) throws BizException{
		if(EnValidator.isEmpty(id_ent)) return null;
		StringBuffer sql = new StringBuffer();
		SqlParam param = new SqlParam();
		sql.append("select lot.* from en_ent_op op ");
		sql.append("inner join bd_dayslot lot on lot.id_dayslot = op.id_dateslot ");
		sql.append("where op.id_ent = ? ");
		param.addParam(id_ent);
		@SuppressWarnings("unchecked")
		List<DaysLotDO> daysLotDOs = (List<DaysLotDO>) new DAFacade().execQuery(sql.toString(),param, new BeanListHandler(DaysLotDO.class));
		return daysLotDOs != null && daysLotDOs.size() > 0 ? daysLotDOs.get(0): null;
	}
	/***
	 * @Description:通过就诊id获取挂号午别map
	 * @param id_ents
	 * @return
	 * @throws DAException
	 */
	public Map<String,OpRegDTO> getDayslotMapByEntId(String[] id_ents) throws DAException {
		if(id_ents == null || id_ents.length <= 0) return null;
		Map<String,OpRegDTO> map = new HashMap<String,OpRegDTO>();
		StringBuffer sql = new StringBuffer();
		sql.append("select op.id_ent,lot.id_dayslot Id_dateslot,lot.name Name_dateslot from en_ent_op op ");
		sql.append("inner join bd_dayslot lot on lot.id_dayslot = op.id_dateslot ");
		sql.append("where ");
		sql.append(EnSqlUtils.getInSqlByIds("op.id_ent ", id_ents));
		@SuppressWarnings("unchecked")
		List<OpRegDTO> daysLotDOs = (List<OpRegDTO>) new DAFacade().execQuery(sql.toString(), new BeanListHandler(OpRegDTO.class));
		if(daysLotDOs != null && daysLotDOs.size() > 0){
			for(OpRegDTO opreg : daysLotDOs){
				if(!EnValidator.isEmpty(opreg.getId_ent()) && !map.containsKey(opreg.getId_ent())){
					map.put(opreg.getId_ent(), opreg);
				}
			}
		}
		return map;
	}
}
