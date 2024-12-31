package iih.en.pv.s.bp.op;

import iih.bd.bc.udi.pub.IEnDictCodeTypeConst;
import iih.en.comm.util.EnAgeCalcUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EntQryModDTO;
import iih.en.pv.dto.d.EntQryRangeEnum;
import iih.en.pv.dto.d.OutpatientQryDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.sc.pub.ScGroupControlUtils;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.d.UdidoclistDO;
import xap.sys.xbd.udi.i.IUdidocRService;
import xap.sys.xbd.udi.i.IUdidoclistRService;

/**
 * 门诊就诊查询
 * 
 * @author liubin
 *
 */
public class GetOpListBP {
	
	private static final String KEY_NAME = "NAME";
	private static final String KEY_CODE = "CODE";
	private static final String KEY_CODE_CHIS = "CODE_CHIS";
	private static final String KEY_CODE_ENT = "CODE_ENT";
	private static final String KEY_ID_CODE = "ID_CODE";
    
	/**
	 * 门诊就诊查询
	 * 
	 * @param qryModDTO
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<OutpatientQryDTO> exec(EntQryModDTO qryModDTO, PaginationInfo pg) throws BizException {
		//1.验证参数
		if(!volidate(qryModDTO)|| pg == null)
			new PagingRtnData<OutpatientQryDTO>();
		
		//2.组装Sql语句
		StringBuilder sb = new StringBuilder();
		SqlParam param = new SqlParam();
		wrapSql(qryModDTO, sb, param);
		String sql = sb.toString();
		
		//3.查询就诊信息
		
		//查询结果分页显示-fanlq-2018.03.27
		PagingServiceImpl<OutpatientQryDTO> pageQryService = new PagingServiceImpl<OutpatientQryDTO>();
		PagingRtnData<OutpatientQryDTO> datas = pageQryService.findByPageInfo(new OutpatientQryDTO(), pg, sql, null, param);
		FArrayList flResult = datas.getPageData();
		List<OutpatientQryDTO> outpatientQryDTOList = new ArrayList<OutpatientQryDTO>();
		for (int i = 0; i < flResult.size(); i++) {
			OutpatientQryDTO apt = (OutpatientQryDTO) flResult.get(i);
			outpatientQryDTOList.add(apt);
		}
		if (!EnValidator.isEmpty(outpatientQryDTOList)) {
			this.setAgeAndStatus(outpatientQryDTOList.toArray(new OutpatientQryDTO[0]));
		}
		return datas;
	}
	
	/***
	 * 设置年龄和就诊状态名称，
	 * @author fanlq 2018-04-27
	 * @param outpatientQryDTOs
	 * @throws BizException
	 */
	private void setAgeAndStatus(OutpatientQryDTO[] outpatientQryDTOs) throws BizException{
		IUdidocRService service = ServiceFinder.find(IUdidocRService.class);
		IUdidoclistRService listservice = ServiceFinder.find(IUdidoclistRService.class);
		UdidoclistDO[] listDOs = listservice.find("code = '"+IEnDictCodeTypeConst.SD_STATUS+"'", null, FBoolean.FALSE);
		if(outpatientQryDTOs != null){
			for(OutpatientQryDTO outpatientQryDTO : outpatientQryDTOs){
				//设置年龄
				//outpatientQryDTO.setAge_pat(AgeCalcUtil.getAge(outpatientQryDTO.getDt_birth_pat()));
				//设置就诊状态
				if(listDOs != null && listDOs[0] != null){
					UdidocDO[] ralsrcudidocDos = service.find("id_udidoclist = '"+listDOs[0].getId_udidoclist()+"' and code = '"+outpatientQryDTO.getSd_status()+"'",  null, FBoolean.FALSE);
					if(ralsrcudidocDos != null && ralsrcudidocDos.length > 0)
						outpatientQryDTO.setName_status(ralsrcudidocDos[0].getName());
				}
			}
			//设置年龄
			EnAgeCalcUtil.setDoAges(outpatientQryDTOs, "Id_ent", "Age_pat");
		}
	}
	
