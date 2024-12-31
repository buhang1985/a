package iih.en.pv.s.bp.op.ws;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.fc.queben.d.QueBenDO;
import iih.bd.fc.queben.i.IQuebenRService;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.EntInfo4BenDTO;
import iih.en.pv.outpatient.dto.d.EntRegInfoDTO;
import iih.en.pv.s.bp.GetPatIdForAp;
import iih.en.que.dto.d.TriageBenInfoDTO;
import iih.en.que.i.IEnQueQryService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 *  取患者分诊台可分诊挂号记录
 * @author Sarah
 *
 */
public class GetEntLisByQuebencodeBP {
	
	/**
	 * 取患者分诊台可分诊挂号记录
	 * @param patCode
	 * @param queBenCode
	 * @param oprCode
	 * @return
	 * @throws BizException 
	 */
	public EntRegInfoDTO[] exec(String patCode,String queBenCode,String oprCode) throws BizException {
		//记录输入参数日志，fanlq-add
		EnLogUtil.getInstance().logInfo("方法：GetEntLisByQuebencodeBP参数为:patCode:"+patCode+";queBenCode:"+queBenCode+";oprCode:"+oprCode);
				
		if (EnValidator.isEmpty(patCode) || EnValidator.isEmpty(queBenCode) || EnValidator.isEmpty(queBenCode)) {
			return null;
		}	
		//0.从chis同步患者
		GetPatIdForAp patap = new GetPatIdForAp();
		String patId = patap.exec(patCode);
		//1.获取当前分诊台信息
		TriageBenInfoDTO benInfo = this.getBenInfo(queBenCode);
		//3.查询患者对应的可分诊挂号记录
		EntInfo4BenDTO[] res = this.getPatEntInfo(patId, benInfo);
		if(EnValidator.isEmpty(res)){
			return null;
		}
		//4.包装需要的就诊信息DTO
		return this.wrapEntDTO(res);		
	}

