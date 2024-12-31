package iih.nm.nqm.aer;

import java.util.List;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * @author 作者 :huang_junhao
 * @version 创建时间：2017年6月7日 下午5:11:29 
 * 类说明： 
 * Company: Copyright 2017 by PKU healthcare IT Co.,Ltd.
 */
public class NmAerDTOServiceImpl {

	public NmAerDTO[] fillBeanInfo(String idaer) throws Exception {

		// 1.获取主DO数据
		NmAerDTO nmAerDTO = getAerDTO(idaer);

		// 2.获取子DO数据
		List<NmAerCaDTO> caDTOs = getCaDto(idaer);

		// 3.把子do的编码字段按逗号分隔拼接起来
		setCaInfo(nmAerDTO,caDTOs);
		
		return new NmAerDTO[]{nmAerDTO};
	}

	/**
	 * 获取主DO数据
	 * 
	 * @param idaer
	 * @return
	 * @throws Exception
	 */
	private NmAerDTO getAerDTO(String idaer) throws Exception {

		StringBuilder str_buf = new StringBuilder();

		str_buf.append(" select");
		str_buf.append(" psn.name as name_emp_rpt, ");
		str_buf.append(" dep.name as name_dep_rpt, ");
		str_buf.append(" aer.dt_occur, ");
		str_buf.append(" aer.dt_rpt, ");
		str_buf.append(" aer.evt_info, ");
		str_buf.append(" aer.problem, ");
		str_buf.append(" aer.advice ");
		str_buf.append(" from nm_aer aer ");
		str_buf.append(" left join bd_psndoc psn on psn.id_psndoc=aer.id_emp_rpt ");
		str_buf.append(" left join bd_dep dep on dep.id_dep = aer.id_dep_rpt ");
		str_buf.append(" WHERE aer.id_aer='" + idaer + "'");

		String str_sql = str_buf.toString().trim();
		str_buf.setLength(0);
		str_buf.trimToSize();

		// 执行sql查询数据记录(SqlReader中自带宏定义的替换功能)
		SqlReader sql_rdr = new SqlReader(null, str_sql);
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();

		// 转换成对应 DTO 对象
		BeanHandler beanlist_handler = new BeanHandler(NmAerDTO.class);
		NmAerDTO bean_info = (NmAerDTO) beanlist_handler.processRs(cached_rs);

		sql_rdr.destroy();
		if (bean_info == null) {
			return new NmAerDTO();
		}
		return bean_info;
	}

	/**
	 * 查询事件分类
	 * 
	 * @param idaer
	 * @return
	 * @throws Exception
	 */
	private List<NmAerCaDTO> getCaDto(String idaer) throws Exception {
		StringBuilder str_buf = new StringBuilder();

		str_buf.append(" select");
		str_buf.append(" sd_evt_ca, ");
		str_buf.append(" evt_ca_name_other as name_other ");
		str_buf.append(" from nm_aer_ca  ");
		str_buf.append(" WHERE id_aer='" + idaer + "'");

		String str_sql = str_buf.toString().trim();
		str_buf.setLength(0);
		str_buf.trimToSize();

		// 执行sql查询数据记录(SqlReader中自带宏定义的替换功能)
		SqlReader sql_rdr = new SqlReader(null, str_sql);
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();

		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(NmAerCaDTO.class);
		@SuppressWarnings("unchecked")
		List<NmAerCaDTO> bean_info = (List<NmAerCaDTO>) beanlist_handler.processRs(cached_rs);

		sql_rdr.destroy();
		if (bean_info == null || bean_info.size() < 0) {
			return null;
		}
		return bean_info;
	}

	/**
	 * 设置事件分类字段
	 * 
	 * @param mDo
	 * @param aerCaDOs
	 */
	private void setCaInfo(NmAerDTO mDo, List<NmAerCaDTO> aerCaDOs) {

		String sd_evt_cas = "";
		String name_other = "";
		if (aerCaDOs != null && aerCaDOs.size() > 0) {
			for (NmAerCaDTO aerCaDO : aerCaDOs) {
				if (!StringUtil.isEmptyWithTrim(aerCaDO.getSd_evt_ca())) {

					sd_evt_cas += (sd_evt_cas.length() == 0 ? "" : ",") + aerCaDO.getSd_evt_ca();
				} else {
					name_other = aerCaDO.getName_other();
				}
			}
		}
		mDo.setSd_evt_ca(sd_evt_cas);
		mDo.setName_other(name_other);
	}
}