	/**
	 * 验证参数
	 * 
	 * @param qryModDTO
	 * @return
	 */
	private boolean volidate(EntQryModDTO qryModDTO){
		if(EnValidator.isEmpty(qryModDTO)){
			Logger.error("门诊就诊查询参数EntQryModDTO为null");
			return false;
		}
		if(EnValidator.isEmpty(qryModDTO.getQry_range())){
			Logger.error("门诊就诊查询查询范围Qry_range为null");
			return false;
		}
		return true;
	}
	/**
	 * 组装Sql语句
	 * 
	 * @param qryModDTO
	 * @param sql
	 * @param param
	 */
	private void wrapSql(EntQryModDTO qryModDTO, StringBuilder sb, SqlParam param){
		sb.append("SELECT DISTINCT EN.ID_ENT,");
		sb.append("EN.ID_ENTP,");
		sb.append("EN.CODE_ENTP,");
		sb.append("EN.ID_PAT,");
		sb.append("EN.NAME_PAT,");
		sb.append("EN.SD_SEX_PAT,");
		sb.append("EN.DT_BIRTH_PAT,");
		sb.append("EN.ID_EMP_PHY,");
		sb.append("PS.NAME AS NAME_EMP_PHY,");
		sb.append("EN.DT_ACPT,");
		sb.append("EN.DT_ENTRY,");
		sb.append("EN.CODE AS CODE_ENT,");
		sb.append("PI.CODE AS CODE_PAT,");
		//增加患者分类，价格分类，医保计划 zhangpp 2019.11.07
		sb.append(" en.id_patca as id_paticate, ");
		sb.append(" patca.name as name_paticate, ");
		sb.append(" en.id_pripat, ");
		sb.append(" pripat.name as name_pripat, ");
		sb.append(" enthp.id_hp, ");
		sb.append(" bdhp.name as name_hp, ");
		sb.append("OP.ID_SCRES AS ID_SCRES,");
		sb.append("RES.NAME AS NAME_SCRES,");
		sb.append("OP.TICKETNO AS TICKNO,");
		sb.append("OP.SD_STATUS,");
		sb.append("DOC.NAME AS NAME_SEX_PAT ");
		sb.append("FROM EN_ENT EN ");
		sb.append("INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT AND EN.FG_CANC = ? ");
		param.addParam(FBoolean.FALSE);
		sb.append("INNER JOIN PI_PAT PI ON EN.ID_PAT = PI.ID_PAT ");
		if(EntQryRangeEnum.CUREMP.equals(qryModDTO.getQry_range())){
			//当前医生
			sb.append("INNER JOIN EN_ENT_EMP EMP ON EN.ID_ENT = EMP.ID_ENT AND EMP.ID_EMP = ? ");
			param.addParam(qryModDTO.getId_emp());
		} else if(EntQryRangeEnum.CURDEP.equals(qryModDTO.getQry_range())){
			//当前科室
			sb.append("INNER JOIN EN_ENT_DEP DEP ON EN.ID_ENT = DEP.ID_ENT AND DEP.ID_DEP = ? ");
			param.addParam(qryModDTO.getId_dep());
		}
		sb.append("LEFT JOIN SC_RES RES ON OP.ID_SCRES = RES.ID_SCRES ");
		sb.append("LEFT JOIN BD_PSNDOC PS ON EN.ID_EMP_PHY = PS.ID_PSNDOC ");
		sb.append("LEFT JOIN BD_UDIDOC DOC ON EN.ID_SEX_PAT = DOC.ID_UDIDOC ");
		sb.append(" left join pi_pat_ca patca on en.id_patca = patca.id_patca ");
		sb.append(" left join bd_pri_pat pripat on en.id_pripat = pripat.id_pripat ");
		sb.append(" left join en_ent_hp enthp on enthp.id_ent = en.id_ent and enthp.fg_maj = 'Y' ");
		sb.append(" left join bd_hp bdhp on bdhp.id_hp = enthp.id_hp ");
		sb.append("WHERE 1 = 1 ");
		sb.append(" AND " + ScGroupControlUtils.getGroupControlFitler(new PatiVisitDO(), "EN") + " ");
		if(qryModDTO.getDt_b() != null){
			sb.append("AND EN.DT_ENTRY >= ? ");
			param.addParam(qryModDTO.getDt_b());
		}
		if(qryModDTO.getDt_e()!=null){
			sb.append("AND EN.DT_ENTRY < ? ");
			param.addParam(qryModDTO.getDt_e().getDateAfter(1));
		}
		// 输入不为空
		if (!EnValidator.isEmpty(qryModDTO.getValue_pat())) {
			if (KEY_CODE_ENT.equals(qryModDTO.getKey_pat())) {
				sb.append("AND EN.CODE = ? ");
				param.addParam(qryModDTO.getValue_pat());
			} else {
				sb.append("AND PI.CODE IN (");
				sb.append("SELECT DISTINCT PAT.CODE FROM PI_PAT PAT LEFT JOIN PI_PAT_CARD CARD ON PAT.ID_PAT = CARD.ID_PAT ");
				sb.append("WHERE 1 = 1 ");
				if (KEY_NAME.equals(qryModDTO.getKey_pat())) {
					// 选择患者姓名
					sb.append("AND (PAT.NAME =? ");
					param.addParam(qryModDTO.getValue_pat());
					sb.append("OR PAT.PYCODE =  ?) ");
					param.addParam(qryModDTO.getValue_pat().toUpperCase()+".");
				} else if (KEY_CODE.equals(qryModDTO.getKey_pat())) {
					// 选择患者编号
					sb.append("AND PAT.CODE = ? ");
					param.addParam(qryModDTO.getValue_pat());
				} else if (KEY_CODE_CHIS.equals(qryModDTO.getKey_pat())) {
					// 选择条码号
					sb.append("AND PAT.BARCODE_CHIS = ? ");
					param.addParam(qryModDTO.getValue_pat());
				} else if (KEY_ID_CODE.equals(qryModDTO.getKey_pat())) {
					// 选择条码号
					sb.append("AND PAT.ID_CODE = ? ");
					param.addParam(qryModDTO.getValue_pat());
				} else {
					sb.append("AND CARD.ID_PATCARDTP = ? AND CARD.CODE = ? ");
					param.addParam(qryModDTO.getKey_pat());
					param.addParam(qryModDTO.getValue_pat());
				}
				sb.append(") ");
			}
		}
		sb.append("ORDER BY EN.DT_ACPT  DESC ");
	}
}
