package iih.sc.apt.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.en.pv.i.IEnOutQryService;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.i.IScBdOutQryService;
import iih.sc.scbd.i.IScDaysLotService;
import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.reg.dto.d.RegResDTO;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.mysql.jdbc.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取患者门诊已预约资源 默认加载标准价格，如果已经结算，加载的是结算价格
 * 
 * @author yank
 *
 */
public class GetOpAptedListBP {
	/**
	 * 获取已预约资源 默认加载标准价格，如果已经结算，加载的是结算价格
	 * 
	 * @param patId
	 *            患者id
	 * @param dt_begin
	 *            预约起始日期
	 * @return 预约资源信息集合
	 * @throws BizException
	 */
	public OpAptDTO[] exec(String patId, FDate dt_begin,String dt_e) throws BizException {
		if (ScValidator.isEmptyIgnoreBlank(patId))
			return null;
		// 1、获取预约信息
		List<OpAptDTO> opAptList = this.getOpAptList(null, patId, dt_begin,dt_e);
		
		//2、过滤非门诊排班服务
		opAptList = this.filterBySrvId(opAptList);
		
		//3、加载资源信息
		this.loadRes(opAptList);

		if (!ListUtil.isEmpty(opAptList)) {
			return opAptList.toArray(new OpAptDTO[0]);
		}
		return null;
	}

	/**
	 * 获取已预约资源 默认加载标准价格，如果已经结算，加载的是结算价格
	 * 
	 * @param aptId
	 *            预约id
	 * @return 预约资源信息
	 * @throws BizException
	 */
	public OpAptDTO exec(String aptId) throws BizException {
		if (ScValidator.isEmptyIgnoreBlank(aptId))
			return null;
		// 1、获取预约信息
		List<OpAptDTO> opAptList = this.getOpAptList(aptId, null, null,null);
		// 2、加载资源信息
		this.loadRes(opAptList);

		if (!ListUtil.isEmpty(opAptList)) {
			return opAptList.get(0);
		}
		return null;
	}

