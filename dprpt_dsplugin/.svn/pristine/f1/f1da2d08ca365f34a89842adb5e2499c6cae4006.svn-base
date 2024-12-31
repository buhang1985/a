package iih.sfda.adsa.yearsstatistics.bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import iih.sfda.adsa.yearsstatistics.GetConstant;
import iih.sfda.adsa.yearsstatistics.dto.MonthDTO;
import iih.sfda.adsa.yearsstatistics.dto.YearsDTO;
import iih.sfda.adsa.yearsstatistics.dto.YearsStatisticsDTO;
import iih.sfda.adsa.yearsstatistics.qry.GetDataTypeSql;
import iih.sfda.adsa.yearsstatistics.qry.GetEventLevelSql;
import iih.sfda.adsa.yearsstatistics.qry.GetEventTypeSql;
import iih.sfda.adsa.yearsstatistics.qry.GetHurtSeveritySql;
import iih.sfda.adsa.yearsstatistics.qry.GetInvolvePatSql;
import iih.sfda.adsa.yearsstatistics.qry.GetOccurAdrSql;
import iih.sfda.adsa.yearsstatistics.qry.GetReportDepSql;
import iih.sfda.adsa.yearsstatistics.qry.GetSeeDoctorSql;
import iih.sfda.adsa.yearsstatistics.qry.GetOccurDepSql;
import iih.sfda.adsa.yearsstatistics.qry.GetPatSexSql;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class StatisticBp {
	// 返回月份
	@SuppressWarnings("unused")
	public List<YearsDTO> GetReturnListMonth(YearsStatisticsDTO[] reList) {
		List<YearsDTO> returnList = new ArrayList<YearsDTO>();
		List<MonthDTO> returnQuart = GetReturnMonth(reList);
		if(returnQuart==null || returnQuart.size()<1)return returnList;
		YearsDTO month = null;
		String[] strMonth = GetConstant.getStrMonth();
		for (int j = 0; j < strMonth.length; j++) {
			month = new YearsDTO();
			month.setName(returnQuart.get(0).getName());
			month.setMonth(strMonth[j]);
			returnList.add(month);
		}
		for (int i = 0; i < returnQuart.size(); i++) {
			String name = returnQuart.get(i).getName();
			if (month == null || month.getName() == null || !name.equals(month.getName())) {
				month = new YearsDTO();
				month.setName(returnQuart.get(i).getName());
				month.setMonth(GetConstant.getStrMonth()[0]);
				returnList.add(month);
			}
			List<Integer> monthList =new ArrayList<Integer>();
			Integer countOne = returnQuart.get(i).getCountOne();
			Integer countTwo = returnQuart.get(i).getCountTwo();
			Integer countThree = returnQuart.get(i).getCountThree();
			Integer countFour = returnQuart.get(i).getCountFour();
			Integer countFive = returnQuart.get(i).getCountFive();
			Integer countSix = returnQuart.get(i).getCountSix();
			Integer countSeven = returnQuart.get(i).getCountSeven();
			Integer countEight = returnQuart.get(i).getCountEight();
			Integer countNine = returnQuart.get(i).getCountNine();
			Integer countTen = returnQuart.get(i).getCountTen();
			Integer countEleven = returnQuart.get(i).getCountEleven();
			Integer countTwelve = returnQuart.get(i).getCountTwelve();
			monthList.add(countOne);
			monthList.add(countTwo);
			monthList.add(countThree);
			monthList.add(countFour);
			monthList.add(countFive);
			monthList.add(countSix);
			monthList.add(countSeven);
			monthList.add(countEight);
			monthList.add(countNine);
			monthList.add(countTen);
			monthList.add(countEleven);
			monthList.add(countTwelve);
			if (month != null && name.equals(month.getName())) {
				for(int m=0;m<monthList.size();m++){
					if (monthList.get(m) != null) {
						month = new YearsDTO();
						month.setName(returnQuart.get(i).getName());
						month.setCount(monthList.get(m));
						month.setMonth(GetConstant.getStrMonth()[m]);
						returnList.add(month);
					}
				}
			}
		}
		return returnList;
	}

	// 返回季度
	@SuppressWarnings("unused")
	public List<YearsDTO> GetReturnListQuart(YearsStatisticsDTO[] reList) {
		List<YearsDTO> returnList = new ArrayList<YearsDTO>();
		List<MonthDTO> returnQuart = GetReturnQuart(reList);
		if(returnQuart==null || returnQuart.size()<1)return returnList;
		YearsDTO quarter = null;
		String[] strQuarter = GetConstant.getStrQuarter();
		for (int j = 0; j < strQuarter.length; j++) {
			quarter = new YearsDTO();
			quarter.setName(returnQuart.get(0).getName());
			quarter.setQuarter(strQuarter[j]);
			returnList.add(quarter);
		}
		for (int i = 0; i < returnQuart.size(); i++) {
			String name = returnQuart.get(i).getName();
			if (quarter == null || quarter.getName() == null || !name.equals(quarter.getName())) {
				quarter = new YearsDTO();
				quarter.setName(returnQuart.get(i).getName());
				quarter.setQuarter(GetConstant.getStrQuarter()[0]);
				returnList.add(quarter);
			}
			Integer countQuartOne = returnQuart.get(i).getCountQuartOne();
			Integer countQuartTwo = returnQuart.get(i).getCountQuartTwo();
			Integer countQuartThree = returnQuart.get(i).getCountQuartThree();
			Integer countQuartFour = returnQuart.get(i).getCountQuartFour();
			List<Integer> quarterList =new ArrayList<Integer>();
			quarterList.add(countQuartOne);
			quarterList.add(countQuartTwo);
			quarterList.add(countQuartThree);
			quarterList.add(countQuartFour);
			if (quarter != null && name.equals(quarter.getName())) {
				for(int j=0;j<quarterList.size();j++){
					if (quarterList.get(j) != null) {
						quarter = new YearsDTO();
						quarter.setName(returnQuart.get(i).getName());
						quarter.setCount(quarterList.get(j));
						quarter.setQuarter(GetConstant.getStrQuarter()[j]);
						returnList.add(quarter);
					}
				}
			}
		}
		return returnList;
	}

	// 返回月份
	private List<MonthDTO> GetReturnMonth(YearsStatisticsDTO[] reList) {
		List<MonthDTO> returnList = new ArrayList<MonthDTO>();
		if (reList == null || reList.length < 1)
			return null;
		MonthDTO monthDto = null;
		for (int i = 0; i < reList.length; i++) {
			String name = reList[i].getName();
			if (monthDto == null || monthDto.getName() == null || !name.equals(monthDto.getName())) {
				monthDto = new MonthDTO();
				monthDto.setName(reList[i].getName());
				returnList.add(monthDto);
			}
			if (monthDto != null && name.equals(monthDto.getName())) {
				String date = reList[i].getDateTime();
				if (date != null) {
					String[] split = date.split("-");

					GetCountBp getCount = new GetCountBp();
					switch (split[1]) {
					case "01":
						getCount.getCountOne(monthDto);
						getCount.getCountAll(monthDto);
						break;
					case "02":
						getCount.getCountTwo(monthDto);
						getCount.getCountAll(monthDto);
						break;
					case "03":
						getCount.getCountThree(monthDto);
						getCount.getCountAll(monthDto);
						break;
					case "04":
						getCount.getCountFour(monthDto);
						getCount.getCountAll(monthDto);
						break;
					case "05":
						getCount.getCountFive(monthDto);
						break;
					case "06":
						getCount.getCountSix(monthDto);
						getCount.getCountAll(monthDto);
						break;
					case "07":
						getCount.getCountSeven(monthDto);
						getCount.getCountAll(monthDto);
						break;
					case "08":
						getCount.getCountEight(monthDto);
						getCount.getCountAll(monthDto);
						break;
					case "09":
						getCount.getCountNine(monthDto);
						getCount.getCountAll(monthDto);
						break;
					case "10":
						getCount.getCountTen(monthDto);
						getCount.getCountAll(monthDto);
						break;
					case "11":
						getCount.getCountEleven(monthDto);
						getCount.getCountAll(monthDto);
						break;
					case "12":
						getCount.getCountTwelve(monthDto);
						getCount.getCountAll(monthDto);
						break;
					}
				}
			}
		}
		return returnList;
	}

	// 季度数量计算
	private List<MonthDTO> GetReturnQuart(YearsStatisticsDTO[] reList) {
		List<MonthDTO> list = new ArrayList<MonthDTO>();
		if (reList == null || reList.length < 1)
			return list;
		MonthDTO monthDto = null;
		for (int i = 0; i < reList.length; i++) {
			String name = reList[i].getName();
			if (monthDto == null || monthDto.getName() == null || !name.equals(monthDto.getName())) {
				monthDto = new MonthDTO();
				monthDto.setName(reList[i].getName());
				list.add(monthDto);
			}
			if (monthDto != null && name.equals(monthDto.getName())) {
				String date = reList[i].getDateTime();
				if (date != null) {
					String[] split = date.split("-");

					GetCountBp getCount = new GetCountBp();
					if (Arrays.asList(GetConstant.getQuartOne()).contains(split[1])) {
						getCount.getCountQuartOne(monthDto);
						getCount.getCountAll(monthDto);
					} else if (Arrays.asList(GetConstant.getQuartTwo()).contains(split[1])) {
						getCount.getCountQuartTwo(monthDto);
						getCount.getCountAll(monthDto);
					} else if (Arrays.asList(GetConstant.getQuartThree()).contains(split[1])) {
						getCount.getCountQuartThree(monthDto);
						getCount.getCountAll(monthDto);
					} else if (Arrays.asList(GetConstant.getQuartFour()).contains(split[1])) {
						getCount.getCountQuartFour(monthDto);
						getCount.getCountAll(monthDto);
					}
				}
			}
		}
		return list;
	}
}
