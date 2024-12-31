package iih.sfda.adsa.yearsstatistics.bp;

import iih.sfda.adsa.yearsstatistics.GetConstant;
import iih.sfda.adsa.yearsstatistics.dto.MonthDTO;

public class GetCountBp {
	public void getCountAll(MonthDTO monthDto){
		if(monthDto.getCount()==null){
			monthDto.setCount(1);
		}else{
			monthDto.setCount(monthDto.getCount()+1);
		}
	}
	public void getCountOne(MonthDTO monthDto){
		if(monthDto.getCountOne()==null){
			monthDto.setCountOne(1);
		}else{
			monthDto.setCountOne(monthDto.getCountOne()+1);
		}
	}
	public void getCountTwo(MonthDTO monthDto){
		if(monthDto.getCountTwo()==null){
			monthDto.setCountTwo(1);
		}else{
			monthDto.setCountTwo(monthDto.getCountTwo()+1);
		}
	}
	public void getCountThree(MonthDTO monthDto){
		if(monthDto.getCountThree()==null){
			monthDto.setCountThree(1);
		}else{
			monthDto.setCountThree(monthDto.getCountThree()+1);
		}
	}
	public void getCountFour(MonthDTO monthDto){
		if(monthDto.getCountFour()==null){
			monthDto.setCountFour(1);
		}else{
			monthDto.setCountFour(monthDto.getCountFour()+1);
		}
	}
	public void getCountFive(MonthDTO monthDto){
		if(monthDto.getCountFive()==null){
			monthDto.setCountFive(1);
		}else{
			monthDto.setCountFive(monthDto.getCountFive()+1);
		}
	}
	public void getCountSix(MonthDTO monthDto){
		if(monthDto.getCountSix()==null){
			monthDto.setCountSix(1);
		}else{
			monthDto.setCountSix(monthDto.getCountSix()+1);
		}
	}
	public void getCountSeven(MonthDTO monthDto){
		if(monthDto.getCountSeven()==null){
			monthDto.setCountSeven(1);
		}else{
			monthDto.setCountSeven(monthDto.getCountSeven()+1);
		}
	}
	public void getCountEight(MonthDTO monthDto){
		if(monthDto.getCountEight()==null){
			monthDto.setCountEight(1);
		}else{
			monthDto.setCountEight(monthDto.getCountEight()+1);
		}
	}
	public void getCountNine(MonthDTO monthDto){
		if(monthDto.getCountNine()==null){
			monthDto.setCountNine(1);
		}else{
			monthDto.setCountNine(monthDto.getCountNine()+1);
		}
	}
	public void getCountTen(MonthDTO monthDto){
		if(monthDto.getCountTen()==null){
			monthDto.setCountTen(1);
		}else{
			monthDto.setCountTen(monthDto.getCountTen()+1);
		}
	}
	public void getCountEleven(MonthDTO monthDto){
		if(monthDto.getCountEleven()==null){
			monthDto.setCountEleven(1);
		}else{
			monthDto.setCountEleven(monthDto.getCountEleven()+1);
		}
	}
	
	public void getCountTwelve(MonthDTO monthDto){
		if(monthDto.getCountTwelve()==null){
			monthDto.setCountTwelve(1);
		}else{
			monthDto.setCountTwelve(monthDto.getCountTwelve()+1);
		}
	}
	
	public void getCountQuartOne(MonthDTO monthDto){
		monthDto.setQuarter(GetConstant.getStrQuarter()[0]);
		if(monthDto.getCountQuartOne()==null){
			monthDto.setCountQuartOne(1);
		}else{
			monthDto.setCountQuartOne(monthDto.getCountQuartOne()+1);
		}
	}
	public void getCountQuartFour(MonthDTO monthDto){
		monthDto.setQuarter(GetConstant.getStrQuarter()[3]);
		if(monthDto.getCountQuartFour()==null){
			monthDto.setCountQuartFour(1);
		}else{
			monthDto.setCountQuartFour(monthDto.getCountQuartFour()+1);
		}
	}
	public void getCountQuartTwo(MonthDTO monthDto){
		monthDto.setQuarter(GetConstant.getStrQuarter()[1]);
		if(monthDto.getCountQuartTwo()==null){
			monthDto.setCountQuartTwo(1);
		}else{
			monthDto.setCountQuartTwo(monthDto.getCountQuartTwo()+1);
		}
	}
	public void getCountQuartThree(MonthDTO monthDto){
		monthDto.setQuarter(GetConstant.getStrQuarter()[2]);
		if(monthDto.getCountQuartThree()==null){
			monthDto.setCountQuartThree(1);
		}else{
			monthDto.setCountQuartThree(monthDto.getCountQuartThree()+1);
		}
	}
}
