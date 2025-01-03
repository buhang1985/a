package iih.ei.std.s.v1.bp.en;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.ArrayListUtil;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;
import iih.ei.std.d.v1.en.getpatinfobydi.d.GetPatInfoByDiParamDTO;
import iih.ei.std.d.v1.en.getpatinfobydi.d.GetPatInfoByDiResultDTO;
import iih.ei.std.d.v1.en.getpatinfobydi.d.PatInfo;
import iih.ei.std.d.v1.utils.EiValidator;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 通过诊断编码获取患者信息
 * 
 * @author fanlq
 * @date: 2020年3月29日 下午2:56:57
 */
public class GetPatInfoByDiBP extends IIHServiceBaseBP<GetPatInfoByDiParamDTO, GetPatInfoByDiResultDTO>{

	//就诊类型-住院
	private String CODE_ENTP_IP = "10";
	//就诊类型-门诊
	private String CODE_ENTP_OP = "00";
	
	/***
	 * 必填项校验
	 */
	@Override
	protected void checkParam(GetPatInfoByDiParamDTO param) throws BizException {
		if(EiValidator.isEmpty(param.getCode_entp())){
			throw new BizException("就诊类型不能为空！00-门诊;10-住院");
		}
		if(EiValidator.isEmpty(param.getDt_b_di())){
			throw new BizException("诊断开始时间不能为空！");
		}
		if(EiValidator.isEmpty(param.getDt_e_di())){
			throw new BizException("诊断结束时间不能为空！");
		}
		if (EiValidator.isEmpty(param.getPageinfo())) {
			throw new BizException("未传入分页信息！");
		}
	}

	@Override
	protected GetPatInfoByDiResultDTO process(GetPatInfoByDiParamDTO param) throws BizException {
		GetPatInfoByDiResultDTO resultDto = new GetPatInfoByDiResultDTO();
		List<PatInfo> patInfoList = new ArrayList<PatInfo>();
		SqlParam sqlParam = new SqlParam();
		String sql = getSql(param,sqlParam);
		//执行sql语句，分页
		PageInfoDTO pageInfoDto = (PageInfoDTO) param.getPageinfo();
		patInfoList = findPagingData(pageInfoDto, sql, sqlParam, PatInfo.class);
		if(ListUtil.isEmpty(patInfoList)){
			return resultDto;
		}
		//返回值设置分页信息
		resultDto.setPageinfo(pageInfoDto);
		//返回值设置患者信息
		resultDto.setPatinfo(ArrayListUtil.ConvertToFArrayList(patInfoList));
		return resultDto;
	}

	private String getSql(GetPatInfoByDiParamDTO param,SqlParam sqlParam){
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT PAT.ID_PAT, ");
		sql.append(" PAT.CODE AS CODE_PAT, ");
		sql.append(" PAT.NAME AS NAME_PAT, ");
		sql.append(" PAT.SD_SEX, ");
		sql.append(" PAT.SD_MARRY, ");
		sql.append(" PAT.ID_NATION, ");
		sql.append(" PAT.SD_NATION, ");
		sql.append(" PAT.ID_IDTP AS ID_TYPE, ");
		sql.append(" PAT.ID_CODE AS CODE_ID, ");
		sql.append(" PAT.DT_BIRTH, ");
		sql.append(" PAT.MOB, ");
		sql.append(" PAT.WORKUNIT, ");
		sql.append(" PAT.ID_OCCU, ");
		sql.append(" PAT.ID_EDUC, ");
		sql.append(" ENT.ID_ENT AS ID_ENT, ");
		sql.append(" ENT.CODE_ENTP AS CODE_ENTP, ");
		sql.append(" ENT.CODE AS CODE_ENT, ");
		sql.append(" ENT.DT_ACPT AS DT_ACPT, " );
		sql.append(" ENT.DT_END AS DT_DNT, ");
		if (CODE_ENTP_OP.equals(param.getCode_entp())) {
			sql.append(" op.times_op as times_ent, ");
		}else if (CODE_ENTP_IP.equals(param.getCode_entp())) {
			sql.append(" ip.times_ip as times_ent, ");
			sql.append(" IP.CODE_AMR_IP AS CODE_AMR_IP, ");
		}
		sql.append(" ENTDI.CODE_DIDEF_DIS AS CODE_DIDEF_DIS, ");
		sql.append(" ENTDI.NAME_DIDEF_DIS AS NAME_DIDEF_DIS, ");
		sql.append(" DEP.CODE AS CODE_DEP_DIAG, ");
		sql.append(" DEP.NAME AS NAME_DEP_DIAG, ");
		sql.append(" psn.code as code_psn_diag, ");
		sql.append(" psn.name as name_psn_diag, ");
		sql.append(" ENTDI.DT_DIAG AS DT_DI, ");
		sql.append(" ENTDI.FG_MAJ AS FG_MAJ ");
		sql.append(" FROM EN_ENT_DI ENTDI ");
		sql.append(" INNER JOIN EN_ENT ENT ON ENT.ID_ENT = ENTDI.ID_ENT ");
		sql.append(" INNER JOIN PI_PAT PAT ON PAT.ID_PAT = ENT.ID_PAT ");
		sql.append(" LEFT JOIN BD_PSNDOC PSN ON PSN.ID_PSNDOC = ENTDI.ID_EMP_PHY ");
		sql.append(" LEFT JOIN BD_DEP DEP ON DEP.ID_DEP = ENTDI.ID_DEP ");
		sql.append(" LEFT JOIN EN_ENT_OP OP ON OP.ID_ENT = ENT.ID_ENT ");
		sql.append(" LEFT JOIN EN_ENT_IP IP ON IP.ID_ENT = ENT.ID_ENT ");
		sql.append(" WHERE ENTDI.DT_DIAG >= ? ");
		sql.append(" AND ENTDI.DT_DIAG <= ? ");
		sql.append(" AND ENT.CODE_ENTP = ? ");
		sqlParam.addParam(param.getDt_b_di() + " 00:00:00 ");
		sqlParam.addParam(param.getDt_e_di() + " 23:59:59 ");
		sqlParam.addParam(param.getCode_entp());
		//诊断编码
		if (!EiValidator.isEmpty(param.getCode_di())) {
			sql.append(" AND ENTDI.CODE_DIDEF_DIS = ? ");
			sqlParam.addParam(param.getCode_di());
		}
		//诊断医生编码
		if(!EiValidator.isEmpty(param.getCode_psn())){
			sql.append(" AND PSN.CODE = ? ");
			sqlParam.addParam(param.getCode_psn());
		}
		//诊断部门编码
		if(!EiValidator.isEmpty(param.getCode_dep())){
			sql.append(" AND DEP.CODE = ? ");
			sqlParam.addParam(param.getCode_dep());
		}
		//患者编码
		if(!EiValidator.isEmpty(param.getCode_pat())){
			sql.append(" AND PAT.CODE = ? ");
			sqlParam.addParam(param.getCode_pat());
		}
		//就诊次数
		if (!EiValidator.isEmpty(param.getTimes_ent())) {
			if (CODE_ENTP_OP.equals(param.getCode_entp())) {
				sql.append(" and op.times_op = ? ");
				sqlParam.addParam(param.getTimes_ent());
			}else if (CODE_ENTP_IP.equals(param.getCode_entp())) {
				sql.append(" and ip.times_ip = ? ");
				sqlParam.addParam(param.getTimes_ent());
			}
		}
		sql.append("ORDER BY ENTDI.DT_DIAG,DEP.CODE,PAT.CODE,ENT.DT_ACPT DESC ");
		return sql.toString();
	}
}
