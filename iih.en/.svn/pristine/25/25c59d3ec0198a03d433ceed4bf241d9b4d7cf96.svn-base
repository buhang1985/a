package iih.en.er.bp.rescue;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeTypeConst;
import iih.bd.bc.udi.pub.IMpNsDictCodeConst;
import iih.en.comm.ep.ErPreEP;
import iih.en.comm.util.DateTimeUtils;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.er.dto.d.UrgNurErInfoDTO;
import iih.en.er.pre.d.EnErPreDO;
import iih.mp.nr.foreign.d.CiorderPreviewDTO;
import iih.mp.nr.foreign.i.IForeignService;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetRescueNurErInfoBP {
	/***
	 * 获取急诊留观护士站-急诊信息 DTO数据
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException 
	 */
	public UrgNurErInfoDTO getNurErInfo(String id_ent) throws BizException{
		UrgNurErInfoDTO urgNurErInfoDTO = this.getDataBySql(id_ent);
		//获取各项评分
		this.getScore(urgNurErInfoDTO, id_ent);
		//获取体温、心率、血压信息，iih.mp.nr.foreign.i.getCiorderPreviewDTOS(String id_ent)
		this.getmpInfo(urgNurErInfoDTO, id_ent);
		//获取绿色通道
		this.getGreenChannel(urgNurErInfoDTO, id_ent);
		//过敏
		
		//滞留时长
		this.getErTimes(urgNurErInfoDTO, id_ent);
		return urgNurErInfoDTO;
	}
	
	/***
	 * 根据sql获取基本DTO数据
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException 
	 */
	private UrgNurErInfoDTO getDataBySql(String id_ent) throws BizException{
		StringBuffer sql = new StringBuffer();
		sql.append("select scale.name, ");
		sql.append("er.dt_entry as dt_entry, " );
		sql.append("er.dt_end as dt_end, " );
		sql.append("endi.name_didef_dis as  name_di, " );
		sql.append("er.ids_green_channel_sym as Ids_green_channel_sym, " );
		sql.append("er.sds_green_channel_sym as Sds_green_channel_sym " );
		sql.append("from en_ent ent " );
		sql.append("inner join en_ent_op op on op.id_ent = ent.id_ent " );
		sql.append("left join en_ent_op_er oper on oper.id_ent = ent.id_ent " );
		sql.append("left join bd_udidoc scale on scale.id_udidoc = oper.id_scale_triage " );
		sql.append("left join en_erpre er on er.id_erpre = oper.id_erpre " );
		sql.append("left join en_ent_di endi " );
		sql.append("on endi.id_ent = ent.id_ent and endi.fg_maj = 'Y'" );
		sql.append("left join en_erpre_score score on score.id_erpre = oper.id_erpre " );
		sql.append("left join bd_udidoc sco on sco.code = score.sd_scotp and sco.id_udidoclist in (select id_udidoclist from bd_udidoclist where code = ? ) " );
		sql.append("where ent.code_entp = ? ");
		sql.append("and ent.id_ent = ? ");
		SqlParam param = new SqlParam();
		param.addParam(IEnDictCodeTypeConst.SD_ERPRE_SCOTP);
		param.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID);
		param.addParam(id_ent);
		@SuppressWarnings("unchecked")
		List<UrgNurErInfoDTO> list = (List<UrgNurErInfoDTO>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(UrgNurErInfoDTO.class));
		if(list != null && list.size() > 0){
			UrgNurErInfoDTO[] urgNurErInfoDTOs = list.toArray(new UrgNurErInfoDTO[0]);
			return urgNurErInfoDTOs[0];
		}
		return new UrgNurErInfoDTO();
	}
	/***
	 * 设置评分
	 * @param urgNurErInfoDTO
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	private UrgNurErInfoDTO getScore(UrgNurErInfoDTO urgNurErInfoDTO,String id_ent) throws BizException{
		StringBuffer sql = new StringBuffer();
		sql.append("select oper.sd_scale_triage as Sd_level,");
		sql.append("scale_triage.shortname as Name_level,");
		sql.append("sco.code as Sd_scoretp, " );
		sql.append("sco.name as Name_scoretp, " );
		sql.append("score.score as Score " );
		sql.append("from en_ent ent " );
		sql.append("inner join en_ent_op op on op.id_ent = ent.id_ent " );
		sql.append("left join en_ent_op_er oper on oper.id_ent = ent.id_ent " );
		sql.append("left join en_erpre_score score on score.id_erpre = oper.id_erpre " );
		sql.append("left join bd_udidoc sco on sco.code = score.sd_scotp and sco.id_udidoclist in (select id_udidoclist from bd_udidoclist where code = ? ) " );
		sql.append("left join bd_udidoc scale_triage on oper.id_scale_triage = scale_triage.id_udidoc ");
		sql.append("where ent.code_entp = ? ");
		sql.append("and ent.id_ent = ? ");
		SqlParam param = new SqlParam();
		param.addParam(IEnDictCodeTypeConst.SD_ERPRE_SCOTP);
		param.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID);
		param.addParam(id_ent);
		@SuppressWarnings("unchecked")
		List<UrgNurErInfoDTO> list = (List<UrgNurErInfoDTO>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(UrgNurErInfoDTO.class));
		if(list != null && list.size() > 0){
			FMap map = new FMap();
			for(UrgNurErInfoDTO dto : list){
				if(map != null && map.containsKey(dto.getName_scoretp())){
					map.put(dto.getName_scoretp(),dto.getScore());
				}
				urgNurErInfoDTO.setSd_level(dto.getSd_level());
				urgNurErInfoDTO.setName_level(dto.getName_level());
			}
			urgNurErInfoDTO.setErscoremap(map);
			return urgNurErInfoDTO;
		}
		return new UrgNurErInfoDTO();
	}
	
	/**
	 * 护理信息
	 * 
	 * @param detailDTO
	 * @throws BizException
	 */
	private void getmpInfo(UrgNurErInfoDTO urgNurErInfoDTO,String id_ent) throws BizException {
		IForeignService foreign = ServiceFinder.find(IForeignService.class);
		CiorderPreviewDTO[] ciorders = foreign.getCiorderPreviewDTOS(id_ent);
		if (EnValidator.isEmpty(ciorders)) {
			return;
		}
		for (CiorderPreviewDTO cider : ciorders) {
			// 体温
			if (!EnValidator.isEmpty(cider.getCode())
					&& cider.getCode().equals(
							IMpNsDictCodeConst.SD_TEMPERATURE_SRVVT)) {
				urgNurErInfoDTO.setTemperature(cider.getValue());
			}
			// 心率
			if (!EnValidator.isEmpty(cider.getCode())
					&& cider.getCode().equals(IMpNsDictCodeConst.SD_HEART_SRVVT)) {
				urgNurErInfoDTO.setHeart_rate(cider.getValue());
			}
			// 血压
			if (!EnValidator.isEmpty(cider.getCode())
					&& cider.getCode().equals(
							IMpNsDictCodeConst.SD_PRESSURE_SRVVT)) {
				urgNurErInfoDTO.setBlood_pressure(cider.getValue());
			}
		}
	}
	
	/***
	 * 获取绿色通道信息
	 * 
	 * @param urgNurErInfoDTO
	 * @param id_ent
	 * @throws BizException 
	 */
	private void getGreenChannel(UrgNurErInfoDTO urgNurErInfoDTO,String id_ent) throws BizException{
		StringBuffer sql = new StringBuffer();
		sql.append("select er.* ");
		sql.append("from en_erpre er " );
		sql.append("inner join en_ent_op_er oper on  oper.id_erpre = er.id_erpre " );
		sql.append("where oper.id_ent = '"+id_ent+"' ");
		@SuppressWarnings("unchecked")
		List<EnErPreDO> list = (List<EnErPreDO>) new DAFacade().execQuery(sql.toString(), new BeanListHandler(EnErPreDO.class));
		if(list != null && list.size() > 0){
			EnErPreDO[] enErPreDOs = list.toArray(new EnErPreDO[0]);
			ErPreEP ep = new ErPreEP();
			ep.setGreenNames(enErPreDOs,EnErPreDO.IDS_GREEN_CHANNEL_SYM,EnErPreDO.NAMES_GREEN_CHANNEL);
			urgNurErInfoDTO.setGreen_channel(enErPreDOs[0].getNames_green_channel());
		}
	}
	
	/**
	 * 获取滞留时长
	 * 
	 * @param urgNurErInfoDTO
	 * @param id_ent
	 */
	private void getErTimes(UrgNurErInfoDTO urgNurErInfoDTO,String id_ent){
		FDateTime datetime = EnAppUtils.getServerDateTime();
		String erTimes = null;
		if(urgNurErInfoDTO != null && urgNurErInfoDTO.getDt_entry() != null){
			if(urgNurErInfoDTO.getDt_end() != null){
				erTimes = DateTimeUtils.getTimeLength(urgNurErInfoDTO.getDt_entry(),urgNurErInfoDTO.getDt_end());
			}else{
				erTimes = DateTimeUtils.getTimeLength(urgNurErInfoDTO.getDt_entry(),datetime);
			}
			urgNurErInfoDTO.setTimes(erTimes);
		}
	}
}
