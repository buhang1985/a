package iih.en.que.s.bp;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.comm.util.EnAgeCalcUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EntQryModDTO;
import iih.en.pv.dto.d.EntQryRangeEnum;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.que.dto.d.ReceptionQueDTO;
import iih.sc.pub.ScGroupControlUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.log.logging.Logger;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 门急诊医生站获取历史就诊列表
 * 
 * @author liubin
 *
 */
public class GetEntListByOperBP {
	private static final String KEY_NAME = "NAME";
	private static final String KEY_CODE = "CODE";
	/**
	 * 门急诊医生站获取历史就诊列表
	 * 
	 * @param pg 分页信息
	 * @param nodeDTO 查询条件
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<ReceptionQueDTO> getEntListByOper(QryRootNodeDTO qryNode, PaginationInfo pg) throws BizException {
		if(qryNode == null || pg == null)
			return new PagingRtnData<ReceptionQueDTO>();
		EntQryModDTO qryDTO = this.getQryDTO(qryNode);
		if(qryDTO == null)
			return new PagingRtnData<ReceptionQueDTO>();
		StringBuilder sb = new StringBuilder();
		SqlParam param = new SqlParam();
		boolean res = this.initSqlAndParam(sb, param, qryDTO);
		if(!res)
			return new PagingRtnData<ReceptionQueDTO>();
		String sql = sb.toString();
		PagingRtnData<ReceptionQueDTO> rtnData = this.getRtnData(pg, sql, param);
		this.initRtnData(rtnData);
		return rtnData;
	}
	/**
	 * 查询数据
	 * 
	 * @param pg
	 * @param sql
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<ReceptionQueDTO> getRtnData(PaginationInfo pg, String sql, SqlParam param) throws BizException{
		PagingServiceImpl<ReceptionQueDTO> pageQryService = new PagingServiceImpl<ReceptionQueDTO>();
		return pageQryService.findByPageInfo(new ReceptionQueDTO(), pg, sql, null, param);
	}
	/**
	 * 对结果数据调整
	 * 
	 * @param rtnData
	 * @throws BizException 
	 */
	@SuppressWarnings("unchecked")
	private void initRtnData(PagingRtnData<ReceptionQueDTO> rtnData) throws BizException{
		if(rtnData == null)
			return;
		FArrayList list = rtnData.getPageData();
		if(list == null || list.isEmpty())
			return;
		//设置年龄
		EnAgeCalcUtil.setDoAges((ReceptionQueDTO[])list.toArray(new ReceptionQueDTO[]{}), "Id_ent", "Age");
		for(int i = 0;i<list.size();i++){
			ReceptionQueDTO rect = (ReceptionQueDTO)list.get(i);
			//rect.setAge(AgeCalcUtil.getAge(rect.getDt_birth_pat()));
			if(FBoolean.TRUE.equals(rect.getFg_needrtn())){
				rect.setEnt_status("0a");
			}else{
				rect.setEnt_status(rect.getSd_status());
			}
		}
	}
	/**
	 * 获取查询条件
	 * 
	 * @param qryNode
	 * @return
	 */
	private EntQryModDTO getQryDTO(QryRootNodeDTO qryNode){
		if(qryNode == null)
			return null;
		FArrayList list = qryNode.getUserObject();
		if(list != null && !list.isEmpty()){
			Object obj = list.get(0);
			if(obj != null && obj instanceof EntQryModDTO){
				return (EntQryModDTO)obj;
			}
		}
		return null;
	}
	/**
	 * 根据查询条件初始化SQL语句
	 * 
	 * @param sb
	 * @param param
	 * @param qryDTO
	 */
	private boolean initSqlAndParam(StringBuilder sb, SqlParam param, EntQryModDTO qryDTO){
		sb.append("SELECT EN.ID_ENT,EN.ID_PAT,EN.ID_ENTP,EN.CODE_ENTP,EN.NAME_PAT,EN.ID_SEX_PAT,EN.DT_ACPT, AREA.FULLNAME || addr.street as addr_pat, PAT.ID_CODE, TPUDI.NAME NAME_IDTP ,");
		sb.append("EN.DT_BIRTH_PAT,EN.TELNO_PAT,EN.ID_HP,EN.DT_END,EN.ID_EMP_PHY,EN.CODE AS CODE_ENT,");
		sb.append("OP.TICKETNO,OP.FG_NEEDRTN,OP.SD_STATUS,PAT.CODE AS CODE_PAT,DI.ID_DIDEF_DIS,SCSRV.NAME AS NAME_SRV,");
		sb.append("DI.NAME_DIDEF_DIS,SEX.NAME AS NAME_SEX,HP.NAME AS NAME_HP,EMP.NAME AS NAME_EMP_PHY ");
		sb.append("FROM EN_ENT EN ");
		sb.append("INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT ");
		sb.append("LEFT JOIN SC_SRV SCSRV ON OP.ID_SCSRV = SCSRV.ID_SCSRV ");//fanlq
		sb.append("INNER JOIN PI_PAT PAT ON EN.ID_PAT = PAT.ID_PAT ");
		sb.append(" LEFT JOIN PI_PAT_ADDR ADDR ON ADDR.ID_PAT = PAT.ID_PAT AND ADDR.SD_ADDRTP = '"+IPiDictCodeConst.SD_ADDR_TYPE_NOW+"' ");
		sb.append(" LEFT JOIN BD_ADMINAREA AREA ON AREA.ID_ADMINAREA = ADDR.ID_ADMDIV ");
		if (!EnValidator.isEmpty(qryDTO.getValue_pat()) //输入不为空
				&& !KEY_NAME.equals(qryDTO.getKey_pat()) //未选中NAME
				&& !KEY_CODE.equals(qryDTO.getKey_pat())) { //未选中CODE
			sb.append("INNER JOIN PI_PAT_CARD CARD ON EN.ID_PAT = CARD.ID_PAT AND CARD.ID_PATCARDTP = ? AND CARD.CODE = ? ");
			param.addParam(qryDTO.getKey_pat());
			param.addParam(qryDTO.getValue_pat());
		}
		sb.append("LEFT JOIN BD_PSNDOC EMP ON EN.ID_EMP_PHY = EMP.ID_PSNDOC ");
		sb.append("LEFT JOIN BD_HP HP ON EN.ID_HP = HP.ID_HP ");
		sb.append("LEFT JOIN BD_UDIDOC TPUDI  ON TPUDI.ID_UDIDOC = PAT.ID_IDTP ");
		sb.append("LEFT JOIN EN_ENT_DI DI ON EN.ID_ENT = DI.ID_ENT AND DI.FG_MAJ = ? ");
		param.addParam(FBoolean.TRUE);
		sb.append("LEFT JOIN BD_UDIDOC SEX ON EN.ID_SEX_PAT = SEX.ID_UDIDOC ");
		sb.append("WHERE EN.FG_ACPTVALID = ? ");
		sb.append("AND " + ScGroupControlUtils.getGroupControlFitler(new PatiVisitDO(), "EN") + " ");
		sb.append("AND EN.FG_CANC = ? ");
		sb.append("AND EN.DT_ENTRY >= ? ");
		sb.append("AND EN.DT_ENTRY < ? ");
        param.addParam(FBoolean.TRUE);
		param.addParam(FBoolean.FALSE);
		param.addParam(qryDTO.getDt_b());
		//加1天
		param.addParam(qryDTO.getDt_e().getDateAfter(1));
		if(EntQryRangeEnum.CUREMP.equals(qryDTO.getQry_range())){
			//当前医生
			sb.append("AND EXISTS (SELECT * FROM EN_ENT_EMP ENEMP WHERE EN.ID_ENT = ENEMP.ID_ENT AND ENEMP.ID_EMP = ?) ");
			param.addParam(qryDTO.getId_emp());
		} else if(EntQryRangeEnum.CURDEP.equals(qryDTO.getQry_range())){
			//当前科室
			sb.append("AND EXISTS (SELECT * FROM EN_ENT_DEP ENDEP WHERE EN.ID_ENT = ENDEP.ID_ENT AND ENDEP.ID_DEP = ?) ");
			param.addParam(qryDTO.getId_dep());
		} else {
			Logger.error("查询范围不匹配");
			return false;
		}
		// 输入不为空
		if (!EnValidator.isEmpty(qryDTO.getValue_pat())) {
			if(KEY_NAME.equals(qryDTO.getKey_pat())){
				// 选择患者姓名
				sb.append("AND EN.NAME_PAT=? ");
				param.addParam(qryDTO.getValue_pat());
			} else if(KEY_CODE.equals(qryDTO.getKey_pat())){
				// 选择患者编号
				sb.append("AND PAT.CODE=? ");
				param.addParam(qryDTO.getValue_pat());
			}
		}
		sb.append("ORDER BY EN.DT_ACPT DESC, OP.TICKETNO ");
		return true;
	}
}
