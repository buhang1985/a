package iih.en.pv.s.bp.op;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.ep.EnPatTpEP;
import iih.en.comm.ep.EnVipEP;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.enres.d.EnExtVipDO;
import iih.en.pv.entagtp.d.EnTagTpDO;
import iih.en.pv.outpatient.dto.d.RegListDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.sc.pub.ScGroupControlUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetSetUpVipListBP {
	/**
	 * 检索门诊挂号信息
	 * 
	 * @param regQry 查询条件
	 * @param pg 分页信息
	 * @return
	 * @throws BizException 
	 */
	public PagingRtnData<RegListDTO> exec(QryRootNodeDTO regQry, PaginationInfo pg) throws BizException {
		if(pg == null)
			return new PagingRtnData<RegListDTO>();
		//根据用户输入的查询条件，自动生成sql
		IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
		String whereSql = qrySQLGeneratorService.getQueryStringWithoutDesc(regQry);
		StringBuilder sb = new StringBuilder();
		SqlParam param = new SqlParam();
		//初始化sql
		this.initSql(regQry, sb, param, null);
		if(whereSql != null){
			//加入查询条件
			sb.append(" AND "+whereSql);
		}
		sb.append(" ORDER BY NAME_DEP_PHY, DT_ENTRY,NAME_DAYSLOT, TICKETNO ");
		String sql = sb.toString();
		Logger.info(sql, this.getClass(), "exec");
		PagingServiceImpl<RegListDTO> pageQryService = new PagingServiceImpl<RegListDTO>();
		PagingRtnData<RegListDTO> result = pageQryService.findByPageInfo(new RegListDTO(), pg, sql, null, param);
		this.proccessResult(result);
		return result;
	}
	/**
	 * 设置vip或者取消vip后，查询当前操作的对象的方法
	 * @param entId	对象的就诊id
	 * @return
	 * @throws BizException
	 */
	public RegListDTO findRegListDTOByEntId(String entId) throws BizException {
		StringBuilder sb = new StringBuilder();
		SqlParam param = new SqlParam();
		//初始化sql
		this.initSql(null, sb, param, entId);
		//查询当前设置vip的对象
		sb.append("AND EN.ID_ENT = ? ");
		param.addParam(entId);
		String sql = sb.toString();
		Logger.info(sql, this.getClass(), "exec");
		List<RegListDTO> ls = (List<RegListDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(RegListDTO.class));
		this.proccessResult(ls);
		RegListDTO reg = ls.get(0);
		return reg;
	}
	
	/**
	 * 初始化查询条件
	 * 
	 * @param regQry
	 * @param sb
	 * @param param
	 * @throws BizException 
	 */
	private void initSql(QryRootNodeDTO regQry, StringBuilder sb, SqlParam param, String entId) throws BizException{
		sb.append("SELECT EN.ID_ENT AS ID_ENT,");
		sb.append("EN.ID_PAT AS ID_PAT,");
		sb.append("EN.NAME_PAT AS NAME_PAT,");
		sb.append("PAT.CODE AS CODE_PAT,");
		sb.append("EN.CODE AS CODE_ENT,");
		sb.append("EN.DT_BIRTH_PAT AS DT_BIRTH_PAT,");
		sb.append("NVL(PAT.MOB, PAT.TEL) AS Mob,");
		sb.append("DEP.NAME AS NAME_DEP_PHY,");
		sb.append("SCSRV.NAME  AS NAME_SCSRV,");
		sb.append("SCRES.NAME AS NAME_SCRES,");
		sb.append("PATCA.NAME AS NAME_PATCA,");
		sb.append("PRIPAT.NAME AS NAME_PRIPAT,");
		sb.append("OP.TICKETNO AS TICKETNO,");
		sb.append("OP.TIMES_OP AS TIMES_OP,");
		sb.append("OP.ID_CG AS ID_CG,");
		sb.append("DAYS.NAME AS NAME_DAYSLOT,");
		sb.append("OP.SD_STATUS AS SD_STATUS,");
		sb.append("case when upper(OPER.NAME) like 'TOKEN%' and chl.name is not null then chl.name else OPER.NAME end as NAME_EMP_OPERATOR,");
		sb.append("case when upper(CANC.NAME) like 'TOKEN%' and chl.name is not null then chl.name else CANC.NAME end as NAME_EMP_CANC,");
		sb.append("EN.DT_CANC AS DT_CANC,");
		sb.append("OP.FG_NEEDRTN AS FG_NEEDRTN, ");
		sb.append("EN.FG_CANC AS FG_CANC,");
		sb.append("EN.DT_INSERT AS DT_INSERT,");
		sb.append("HP.NAME AS NAME_HP,");
		sb.append("SUBSTR(EN.DT_ENTRY, 0, 10) AS DT_ENTRY ");
		sb.append("FROM EN_ENT EN ");
		sb.append("INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT ");
		sb.append("INNER JOIN PI_PAT PAT ON EN.ID_PAT = PAT.ID_PAT ");
		sb.append("LEFT JOIN BD_DEP DEP ON EN.ID_DEP_PHY = DEP.ID_DEP ");
		sb.append("LEFT JOIN SC_SRV SCSRV ON OP.ID_SCSRV = SCSRV.ID_SCSRV ");
		sb.append("LEFT JOIN SC_RES SCRES ON OP.ID_SCRES = SCRES.ID_SCRES ");
		sb.append("LEFT JOIN PI_PAT_CA PATCA ON EN.ID_PATCA = PATCA.ID_PATCA ");
		sb.append("LEFT JOIN BD_PRI_PAT PRIPAT ON EN.ID_PRIPAT = PRIPAT.ID_PRIPAT ");  
		sb.append("LEFT JOIN BD_DAYSLOT DAYS ON OP.ID_DATESLOT = DAYS.ID_DAYSLOT ");
		sb.append("LEFT JOIN BD_PSNDOC OPER ON OP.ID_EMP_OPERATOR = OPER.ID_PSNDOC "); 
		sb.append("LEFT JOIN BD_PSNDOC CANC ON EN.ID_EMP_CANC = CANC.ID_PSNDOC ");
		sb.append("left join bd_hp hp on en.id_hp = hp.id_hp ");
		sb.append("left join sc_apt apt on apt.id_apt = op.id_schapt ");
		sb.append("left join sc_chl chl on chl.id_scchl = apt.id_scchl ");
		sb.append("WHERE 1=1 ");
		sb.append(" AND " + ScGroupControlUtils.getGroupControlFitler(new PatiVisitDO(), "EN") + " ");
	}
	/**
	 * 处理数据
	 * 
	 * @param result
	 * @throws BizException 
	 */
	@SuppressWarnings("unchecked")
	private void proccessResult(Object object) throws BizException{
		if(object==null)
			return;
		List<RegListDTO> list = null;
		if (object instanceof PagingRtnData) {
			PagingRtnData<RegListDTO> pagData = (PagingRtnData<RegListDTO>)object;
			list = (List<RegListDTO>) pagData.getPageData();
		}else if (object instanceof List) {
			list = (List<RegListDTO>) object;
		}else {
			return;
		}
		Set<String> set = new HashSet<>();
		for(RegListDTO regList : list){
			//计算年龄
			regList.setAge(AgeCalcUtil.getAge(regList.getDt_birth_pat()));
			//设置状态名称
			this.SetNameState(regList);
			set.add(regList.getId_ent());
		}
		//是否是Vip
		Map<String, EnExtVipDO> extVipMap = new EnVipEP().getIsExtVipDOMap(set.toArray(new String[set.size()]));
		Map<String, List<EnTagTpDO>> entTagMap = new EnPatTpEP().getEnTagTpMap(set.toArray(new String[set.size()]));
		for(RegListDTO regList : list){
			//设置Vip
			if(extVipMap != null){
				if(extVipMap.containsKey(regList.getId_ent())){
					EnExtVipDO extVipDO = extVipMap.get(regList.getId_ent());
					if(extVipDO != null){
						regList.setFg_vip(FBoolean.TRUE);
						regList.setName_emp_setvip(extVipDO.getName_emp_insert());
						regList.setReason_setvip(extVipDO.getReason());
						if(!FBoolean.FALSE.equals(extVipDO.getFg_valid())){
							regList.setDt_setvip(extVipDO.getDt_b());//设置vip时间
						}
					}else
						regList.setFg_vip(FBoolean.FALSE);
				}else
					regList.setFg_vip(FBoolean.FALSE);
			}
			//设置标签
			if(entTagMap != null && entTagMap.containsKey(regList.getId_ent())){
				List<EnTagTpDO> tagList = entTagMap.get(regList.getId_ent());
				if(!ListUtil.isEmpty(tagList)){
					StringBuilder builder = new StringBuilder();
					boolean isFirst = true;
					for(EnTagTpDO tag : tagList){
						if(!isFirst){
							builder.append(",");
							isFirst = false;
						}
						if(EnValidator.isNotEmptyIgnoreBlank(tag.getShortname()))
							builder.append(tag.getShortname());
						else
							builder.append(tag.getName_tagtp());
					}
					regList.setNames_enttag(builder.toString());
				}
			}
		}
	}
	/**
	 * 设置状态名称
	 * 
	 * @param regList
	 * @throws BizException
	 */
	private void SetNameState(RegListDTO regList) throws BizException{
		switch(regList.getSd_status()){
		case IEnDictCodeConst.SD_ENSTATUS_OP_ORDER:
			regList.setName_status("预约");
			break;
		case IEnDictCodeConst.SD_ENSTATUS_OP_REGISTER:
			regList.setName_status("挂号");
			break;
		case IEnDictCodeConst.SD_ENSTATUS_OP_ENCOUNTER:
			regList.setName_status("就诊");
			break;
		case IEnDictCodeConst.SD_ENSTATUS_OP_FINISH:
			regList.setName_status("诊毕");
			break;
		}
	}
}
