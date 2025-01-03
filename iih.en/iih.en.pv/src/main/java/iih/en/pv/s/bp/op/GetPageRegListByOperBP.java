package iih.en.pv.s.bp.op;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.QueryRegInfoDTO;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.sc.pub.ScGroupControlUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 分页获取挂号员已挂号列表
 * @author yank
 *
 */
public class GetPageRegListByOperBP {
	/**
	 * 检索操作员挂号信息
	 * @param queryNoteSql
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<RegInfoDTO> exec(PaginationInfo pg, QueryRegInfoDTO queryDTO) throws BizException{	
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
		//就诊卡号
		String card = queryDTO.getCard();
		//发票号
		String incNo = queryDTO.getIncNo();
		QryRootNodeDTO nodeDTO = queryDTO.getNodeDTO();
		String sql="" ;
 		if (nodeDTO!=null){
 			 sql = service.getQueryStringWithoutDesc(nodeDTO);
 		}
 		PagingRtnData<RegInfoDTO> data = getData(pg, sql, card, incNo);
 		return data;
	}
	/**
	 * 获取数据
	 * @throws BizException 
	 */
	private PagingRtnData<RegInfoDTO> getData(PaginationInfo pg,String queryNoteSql, String card, String incNo) throws BizException{
		StringBuilder sqlBuilder = new StringBuilder();		
		sqlBuilder.append("SELECT ENT.ID_ENT, ENT.ID_PAT,ENT.NAME_PAT,ENT.CODE AS ENT_CODE,ENT.FG_CANC,");
		sqlBuilder.append("SUBSTR(ENT.DT_ENTRY,0,10) REGISTED_DATE,SUBSTR(ENT.DT_INSERT,11,6) INVNO,LOT.NAME DAYSLOT,");
		sqlBuilder.append("PL.NAME AS REGRES,OP.TICKETNO TICKNO,");	
		sqlBuilder.append("ENT.ID_HP,HP.NAME AS NAME_HP,");
		sqlBuilder.append("OP.SD_STATUS,");
		sqlBuilder.append("PAT.CODE AS PAT_CODE,");
		sqlBuilder.append("PATHP.NO_HP AS NO_HP,"); //医保号
		sqlBuilder.append("PAT.ID_CODE AS ID_CODE,"); //证件号
		sqlBuilder.append("DEP.ID_DEP AS ID_DEP_PHY,"); 
		sqlBuilder.append("DEP.NAME AS NAME_DEP_PHY,"); 
		sqlBuilder.append("DEP.CODE AS CODE_DEP_PHY"); 
		sqlBuilder.append(" FROM EN_ENT_OP OP");
		sqlBuilder.append(" INNER JOIN EN_ENT ENT ON OP.ID_ENT=ENT.ID_ENT");
		sqlBuilder.append(" INNER JOIN PI_PAT PAT ON ENT.ID_PAT = PAT.ID_PAT");
		sqlBuilder.append(" INNER JOIN BD_DEP DEP ON DEP.ID_DEP = ENT.ID_DEP_PHY");
		sqlBuilder.append(" LEFT JOIN PI_PAT_HP PATHP ON PATHP.ID_PAT = PAT.ID_PAT AND PATHP.FG_DEFT = 'Y' ");
		sqlBuilder.append(" LEFT JOIN SC_SCH SCH ON OP.ID_SCH= SCH.ID_SCH");
		sqlBuilder.append(" LEFT JOIN SC_PL PL ON PL.ID_SCPL= SCH.ID_SCPL");
		sqlBuilder.append(" LEFT JOIN BD_DAYSLOT LOT ON OP.ID_DATESLOT =LOT.ID_DAYSLOT");
		sqlBuilder.append(" LEFT JOIN BD_HP HP ON ENT.ID_HP=HP.ID_HP");
		sqlBuilder.append(" WHERE 1=1 ");
		//就诊卡号
		if(card != null && card.length() > 0){
			sqlBuilder.append("AND PAT.ID_PAT IN (SELECT CARD.ID_PAT FROM PI_PAT_CARD CARD WHERE CARD.CODE= '" + card + "' AND CARD.FG_ACT='Y')");
		}
		//发票号
		if (!EnValidator.isEmpty(incNo)) {
			sqlBuilder.append(" and exists(select * from bl_cg_itm_oep cgitm inner join bl_inc_oep inc on inc.id_stoep = cgitm.id_stoep "
					+ "where inc.incno = '" + incNo + "' and cgitm.id_ent = ent.id_ent) ");
		}
		//集团管控
		sqlBuilder.append(" AND " + ScGroupControlUtils.getGroupControlFitler(new PatiVisitDO(), "ENT") + " ");
		//查询模板查询条件
		if(queryNoteSql != null && queryNoteSql.length()>0){
			sqlBuilder.append("AND " + queryNoteSql);
		}
		sqlBuilder.append(" ORDER BY ENT.DT_INSERT");	
		
		RegInfoDTO regInfo = new RegInfoDTO();
		PagingServiceImpl<RegInfoDTO> pageQryService = new PagingServiceImpl<RegInfoDTO>();	
		PagingRtnData<RegInfoDTO> pgRtData = pageQryService.findByPageInfo(regInfo, pg, sqlBuilder.toString(), null, null);
		FArrayList flResult = pgRtData.getPageData();
		for (int i = 0; i < flResult.size(); i++) {
			RegInfoDTO reg = (RegInfoDTO) flResult.get(i);
			if(reg.getFg_canc().booleanValue()){
				reg.setSd_status("退号");
			}else{
				reg.setSd_status(this.SetStatusNMBySd(reg.getSd_status()));
			}
		}
		return pgRtData;
	}
	/**
	 * 根据就诊状态编码设置对应的名称
	 * @param sd_status
	 * @return
	 */
	private String SetStatusNMBySd(String sd_status){
		if(EnValidator.isEmpty(sd_status))
			return "";
		if(sd_status.equals(IEnDictCodeConst.SD_ENSTATUS_OP_ORDER)){
			return "预约";
		}else if(sd_status.equals(IEnDictCodeConst.SD_ENSTATUS_OP_REGISTER)){
			return "挂号";
		}else if(sd_status.equals(IEnDictCodeConst.SD_ENSTATUS_OP_ENCOUNTER)){
			return "就诊";
		}else if(sd_status.equals(IEnDictCodeConst.SD_ENSTATUS_OP_FINISH)){
			return "诊毕";
		}else if(sd_status.equals(IEnDictCodeConst.SD_ENSTATUS_OP_CONTINUE)){
			return "续诊";
		}
		return "";
	}
}
