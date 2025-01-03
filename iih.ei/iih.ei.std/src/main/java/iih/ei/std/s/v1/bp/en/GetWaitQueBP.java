package iih.ei.std.s.v1.bp.en;

import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.bd.base.utils.ArrayListUtil;
import iih.bd.base.utils.FBooleanUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;
import iih.ei.std.d.v1.en.opwaitque.d.OpWaitQueDTO;
import iih.ei.std.d.v1.en.opwaitque.d.OpWaitQueParamDTO;
import iih.ei.std.d.v1.en.opwaitque.d.OpWaitQueResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.common.DaysLotEP;
import iih.ei.std.s.v1.bp.common.EiParamUtils;
import iih.ei.std.s.v1.bp.common.PatEP;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.pi.reg.pat.d.PatDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 获取患者候诊队列  BP
 * 
 * @author li.wm
 */
public class GetWaitQueBP extends IIHServiceBaseBP<OpWaitQueParamDTO, OpWaitQueResultDTO> {
	
	/***
	 * 入参校验
	 */
	@Override
	protected void checkParam(OpWaitQueParamDTO param) throws BizException {
		if(StringUtils.isNullOrEmpty(param.getCode_pat())){
			throw new BizException("患者编码不能为空！");
		}
		if(StringUtils.isNullOrEmpty(param.getTimes_op())){
			throw new BizException("就诊次数不能为空");
		}
		if (param.getPageinfo() == null || param.getPageinfo().size() <= 0) {
			throw new BizException("未传入分页信息！");
		}
	}

	/***
	 * 核心处理
	 */
	@Override
	protected OpWaitQueResultDTO process(OpWaitQueParamDTO param) throws BizException {
		OpWaitQueResultDTO resultDTO = new OpWaitQueResultDTO();
		PageInfoDTO pageInfoDto = (PageInfoDTO) param.getPageinfo().get(0);
		//1.校验患者是否存在
		PatDO patDO = new PatEP().getPatByCode(param.getCode_pat());
		if(patDO == null){
			throw new BizException("在IIH中未查询到该编码对应的患者！患者编码为："+param.getCode_pat());
		}
		//2.校验午别
		DaysLotDO dayslot = new DaysLotEP().getCurDaysLot();
		if(dayslot == null){
			throw new BizException("未获取到到当前午别！");
		}
		//3.校验就诊队列
		EnQueueDO enQue = this.getEnQue(param,dayslot,patDO.getId_pat());
		if(enQue == null) {
			throw new BizException("未获取到该患者就诊队列！患者编码为："+ param.getCode_pat());
		}
		if(FBoolean.FALSE.equals(enQue.getId_que_site())){
			if(StringUtils.isNullOrEmpty(enQue.getId_que_site())){
				throw new BizException("患者还未分诊到医生站点！");
			}
		}
		//4.获取候诊队列
		SqlParam sqlParam = new SqlParam();
		String sql = getSql(param,enQue, sqlParam);
		List<OpWaitQueDTO> list  = this.findPagingData(pageInfoDto, sql, sqlParam, OpWaitQueDTO.class);
		if(list == null || list.size() <= 0){
			throw new BizException("未获取到该患者侯诊队列！");
		}
		//5.返回值设置分页信息
		setPageInfo(pageInfoDto,resultDTO);
		resultDTO.setOpwaitque(ArrayListUtil.ConvertToFArrayList(list));
		return resultDTO;
	}
	
	/***
	 * @Description:获取患者候诊队列
	 * @param enQue
	 * @param sqlParam
	 * @return
	 */
	private String getSql(OpWaitQueParamDTO param,EnQueueDO enQue, SqlParam sqlParam) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ROWNUM AS ROW_NUMBER,");
		sb.append("EN_ENT_OP.TICKETNO AS CODE_TICKET,");
		sb.append("PI_PAT.CODE AS CODE_PAT,");
		sb.append("PI_PAT.NAME AS NAME_PAT,");
		sb.append("EN_ENT_OP.TIMES_OP AS TIMES_OP,");
		sb.append("EN_ENT_QUE.ID_ENT AS ID_ENT, ");
		sb.append("EN_ENT.CODE AS CODE_ENT,");
		sb.append("BD_QUE_SITE.ROOM || BD_QUE_SITE.NAME AS ROOM_ENT, ");
		sb.append("EN_ENT_QUE.SORTNO_CALLED AS SORTNO_CALLED, ");
		sb.append("EN_ENT_OP.SD_STATUS AS CODE_ENTSTATUS,");
		sb.append("EN_ENT_QUE.SD_STATUS_ACPT AS CODE_QUESTATUS,");
		sb.append("EN_ENT_QUE.ID_QUE_SITE AS ID_QUE_SITE,");
		sb.append("EN_ENT.DT_BIRTH_PAT AS DT_BIRTH_PAT,");
		sb.append("EN_ENT_QUE.LEVEL_PRI AS LEVEL_PRI,");
		sb.append("EN_ENT_QUE.ID_ENT_QUE AS ID_ENT_QUE,");
		sb.append("EN_ENT_OP.FG_NEEDRTN AS FG_RTN, ");
		sb.append(" CASE WHEN EN_ENT_QUE.ID_QUE_SITE IS NOT NULL AND  EN_ENT_QUE.SD_STATUS_ACPT = '0' THEN 'Y' ELSE 'N'  END AS FG_WAIT ");
		sb.append("FROM EN_ENT_QUE EN_ENT_QUE ");
		sb.append("INNER JOIN EN_ENT EN_ENT ON EN_ENT_QUE.ID_ENT = EN_ENT.ID_ENT ");
		sb.append("INNER JOIN EN_ENT_OP EN_ENT_OP ON EN_ENT_QUE.ID_ENT = EN_ENT_OP.ID_ENT ");
		sb.append("INNER JOIN PI_PAT PI_PAT ON EN_ENT.ID_PAT = PI_PAT.ID_PAT ");
		sb.append("LEFT JOIN BD_QUE_SITE BD_QUE_SITE ON EN_ENT_QUE.ID_QUE_SITE = BD_QUE_SITE.ID_QUESITE ");
		sb.append("WHERE EN_ENT_QUE.SD_ENTQUE_TP = ? ");
		sb.append("AND EN_ENT_QUE.FG_ACTIVE = ? ");
		if(FBoolean.TRUE.toString().equals(param.getFg_all())){
			sb.append("AND EN_ENT_QUE.ID_QUE = ? ");
		}
		
