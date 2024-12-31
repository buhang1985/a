package iih.ci.ord.printmanage.srv.ord;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.handler.BeanListHandler;

import com.sun.rowset.CachedRowSetImpl;

import iih.ci.ord.printmanage.dto.SampCardPrintDTO;

/**
 * 床头卡\杯卡打印模板DTO查询服务
 * 
 * @author zhengcm
 * @date 2016-07-14 16:22:45
 *
 */

public class SampCardPrintService {

	/**
	 * 标本卡打印报表查询服务
	 * 
	 * @author yzh
	 * @param ident 就诊ID
	 * @param sampdata 前台传入的标本数据格式为A,B,C|A1,B1,C1 以|分条,以,分割单条数据
	 * @return
	 * @throws Exception
	 */
	public SampCardPrintDTO[] query(String ident,String sampdata) throws Exception {
		if ("".equals(ident)||ident== null) return new SampCardPrintDTO[] {};
		StringBuilder sql = new StringBuilder();
		sql.append("select P.name as pat_name, P.barcode_chis, B1.name as pat_sex, P.dt_birth ");
		sql.append("from pi_pat P ");
		sql.append("left outer join en_ent E on P.id_pat = E.id_pat ");
		sql.append("left outer join bd_udidoc B1 on P.Id_Sex=B1.id_udidoc ");
		sql.append("where E.id_ent ='"+ident+"'");
		

		// 执行查询
		List<SampCardPrintDTO> datas = this.getResultBySql(sql.toString());


		// 计算患者年龄
		this.calcPatAge(datas);

		if (ListUtil.isEmpty(datas)) {
			return null;
		}
		List<SampCardPrintDTO> result = new ArrayList<SampCardPrintDTO>();
		if (sampdata != null && !sampdata.equals("")) {
			result = dataHandle(datas, sampdata);
		}
		return result.toArray(new SampCardPrintDTO[] {});
	}
	private List<SampCardPrintDTO> dataHandle(List<SampCardPrintDTO> list,String data){
		List<SampCardPrintDTO> result = new ArrayList<SampCardPrintDTO>();
		SampCardPrintDTO dto = list.get(0);
		String[] dataItem = data.split("\\|");
		for (String item : dataItem) {
			SampCardPrintDTO obj = new SampCardPrintDTO();
			obj.setBarcode_chis(dto.getBarcode_chis());
			obj.setPat_age(dto.getPat_age());
			obj.setPat_sex(dto.getPat_sex());
			obj.setPat_name(dto.getPat_name());
			String[] dataItemStr = item.split(",");
			if(dataItemStr.length == 4){
				obj.setSamp_no("标本"+dataItemStr[0]+": "+dataItemStr[2]+"+"+dataItemStr[3]+" "+dataItemStr[1]+"块");
			}
			result.add(obj);
		}
		return result;
	}
	
	/**
	 * 执行报表数据SQL查询
	 * 
	 * @author yzh
	 * @param strSql SQL语句
	 * @return 标本打印报表数据DTO列表
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private List<SampCardPrintDTO> getResultBySql(String strSql) throws Exception {
		SqlReader sql_rdr = new SqlReader(null, strSql);
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(SampCardPrintDTO.class);
		List<SampCardPrintDTO> result = (List<SampCardPrintDTO>) beanlist_handler
				.processRs(cached_rs);
		sql_rdr.destroy();
		return result;
	}

	/**
	 * 计算患者年龄
	 * 
	 * @author 
	 * @param datas 打印报表数据DTO
	 * @throws Exception
	 */
	private void calcPatAge(List<SampCardPrintDTO> datas) throws Exception {
		if (ListUtil.isEmpty(datas)) {
			return;
		}
		for (SampCardPrintDTO dto : datas) {
			if (StringUtil.isEmptyWithTrim(dto.getDt_birth())) {
				continue;
			}
			dto.setPat_age(this.getAge(new FDate(dto.getDt_birth())));
		}
	}

	/**
	 * 计算年龄（因为无法调用公共的方法，为了显示统一，直接拷贝了工具类AgeCalcUtil的方法）
	 * 
	 * @author zhengcm
	 * @param birth 生日
	 * @return
	 */
	private String getAge(FDate birth) {
		if (birth == null) {
			return "不详";
		}
		birth = birth.asBegin();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = df.format(new Date());// 获取当前系统时间
		FDateTime curTime = new FDateTime(now);
		FDate curDate = curTime.getDate().asBegin();
		if (birth.after(curDate)) {
			return "不详";
		}

		int Months = curDate.getLocalMonth() - birth.getLocalMonth() + 12
				* (curDate.getLocalYear() - birth.getLocalYear());
		Calendar cal = Calendar.getInstance();
		cal.setTime(birth.toDate());
		cal.add(2, Months);

		int totalMonth = new FDate(cal.getTime()).after(curDate) ? Months - 1 : Months;

		int fullYear = totalMonth / 12;

		int fullMonth = totalMonth % 12;

		cal.setTime(birth.toDate());
		cal.add(2, totalMonth);
		FDate changeDate = new FDate(cal.getTime());
		int days = FDate.getDaysBetween(changeDate, curDate);
		if (fullYear >= 5) {
			return String.format("%d岁", new Object[] { Integer.valueOf(fullYear) });
		}
		if ((fullYear < 5) && (fullYear >= 1)) {
			if (fullMonth <= 0) {
				return String.format("%d岁", new Object[] { Integer.valueOf(fullYear) });
			}
			return String.format("%d岁%d月",
					new Object[] { Integer.valueOf(fullYear), Integer.valueOf(fullMonth) });
		}

		if ((fullMonth >= 1) && (fullYear <= 1)) {
			if (days <= 0) {
				return String.format("%d月", new Object[] { Integer.valueOf(fullMonth) });
			}
			return String.format("%d月%d天",
					new Object[] { Integer.valueOf(fullMonth), Integer.valueOf(days) });
		}
		if (days <= 0) {
			return String.format("%d天", new Object[] { Integer.valueOf(1) });
		}
		return String.format("%d天", new Object[] { Integer.valueOf(days) });
	}


}