	/**
	 * 2.获取分诊台
	 * @param queBenCode
	 * @throws BizException
	 */
	private TriageBenInfoDTO  getBenInfo(String queBenCode) throws BizException{
		IQuebenRService rService = ServiceFinder.find(IQuebenRService.class);
		QueBenDO[] bendos = rService.find(" code ='"+queBenCode+"'", "", FBoolean.FALSE);
		if(EnValidator.isEmpty(bendos)){
			throw new BizException("未获取编码为"+queBenCode+"的分诊台");
		}
		IEnQueQryService serv = ServiceFinder.find(IEnQueQryService.class);
		TriageBenInfoDTO ben =  serv.getTriageBenInfo(bendos[0].getId_queben(), IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		if(ben == null)
			throw new BizException(String.format("分诊台[%s]信息获取失败！", bendos[0].getName()));
		return ben;
	}
	
	/**
	 * 查询患者对应的可分诊挂号记录
	 * 
	 * @param patId
	 * @param benInfo
	 * @return
	 * @throws BizException 
	 */
	private EntInfo4BenDTO[] getPatEntInfo(String patId, TriageBenInfoDTO benInfo) throws BizException{
		StringBuilder sqlSb = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlSb.append(" SELECT PAT.CODE  AS PATCODE, ");
		sqlSb.append(" PAT.NAME         AS PATNAME, ");
		sqlSb.append(" EN.DT_ENTRY      AS DTENTRY, ");
		sqlSb.append(" DL.SD_DAYSLOTTP  AS DAYSLOTTP, ");
		sqlSb.append(" SR.NAME          AS RESNAME,");
		sqlSb.append(" SR.CODE          AS RESCODE, ");
		sqlSb.append(" SS.CODE          AS SRVCODE, ");
		sqlSb.append(" SS.NAME          AS SRVNAME, ");
		sqlSb.append(" CHL.CODE         AS CHLTYPE, ");
		sqlSb.append(" DEP.CODE         AS DEPTCODE,");
		sqlSb.append(" DEP.NAME         AS DEPTNAME,");
		sqlSb.append(" OP.TIMES_OP      AS TIMESOP,");
		sqlSb.append(" OP.TICKETNO      AS Ticketno,");
		sqlSb.append(" EN.DT_INSERT     AS OPRDATE,");
		sqlSb.append(" PAT.ID_CODE      AS IDCODE,");
		sqlSb.append(" PAT.SD_IDTP      AS IDTP,");
		sqlSb.append(" PAT.BARCODE_CHIS AS BARCODE,");
		sqlSb.append(" PAT.SD_SEX       AS SEX,");
		sqlSb.append(" PAT.DT_BIRTH, ");
		sqlSb.append(" OP.SD_STATUS,");
		sqlSb.append(" QUE.SD_STATUS_ACPT, ");
		sqlSb.append(" QUE.ID_QUE_SITE, ");
		sqlSb.append(" QUE.SORTNO_CALLED ");
	    sqlSb.append(" FROM EN_ENT EN");
	    sqlSb.append(" INNER JOIN PI_PAT PAT ON PAT.ID_PAT = EN.ID_PAT ");
	    sqlSb.append(" INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT ");
	    sqlSb.append(" INNER JOIN EN_ENT_QUE QUE ON QUE.ID_ENT = EN.ID_ENT ");
	    sqlSb.append(" INNER JOIN SC_SCH SCH ON OP.ID_SCH = SCH.ID_SCH ");
	    sqlSb.append(" INNER JOIN SC_PL PL ON SCH.ID_SCPL = PL.ID_SCPL ");
	    sqlSb.append(" LEFT OUTER JOIN SC_RES SR ON OP.ID_SCRES = SR.ID_SCRES ");
	    sqlSb.append(" LEFT OUTER JOIN SC_SRV SS ON OP.ID_SCSRV = SS.ID_SCSRV ");
	    sqlSb.append(" LEFT JOIN SC_APT APT ON OP.ID_SCHAPT = APT.ID_APT ");
	    sqlSb.append(" LEFT JOIN SC_CHL CHL ON APT.ID_SCCHL = CHL.ID_SCCHL ");
	    sqlSb.append(" LEFT OUTER JOIN BD_DEP DEP ON EN.ID_DEP_PHY = DEP.ID_DEP ");
	    sqlSb.append(" LEFT OUTER JOIN BD_DAYSLOT DL ON SCH.ID_DAYSLOT = DL.ID_DAYSLOT ");
	    sqlSb.append(" WHERE PAT.ID_PAT = ?");
	    param.addParam(patId);
	    sqlSb.append(" AND PL.ID_QUEBEN = ?");
	    param.addParam(benInfo.getId_queben());
	    sqlSb.append(" AND QUE.SD_ENTQUE_TP = ?");
	    param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
	    FDateTime curDateTime = EnAppUtils.getAcptQryDateTime(benInfo.getDate(), benInfo.getId_dayslot());
	    sqlSb.append(" AND OP.DT_VALID_B <= ?");
	    sqlSb.append(" AND OP.DT_VALID_E >= ?");
	    param.addParam(curDateTime);
	    param.addParam(curDateTime);
	    sqlSb.append(" AND EN.FG_CANC='N'");
		List<EntInfo4BenDTO> patEntInfos = (List<EntInfo4BenDTO>) new DAFacade().execQuery(sqlSb.toString(), param, new BeanListHandler(EntInfo4BenDTO.class));
		if (EnValidator.isEmpty(patEntInfos)) 
			return  null;
		return  patEntInfos.toArray(new EntInfo4BenDTO[]{});
	}
	/**
	 * 4.包装所需DTO
	 * @param entinfoDTOs
	 * @param benDTOs
	 * @return
	 */
	private EntRegInfoDTO[] wrapEntDTO( EntInfo4BenDTO[] benDTOs){
		List<EntRegInfoDTO> list = new ArrayList<EntRegInfoDTO>();
		GetVisitFlagBP visitBP = new GetVisitFlagBP();
		for (EntInfo4BenDTO infoDTO : benDTOs) {
			EntRegInfoDTO dto = new EntRegInfoDTO();
			dto.setPatCode(infoDTO.getPatCode());
			dto.setPatName(infoDTO.getPatName());
			dto.setDtEntry(infoDTO.getDtEntry());
			dto.setDayslottp(infoDTO.getDayslottp());
			dto.setResName(infoDTO.getResName());
			dto.setResCode(infoDTO.getResCode());
			dto.setSrvName(infoDTO.getSrvName());
			dto.setSrvCode(infoDTO.getSrvCode());
			if(EnValidator.isEmpty(infoDTO.getChlType())){
				dto.setChlType(IScDictCodeConst.SD_SCCHLTP_HOSPITAL_WINDOW);
			}
			dto.setDeptCode(infoDTO.getDeptCode());
			dto.setDeptName(infoDTO.getDeptName());
			dto.setTimesOp(infoDTO.getTimesOp());
			dto.setTicketno(infoDTO.getTicketno());
			dto.setOprDate(infoDTO.getOprDate());
			dto.setIdCode(infoDTO.getIdCode());
			dto.setBarcode(infoDTO.getBarcode());
			if(!EnValidator.isEmpty(infoDTO.getIdTp())&& IPiDictCodeConst.SD_IDTP_IDENTITY.equals(infoDTO.getIdTp())){
				dto.setIdTp("01");//文档中规定值
			}else{
				dto.setIdTp("02");//文档中规定值
			}
			dto.setIdTp(infoDTO.getIdTp());
			dto.setAge(AgeCalcUtil.getAge(new FDate(infoDTO.getDt_birth())));
			dto.setSex(infoDTO.getSex());
			dto.setVisitFlag(visitBP.getVisitStatusNew(infoDTO.getSd_status(), infoDTO.getSd_status_acpt(), infoDTO.getId_que_site(), infoDTO.getSortno_called()));
			list.add(dto);
		}
		return list.toArray(new EntRegInfoDTO[]{});
	}
	
	

}
