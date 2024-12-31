package iih.en.que.s.bp.mt;

import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.que.i.IQueRService;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.TriagePatInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.util.AgeCalcUtil;
/***
 * 根据站点id和午别id获取通用队列患者信息
 * @author fanlq
 * @date: 2020年2月22日 下午2:20:02
 */
public class GetPatInfoByQueSiteIdBP {

	/***
	 * @Description:根据站点id和午别id获取通用队列患者信息
	 * @param id_quesite
	 * @param id_dayslot
	 * @return
	 * @throws BizException
	 */
	public TriagePatInfoDTO[] exec(String id_quesite,String id_que,String sd_acpt_status,String id_dayslot) throws BizException{
		StringBuffer sql = new StringBuffer();
		SqlParam param = new SqlParam();
		sql.append("SELECT PAT.ID_PAT AS ID_PAT, ");
		sql.append("EQ.SD_STATUS_ACPT,");
		sql.append("PAT.CODE AS CODE_PAT, ");
		sql.append("EQ.NAME_PAT AS NAME_PAT, ");
		sql.append("EQ.ID_QUEBEN AS ID_BEN, ");
		sql.append("BEN.NAME AS NAME_BEN, ");
		sql.append("SIT.ID_QUESITE AS ID_SITE, ");
		sql.append("SIT.CODE AS SD_SITE, ");
		sql.append("SIT.NAME AS NAME_SITE, ");
		sql.append("EQ.SD_STATUS_ACPT AS SD_STATUS, ");
		sql.append("SIT.EU_PAUSE AS SD_STATUS_SITE, ");
		sql.append("EQ.SORTNO AS SORTNO, ");
		sql.append("EQ.DT_IN AS DT_IN, ");
		sql.append("PAT.DT_BIRTH AS DT_BIRTHDAY, ");
		sql.append("SEX.NAME AS NAME_SEX, ");
		sql.append("EQ.LEVEL_PRI AS LEVEL_PRI, ");
		sql.append("EQ.LEVEL_PRI_RSN AS LEVEL_PRI_RSN, ");
		sql.append("EQ.ID_QUE AS ID_QUE, ");
		sql.append("QUE.NAME AS NAME_QUE, ");
		sql.append("EQ.ID_ENT_QUE AS ID_ENT_QUE, ");
		sql.append("EQ.ID_DATESLOT AS ID_DAYSLOT, ");
		sql.append("LOT.CODE AS SD_DAYSLOT, ");
		sql.append("LOT.NAME AS NAME_DAYSLOT ");
		sql.append("FROM EN_ENT_QUE EQ ");
		sql.append("INNER JOIN PI_PAT PAT ON PAT.ID_PAT = EQ.ID_PAT ");
		sql.append("INNER JOIN BD_UDIDOC SEX ON SEX.ID_UDIDOC = PAT.ID_SEX ");
		sql.append("INNER JOIN BD_QUE_BEN BEN ON BEN.ID_QUEBEN = EQ.ID_QUEBEN ");
		sql.append("INNER JOIN BD_DAYSLOT LOT ON LOT.ID_DAYSLOT = EQ.ID_DATESLOT ");
		sql.append("LEFT JOIN BD_QUE_SITE SIT ON SIT.ID_QUESITE = EQ.ID_QUE_SITE ");
		sql.append("LEFT JOIN BD_QUE QUE ON QUE.ID_QUE = EQ.ID_QUE ");
		sql.append("WHERE EQ.ID_QUE_SITE = ? ");
		sql.append("AND substr(EQ.DT_IN,0,10) = ? ");
		sql.append("AND EQ.SD_ENTQUE_TP = ? ");
		sql.append("AND EQ.ID_DATESLOT = ? ");
		sql.append("AND EQ.FG_ACTIVE = 'Y' ");
		param.addParam(id_quesite);
		param.addParam(EnAppUtils.getServerDate());
		param.addParam(IBdFcDictCodeConst.SD_QUETP_OTHER);
		param.addParam(id_dayslot);
		if(!EnValidator.isEmpty(sd_acpt_status)){
			sql.append("AND EQ.SD_STATUS_ACPT = ? ");
			param.addParam(sd_acpt_status);
		}
		IQueRService queService = ServiceFinder.find(IQueRService.class);
		QueDO queDO= queService.findById(id_que);
		if(queDO.getEu_sorttp() == null)
		{
			sql.append("  order by eq.level_pri desc,eq.dt_in ASC");
		}
		else if(queDO.getEu_sorttp().equals(0))//预约顺序号
		{
			sql.append("  order by eq.level_pri desc,eq.sortno ASC");
		}
		else if(queDO.getEu_sorttp().equals(1))//签到时间
		{
			sql.append("  order by eq.level_pri desc,eq.dt_in ASC");
		}else{
			sql.append("ORDER BY EQ.ID_DATESLOT,EQ.SORTNO ");
		}
		@SuppressWarnings("unchecked")
		List<TriagePatInfoDTO> list = (List<TriagePatInfoDTO>) new DAFacade().execQuery(sql.toString(), param,
				new BeanListHandler(TriagePatInfoDTO.class));
		if(!EnValidator.isEmpty(list)){
			for(TriagePatInfoDTO dto : list){
				dto.setAge(AgeCalcUtil.getAge(dto.getDt_birthday()));
				this.setNameStatus(dto);
			}
			return list.toArray(new TriagePatInfoDTO[]{});
		}
		return null;
	}
	/***
	 * @Description:设置就诊状态
	 * @param triagePatInfoDTO
	 */
	private void setNameStatus(TriagePatInfoDTO triagePatInfoDTO){
		if(!EnValidator.isEmpty(triagePatInfoDTO.getSd_status())){
			switch(triagePatInfoDTO.getSd_status()){
				case IEnDictCodeConst.SD_STATUS_ACPT_FINCHECKED:
					triagePatInfoDTO.setName_status("处必");
					break;
				case IEnDictCodeConst.SD_STATUS_ACPT_CHECKED:
					triagePatInfoDTO.setName_status("处置");
					break;
				case IEnDictCodeConst.SD_STATUS_ACPT_CALLBUTNOTCOME:
					triagePatInfoDTO.setName_status("过号");
					break;
				case IEnDictCodeConst.SD_STATUS_ACPT_CALL:
					triagePatInfoDTO.setName_status("叫号");
					break;
				case IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT:
					if(!EnValidator.isEmpty(triagePatInfoDTO.getId_site()))
						triagePatInfoDTO.setName_status("分诊");
					else
						triagePatInfoDTO.setName_status("到诊");
					break;
			}
		}
	}
}
