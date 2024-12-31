package iih.en.pv.s.bp.ip.qry;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.comm.util.EnAgeCalcUtil;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.dto.d.IpRegInfoDTO;
import iih.en.pv.inpatient.dto.d.IpRegQrySchmDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 住院诊断查询
 * @author zhangpp
 *
 */
public class GetIpDiQryListBP {

	/**
	 * 查询住院患者信息
	 * @param qrySchm
	 * @param pageInfo
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PagingRtnData<IpRegInfoDTO> exec(IpRegQrySchmDTO qrySchm, PaginationInfo pageInfo) throws BizException{
		PagingRtnData<IpRegInfoDTO> datas = new PagingRtnData<IpRegInfoDTO>();
		PagingServiceImpl<IpRegInfoDTO> service =new PagingServiceImpl();
		SqlParam param = new SqlParam();
		//获取sql
		String sql = getQrySql(qrySchm,param);
		
		datas = service.findByPageInfo(new IpRegInfoDTO(), pageInfo, sql, "", param);
		//批量查询年龄
		this.getAge(datas);
		
		return datas;
	}
	/**
	 * 根据查询条件组装sql
	 * @param qrySchm
	 * @param param
	 * @return
	 */
	private String getQrySql(IpRegQrySchmDTO qrySchm,SqlParam param){
		
		StringBuffer str = new StringBuffer();
		str.append(" select ent.id_ent, ent.dt_entry, ");
		str.append(" ent.dt_end, ");
		str.append(" ip.code_amr_ip, ");
		str.append(" pat.name as name_pat, ");
		str.append(" sex.name as name_sex, ");
		str.append(" pat.dt_birth, ");
		str.append(" idtp.name as name_idtp, ");
		str.append(" pat.id_code as id_code, ");
		str.append(" pat.mob as telno_pat, ");
		str.append(" itm.id_didef_name as name_didef_dis, ");
		str.append(" dep.name as name_dep_phy, ");
		str.append(" psn.name as name_emp_dire, ");
		str.append(" area.fullname || addr.street as addar ");
		str.append(" from en_ent ent ");
		str.append(" inner join en_ent_ip ip on ip.id_ent = ent.id_ent ");
		str.append(" inner join pi_pat pat on pat.id_pat = ent.id_pat ");
		str.append(" left join bd_udidoc sex on sex.id_udidoc = pat.id_sex ");
		str.append(" left join bd_udidoc idtp on idtp.id_udidoc = pat.id_idtp ");
		str.append(" left join bd_dep dep on dep.id_dep = ent.id_dep_phy ");
		str.append(" left join bd_psndoc psn on psn.id_psndoc = ent.id_emp_phy ");
		str.append(" left join pi_pat_addr addr on addr.id_pat = pat.id_pat and addr.sd_addrtp = ? ");
		param.addParam(IPiDictCodeConst.SD_ADDR_TYPE_NOW);
		str.append(" left join bd_adminarea area on area.id_adminarea = addr.id_admdiv ");
		str.append(" left join (select c.id_di, c.id_en,  row_number() over(partition by c.id_en order by c.dt_sign desc) rn ");
		str.append(" from ci_di c) di on ent.id_ent = di.id_en and di.rn = 1 ");
		str.append(" left join ci_di_itm itm on di.id_di = itm.id_di and itm.fg_majdi = 'Y' ");
		str.append(" where ent.fg_canc = 'N'  and ip.sd_status <> ? ");
		param.addParam(ICiDictCodeConst.SD_STATUS);
		//查询开始日期
		if(qrySchm.getD_begin() != null){
			str.append(" AND ENT.DT_ACPT >= ? " );
			param.addParam(qrySchm.getD_begin());
		}
		//查询结束日期
		if(qrySchm.getD_end() != null){
			str.append(" AND ENT.DT_ACPT <= ? " );
			param.addParam(qrySchm.getD_end());
		}
		//科室
		if(!EnValidator.isEmpty(qrySchm.getId_dep_phy())){
			str.append(" AND ent.id_dep_phy = ? " );
			param.addParam(qrySchm.getId_dep_phy());
		}
		//住院号
		if(!EnValidator.isEmpty(qrySchm.getCode_amr_ip())){
			str.append(" AND IP.CODE_AMR_IP = ? " );
			param.addParam(qrySchm.getCode_amr_ip());
		}
		//患者姓名
		if(!EnValidator.isEmpty(qrySchm.getName_pat())){
			str.append(" AND PAT.NAME LIKE ? " );
			param.addParam("%"+qrySchm.getName_pat()+"%");
		}			
		//诊断
		if (!EnValidator.isEmpty(qrySchm.getId_di())) {
			//诊断参数处理
			str.append(EnSqlUtils.getInSqlByIds(" AND ITM.ID_DIDEF ", qrySchm.getId_di().split(",")));
		}
		return str.toString();
	}

	/**
	 * 查找年龄
	 * @param pageBedDTO
	 * @throws BizException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void getAge( PagingRtnData datas ) throws BizException{
		FArrayList list = datas.getPageData();
		if(EnValidator.isEmpty(list))
			return;
		/*for(Object obj: list){
			IpRegInfoDTO regdto = (IpRegInfoDTO) obj;
			//regdto.setAge(AgeCalcUtil.getAge(regdto.getDt_birth()));
		}*/
		EnAgeCalcUtil.setDoAges((IpRegInfoDTO[])list.toArray(new IpRegInfoDTO[]{}), "Id_ent", "Age");
	}
}