		sb.append("AND EN_ENT_QUE.DT_REGIST = ? ");
		sb.append("AND EN_ENT_QUE.ID_DATESLOT = ? ");
		sb.append("AND EN_ENT.FG_CANC = ? ");
		sqlParam.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		sqlParam.addParam(FBoolean.TRUE);
		if(FBoolean.TRUE.toString().equals(param.getFg_all())){
			sqlParam.addParam(enQue.getId_que());
		}
		
		sqlParam.addParam(enQue.getDt_regist());
		sqlParam.addParam(enQue.getId_dateslot());
		sqlParam.addParam(FBoolean.FALSE);
		if(!StringUtils.isNullOrEmpty(enQue.getId_que_site())&& FBooleanUtils.isNullOrFalse(new FBoolean(param.getFg_all()))){
			sb.append("AND EN_ENT_QUE.ID_QUE_SITE = ? ");
			sqlParam.addParam(enQue.getId_que_site());
		}
		sb.append("ORDER BY EN_ENT_QUE.SORTNO_CALLED, EN_ENT_QUE.LEVEL_PRI DESC, EN_ENT_QUE.SORTNO ");
		return sb.toString();
	}
	
	/**
	 * 获取患者就诊队列
	 * 
	 * @param patId 患者ID
	 * @param deptCode 科室编码
	 * @param opTimes 就诊次数
	 * @return
	 * @throws BizException 
	 */
	private EnQueueDO getEnQue(OpWaitQueParamDTO param,DaysLotDO dayslot,String id_pat) throws BizException{
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT EN_ENT_QUE.* ");
		sb.append("FROM EN_ENT_QUE EN_ENT_QUE ");
		sb.append("INNER JOIN EN_ENT EN_ENT ON EN_ENT_QUE.ID_ENT = EN_ENT.ID_ENT ");
		sb.append("INNER JOIN EN_ENT_OP EN_ENT_OP ON EN_ENT_QUE.ID_ENT = EN_ENT_OP.ID_ENT ");
		sb.append("INNER JOIN PI_PAT PI_PAT ON EN_ENT.ID_PAT = PI_PAT.ID_PAT ");
		sb.append("LEFT JOIN SC_APT SC_APT ON EN_ENT_OP.ID_SCHAPT = SC_APT.ID_APT ");
		sb.append("LEFT JOIN SC_APT_OP SC_APT_OP ON SC_APT.ID_APT = SC_APT_OP.ID_APT ");
		sb.append("WHERE EN_ENT_QUE.SD_ENTQUE_TP = ? ");
		sb.append("AND EN_ENT_QUE.FG_ACTIVE = ? ");
		sb.append("AND PI_PAT.ID_PAT = ? ");
		sb.append("AND EN_ENT_OP.TIMES_OP = ? ");
		sb.append("AND EN_ENT_QUE.ID_DATESLOT = ? ");	
		if(EiParamUtils.getAptNeedCfm()){
			sb.append("AND EN_ENT_OP.SD_STATUS IN (?, ?,?) ");
			sb.append("AND EN_ENT_QUE.SD_STATUS_ACPT IN (?,?,?) ");
		}else{
			sb.append("AND EN_ENT_QUE.SD_STATUS_ACPT <>? ");
		}
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		sqlParam.addParam(FBoolean.TRUE);
		sqlParam.addParam(id_pat);
		sqlParam.addParam(param.getTimes_op());
		sqlParam.addParam(dayslot.getId_dayslot());
		if(EiParamUtils.getAptNeedCfm()){
			sqlParam.addParam(IEnDictCodeConst.SD_ENSTATUS_OP_REGISTER);
			sqlParam.addParam(IEnDictCodeConst.SD_ENSTATUS_OP_ENCOUNTER);
			sqlParam.addParam(IEnDictCodeConst.SD_ENSTATUS_OP_FINISH);
			sqlParam.addParam(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
			sqlParam.addParam(IEnDictCodeConst.SD_STATUS_ACPT_CALL);
			sqlParam.addParam(IEnDictCodeConst.SD_STATUS_ACPT_CALLBUTNOTCOME);
		}
		else{
			sqlParam.addParam(IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED);
		}
		@SuppressWarnings("unchecked")
		List<EnQueueDO> list =(List<EnQueueDO>) new DAFacade().execQuery(sb.toString(),sqlParam,new BeanListHandler(EnQueueDO.class));	
		return ListUtil.isEmpty(list) ? null:list.toArray(new EnQueueDO[]{})[0];
	}
	/***
	 * @Description:设置分页信息
	 * @param pageInfoDto
	 * @param resultDto
	 */
	@SuppressWarnings("unchecked")
	private void setPageInfo(PageInfoDTO pageInfoDto,OpWaitQueResultDTO resultDto){
		FArrayList pageInfoList = new FArrayList();
		pageInfoList.add(pageInfoDto);
		resultDto.setPageinfo(pageInfoList);
	}
}
