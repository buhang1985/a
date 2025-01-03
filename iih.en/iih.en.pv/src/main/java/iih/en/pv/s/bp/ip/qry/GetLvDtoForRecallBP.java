package iih.en.pv.s.bp.ip.qry;

import java.util.HashSet;
import java.util.List;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bl.st.dto.blipauditstatus.d.BlIpAuditStatusDTO;
import iih.bl.st.i.IBlStOutQryService;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.HosRecallDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.sc.pub.ScGroupControlUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询出院记录
 * 
 * @author renying
 *
 */
public class GetLvDtoForRecallBP {
	/**
	 * 查询出院记录
	 * 
	 * @param queryNode
	 *            查询方案
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public HosRecallDTO[] exec(QryRootNodeDTO queryNode) throws BizException {
		
		SqlParam param = new SqlParam();
		String string = getSql(queryNode,param);

		List<HosRecallDTO> dtoList = (List<HosRecallDTO>) new DAFacade().execQuery(string, param, new BeanListHandler(HosRecallDTO.class));
		//设置费用标志
		setBlFalg(dtoList);
		if (dtoList != null) {
			return dtoList.toArray(new HosRecallDTO[0]);
		}

		return null;
	}
	
	/**
	 * 出院召回（分页查询）-zhangpp 2018.12.6
	 * @param queryNode
	 * @param pageInfo
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PagingRtnData<HosRecallDTO> exec(QryRootNodeDTO queryNode, PaginationInfo pageInfo) throws BizException{
		PagingRtnData<HosRecallDTO> datas = new PagingRtnData<HosRecallDTO>();
		PagingServiceImpl<HosRecallDTO> service =new PagingServiceImpl();
		SqlParam param = new SqlParam();
		//获取sql
		String sql = getSql(queryNode,param);
		
		datas = service.findByPageInfo(new HosRecallDTO(), pageInfo, sql, "", param);
		//设置费用标志
		setBlFalg(datas.getPageData());
		return datas;
	}
	
	/**
	 * 获取sql
	 * @param queryNode
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private String getSql(QryRootNodeDTO queryNode,SqlParam param) throws BizException {
		IQrySQLGeneratorService service = ServiceFinder.find(IQrySQLGeneratorService.class);
		String sql = "";
		if (queryNode != null) {
			sql = service.getQueryStringWithoutDesc(queryNode);
		}
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT ENT.ID_ENT,");
		sqlBuilder.append("ENT.ID_PAT,ENT.NAME_PAT,ENT.dt_birth_pat, ENT.FG_ST, ent.id_dep_phy, ent.id_dep_nur, DEP.NAME AS NAME_DEP,NUR.NAME AS NAME_NUR, ");
		sqlBuilder.append("ENT.DT_END,ENT.SD_SEX_PAT,IP.ID_BED,IP.NAME_BED , IP.code_amr_ip code ,IP.FG_NEWBORN, ");
		sqlBuilder.append("NB.ID_ENT_MOM, ");
		sqlBuilder.append("IP.FG_BLRECALL ");
		sqlBuilder.append("FROM EN_ENT ENT ");
		sqlBuilder.append("INNER JOIN EN_ENT_IP IP ON ENT.ID_ENT=IP.ID_ENT ");
		sqlBuilder.append(" LEFT JOIN EN_ENT_NB NB ");
		sqlBuilder.append(" ON NB.ID_ENT_BB = ENT.ID_ENT ");
		sqlBuilder.append(" LEFT JOIN BD_DEP DEP ON DEP.ID_DEP = ENT.ID_DEP_PHY ");
		sqlBuilder.append(" LEFT JOIN BD_DEP NUR ON NUR.ID_DEP = ENT.ID_DEP_NUR ");
		sqlBuilder.append("WHERE ENT.FG_IP='N' AND IP.SD_STATUS= ? ");// 出院
		sqlBuilder.append("AND ENT.CODE_ENTP <> ? "); //过滤掉预住院患者
		param.addParam(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALOUT);
		param.addParam(IEnDictCodeConst.SD_ENTP_IPPRE);
		sqlBuilder.append(" AND " + ScGroupControlUtils.getGroupControlFitler(new PatiVisitDO(), "ENT") + " ");

		String nurId = EnContextUtils.getDeptId();
		if (!EnValidator.isEmpty(nurId)) {
			sqlBuilder.append("AND ENT.ID_DEP_NUR=?  and ");
			param.addParam(nurId);
		}

		if (!EnValidator.isEmpty(sql)) {
			sqlBuilder.append(sql);
		} else {
			sqlBuilder.append(" 1=1 ");
		}
		sqlBuilder.append(" ORDER BY DT_END DESC, IP.ID_BED DESC ");// 按出院时间倒序排列
		
		return sqlBuilder.toString();
	}
	
	/**
	 * 设置费用标志
	 * 
	 * @param dtoList
	 * @throws BizException
	 */
	/**
	 * @author lilei
	 * @date 2019年12月31日 
	 */
	public void setBlFalg(List<HosRecallDTO> dtoList) throws BizException {
		if(ListUtil.isEmpty(dtoList))
			return;
		HashSet<String> set = new HashSet<String>();
		for(HosRecallDTO dto : dtoList)
			set.add(dto.getId_ent());
		IBlStOutQryService blService = ServiceFinder.find(IBlStOutQryService.class);
		BlIpAuditStatusDTO[] ipAuditStatus = blService.getIpAuditStatus(set.toArray(new String[0]));
		if(ArrayUtil.isEmpty(ipAuditStatus))
			return;
		for(HosRecallDTO dto : dtoList){
			for(BlIpAuditStatusDTO ipAudit : ipAuditStatus){
				if(dto.getId_ent().equals(ipAudit.getId_ent())){
					dto.setFg_pass_clinic(ipAudit.getFg_pass_clinic());
					dto.setFg_pass_hp(ipAudit.getFg_pass_hp());
				}
			}
		}
	}
}