	/**
	 * 获取门诊预约集合
	 * 
	 * @param patId
	 * @param dt_begin
	 * @return
	 * @throws BizException
	 */
	private List<OpAptDTO> getOpAptList(String aptId, String patId, FDate dt_begin,String dt_e) throws BizException {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT APT.ID_APT,APT.DT_B,APT.DT_E,APT.ID_DATESLOT ID_DAYSLOT,OP.ID_CG,");
		sqlBuilder.append("EXAPT.CODE_APT AS Code_exapt,");
		sqlBuilder.append("APT.DT_APPT,APT.ID_PAT,APT.ID_SCSRV,SCPL.ID_SCPL,");
		sqlBuilder.append("APT.ID_SCH,APT.ID_TICKS,APT.ID_TICK,APT.QUENO,");
		sqlBuilder.append("APT.ID_SCCHL,SC_CHL.NAME AS NAME_SCCHL,APT.ID_ORG_APPT,APT.ID_DEP_APPT,APT.ID_EMP_APPT,");
		sqlBuilder.append("APT.FG_PAYMENT,APT.FG_CANC,APT.DT_CANC,APT.FG_BILL,APT.SD_STATUS,APT.CODE AS CODE_APT,");
		sqlBuilder.append("APTOP.FG_EN,APTOP.ID_EN ID_ENT,FG_ADD,OP.ID_CG");
		sqlBuilder.append(" FROM SC_APT APT");
		sqlBuilder.append(" INNER JOIN SC_APT_OP APTOP ON APT.ID_APT=APTOP.ID_APT ");
		sqlBuilder.append(" LEFT JOIN EN_ENT_OP OP ON APTOP.ID_EN = OP.ID_ENT ");
		sqlBuilder.append(" LEFT JOIN SC_CHL SC_CHL ON APT.ID_SCCHL = SC_CHL.ID_SCCHL ");
		sqlBuilder.append(" LEFT JOIN SC_APT_EXCHL EXAPT ON APT.ID_APT = EXAPT.ID_APT ");
		sqlBuilder.append(" LEFT JOIN SC_SCH SCH ON SCH.ID_SCH = APT.ID_SCH ");
		sqlBuilder.append(" LEFT JOIN SC_PL SCPL ON SCPL.ID_SCPL = SCH.ID_SCPL ");
		sqlBuilder.append(" WHERE 1=1 ");

		SqlParam param = new SqlParam();
		if (ScValidator.isNotEmptyIgnoreBlank(aptId)) {
			sqlBuilder.append(" AND APT.ID_APT = ? ");
			param.addParam(aptId);
		}
		if (ScValidator.isNotEmptyIgnoreBlank(patId)) {
			sqlBuilder.append(" AND APT.ID_PAT = ? ");
			param.addParam(patId);
		}
		
		if (dt_begin != null) {
			// 当前开始时间不为空的情况下获取当前可使用的日期分组  dayslotDO中的def1会冗余返回可使用的日期
			IScDaysLotService iscdayslotservice = ServiceFinder.find(IScDaysLotService.class);
			DaysLotDO dayslot = iscdayslotservice.getNowDaysLotCross(IScDictCodeConst.SD_SCTP_OP, FBoolean.FALSE);
			// 当可使用的日期在当前时间之前时 认为午别跨天 这时需要查询前一天可使用的午别以及之后的全部数据
			if(dayslot != null && dt_begin.asBegin().compareTo(new FDate(dayslot.getDef1()).asBegin()) > 0){
				sqlBuilder.append(" AND ( (SUBSTR(APT.DT_B,0,10) = ? AND SCH.ID_DAYSLOT = ?) OR SUBSTR(APT.DT_B,0,10) > ? ) ");
				param.addParam(dayslot.getDef1());
				param.addParam(dayslot.getId_dayslot());
				param.addParam(dayslot.getDef1());
			}else{
			sqlBuilder.append(" AND SUBSTR(APT.DT_B,0,10)>=? ");
				param.addParam(dayslot.getDef1());
			}
		}
		if(!StringUtils.isNullOrEmpty(dt_e)){
			FDate dt_end = new FDate().fromPersisted(dt_e);
			sqlBuilder.append(" AND SUBSTR(APT.DT_B,0,10) <= ? ");
			param.addParam(dt_end);
		}
		// 按就诊开始时间排序
		sqlBuilder.append(" ORDER BY APT.DT_B ");

		DAFacade daf = new DAFacade();
		List<OpAptDTO> aptDTOList = (List<OpAptDTO>) daf.execQuery(sqlBuilder.toString(), param, new BeanListHandler(OpAptDTO.class));

		return aptDTOList;
	}

	/**
	 * 加载资源
	 * 
	 * @param aptDTOList
	 * @throws BizException
	 */
	private void loadRes(List<OpAptDTO> aptDTOList) throws BizException {
		if (ListUtil.isEmpty(aptDTOList)) {
			return;
		}
		IScSchOutQryService schService = ServiceFinder.find(IScSchOutQryService.class);
		IEnOutQryService qryService = ServiceFinder.find(IEnOutQryService.class);
		for (OpAptDTO aptDTO : aptDTOList) {
			RegResDTO resDTO = schService.getRegRes4Apt(aptDTO.getId_apt(), FBoolean.TRUE);
			if (resDTO != null) {
				if (FBoolean.TRUE.equals(aptDTO.getFg_payment())) {
					qryService.loadResPri4Apt(aptDTO.getId_ent(), resDTO);// TODO
																			// 后续优化
					resDTO.setAmt_orig(resDTO.getAmt());
				}
				FArrayList resArray = new FArrayList();
				resArray.add(resDTO);
				aptDTO.setRegresarray(resArray);
			}
		}
	}
	
	/**
	 * 过滤非门诊排班服务
	 * 
	 * @param opPatApts
	 * @return
	 * @throws BizException 
	 */
	private List<OpAptDTO> filterBySrvId(List<OpAptDTO> opAptDTOs) throws BizException {
		if (ListUtil.isEmpty(opAptDTOs))
			return null;
		IScBdOutQryService serv = ServiceFinder.find(IScBdOutQryService.class);
		String scsrvIds = serv.getScsrvIdsNoOpSch();
		if(ScValidator.isEmptyIgnoreBlank(scsrvIds))
			return opAptDTOs;
		List<OpAptDTO> list = new LinkedList<>();
		for(OpAptDTO opAptDTO : opAptDTOs){
			if(scsrvIds.contains(opAptDTO.getId_scsrv()))
				continue;
			list.add(opAptDTO);
		}
		return list;
	}

}
