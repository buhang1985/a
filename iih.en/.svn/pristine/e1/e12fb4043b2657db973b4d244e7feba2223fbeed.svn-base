package iih.en.que.s.bp;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.que.dto.d.EnTrDocSiteInfoDTO;
import iih.en.que.dto.d.ReceptionQueDTO;
import iih.en.que.enqueue.d.EntQueStatus;
import iih.sc.pub.ScGroupControlUtils;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 门诊医生接诊得到已诊列表
 * 
 * @author liubin
 *
 */
public class GetDiagnosedBP {
	/**
	 * 获取已诊患者列表
	 * 
	 * @param siteInfo 
	 * 		站点信息
	 * @return 
	 * 		已诊队列DTO集合
	 * @throws BizException
	 * @author liubin
	 */
	public ReceptionQueDTO[] exec(EnTrDocSiteInfoDTO siteInfo) throws BizException {
		if(siteInfo == null || EnValidator.isEmpty(siteInfo.getId_emp())){
			return null;
		}
		if(siteInfo.getDate() == null)
			siteInfo.setDate(EnAppUtils.getServerDate());
		String[] entIds = this.getDiagnosedEntIds(siteInfo);
		if(!EnValidator.isEmpty(entIds)){
			GetAcptEntBP bp = new GetAcptEntBP();
			List<ReceptionQueDTO> list =  bp.getAcptEnt(entIds, EntQueStatus.Accept, IEnDictCodeConst.SD_STATUS_ACPT_ACCEPTED);
			if(!EnValidator.isEmpty(list)){
				return list.toArray(new ReceptionQueDTO[0]);
			}
		}
		return null;
	}
	
	/**
	 * 获取已诊患者就诊ID
	 * 
	 * @param empId
	 * @return
	 * @throws BizException
	 */
	private String[] getDiagnosedEntIds(EnTrDocSiteInfoDTO siteInfo) throws BizException{
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT DISTINCT EN.ID_ENT ");
		builder.append("FROM EN_ENT EN ");
		builder.append("INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT ");
		builder.append("INNER JOIN EN_ENT_EMP EMP ON EN.ID_ENT = EMP.ID_ENT ");
		builder.append("WHERE EMP.ID_EMP = ? ");
		builder.append("AND OP.FG_NEEDRTN = ? ");
		builder.append("AND EMP.DT_B >= ? ");
		builder.append("AND EN.FG_ACPTVALID = ? "); 
		builder.append("AND EN.FG_CANC = ? ");
		builder.append("AND " + ScGroupControlUtils.getGroupControlFitler(new PatiVisitDO(), "EN") + " ");
		builder.append("AND ").append(EnSqlUtils.getOpOrErTpSql("EN", siteInfo.getCode_entp()));
		String sql = builder.toString();
		SqlParam param = new SqlParam();
		param.addParam(siteInfo.getId_emp());
		param.addParam(FBoolean.FALSE);
		param.addParam(siteInfo.getDate());
		param.addParam(FBoolean.TRUE);
		param.addParam(FBoolean.FALSE);
		List<String> list = (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
		if(!EnValidator.isEmpty(list)){
			return list.toArray(new String[0]);
		}
		return null;
	}
}
