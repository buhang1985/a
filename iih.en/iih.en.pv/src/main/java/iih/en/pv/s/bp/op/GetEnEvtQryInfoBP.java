package iih.en.pv.s.bp.op;

import iih.bd.bc.udi.pub.IEnDictCodeTypeConst;
import iih.en.pv.enevtqrydto.d.EnEvtListDTO;
import iih.en.pv.enevtqrydto.d.EnEvtResultDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取就诊事件信息
 * 
 * @author yank
 *
 */
public class GetEnEvtQryInfoBP {
	/**
	 * 获取就诊记录
	 * 
	 * @param pg
	 * @param param         
	 * @throws BizException
	 */
	public PagingRtnData<EnEvtResultDTO> exec(PaginationInfo pg, String wherestr) throws BizException {
		// 获取SQL
		StringBuilder sql = new StringBuilder();
		SqlParam sqlParam = new SqlParam();
		sql.append("SELECT  PAT.CODE  AS CODE_PAT,");
		sql.append(" PAT.NAME AS NAME_PAT, ");
		sql.append("SEX.NAME AS SEX ,");
		sql.append("PAT.DT_BIRTH ,");
		sql.append("PAT.ID_IDTP ,");
		sql.append("PAT.SD_IDTP,");
		sql.append("PAT.ID_CODE AS CODE_ID,");
		sql.append("ENT.CODE AS CODE_ENT,");
		sql.append("DEP.ID_DEP AS ID_DEP_PHY,");
		sql.append("DEP.CODE AS CODE_DEP_PHY ,");
		sql.append("DEP.NAME AS NAME_DEP_PHY ,");
		sql.append("ENT.DT_ACPT,");
		sql.append("PSN.NAME NAME_EMP ,");
		sql.append("NVL(OP_STATUS.NAME,IP_STATUS.NAME) AS SD_STATUS,");
		sql.append("ENTP.NAME AS NAME_ENTP,");		
		sql.append("IP.CODE_AMR_IP AS CODE_AMR_IP,");		
		sql.append("CA.ID_PATCA,");
		sql.append("CA.CODE AS SD_PATCA,");
		sql.append("CA.NAME AS NAME_PATCA  ");
		sql.append("FROM EN_ENT ENT INNER JOIN PI_PAT PAT ON ENT.ID_PAT = PAT.ID_PAT ");
		sql.append("INNER JOIN  BD_ENTP ENTP ON ENT.ID_ENTP = ENTP.ID_ENTP ");
		sql.append("INNER JOIN BD_UDIDOC SEX ON PAT.ID_SEX = ID_UDIDOC ");
		sql.append("INNER JOIN BD_DEP DEP ON DEP.ID_DEP = ENT.ID_DEP_PHY ");
		sql.append("INNER JOIN BD_PSNDOC PSN ON PSN.ID_PSNDOC = ENT.ID_EMP_PHY ");
		sql.append("INNER JOIN PI_PAT_CA CA ON CA.ID_PATCA = ENT.ID_PATCA ");
		sql.append("LEFT JOIN EN_ENT_OP OP ON OP.ID_ENT = ENT.ID_ENT ");
		sql.append("LEFT JOIN BD_UDIDOC OP_STATUS ON OP.SD_STATUS = OP_STATUS.CODE AND OP_STATUS.ID_UDIDOCLIST = '"+IEnDictCodeTypeConst.ID_EN_STATUS+"' ");
		sql.append("LEFT JOIN EN_ENT_IP IP ON IP.ID_ENT = ENT.ID_ENT ");
		sql.append("LEFT JOIN BD_UDIDOC IP_STATUS ON IP.SD_STATUS = IP_STATUS.CODE AND IP_STATUS.ID_UDIDOCLIST = '"+IEnDictCodeTypeConst.ID_EN_STATUS+"' ");
		sql.append("WHERE "+wherestr+" ");
	    //获取数据
		PagingServiceImpl<EnEvtResultDTO> pageQryService = new PagingServiceImpl<EnEvtResultDTO>();
		PagingRtnData<EnEvtResultDTO> pgRtData = pageQryService.findByPageInfo(new EnEvtResultDTO(), pg, sql.toString(),
				null, sqlParam);
		

		FArrayList flResult = pgRtData.getPageData();
		for (int i = 0; i < flResult.size(); i++) {
			EnEvtResultDTO reg = (EnEvtResultDTO) flResult.get(i);
			reg.setAge(AgeCalcUtil.getAge(reg.getDt_birth()));
			
		}
		return pgRtData;
	}

	/***
	 * 查询就诊事件列表 - li.wm
	 * 
	 * @param pg
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<EnEvtListDTO> exec(PaginationInfo pg, EnEvtResultDTO param) throws BizException {
		//获取SQl
		StringBuilder sql = new StringBuilder();
		SqlParam sqlParam = new SqlParam();
		sql.append("SELECT  EVENT.NAME AS SD_ENTEVT ,");
		sql.append("EVT.DES , ");
		sql.append("EVT.DT_EVT AS DT_INSERT ,");
		sql.append("EVT.VAL_OLD,");
		sql.append("EVT.VAL_NEW ");
		sql.append("FROM EN_ENT_EVT EVT  INNER JOIN EN_ENT ENT ON ENT.ID_ENT = EVT.ID_ENT ");
		sql.append("INNER JOIN BD_UDIDOC EVENT ON EVENT.CODE = EVT.SD_ENTEVT AND EVENT.ID_UDIDOCLIST = '"+IEnDictCodeTypeConst.ID_EN_EVENT+"' ");
		sql.append(" WHERE 1=1 ");
		sql.append(" AND ENT.CODE = ? ");
		sqlParam.addParam(param.getCode_ent());
		sql.append(" ORDER BY EVT.DT_INSERT ");
		//获取数据
		PagingServiceImpl<EnEvtListDTO> pageQryService = new PagingServiceImpl<EnEvtListDTO>();
		PagingRtnData<EnEvtListDTO> pgRtData = pageQryService.findByPageInfo(new EnEvtListDTO(), pg, sql.toString(),
				null, sqlParam);
		return pgRtData;
	}
}
